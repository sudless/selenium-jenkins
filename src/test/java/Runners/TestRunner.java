package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = {"stepDefinitions", "hooks"},
        tags = "@buttons",
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true
)


public class TestRunner {
}

