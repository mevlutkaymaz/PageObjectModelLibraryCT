package com.libraryct.testbase;

import com.libraryct.pages.AddBookPage;
import com.libraryct.pages.AddUserPage;
import com.libraryct.pages.BooksPageUser;
import com.libraryct.pages.HomePage;
import com.libraryct.pages.LogginPage;
import com.libraryct.pages.MainPage;
import com.libraryct.pages.MainPageUser;
import com.libraryct.pages.UsersPage;

public class PageInitializer extends BaseClass {

	public static LogginPage logginPage;
	public static AddBookPage addBookPage;
	public static MainPage mainPage;
	public static AddUserPage addUserPage;
	public static UsersPage usersPage;
	public static HomePage homePage;
	public static MainPageUser mainPageUser;
	public static BooksPageUser booksPageUser;

	public static void initializer() {
		mainPage = new MainPage();
		logginPage=new LogginPage();
		addBookPage=new AddBookPage();
		addUserPage=new AddUserPage();
		usersPage=new UsersPage();
		homePage=new HomePage();
		mainPageUser=new MainPageUser();
		booksPageUser=new BooksPageUser();
		

	}

}
