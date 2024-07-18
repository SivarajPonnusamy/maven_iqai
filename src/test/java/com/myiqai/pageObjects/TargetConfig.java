package com.myiqai.pageObjects;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TargetConfig {
	public WebDriver ldriver;
	public WebDriverWait wait;
	public TargetConfig(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		}
	@FindBy(xpath="//a[normalize-space()='Organisation']")
	WebElement navigation_org;
	
	@FindBy(xpath = "//div[@id='root']//header//div//button//span")
	WebElement adminsettings;
	
	@FindBy(xpath = "//a[normalize-space()='Settings']")
	WebElement settings;

	@FindBy(xpath = "//a[@href='/organisations']")
	WebElement addorgcard;
	
	@FindBy(xpath="//select[@name='orgInt']")
	WebElement target;
	
	@FindBy(xpath="//h4[normalize-space()='Target']")
	WebElement erp;
	
	@FindBy(xpath="//div[@id='erp_type']") 
	WebElement erptypes;
	
	@FindBy(xpath="//input[@placeholder='https://www.example.com']") 
	WebElement url;
	@FindBy(xpath="//input[@placeholder='Enter the Username']")
	WebElement username;
	@FindBy(xpath="//input[@id='new-password']")
	WebElement pwd;
	@FindBy(xpath="(//button[@title='Save'][normalize-space()='Save'])[2]")
	WebElement saveerp;
	@FindBy(xpath="//button[normalize-space()='Test' and @title='to Test Connection']")
	WebElement testerp;
	public void sidebarOrg() {
		wait = new WebDriverWait(ldriver, 30);
		WebElement navigation_icon =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/organisations']")));
		navigation_icon.click();
		//navigation_org.click();
	}
	public void adminSettings() {
		adminsettings.click();

	}

	public void settingS() {
		settings.click();

	}

	public void addorgCard() {
		addorgcard.click();
	}
	
	
	
	public void orgList() throws InterruptedException {
		List<WebElement> orglist = ldriver.findElements(By.xpath("//h5[@class='mb-2 font-interM trunc-2 max-w-[500px] xl:max-w-[180px]']"));
		int orgcount = orglist.size();
		
		System.out.println(orgcount);
		
		for(WebElement orglisting:orglist) {
			System.out.println(orglisting.getText());
			
			if(orglisting.getText().equalsIgnoreCase("My iq Mac")) {
				Thread.sleep(3000);
				System.out.println("Karl marx vs Gandhi");
				orglisting.click();
				
				break;
			}
			else {
				System.out.println("Dr.BR.Ambedkar");
			}
			
		}

	}
	
	

	
	public void targetConfig() {
		target.click();
		Select dropdown = new Select(target);
		dropdown.selectByVisibleText("Yes");
		List<WebElement> drop=dropdown.getOptions();
		for(WebElement erp:drop) {
			String option=erp.getText();
			System.out.println("Sam");
			System.out.println(option);
			if (option=="Yes") {
				erp.click();
			}
		}
		}
	
		public void erpConfig() {
			erp.click();
		}
		
		public void typesofERP() {
			erptypes.click();
			List<WebElement> diff_erps=ldriver.findElements(By.xpath("//ul[@role='listbox']//li"));
			for(WebElement erplists:diff_erps) {
				System.out.println(erplists.getText());
					if(erplists.getText().equalsIgnoreCase("SAP")) {
						erplists.click();
						
					}
			}
		}
		public void urL() {
			url.clear();
			url.sendKeys("http://3.8.239.88:8080/");
		}
		public void erpUsername() {
			username.clear();
			username.sendKeys("odatatest");
		}
		public void erpPwd() {
			pwd.clear();
			pwd.sendKeys("Test@123");
		}
		public void erpSave() {
			saveerp.click();
		}
		public void erpTest() throws InterruptedException {
			testerp.click();
			Thread.sleep(3000);
			ldriver.findElement(By.xpath("(//button[normalize-space()='OK'])[1]")).click();
			Thread.sleep(3000);
			ldriver.findElement(By.xpath("//div[@id='mui-component-select-company_code']")).click();
			List<WebElement> company_code = ldriver.findElements(By.xpath("//ul[@role='listbox']//li"));
			for (WebElement code : company_code) {
				if (code.getText().equalsIgnoreCase("GB01")) {
					code.click();
					break;

				}
			}
		}
		

}
