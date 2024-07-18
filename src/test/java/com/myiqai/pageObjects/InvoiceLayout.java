package com.myiqai.pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvoiceLayout {
	WebDriver ldriver;
	WebDriverWait wait;
	public InvoiceLayout(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//div[@id='root']//header//div//button//span")
	WebElement adminsettings;

	@FindBy(xpath = "//a[normalize-space()='Settings']")
	WebElement settings;
	
	@FindBy(xpath="//p[contains(text(),'Take control of your invoice presentation, customi')]")
	WebElement invoicelayoutcard;
	
	
	public void adminSettings() {
		adminsettings.click();

	}

	public void settingS() {
		settings.click();

	}
	
	public void invoicelayoutCard() {
		invoicelayoutcard.click();
	}
	
	public void orglayout() throws InterruptedException {
		wait = new WebDriverWait(ldriver,50);
		ldriver.findElement(By.xpath("//div[@id='mui-component-select-countryList']")).click();
		Thread.sleep(4000);
		List <WebElement>countries=ldriver.findElements(By.xpath("//li[@name='countryList']"));
		wait.until(ExpectedConditions.visibilityOfAllElements(countries));
		for(WebElement region:countries) {
			wait.until(ExpectedConditions.visibilityOfAllElements(region));
			System.out.println(region.getText());
			if(region.getText().equalsIgnoreCase("United Kingdom")) {
				region.click();
			}
			
		}
		
	}
	
	public void savebutton() {
		wait = new WebDriverWait(ldriver,40);
		ldriver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		String alert_mess=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Modifying the invoice layout may alter the followi')]"))).getText();
		if(alert_mess.contains("Modifying the invoice layout")) {
			ldriver.findElement(By.xpath("//button[normalize-space()='Confirm']")).click();
		}
	}
	public void labeledit() throws InterruptedException {
		WebElement mousehover = ldriver.findElement(By.xpath("//body/div[@id='root']/div/div/div/div[@id='ListView']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));
		WebElement pencilelement = ldriver.findElement(By.xpath("(//img[@alt='pencilEdit'])[1]"));
		Thread.sleep(3000);
		Actions act = new Actions(ldriver);
		act.moveToElement(mousehover).click(pencilelement);
		
	}
	
	public void display() throws InterruptedException {
		ldriver.findElement(By.xpath("//body[1]/div[1]/div[3]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[2]/span[1]/input[1]")).click();
		Thread.sleep(5000);
		savebutton();
	}
	
}
