package com.LIMS.objectRepository.elements;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	
	public LoginPage(WebDriver driver)
	{
	  PageFactory.initElements(driver, this);
   }
	@FindBy(name=("username")) private WebElement nameTextField;
	@FindBy(name=("password")) private WebElement passwordTextField;
	@FindBy(xpath=("//button[text()='login']")) private WebElement loginButton;

	
	public void LoginAction( String username,String password )
	{
		 nameTextField.sendKeys(username);
		 passwordTextField.sendKeys(password);
		 loginButton.click();
	}
}

