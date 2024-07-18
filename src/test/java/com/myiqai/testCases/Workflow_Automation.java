package com.myiqai.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.myiqai.base.Base_test;
import com.myiqai.pageObjects.WorkflowAutomation;

public class Workflow_Automation extends Base_test{
	@Test
	public void workflowAutomation() throws InterruptedException {
		WorkflowAutomation wa = new WorkflowAutomation(driver);
		wa.adminSettings();
		wa.settingS();
		wa.workflowautomationcard();
		wa.orgLayout();
		Thread.sleep(3000);
		wa.doctype();
		wa.addnewStatus();
		wa.savebutton();
		Thread.sleep(5000);
	}

}
