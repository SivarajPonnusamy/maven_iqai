package com.myiqai.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailTemplate {
	WebDriver ldriver;
	WebDriverWait wait;
	public EmailTemplate(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//div[@id='root']//header//div//button//span")
	WebElement adminsettings;
	
	@FindBy(xpath = "//a[normalize-space()='Settings']")
	WebElement settings;
	
	@FindBy(xpath="//body/div[@id='root']/div/div/div/div/a[4]")
	WebElement sidebarTaskmgmt;
	
	@FindBy(xpath="//a[@href='/emailtemplate']")
	WebElement emailtemplate;
	
	@FindBy(xpath="//button[normalize-space()='Create Template']")
	WebElement createTem;
	
	@FindBy(xpath="//input[@placeholder='Template Name']")
	WebElement tempname;
	
	@FindBy(xpath="//input[@id='tags-filled']")
	WebElement ccname;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	WebElement bccname;	
	
	@FindBy(xpath="(//input)[6]")
	WebElement subject;	
	
	@FindBy(xpath="//span[normalize-space()='Insert Placeholders']")
	WebElement insertplaceholders;	
	
	@FindBy(xpath="//button[@title='Save']")
	WebElement savebutton;
	
	public void adminSettings() {
		adminsettings.click();

	}
	
	public void settingS() {
		settings.click();

	}
	
	public void sidebartskmgmt() throws InterruptedException {
		sidebarTaskmgmt.click();
		Thread.sleep(4000);
	}
	public void mailTemplate() throws InterruptedException {
	
		emailtemplate.click();
		createTem.click();
		tempname.sendKeys("TestTwo");
		ccname.sendKeys("psivaraj@iquantm.com");
		bccname.sendKeys("vsam@iquantm.com");
		subject.sendKeys("PO Not released");
		subject.sendKeys(Keys.TAB);
		
		
		
		
		//insertplaceholders.click();
		Thread.sleep(5000);
		//wait = new WebDriverWait(ldriver, 50);
        //WebElement bodyframe=ldriver.findElement(By.xpath("//iframe"));
        //ldriver.switchTo().frame(bodyframe);
        
        
        //WebElement bodyframe_1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='presentation'])[3]")));
    	//bodyframe_1.click();
        //Actions act1=new Actions(ldriver);
        //bodyframe_1.sendKeys("PO NOT released, Have a look into this :");
		
		
		//wait = new WebDriverWait(ldriver, 50);
		//WebElement bodyframe = wait
			//	.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='cke_1_contents']")));
	
		//bodyframe.sendKeys("PO NOT released, Have a look into this :");
		
		//WebElement bodyframe=ldriver.findElement(By.xpath("//iframe[@title='Rich Text Editor, editor1']"));
		
		// 
		// iframe[@title='Rich Text Editor, editor1']
		
		//bodyframe.sendKeys("PO NOT released, Have a look into this :");
		
		//ldriver.switchTo().frame(bodyframe);
	
		insertplaceholders.click();
		WebElement fromElement = ldriver.findElement(By.xpath("//li[normalize-space()='Invoice No.']"));
		
		WebElement toElement = ldriver.findElement(By.xpath("//iframe"));
		Actions act = new Actions(ldriver);
		act.dragAndDrop(fromElement, toElement).perform();
	
		Thread.sleep(3000);
		
		savebutton.click();
		
	}

}
