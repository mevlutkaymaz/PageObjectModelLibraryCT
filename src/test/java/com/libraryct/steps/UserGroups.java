package com.libraryct.steps;

import com.libraryct.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class UserGroups extends CommonMethods{
	int actualNumberOfGroups;
	
	@When("librarian click user group dropdown")
	public void librarian_click_user_group_dropdown() {
		click(usersPage.userGroups);
		actualNumberOfGroups=selectDropdownSize(usersPage.userGroups);
		System.out.println("actualNumberOfGroups: "+actualNumberOfGroups);
		
	}

	@Then("verify librarian have {int} options")
	public void verify_librarian_have_options(int expectedNumberOfGroups) {
		Assert.assertEquals(expectedNumberOfGroups, actualNumberOfGroups);
	}

}
