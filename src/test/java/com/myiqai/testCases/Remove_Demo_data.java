package com.myiqai.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.myiqai.base.Base_test;
import com.myiqai.pageObjects.RemoveDemoData;

public class Remove_Demo_data extends Base_test{
	@Test
	public void removeDemoData() throws InterruptedException {
		RemoveDemoData rd = new RemoveDemoData(driver);
		rd.adminSettings();
		rd.settingS();
		rd.demoCard();
		Thread.sleep(3000);
		rd.confirmButton();
		Thread.sleep(5000);
		
	}

}
