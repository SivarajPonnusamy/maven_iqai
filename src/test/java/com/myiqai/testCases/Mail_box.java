package com.myiqai.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.myiqai.base.Base_test;
import com.myiqai.pageObjects.Mailbox;

public class Mail_box extends Base_test{
	Mailbox mail;
	@Test
	public void mailBox() throws InterruptedException {
		mail=new Mailbox(driver);
		mail.navigation2mailbox();
		mail.outlook_config();
		Thread.sleep(3000);
		mail.O365login();
		
	}
	
	

}
