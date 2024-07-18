package com.myiqai.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdvanceRequest {
	WebDriver ldriver;
	WebDriverWait wait;

	public AdvanceRequest(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//img[@src='/images/MyiQ-icons/invoice.svg']")
	WebElement invoicesidebar;

	@FindBy(xpath = "//a[normalize-space()='Advance']")
	WebElement advancerequest;

	@FindBy(xpath = "//a[@title='To Create New Mobilization Request']")
	WebElement mobilisationcreation;
	
	@FindBy(xpath="//div[@id='mui-component-select-orgName']")
	WebElement orglayout;

	public void advancerequestnavigation() throws InterruptedException {
		Thread.sleep(4000);
		wait = new WebDriverWait(ldriver, 50);
		WebElement invociesidebar1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/images/MyiQ-icons/invoice.svg']")));
		invociesidebar1.click();
		
		//li[2]//div[@class='undefined']
		Thread.sleep(4000);
		WebElement advancerequest = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Advance']")));
		advancerequest.click();
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

				/*
				 * wait = new WebDriverWait(ldriver, 30); WebElement lay_org =
				 * wait.until(ExpectedConditions .presenceOfElementLocated(By.
				 * xpath("//li[@name='organisation_name'and @xpath='1']"))); lay_org.click();
				 */
				break;

			}

		}

	}
	
	public void createMobilisation() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 50);
		mobilisationcreation.click();
		WebElement ponumber=ldriver.findElement(By.xpath("//input[@placeholder='Enter PO number']"));
		ponumber.sendKeys("8000000176");
		Thread.sleep(4000);
		ldriver.findElement(By.xpath("(//tr)[2]")).click();
		System.out.println("Siva");
		//ponumber.click();
		String vendorName=ldriver.findElement(By.xpath("//input[@placeholder='Vendor Name']")).getText();
		System.out.println("VendorName of the given number: "+vendorName);
		if(vendorName.equalsIgnoreCase("ALBION AUTOMOTIVE LTD")) {
			System.out.println("Entered PO is correct");
		}
		else {
			System.out.println("Entered PO is Incorrect");
		}
		Thread.sleep(3000);
		ldriver.findElement(By.xpath("//input[@placeholder='Enter reference number']")).sendKeys("Test_123");	
		ldriver.findElement(By.xpath("//input[@name='adv_amount']")).sendKeys("10");
		Thread.sleep(3000);
		Actions actions = new Actions(ldriver);
		 WebElement glindicator=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='input4'])[1]")));
		 actions.moveToElement(glindicator).perform();
		 glindicator.click();
		//ldriver.findElement(By.xpath("(//div[@id='input4'])[1]")).click();
		Thread.sleep(3000);
		
		List<WebElement>gldropdown=ldriver.findElements(By.xpath("//ul[@role='listbox']//li"));
		Thread.sleep(4000);
		System.out.println("Size of the Spl GL Indicator: "+gldropdown.size());
		for(WebElement splGLIndicator:gldropdown) {
			System.out.println("List of GL Indicator: "+splGLIndicator.getText());
			Thread.sleep(3000);
			if(splGLIndicator.getText().equalsIgnoreCase("A")) {
				splGLIndicator.click();
				Thread.sleep(3000);
				break;
			}
			else {
				System.out.println("There is no desired Spl GL indicator");
			}
			
		}
		
	}
	public void savebutton() throws InterruptedException {
		Thread.sleep(3000);
		/*wait = new WebDriverWait(ldriver, 50);
		Actions actions = new Actions(ldriver);
		 WebElement savebutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Save']")));
		 actions.moveToElement(savebutton).perform();
		 savebutton.click();*/
		((JavascriptExecutor) ldriver).executeScript("window.scrollBy(0, -document.body.scrollHeight);");

		ldriver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		
	}
}
