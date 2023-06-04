package org.suvi.testframework.driver.producer;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxLocalProducer implements WebDriverProducer {

    @Override
    public WebDriver produce() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
