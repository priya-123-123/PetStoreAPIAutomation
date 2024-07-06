#Author: your.email@your.domain.com
#Keywords Summary :
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
Feature: Test Pet APIs
  This Feature file tests all Pet APIs
  
Background:
		Given valid base url is defined

  @smoke
  Scenario: Add single pet
    Given valid endpoints to add a new pet 
    And header key is known for authentication
    And valid pet data available in required format
    When post request is sent to server with data
    Then Validate the status code to be "200" 
    And Validate the content type as "application/json"
    And Validate response values matching with input data
    
  @smoke
  Scenario: Get pet details by id
    Given valid endpoints to get pet details using id
    And header key is known for authentication
    When get request is sent to server with id
    Then Validate the status code to be "200" for get pet details
    And Validate the content type as "application/json" for get pet details
    And Validate response values matching with expected data
    
  @smoke
  Scenario: Find pet details by status
    Given valid endpoints to find pet details using status
    And header key is known for authentication
    When get request is sent to server with status
    Then Validate the status code to be "200" for get pet details by status
    And Validate the content type as "application/json" for get pet details by status
    And Validate response values matching with expected status
    
  @smoke
  Scenario: Add  pet a image to existing pet or create new pet if pet id is not present 
    Given valid endpoints to add a image to existing pet or create new pet if pet id is not present 
    And valid pet data for image and additional meta data is available in required format
    When post request is sent to server with image data
    Then Validate the status code to be "200"  in post pet image details
    And Validate the content type as "application/json" in post image details
    And Validate response metadata value matching with input data
    
  @sanity
  Scenario: Update existing pet using put method, if Pet ID exists then pet details should be updated.
  	Given valid endpoints to update pet details 
  	And Authorisation is added in header
  	And valid pet data is available to update
  	When Put request is sent to the server
  	Then Validate the status code to be "200" for put update request
  	And Validate the content type as "application/json" in put request
  	And Validate response metadata value matching with input data in put request
  	
  @sanity
  Scenario: Update pet in the store with the form details using post 
  	Given valid end points to update pet status and name
  	And  Authorisation is added in header
  	And Valid pet data is available to update pet name and status
  	When Post request is sent to the server
  	Then Validate the status code to be "200" for post update request
  	And Validate the content type as "application/json" in post update request
  	And Validate response metadata value matching with input data in post update request
  	
  @sanity @delete
  Scenario: Delete the pet based on id
  	Given valid endpoints to delete  pet details 
  	And Authorisation is added in header for deleting pet 
  	When Delete request is sent to server
  	Then Element should be successfully deleted from the server with status code as "200"
  	And Validate the content type as "application/json" in delete response
  	And Validate response content
  	


  	
  

    

  
		
    
