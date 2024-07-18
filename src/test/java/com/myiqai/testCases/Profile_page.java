package com.myiqai.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.myiqai.base.Base_test;
import com.myiqai.pageObjects.Profile;
import com.myiqai.utilities.XLUtils;

import java.io.IOException;

import org.testng.annotations.DataProvider;


public class Profile_page extends Base_test{
	
	Profile prof;
	
	
	public void settingsProfile() {
	prof = new Profile(driver);
	prof.adminSettings();
	prof.profile();
	}
	
	@Test(dataProvider="profile",dependsOnMethods = "settingsProfile")
	public void profilePage(String firstname,String lastname, String mobile) throws InterruptedException {
		prof = new Profile(driver);
		
		
		prof.editProfile();
		prof.firstName(firstname);
		prof.lastName(lastname);
		prof.mobileNumber(mobile);
		//prof.countryDropDown();
		prof.profileUpdate();
		
		Thread.sleep(5000);
		
	}
	
	/*@Test(priority=3)
	public void settingstab() throws InterruptedException {
	prof.settingsTab();
	Thread.sleep(3000);
	}*/
	
	@Test(priority=4)
	public void password() throws InterruptedException {
		
		prof.passWord();
		
		prof.changePassword();
		Thread.sleep(4000);
	}
	 
	@DataProvider(name = "profile")
	public String[][] getprofData() throws IOException {
		int rownum;
		String path = System.getProperty("user.dir")+"/src/test/resources/testData/profile.xlsx";
		rownum = XLUtils.getRowCount(path, "profile");
		System.out.println("RowNmber:"+rownum);
		
		int cellnum = XLUtils.getCellCount(path, "profile", 1);
		System.out.println("ColumnNmber:"+cellnum);
		String profdata[][] = new String[rownum][cellnum];
		
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < cellnum; j++) {
				profdata[i - 1][j] = XLUtils.getCellData(path, "profile", i, j);
				System.out.println(profdata[i - 1][j] = XLUtils.getCellData(path, "profile", i, j));
			}
		}
		return profdata;
	}


}
