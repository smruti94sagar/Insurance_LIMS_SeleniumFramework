package com.LIMS.genericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumUtility {
	public WebDriver driver;

	
	public SeleniumUtility() {};
	public WebDriver launchWebBrowser(String browser) throws IOException {

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "fireFox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("enter proper key '+browser+'");
			break;
		}
		return driver;

	}
	public void maximiseWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method will maximize the window when its called
	 * @param driver
	 * @return
	 */


	public String getTitleOfWebPage(WebDriver driver)
	{
		String title=driver.getTitle();
		return title;
	}
	/**
	 * This method will fetch the title of the web page
	 * @param driver
	 * @param url
	 */



	public void getApplication(WebDriver driver, String url)
	{
		driver.get(url);
	}
	/**
	 * This method will open the application of browser
	 * @param driver
	 * @return
	 */

	public String getUrlOfWebpage(WebDriver driver)
	{
		String url=driver.getCurrentUrl();
		return url;
	}
	/**
	 * This method will open the application of browser
	 * @param driver
	 * @return
	 */

	public String getSourceCodeOfWebpage(WebDriver driver)
	{
		String code=driver.getPageSource();
		return code;
	}
	/**
	 * This method will fetch the source code of web page
	 * @param driver
	 */

	public void closeMainWindow(WebDriver driver)
	{
		driver.close();
	}
	/**
	 * This method will close only the main window
	 * @param driver
	 */

	public void closeAllWindow(WebDriver driver)
	{
		driver.quit();
	}
	/**
	 * This method will close all the window
	 * @param driver
	 * @param width
	 * @param height
	 */

	public void setSizeOfBrowser(WebDriver driver, int width, int height)
	{
		driver.manage().window().setSize(new Dimension(width, height));
	}
	/**
	 *This method will customize the width and height of browser
	 * @param driver
	 * @param x
	 * @param y
	 */

	// This method will customize the x and y co-ordinate of browser

	public void setPositionOfBrowser(WebDriver driver, int x, int y)
	{
		driver.manage().window().setPosition(new Point(x, y));
	}
	/**
	 * This method will customize the x and y co-ordinate of browser
	 * @param element
	 */



	public void clearElement(WebElement element)
	{
		element.clear();
	}
	/**
	 * 
	 This method will remove the value present in web element
	 * @param element
	 * @return
	 */



	public String getTagNameOfElement(WebElement element)
	{
		return element.getTagName();
	}
	/**
	 * This method will return tag name of web element
	 * @param driver
	 */

	
	Robot r;
	public void pressEnterKey()
	{
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 *  This method will take screenshot and save it in screenshot folder
	 * @param driver
	 * @param screenShotName
	 * @return
	 */

	public String taketheScreenShot(WebDriver driver, String screenShotName)
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File(".\\ScreenShot\\"+screenShotName+".png");
		try {
			Files.copy(src, trg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return trg.getAbsolutePath(); //used for extent reports
	}
	public String taketheScreenShot() {
		TakesScreenshot ts= (TakesScreenshot) driver;
	String path = ts.getScreenshotAs(OutputType.BASE64);
	return path;
		
		
	}

	/**
	 * This method will switch to window based on partial window title
	 * @param driver
	 * @param partialWinTitle
	 */

	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		Set<String> allWindows=driver.getWindowHandles();
		for(String indWindow:allWindows)
		{
			String currentWinTitle = driver.switchTo().window(indWindow).getTitle();
			if(currentWinTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}

	/**
	 * This method will handle notifications popup
	 * @param driver
	 */

	public void notificationPopup(WebDriver driver)
	{
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
	}
}















