package com.LIMS.objectRepository.elements;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPaymentPage {
	
    private WebDriver driver;
	String clientInformationTextFieldPartialXpath = "//div[@class='col-md-12']/form/input[@name='%s']";
	@FindBy(xpath = ("//input[@type='submit']")) private WebElement paymentsubmitbutton;

	
	
	private WebElement convertToElement(String partialXpath, String replaceData) {
		String xPath = String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xPath));
}
	public AddPaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

}
	public void addNewPayment(Map<String, String> clientInformation) 
	{
		for (Entry<String, String> keyValue : clientInformation.entrySet()) 
		{
			if (!keyValue.getValue().equals("")) {
				convertToElement(clientInformationTextFieldPartialXpath, keyValue.getKey())
						.sendKeys(keyValue.getValue());
			}
		}
		paymentsubmitbutton.click();
	}
}
