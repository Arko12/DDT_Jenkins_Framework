package com.TestCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Util.Log;
import com.Util.TestUtil;

public class TC004_Customers extends BaseClass{
	
	
	@Test
	public static void tC004_Customers() {
		
		if(!TestUtil.isTestRunnalbe("TC004_Customers")) {
			throw new SkipException("Test case skipped from Test suite level");
		}
		
		click("show_cust_XPATH");
		
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Log.info("TC004 executed");
	}

}
