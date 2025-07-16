package com.Utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.Base.BaseClass;

public class TestUtil extends BaseClass{

	public static String stringShotPath;
	public static File destination;
	
	public static void captureScreenshot() throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		Date d=new Date();
		stringShotPath="screenshot_"+d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		
		destination=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\"+stringShotPath);
		
		FileUtils.copyFile(src,destination);
		
	}
	
	
	@DataProvider(name="dp")
	public Object[][] commonDataProvider(Method m){
		String sheetName=m.getName();
		int rows=excel.getRowcount(sheetName);
		int cols=excel.getColumncount(sheetName);
		
		
		Object[][] data=new Object[rows-1][cols];
		
		
		
		for(int i=1;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				data[i-1][j]=excel.getCellValue(sheetName, i, j);
			}
		}
		
		return data;
	}
	
	
	@DataProvider(name="dp_hash")
	public Object[][] commonDataProvider_hash(Method m){
		String sheetName=m.getName();
		int rows=excel.getRowcount(sheetName);
		int cols=excel.getColumncount(sheetName);
		
		Hashtable<String,String> table=null;
		
		Object[][] data=new Object[rows-1][1];
		
		
		
		for(int i=1;i<rows;i++) {
			table=new Hashtable<String,String>();
			for(int j=0;j<cols;j++) {
				
				table.put(excel.getCellValue(sheetName,0,j), excel.getCellValue(sheetName,i,j));
				data[i-1][0]=table;
			}
		}
		
		return data;
	}
	
	
	
	
	public static boolean isTestRunnable(String testName) {
		String sheetName="Test_Suite";
		
		int rows=excel.getRowcount(sheetName);
		
		for(int i=1;i<rows;i++) {
			String test_case=excel.getCellValue(sheetName, i, 0);
			if(test_case.equalsIgnoreCase(testName)) {
				String runMode=excel.getCellValue(sheetName, i, 1);
				
				  if(runMode.equalsIgnoreCase("Y")) {
					  return true;
				  }else {
					  return false;
				  }
			}
		}
		
		return false;
	}
}
