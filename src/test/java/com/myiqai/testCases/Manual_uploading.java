package com.myiqai.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.myiqai.base.Base_test;
import com.myiqai.pageObjects.Manualuploading;

public class Manual_uploading extends Base_test {
	@Test
	public static void manual_Uploading() throws InterruptedException {
		/*
		 * Loginpage login = new Loginpage(driver);
		 * login.setBusiness_email(newuserbusinessemail1); login.setPwd(userPassword1);
		 * login.login_bt(); Thread.sleep(3000);
		 */

		Manualuploading upload = new Manualuploading(driver);
		upload.stickyUpload();
		// upload.sidebarManual();
		Thread.sleep(3000);
		// upload.orgLayout();
		Thread.sleep(3000);
		upload.doc_type();
		upload.uploadFiles();

		Thread.sleep(3000);

		upload.uploadBt();
		Thread.sleep(3000);
		// upload.confirmationMess();
		// Thread.sleep(3000);

	}

}
