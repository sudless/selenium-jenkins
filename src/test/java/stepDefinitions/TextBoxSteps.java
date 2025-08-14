package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TextBoxPage;

public class TextBoxSteps{

    @Given("I open the DemoQA text box page")
    public void i_open_demoqa(){
        TextBoxPage.open();
    }

    @When("I fill out the form with credentials")
    public void i_fill_out_form() {
        TextBoxPage.fillForm();
    }
    @And("I click the submit button")
    public void i_click_submit() {
        TextBoxPage.submit();
    }

    @Then("the name displayed should be {string}")
    public void name_displayed_should_be(String expected) {
        TextBoxPage.checkDisplayedName(expected);
    }
}

