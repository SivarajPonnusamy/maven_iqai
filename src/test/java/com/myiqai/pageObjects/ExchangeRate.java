package com.myiqai.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExchangeRate {
	WebDriver ldriver;
	WebDriverWait wait;

	public ExchangeRate(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//body/div[@id='root']/div/ul/li[5]/div[1]/a[1]")
	WebElement exchangeratesidebar1;

	@FindBy(xpath = "//a[normalize-space()='Exchange Rate']")
	WebElement exchangerate;

	@FindBy(xpath = "(//div[@role='button'][normalize-space()='Select'])[1]")
	WebElement currencydropdown;

	public void exchangerateSideBar() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 50);
		WebElement exchangeratesidebar = wait.until(ExpectedConditions.elementToBeClickable(exchangeratesidebar1));
		exchangeratesidebar.click();
		Thread.sleep(3000);
		exchangerate.click();
	}

	public void currencyDropdown() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 50);
		currencydropdown.click();
		// WebElement dropdown =
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(currencieslist)));
		List<WebElement> currencieslist = ldriver.findElements(By.xpath("//li[@title]"));
		Thread.sleep(3000);
		// wait.until(ExpectedConditions.visibilityOfAllElements(currencieslist));
		System.out.println("Size of the currency dropdown: " + currencieslist.size());
		// for(WebElement currency:currencieslist) {
		for (int i = 0; i < currencieslist.size(); i++) {
			System.out.println(currencieslist.get(i).getText());

			// System.out.println(currency.getText());
			if (currencieslist.get(i).getText().equalsIgnoreCase("GBP - British Pound Sterling")) {
				// currency.getText().contains("GBP"))
				currencieslist.get(i).click();
				break;

				// currency.click();
			}

		}

	}
	public void addvendorCurrency() {
		wait = new WebDriverWait(ldriver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='+ Add Currency']")))
				.click();
		// ldriver.findElement(By.xpath("//span[normalize-space()='+ Add
		// Currency']")).click();
		ldriver.findElement(By.xpath("//div[@id='mui-component-select-currencyCode']")).click();
		List<WebElement> vendorcurrencies = ldriver.findElements(By.xpath("//li[@role]"));
		System.out.println("Vendor currency code size: " + vendorcurrencies.size());
		for (WebElement vendorcurrencycode : vendorcurrencies) {
			System.out.println(vendorcurrencycode.getText());
			if (vendorcurrencycode.getText().contains("Belize Dollar")) {
				vendorcurrencycode.click();
				break;
			}
		}
		// Calender Pick
		ldriver.findElement(By.xpath("//div[4]//div[1]//div[1]//div[1]//div[1]//button[1]//img[1]")).click();

		// Previous month
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Previous month']//*[name()='svg']")))
				.click();
		// ldriver.findElement(By.xpath("//div[@id='mui-component-select-currencyCode']")).click();
		// date pick
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='15']"))).click();
		// ldriver.findElement(By.xpath("//button[normalize-space()='15']")).click();
		// Exchange rate setup
		ldriver.findElement(By.xpath("//input[@name='Exchange Rate']")).sendKeys("450");
		// Save button
		ldriver.findElement(By.xpath("(//button[contains(text(),'Save')])[1]")).click();

		// Alert message
		String currencyalreadyconfig = ldriver.findElement(By.xpath("(//div[@id='swal2-html-container'])[1]"))
				.getText();
		System.out.println("Already config currency: " + currencyalreadyconfig);
		if (currencyalreadyconfig.contains("This particular currency's date is already been configured")) {
			ldriver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
			ldriver.findElement(By.xpath("(//button[contains(text(),'Cancel')])[2]")).click();
			addnewvendorCurrency();

		} else {

			String sucessalertmess = ldriver.findElement(By.xpath("(//div[@id='swal2-html-container'])[1]")).getText();
			System.out.println("Vendor currency added successfully :" + sucessalertmess);
			ldriver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
		}

	}

	public void addnewvendorCurrency() {
		wait = new WebDriverWait(ldriver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='+ Add Currency']")))
				.click();
		// ldriver.findElement(By.xpath("//span[normalize-space()='+ Add
		// Currency']")).click();
		ldriver.findElement(By.xpath("//div[@id='mui-component-select-currencyCode']")).click();
		List<WebElement> vendorcurrencies = ldriver.findElements(By.xpath("//li[@role]"));
		System.out.println("Vendor currency code size: " + vendorcurrencies.size());
		for (WebElement vendorcurrencycode : vendorcurrencies) {
			System.out.println(vendorcurrencycode.getText());
			if (vendorcurrencycode.getText().contains("Chinese Yuan")) {
				vendorcurrencycode.click();
				break;
			}
		}
		// Calender Pick
		ldriver.findElement(By.xpath("//div[4]//div[1]//div[1]//div[1]//div[1]//button[1]//img[1]")).click();

		// Previous month
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Previous month']//*[name()='svg']")))
				.click();
		// ldriver.findElement(By.xpath("//div[@id='mui-component-select-currencyCode']")).click();
		// date pick
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='15']"))).click();
		// ldriver.findElement(By.xpath("//button[normalize-space()='15']")).click();
		// Exchange rate setup
		ldriver.findElement(By.xpath("//input[@name='Exchange Rate']")).sendKeys("450");
		// Save button
		ldriver.findElement(By.xpath("(//button[contains(text(),'Save')])[1]")).click();

	}

}
