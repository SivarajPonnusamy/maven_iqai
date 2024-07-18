package com.myiqai.pageObjects;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// POM
public class Addorganisation {

	public WebDriver ldriver;
	public WebDriverWait wait;

	public Addorganisation(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//div[@id='root']//header//div//button//span")
	WebElement adminsettings;

	@FindBy(xpath = "//a[normalize-space()='Settings']")
	WebElement settings;

	// @FindBy(xpath = "//p[normalize-space()='Centrally manage all our
	// Organisations setup.']")
	@FindBy(xpath = "//a[@href='/organisations']")
	WebElement addorgcard;

	@FindBy(xpath = "//a[@href='/organisations']")
	WebElement navigation_org;

	@FindBy(xpath = "//button[normalize-space()='Add Organization']")
	// "//button[normalize-space()='Add Organisation']")
	WebElement addorg_bt;

	@FindBy(xpath = "//input[@id='orgnameId']")
	// "//input[@placeholder='www.domainname.com']")
	WebElement org_domain_name;

	@FindBy(xpath = "//input[@placeholder='Enter your Organization Name']")
	WebElement org_name;

	@FindBy(xpath = "//input[@placeholder='Enter the register number']")
	WebElement reg_no;

	@FindBy(xpath = "//input[@placeholder='Enter your Organization Code']")
	WebElement orgcode;

	@FindBy(xpath = "//input[@placeholder='Enter the Address']")
	WebElement address;

	@FindBy(xpath = "//div[@role='button' and @id='mui-component-select-country_id']")
	WebElement org_country;

	@FindBy(xpath = "//button[normalize-space()='Next']")
	WebElement nxtbutton;

	@FindBy(xpath = "//div[@id='mui-component-select-is_parking']")
	WebElement parking;

	@FindBy(xpath = "//div[@id='mui-component-select-three_way_matching']")
	WebElement Threewaymatching;

	@FindBy(xpath = "//button[@title='To Create the Organization")
	WebElement btnaddneworg;

	@FindBy(xpath = "(//div[@role='alert'])[1]")
	WebElement alert;

	// @FindBy(xpath="(//div[@role='alert'])[1]")
	// WebElement failurealert;

	@FindBy(xpath = "(//button[@title='To Cancel'][normalize-space()='Cancel'])[2]")
	WebElement close_bt;

	@FindBy(xpath = "(//u[normalize-space()='Click to add'])[1]")
	WebElement addorglink;

	public void adminSettings() {
		adminsettings.click();

	}

	public void settingS() {
		settings.click();

	}

	public void addorgCard() {
		addorgcard.click();
	}

	public void sidebarOrg() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 30);
		WebElement navigation_icon = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/organisations']")));
		navigation_icon.click();

