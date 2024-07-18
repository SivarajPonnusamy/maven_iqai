package com.myiqai.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class IdConfiguration{
	WebDriver ldriver;
	WebDriverWait wait;
	public IdConfiguration(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		}
	
	
	@FindBy(xpath = "//div[@id='root']//header//div//button//span")
	WebElement adminsettings;

	@FindBy(xpath = "//a[normalize-space()='Settings']")
	WebElement settings;
	
	@FindBy(xpath="//a[@href='/invoiceid-config']")
	WebElement idcard;
	
	@FindBy(xpath="//div[@id='mui-component-select-OrganisationList' and @aria-haspopup='listbox']")
	WebElement orglayout;
	
	@FindBy(xpath="//div[@id='mui-component-select-documentGroup']")
	WebElement doctype;
	
	@FindBy(xpath="//input[@placeholder='eg: INV-']")
	WebElement prefix;
	
	@FindBy(xpath="//input[@name='NumberSize']")
	WebElement runNo;
	
	@FindBy(xpath="//input[@placeholder='eg: 123']")
	WebElement suffix;
	
	@FindBy(xpath="//input[@placeholder='eg: 1']")
	WebElement Nostarts;
	
	@FindBy(xpath="//button[@title='Save']")
	WebElement save;
	

	public void adminSettings() {
		adminsettings.click();

	}

	public void settingS() {
		settings.click();

	} 
	
	public void idconfigCard() {
		idcard.click();
		
	}
	
	public void orgLayout() throws InterruptedException {
		Thread.sleep(4000);
		orglayout.click();
		WebDriverWait wait = new WebDriverWait(ldriver,50);
		List<WebElement> org_layout= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@name='OrganisationList']")));
		
		//List<WebElement> org_layout = ldriver.findElements(By.xpath("//li[@name='OrganisationList']"));
		int layout_size=org_layout.size();
		System.out.println("Size of layout :"+layout_size);

		//for (WebElement organisation : org_layout)
		for (int i=0;i<=layout_size;i++){
			boolean status =false;
			if (org_layout.get(i).getText().equalsIgnoreCase("My iq Mac"))

			{
				System.out.println("123-123");
				System.out.println(org_layout.get(i).getText());
				org_layout.get(i).click();
				status=true;
				break;
			}
			if (!status) {
			    System.out.println("No country is matching");
			}
			
			
			
			}
			
			
		}
	public void docType() {
		doctype.click();
		WebDriverWait wait = new WebDriverWait(ldriver,50);
		List<WebElement> doc_layout=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li")));
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li")));
		
		//List<WebElement> org_layout = ldriver.findElements(By.xpath("//li[@name='OrganisationList']"));
		int documentsize=doc_layout.size();
		System.out.println("Size of layout :"+documentsize);
		for (int i=0;i<=documentsize;i++){
			boolean status =false;
			if (doc_layout.get(i).getText().contains("Invoice"))

			{
				
				System.out.println(doc_layout.get(i).getText());
				doc_layout.get(i).click();
				status=true;
				break;
			}
			if (!status) {
			    System.out.println("No document is matching");
			}
			
			
			
			}
		
	}
	
	public void preFix() {
		prefix.clear();
		prefix.sendKeys("Inv-");
	}
	
	public void runningNO() {
		runNo.clear();
		runNo.sendKeys("1");
	}
	public void suFFix() {
		suffix.clear();
		suffix.sendKeys("-2025");
	}
	public void NumberStarts() {
		Nostarts.clear();
		Nostarts.sendKeys("7");
	}
	
	public void idconfirmation() {
		save.click();
	}
		
	}
	

