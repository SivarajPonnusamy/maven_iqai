package com.myiqai.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccrualAutomationConfig {
	WebDriver ldriver;
	WebDriverWait wait ;

	public AccrualAutomationConfig(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	@FindBy(xpath = "//div[@id='root']//header//div//button//span")
	WebElement adminsettings;

	@FindBy(xpath = "//a[normalize-space()='Settings']")
	WebElement settings;
	
	@FindBy(xpath="//p[contains(text(),'Simplify month-end processes with Accrual Automati')]")
	WebElement accrualcard;
	
	@FindBy(xpath="//div[@id='mui-component-select-OrganisationList']")
	WebElement organisationlayout;
	
	@FindBy(xpath="//tbody//td//li[1]")
	WebElement ponotreleased;
	
	@FindBy(xpath="//div[@id='mui-component-select-debit_credit']")
	WebElement drcrdropdown;
	
	@FindBy(xpath="//div[@id='mui-component-select-amount_type']")
	WebElement amountdropdown;
	
	@FindBy(xpath="//div[normalize-space()='+ Add New']")
	WebElement addnewrow;
	
	public void adminSettings() {
		adminsettings.click();

	}

	public void settingS() {
		settings.click();
	}
	
	public void accrualautomationcard() {
		accrualcard.click();
	}
	
	public void orgLayout() throws InterruptedException {
		// orglayout.click();
		wait = new WebDriverWait(ldriver, 50);
		WebElement orglayout = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id='mui-component-select-OrganisationList']")));
		orglayout.click();
		Thread.sleep(5000);
		// need to use presence of all elements for all the options...
		List<WebElement> orgLayoutOptions = wait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li")));
		int layout_size = orgLayoutOptions.size();
		System.out.println("Size of or layout :" + layout_size);
		// for (WebElement organisation : org_layout)
		for (WebElement option : orgLayoutOptions) {
			System.out.println("Option text: " + option.getText());
		}
		for (int i = 0; i < layout_size; i++) {
			System.out.println("123-123");
			if (orgLayoutOptions.get(i).getText().equalsIgnoreCase("My iq Mac")) {
				System.out.println(orgLayoutOptions.get(i).getText());
				Thread.sleep(3000);
				orgLayoutOptions.get(i).click();
				System.out.println("iquantm");
				break;

			}

		}

	}
	
	public void accountingoptions() {
		ponotreleased.click();
		
	}
	public void debitcreditDropdown() throws InterruptedException {
		drcrdropdown.click();
		List <WebElement>drcritems=ldriver.findElements(By.xpath("//ul[@role='listbox']//li"));
		for(WebElement drcroptions:drcritems) {
			String drcr=drcroptions.getText();
			System.out.println("Debit and credit dropdown options: "+drcr);
			if(drcroptions.getText().equalsIgnoreCase("debit")) {
				drcroptions.click();
				break;
			}	
		}
		WebElement acc_code=ldriver.findElement(By.xpath("//input[@placeholder='Account Code']"));
		acc_code.clear();
		acc_code.sendKeys("416300");
		
		WebElement costcenter=ldriver.findElement(By.xpath("//input[@placeholder='Cost center']"));
		costcenter.clear();
		costcenter.sendKeys("7001");
		
		WebElement description=ldriver.findElement(By.xpath("//textarea[@placeholder='Max. 250 characters']"));
		description.clear();
		description.sendKeys("Debit account without PO NOT released ");
		
		amountdropdown.click();
		Thread.sleep(3000);
		List<WebElement>amountoptions=ldriver.findElements(By.xpath("//ul[@role='listbox']//li"));
		for(WebElement optionsamt:amountoptions) {
			String amtlist=optionsamt.getText();
			System.out.println("List of options avaliable in amount dropdown: "+amtlist);
			if(optionsamt.getText().equalsIgnoreCase("Net Amount")) {
				optionsamt.click();
				Thread.sleep(3000);
				break;
				
			}
			
		}
		newrowAdd();
	}
	
	public void newrowAdd() throws InterruptedException {
		addnewrow.click();
		Thread.sleep(5000);
		//debitcreditDropdown();
		
		System.out.println("Poda");
		creditdebitDropdown();
		Thread.sleep(6000);
	}
	
	public void creditdebitDropdown() throws InterruptedException {
		//drcrdropdown.click();
		ldriver.findElement(By.xpath("//tbody/tr[2]/td[1]/div[1]/div[1]/div[1]")).click();
		List <WebElement>drcritems=ldriver.findElements(By.xpath("//ul[@role='listbox']//li"));
		for(WebElement drcroptions:drcritems) {
			String drcr=drcroptions.getText();
			System.out.println("Debit and credit dropdown options: "+drcr);
			if(drcroptions.getText().equalsIgnoreCase("credit")) {
				drcroptions.click();
				break;
			}	
		}
		WebElement acc_code=ldriver.findElement(By.xpath("(//input[@placeholder='Account Code'])[2]"));
		acc_code.clear();
		acc_code.sendKeys("416400");
		WebElement costcenter=ldriver.findElement(By.xpath("(//input[@placeholder='Cost center'])[2]"));
		costcenter.clear();
		costcenter.sendKeys("7002");
		WebElement description=ldriver.findElement(By.xpath("(//textarea[@placeholder='Max. 250 characters'])[2]"));
		description.clear();
		description.sendKeys("Credit account without PO NOT released ");
		//amountdropdown.click();
		ldriver.findElement(By.xpath("//body[1]/div[1]/div[3]/div[1]/div[3]/table[2]/tbody[1]/tr[2]/td[5]/div[1]/div[1]/div[1]")).click(); //div[@id='mui-component-select-amount_type']
		Thread.sleep(3000);
		List<WebElement>amountoptions=ldriver.findElements(By.xpath("//ul[@role='listbox']//li"));
		for(WebElement optionsamt:amountoptions) {
			String amtlist=optionsamt.getText();
			System.out.println("List of options avaliable in amount dropdown_2: "+amtlist);
			if(optionsamt.getText().equalsIgnoreCase("Net Amount")) {
				optionsamt.click();
				Thread.sleep(3000);
				break;
				
			}
			
		}
		
	}
	
	public void savebutton() {
		
		ldriver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		String alertmess=ldriver.findElement(By.xpath("(//div[@id='swal2-html-container'])[1]")).getText();
		System.out.println("Warning mess :"+alertmess);
		if(alertmess.equalsIgnoreCase("Rows should not be empty!")) {
			ldriver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
			ldriver.findElement(By.xpath("//body[1]/div[1]/div[3]/div[1]/div[3]/table[2]/tbody[1]/tr[3]/td[6]/button[1]/img[1]")).click();
			ldriver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
			ldriver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		}
		
	}
	
	

}
