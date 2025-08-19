package pages;

import Methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utilities.DriverFactory;
import utilities.WebdriverExtras;

public class ButtonsPage {

    static By doubleClickButton = By.id("doubleClickBtn");
    static By rightClickButton = By.id("rightClickBtn");
    static By singleClickButton = By.xpath("(//*[@type=\"button\"])[4]");

    static By doubleClickMessage = By.id("doubleClickMessage");
    static By singleClickMessage = By.id("dynamicClickMessage");
    static By rightClickMessage = By.id("rightClickMessage");


    public static void open() {
        WebdriverExtras.safeGet("https://demoqa.com/buttons");
    }

    public static void clickButton(String clickType) {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        switch (clickType) {
            case "Double Click Me":
                Methods.doubleClick(doubleClickButton);
                break;
            case "Right Click Me":
                Methods.rightClick(rightClickButton);
                break;
            case "Click Me":
                js.executeScript("arguments[0].click();", Methods.element(singleClickButton));
                //Methods.click(singleClickButton);
                break;
            default:
                throw new IllegalArgumentException("Invalid button type: " + clickType);
        }
    }

    public static void getMessage(String messageType) {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        String actualMessage;
        switch (messageType){
            case "You have done a double click":
                js.executeScript(
                        "var e=new MouseEvent('dblclick',{bubbles:true,cancelable:true,view:window});" +
                                "arguments[0].dispatchEvent(e);",
                        Methods.element(doubleClickButton));
                //Methods.doubleClick(doubleClickButton);
                Methods.element(doubleClickMessage).isDisplayed();
                actualMessage = Methods.getText(doubleClickMessage);
                Assert.assertEquals(messageType, actualMessage);
                break;
            case "You have done a right click":
                js.executeScript(
                        "var e=new MouseEvent('contextmenu',{bubbles:true,cancelable:true,view:window,button:2});" +
                                "arguments[0].dispatchEvent(e);",
                        Methods.element(rightClickButton));                //Methods.rightClick(rightClickButton);
                Methods.element(rightClickMessage).isDisplayed();
                actualMessage = Methods.getText(rightClickMessage);
                Assert.assertEquals(messageType, actualMessage);
                break;
            case "You have done a dynamic click":
                js.executeScript("arguments[0].click();", Methods.element(singleClickMessage));
                Methods.click(singleClickButton);
                Methods.element(singleClickMessage).isDisplayed();
                actualMessage = Methods.getText(singleClickMessage);
                Assert.assertEquals(messageType, actualMessage);
                break;
            default:
                throw new IllegalArgumentException("Unexpected message type ");
        }
    }
}
