package com.Util;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class CustomListeners implements ITestListener {
	
	public static Date d=new Date();
	public static String path="extent_"+d.toString().replace(" ", "_").replace(":","_")+".html";
	public static ExtentReports extent=ExtentManager.createReport(System.getProperty("user.dir")+"\\src\\test\\resources\\reports\\"+path);
	public static ThreadLocal<ExtentTest> testReport=new ThreadLocal<ExtentTest>();
	
	public void onStart(ITestContext arg0) {
		
	}
	
	public void onTestStart(ITestResult arg0) {
		ExtentTest test=extent.createTest(arg0.getClass().getName()+"@Test case"+arg0.getMethod().getMethodName());
		testReport.set(test);
	}
	
	public void onTestSuccess(ITestResult arg0) {
		try {
			TestUtil.captureScreenshot();
			testReport.get().pass("<b>"+"Success screenshot"+"<b>",MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.captureScreenshot()).build());
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("Test case passed");
		Reporter.log("<a href="+TestUtil.destinationPath+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a href="+TestUtil.destinationPath+"><img src="+TestUtil.destinationPath+" height=200 width=200></img></a>");
		
		
		
		String methodName=arg0.getMethod().getMethodName();
		String logText="<b>"+methodName.toUpperCase()+"Test is PASSED"+"</b>";
		Markup m= MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testReport.get().pass(m);
	}
	
	
	public void onTestFailure(ITestResult arg0) {
		try {
			TestUtil.captureScreenshot();
			testReport.get().fail("<b>"+"Test case FAILED"+"</b>",MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.captureScreenshot()).build());
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("Test case FAILED");
		Reporter.log("<a href="+TestUtil.destinationPath+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a href="+TestUtil.destinationPath+"><img src="+TestUtil.destinationPath+" height=200 width=200></img></a>");
		
		
		String methodName=arg0.getMethod().getMethodName();
		String logText="<b>"+methodName.toUpperCase()+"Test is FAILED"+"</b>";
		Markup m= MarkupHelper.createLabel(logText, ExtentColor.RED);
		testReport.get().fail(m);
	}
	
	public void onTestSkipped(ITestResult arg0) {
		Reporter.log("Test case skipped");
		
		String methodName=arg0.getMethod().getMethodName();
		String logText="<b>"+methodName.toUpperCase()+"Test is SKIPPED"+"</b>";
		Markup m= MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
		testReport.get().skip(m);
	}
	
	
	public void onFinish(ITestContext arg0) {
		if(extent!=null) {
			extent.flush();
		}
	}

}
