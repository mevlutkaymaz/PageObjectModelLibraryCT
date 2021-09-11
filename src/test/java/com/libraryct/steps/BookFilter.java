package com.libraryct.steps;

import org.junit.Assert;

import com.libraryct.utils.CommonMethods;
import com.libraryct.utils.ConfigsReader;
import com.libraryct.utils.Constants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookFilter extends CommonMethods{
	
	int actualNumberOfCategories;
	
	@Given("user is successfully logged in")
	public void user_is_successfully_logged_in() {
		ConfigsReader.readProperties(Constants.CONFIG_FILE_PATH);
		sendText(logginPage.userName, ConfigsReader.getProperty("username_user"));
		ConfigsReader.readProperties(Constants.CONFIG_FILE_PATH);
		sendText(logginPage.password, ConfigsReader.getProperty("password_user"));
		click(logginPage.loginBtn);
	}
	
	@When("user click Books module")
	public void user_click_books_module() {
		click(mainPageUser.books);

	}

	@When("user click book category dropdown")
	public void user_click_book_category_dropdown() {
		click(booksPageUser.bookCategories);
		actualNumberOfCategories=selectDropdownSize(booksPageUser.bookCategories);
		System.out.println("actualNumberOfCategories: "+actualNumberOfCategories);
	}

	@Then("verify there are {int} options")
	public void verify_there_are_options(int exptectedNumberOfCategories) {
		Assert.assertEquals(exptectedNumberOfCategories, actualNumberOfCategories);
	}

	@Then("verify user is able to selected the {string} option")
	public void verify_user_is_able_to_selected_the_option(String bookCategory) {
		selectDropdown(booksPageUser.bookCategories, bookCategory);
		String actualValue=booksPageUser.bookCategories.getText();
		Assert.assertEquals(true, actualValue.contains(bookCategory));
	}

}
