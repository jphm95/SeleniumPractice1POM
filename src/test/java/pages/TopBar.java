package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class TopBar extends BasePage {
    private final By tittle = By.xpath("//div[text()='Swag Labs']");
    private final By burgerMenu = By.className("bm-burger-button");
    private final By shoppingCartButton = By.id("shopping_cart_container");

    @Override
    public void waitPageToLoad() {
    }

    @Override
    @Step("Verifying top bar menu")
    public void verifyPage() {
        Logs.info("Verifying top bar menu");
        softAssert.assertTrue(find(tittle).isDisplayed());
        softAssert.assertTrue(find(burgerMenu).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Opening Burguer Menu")
    public void openBurguerMenu() {
        Logs.info("Opening Burguer Menu");
        find(burgerMenu).click();
    }

    @Step("Clicking Shopping Cart Button")
    public void clickShoppingCartButton() {
        Logs.info("Clicking Shopping Cart Button");
        find(shoppingCartButton).click();

    }
}
