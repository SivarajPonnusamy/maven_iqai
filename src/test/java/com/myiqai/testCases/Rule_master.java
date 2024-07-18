package com.myiqai.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.myiqai.base.Base_test;
import com.myiqai.pageObjects.RuleMaster;
import com.myiqai.utilities.XLUtils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Rule_master extends Base_test{
	
	RuleMaster rulemaster;
	int rownum;
	@Test
	public void rule_Mas() throws InterruptedException {
		rulemaster = new RuleMaster(driver);
		rulemaster.adminSettings();
		rulemaster.settingS();
		rulemaster.ruleCard();
		Thread.sleep(3000);
		}
	@Test(dataProvider = "rulemaster")
	public void rule_master(String rulename, String rule_description, String Operators, String VendorCountry,String Currency) throws InterruptedException {
		for (int i =1;  i<=rownum;) {
			try {
		rulemaster.newruleButton();
		rulemaster.doctypeRule(rulename);
		rulemaster.ruleDescription(rule_description,Operators, VendorCountry,Currency);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		//rulemaster.ruleName(rulename);
		
		Thread.sleep(4000);
		//rulemaster.ruleSave();
		break;
		}
	}	
	@DataProvider(name = "rulemaster")
	public String[][] getOrgData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/resources/testData/rulecreation.xlsx";
		rownum = XLUtils.getRowCount(path, "rules");
		int cellnum = XLUtils.getCellCount(path, "rules", 1);
		String ruledata[][] = new String[rownum][cellnum];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < cellnum; j++) {
				ruledata[i - 1][j] = XLUtils.getCellData(path, "rules", i, j);
				System.out.println(ruledata[i - 1][j] = XLUtils.getCellData(path, "rules", i, j));
			}
		}
		return ruledata;
	}
}
