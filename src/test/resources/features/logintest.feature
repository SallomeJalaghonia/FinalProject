Feature: User Login

  Scenario: Successful login with valid credentials
    Given User is on the login page
    When User enters valid username and password
    And User clicks on the login button
    Then User should be redirected to the secure area
    And User should see a logout button

  Scenario: Unsuccessful login with invalid credentials
    Given User is on the login page
    When User enters invalid username and password
    And User clicks on the login button
    Then User should see an error message
