package com.myiqai.pageObjects;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AccrualAccounting {
	WebDriver ldriver;
	WebDriverWait wait;
	

	public AccrualAccounting(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//body/div[@id='root']/div/ul/li[5]/div[1]/a[1]")
	WebElement accrualsidebar;
	@FindBy(xpath = "//a[normalize-space()='Accrual']")
	WebElement accrualacctab;

	public void accrualSideBar() throws InterruptedException {
		accrualsidebar.click();
		Thread.sleep(4000);
		accrualacctab.click();

	}

	public void accountingTable() throws InterruptedException {
		boolean status = false;
		List<WebElement> allheaders = ldriver
				.findElements(By.xpath("//div[@id='root']//div//div//div//table//thead//tr"));

		System.out.println("No.of Headers: " + allheaders.size());

		for (WebElement headers : allheaders) {
			String headername = headers.getText();
			System.out.println(headername);
			if (headername.contains("Organization")) {
				status = true;
			}
			Assert.assertTrue(status, "Header is not present");

		}

		List<WebElement> alldata = ldriver.findElements(By.xpath("//p[@title]"));
		//div[@id='root']//div//div//div//table
		
		
		System.out.println("No.of datas present in that table: " + alldata.size());
		for (WebElement datas : alldata) {
			String dataintable = datas.getText();
			System.out.println("Test233 :"+dataintable);
			if (dataintable.contains("My iq Mac")) {
				
				 String rowIndex;
				try {
					
		            // Construct the XPath to find the row number of the given organization
		            String rowXPath = "//p[contains(@title, 'My iq Mac')]";
		            
		            /* "//table/tbody/tr[td[2][contains(text(),'" + organizationName + "')]]";
		            "//th[contains(normalize-space(), 'Organization')]"
		            //p[@title='food']*/

		            // Find the row using the constructed XPath
		            WebElement row = ldriver.findElement(By.xpath(rowXPath));
		           String organisationname=row.getText();
		            System.out.println("Org name for the user given org: "+organisationname);

		            // Get the row index
		             rowIndex = row.getAttribute("id");
		             System.out.println("Index number of corresponding org :"+rowIndex);

		            // Construct the dynamic XPath for the action link
		            String dynamicXPath = "//table/tbody/tr[" + rowIndex + "]/td[4]/a[1]";
		            		//table/tbody/tr[" + rowIndex + "]/td[4]/a[1]"
		          //table//tbody//tr//td[@name="+rowIndex+ "]
		            WebElement actionLink = ldriver.findElement(By.xpath(dynamicXPath));
		            System.out.println("Action link to be cliked : "+actionLink.getText());
	

		            // Perform actions on the element
		            actionLink.click();
		            
		            Thread.sleep(5000);
		        } 
				catch (NoSuchElementException e) {
		            System.out.println("Organization not found in the table.");
		            System.out.println("type of exception: "+e);
		        }
				
				//ldriver.findElement(By.xpath("//body[1]/div[1]/div[3]/div[1]/div[3]/table[1]/tbody[1]/tr["+rowIndex+"]/td[4]/a[1]")).click();
				
				//body[1]/div[1]/div[3]/div[1]/div[3]/table[1]/tbody[1]/tr[" + rowIndex + "]/td[4]/a[1]"
				
				
				status = true;
				break;
			}
			Assert.assertTrue(status, "Data is not present");

		}

	}
	public void accrualdate() {
		  wait = new WebDriverWait(ldriver, 50);
		  //driver.findElement(By.cssSelector("input[name='field-0']"))
	       // WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='field-0'])[1]")));
	        WebElement checkbox =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("(//input[@id='1'])[1]")));
	        checkbox.click();
		// ldriver.findElement(By.xpath("(//input[@name='field-0'])[1]")).click();
	     //(//*[name()='svg'][@focusable='false'])[1]
	        
		System.out.println("Siva..");
		WebElement datepicker=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(@aria-label, 'Choose date')])[1]")));
		datepicker.click();
		//ldriver.findElement(By.xpath("(//button[contains(@aria-label, 'Choose date')])[1]")).click();
		WebElement dateselection=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='25']")));
		dateselection.click();
		//ldriver.findElement(By.xpath("//button[normalize-space()='25']")).click();
		
		}
	public void saveButton() {
		ldriver.findElement(By.xpath("//button[normalize-space()='Post']")).click();
	}
	
}
