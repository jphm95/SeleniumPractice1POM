package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class JsonCredential {
    @JsonProperty("credentials")
    private Map<String, Credential> mapCredentials;

    public Map<String, Credential> getMapCredentials() {
        return mapCredentials;
    }
}
