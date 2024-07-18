package com.myiqai.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MiscellaneousPaymentRequest {
	WebDriver ldriver;
	WebDriverWait wait;
	public MiscellaneousPaymentRequest(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//img[@src='/images/MyiQ-icons/invoice.svg']")
	WebElement invoicesidebar;
	
	@FindBy(xpath="//a[normalize-space()='Miscellaneous']")
	WebElement miscellaneouspayment;
	
	public void invoicenavigation() throws InterruptedException {
		wait = new WebDriverWait(ldriver,50);
		WebElement invociesidebar1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='/images/MyiQ-icons/invoice.svg']")));
		invociesidebar1.click();
		
		WebElement miscellaneous=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Miscellaneous']")));
		miscellaneous.click();
		
		//WebElement invoicenavigation=wait.until(ExpectedConditions.presenceOfElementLocated(By.
			//	xpath("//a[normalize-space()='Miscellaneous']")));
			//Actions act = new Actions(ldriver);
		    Thread.sleep(3000);
			//act.moveToElement(invociesidebar1).moveToElement(hover_miscellaneous).click().perform();
	}

}
