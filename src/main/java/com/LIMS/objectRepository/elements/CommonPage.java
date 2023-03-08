package com.LIMS.objectRepository.elements;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {
	private WebDriver driver;
	/**
	 * 
	 */
	//declaration
	private String clientpartialxpath="//a[text()='%s']";
	
	private WebElement converTokey(String clientpartialxpath,String replacekey)
	{
		String xpath=String.format(clientpartialxpath, replacekey);
		return driver.findElement(By.xpath(xpath));
		
	}
	public CommonPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void setDataIntoclient(Map<String,String>clientInformation)
	{
		for(Entry<String,String> keyValue:clientInformation.entrySet())
		{
			converTokey(clientpartialxpath,keyValue.getKey()).sendKeys(keyValue.getValue());
		}
	}

}

