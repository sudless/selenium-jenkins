package pages;

import Methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utilities.DriverManager;

public class TextBoxPage {
    static By fullName = By.xpath("(//*[@autocomplete])[1]");
    static By email = By.xpath("(//*[@autocomplete])[2]");
    static By currAdd = By.cssSelector("*[placeholder='Current Address']");
    static By permAdd = By.xpath("(//*[@class='form-control'])[2]");
    static By submitButton = By.id("submit");
    static By nameDisplayed = By.xpath("//p[@id='name']");

    public static void open(){
        DriverManager.getDriver().get("https://demoqa.com/text-box");
    }
    public static void fillForm(){
        Methods.sendKeys(fullName,"testerFullName");
        Methods.sendKeys(email,"testerEmail@gmail.com");
        Methods.sendKeys(currAdd,"testerCurrAddress");
        Methods.sendKeys(permAdd,"testerPermAddress");
    }
    public static void submit(){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].click()", Methods.elementByClickable(submitButton));
    }
    public static void checkDisplayedName(String expected){
        Methods.element(nameDisplayed).isDisplayed();
        Assert.assertEquals(expected, Methods.getText(nameDisplayed));
    }
}
