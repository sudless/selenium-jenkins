# Created by sude at 5.08.2025

Feature: Type colors and view auto completion
  @autoComplete
  Scenario Outline: Type multiple or single color names and view autocompletion
    Given I go to DemoQA auto complete page
    When I enter "<numOfColors>" in "<inputField>"
    Then I view the chosen "<numOfColors>" in "<inputField>"

    Examples:
      | numOfColors | inputField            |
      | 2           | multiple colors space |
      | 1           | single color space    |
      | 1           | multiple colors space |



