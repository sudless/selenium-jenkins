package hooks;

import io.cucumber.java.*;
import utilities.DriverFactory;

import java.time.Duration;

public class Hooks {

    @BeforeAll
    public static void setUp() {
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterAll
    public static void tearDown() {
        DriverFactory.quitDriver();

    }
}
