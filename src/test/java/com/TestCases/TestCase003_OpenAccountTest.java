package com.TestCases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Utilities.TestUtil;

public class TestCase003_OpenAccountTest extends BaseClass{
	
	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp_hash")
	public void testCase003_OpenAccountTest(Hashtable<String,String> data) {
		
		if(!TestUtil.isTestRunnable("testCase003_OpenAccountTest")) {
			throw new SkipException("TEST SKIPPED FROM RUN MODE-from Test suite level");
		}
		
		
		if(!data.get("Run Mode").equalsIgnoreCase("Y")){
			throw new SkipException("TEST SKIPPED FROM RUN MODE-from test data level");
		}
		
		
		click("open_acc_XPATH");
		
		select("customer_XPATH",data.get("customer"));	
		select("currency_XPATH",data.get("currency"));
		
		click("process_XPATH");
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
