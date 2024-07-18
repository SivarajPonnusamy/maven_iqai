package com.myiqai.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskId {
	WebDriver ldriver;
	public TaskId(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		}
	@FindBy(xpath = "//div[@id='root']//header//div//button//span")
	WebElement adminsettings;

	@FindBy(xpath = "//a[normalize-space()='Settings']")
	WebElement settings;
	
	@FindBy(xpath="//a[@name='Task Id Configuration']")
	WebElement taskidcard;
	
	public void adminSettings() {
		adminsettings.click();
	}
	public void settingS() {
		settings.click();
	}
	public void taskIdcard() {
		taskidcard.click();
	}
	
	public void taskidconfig() {
		WebElement prefix=ldriver.findElement(By.xpath("//input[@placeholder='eg: TSK-']"));
		prefix.clear();
		prefix.sendKeys("88");
		WebElement numbersize=ldriver.findElement(By.xpath("//input[@name='NumberSize']"));
		numbersize.clear();
		numbersize.sendKeys("5");
		WebElement suffix=ldriver.findElement(By.xpath("//input[@placeholder='eg: -123']"));
		suffix.clear();
		suffix.sendKeys("-2024");
		
		WebElement Numbers_starts=ldriver.findElement(By.xpath("//input[@placeholder='eg: 1']"));
		Numbers_starts.sendKeys("-123");
		ldriver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		
		
		
	}
	
	
}
