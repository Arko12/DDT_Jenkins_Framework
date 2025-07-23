package com.Base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.support.ui.Select;

import com.Util.ExcelReader;
import com.Util.Log;

public class BaseClass {
	
	public static FileInputStream fis;
	public static Properties config=new Properties();
	public static Properties OR=new Properties();
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\TestData.xlsx");
	
	
	@BeforeSuite
	public static void setUp() {
		try {
			fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
			config.load(fis);
			Log.info("config file loaded");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			OR.load(fis);
			Log.info("OR file loaded");
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(config.getProperty("browser").equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			Log.info("chrome driver loaded");
		}
		if(config.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			Log.info("firefox driver loaded");
		}
		
		driver.get(config.getProperty("testurl"));
		driver.manage().window().maximize();
		
		Log.info("url loaded-window maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("wait"))));
		wait=new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(config.getProperty("wait"))));
	}
	
	public static void click(String locator) {
		if(locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		}
		
		if(locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		}
		
		if(locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
		}
	}
	
	
	public static void sendKeys(String locator,String value) {
		if(locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		}
		
		if(locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		}
		
		if(locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		}
	}
	
	public static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	
	public static WebElement dropdown;
	public static void Select(String locator,String value) {
		
		if(locator.endsWith("_XPATH")) {
			dropdown=driver.findElement(By.xpath(OR.getProperty(locator)));
		}
		
		if(locator.endsWith("_CSS")) {
			dropdown=driver.findElement(By.cssSelector(OR.getProperty(locator)));
		}
		
		if(locator.endsWith("_ID")) {
			dropdown=driver.findElement(By.id(OR.getProperty(locator)));
		}
		
		Select select=new Select(dropdown);
		select.selectByVisibleText(value);
	}
	
	@AfterSuite
	public static void teardown() {
		if(driver!=null) {
			driver.quit();
		}
	}

}
