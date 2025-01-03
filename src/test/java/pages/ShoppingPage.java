package pages;

import io.qameta.allure.Step;
import models.ItemProduct;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.BasePage;
import utilities.Logs;

import java.util.List;

public class ShoppingPage extends BasePage {
    private final By inventoryList = By.className("inventory_list");
    private final By productsTitle = By.xpath("//span[text()='Products']");
    private final By selectItem = By.className("product_sort_container");

    private By getItemName(String itemName) {
        final var locator = String.format("//div[text()='%s']", itemName);
        return By.xpath(locator);
    }

    private By getItemPrice(String itemName) {
        return RelativeLocator
                .with(By.className("inventory_item_price"))
                .below(getItemName(itemName));
    }

    @Override
    @Step("Waiting shopping page to load")
    public void waitPageToLoad() {
        waitPage(inventoryList, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verifying shopping page")
    public void verifyPage() {
        Logs.info("Verifying shopping page");
        softAssert.assertTrue(find(inventoryList).isDisplayed());
        softAssert.assertTrue(find(productsTitle).isDisplayed());
        softAssert.assertTrue(find(selectItem).isDisplayed());
        softAssert.assertAll();
    }

    public void goToItemDetail(String itemName) {
        Logs.info("Navigating to item %s detail: ", itemName);
        find(getItemName(itemName)).click();
    }

    @Step("Verifying products price")
    public void verifyProductsPrice(List<ItemProduct> itemsList) {
        Logs.info("Verifying products price");

        for (var item : itemsList) {
            final var priceLabel = find(getItemPrice(item.getNombre()));
            final var price = Double.parseDouble(
                    priceLabel.getText().replace("$", "")
            );
            softAssert.assertEquals(
                    price,
                    item.getPrecio(),
                    String.format("Failed: %s", item.getNombre())
            );
            softAssert.assertAll();
        }

    }
}
