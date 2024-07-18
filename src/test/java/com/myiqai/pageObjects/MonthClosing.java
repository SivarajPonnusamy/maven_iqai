package com.myiqai.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MonthClosing {
	WebDriver ldriver;
	WebDriverWait wait;
	public MonthClosing(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath = "//body/div[@id='root']/div/ul/li[5]/div[1]/a[1]")
	WebElement monthclosingsidebar1;
	
	@FindBy(xpath="//a[normalize-space()='Month Closing']")
	WebElement monthclosing;
	
	public void monthclosingSideBar() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 50);
		WebElement monthclosingsidebar=wait.until(ExpectedConditions.elementToBeClickable(monthclosingsidebar1));
		monthclosingsidebar.click();
		Thread.sleep(3000);
		monthclosing.click();

	}
	
	public void orgLayout() throws InterruptedException {
		// orglayout.click();
		wait = new WebDriverWait(ldriver, 50);
		WebElement orglayout = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id='mui-component-select-orgName']")));
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
	public void monthopened() {
		 wait = new WebDriverWait(ldriver, 50);
		WebElement datepicker=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[1]/div[1]/div[3]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]/img[1]")));
		datepicker.click();
		WebElement yearselection=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='2024']")));
		yearselection.click();
		
		WebElement monthselection = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='May']")));
		monthselection.click();
		
		
		//button[normalize-space()='May']
		//button[normalize-space()='2023']
		}
	public void updateButton() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 50);
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()='Update']"))).click();
		ldriver.findElement(By.xpath("//button[normalize-space()='Update']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@id='swal2-html-container'])[1]")));
		String alertmess= ldriver.findElement(By.xpath("(//div[@id='swal2-html-container'])[1]")).getText();
		System.out.println("Pop mess if the user not configured the accrual: "+alertmess);
		
		String updatation_mess=ldriver.findElement(By.xpath("(//div[@id='swal2-html-container'])[1]")).getText();
		System.out.println("Month Closing updatation mess:"+updatation_mess);
		
		if(alertmess.contains("You haven't posted accrual")) {
			ldriver.findElement(By.xpath("//button[normalize-space()='Continue']")).click();
			Thread.sleep(3000);
		}
		else if(updatation_mess.contains("Make any necessary changes to save!")) {
			wait = new WebDriverWait(ldriver, 50);
			ldriver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
			Thread.sleep(3000);
			//wait.until(ExpectedConditions.elementToBeClickable("//button[normalize-space()='Update']"));
			ldriver.findElement(By.xpath("//button[normalize-space()='Update']")).click();
			
			
		}
		else {
			ldriver.findElement(By.xpath("//button[normalize-space()='Update']")).click();
		}
		
		
	}

}
