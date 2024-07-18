package com.myiqai.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.myiqai.base.Base_test;
import com.myiqai.pageObjects.FolderConfig;

public class Folder_config extends Base_test {
	@Test
	public void folderConfig() throws InterruptedException {
		FolderConfig folder = new FolderConfig(driver);
		folder.adminSettings();
		folder.settingS();
		folder.addorgCard();
		folder.orgList();
		Thread.sleep(4000);
		folder.folderConfig();
        Thread.sleep(3000);	
	}
}
