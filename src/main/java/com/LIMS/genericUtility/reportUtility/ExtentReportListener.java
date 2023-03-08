package com.LIMS.genericUtility.reportUtility;

 

import org.testng.ISuite;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
 
import com.LIMS.genericUtility.Mainclass;
import com.LIMS.genericUtility.UtilityInstanceTranfer;
import com.LIMS.genericUtility.annotations.Report;
 
/**
 * 
 * @author smruti
 *
 */
public class ExtentReportListener implements ITestListener, ISuiteListener {
	ReportUtility report;
	public static ReportUtility sreport;

/**
 * This is used for @Beforesuit level initalization like as Reportutility
 */
	@Override
	public void onStart(ISuite suite) {
		System.out.println("OnSuite-->Suite");
		report = new ReportUtility();
		sreport = report;	
		}

	/**
	 * This method is used for @AfterSuit level close like as report.saveReport
	 */

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart");
		
	}
	/**
	 * This method is used for @BeforeTest level annotation
	 * Here using getAnnotation(Report.class) method declaration
	 * Here using reportAnnotation.author();for initiallization of the name of author
	 */

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
		report.createTest(result.getMethod().getMethodName());
		Report reportAnnotation = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Report.class);
		System.out.println(reportAnnotation.author());
		System.out.println(reportAnnotation.author());
		
	}
	/**
	 * This method used once the test will success.
	 */

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSucess");
		report.pass(UtilityInstanceTranfer.getExtentTest(), result.getMethod().getMethodName() + "is pass");
	}
	/**
	 * This method is used for once the test will fail
	 * report fail message will pass withattach screenshot base64 as well as absolute path.
	 */

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
		report.fail(UtilityInstanceTranfer.getExtentTest(), result.getMethod().getMethodName() + "is fail");
		report.fail(UtilityInstanceTranfer.getExtentTest(), result.getThrowable());
		String screenshotpath = null;
		screenshotpath = Mainclass.class.cast(result.getMethod().getInstance()).sel.taketheScreenShot();
		report.attachScreenshot(UtilityInstanceTranfer.getExtentTest(), screenshotpath,
				result.getMethod().getMethodName(), "base64");

	}
	/**
	 * once skip just pass the message skip.
	 */

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
		report.skip(UtilityInstanceTranfer.getExtentTest(), result.getMethod().getMethodName() + "is failed",
				result.getThrowable());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButwithinSuccessPercentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedButWithinsuccesspercentage");

	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish --> Test");
		report.saveReport();
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("onFinish --> Suite");
		report.saveReport();
	}
}
