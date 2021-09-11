@AddNewUser
Feature: Adding New User Functionality
  I will be using this file to test adding new user functionality of LibraryCT
Background:
	Given librarian is successfully logged in
Scenario Outline: 
	When librarian click Users module 
	And librarian click Add User button  
	When librarian enter "<fullname>", "<password>", "<email>" and "<address>" 
	And librarian click save changes 
	Then verify a new user "<email>" is created 			
			
Examples:
	|fullname|password|email|address|
	|StudentTest224|aserdew2342|224@gmail.com|unknown|
	|StudentTest225|aserdew2342|225@gmail.com|unknown|
	    