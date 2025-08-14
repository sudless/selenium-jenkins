# Created by sude at 4.08.2025
Feature: Open new tab, window and window message by clicking them
  @browserWindows
  Scenario Outline: Check "<button>" and view "<view>"
  Given I open the DemoQA browser windows page
  When I click "<button>" browser button
  Then I view "<view>"

    Examples:
      | button     | view       |
      | New Tab    | new tab    |
      | New Window | new window |
   #     | New Window Message | new window message |