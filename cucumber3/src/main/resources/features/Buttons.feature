# Created by sude at 4.08.2025
Feature: Click Buttons on DemoQA
  @buttons
  Scenario Outline: Click buttons on DemoQA and receive message
    Given I open the DemoQA buttons page
    When I click "<clickType>" button
    Then I should be told "<messageType>"

    Examples:
      | clickType       | messageType                   |
      | Double Click Me | You have done a double click  |
      | Right Click Me  | You have done a right click   |
      | Click Me        | You have done a dynamic click |