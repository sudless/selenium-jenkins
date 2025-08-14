package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AutoCompletePage;

public class AutoComplete {
    @Given("I go to DemoQA auto complete page")
    public void i_go_to_demoQA_autoCompletePage() {
        AutoCompletePage.open();
    }

    @When("I enter {string} in {string}")
    public void i_enter_colors_infield(String numOfColors, String inputField) throws InterruptedException {
        AutoCompletePage.enterColors(numOfColors, inputField);
    }
    @Then("I view the chosen {string} in {string}")
    public void i_view_result(String numOfColors,String inputField) throws InterruptedException {
        AutoCompletePage.viewColorResult(numOfColors, inputField);
    }

}
