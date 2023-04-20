Feature: Verify options page functionality

  Background:
    Given User opens Home page
    When User clicks on the Options link
    And User switches to another tab

  Scenario Outline: Check Java dropdown menu
    And Users select the "<option>" option
    Then Users sees the "<expectedResult>" option text

    Examples:
      | option | expectedResult |
      | c#     | C#             |
      | sql    | SQL            |

  Scenario: Check green radio button
    And User clicks on the Green radio button
    Then User sees the value "green"

  Scenario: Check checkboxes
    And User selects the first, second option checkboxes
    Then User sees that the first and second checkboxes are selected

