#Author: Chittaranjan Swain
#Keywords Summary :I want to login into https://admin-demo.nopcommerce.com/
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Login
  I want to login into https://admin-demo.nopcommerce.com/

@tag1
Scenario: Successful Login with Valid Credentials 
    Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out Link 
    Then Page Title should be "Your store. Login"
    And close browser
    
    
Scenario Outline: Successful Login with Valid Credentials with multiple users
    Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/"
    And User enters email as "<Email>" and password as "<Password>"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out Link 
    Then Page Title should be "Your store. Login"
    And close browser

Examples:
|Email|Password|
|admin@yourstore.com|admin|
|admin1@yourstore.com|admin1|

		
    