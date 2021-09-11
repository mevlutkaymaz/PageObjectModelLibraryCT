package com.libraryct.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.libraryct.testbase.BaseClass;

public class AddBookPage extends BaseClass{
	
	@FindBy(name="name")
	public WebElement name;
	
	@FindBy(name="isbn")
	public WebElement isbn;
	
	@FindBy(name="year")
	public WebElement year;
	
	@FindBy(xpath="//input[@name='author']")
	public WebElement author;
	
	@FindBy(xpath="//textarea[@name='description']")
	public WebElement description;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	public WebElement submitBtn;
	
	@FindBy(xpath="//tr[@role='row'][1]//td[2]")
	public WebElement firstRow;
	
	
	public AddBookPage() {
		PageFactory.initElements(driver, this);
	}

}
