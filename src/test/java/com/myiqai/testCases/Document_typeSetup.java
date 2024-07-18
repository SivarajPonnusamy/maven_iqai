package com.myiqai.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.myiqai.base.Base_test;
import com.myiqai.pageObjects.DocumentTypeSetup;

public class Document_typeSetup extends Base_test {
	
	@Test
	public void docsetUP() throws InterruptedException {
		DocumentTypeSetup doc= new DocumentTypeSetup(driver);
			doc.adminSettings();
			doc.settingS();
			doc.doctypesetupcard();
			doc.doctype();
			Thread.sleep(4000);
			doc.docCode();
			Thread.sleep(3000);
			doc.glIndicator();
			doc.savebutton();
			Thread.sleep(3000);
		
	}

}
