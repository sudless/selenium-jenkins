# Created by sude at 4.08.2025
Feature: Check the box on DemoQA
  @checkBox
  Scenario: Check the box on DemoQA and view "You have selected" message
    Given I open the DemoQA check box page
    When I click the checkbox
    Then I view the 'You have selected' message