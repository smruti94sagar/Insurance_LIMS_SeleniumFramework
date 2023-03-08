

package com.LIMS.objectRepository.elements;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author smruti
 *
 */
public class AddClientPage{
	/**
	 * This method is used for dynamic xpath for addclient.
	 */
	private WebDriver driver;

	String clientInformationTextFieldPartialXpath = "//div[@class='col-md-12']/form/input[@name='%s']";
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement addClientSubmitButton;

	private WebElement convertToElement(String partialXpath, String replaceData) {
		String xPath = String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xPath));
	}

	public AddClientPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/**
	 * 
	 * @param clientInformation
	 */
	public void addNewClient(Map<String, String> clientInformation) {
		for (Entry<String, String> keyValue : clientInformation.entrySet()) {
			if (!keyValue.getValue().equals("")) {
				convertToElement(clientInformationTextFieldPartialXpath, keyValue.getKey())
						.sendKeys(keyValue.getValue());
			}
		}
		
		addClientSubmitButton.click();
 
}
	
}
