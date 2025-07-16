package com.TestCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Utilities.TestUtil;

public class TestCase003_OpenAccountTest extends BaseClass{
	
	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void testCase003_OpenAccountTest(String customer,String currency,String alertText) {
		click("open_acc_XPATH");
		
		select("customer_XPATH",customer);	
		select("currency_XPATH",currency);
		
		click("process_XPATH");
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(alertText));
		alert.accept();
		
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
