@newbook
Feature: Adding New Book Functionality
  I will be using this file to test adding new book functionality of LibraryCT
  
  Background:
	Given librarian is successfully logged in
	
  Scenario Outline: Add new book
    When librarian click Books module
    And librarian click Add Book button
    When librarian enter "<BookName>", "<ISBN>", "<Year>", "<Author>", and "<Description>"
    And librarian click save changes
    Then verify a new book is added "<ISBN>"
    
    Examples:
    |BookName|ISBN|Year|Author|Description|
    |test1|1234567890|2021|unknown|horror|
    |test2|9876543210|2021|unknown|horror|
    