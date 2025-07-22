package com.TestCases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Util.TestUtil;

public class TC003_OpenAccount extends BaseClass{

	@Test(dataProviderClass=TestUtil.class,dataProvider="dp_hash")
	public static void tC003_OpenAccount(Hashtable<String,String> data) {
		
		if(!TestUtil.isTestRunnalbe("TC003_OpenAccount")) {
			throw new SkipException("Test case skipped from Test suite level");
		}
		
		if(!data.get("Run Mode").equalsIgnoreCase("Y")) {
			throw new SkipException("skipped from run mode");
		}
		
		
		click("open_acc_XPATH");
		
		
		
		sendKeys("customer_XPATH",data.get("Customer"));
		sendKeys("currency_XPATH",data.get("Currency"));
		
		click("process_XPATH");
		
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Alert alert= wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(data.get("AlertText")));
		alert.accept();
		
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
