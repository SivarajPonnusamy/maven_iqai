package com.myiqai.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.myiqai.base.Base_test;
import com.myiqai.pageObjects.MiscellaneousPaymentRequest;

public class Miscellaneous_Payment_Request extends Base_test {
	@Test
	public void miscellaneousRequest() throws InterruptedException {
		MiscellaneousPaymentRequest mr = new MiscellaneousPaymentRequest(driver);
		mr.invoicenavigation();
		Thread.sleep(6000);

	}

}
