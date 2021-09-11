package com.libraryct.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.libraryct.testbase.BaseClass;

public class AddUserPage extends BaseClass {
	
	@FindBy(name="full_name")
	public WebElement full_name;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(name="email")
	public WebElement email;
	
	@FindBy(name="address")
	public WebElement address;
	
	@FindBy(xpath="//tr[@role='row'][1]//td[4]")
	public WebElement firstRow;
	
		
	public AddUserPage() {
		PageFactory.initElements(driver, this);
	}

}
