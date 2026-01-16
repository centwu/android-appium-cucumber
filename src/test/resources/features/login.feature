Feature: Login

  Background:
    Given user is on products page
    And user opens side menu
    And user navigates to login page

  Scenario: User logs in with valid credentials
    When user enters valid username and password
    Then user should see products page

  Scenario: User logs in with locked out credentials
    When user enters locked out username and password
    Then user should see locked out message
