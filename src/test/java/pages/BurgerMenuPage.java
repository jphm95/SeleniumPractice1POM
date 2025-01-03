package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BasePage;
import utilities.Logs;

import java.time.Duration;

public class BurgerMenuPage extends BasePage {
    private final By logoutButton = By.id("logout_sidebar_link");
    private final By aboutbutton = By.id("about_sidebar_link");

    @Override
    @Step("Waiting visibility of burger menu")
    public void waitPageToLoad() {
        waitPage(logoutButton, this.getClass().getName());

        Logs.info("Waiting element's clickeability");
        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
    }

    @Override
    @Step("Verifying Burger Menu")
    public void verifyPage() {
        Logs.info("Verifying Burger Menu");
        softAssert.assertTrue(find(logoutButton).isDisplayed());
        softAssert.assertTrue(find(aboutbutton).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Clicking logout button")
    public void clickLogout() {
        Logs.info("Clicking logout button");
        find(logoutButton).click();
    }

    @Step("Verifying about link")
    public void verifyAboutLink(String expectedUrl) {
        final var aboutLabel = find(aboutbutton);

        Logs.info("Verifying about option");

        softAssert.assertTrue(find(aboutbutton).isDisplayed());
        softAssert.assertTrue(find(aboutbutton).isEnabled());
        softAssert.assertEquals(find(aboutbutton).getAttribute("href"), expectedUrl);
        softAssert.assertAll();


    }
}
