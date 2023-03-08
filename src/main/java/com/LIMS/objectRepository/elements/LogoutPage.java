package com.LIMS.objectRepository.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	@FindBy(xpath=("//a[contains(@class,'btn')]")) private WebElement logoutbutton;
	
	public LogoutPage(WebDriver driver)
	{
	  PageFactory.initElements(driver, this);
   }
	public void LogoutAction( String username,String password )
	{
		 
		logoutbutton.click();
	}

}
