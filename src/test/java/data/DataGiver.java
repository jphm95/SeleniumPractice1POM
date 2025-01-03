package data;

import models.Credential;

import java.util.Map;

public class DataGiver {
    private static Map<String, Credential> getMapCredentials() {
        return JsonReader.getMapCredentials().getMapCredentials();
    }

    public static Credential getValidCredential() {
        return getMapCredentials().get("valid");
    }

    public static Credential getLockedCredential() {
        return getMapCredentials().get("locked");
    }

    public static Credential getNonexistentCredential() {
        return getMapCredentials().get("nonexistent");
    }
}
