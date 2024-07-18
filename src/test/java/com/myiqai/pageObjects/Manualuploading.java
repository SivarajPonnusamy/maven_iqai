package com.myiqai.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Manualuploading {
	public WebDriver ldriver;
	public WebDriverWait wait;

	public Manualuploading(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//img[@alt='fileupload-white']")
	// Prod---> 
	//body[1]/div[1]/div[3]/div[3]/a[1]
	WebElement manualuploadsticky;

	@FindBy(xpath = "//a[@href='/file-upload']")
	WebElement navigation_manualuploading;
	
	@FindBy(xpath="(//a[@tabindex='1'])[3]")
	WebElement sidebarInvoicehover;
	
	@FindBy(xpath="//div[@id='mui-component-select-orgName']")
	WebElement orglayout;
	
	//@CacheLookup
	//@FindBy(xpath="(//div[@role='button'])[2]")
	//WebElement doc_selection;
	
	@FindBy(xpath="//input[@name='image']")
	WebElement uploadfiles;
	
	@FindBy(xpath = "//button[@title='To manually upload the Invoices']")   //button[@title='To manually upload the Invoices']
	WebElement upload_bt;
	
	@FindBy(xpath ="//button[normalize-space()='Ok']")
	WebElement confirm_mess;

	public void sidebarManual() throws InterruptedException {
	
	wait = new WebDriverWait(ldriver,50);
	//By navigation_uploadClick= By.xpath("(//span[normalize-space()='Invoice Upload'])[1]");
	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@tabindex='1'])[3]")));
	

	WebElement hover_upload=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='/dashboard'])[3]")));
	System.out.println("democracy vs India");	
	Thread.sleep(3000);
	
	WebElement navigation_manualuploading= wait.until(ExpectedConditions.visibilityOfElementLocated(By.
			xpath("//a[@class='manual_upload_step  flex text-light-copy  ']")));
	Actions act = new Actions(ldriver);
	act.moveToElement(hover_upload).moveToElement(navigation_manualuploading).click().perform();
	
	//WebElement navigation_upload123 =wait.until(ExpectedConditions.elementToBeClickable(navigation_uploadClick));
	//navigation_upload123.click();
	orgLayout();
	Thread.sleep(3000);
	//navigation_manualuploading.click();
	}
	
	public void stickyUpload() throws InterruptedException {
		manualuploadsticky.click();
		Thread.sleep(3000);
		orgLayout();
	}
	
	public void orgLayout() throws InterruptedException {
		orglayout.click();
		List<WebElement> org_layout = ldriver.findElements(By.xpath("//li[@title]"));
		int layout_size=org_layout.size();
		System.out.println("Size of or layout :"+layout_size);

		//for (WebElement organisation : org_layout)
		for (int i=0;i<layout_size;i++){
			
			System.out.println("123-123");
			if (org_layout.get(i).getText().equalsIgnoreCase("My iq Mac"))
//My iq Mac
			{
				
				System.out.println(org_layout.get(i).getText());
				Thread.sleep(3000);
				org_layout.get(i).click();
				System.out.println("iquantm");
				
				
				/*wait = new WebDriverWait(ldriver, 30);
				WebElement lay_org = wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//li[@name='organisation_name'and @xpath='1']")));
				lay_org.click();*/
				break;
			
			}
			
			
		}
	
		
	}
	public void doc_type() throws InterruptedException {
	//WebDriverWait wait = new WebDriverWait(ldriver, 40);
    //WebElement doc_selection = wait.until(ExpectedConditions.elementToBeClickable(ldriver.findElement(By.xpath("//div[@role='button' and @id='mui-component-select-docType']"))));
    //doc_selection.click();
		/*WebElement doc_selection = ldriver.findElement(By.xpath("//div[@role='button'])[2]"));
		boolean isStale = false;
		while(!isStale) {
			try {
			doc_selection.click();
			isStale = true;
		}
		
		catch(StaleElementReferenceException e) {
			
			doc_selection = ldriver.findElement(By.xpath("//div[@role='button'])[2]"));
			
		}
		}*/
		
		/*Wait<WebDriver> wait = new FluentWait(ldriver)
			    .ignoring(StaleElementReferenceException.class)
			    .pollingEvery(Duration.ofMillis(500))
			    .withTimeout(Duration.ofSeconds(10));
		WebElement element = wait.until(ldriver -> {
		    WebElement ele = ldriver.findElement(By.xpath("//div[@role='button' and @id='mui-component-select-docType']"));
		    // Perform your action on the element
		    ele.click();
		    return ele;
		});*/
		
		ldriver.findElement(By.xpath("//div[@role='button' and @id='mui-component-select-docType']")).click();
		
		List<WebElement> doc_type = ldriver.findElements(By.xpath("//ul[@role='listbox']//li"));
		
		int no_of_doctypes = doc_type.size();
		System.out.println("no.of document types "+  +no_of_doctypes);
		
		
		//for(WebElement listdoctype:doc_type) 
		
		for (int i =0; i<=no_of_doctypes; i++)
		{
			String docType=doc_type.get(i).getText();
			Thread.sleep(3000);
			System.out.println("document type:"+" "+docType);
			
			
			//System.out.println(listdoctype.getText());
		
			//System.out.println("Democracy vs Communism123");
			if(docType.equalsIgnoreCase("PO Invoice")) {
				System.out.println("Democracy vs Communism 987");
				doc_type.get(i).click();
				
				
				break;
				}
			else {
				System.out.println("Something went wrong pls contact admin");
			}
			
		}

}
		
	
	
	public void uploadFiles() {
		uploadfiles.sendKeys("/Users/sivaraj/Downloads/cbbb/Consolidated_Company_wise_list/Highway_Recovery_Ltd/Highway recovery Invoice 00-060806.pdf"+"\n"+
	"/Users/sivaraj/Downloads/cbbb/Consolidated_Company_wise_list/HGV_Training_Services_Ltd/HGV Invoice 187036.pdf"+"\n"+
				"/Users/sivaraj/Downloads/cbbb/Consolidated_Company_wise_list/HGV_Training_Services_Ltd/HGV Invoice 187037.pdf"+"\n"+ 
	"/Users/sivaraj/Downloads/cbbb/Consolidated_Company_wise_list/HGV_Training_Services_Ltd/HGV Invoice 187038.pdf");
	}
	
	public void uploadBt(){
		ldriver.findElement(By.xpath("(//button[normalize-space()='Submit'])[1]")).click();
	    
	    //ldriver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
	    //upload_bt.click();
		
		
		/*WebElement upload_bt = ldriver.findElement(By.xpath("//button[normalize-space()='Submit']"));
		boolean isStale = false;
		while(!isStale) {
			try {
				upload_bt.click();
			isStale = true;
		}
		
		catch(StaleElementReferenceException e) {
			
			upload_bt = ldriver.findElement(By.xpath("//button[normalize-space()='Submit']"));
			
		}
		}*/
		//upload_bt.click();
	}
	
	public void confirmationMess() {
		confirm_mess.click();
	}

}
