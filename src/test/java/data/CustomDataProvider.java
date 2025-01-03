package data;

import models.User;
import org.testng.annotations.DataProvider;

public class CustomDataProvider {
    public static final String DP_CREDENTIALS = "dpCredentials";
    public static final String DP_ERROR_MESSAGES = "dpErrorMessages";

    @DataProvider(name = DP_CREDENTIALS)
    public static Object[][] credentialsDataProvider() {
        final var invalid = DataGiver.getLockedCredential();
        final var nonexistent = DataGiver.getNonexistentCredential();

        return new Object[][]{
                {invalid.getUsername(), invalid.getPassword(), invalid.getMessage()},
                {nonexistent.getUsername(), nonexistent.getPassword(), nonexistent.getMessage()}
        };
    }

    @DataProvider(name = DP_ERROR_MESSAGES)
    public static Object[][] errorMessagesDataProvider() {
        final var user = new User();
        final var mapErrorMessages = Parser.getMapErrorMessage();

        return new Object[][]{
                {"", user.getLastName(), user.getZipCode(),
                        mapErrorMessages.get("error_name").getMessage()},
                {user.getFirstName(), "", user.getZipCode(),
                        mapErrorMessages.get("error_lastname").getMessage()},
                {user.getFirstName(), user.getLastName(), "",
                        mapErrorMessages.get("error_zipcode").getMessage()}
        };
    }
}
