package step_defs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.suvi.testframework.PageObjects.LandingPage;
import org.suvi.testframework.PageObjects.SearchResultsPage;
import org.suvi.testframework.driver.DriverManager;
import org.testng.Assert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class StepDefinitions {

    @Before
    public void setUp() {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
//        driver.close();
    }

    WebDriver driver = DriverManager.getDriver();
    LandingPage landingPage = PageFactory.initElements(driver,LandingPage.class);
    SearchResultsPage searchResultsPage = PageFactory.initElements(driver,SearchResultsPage.class);
    public StepDefinitions() throws IOException {
    }

    @Given("I navigate to google home page")
    public void i_navigate_to_google_home_page() {
        driver.get("https://www.google.co.uk");
    }

    @Then("google homepage should be loaded")
    public void google_homepage_should_be_loaded() {
        Assert.assertEquals(landingPage.PAGE_TITLE,driver.getTitle());
    }

    @When("I search for a string {string}")
    public void iSearchForAStringSearchString(String searchString) throws Exception {
        landingPage.acceptCookies();
        landingPage.enterSearchString(searchString);
        landingPage.clickSearchButton();
    }


    @Then("first result should be {string}")
    public void firstResultShouldBeResult(String firstResult) {
        Assert.assertEquals(searchResultsPage.getFirstResultLink(),firstResult);
    }
}
