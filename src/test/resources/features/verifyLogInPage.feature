Feature: Validate Log in page with invalid credentials

  Background:
    Given User opens Home page

  Scenario Outline: User logs in with default credentials and sees validation message
    When User clicks on the login portal link
    And  User switches to another tab
    When User logs in with name - "<username>", password - "<password>"
    And User accepts the alert
    Then User sees the "validation failed" message in alert window

    Examples:
      | username | password  |
      | Arina    | ffdss6788 |


