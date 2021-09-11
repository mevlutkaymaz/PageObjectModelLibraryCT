@filter
Feature: Book Filter
  I want to test book filter categories of LibraryCT 
	
	Background:
		Given user is successfully logged in
		When user click Books module 
		
  @AC1
  Scenario: Book Filter of LibraryCT
		And user click book category dropdown
		Then verify there are 21 options
		
	@AC2
	Scenario: Book Filter of LibraryCT of selection an specific option
	And user click book category dropdown
	Then verify user is able to selected the 'Drama' option