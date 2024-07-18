package com.myiqai.testCases;

import org.testng.annotations.Test;


import com.myiqai.base.Base_test;
import com.myiqai.pageObjects.AccrualAutomationConfig;

public class Accrual_AutomationConfig extends Base_test {
	@Test
	public void accrualautomationConfig() throws InterruptedException {
		AccrualAutomationConfig aac = new AccrualAutomationConfig(driver);
		aac.adminSettings();
		aac.settingS();
		aac.accrualautomationcard();
		Thread.sleep(3000);
		aac.orgLayout();
		aac.accountingoptions();
		// Thread.sleep(6000);
		try {
			aac.debitcreditDropdown();
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("Type of Exception :" + e);

		}
		aac.savebutton();
		Thread.sleep(3000);

	}

}
