package com.TestCases;

import org.testng.annotations.Test;

import com.Base.BaseClass;

public class TC004_Customers extends BaseClass{
	
	
	@Test
	public static void tC004_Customers() {
		click("show_cust_XPATH");
		
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
