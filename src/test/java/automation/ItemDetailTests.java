package automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ItemDetailPage;
import pages.ShoppingPage;
import utilities.BaseTest;

public class ItemDetailTests extends BaseTest {
    private final ShoppingPage shoppingPage = new ShoppingPage();
    private final ItemDetailPage itemDetail = new ItemDetailPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToItemDetail("Sauce Labs Fleece Jacket");
    }

    @Test(groups = {regression})
    public void verifyPageTest() {
        itemDetail.verifyPage();
    }

    @Test(groups = {regression, smoke})
    public void backToProductsTest() {
        itemDetail.clickBackButtonProducts();
        shoppingPage.waitPageToLoad();
        shoppingPage.verifyPage();
    }
}
