package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class ItemDetailPage extends BasePage {
    private final By itemName = By.className("inventory_details_name");
    private final By itemDescription = By.className("inventory_details_desc");
    private final By itemImg = By.className("inventory_details_img");
    private final By itemPrice = By.className("inventory_details_price");
    private final By backButton = By.id("back-to-products");
    private final By addToCartButton = By.xpath("//button[text()='Add to cart']");


    @Override
    @Step("Waiting page to load")
    public void waitPageToLoad() {
        waitPage(itemName, this.getClass().getName());

    }

    @Override
    @Step("Verifying Item Detail Page")
    public void verifyPage() {
        Logs.info("Verifying Item Detail Page");
        softAssert.assertTrue(find(itemName).isDisplayed());
        softAssert.assertTrue(find(itemDescription).isDisplayed());
        softAssert.assertTrue(find(itemPrice).isDisplayed());
        softAssert.assertTrue(find(itemImg).isDisplayed());
        softAssert.assertTrue(find(backButton).isDisplayed());
        softAssert.assertTrue(find(addToCartButton).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Clicking back to products button")
    public void clickBackButtonProducts() {
        Logs.info("Clicking back to products button");
        find(backButton).click();
    }


}
