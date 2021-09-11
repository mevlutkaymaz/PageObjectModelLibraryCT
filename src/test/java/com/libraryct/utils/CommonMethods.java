package com.libraryct.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.libraryct.testbase.PageInitializer;


public class CommonMethods extends PageInitializer{
	
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
	public static void clickRadioOrCheckbox(List<WebElement> listElements, String value) {
		String actualValue;
		for(WebElement e:listElements) {
			actualValue=e.getAttribute("value").trim();
			if(e.isEnabled()&&actualValue.equals(value)) {
				e.click();
				break;
			}
				
		}
	}
	
	public int selectDropdownSize(WebElement element) {
		Select select=new Select(element);
		int size=select.getOptions().size();
		return size;
	}
	
	public void selectDropdown(WebElement element, int index) {
		try {
			Select select=new Select(element);
			int size=select.getOptions().size();
			if(size>index) {
				select.selectByIndex(index);
			}
			
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
		
	}
	
	public void selectDropdown(WebElement element, String visibleText) {
		try {
			Select select=new Select(element);
				select.selectByVisibleText(visibleText);
			
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void acceptAlert() {
		try {
			Alert alert=driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void swithToFrame(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void swithToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void swithToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void switchToChildWindow() {
		String mainWindow=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		for(String window:windows) {
			if(!window.equals(mainWindow))
				driver.switchTo().window(window);
		}
	}
		
	public static WebDriverWait getWaitObject() {
		WebDriverWait wait=new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
		return wait;
	}
	
	public static WebElement waitForClickability(WebElement element) {
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static WebElement waitForVisibility(WebElement element) {
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}
	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}
	
	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static JavascriptExecutor getJSObject() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		return js;
		
	}
	
	public static void jsClick(WebElement element) {
		getJSObject().executeScript("arguments[0].click()", element);
	}
	
	public static void scrollToElement(WebElement element) {
		getJSObject().executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public static void scrollDown(int pixel) {
		getJSObject().executeScript("windows.scrollBy(0,-"+pixel+")");
	}
	
	public static void scrollUp(int pixel) {
		getJSObject().executeScript("windows.scrollBy(0,+"+pixel+")");
	}
	public static void selectCalendarDate(List<WebElement> elements, String text) {
		for(WebElement day:elements) {
			if(day.isEnabled()) {
				if(day.getText().equals(text)) {
					day.click();
					break;
				}

			}  
		}
	}
	
	
	public static byte[] takeScreenshot(String filename) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		byte[] picBytes=ts.getScreenshotAs(OutputType.BYTES);
		File file=ts.getScreenshotAs(OutputType.FILE);
		String destination=Constants.SCREENSHOT_PATH+filename+getTimeStamp()+".png";
		try {
			FileUtils.copyFile(file, new File(destination));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return picBytes;
	}

	private static String getTimeStamp() {
		Date date=new Date();
		SimpleDateFormat sp=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		return sp.format(date.getTime());
	}

	
}
