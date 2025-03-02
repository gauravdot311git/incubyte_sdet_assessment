Feature: User Account
  As a registered user and logged in the account,
  I want to log out.

  Scenario: Successful User Log out
    Given I am logged in into user account page
    When I click on drop down
    And I click on sign out
    Then I should be logged out and redirected to the home page
