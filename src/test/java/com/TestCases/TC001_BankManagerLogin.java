package com.TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Util.Log;
import com.Util.TestUtil;

public class TC001_BankManagerLogin extends BaseClass{

	@Test
	public static void tC001_BankManagerLogin() {
		
		if(!TestUtil.isTestRunnalbe("TC001_BankManagerLogin")) {
			throw new SkipException("Test case skipped from Test suite level");
		}
		
		
		click("btm_login_XPATH");
		
		try {
			Thread.sleep(2000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("add_cust_button_XPATH"))));
		Log.info("TC001 executed");
	}
}
