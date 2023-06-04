package org.suvi.testframework.driver;

import org.openqa.selenium.WebDriver;
import org.suvi.testframework.driver.producer.ChromeLocalProducer;
import org.suvi.testframework.driver.producer.FireFoxLocalProducer;
import org.suvi.testframework.driver.producer.WebDriverProducer;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static final Map<BrowserType, WebDriverProducer> producers = new HashMap<>();

    static{
        producers.put(BrowserType.Chrome, new ChromeLocalProducer());
        producers.put(BrowserType.Firefox, new FireFoxLocalProducer());
    }

    private final BrowserType browserType;

    public DriverFactory(String browserTypeName) {
        browserType = BrowserType.valueOf(browserTypeName);
    }

    public WebDriver createInstance() {
        return producers.get(browserType).produce();
    }
}
