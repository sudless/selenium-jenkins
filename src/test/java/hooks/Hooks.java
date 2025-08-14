package hooks;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import utilities.DriverManager;

import java.time.Duration;

import static utilities.DriverManager.driver;

public class Hooks {

    @BeforeAll
    public void setUp() {
        DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterAll
    public void tearDown() {
        DriverManager.getDriver().quit();

    }
}
