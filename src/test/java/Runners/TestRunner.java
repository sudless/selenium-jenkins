package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = {"stepDefinitions", "hooks"},
        tags = "@autoComplete",
        plugin = {"pretty",
                  "json:target/cucumber-report/cucumber.json",
                  "junit:target/cucumber-report/cucumber.xml"
        },
        monochrome = true
)


public class TestRunner {
}

