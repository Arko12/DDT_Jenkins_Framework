package com.Util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	public static ExtentReports extent;
	
	public static ExtentReports createReport(String path) {
		ExtentSparkReporter htmlReporter=new ExtentSparkReporter(path);
		
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle(path);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "Kaustuv");
		
		return extent;
	}

}
