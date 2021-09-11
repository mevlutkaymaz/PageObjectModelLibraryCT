package com.libraryct.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.libraryct.utils.ConfigsReader;
import com.libraryct.utils.Constants;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static WebDriver setUp() {
		ConfigsReader.readProperties(Constants.CONFIG_FILE_PATH);
		if(ConfigsReader.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",Constants.CHROM_DRIVER_PATH);
			driver=new ChromeDriver();
		}
		else if(ConfigsReader.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.driver",Constants.GECKO_DRIVER_PATH);
			driver=new FirefoxDriver();
		}
		else
			throw new RuntimeException("not a proper browser name");
		
		
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ConfigsReader.getProperty("url"));
		
		PageInitializer.initializer();
		return driver;
		
	}
	
	public static void quit() {
		if(driver!=null)
			driver.quit();
	}

}
