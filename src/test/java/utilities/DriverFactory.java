package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverFactory {

    public enum Browser { CHROME, FIREFOX, EDGE }
    private static final ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    private static final ThreadLocal<WebDriverWait> waits = new ThreadLocal<>();
    private static final ThreadLocal<Browser> browsers = new ThreadLocal<>();

    private DriverFactory() {}

    public static WebDriver getDriver() {
        WebDriver driver = drivers.get();
        if (driver == null) {
            initFromSystemProps();
            driver = drivers.get();
        }
        return driver;
    }

    public static WebDriverWait getWait() {
        WebDriverWait wait = waits.get();
        if(wait == null) {
            int timeout = Integer.parseInt(System.getProperty("waitTimeout", "10"));
            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
            waits.set(wait);
        }
        return wait;
    }

    public static Browser getBrowser(){
        if(browsers.get() == null) initFromSystemProps();
        return browsers.get();
    }

    public static void quitDriver() {
        WebDriver driver = drivers.get();
        if (driver != null) {
            try{driver.quit();} finally{
                drivers.remove();
                waits.remove();
                browsers.remove();
            }
        }
    }

    //helpers

    private static void initFromSystemProps() {
        // browser + headless passed from Maven/Jenkins: -Dbrowser=firefox -Dheadless=true
        final String browserName = System.getProperty("browser", "chrome").trim().toUpperCase();
        final boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        final int waitSeconds    = Integer.parseInt(System.getProperty("waitTimeout", "10"));

        Browser browser;
        try{
            browser = Browser.valueOf(browserName);
        }catch(IllegalArgumentException e){
            browser = Browser.CHROME;
        }
        browsers.set(browser);

        WebDriver driver;
        switch (browser) {
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions Foptions = new FirefoxOptions();
                if(headless) Foptions.addArguments("-headless");
                driver = new FirefoxDriver(Foptions);
            }
            case EDGE -> {
                WebDriverManager.edgedriver().setup();
                EdgeOptions Eoptions = new EdgeOptions();
                if (headless) Eoptions.addArguments("--headless=new");
                driver = new EdgeDriver(Eoptions);
            }
            default -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions Coptions = new ChromeOptions();
                if(headless) Coptions.addArguments("--headless=new");
                driver = new ChromeDriver(Coptions);
            }
        }
        // Per-thread driver ready
        drivers.set(driver);

        // Window & timeouts – keep implicit at 0 when using explicit waits
        try{ driver.manage().window().maximize();
        } catch(Exception ignored){
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(
                    Long.parseLong(System.getProperty("pageLoadTimeout", "60"))));
            driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(
                    Long.parseLong(System.getProperty("scriptTimeout", "30"))));

            // Per-thread explicit wait
            waits.set(new WebDriverWait(driver, Duration.ofSeconds(waitSeconds)));
        }

    }

//    public static WebDriver getDriver(){
//        WebDriver drv = drivers.get();
//        if(drv == null){
//            String browserName = System.getProperty("browser","chrome").toUpperCase();
//            boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
//            Browser browser = Browser.valueOf(browserName);
//
//            switch(browser){
//                case FIREFOX -> {
//                    WebDriverManager.firefoxdriver().setup();
//                    FirefoxOptions fops = new FirefoxOptions();
//                    if (Boolean.getBoolean("headless")) fops.addArguments("--headless");
//                    drv = new FirefoxDriver(fops);
//                }
//                case EDGE -> {
//                    WebDriverManager.edgedriver().setup();
//                    EdgeOptions eops = new EdgeOptions();
//                    if (Boolean.getBoolean("headless")) eops.addArguments("--headless");
//                    drv =  new EdgeDriver(eops);
//                }
//                case CHROME -> {
//                    WebDriverManager.chromedriver().setup();
//                    ChromeOptions cops = new ChromeOptions();
//                    if (Boolean.getBoolean("headless")) cops.addArguments("--headless");
//                    drv =  new ChromeDriver(cops);
//                }
//            }
//            drivers.set(drv);
//            drv.manage().window().maximize();
//        }
//        return drv;
//    }
//
//    public static void quitDriver(){
//        WebDriver drv = driver.get();
//        if(drv != null){
//            drv.quit();
//            driver.remove();
//        }
//    }
}
