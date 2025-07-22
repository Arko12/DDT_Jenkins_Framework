package com.TestCases;

import org.testng.annotations.Test;

import com.Base.BaseClass;

public class TC002_AddCustomer extends BaseClass{
	
	@Test
	public static void TC002_AddCustomer() {
		click("add_cust_button_XPATH");
	
	

	try {
		Thread.sleep(2000);
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
}
