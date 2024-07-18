package com.myiqai.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

// POM Users and role permission

public class RoleCreation {

	public WebDriver ldriver;
	public WebDriverWait wait;

	public RoleCreation(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//div[@id='root']//header//div//button//span")//  
	//body[1]/div[1]/header[1]/div[2]/button[3]
	WebElement adminsettings;

	@FindBy(xpath = "//a[normalize-space()='Settings']")
	WebElement settings;

	@FindBy(xpath = "//a[@href='#section1']")
	WebElement users_management_section;

	@FindBy(xpath = "//a[@href='/role-master']")
	WebElement rolemaster;

	@FindBy(xpath = "(//button[normalize-space()='Add Role'])[1]")
	WebElement addrolebutton;

	@FindBy(xpath = "//input[@placeholder='Role Name']")
	WebElement rolename;

	@FindBy(xpath = "//textarea[@placeholder='Max. 250 characters']")
	WebElement roledescription;

	@FindBy(xpath = "(//input[@type='checkbox'])[52]")
	WebElement invoice_role;
	
    // organisation management
	@FindBy(xpath = "(//span[contains(text(),'Select All')])[1]")
	WebElement orgmanag_role;
	
    // users management
	@FindBy(xpath = "(//input[@type='checkbox'])[37]")
	WebElement user_role;
	
    // Reports
	@FindBy(xpath = "(//input[@type='checkbox'])[74]")
	WebElement reports_role;
	
    // Task reports
	@FindBy(xpath = "(//input[@id='33'])[1]")
	WebElement task_reports;
	
    // dash board
	@FindBy(xpath = "(//span[normalize-space()='Dashboard'])[1]")
	WebElement dashboard_role;

	@FindBy(xpath = "//button[@title='Create']")

	WebElement rolecreationbutton;

	public void adminSet() {
		adminsettings.click();

	}

	public void settingS() {
		settings.click();

	}

	public void roleMaster() {
		users_management_section.click();
		rolemaster.click();
	}

	public void addRole() {
		addrolebutton.click();
	}

	public void roleName(String role_name) {
		rolename.sendKeys(role_name);

	}

	public void alertMess() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 50);

		By alert_mess = By.cssSelector("div[role='presentation']");

		wait.until(ExpectedConditions.presenceOfElementLocated(alert_mess));
		Thread.sleep(3000);
		String confirm_mess = ldriver.findElement(alert_mess).getText();

		// String confirm_mess=ldriver.findElement(By.cssSelector("")).getText();

		System.out.println("alert_mess" + " " + confirm_mess);
		

		if (confirm_mess.contains("Role Name Already Exists")) {
			System.out.println("Failure_alert_mess" + "  " + confirm_mess);

			ldriver.findElement(By.xpath("//a[normalize-space()='Cancel']")).click();

			ldriver.navigate().refresh();

		}

		// Role created successfully
		else {
			System.out.println("Success_alert_mess" + "  " + confirm_mess);
			Thread.sleep(3000);
			// ldriver.findElement(By.xpath("(//a[normalize-space()='Cancel'])[1]")).click();
		}
	}

	public void roleDescription(String role_des) throws InterruptedException {
		roledescription.sendKeys(role_des);
	
		if (role_des.contains("Invoice- View, add,assign and approval")) {
			System.out.println("hi siva435");
			Thread.sleep(3000);
			invoice_role.click();

			roleCreation();
			alertMess();

		} else if (role_des.contains("User- Add, view,Manual upload and invoice view - approval alone")) {
			System.out.println("hi siva123");

			user_role.click();
			invoice_role.click();
			task_reports.click();

			roleCreation();
			alertMess();
			Thread.sleep(3000);

		} else if (role_des.contains("View reports page")) {
			System.out.println("hi abc");
			Thread.sleep(3000);
			reports_role.click();

			roleCreation();
			alertMess();

		} else if (role_des.contains("Organisation -Add, view, email and target,Manual upload and invoice view -processed, exception, approval")) {
			//Thread.sleep(3000);
			System.out.println("hi siva");
			orgmanag_role.click();
			invoice_role.click();
			task_reports.click();

			roleCreation();
			alertMess();
			

		} else if (role_des.contains("Task reports and invoice view ")) {
			Thread.sleep(3000);
			task_reports.click();

			roleCreation();
			alertMess();

		}
	
	}

	/*
	 * public void roleInvoice() {
	 * 
	 * roleinvoice.click(); }
	 */

	public void roleCreation() throws InterruptedException {
		rolecreationbutton.click();

	}

}
