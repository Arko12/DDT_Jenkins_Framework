package com.Util;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListeners implements ITestListener {
	
	
	public void onTestSuccess(ITestResult arg0) {
		try {
			TestUtil.captureScreenshot();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("Test case passed");
		Reporter.log("<a href="+TestUtil.destinationPath+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a href="+TestUtil.destinationPath+"><img src="+TestUtil.destinationPath+" height=200 width=200></img></a>");
	}
	
	
	public void onTestFailure(ITestResult arg0) {
		
	}
	
	public void onTestSkipped(ITestResult arg0) {
		
	}

}
