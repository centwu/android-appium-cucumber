Feature: Login

  Scenario: User logs in with valid credentials
    Given user is on products page
    And user opens side menu
    And user navigates to login page
    When user enters valid username and password
    Then user should see products page

  Scenario: User logs in with locked out credentials
    Given user is on products page
    And user opens side menu
    And user navigates to login page
    When user enters locked out username and password
    Then user should see locked out message
