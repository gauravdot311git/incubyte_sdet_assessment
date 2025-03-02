Feature: User Signup
  As a new user,
  I want to create an account,
  So that I can log in and access my dashboard.

  Scenario: Successful User Signup
    Given I am on the signup page
    When I enter valid "Gaurav" as first name
    And I enter "Kumar" as last name
    And I enter "gaurav.kumar@gmail.com" as email
    And I enter "Abc@1234" as password
    And I confirm the password as "Abc@1234"
    And I click on "Create an Account" button
    Then It should redirect on account page and should see the message "Welcome John Doe!"

  Scenario: Signup with an Existing Email
    Given I am on the signup page
    When I enter "existinguser@gmail.com" as email
    And I enter valid details
    And I click on "Create an Account" button
    Then I should see an error message "There is already an account with this email address"

  Scenario: Signup with an Invalid Email
    Given I am on the signup page
    When I enter an invalid email
    And I enter valid details
    And I click on "Create an Account" button
    Then I should see an error message "Please enter a valid email address"
