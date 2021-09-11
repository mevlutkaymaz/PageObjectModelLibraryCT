@userstatus
Feature: userstatus
  I want to test user status fucntinality of Library 
		
  @AC1
  Scenario: User Status of LibraryCT
  	Given librarian is successfully logged in 
		When librarian click Users module 
		And librarian click Status dropdown
		Then verify there are 2 status options