package com.TestCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Util.TestUtil;

public class TC003_OpenAccount extends BaseClass{

	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public static void tC003_OpenAccount(String customer,String currency,String alerText) {
		click("open_acc_XPATH");
		
		
		
		sendKeys("customer_XPATH",customer);
		sendKeys("currency_XPATH",currency);
		
		click("process_XPATH");
		
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Alert alert= wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(alerText));
		alert.accept();
		
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
