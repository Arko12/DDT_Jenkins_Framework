package com.TestCases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Util.Log;
import com.Util.TestUtil;

public class TC002_AddCustomer extends BaseClass {

	@Test(dataProviderClass=TestUtil.class,dataProvider="dp_hash")
	public static void tC002_AddCustomer(Hashtable<String,String> data) {
		
		if(!TestUtil.isTestRunnalbe("TC002_AddCustomer")) {
			throw new SkipException("Test case skipped from Test suite level");
		}
		
		if(!data.get("Run Mode").equalsIgnoreCase("Y")) {
			throw new SkipException("skipped from run mode");
		}
		
		
		click("add_cust_button_XPATH");

		sendKeys("first_name_XPATH",data.get("First Name"));
		sendKeys("last_name_XPATH",data.get("Last Name"));
		sendKeys("postCode_XPATH",data.get("Post Code"));
		
		click("add_cust_Submit_button_XPATH");

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(data.get("AlertText")));
		alert.accept();
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Log.info("TC002 executed");
	}

	

}
