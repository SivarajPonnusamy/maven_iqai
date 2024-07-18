package com.myiqai.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.myiqai.base.Base_test;
import com.myiqai.pageObjects.EmailConfig;

public class Email_config extends Base_test {

	@Test
	public void emailConfig() throws InterruptedException {
		EmailConfig email = new EmailConfig(driver);
		//email.sideBarOrg();
		email.adminSettings();
		email.settingS();
		email.addorgCard();
		email.orgList();
		Thread.sleep(3000);
		email.emailConfig();
		Thread.sleep(3000);
		//email.emailConfigList();
	}
}
