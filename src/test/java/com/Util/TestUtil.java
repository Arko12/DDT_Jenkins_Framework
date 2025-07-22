package com.Util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

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

}
