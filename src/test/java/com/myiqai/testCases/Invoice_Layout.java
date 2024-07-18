package com.myiqai.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.myiqai.base.Base_test;
import com.myiqai.pageObjects.InvoiceLayout;

public class Invoice_Layout extends Base_test{
	@Test
	public void invoiceLayout() throws InterruptedException {
		InvoiceLayout il= new InvoiceLayout(driver);
		il.adminSettings();
		il.settingS();
		il.invoicelayoutCard();
		il.orglayout();
		//il.labeledit();
		il.display();
		Thread.sleep(3000);
	}

}