		Thread.sleep(3000);
		// navigation_org.click();

	}

	public void addorgBt() {
		addorg_bt.click();

	}

	public void orgDomainName(String orgdomainname) {
		org_domain_name.sendKeys(orgdomainname);
	}

	public void orgName(String orgname) {
		org_name.sendKeys(orgname);
	}

	public void regNo(String regno) {
		reg_no.sendKeys(regno);
	}

	public void Address(String address1) {
		address.sendKeys(address1);
	}

	public void orgCountry() {
		WebDriverWait wait = new WebDriverWait(ldriver, 30);
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@role='button' and @id='mui-component-select-country_id']")));
		dropdown.click();

		List<WebElement> orgcountries = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@role='option']")));
		System.out.println("no of countries :" + " " + orgcountries.size());

		boolean status = false;

		for (WebElement orgcountry : orgcountries) {
			if (orgcountry.getText().trim().equalsIgnoreCase("Ascension")) {
				orgcountry.click();
				status = true;
				break;
			}
		}

		if (!status) {
			System.out.println("No country is matching");
		}
	}

	/*
	 * boolean status = false; org_country.click();
	 * 
	 * //LinkedList <WebElement>orgcountries= (LinkedList)
	 * ldriver.findElements(By.xpath("//ul[@role='listbox']//li"));
	 * 
	 * wait = new WebDriverWait(ldriver, 30);
	 * 
	 * 
	 * 
	 * List<WebElement> orgcountries =
	 * ldriver.findElements(By.xpath("//li[@role='option']")); //+
	 * "//li[@role='option']"));
	 * 
	 * By org = By.xpath("//li[@role='option']");
	 * wait.until(ExpectedConditions.presenceOfElementLocated(org));
	 * 
	 * System.out.println("no of countries :" + " " + orgcountries.size());
	 * 
	 * for (WebElement orgcountries_list : orgcountries) {
	 * 
	 * if (orgcountries_list.getText().equalsIgnoreCase("United Kingdom")) {
	 * orgcountries_list.click(); status= true; break; }
	 * 
	 * } if (status==false) { System.out.println("No country is matching "); }
	 * 
	 * }
	 */

	public void orgCode(String ComCode) {
		orgcode.sendKeys(ComCode);
	}

	public void nextButton() {
		nxtbutton.click();
	}

	public void parkinG() {
		parking.click();
		List<WebElement> parkingreq = ldriver.findElements(By.xpath("//li[@class]"));
		System.out.println("Parking required :" + " " + parkingreq.size());
		for (WebElement parkdoc : parkingreq) {
			System.out.println("List of options in parking: " + " " + parkdoc.getText());
			if (parkdoc.getText().equalsIgnoreCase("Yes")) {
				parkdoc.click();
				break;
			}
		}

	}

	public void threewayMatching() {
		Threewaymatching.click();
		List<WebElement> threewaymatchreq = ldriver.findElements(By.xpath("//li[@class]"));
		System.out.println("matching required :" + " " + threewaymatchreq.size());
		for (WebElement matching : threewaymatchreq) {
			System.out.println("List of options in matching: " + " " + matching.getText());
			if (matching.getText().equalsIgnoreCase("Yes")) {
				matching.click();
				break;
			}
		}

	}

	public void btncreatenewOrg() throws InterruptedException {

		wait = new WebDriverWait(ldriver, 30);
		WebElement createbutton = ldriver
				.findElement(By.xpath("//button[@title='To Create the Organization' and @type='submit']")); // button[@title='To
																											// Create
																											// the
																											// Organization']
		wait.until(ExpectedConditions.elementToBeClickable(createbutton)).click();
		// createbutton.click();
		// System.out.println("Print Siva..");

		// alertMess();
		// System.out.println("Print Siva123..");
		Thread.sleep(4000);
		refresH();

	}

	public void addorgBts() {
		addorg_bt.click();

	}

	public void addorgLink() {
		addorglink.click();
	}

	public void refresH() {
		ldriver.navigate().refresh();
	}

	public void alertMess() throws InterruptedException {

		By alertElement = By.xpath("(//div[@role='alert'])[1]");
		wait = new WebDriverWait(ldriver, 40);

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		ldriver.switchTo().alert();
		alert.accept();

		// WebElement element = ldriver.findElement(By.id("yourElementId"));
		// ((JavascriptExecutor)
		// ldriver).executeScript("arguments[0].scrollIntoView(true);", alertElement);

		// By alertmess = By.xpath("(//div[@role='alert'])[1]");
		// //(//div[@role='alert'])[1]
		System.out.println("Sam..123");
		//// div[@role='alert']/ancestor::div[@role='presentation']
		// Thread.sleep(3000);

		String alert_mess = ldriver.findElement(alertElement).getText();
		Thread.sleep(3000);

		System.out.println("Alert mess" + " " + alert_mess);
		if (alert_mess.equalsIgnoreCase("New organisation has been created successfully.")) {
			System.out.println(alert_mess);
			// addorgBts();
			Thread.sleep(4000);
		} else {
			System.out.println(alert_mess);
			close_bt.click();
			Thread.sleep(3000);
			refresH();
			// addorgBts();
			// addorgLink();
			Thread.sleep(3000);

		}

	}

	public void orgList(String orgname) throws InterruptedException {

		List<WebElement> orglist = ldriver.findElements(By.xpath("//h5"));
		int orgcount = orglist.size();

		System.out.println(orgcount);// 17-2

		for (WebElement orglisting : orglist) {
			System.out.println(orglisting.getText());// 1st two we get empty...
			System.out.println("QWERT " + orgname);
			if (orglisting.getText().equalsIgnoreCase(orgname)) {

				Thread.sleep(3000);
				System.out.println("Karl marx vs Gandhi");
				orglisting.click();
				break;

			} else {
				System.out.println("Dr.BR.Ambedkar");
			}

		}

	}

	public void orgCountryUpdate() {
		WebDriverWait wait = new WebDriverWait(ldriver, 30);
		WebElement dropdown = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id='mui-component-select-countryValue']")));
		dropdown.click();

		List<WebElement> orgcountries = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@role='option']")));
		System.out.println("no of countries :qwerty" + " " + orgcountries.size());

		boolean status = false;

		for (WebElement orgcountry : orgcountries) {
			if (orgcountry.getText().trim().equalsIgnoreCase("Australia")) {
				orgcountry.click();
				status = true;
				break;
			}
		}

		if (!status) {
			System.out.println("No country is matching");
		}
	}

	public void OrgUpdate(String tochangeorgname, String changeddomainname, String changedorgname, String changedregno,
			String changedaddress1) throws InterruptedException {

		System.out.println("1abc " + changedorgname);

		orgList(changedorgname);// select the organization and then it get moved over here....
		WebDriverWait wait = new WebDriverWait(ldriver, 40);
		WebElement mousehover = ldriver.findElement(By.xpath("//body[1]/div[1]/div[4]/div[5]/div[2]/div[1]/div[1]"
				+ "/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]"));
		WebElement moushoverclickadd = ldriver
				.findElement(By.xpath("//body[1]/div[1]/div[4]/div[5]/div[2]/div[1]/div[1]/div[1]"
						+ "/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/button[1]"));
		Actions act = new Actions(ldriver);
		act.moveToElement(mousehover).moveToElement(moushoverclickadd).click().perform();

		org_domain_name.clear();
		org_domain_name.sendKeys(changeddomainname);
		org_name.clear();
		org_name.sendKeys(changedorgname);
		reg_no.clear();
		reg_no.sendKeys(changedregno);
		address.clear();
		address.sendKeys(changedaddress1);
		orgCountryUpdate();
		nextButton();
		ldriver.findElement(By.xpath("//button[@title='to Update']")).click();
		Thread.sleep(4000);
		refresH();

	}

}
