package org.suvi.testframework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.suvi.testframework.properties.*;

import java.io.IOException;

public class DriverManager {

    private static final BrowserType DEFAULT_BROWSER = BrowserType.Chrome;
    private static WebDriver d = null;

    public static WebDriver getDriver() throws IOException {
        if(d ==null) {
            d = createDriver();
        }
        return d;
    }

    public static WebDriver createDriver() throws IOException {
        String currentBrowser = PropertyLoader.getProperty(CommonProperties.BROWSER_TYPE);
        if(currentBrowser == null) {
            System.out.println("could not get the property from property file!");
            currentBrowser = DEFAULT_BROWSER.toString();
        }
        return new DriverFactory(currentBrowser).createInstance();
    }
}
