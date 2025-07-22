package com.TestCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Util.TestUtil;

public class TC002_AddCustomer extends BaseClass {

	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public static void tC002_AddCustomer(String fName, String lName, String pcode, String alertText) {
		click("add_cust_button_XPATH");

		sendKeys("first_name_XPATH",fName);
		sendKeys("last_name_XPATH",lName);
		sendKeys("postCode_XPATH",pcode);
		
		click("add_cust_Submit_button_XPATH");

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(alertText));
		alert.accept();
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
