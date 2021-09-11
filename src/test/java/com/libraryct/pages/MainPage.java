package com.libraryct.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.libraryct.testbase.BaseClass;

public class MainPage extends BaseClass{
		
	@FindBy(xpath = "//li[@class='nav-item']")
	public List<WebElement> modules;
	
	@FindBy(xpath="//li[@class='nav-item'][3]")
	public WebElement books;
	
	@FindBy(xpath="//a[@class='btn btn-lg btn-outline btn-primary btn-sm add_book_btn']")
	public WebElement addBook;
	
	@FindBy(xpath="//li[@class='nav-item'][1]")
	public WebElement dashboard;
	
	@FindBy(xpath="//h2[@id='book_count']")
	public WebElement numberOfBooks;
	
	@FindBy(xpath="//li[@class='nav-item'][2]")
	public WebElement users;
	
	@FindBy(id="navbarDropdown")
	public WebElement profile;
	
	@FindBy(xpath="//a[@class='dropdown-item']")
	public WebElement logout;
	
	
	
	public MainPage() {
		PageFactory.initElements(driver, this);
	}
	

}
