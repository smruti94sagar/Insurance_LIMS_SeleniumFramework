package com.LIMS.objectRepository.elements;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNomineePage {
	private WebDriver driver;
	String nomineeinformationpartialxpath="//input[@name='%s']";
	@FindBy(xpath=("//input[@type='submit']")) private WebElement clicksubmit;
	private WebElement convertToElement(String partialXpath, String replaceData) {
		String xPath = String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xPath));
}
	public AddNomineePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

}
	public void addNominee(Map<String, String> clientInformation) 
	{
		for (Entry<String, String> keyValue : clientInformation.entrySet()) 
		{
			if (!keyValue.getValue().equals("")) {
				convertToElement(nomineeinformationpartialxpath, keyValue.getKey())
						.sendKeys(keyValue.getValue());
			}
		}
		clicksubmit.click();
	}

}
