# Created by sude at 1.08.2025
Feature: Fill out text box form on DemoQA
  @textBox
  Scenario: Submit user details and verify message
    Given I open the DemoQA text box page
    When I fill out the form with credentials
    And I click the submit button
    Then the name displayed should be "Name:testerFullName"