package com.libraryct.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.libraryct.testbase.BaseClass;

public class LogginPage extends BaseClass{
	
	
	
	@FindBy(id="inputEmail")
	public WebElement userName;
	@FindBy(id="inputPassword")
	public WebElement password;
	@FindBy(xpath="//button[@class='btn btn-lg btn-primary btn-block']")
	public WebElement loginBtn;
	@FindBy(xpath="//div[@class='mb-4']")
	public WebElement errorMsg;
	@FindBy(xpath="//title")
	public WebElement title;
	
	
	public LogginPage() {
		PageFactory.initElements(driver, this);
	}

}
