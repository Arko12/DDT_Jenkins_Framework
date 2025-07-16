package com.TestCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Utilities.TestUtil;

public class TestCase004_ShowCustomers extends BaseClass{

	@Test
	public void testCase004_ShowCustomers() {
		
		if(!TestUtil.isTestRunnable("testCase004_ShowCustomer")) {
			throw new SkipException("TEST SKIPPED FROM RUN MODE-from tTest suite level");
		}
		
		
		click("show_cust_XPATH");
		
		try {
			Thread.sleep(3000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
