#Author: Chittaranjan Swain
#Keywords Summary : Automating Add new customer Test feature file, i.e. Customers.feature
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
Feature: Customers
  Adding a new customer to https://admin-demo.nopcommerce.com/

  @tag1
  Scenario: Add a new Customer
    Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then User can view Dashboard
    When User click on customers menu
    And click on customers menu item
    And click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And click on Save button
    Then User can view confirmation message "The new customer has been added successfully."
    And close browser

