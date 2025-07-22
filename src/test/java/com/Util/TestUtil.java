package com.Util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

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
}
