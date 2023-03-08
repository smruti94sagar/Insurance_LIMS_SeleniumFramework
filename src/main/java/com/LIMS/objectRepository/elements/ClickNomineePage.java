package com.LIMS.objectRepository.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickNomineePage {
	@FindBy(xpath=("//a[text()='NOMINEE']")) private  WebElement nomineebutton;
	@FindBy(xpath=("//a[@class='btn']")) private  WebElement addnomineebutton;

	
public ClickNomineePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);}

 
public void clicknominee()
{
	nomineebutton.click();
	addnomineebutton.click();
}
}