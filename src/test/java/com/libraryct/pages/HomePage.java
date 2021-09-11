package com.libraryct.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.libraryct.testbase.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath="//div[@class='text-center mb-4']")
	public WebElement homePageIcon;

}
