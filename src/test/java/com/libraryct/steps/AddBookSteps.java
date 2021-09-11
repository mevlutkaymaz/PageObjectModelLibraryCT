package com.libraryct.steps;

import com.libraryct.utils.CommonMethods;
import com.libraryct.utils.ConfigsReader;
import com.libraryct.utils.Constants;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddBookSteps extends CommonMethods{
	
	static int numberOfBooks;
		
	@Given("librarian is successfully logged in")
	public void librarian_is_successfully_logged_in() {
		ConfigsReader.readProperties(Constants.CONFIG_FILE_PATH);
		sendText(logginPage.userName, ConfigsReader.getProperty("username_librarian"));
		ConfigsReader.readProperties(Constants.CONFIG_FILE_PATH);
		sendText(logginPage.password, ConfigsReader.getProperty("password_librarian"));
		click(logginPage.loginBtn);
		click(mainPage.dashboard);
		wait(2);
		numberOfBooks=Integer.parseInt(mainPage.numberOfBooks.getText());
	}
	@When("librarian click Books module")
	public void librarian_click_books_module() {
	    click(mainPage.books);
	}
	@When("librarian click Add Book button")
	public void librarian_click_add_book_button() {
	    click(mainPage.addBook);
	}
	@When("librarian enter {string}, {string}, {string}, {string}, and {string}")
	public void librarian_enter_and(String name, String isbn, String year, String author, String description) {
		sendText(addBookPage.name, name);
		sendText(addBookPage.isbn, isbn);
		sendText(addBookPage.year, year);
		sendText(addBookPage.author, author);
		sendText(addBookPage.description, description);
	}
	@When("librarian click save changes")
	public void librarian_click_save_changes() {
	    click(addBookPage.submitBtn);
	    wait(2);
	    
	}
	@Then("verify a new book is added {string}")
	public void verify_a_new_book_is_added(String ISBN) {	    
	    String newbookISBN=addBookPage.firstRow.getText();
	    if(newbookISBN.equals(ISBN)) {
	    	System.err.println("User is created");
	    	Hooks.scenario.log("User is created");
	    }
	}

}
