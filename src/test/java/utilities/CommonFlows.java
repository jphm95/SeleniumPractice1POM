package utilities;

import data.DataGiver;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import pages.BurgerMenuPage;
import pages.CartPage;
import pages.ItemDetailPage;
import pages.LoginPage;
import pages.ShoppingPage;
import pages.TopBar;
import pages.YourInformationPage;

public class CommonFlows {
    private WebDriver getDriver() {
        return new WebDriverProvider().get();
    }

    public void assignLoginCookie() {
        Logs.info("Navigating to the url");
        getDriver().get("https://www.saucedemo.com/404");
        final var validCredentials = DataGiver.getValidCredential();
        final var loginCookie =
                new Cookie("session-username", validCredentials.getUsername());
        getDriver().manage().addCookie(loginCookie);
    }

    public void goToLoginPage() {
        Logs.info("Navigating to the url");
        getDriver().get("https://www.saucedemo.com");

        new LoginPage().waitPageToLoad();
    }

    public void goToShoppingPage() {
        assignLoginCookie();
        getDriver().get("https://www.saucedemo.com/inventory.html");
        new ShoppingPage().waitPageToLoad();
    }

    public void openBurgerMenu() {
        goToLoginPage();
        goToShoppingPage();
        new TopBar().openBurguerMenu();
        new BurgerMenuPage().waitPageToLoad();
    }

    public void goToItemDetail(String itemName) {
        goToShoppingPage();
        new ShoppingPage().goToItemDetail("Sauce Labs Fleece Jacket");
        new ItemDetailPage().waitPageToLoad();
    }

    public void goToYourCart() {
        goToShoppingPage();
        new TopBar().clickShoppingCartButton();
        new CartPage().waitPageToLoad();
    }

    public void goYourInformationPage() {
        goToYourCart();
        new CartPage().clickCheckout();
        new YourInformationPage().waitPageToLoad();
    }
}
