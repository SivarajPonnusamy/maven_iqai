package com.myiqai.pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemoveDemoData {
	WebDriver ldriver;
	public RemoveDemoData(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		}
	
	@FindBy(xpath = "//div[@id='root']//header//div//button//span")
	WebElement adminsettings;

	@FindBy(xpath = "//a[normalize-space()='Settings']")
	WebElement settings;
	
	@FindBy(xpath="//a[@name='Clean up Demo Data']")
	WebElement cleandemocard;
	
	@FindBy(xpath="(//button[@title='Confirm'][normalize-space()='Confirm'])[1]")
	WebElement confirmbutton;
	
	
	public void adminSettings() {
		adminsettings.click();

	}

	public void settingS() {
		settings.click();

	}
	public void demoCard() {
		cleandemocard.click();
		
	}
	
	public void confirmButton() throws InterruptedException {
		/*WebElement simpleAlertButton=ldriver.findElement(By.xpath("(//button[@title='Confirm'][normalize-space()='Confirm'])[1]"));
		simpleAlertButton.click();*/
		
		confirmbutton.click();
		Thread.sleep(2000);
		System.out.println(ldriver.findElement(By.xpath("//body/div[@id='user-modal-root']/div[12]/div[1]")).getText());
		
		
		/*Alert simpleAlert = ldriver.switchTo().alert();
		String demodatacleantext=simpleAlert.getText();
		System.out.println(demodatacleantext);*/
		
		
		//div[@role='dialog']
		String demodatapopup=ldriver.findElement(By.xpath("(//div[@id='swal2-html-container'])[1]")).getText();
		
		System.out.println(demodatapopup);
		ldriver.findElement(By.xpath("//button[@type='button' and @class='swal2-confirm swal2-styled']")).click();
		
	}
	

}
