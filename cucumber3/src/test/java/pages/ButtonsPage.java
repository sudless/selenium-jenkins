package pages;

import Methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverManager;
import Methods.Methods;

import java.time.Duration;

public class ButtonsPage {
    static Actions actions = new Actions(DriverManager.getDriver());

    static By doubleClickButton = By.xpath("//button[text()='Double Click Me']");
    static By singleClickButton = By.xpath("//button[text()='Click Me']");
    static By rightClickButton = By.xpath("//button[text()='Right Click Me']");
    static By doubleClickMessage = By.id("doubleClickMessage");
    static By singleClickMessage = By.id("dynamicClickMessage");
    static By rightClickMessage = By.id("rightClickMessage");


    public static void open() {
        DriverManager.getDriver().get("https://demoqa.com/buttons");
    }

    public static void clickButton(String clickType) {
        switch (clickType) {
            case "Double Click Me":
                actions.doubleClick(Methods.elementByClickable(doubleClickButton)).perform();
                break;
            case "Right Click Me":
                actions.contextClick(Methods.elementByClickable(rightClickButton)).perform();
                break;
            case "Click Me":
                actions.click(Methods.elementByClickable(singleClickButton)).perform();
                break;
            default:
                throw new IllegalArgumentException("Invalid button type: " + clickType);
        }
    }

    public static void getMessage(String messageType) {
        String actualMessage = "";
        switch (messageType){
            case "You have done a double click":
                //action.doubleClick(Elements.getDoubleButton()).perform();
                actions.doubleClick(Methods.elementByClickable(doubleClickButton)).perform();
                Methods.element(doubleClickMessage).isDisplayed();
                actualMessage = Methods.element(doubleClickMessage).getText();
                Assert.assertEquals(messageType, actualMessage);
                break;
            case "You have done a right click":
                actions.contextClick(Methods.elementByClickable(rightClickButton)).perform();
                Methods.element(rightClickMessage).isDisplayed();
                actualMessage = Methods.element(rightClickMessage).getText();
                Assert.assertEquals(messageType, actualMessage);
                break;
            case "You have done a dynamic click":
                actions.click(Methods.elementByClickable(singleClickButton)).perform();
                Methods.element(singleClickMessage).isDisplayed();
                actualMessage = Methods.element(singleClickMessage).getText();
                Assert.assertEquals(messageType, actualMessage);
                break;
            default:
                throw new IllegalArgumentException("Unexpected message type ");
        }
}
}
