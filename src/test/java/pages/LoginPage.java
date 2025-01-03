package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class LoginPage extends BasePage {
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    @Override
    @Step("Waiting to load LogIn Page")
    public void waitPageToLoad() {
        waitPage(usernameInput, this.getClass().getSimpleName());

    }

    @Override
    @Step("Verifying  LogIn Page")
    public void verifyPage() {
        Logs.info("Verifying Login page");
        softAssert.assertTrue(find(usernameInput).isDisplayed());
        softAssert.assertTrue(find(passwordInput).isDisplayed());
        softAssert.assertTrue(find(loginButton).isDisplayed());
        softAssert.assertAll();

    }

    @Step("Filling Login form")
    public void fillLogin(String username, String password) {
        Logs.info("Input usernmae");
        find(usernameInput).sendKeys(username);

        Logs.info("Input password");
        find(passwordInput).sendKeys(password);

        Logs.info("Click Login");
        find(loginButton).click();
    }

    @Step("Verifying error message")
    public void verifyErrorMessage(String errorText) {
        final var errorLabel = find(errorMessage);

        Logs.info("Verifying error message and text related");
        softAssert.assertTrue(errorLabel.isDisplayed());
        softAssert.assertEquals(errorLabel.getText(), errorText);
        softAssert.assertAll();
    }
}
