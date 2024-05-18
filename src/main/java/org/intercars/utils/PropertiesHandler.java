package org.intercars.utils;

import java.util.ResourceBundle;

public class PropertiesHandler {

    private static final String URL = "url";

    private PropertiesHandler() {
        throw new IllegalStateException("Utility class");
    }

    private static String getRequiredData(final String key) {
        return ResourceBundle.getBundle(switch (System.getProperty("env") != null ? System.getProperty("env") : "prod") {
            case "test":
                yield "test";
            case "prod":
                yield "prod";
            default:
                throw new IllegalStateException("Unexpected env");
        }).getString(key);
    }

    public static String getUrl() {
        return getRequiredData(URL);
    }
}
