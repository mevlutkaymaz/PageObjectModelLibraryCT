package com.libraryct.steps;

import com.libraryct.utils.CommonMethods;
import com.libraryct.utils.ConfigsReader;
import com.libraryct.utils.Constants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LoginSteps extends CommonMethods {

	@Then("verify that the title is {string}")
	public void verify_that_the_title_is(String exptectedTitle) {
	    String actualTitle=driver.getTitle();
	    Assert.assertEquals(exptectedTitle, actualTitle);
	}
	
	@When("librarian enters valid {string} and {string}")
	public void librarian_enters_valid_and(String string, String string2) {
		ConfigsReader.readProperties(Constants.CONFIG_FILE_PATH);
		sendText(logginPage.userName, ConfigsReader.getProperty("username_librarian"));
		ConfigsReader.readProperties(Constants.CONFIG_FILE_PATH);
		sendText(logginPage.password, ConfigsReader.getProperty("password_librarian"));
	}
	@When("{string} click sign in button")
	public void librarian_click_sign_in_button(String click) {
		click(logginPage.loginBtn);
		wait(2);
	}
	@Then("verify that there are \"{int}\" modules the page")
	public void verify_that_there_are_modules_the_page(int exptectedNumOfModules) {
		int actualNubOfModules=mainPage.modules.size();
		for(int i=0;i<actualNubOfModules;i++)
			System.out.println("-------------"+mainPage.modules.get(i).getText());
		Assert.assertEquals(exptectedNumOfModules, actualNubOfModules);
	}
	
	@Then("verify that the {string}")
	public void verify_that_the(String url) {
		String actualUrl=driver.getCurrentUrl();
		Assert.assertEquals(url, actualUrl);
	}
	@When("student enters valid {string} and {string}")
	public void student_enters_valid_and(String username, String password) {
		ConfigsReader.readProperties(Constants.CONFIG_FILE_PATH);
		sendText(logginPage.userName, ConfigsReader.getProperty("username_user"));
		ConfigsReader.readProperties(Constants.CONFIG_FILE_PATH);
		sendText(logginPage.password, ConfigsReader.getProperty("password_user"));
	}
	@When("user enters invalid {string}, {string}")
	public void user_enters_invalid_or(String username, String password) {
		System.out.println("Username: "+username);
		System.out.println("Password: "+password);
		sendText(logginPage.userName, username);
		sendText(logginPage.password, password);
	}
	
	@Then("verify the error message {string}")
	public void verify_the_error_message(String exptectedMsg) {
		String actualMsg=logginPage.errorMsg.getText();
		Assert.assertEquals(exptectedMsg, actualMsg);
	}
}
