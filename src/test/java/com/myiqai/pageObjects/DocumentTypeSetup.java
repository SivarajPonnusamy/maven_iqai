package com.myiqai.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentTypeSetup {
	WebDriver ldriver;
	public DocumentTypeSetup(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		}
	
	@FindBy(xpath = "//div[@id='root']//header//div//button//span")
	WebElement adminsettings;

	@FindBy(xpath = "//a[normalize-space()='Settings']")
	WebElement settings;
	
	
	@FindBy(xpath="//a[@href='/document-type']")
	WebElement doctype;
	
	@FindBy(xpath="//input[@placeholder='Enter document code']")
	WebElement doccode;
	
	@FindBy(xpath="//input[@placeholder='Enter special g/l indicator']")
	WebElement glindicator;
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement savedoctype;
	
	
	public void adminSettings() {
		adminsettings.click();

	}

	public void settingS() {
		settings.click();

	}
	
	public void doctypesetupcard() {
		doctype.click();
	}
	
	
	public void doctype() throws InterruptedException {
		ldriver.findElement(By.xpath("//div[@id='mui-component-select-document_type']")).click();
		List<WebElement> doctypes = ldriver.findElements(By.xpath("//ul[@role='listbox']//li"));
		Thread.sleep(4000);
		int len = doctypes.size();
		for (int i = 0; i < len; i++) {
			String doctypenames = doctypes.get(i).getText();
			System.out.println(doctypenames);
			if (doctypenames.equalsIgnoreCase("Non-PO Invoice")) {
				doctypes.get(i).click();
				break;
			}

		}

	}
	
	public void docCode() {
		doccode.clear();
		doccode.sendKeys("Testdoc123");
		
	}
	
	public void glIndicator() {
		glindicator.clear();
		glindicator.sendKeys("R");
	}
	
	public void savebutton() {
		savedoctype.click();	
	
	}
}
