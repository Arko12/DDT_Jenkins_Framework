package com.TestCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Utilities.TestUtil;

public class TestCase002_AddCustomerTest extends BaseClass{
	
	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void testCase002_AddCustomerTest(String fName,String lName,String pCode,String alertText)
	{
		click("add_cust_button_XPATH");
		sendKeys("first_name_XPATH",fName);
		sendKeys("last_name_XPATH",lName);
		sendKeys("postCode_XPATH",pCode);
		click("add_cust_Submit_button_XPATH");
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
