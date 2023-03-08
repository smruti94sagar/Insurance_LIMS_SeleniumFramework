package com.LIMS.objectRepository.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickAddClientPage {
	@FindBy(xpath=("//a[text()='CLIENTS']")) private WebElement clientbutton;
	@FindBy(xpath=("//a[text()='Add Client']")) private WebElement addclientbutton;
	@FindBy(xpath=("//a[@href='clientStatus.php?client_id=1511987599']")) private WebElement addclientstatus;
	@FindBy(xpath=("//a[text()='Add Payment']")) private WebElement addpayment;
	
	public ClickAddClientPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void AddClient()
	{
		clientbutton.click();
		addclientbutton.click();
	}
	public void Clickclientsts()
	{
		clientbutton.click();
		addclientstatus.click();
		addpayment.click();
		
	}
	

}
