package com.LIMS.genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.LIMS.genericUtility.enums.FreameworkConstant;
import com.LIMS.genericUtility.enums.PropertiesFile;
import com.LIMS.genericUtility.reportUtility.ReportUtility;
import com.LIMS.objectRepository.elements.CommonPage;
import com.LIMS.objectRepository.elements.LoginPage;
import com.LIMS.objectRepository.elements.LogoutPage;
import com.aventstack.extentreports.ExtentTest;
import com.beust.jcommander.Parameter;

public class Mainclass extends Baseclass
{
	//general utility key
	
	/**
	 * 
	 * @throws IOException
	 */
	@Parameters(value ="browser")
	@BeforeClass(alwaysRun=true)
	
	public void initialization(@Optional String browser) throws IOException
	{
		//initialization all file
		chart=new CharacteristicUtility(FreameworkConstant.TEST_PROPERTY_FILE_PATH);
		tabl=new TabulationUtility(FreameworkConstant.TEST_EXCEL_FILE_PATH);
		
		select=new SelectUtility();
		wait=new WaitUtility();
		fram=new FrameUtility();
		sel=new SeleniumUtility();
		verify=new VerificationUtility();
		
		//commondata
		if(browser==null|| browser.isBlank()|| browser.isEmpty()|| browser.equals("")) {
			browser=chart.getPropertyData(PropertiesFile.BROWSER);
		}
		this.browser=browser;
		 
		 url=chart.getPropertyData(PropertiesFile.URL);
		 img=chart.getPropertyData(PropertiesFile.IMAGEPATH);
		 time=chart.getPropertyData(PropertiesFile.TIMEOUT);
		 username=chart.getPropertyData(PropertiesFile.USERNAME);
		 password=chart.getPropertyData(PropertiesFile.PASSWORD);
		 driver=sel.launchWebBrowser(browser);
	     jsu=new JavaScriptUtility(driver);	     
	 	sel.getApplication(driver, url);
		Assert.assertTrue(sel.getTitleOfWebPage(driver).equals("Login Page"), "Login page is not open");
		sel.maximiseWindow(driver);
		wait.waitForPageLoad(driver);
		
	}
	/**
	 * 
	 * @throws IOException
	 */
	
	 
	/**
	 * loginapplication
	 */
	@BeforeMethod(alwaysRun=true)
	public void loginApp()
	{
		LoginPage lgp=new LoginPage (driver);
		lgp.LoginAction(username, password);
	}
	/**
	 * logoutapplication
	 */
	@AfterMethod(alwaysRun=true)
	public void logoutApp()
	{
		LogoutPage lp=new LogoutPage(driver);
		lp.LogoutAction(username, password);
	}
	@AfterClass(alwaysRun=true)
	public void Closebrowser()
	{
		sel.closeAllWindow(driver);
	}
	
	

}
