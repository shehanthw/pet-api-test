package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class PropertyUtils {

    private PropertyUtils() {}

    public static String getValue(String key) {
        try {
            Properties property = new Properties();
            FileInputStream file = new FileInputStream("src/test/resources/config/config.properties");

            property.load(file);
            return property.getProperty(key).trim();
        } catch (IOException e) {
            System.out.println(e);
        }
        return key;
    }
}
