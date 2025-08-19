package pages;

import Methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;
import utilities.WebdriverExtras;

public class CheckBoxPage {
    static By checkBox = By.cssSelector("#tree-node > ol > li > span > label > span.rct-checkbox > svg");
    static By checkBoxResult = By.cssSelector("div[id='result']");


    static String resultExpected = """
            You have selected :
            home
            desktop
            notes
            commands
            documents
            workspace
            react
            angular
            veu
            office
            public
            private
            classified
            general
            downloads
            wordFile
            excelFile""";
    public static void open(){
        WebdriverExtras.safeGet("https://demoqa.com/checkbox");
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

