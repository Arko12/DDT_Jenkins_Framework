package com.TestCases;

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
	}

}
