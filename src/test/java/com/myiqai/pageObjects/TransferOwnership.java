package com.myiqai.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransferOwnership {
	WebDriver ldriver;
	WebDriverWait wait;
	public TransferOwnership(WebDriver rdriver) {
		 ldriver=rdriver;
		 PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//div[@id='root']//header//div//button//span")
	WebElement adminsettings;

	@FindBy(xpath = "//a[normalize-space()='Settings']")
	WebElement settings;
	
	@FindBy(xpath ="//a[@name='Transfer Ownership']")
	WebElement transferownershipcard;
	
	@FindBy(xpath="//div[@id='mui-component-select-orgName']")
	WebElement usersdropdown;
	
	@FindBy(xpath="//button[@title='Save']")
	WebElement savebutton;
	
	@FindBy(name = "login_email")
	WebElement login;

	@FindBy(name = "login_password")
	WebElement pwd;

	@FindBy(xpath = "//button[@title='Login']")
	WebElement loginbt;
	
	public void adminSettings() {
		adminsettings.click();

	}

	public void settingS() {
		settings.click();

	}
	public void transfercard() {
		transferownershipcard.click();
		
	}
	
	public void usersDropdown() throws InterruptedException {
		//usersdropdown.click();
		wait = new WebDriverWait(ldriver, 40);
		WebElement userdropdown =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='mui-component-select-orgName']")));
		userdropdown.click();
	    Thread.sleep(4000);
		List<WebElement>userslist=ldriver.findElements(By.xpath("//ul[@role='listbox']//li"));
		int size=userslist.size();
		System.out.println(size);
		for(WebElement usl:userslist) {
			System.out.println(usl.getText());
			if(usl.getText().equalsIgnoreCase("saxurihi@finews.biz")) {
				usl.click();
				break;
			}
			
		}
	}
	public void  savebutton() throws InterruptedException   {
		//Thread.sleep(4000);
		savebutton.click();
		ldriver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
		
		}
	public void transferredUserLogin(String business_email,String password) throws InterruptedException {
			wait.until(ExpectedConditions.visibilityOf(login));
			login.clear();
			login.sendKeys(business_email);
			wait.until(ExpectedConditions.visibilityOf(pwd));
			pwd.clear();
			pwd.sendKeys(password);
			wait.until(ExpectedConditions.visibilityOf(loginbt));
			loginbt.click();	
			adminSettings();
			settingS() ;
			transfercard();
			wait = new WebDriverWait(ldriver, 40);
			WebElement userdropdown =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='mui-component-select-orgName']")));
			userdropdown.click();
		    Thread.sleep(4000);
			List<WebElement>userslist=ldriver.findElements(By.xpath("//ul[@role='listbox']//li"));
			int size=userslist.size();
			System.out.println(size);
			for(WebElement usl:userslist) {
				System.out.println(usl.getText());
				if(usl.getText().equalsIgnoreCase("psivaraj@iquantm.com")) {
					usl.click();
					Thread.sleep(5000);
					break;
				}
				
			}
			
			savebutton();
			Thread.sleep(5000);
	}
	
}
