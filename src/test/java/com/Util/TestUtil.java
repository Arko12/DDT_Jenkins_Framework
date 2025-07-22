package com.Util;

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
	
	public static File destinationPath;
	
	public static String captureScreenshot() throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		Date d=new Date();
		String path="Screenshot_"+d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		
		destinationPath=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\"+path);
		
		FileUtils.copyFile(src, destinationPath);
		
		return System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\"+path;
	}
	
	
	
	
	
	
	@DataProvider(name="dp")
	public static Object[][] getData(Method m){
		String sheetName=m.getName();
		
		int rows=excel.getRowCount(sheetName);
		int cols=excel.getColCount(sheetName);
		
		Object data[][]=new Object[rows-1][cols];
		
		for(int i=1;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				data[i-1][j]=excel.getCellValue(sheetName, i, j);
			}
		}
		
		return data;
	}
	
	
	@DataProvider(name="dp_hash")
	public static Object[][] getData_hash(Method m){
		String sheetName=m.getName();
		
		int rows=excel.getRowCount(sheetName);
		int cols=excel.getColCount(sheetName);
		
		Hashtable<String,String> table=null;
		
		Object data[][]=new Object[rows-1][1];
		
		for(int i=1;i<rows;i++) {
			table=new Hashtable<String,String>();
			
			for(int j=0;j<cols;j++) {
				table.put(excel.getCellValue(sheetName, 0, j),excel.getCellValue(sheetName, i, j));
				
				data[i-1][0]=table;
			}
		}
		
		return data;
	}
	
	
	
	public static boolean isTestRunnalbe(String testName) {
		String sheetName="Test_Suite";
		
		int rows=excel.getRowCount(sheetName);
		
		for(int i=1;i<rows;i++) {
			String test_case=excel.getCellValue(sheetName, i, 0);
			   if(test_case.equalsIgnoreCase(testName)) {
				   String test_runmode=excel.getCellValue(sheetName, i, 1);
				   
				       if(test_runmode.equalsIgnoreCase("Y")) {
				    	   return true;
				       }else {
				    	   return false;
				       }
			   }
		}
		
		return false;
	}
}
