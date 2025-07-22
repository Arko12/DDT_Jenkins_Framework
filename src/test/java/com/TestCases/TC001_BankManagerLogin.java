package com.TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Base.BaseClass;

public class TC001_BankManagerLogin extends BaseClass{

	@Test
	public static void tC001_BankManagerLogin() {
		click("btm_login_XPATH");
		
		try {
			Thread.sleep(2000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("add_cust_button_XPATH"))));
	}
}
