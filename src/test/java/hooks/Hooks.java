package hooks;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;
import utilities.DriverManager;

import java.time.Duration;

public class Hooks {

    @BeforeAll
    public static void setUp() {
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterAll
    public static void tearDown() {
        DriverManager.quit();

    }
}
