@logout
Feature: Logout
  I want to test logout feature of Library 
		
  @AC1
  Scenario: Logout of LibraryCT
  	Given librarian is successfully logged in
		When user click username on the right top corner 
		And user click Log Out  
		Then verify user navigate back to login page.