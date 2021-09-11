package com.libraryct.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.libraryct.testbase.BaseClass;

public class BooksPageUser extends BaseClass{
	
	@FindBy(id="book_categories")
	public WebElement bookCategories;
	
	public BooksPageUser() {
		PageFactory.initElements(driver, this);
	}

}
