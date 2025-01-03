package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class YourInformationPage extends BasePage {
    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By zipCodeInput = By.id("postal-code");
    private final By continueButton = By.id("postal-code");
    private final By errorLabel = By.cssSelector("h3[data-test='error']");


    @Override
    @Step("Waiting page to load")
    public void waitPageToLoad() {
        waitPage(firstNameInput, this.getClass().getSimpleName());

    }

    @Override
    @Step("Verifying Your Information Page")
    public void verifyPage() {
        Logs.info("Verifying Your Information Page");
        softAssert.assertTrue(find(firstNameInput).isDisplayed());
        softAssert.assertTrue(find(lastNameInput).isDisplayed());
        softAssert.assertTrue(find(zipCodeInput).isDisplayed());
        softAssert.assertTrue(find(continueButton).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Filling form")
    public void fillData(String firstName, String lastName, String zipCode) {
        if (!firstName.isEmpty()) {
            Logs.info("Writing first name");
            find(firstNameInput).sendKeys(firstName);
        }

        if (!lastName.isEmpty()) {
            Logs.info("Writing last name");
            find(lastNameInput).sendKeys(lastName);
        }

        if (!zipCode.isEmpty()) {
            Logs.info("Writing zip code");
            find(zipCodeInput).sendKeys(zipCode);
        }

        Logs.info("Clicking Continue Button");
        find(continueButton).click();
    }

    @Step("Verifying Error Message")
    public void verifyErrorMessage(String errorMessage) {
        Logs.info("Verifying Error Message");
        final var errorLabelElement = find(errorLabel);

        softAssert.assertTrue(errorLabelElement.isDisplayed());
        softAssert.assertEquals(errorLabelElement.getText(), errorMessage);
        softAssert.assertAll();
    }
}
