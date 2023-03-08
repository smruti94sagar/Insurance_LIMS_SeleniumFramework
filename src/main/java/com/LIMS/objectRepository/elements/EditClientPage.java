package com.LIMS.objectRepository.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditClientPage {
	@FindBy(xpath=("//a[text()='CLIENTS']")) private WebElement clientbutton;
	@FindBy(xpath=("//a[@href='clientStatus.php?client_id=1511987599']")) private WebElement addclientstatus;
	@FindBy(xpath=("//a[text()='Edit Client']")) private WebElement editclientbutton;
	
	public EditClientPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void Clickeditclient()
	{
		clientbutton.click();
		addclientstatus.click();
		editclientbutton.click();
	}

}
