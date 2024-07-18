package com.myiqai.pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvoiceApproved {
	WebDriver ldriver;
	WebDriverWait wait;
	public InvoiceApproved(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	@FindBy(xpath="(//img[@alt='dashboard'])[2]")
	WebElement sidebarinvoice;
	
	@FindBy(xpath="//div[@id='mui-component-select-orgName']")
	WebElement orglayout;
	
	@FindBy(xpath="//button[@title='To Validate Invoice']")
	WebElement validate;
	
	public void invNavigation() throws InterruptedException {
		wait = new WebDriverWait(ldriver,50);
		WebElement hover_invoice=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@alt='dashboard'])[2]")));
		hover_invoice.click();
		WebElement invoicenavigation=wait.until(ExpectedConditions.presenceOfElementLocated(By.
			xpath("//a[normalize-space()='Invoice']")));
		Actions act = new Actions(ldriver);
		Thread.sleep(3000);
		act.moveToElement(hover_invoice).moveToElement(invoicenavigation).click().perform();
		//invoicenavigation.click();
		
		Thread.sleep(3000);
		
		
		//sidebarinvoice.click();
	}

	public void orgLayout() throws InterruptedException {
		orglayout.click();
		List<WebElement> org_layout = ldriver.findElements(By.xpath("//li[@title]"));
		int layout_size = org_layout.size();
		System.out.println("Org_layout :" + layout_size);

		// for (WebElement organisation : org_layout)
		for (int i = 0; i < layout_size; i++) {

			System.out.println("123-123");
			if (org_layout.get(i).getText().equalsIgnoreCase("My iq Mac"))
//ktgfsdf com
			{
				System.out.println(org_layout.get(i).getText());
				org_layout.get(i).click();

				/*
				 * wait = new WebDriverWait(ldriver, 30); WebElement lay_org =
				 * wait.until(ExpectedConditions .presenceOfElementLocated(By.
				 * xpath("//li[@name='organisation_name'and @xpath='1']"))); lay_org.click();
				 */
				break;

			}

		}
		Thread.sleep(3000);
	}
	public void invoiceSelection() throws InterruptedException {
		List<WebElement> finding_ap = ldriver.findElements(By.xpath("//select[@id]//option"));
		int total_pages = finding_ap.size();
		System.out.println("total_pages:" + " " + total_pages);

		// total no.of pages
		List<WebElement> vendor_id = ldriver.findElements(By.xpath("//tr//td[3]"));

		for (int ids = 0; ids < vendor_id.size(); ids++) {
			WebDriverWait wait = new WebDriverWait(ldriver, 40);
			ldriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement a = vendor_id.get(ids);
			String id_name = a.getText();
			System.out.println("Invoice ID :" + " " + id_name);
			ldriver.findElement(By.xpath("(//a[normalize-space()=" + id_name + "])[1]")).click();
			break;
		}
	
			
			//ldriver.findElement(By.xpath("//img[@title='More Options']")).click();// kebab menu, more options.
		    /*validate.click();
			Thread.sleep(6000);
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.
					elementToBeClickable(By.xpath("//button[normalize-space()='OK']")))).click();
			Thread.sleep(6000);
			System.out.println("Siva123");
			ldriver.findElement(By.xpath("//li[3]//div[1]//*[name()='svg']")).click();
			
			try {
	            
	            WebElement nextstatus =ldriver.findElement(By.xpath("//li[3]//div[1]//*[name()='svg']"));
	            nextstatus.click();
	            
	        } catch(StaleElementReferenceException e) {
	            try {
	                Thread.sleep(500);
	            } catch (InterruptedException ie) {
	                ie.printStackTrace();
	            }
	            ldriver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
	            
	            Thread.sleep(6000);
			//approved();
			
		}*/
		}

	
	
	public void approved() throws InterruptedException {
		System.out.println("Siva123");
		validate.click();
	    WebDriverWait wait = new WebDriverWait(ldriver, 40);
		
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.
				elementToBeClickable(By.xpath("//button[normalize-space()='OK']")))).click();
		
		

	}
}
