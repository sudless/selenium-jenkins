package pages;

import Methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;
import utilities.DriverManager;

public class CheckBoxPage {
    static By checkBox = By.cssSelector("#tree-node > ol > li > span > label > span.rct-checkbox > svg");
    static By checkBoxResult = By.cssSelector("div[id='result']");


    static String resultExpected ="You have selected :\n" + "home\n" + "desktop\n" + "notes\n" + "commands\n" + "documents\n" + "workspace\n" + "react\n" + "angular\n" + "veu\n" + "office\n" + "public\n" + "private\n" + "classified\n" + "general\n" + "downloads\n" + "wordFile\n" + "excelFile";
    public static void open(){
        DriverManager.getDriver().get("https://demoqa.com/checkbox");
    }

    public static void clickCheckBox(){
        if(Methods.elementByClickable(checkBox).isSelected()){
            Methods.click(checkBox);
        }
        Methods.click(checkBox);
    }

    public static void checkResultMessage(){
        String resultText = Methods.getText(checkBoxResult);
        Methods.element(checkBoxResult).isDisplayed();
        Assert.assertEquals(resultExpected, resultText);
    }

    }

