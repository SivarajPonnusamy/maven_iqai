package com.myiqai.pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// POM Mailbox config
public class Mailbox {
public WebDriver ldriver;
public String parentwindow;
	
	public Mailbox(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this );
		}
	@FindBy(xpath="//a[normalize-space()='Inbox']")
	WebElement navigationmailbox;
	
	@FindBy(xpath="//a[@href='/inbox-config/outlook']")
	WebElement outlook_config;
	
	@FindBy(xpath="//div[@id='root']//div//div//div//div//button[@type='button']")
	WebElement outlook_continue;
	
	@FindBy(xpath="//input[@type='email' and @name ='loginfmt']")
	WebElement O365username;
	
	@FindBy(xpath="//input[@type='submit' and @data-report-event ='Signin_Submit']")
	WebElement nextbutton;
	
	@FindBy(xpath="//input[@name='passwd' and @type='password']")
	WebElement O365password;
	
	@FindBy(xpath="//input[@type='submit' and @value='Sign in']")
	WebElement O365loginbutton;
	
	
	
	
	public void navigation2mailbox() {
		navigationmailbox.click();
		
	}
	
	public void outlook_config() {
		outlook_config.click();
		outlook_continue.click();
		Set<String> windowhandles =ldriver.getWindowHandles();
		System.out.println(windowhandles);
		Iterator<String> iterator = windowhandles.iterator();
		String parentwindow = iterator.next();
		String childwindow = iterator.next();
		ldriver.switchTo().window(childwindow);
		
	}
	
	public void O365login() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(ldriver, 50);
		By O365mailid=By.xpath("//input[@name ='loginfmt']");
		wait.until(ExpectedConditions.presenceOfElementLocated(O365mailid));
		ldriver.findElement(O365mailid).sendKeys("admin@iquantm.online");
		Thread.sleep(3000);
	
		//O365username.sendKeys("admin@iquantm.online");
		nextbutton.click();
		By O365Pwd = By.xpath("//input[@name='passwd' and @type='password']");
		ldriver.findElement(O365Pwd).sendKeys("iquantm@143");
		//O365password.sendKeys("iquantm@143");
		O365loginbutton.click();
		ldriver.findElement(By.xpath("//input[@type='button']")).click();
		Thread.sleep(3000);
		ldriver.navigate().refresh();
		Thread.sleep(3000);
		ldriver.findElement(By.xpath("//button[normalize-space()='Back']")).click();
		
		
		//ldriver.switchTo().window(parentwindow);
		
		
		
	}
	

}
