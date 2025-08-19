package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    public enum Browser { CHROME, FIREFOX, EDGE }
    private static final ThreadLocal<WebDriver> TL_DRIVER = new ThreadLocal<>();

    public static WebDriver getDriver(){
        WebDriver drv = TL_DRIVER.get();
        if(drv == null){
            String browserName = System.getProperty("browser","chrome").toUpperCase();
            boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
            Browser browser = Browser.valueOf(browserName);

            switch(browser){
                case FIREFOX -> {
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions fops = new FirefoxOptions();
                    if (Boolean.getBoolean("headless")) fops.addArguments("--headless");
                    drv = new FirefoxDriver(fops);
                }
                case EDGE -> {
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions eops = new EdgeOptions();
                    if (Boolean.getBoolean("headless")) eops.addArguments("--headless");
                    drv =  new EdgeDriver(eops);
                }
                case CHROME -> {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions cops = new ChromeOptions();
                    if (Boolean.getBoolean("headless")) cops.addArguments("--headless");
                    drv =  new ChromeDriver(cops);
                }
            }
            TL_DRIVER.set(drv);
            drv.manage().window().maximize();
        }
        return drv;
    }

    public static void quitDriver(){
        WebDriver drv = TL_DRIVER.get();
        if(drv != null){
            drv.quit();
            TL_DRIVER.remove();
        }
    }
}
