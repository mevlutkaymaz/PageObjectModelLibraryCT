@groups
Feature: Logout
  I want to test user groups functionality of Library 
		
  @AC1
  Scenario: User Groups of LibraryCT
  	Given librarian is successfully logged in 
		When librarian click Users module 
		And librarian click user group dropdown
		Then verify librarian have 3 options 