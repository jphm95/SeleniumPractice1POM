package data;

import models.ErrorMessageExcel;

import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static Map<String, ErrorMessageExcel> getMapErrorMessage() {
        final var map = new HashMap<String, ErrorMessageExcel>();

        final var messageErrorList = ExcelReader.readErrorMessagesExcel();

        for (var errorMessage : messageErrorList) {
            map.put(errorMessage.getName(), errorMessage);
        }
        return map;
    }
}
