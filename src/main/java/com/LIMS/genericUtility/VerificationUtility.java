package com.LIMS.genericUtility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificationUtility {
	public void exactverifiaction(String actResult, String expResult, String strategy,
			String paegNameorTCNameorWebelement) {
		if (strategy.equalsIgnoreCase("Tc")) {
			if (actResult.equals(expResult)) {
				System.out.println(paegNameorTCNameorWebelement + "TC is pass");
			} else {
				System.out.println(paegNameorTCNameorWebelement + "TC is fail");
			}
		} else if (strategy.equalsIgnoreCase("page")) {
			if (actResult.equals(expResult)) {
				System.out.println(paegNameorTCNameorWebelement + "Page is Displayed");
			} else {
				System.out.println(paegNameorTCNameorWebelement + "Page is not Displayed");
			}
		} else if (strategy.equalsIgnoreCase("webElement")) {
			if (actResult.equals(expResult)) {
				System.out.println(paegNameorTCNameorWebelement + "webElement is showing");
			} else {
				System.out.println(paegNameorTCNameorWebelement + "webElement is not showing");
			}
		}
	}

	/**
	 * 
	 * @param actResult
	 * @param expResult
	 * @param strategy
	 * @param PageNameorTCName
	 */

	public void partialverification(String actResult, String expResult, String strategy, String PageNameorTCName) {
		if (strategy.equalsIgnoreCase("TC")) {
			if (actResult.contains(expResult)) {
				System.out.println(PageNameorTCName + "TC is pass");
			} else {
				System.out.println(PageNameorTCName + "TC is fail");
			}
		} else if (strategy.equalsIgnoreCase("page")) {
			if (actResult.contains(expResult)) {
				System.out.println(PageNameorTCName + "Page is Displayed");
			} else {
				System.out.println(PageNameorTCName + "Page is Not Displyed");
			}
		} else if (strategy.equalsIgnoreCase("webElement")) {
			if (actResult.contains(expResult)) {
				System.out.println(PageNameorTCName + "webElement is Displayed");
			} else {
				System.out.println(PageNameorTCName + "webElement is Not Displyed");
			}
		}

	}

	/**
	 * 
	 * @param actual
	 * @param expected
	 * @param strategy
	 * @param PageNameorTCNameorElementName
	 */

	public void exactverify(String actual, String expected, String strategy, String PageNameorTCNameorElementName) {
		String pass = "";
		String fail = "";
		switch (strategy.toUpperCase()) {
		case "TC":
			pass = "TC is pass";
			fail = "TC is fail";
			break;

		case "PAGE":
			pass = "PAGE is pass";
			fail = "PAGE is fail";
			break;

		case "ELEMENT":
			pass = "ELEMENT is pass";
			fail = "ELEMENT is fail";
			break;
		default:
			break;
		}
		if (actual.equals(expected)) {
			System.out.println(PageNameorTCNameorElementName + pass);
		} else {
			System.out.println(PageNameorTCNameorElementName + fail);
		}

	}
	
	

}
