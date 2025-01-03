package automation;

import data.CustomDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.YourInformationPage;
import utilities.BaseTest;

public class YourInformationTests extends BaseTest {
    private final YourInformationPage yourInfoPage = new YourInformationPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goYourInformationPage();
    }

    @Test(groups = {regression},
            dataProviderClass = CustomDataProvider.class,
            dataProvider = CustomDataProvider.DP_ERROR_MESSAGES
    )
    public void errorMessagesTest(
            String firstName,
            String lastName,
            String zipCode,
            String errorMessage
    ) {
        yourInfoPage.fillData(firstName, lastName, zipCode);
        //yourInfoPage.verifyErrorMessage(errorMessage);

    }
}
