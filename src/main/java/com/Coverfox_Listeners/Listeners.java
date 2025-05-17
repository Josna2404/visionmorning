package com.Coverfox_Listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.Coverfox_Base.Base;
import com.Coverfox_Utility.Utility;

public class Listeners extends Base implements ITestListener {
	
	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test "+result.getName()+" is success",true);
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
	Reporter.log("Test "+result.getName()+" is fail ",true);
	try {
		 Utility.takeScreenshot(driver, "FailedTCScreenshot");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
