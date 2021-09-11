package com.libraryct.steps;

import com.libraryct.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class UserStatusSteps extends CommonMethods{
	int actualNumberOfStatus;
	@When("librarian click Status dropdown")
	public void librarian_click_status_dropdown() {
		click(usersPage.userStatus);
		actualNumberOfStatus=selectDropdownSize(usersPage.userStatus);
		System.out.println("actualNumberOfGroups: "+actualNumberOfStatus);

	}

	@Then("verify there are {int} status options")
	public void verify_there_are_status_options(int expectedNumberOfStatus) {
		Assert.assertEquals(expectedNumberOfStatus, actualNumberOfStatus);
	}

}
