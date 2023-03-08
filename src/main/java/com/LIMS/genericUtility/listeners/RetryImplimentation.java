package com.LIMS.genericUtility.listeners;

import org.testng.IRetryAnalyzer;

import org.testng.ITestResult;
/**
 * 
 * @author smruti
 *
 */

public class RetryImplimentation implements IRetryAnalyzer {
	int count;
	@Override
	public boolean retry(ITestResult result)
	{
		int maxCount=2;
		if(count<maxCount)
		{
			count++;
			return true;
		}
		return false;
	}
	

}
