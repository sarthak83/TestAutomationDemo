package runners;

import io.cucumber.java.After;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "step_defs",
        tags = "@demo",
        plugin = {"pretty","message:target/cucumber-report.ndjson"}
)
public class Runner extends AbstractTestNGCucumberTests {



}
