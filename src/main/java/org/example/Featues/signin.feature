Feature: User Login
  As a registered user,
  I want to log in, to access my account.

  Scenario: Successful User Login
    Given I am on the login page
    When I enter "gaurav.kumar@gmail.com" as email
    And I enter "Abc@1234" as password
    And I click on "Sign In" button
    Then I should be redirected to the user account page

  Scenario: Login with Incorrect Password
    Given I am on the login page
    When I enter "gaurav.kumar@gmail.com" as email
    And I enter wrong password in password field
    And I click on "Sign In" button
    Then I should see an error message "Invalid login credentials"

  Scenario: Login with Empty Fields
    Given I am on the login page
    When I leave email and password empty
    And I click on "Sign In" button
    Then I should see an error message "This is a required field."
