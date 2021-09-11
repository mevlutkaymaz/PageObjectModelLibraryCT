@login
Feature: Login Functionality
  I will be using this file to test login functionality of LibraryCT
  @AC1
  Scenario:Login functionality of LibraryCT Application Test-1
    Then verify that the title is "Login - Library"
    When librarian enters valid "email address" and "password"
    And "librarian" click sign in button
    Then verify that there are "3" modules the page
  @AC2
  Scenario:Login functionality of LibraryCT Application Test-2
    Then verify that the "https://library2.cybertekschool.com/login.html"
    When student enters valid "email address" and "password"
    And "student" click sign in button
    Then verify that there are "2" modules the page
  @AC3
  Scenario Outline: Login functionality of LibraryCT Application Test-3
    When user enters invalid "<email_addres>", "<password>"
    And "student" click sign in button
    Then verify the error message "Sorry, Wrong Email or Password"
    
    Examples:
    |   email_addres    |password|
    |asdfasd@library|asdfasd@|
    |asdfasd@library|asdfasd@|