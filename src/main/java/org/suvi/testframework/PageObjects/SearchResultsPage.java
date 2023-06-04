package org.suvi.testframework.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage {
    @FindBy(xpath="(//div[@class='yuRUbf'])[1]/a") WebElement firstLinkElement;

    public String getFirstResultLink() {
        return firstLinkElement.getAttribute("href");
    }

}
