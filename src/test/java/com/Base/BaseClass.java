package com.Base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	public static FileInputStream fis;
	public static Properties config=new Properties();
	public static Properties OR=new Properties();
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	
	@BeforeSuite
	public static void setUp() {
		try {
			fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
			config.load(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			OR.load(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(config.getProperty("browser").equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		if(config.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		
		driver.get(config.getProperty("testurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("wait"))));
		wait=new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(config.getProperty("wait"))));
	}
	
	public static void click(String locator) {
		if(locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		}
	}
	
	
	public static void sendKeys(String locator,String value) {
		if(locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		}
	}
	
	
	
	@AfterSuite
	public static void teardown() {
		if(driver!=null) {
			driver.quit();
		}
	}

}
