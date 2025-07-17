package com.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {

	

	public static ExtentReports extent;
	
	public static ExtentReports createInstance(String filename) {
		ExtentSparkReporter htmlReporter=new ExtentSparkReporter(filename);
		
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("DDT_Framework_Jenkis_project");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(filename);
		
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "Kaustuv");
		extent.setSystemInfo("build", "001");
		
		return extent;
	}
	

}
