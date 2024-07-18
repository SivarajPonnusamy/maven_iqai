package com.myiqai.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.myiqai.base.Base_test;
import com.myiqai.pageObjects.MonthClosing;

public class Month_Closing extends Base_test{
	@Test
	public void monthclosing() throws InterruptedException {
		
		MonthClosing mc = new MonthClosing(driver);
		mc.monthclosingSideBar();
		mc.orgLayout();
		mc.monthopened();
		mc.updateButton();
		Thread.sleep(4000);
	}

}
