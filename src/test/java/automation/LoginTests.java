package automation;

import data.CustomDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.BaseTest;

public class LoginTests extends BaseTest {
    private final LoginPage loginPage = new LoginPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToLoginPage();
    }

    @Test(groups = {regression},
            dataProviderClass = CustomDataProvider.class,
            dataProvider = CustomDataProvider.DP_CREDENTIALS)
    public void credentialsTest(String username, String password, String message) {
        loginPage.fillLogin(username, password);
        loginPage.verifyErrorMessage(message);
    }

    @Test(groups = {regression, smoke})
    public void verifyLoginPageTest() {
        loginPage.verifyPage();
    }

}
