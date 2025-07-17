package com.Utilities;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class CustomListeners implements ITestListener{
	
	static Date d=new Date();
	static String  fileName="extent_"+d.toString().replace(" ", "_").replace(":", "_")+".html";
	private static ExtentReports extent=ExtentManager.createInstance(System.getProperty("user.dir")+"\\reports\\"+fileName);
	public static ThreadLocal<ExtentTest> testreport=new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult arg0) {
		ExtentTest test=extent.createTest(arg0.getClass().getName()+" @TestCase: "+arg0.getMethod().getMethodName());
		testreport.set(test);
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
	
	
		String methodName=arg0.getMethod().getMethodName();
		String logText="<b>"+"Test case: "+methodName.toUpperCase()+" PASSED"+"</b>";
		Markup m=MarkupHelper.createLabel(logText,ExtentColor.GREEN);
		testreport.get().pass(m);
	
	
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
	
	
		String methodname=arg0.getMethod().getMethodName();
		String logText="<b>"+"Test case:"+methodname.toUpperCase()+"FAILED"+"<b>";
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.RED);
		testreport.get().fail(m);
	
	
	
	}
	
	public void onTestSkipped(ITestResult arg0) {
		Reporter.log("Test case Skipped");
		
		String methodname=arg0.getMethod().getMethodName();
		String logText="<b>"+"Test case:"+methodname.toUpperCase()+"SKIPPED"+"<b>";
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
		testreport.get().skip(m);
	}
	
	public void onStart(ITestContext arg0) {
		
	}
	
	public void onFinish(ITestContext arg0) {
		if(extent!=null) {
			extent.flush();
		}
	}
	
	
}
