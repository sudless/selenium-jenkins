package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverManager;
import org.openqa.selenium.interactions.Actions;
import pages.ButtonsPage;
import java.time.Duration;


public class Buttons {

    @Given("I open the DemoQA buttons page")
    public void i_open_DemoQA(){
        ButtonsPage.open();
    }

    @When("I click {string} button")
    public void i_click_button(String clickType) throws InterruptedException {
        ButtonsPage.clickButton(clickType);
    }


    @Then("I should be told {string}")
    public void i_should_be_told(String messageType){
        ButtonsPage.getMessage(messageType);

    }

}
