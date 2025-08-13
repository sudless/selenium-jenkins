package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BrowserWindowsPage;
import utilities.DriverManager;

import java.util.Set;

public class BrowserWindows {

    @Given("I open the DemoQA browser windows page")
    public void i_open_the_demo_qa_buttons_page() {
        BrowserWindowsPage.open();
    }

    @When("I click {string} browser button")
    public void i_click_button(String button) {
        BrowserWindowsPage.clickButtons(button);
    }

    @Then("I view {string}")
    public void i_view(String view) {
        BrowserWindowsPage.viewResult(view);
    }
}
