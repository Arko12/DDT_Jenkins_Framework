package com.TestCases;

import org.testng.annotations.Test;

import com.Base.BaseClass;

public class TestCase004_ShowCustomers extends BaseClass{

	@Test
	public void testCase004_ShowCustomers() {
		click("show_cust_XPATH");
		
		try {
			Thread.sleep(3000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
