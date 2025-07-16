package com.TestCases;

import org.testng.annotations.Test;

import com.Base.BaseClass;

public class TestCase002_AddCustomerTest extends BaseClass{
	
	
	@Test
	public void testCase002_AddCustomerTest()
	{
		click("add_cust_button_XPATH");
		
		try {
			Thread.sleep(2000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
