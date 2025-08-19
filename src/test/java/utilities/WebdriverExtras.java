package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class WebdriverExtras {
    public static void safeGet(String url){
        WebDriver driver = DriverFactory.getDriver();
        final int maxAttempts = 3;
        int attempts = 0;

        while (attempts++ < maxAttempts) {
            try {
                driver.navigate().to(url);
                new WebDriverWait(driver, Duration.ofSeconds(20))
                        .until(d -> "complete".equals(
                                ((JavascriptExecutor) d).executeScript("return document.readyState")));
                return; // success
            } catch (WebDriverException e) {
                if (attempts == maxAttempts) throw e; // give up
                // short cooperative backoff w/out Thread.sleep
                new WebDriverWait(driver, Duration.ofSeconds(2)).until(d -> true);
            }
        }
    }
}