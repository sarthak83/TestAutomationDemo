package org.suvi.testframework.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    private static final String  propertyFile = "properties/application.properties";

    public static String getProperty(String propertyKey) throws IOException {
        if(System.getProperty(propertyKey)!=null) {
            return System.getProperty(propertyKey);
        }
        String property = getValueFromPropertiesFile(propertyFile, propertyKey);
        return property;
    }

    private static String getValueFromPropertiesFile(String propertyFile, String propertyKey) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream;

        inputStream = PropertyLoader.class.getClassLoader().getResourceAsStream(propertyFile);
        if(inputStream == null) {
            System.out.println("Unable to find the property file"+propertyFile);
            return null;
        }
        properties.load(inputStream);
        return properties.getProperty(propertyKey);
    }
}
