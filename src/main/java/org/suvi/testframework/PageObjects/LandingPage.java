package org.suvi.testframework.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {

    public final String PAGE_TITLE = "Google";

    @FindBy(name = "q") WebElement searchFieldTextBox;

    //xpaths
    @FindBy(xpath = "(//input[@name='btnK'])[2]") WebElement searchButtonTop;
    @FindBy(xpath = "//input[ends-with(@data-ved,'CBA')]") WebElement searchButtonTopXpath2;
    @FindBy(xpath = "(//input[@name='btnK'])[1]") WebElement searchButtonBottom;
    @FindBy(xpath = "//input[contains(@data-ved,'UDCBA') OR contains(@data-ved,'dUDCAs')]") WebElement searchButton;


    @FindBy(css = "input[value='Google Search'][name='btnK'][data-ved$='CAs']") WebElement searchButtonBottomCss;


    @FindBy(css = "input[value='Google Search'][name='btnK'][data-ved$='CBA']") WebElement searchButtonTopCss;

    @FindBy(id = "L2AGLb")
    WebElement acceptAllCookiesButton;

    public void enterSearchString(String searchString) {
        searchFieldTextBox.sendKeys(searchString);
    }

    public void acceptCookies() {
        if(elementPresent(acceptAllCookiesButton)) {
            acceptAllCookiesButton.click();
        }
        else {
            System.out.println("Cookies already accepted");
        }

    }

    public void clickSearchButton() throws Exception {
        waitForElementToBeVisible(searchButtonTop);
        try {
            searchButtonTop.click();
        } catch(org.openqa.selenium.ElementClickInterceptedException e) {
            searchButtonBottom.click();
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

}
