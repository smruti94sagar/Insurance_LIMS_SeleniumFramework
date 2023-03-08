package com.LIMS.genericUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 * This method will wait for entire page to load for 20 seconds
	 * @param driver
	 * @param element
	 */



	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	/**
	 * This method is use to wait for element to be visible
	 * @param driver
	 * @param element
	 */



	public void waitElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	/**
	 * This method will wait for element to be clickable
	 * @param driver
	 * @param element
	 */

	public void waitForElementToBeSelected(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	/**
	 * This method will wait for element to be selected
	 * @param driver
	 * @param element
	 * @param text
	 */



	public void waitForTextToBePresentInElement(WebDriver driver, WebElement element, String text)
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	/**
	 * This method will wait for the text to be present in element
	 * @param element
	 * @param index
	 */
	
	
   public void waitTillClick(long pollingTime,int duration,WebElement element)
   {
	   int count=0;
	   while(count<duration)
	   {
		   try {
			   element.click();
			   break;
		   }
		   catch(Exception e)
		   {
			 try {
				Thread.sleep(pollingTime);
			} catch (InterruptedException e1) {
			
				e1.printStackTrace();
			}
			 count=count+((int)pollingTime/1000);
		   }
	   }
   }

}
