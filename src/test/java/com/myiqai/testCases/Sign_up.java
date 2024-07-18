package com.myiqai.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.myiqai.pageObjects.Signup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Sign_up  {
	@Test
	public void signUp() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get("https://qa.myiq.ai/");
		Signup signup = new Signup(driver);
		signup.signupHyperlink();
		signup.firstName();
		signup.lastName();
		signup.businessEmail();
		signup.termsPrivacy();
		signup.signUpBt();
	    //signup.failMess();
	    signup.alertMess();
		}

}
