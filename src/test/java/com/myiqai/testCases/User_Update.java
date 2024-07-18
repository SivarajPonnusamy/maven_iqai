package com.myiqai.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.myiqai.base.Base_test;
import com.myiqai.pageObjects.UserUpdate;

import org.openqa.selenium.WebDriver;

public class User_Update extends Base_test{
	@Test
	public  void userUpdation() throws InterruptedException {
		UserUpdate uu= new UserUpdate(driver);
		uu.adminSettings();
		uu.settingS();
		uu.inviteUsers();
		uu.userslist();
		Thread.sleep(5000);

	}

}
