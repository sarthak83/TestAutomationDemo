package org.suvi.testframework.PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.suvi.testframework.driver.DriverManager;

import java.io.IOException;

import static org.suvi.testframework.driver.DriverManager.getDriver;

public class BasePage {

    private static final long WEB_BROWSER_TIMEOUT = 20;

    public WebDriverWait webDriverWait() throws IOException {
        return new WebDriverWait(getDriver(),WEB_BROWSER_TIMEOUT);
    }

    public void waitForElementToBeVisible(WebElement webElement) {
        try {
            webDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean elementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch(org.openqa.selenium.NoSuchElementException e) {
            return false;
    }


    }
}
