package com.libraryct.steps;

import com.libraryct.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LogoutSteps extends CommonMethods{
	
	@When("user click username on the right top corner")
	public void user_click_username_on_the_right_top_corner() {
		click(mainPage.profile);
	}

	@When("user click Log Out")
	public void user_click_log_out() {
		click(mainPage.logout);
		wait(2);
	}

	@Then("verify user navigate back to login page.")
	public void verify_user_navigate_back_to_login_page() {
		String expectedVal="https://library2.cybertekschool.com/login.html";
		String actualVal=driver.getCurrentUrl();
		System.out.println("Actual Value: "+actualVal);
		Assert.assertEquals(expectedVal, actualVal);
	}

}
