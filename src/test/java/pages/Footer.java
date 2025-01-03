package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;

public class Footer extends BasePage {
    private final By twitterButton = By.xpath("//a[text()='Twitter']");
    private final By linkedInButton = By.xpath("//a[text()='LinkedIn']");
    private final By facebookButton = By.xpath("//a[text()='Facebook']");

    @Override
    public void waitPageToLoad() {
    }

    @Override
    public void verifyPage() {
    }

    @Step("Verifying Social Media Links")
    public void verifySocialMediaLinks(
            String twitterUrl,
            String linkedInUrl,
            String facebookUrl
    ) {
        final var twitterLabel = find(twitterButton);
        final var linkedInLabel = find(linkedInButton);
        final var facebookLabel = find(facebookButton);

        softAssert.assertTrue(twitterLabel.isDisplayed());
        softAssert.assertTrue(twitterLabel.isEnabled());
        softAssert.assertEquals(twitterLabel.getAttribute("href"), twitterUrl);

        softAssert.assertTrue(linkedInLabel.isDisplayed());
        softAssert.assertTrue(linkedInLabel.isEnabled());
        softAssert.assertEquals(linkedInLabel.getAttribute("href"), linkedInUrl);

        softAssert.assertTrue(facebookLabel.isDisplayed());
        softAssert.assertTrue(facebookLabel.isEnabled());
        softAssert.assertEquals(facebookLabel.getAttribute("href"), facebookUrl);

        softAssert.assertAll();

    }
}
