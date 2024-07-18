package com.myiqai.pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvoiceList {
	
	public WebDriver ldriver;
	public WebDriverWait wait;
	public InvoiceList(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="(//img[@alt='dashboard'])[2]")
	WebElement sidebarinvoice;
	
	@FindBy(xpath="//div[@id='mui-component-select-orgName']")
	WebElement orglayout;
	
	
	
	
	@FindBy(xpath="(//a[@href='/exception'])[1]")
	WebElement invoicelist_exceptioncard; // work around to reach the invoice list page
	
	
	
	@FindBy(xpath = "//a[normalize-space()='Invoice']")
	WebElement invoice_navigation;
	
	
	
	
	
	@FindBy(xpath = "(//select)[2]")
	WebElement total_pages;
	
	
	@FindBy(xpath="//button[normalize-space()='Create Task']")
	WebElement createtask;
	
	
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
		int layout_size=org_layout.size();
		System.out.println("Org_layout :"+layout_size);

		//for (WebElement organisation : org_layout)
		for (int i=0;i<layout_size;i++){
			
			System.out.println("123-123");
			if (org_layout.get(i).getText().equalsIgnoreCase("My iq Mac"))
//ktgfsdf com
			{
				System.out.println(org_layout.get(i).getText());
				Thread.sleep(4000);
				org_layout.get(i).click();
				
				
				/*wait = new WebDriverWait(ldriver, 30);
				WebElement lay_org = wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//li[@name='organisation_name'and @xpath='1']")));
				lay_org.click();*/
				break;
			
			}
			
			
		}
	
		
	}
	
	
	
	//// work around to reach the invoice list page
	public void invoicelistExceptionpage() {
		invoicelist_exceptioncard.click();
		// refresh icon - to display all the invoice in list page(both processed and exception)
		ldriver.findElement(By.xpath("//img[@src='/images/common/refresh.svg']")).click();
		System.out.println("123-123");
		
	}
	
	public void invoiceNavigation() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 30);
		//invoice_navigation.click();
		
        
		By navigationhover = (By.xpath("(//a[@href='/dashboard'])[3]"));
		wait.until(ExpectedConditions.elementToBeSelected(navigationhover));
		
		
		Actions act = new Actions(ldriver);
		
	
		act.moveToElement(invoice_navigation).build().perform();
		
		//Thread.sleep(3000);
		//act.moveToElement(navigationhover).moveToElement(invoiceclick).click().perform();
		WebElement invoiceclick = ldriver.findElement(By.xpath("//a[normalize-space()='Invoice']"));
		
		
		
		act.moveToElement(invoice_navigation).moveToElement(invoiceclick).click().perform();
		System.out.println("123-1");
		Thread.sleep(3000);
		//invoiceclick.click();
		
	}
	
	public void layoutSelection() {
		orglayout.click();
		List<WebElement> org_layout = ldriver.findElements(By.xpath("//li[@class]"));
		int layout_size=org_layout.size();
		for (WebElement organisation : org_layout) {
			if (organisation.getText().equalsIgnoreCase("My IQ2"))

			{
				System.out.println(organisation.getText());
				organisation.click();

			}
		}
	}
	public void totalPages() throws InterruptedException {
		List<WebElement> finding_ap = ldriver.findElements(By.xpath("//select[@id]//option"));
		int total_pages = finding_ap.size();
		System.out.println("total_pages:" + " " + total_pages);
		
		// total no.of pages
		List<WebElement> vendor_id = ldriver.findElements(By.xpath("//tr//td[3]"));
		
		
		for (int ids = 0; ids < vendor_id.size(); ids++) {
			WebDriverWait wait= new WebDriverWait(ldriver, 40);
			ldriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement a = vendor_id.get(ids);
	        String id_name	=	a.getText();
			System.out.println("Invoice ID :" + " " + id_name);
			ldriver.findElement(By.xpath("(//a[@title=\"" + id_name + "\"])[1]")).click();
			//ldriver.findElement(By.xpath("(//a[@title=" + id_name + "])[1]")).click();
			//ldriver.findElement(By.xpath("//a[@title='Inv-22-2025']")).click();
			Thread.sleep(6000);
			ldriver.findElement(By.xpath("//img[@title='More Options']")).click();// kebab menu, more options.
			//div[@id='root']//div//div//div//div//div//div//ul//li//a
			System.out.println("Siva123");
			
			
			Thread.sleep(3000);
			
			
			
			
			
			
			
			/*ldriver.findElement(By.xpath("(//img[@alt='tickW'])[1]")).click();
			ldriver.findElement(By.xpath("(//button[normalize-space()='OK'])[1]")).click();
			Thread.sleep(4000);
			ldriver.findElement(By.xpath("(//button[normalize-space()='Ok'])[1]")).click();
			ldriver.findElement(By.xpath("//img[@title='Close']")).click();
			Thread.sleep(4000);*/
			break;
			
			
		}
		
	}

	public void taskCreation() throws InterruptedException {
		// createtask.click();
		WebDriverWait wait = new WebDriverWait(ldriver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Task']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Create Task']")))
				.click();
		WebElement subject = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//body/div[@id='user-modal-root']/div/div/div/div[2]/input[1]")));

		subject.sendKeys("PO not released");

		ldriver.findElement(By.xpath("//input[@id='tags-filled']")).click();
		List<WebElement> user = ldriver.findElements(By.xpath("//ul[@id='tags-filled-listbox']"));
		int no_of_users = user.size();
		System.out.println("Number users in dropdown :" + no_of_users);
			// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='tags-filled-listbox']")));
		for(int i=0;i<no_of_users;i++) {
			user.get(i).click();
			Thread.sleep(3000);		
			break;
		}
		WebElement taskbody=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@placeholder='Write your message']")));
		taskbody.sendKeys("Take look into this Invoice");
		WebElement taskcreation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='To create todo task']")));
		taskcreation.click();
		Thread.sleep(3000);
		
	}
		
}
