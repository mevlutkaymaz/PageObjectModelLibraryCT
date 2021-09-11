package com.libraryct.steps;

import com.libraryct.steps.Hooks;
import com.libraryct.utils.CommonMethods;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddUserSteps extends CommonMethods{
	
	@When("librarian click Users module")
	public void librarian_click_users_module() {
	    System.out.println("Hell0---------------");
	    click(mainPage.users);
	}

	@When("librarian click Add User button")
	public void librarian_click_add_user_button() {
	    click(usersPage.addUser);
	}

	@When("librarian enter {string}, {string}, {string} and {string}")
	public void librarian_enter_full_name_password_email_and_address(String fullname, String password, String email, String address) {
		sendText(addUserPage.full_name, fullname);
		sendText(addUserPage.password, password);
		sendText(addUserPage.email, email);
		sendText(addUserPage.address, address);
	}

	@Then("verify a new user {string} is created")
	public void verify_a_new_user_is_created(String email) {
	    String newUserEamil=addUserPage.firstRow.getText();
	    if(newUserEamil.equals(email)) {
	    	System.err.println("User is created");
	    	Hooks.scenario.log("User is created");
	    }
	}

}
