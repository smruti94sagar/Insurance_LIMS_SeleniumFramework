package com.LIMS.genericUtility;

import org.openqa.selenium.WebDriver;

import com.LIMS.genericUtility.reportUtility.ReportUtility;
import com.LIMS.objectRepository.elements.CommonPage;
import com.aventstack.extentreports.ExtentTest;

public class Baseclass {
	protected CharacteristicUtility chart;
	protected TabulationUtility tabl;
	public  SeleniumUtility sel;
	protected ActionUtility  actionutility;
	protected FrameUtility   fram;
	public JavaScriptUtility jsu;
	protected WaitUtility wait;
	protected SelectUtility select;
	protected VerificationUtility verify;
	public ExtentTest test;
	protected ReportUtility report;
	
	
	//commondata key
	protected String browser;
	protected String url;
	protected String img;
	protected String time;
	protected String username;
	protected String password;
	
	
	//after browser initiallization key
	protected WebDriver driver;
	protected CommonPage commonpager;

}
