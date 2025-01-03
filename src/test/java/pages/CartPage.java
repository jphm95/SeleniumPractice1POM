package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class CartPage extends BasePage {

    private final By checkoutButton = By.id("checkout");

    @Override
    @Step("Waiting page to load")
    public void waitPageToLoad() {
        waitPage(checkoutButton, this.getClass().getSimpleName());

    }

    @Override
    public void verifyPage() {
        Logs.info("Verifying Cart Page");
        softAssert.assertTrue(find(checkoutButton).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Clicking Checkout Button")
    public void clickCheckout() {
        Logs.info("Clicking Checkout Button");
        find(checkoutButton).click();
    }
}
