package com.myiqai.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.myiqai.base.Base_test;
import com.myiqai.pageObjects.ExchangeRate;

public class Exchange_Rate extends Base_test{
	@Test
	public void exchangerate() throws InterruptedException {
		ExchangeRate er= new ExchangeRate(driver);
		er.exchangerateSideBar();
		er.currencyDropdown();
		er.addvendorCurrency();
		
		Thread.sleep(5000);
		
	}
	

}
