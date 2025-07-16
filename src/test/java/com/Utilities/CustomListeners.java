package com.Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListeners implements ITestListener{
	
	public void onTestStart(ITestResult arg0) {
		
	}
	
	
	public void onTestSuccess(ITestResult arg0) {
		try {
			TestUtil.captureScreenshot();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("Test Case Passed");
		Reporter.log("<a target=\"blank\"  href="+TestUtil.destination+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"blank\" href="+TestUtil.destination+"><img src="+TestUtil.destination+" height=200 width=200></img></a>");
	}
	
	public void onTestFailure(ITestResult arg0) {
		
		try {
			TestUtil.captureScreenshot();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("Test Case Failed");
		//Reporter.log("<a target=\"blank\" href=\"C:\\Users\\ARKO\\OneDrive\\Pictures\\img3.jpg\">Screenshot</a>");
		//Reporter.log("<br>");
		//Reporter.log("<a target=\"blank\" href=\"C:\\Users\\ARKO\\OneDrive\\Pictures\\img3.jpg\"><img src=\"C:\\Users\\ARKO\\OneDrive\\Pictures\\img3.jpg\" height=200 width=200></img></a>");
		Reporter.log("<a target=\"blank\"  href="+TestUtil.destination+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"blank\" href="+TestUtil.destination+"><img src="+TestUtil.destination+" height=200 width=200></img></a>");
	}
	
	public void onTestSkipped(ITestResult arg0) {
		Reporter.log("Test case Skipped");
	}
	
	public void onStart(ITestContext arg0) {
		
	}
	
	public void onFinish(ITestContext arg0) {
		
	}
	
	
}
