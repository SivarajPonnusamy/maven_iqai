package com.myiqai.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.myiqai.base.Base_test;
import com.myiqai.pageObjects.IdConfiguration;

import org.openqa.selenium.WebDriver;

public class Id_Configuration extends Base_test {
	public IdConfiguration id;
	@Test
	public void idConfig() throws InterruptedException {
	    id = new IdConfiguration(driver);
		id.adminSettings();
		id.settingS();
		id.idconfigCard();
		Thread.sleep(5000);
		id.orgLayout();

		id.docType();
		Thread.sleep(6000);
		id.preFix();
		id.runningNO();
		id.suFFix();
		id.NumberStarts();
		id.idconfirmation();
		Thread.sleep(5000);
	}

}
 