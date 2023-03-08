package com.LIMS.genericUtility;

import com.aventstack.extentreports.ExtentTest;

public class UtilityInstanceTranfer {
	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();
	
	public static ExtentTest getExtentTest()
	{
	return extentTest.get();
	}
	/**
	 * 
	 * @param setExtentTest
	 */
	public static void setExtentTest(ExtentTest setExtentTest)
	{
		extentTest.set(setExtentTest);
	}

}
