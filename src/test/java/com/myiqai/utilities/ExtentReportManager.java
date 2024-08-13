package com.myiqai.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;// UI of the report
	public ExtentReports extent; // populate common info on the report
	public ExtentTest test;// creating testcase entries in the report and update status of the test methods
	
	public void onStart(ITestContext context) {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir"+ "/reports/myreports.html"));
		sparkReporter.config().setDocumentTitle("MYIQ.AI Automation Report");
		sparkReporter.config().setReportName("Regression testing");
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent= new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Computer name", "local host Mac");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Siva");
		extent.setSystemInfo("OS", "Mac OS");
		extent.setSystemInfo("Browser name", "Chrome");

	}

	
	public void onTestStart(ITestResult result) {
		
		
	}

	
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getName());// create new entry in the report
		test.log(Status.PASS, "test case Passed is : "+result.getName());// update status pass/fail/skipped
		
	}

	
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.FAIL,"Test case failed :"+result.getName());
		test.log(Status.FAIL,"Test case failed cause is :"+result.getThrowable());
		}

	
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case skipped :"+result.getName());
		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}
	
	

}
