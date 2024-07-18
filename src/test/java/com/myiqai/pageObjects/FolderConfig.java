package com.myiqai.pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FolderConfig {
	WebDriver ldriver;
	WebDriverWait wait;
	
	public  FolderConfig(WebDriver rdriver) {
	ldriver	=rdriver;
	PageFactory.initElements(rdriver, this);
		}
	@FindBy(xpath="//a[normalize-space()='Organisation']")
	WebElement navigation_org;
	
	@FindBy(xpath = "//div[@id='root']//header//div//button//span")
	WebElement adminsettings;

	@FindBy(xpath = "//a[normalize-space()='Settings']")
	WebElement settings;

	@FindBy(xpath = "//a[@href='/organisations']")
	WebElement addorgcard;
	
	
	public void sideBarOrg() {
		wait = new WebDriverWait(ldriver, 30);
		WebElement navigation_icon =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/organisations']")));
		navigation_icon.click();
		//navigation_org.click();
	}
	
	public void adminSettings() {
		adminsettings.click();

	}

	public void settingS() {
		settings.click();

	}

	public void addorgCard() {
		addorgcard.click();
	}
	
	public void orgList() throws InterruptedException {
		List<WebElement> orglist = ldriver.findElements(By.xpath("//h5[@class='mb-2 font-interM trunc-2 max-w-[500px] xl:max-w-[180px]']"));
		int orgcount = orglist.size();
		
		System.out.println(orgcount);
		
		for(WebElement orglisting:orglist) {
			System.out.println(orglisting.getText());
			
			if(orglisting.getText().equalsIgnoreCase("My iq Mac")) {
				Thread.sleep(3000);
				System.out.println("Karl marx vs Gandhi");
				orglisting.click();
				
				break;
			}
			else {
				System.out.println("Dr.BR.Ambedkar");
			}
			
		}

	}
	
	public void folderConfig() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(ldriver, 40);
		WebElement mousehover = ldriver.findElement(By.xpath("//h4[normalize-space()='Folder']"));
		WebElement moushoverclickadd = ldriver.findElement(By.xpath("//body[1]/div[1]/div[4]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]"
				+ "/div[1]/div[2]/div[6]/div[2]/div[2]/div[1]/button[1]/span[1]"));
				
				//findElement(By.xpath("//body[1]/div[1]/div[4]/div[5]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[6]/div[2]/div[2]/div[1]/button[1]"));
				//findElement(By.xpath("//body[1]/div[1]/div[4]/div[3]/div[2]/div[1]/div[1]/div[1]"
				//+ "/div[1]/div[1]/div[2]/div[6]/div[2]/div[2]/div[1]/button[1]"));
				
				
				//QA
				/*.findElement(By.xpath("//body[1]/div[1]/div[4]/div[5]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/"
						+ "div[6]/div[2]/div[2]/div[1]/button[1]"));*/
		Actions act = new Actions(ldriver);
		act.moveToElement(mousehover).moveToElement(moushoverclickadd).click().perform();
		
		ldriver.findElement(By.xpath("(//button[@type='button'])[14]")).click();
		Thread.sleep(3000);
		
		Set<String> windowhandles =ldriver.getWindowHandles();
		System.out.println(windowhandles);
		Iterator<String> iterator = windowhandles.iterator();
		String parentwindow = iterator.next();// main window
		String childwindow = iterator.next();// o365 login window
		ldriver.switchTo().window(childwindow);
		Thread.sleep(3000);

		By o365username = By.xpath("//input[@name='loginfmt']");
		wait.until(ExpectedConditions.presenceOfElementLocated(o365username));
		ldriver.findElement(o365username).sendKeys("admin@iquantm.online");
		ldriver.findElement(By.xpath("//input[@type='submit' and @id='idSIButton9' ]")).click();
		Thread.sleep(4000);
		By o365pwd =By.xpath("//input[@name='passwd']");
		wait.until(ExpectedConditions.presenceOfElementLocated(o365pwd));
		ldriver.findElement(o365pwd).sendKeys("iquantm@143");
		ldriver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		ldriver.findElement(By.xpath("//input[@type='button']")).click();
		Thread.sleep(3000);
		ldriver.switchTo().window(parentwindow);
		WebElement foldername=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Folder Name']")));
		foldername.sendKeys("DEMOFOLDER");
		
		documentType();
		
		ldriver.findElement(By.xpath("//input[@name='signup_acceptTerms']")).click();
		//ldriver.findElement(By.xpath("(//button[@title='Create'][normalize-space()='Create'])[1]")).click();
	    Thread.sleep(2000);
		ldriver.findElement(By.xpath("//button[@title='Create' and @type='button']")).click();
		Thread.sleep(3000);
		//successAlert();
	    ldriver.navigate().refresh();
	    
		
		
		}

		public void documentType() {
			ldriver.findElement(By.xpath("//div[@id='mui-component-select-orgName']")).click();
			List<WebElement> doc_type = ldriver.findElements(By.xpath("//li[@name='invoice_type']"));
			int no_of_doctypes = doc_type.size();
			System.out.println("no.of document types "+  +no_of_doctypes);
			for(WebElement listdoctype:doc_type) {
				
				System.out.println(listdoctype.getText());
				System.out.println("Democracy vs Communism123");
				if(listdoctype.getText().equalsIgnoreCase("PO Invoice")) {
					System.out.println("Democracy vs Communism987");
					listdoctype.click();
					//
					break;
					}
				else {
					System.out.println("Something went wrong pls contact admin");
				}
			}

	}
	
		/*public void emailConfigList() {
		WebElement mousehover = ldriver.findElement(By.xpath("//h4[normalize-space()='Email']"));
	    WebElement view_email_list=	ldriver.findElement(By.xpath("(//button)[14]"));
	    Actions act = new Actions(ldriver);
	    act.moveToElement(mousehover).moveToElement(view_email_list).build().perform();
	    
		
	}*/

}
