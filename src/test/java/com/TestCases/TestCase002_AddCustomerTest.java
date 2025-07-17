package com.TestCases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Utilities.TestUtil;

public class TestCase002_AddCustomerTest extends BaseClass{
	
	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp_hash")
	public void testCase002_AddCustomerTest(Hashtable<String,String> data) {
		
		if(!TestUtil.isTestRunnable("testCase002_AddCustomerTest")) {
			throw new SkipException("TEST SKIPPED FROM RUN MODE-from Test suite level");
		}
		
	
	if(!data.get("Run Mode").equalsIgnoreCase("Y")){
		throw new SkipException("TEST SKIPPED FROM RUN MODE-from test data level");
	}
	
	
	
		click("add_cust_button_XPATH");
		sendKeys("first_name_XPATH",data.get("FirstName"));
		sendKeys("last_name_XPATH",data.get("LastName"));
		sendKeys("postCode_XPATH",data.get("Postcode"));
		click("add_cust_Submit_button_XPATH");
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(data.get("AlertText")));
		alert.accept();
		
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	


}
