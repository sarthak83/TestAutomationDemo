package org.suvi.testframework.driver.producer;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeLocalProducer implements WebDriverProducer {
    @Override
    public WebDriver produce() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
