package pages;

import Methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverManager;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static utilities.DriverManager.driver;

public class BrowserWindowsPage {

    static By newTabButton = By.xpath("//*[@id='tabButton']");
    static By newWindowButton = By.xpath("//*[@id='windowButton']");
    static By newPopupButton = By.xpath("//*[@id='messageWindowButton']");
    static By newTabMessage = By.id("sampleHeading");
    static By getNewWindowHeading = By.id("sampleHeading");
    static By getNewPopupMessage = By.xpath("/html/body");
    static String popupMessage = "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";
    public static void open(){
        DriverManager.getDriver().get("https://demoqa.com/browser-windows");
    }

    public static void clickButtons(String button){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        Methods.elementByClickable(newTabButton).isDisplayed();
        Methods.elementByClickable(newWindowButton).isDisplayed();
        Methods.elementByClickable(newPopupButton).isDisplayed();
        switch(button) {
            case "New Tab":
                Methods.elementByClickable(newTabButton).click();
                break;
            case "New Window":
                js.executeScript("arguments[0].click()", Methods.elementByClickable(newWindowButton));
                break;
            case "New Window Message":
                js.executeScript("arguments[0].click()", Methods.elementByClickable(newPopupButton));
                break;
        }
    }
    public static void viewResult(String view) {
        var d = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(5));
        String originalWindow = d.getWindowHandle();

        for (String handle : d.getWindowHandles()) {
            if (!handle.equals(originalWindow)) {
                d.switchTo().window(handle);
                break;
            }
        }
        switch(view) {
            case "new tab":
                wait.until(w -> "complete".equals(
                        ((JavascriptExecutor) w).executeScript("return document.readyState")));

                Methods.element(newTabMessage).isDisplayed();
                Assert.assertEquals(Methods.element(newTabMessage).getText(), "This is a sample page");
                DriverManager.getDriver().switchTo().window(originalWindow);
                break;
            case "new window":
                wait.until(w -> "complete".equals(
                        ((JavascriptExecutor) w).executeScript("return document.readyState")));
                DriverManager.getDriver().switchTo().window(DriverManager.getDriver().getWindowHandle());
                Methods.element(getNewWindowHeading).isDisplayed();
                Assert.assertEquals("This is a sample page", Methods.element(getNewWindowHeading).getText());
                break;
            case "new window message":

                wait.until(ExpectedConditions.numberOfWindowsToBe(2));

                // Get all window handles
                Set<String> allWindows = d.getWindowHandles();
                System.out.println("All windows: " + allWindows);

                // Switch to the new popup window
                for (String windowHandle : allWindows) {
                    if (!windowHandle.equals(originalWindow)) {
                        d.switchTo().window(windowHandle);
                        System.out.println("Switched to window: " + windowHandle);
                        break;
                    }
                }


                try {
                    // Wait for the page to load completely
                    wait.until(w -> "complete".equals(
                            ((JavascriptExecutor) w).executeScript("return document.readyState")));
                    String actualText = Methods.element(By.tagName("body")).getText().trim();
                    System.out.println("Actual text: " + actualText);
                    Assert.assertTrue("Expected popup message not found. Actual: '" + actualText + "'",
                            actualText.contains("Knowledge increases by sharing") ||
                                    actualText.equals(popupMessage));
                } catch (Exception e) {
                    System.out.println("Error reading popup content: " + e.getMessage());
                    // Try alternative approach - get page source
                    String pageSource = d.getPageSource();
                    System.out.println("Page source: " + pageSource);
                    throw e;
                }break;

            default:
                throw new IllegalArgumentException("Unexpected view type: " + view);
        }
//                List<String> windowHandles = DriverManager.getDriver().getWindowHandles().stream().toList();
//                System.out.println(windowHandles);
//                System.out.println(windowHandles.get(1));
//                System.out.println(DriverManager.getDriver().switchTo().window(windowHandles.get(1)).findElement(By.xpath("//body")).getText());



//                break;
//            default:
//                throw new IllegalArgumentException("Unexpected view type: " + view);
//
//        }
       // d.close();
       // d.switchTo().window(originalWindow);
    }
    }

