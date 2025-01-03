package automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BurgerMenuPage;
import pages.LoginPage;
import utilities.BaseTest;

public class BurgerMenuTests extends BaseTest {

    private final LoginPage loginPage = new LoginPage();
    private final BurgerMenuPage burgerMenu = new BurgerMenuPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.openBurgerMenu();
    }

    @Test(groups = {regression, smoke})
    public void logoutTest() {
        burgerMenu.clickLogout();
        loginPage.waitPageToLoad();
        loginPage.verifyPage();
    }

    @Test(groups = {regression})
    public void aboutLinkTest() {
        burgerMenu.verifyAboutLink("https://saucelabs.com/");
    }


}
