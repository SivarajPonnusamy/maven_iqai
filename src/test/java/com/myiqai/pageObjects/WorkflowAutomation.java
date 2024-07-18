package com.myiqai.pageObjects;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorkflowAutomation {
	WebDriver ldriver;

	public WorkflowAutomation(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//div[@id='root']//header//div//button//span")
	WebElement adminsettings;

	@FindBy(xpath = "//a[normalize-space()='Settings']")
	WebElement settings;

	@FindBy(xpath = "//a[@name='Workflow Automation']")
	WebElement workflowautomationcard;

	@FindBy(xpath = "//div[@id='mui-component-select-documentGroup']")
	WebElement doctypedropdown;

	@FindBy(xpath = "//div[@id='mui-component-select-orgName']")
	WebElement orglayout;
	
	@FindBy(xpath="(//img[@id='190030c9-a6f4-498a-8bc7-90c3d28453ed'])[1]")
	WebElement plusicon;
	
	@FindBy(xpath="//input[@type='text']")
	WebElement statusname;
	
	@FindBy(xpath="//button[@title='Save'][normalize-space()='Create']")
	WebElement statuscreatebutton;
	
	@FindBy(xpath="//img[@title='To Select Colour Theme']")
	WebElement themecolor;
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement workflowsavebutton;

	public void adminSettings() {
		adminsettings.click();
	}

	public void settingS() {
		settings.click();
	}

	public void workflowautomationcard() {
		workflowautomationcard.click();
	}

	public void orgLayout() throws InterruptedException {
		orglayout.click();
		List<WebElement> org_layout = ldriver.findElements(By.xpath("//li[@title]"));
		int layout_size = org_layout.size();
		System.out.println("Size of or layout :" + layout_size);

		// for (WebElement organisation : org_layout)
		for (int i = 0; i < layout_size; i++) {
			System.out.println("123-123");
			if (org_layout.get(i).getText().equalsIgnoreCase("My iq Mac"))
			{
				System.out.println(org_layout.get(i).getText());
				Thread.sleep(3000);
				org_layout.get(i).click();
				System.out.println("iquantm");
				break;
			}
		}
	}
	public void doctype() throws InterruptedException {
		doctypedropdown.click();
		List<WebElement> doctype = ldriver.findElements(By.xpath("//ul[@role='listbox']//li"));
		for (WebElement listofdoctypes : doctype) {
			System.out.println(listofdoctypes.getText());
			if (listofdoctypes.getText().equalsIgnoreCase("Advance Request")) {
				System.out.println("Sam");
				listofdoctypes.click();
				System.out.println("Sam123");
				Thread.sleep(5000);
				break;

			}

		}

	}
	public void addnewStatus() {
		
		plusicon.click();
		System.out.println("poda");
		ldriver.findElement(By.xpath("//span[normalize-space()='Add Status']")).click();
		statusname.sendKeys("1");
		statuscreatebutton.click();
		ldriver.findElement(By.xpath("//body/div[@id='root']/div/div/div/div/div/div[@title='1']/div[1]")).click();
		themecolor.click();
		ldriver.findElement(By.xpath("(//span)[37]")).click();
		
		
		
		
		
		
		
		
	}
	
	public void savebutton() {
		workflowsavebutton.click();
	}

}
