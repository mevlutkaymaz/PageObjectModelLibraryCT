package com.libraryct.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.libraryct.testbase.BaseClass;

public class UsersPage extends BaseClass{
	
	@FindBy(xpath="//a[@class='btn btn-lg btn-outline btn-primary btn-sm']")
	public WebElement addUser;
	
	@FindBy(id="user_groups")
	public WebElement userGroups;
	
	@FindBy(id="user_status")
	public WebElement userStatus;
	
	public UsersPage() {
		PageFactory.initElements(driver, this);
	}

}
