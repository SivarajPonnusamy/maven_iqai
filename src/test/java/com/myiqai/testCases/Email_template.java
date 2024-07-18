package com.myiqai.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.myiqai.base.Base_test;
import com.myiqai.pageObjects.EmailTemplate;

public class Email_template extends Base_test {
	EmailTemplate em;
	
	@Test
	public void emailTemplate() throws InterruptedException {
		em = new EmailTemplate(driver);
		em.adminSettings();
		em.settingS();
		em.sidebartskmgmt();
		em.mailTemplate();
		Thread.sleep(3000);
		
		}
	

}
