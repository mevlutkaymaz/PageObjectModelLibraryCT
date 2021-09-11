package com.libraryct.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.libraryct.testbase.BaseClass;
import com.libraryct.testbase.PageInitializer;

public class MainPageUser extends BaseClass{
	
	@FindBy(xpath="//a[@class='nav-link']")
	public WebElement books;
	
	public MainPageUser() {
		PageFactory.initElements(driver, this);
	}

}
