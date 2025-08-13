package pages;

import Methods.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.DriverManager;

public class AutoCompletePage {

    static By singleInput = By.xpath("//*[@id=\"autoCompleteSingleInput\"]");
    static By multipleInput = By.xpath("//*[@id=\"autoCompleteMultipleInput\"]");
    static By redSingleLocator = By.xpath("//div[@class='auto-complete__single-value css-1uccc91-singleValue']");
    static By redMultView = By.xpath("//div[contains(text(),'Red')]");
    static By blueMultView = By.xpath("//div[contains(text(),'Blue')]");
    static By purpleMultView = By.xpath("//div[@class='css-12jo7m5 auto-complete__multi-value__label']");

    public static void open(){
        DriverManager.getDriver().get("https://demoqa.com/auto-complete");
    }
    public static void enterColors(String numOfColors, String inputField){
        if(numOfColors.equals("2") && inputField.equals("multiple colors space")){
            Methods.elementByClickable(multipleInput).sendKeys("Red", Keys.ENTER);
            Methods.elementByClickable(multipleInput).sendKeys("Blue", Keys.ENTER);
        }else if(numOfColors.equals("1") && inputField.equals("single colors space")){
            Methods.elementByClickable(singleInput).sendKeys("Red", Keys.ENTER);
        }else if(numOfColors.equals("1") && inputField.equals("multiple colors space")){
            Methods.elementByClickable(multipleInput).sendKeys("Red", Keys.ENTER);
        }
    }
    public static void viewColorResult(String numOfColors,String inputField){
        if(numOfColors.equals("2") && inputField.equals("multiple colors space")){
            Methods.elementByClickable(multipleInput).sendKeys("Red", Keys.ENTER);
            Methods.elementByClickable(multipleInput).sendKeys("Blue", Keys.ENTER);
            Methods.elementPresent(blueMultView).isDisplayed();
            Methods.elementPresent(redMultView).isDisplayed();
        }else if(numOfColors.equals("1") && inputField.equals("single colors space")){
            Methods.elementByClickable(singleInput).sendKeys("Red", Keys.ENTER);
            Methods.elementPresent(redSingleLocator).isDisplayed();
        }else if(numOfColors.equals("1") && inputField.equals("multiple colors space")){
            Methods.elementByClickable(multipleInput).sendKeys("Red", Keys.ENTER);
            Methods.elementPresent(purpleMultView).isDisplayed();
        }
    }
    }


