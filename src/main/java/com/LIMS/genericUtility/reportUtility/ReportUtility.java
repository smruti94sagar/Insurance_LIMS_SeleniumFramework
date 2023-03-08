package com.LIMS.genericUtility.reportUtility;

import java.io.IOException;

import com.LIMS.genericUtility.CharacteristicUtility;
import com.LIMS.genericUtility.JavaUtility;
import com.LIMS.genericUtility.UtilityInstanceTranfer;
import com.LIMS.genericUtility.enums.FreameworkConstant;
import com.LIMS.genericUtility.enums.PropertiesFile;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * 
 * @author smruti
 *
 */
public class ReportUtility {
	private ExtentReports report;
	public ReportUtility() {
		init();
	}
	//String filePath,String title,String reportName,String browserName
	/**
	 * 
	 */
	public void init()
	{
		CharacteristicUtility chart=null;
		try {
			  chart=new CharacteristicUtility(FreameworkConstant.EXTENT_REPORT_PROPERTYFILE);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		String overrideOrNot=chart.getPropertyData(PropertiesFile.OVERRIDEREPORT);
		String rendomName="";
		if(overrideOrNot.equalsIgnoreCase("yes")) {
			  rendomName= "_"+new JavaUtility().getSimpleDateFormate();
		}
		 
		ExtentSparkReporter spark=new ExtentSparkReporter(FreameworkConstant.EXTENT_REPORT_PATH+"extentreport"+rendomName+".html");
		spark.config().setDocumentTitle(chart.getPropertyData(PropertiesFile.EXTENTREPORTTITILE));
		spark.config().setReportName(chart.getPropertyData(PropertiesFile.EXTENETREPORTNAME));
	    spark.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser", chart.getPropertyData(PropertiesFile.BROWSER));
		report.setSystemInfo("os", System.getProperty("os.name"));
		
		
	}
	/**
	 * 
	 * @param testName
	 */
	
	public void createTest(String testName)
	{
		ExtentTest test=report.createTest(testName);
		UtilityInstanceTranfer.setExtentTest(test);
	}
	/**
	 * 
	 * @param test
	 * @param message
	 */
	public void fail(ExtentTest test,String message)
	{
		test.fail(message);
		
	}
	/**
	 * 
	 * @param test
	 * @param message
	 */
	
	public void addauthor(ExtentTest test,String...message)
	{
		test.assignAuthor(message);
	}
	/**
	 * 
	 * @param test
	 * @param errormessage
	 */
	public void fail(ExtentTest test,Throwable errormessage)
	{
		test.fail(errormessage);
		System.out.println(errormessage);
	}
	/**
	 * 
	 * @param test
	 * @param message
	 */
	public void pass(ExtentTest test,String message)
	{
		test.pass(message);
	}
	/**
	 * 
	 * @param test
	 * @param masg
	 * @param errMsg
	 */
	
	public void skip(ExtentTest test,String masg,Throwable errMsg)
	{
		test.fail(masg);

		test.fail(errMsg);
	}
	/**
	 * 
	 * @param test
	 * @param message
	 */
	public void warn(ExtentTest test,String message)
	{
		test.warning(message);
		System.out.println(message);
	}
	/**
	 * 
	 * @param test
	 * @param message
	 */
	public void info(ExtentTest test,String message)
	{
		test.info(message);
		System.out.println(message);
	}
	/**
	 * 
	 * @param test
	 * @param screenshotpath
	 * @param title
	 * @param strategy
	 */
	public void attachScreenshot(ExtentTest test,String screenshotpath,String title,String strategy)
	{
		if(strategy.equalsIgnoreCase("base64"))
		{
			test.addScreenCaptureFromBase64String(screenshotpath,title);
		}
		else
		{
			test.addScreenCaptureFromPath(screenshotpath,title);
		}
	}
	/**
	 * 
	 */
	public void saveReport()
	{
		report.flush();
	}
	
	

}
