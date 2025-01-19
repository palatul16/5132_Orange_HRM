Feature: Login Functionality for OrangeHRM website
  As a user of the OrangeHRM website
  I want to be able to login with my account
  So that I can access my account related and manage my orders
  
  Background:
    Given I am on the OrangeHRM login page
    
  Scenario: Successful login with valid credentials
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully
    
    
  Scenario: Unsuccessful login with invalid credentials
    Given I have entered invalid "<username>" and "<password>"
    When I click on the login button
    Then I should see a error message indicating "<error_message>"
    
    
    Examples:
      | username      | password | error_message                                       |
      | abc@gmail.com | abc123   | Warning: No match for Email address and/or Password |
      | xyz@gmail.com | xyz123   | Warning: No match for Email address and/or Password |
      
      
  Scenario: Navigating to the forgotten password page
    When I click on the "Forgotten Password" link
    Then I should be redirected to the password reset page

