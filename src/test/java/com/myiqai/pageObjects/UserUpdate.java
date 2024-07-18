package com.myiqai.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserUpdate {
	WebDriver ldriver;
	public WebDriverWait wait;

	public UserUpdate(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//div[@id='root']//header//div//button//span")
	WebElement adminsettings;

	@FindBy(xpath = "//a[normalize-space()='Settings']")
	WebElement settings;

	@FindBy(xpath = "//a[@href='/users']")
	WebElement invite_users;

	@FindBy(xpath = "//button[@class='px-2 userMore-step']")
	
	WebElement userslistkebabicon;

	public void adminSettings() {
		adminsettings.click();

	}

	public void settingS() {
		settings.click();

	}

	public void inviteUsers() {
		// navigation_users1.click();
		wait = new WebDriverWait(ldriver, 40);
		WebElement invite_users = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/users']")));
		invite_users.click();

	}

	public void userslist() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 40);
		List<WebElement> usercard = ldriver
				.findElements(By.xpath("//h5[@class='text-light-10 break-all font-interSb text-center text-base']"));
		//wait.until(ExpectedConditions.visibilityOfAllElements(usercard));

		// div[@class='bg-light-card text-light-copy border-[1px] border-light-700
		// shadow-[0px_4px_20px_rgba(238,238,238,0.5)] relative p-[30px]
		// rounded-[10px]']
		System.out.println("No.of userscard :" + usercard.size());
		for (WebElement listingusers : usercard) {
			String usersname = listingusers.getText();
			System.out.println(usersname);
		}
		List<WebElement>kebicons=ldriver.findElements(By.xpath("//button[@id]"));
		Thread.sleep(4000);
		//List<WebElement> kebicons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@id]")));
		//wait.until(ExpectedConditions.visibilityOfAllElements(kebicons));
		System.out.println("No.of kebicons: "+kebicons.size());
		for (WebElement threedots : kebicons) {
			
			String emailaddress=threedots.getAttribute("id");
		
			System.out.println(emailaddress);
			
			if (threedots.getAttribute("id").equalsIgnoreCase("abdemouserab@iq.ai")) {
				Actions a = new Actions(ldriver);
				//scroll down a page
				//a.sendKeys(Keys.PAGE_DOWN).build().perform();
				
				/*((JavascriptExecutor) ldriver).executeScript("arguments[0].scrollIntoView(true);", threedots);
				threedots.click();*/
				
				//ldriver.findElement(By.xpath("//button[@id='saxurihi@finews.biz']")).click();
				//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='iqqiqi@myiq.co']"))).click();
				
				System.out.println("siva...12");
				//userslistkebabicon.click();
				ldriver.findElement(By.xpath("//button[@id='abdemouserab@iq.ai']")).click();
				ldriver.findElement(By.xpath("//button[normalize-space()='Edit user']")).click();
				WebElement firstname=ldriver.findElement(By.xpath("(//input[@id='DemoA'])[2]"));
				firstname.clear();
				firstname.sendKeys("Updated");
                ldriver.findElement(By.xpath("(//button[@title='To Update the User'][normalize-space()='Update'])[2]")).click();
                Thread.sleep(3000);
                break;

				// body[1]/div[3]/div[24]/div[1]/form[1]/div[1]/div[1]/input[1]
			}

		}

	}

}
