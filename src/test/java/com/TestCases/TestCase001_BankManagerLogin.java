package com.TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Base.BaseClass;

public class TestCase001_BankManagerLogin extends BaseClass{
	
	@Test
	public void testCase001_BankManagerLogin() {
		click("btm_login_XPATH");
		
		try {
			Thread.sleep(2000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(ElementisPresent(By.xpath(OR.getProperty("add_cust_button_XPATH"))));
	}

}
