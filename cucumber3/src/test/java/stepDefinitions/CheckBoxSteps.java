package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckBoxPage;

public class CheckBoxSteps {
    @Given("I open the DemoQA check box page")
    public void i_open_DemoQA(){
        CheckBoxPage.open();
    }
    @When("I click the checkbox")
    public void i_click_checkbox(){
        CheckBoxPage.clickCheckBox();
    }
    @Then("I view the 'You have selected' message")
    public void i_view_checkbox_message(){
        CheckBoxPage.checkResultMessage();
    }
}
