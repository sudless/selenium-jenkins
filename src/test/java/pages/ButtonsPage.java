package pages;

import Methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;
import utilities.DriverManager;

public class ButtonsPage {

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
                Methods.doubleClick(doubleClickButton);
                break;
            case "Right Click Me":
                Methods.rightClick(rightClickButton);
                break;
            case "Click Me":
                Methods.click(singleClickButton);
                break;
            default:
                throw new IllegalArgumentException("Invalid button type: " + clickType);
        }
    }

    public static void getMessage(String messageType) {
        String actualMessage = "";
        switch (messageType){
            case "You have done a double click":
                Methods.doubleClick(doubleClickButton);
                Methods.element(doubleClickMessage).isDisplayed();
                actualMessage = Methods.getText(doubleClickMessage);
                Assert.assertEquals(messageType, actualMessage);
                break;
            case "You have done a right click":
                Methods.rightClick(rightClickButton);
                Methods.element(rightClickMessage).isDisplayed();
                actualMessage = Methods.getText(rightClickMessage);
                Assert.assertEquals(messageType, actualMessage);
                break;
            case "You have done a dynamic click":
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
