package com.qa.capsulecrm.listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.capsulecrm.base.BaseClass;
import com.qa.capsulecrm.utilities.Utilities;

public class MyListener extends BaseClass implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result)
	{
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test has failed");
		try {
			Utilities.getScreenshotPath(result.getMethod().getMethodName(), driver);
			//Utilities.getScreen
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	@Override
	public void onTestSkipped(ITestResult result)
	{
		
		
	}

}
