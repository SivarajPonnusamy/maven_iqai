package com.myiqai.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Profile {
	WebDriver ldriver;
	public Profile(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath = "//div[@id='root']//header//div//button//span")
	WebElement adminsettings;
	
	@FindBy(xpath="//a[@title='Profile']")
	WebElement profile;
	
	@FindBy(xpath="//button[normalize-space()='Edit Profile']")
	WebElement editprofile;
	
	@FindBy (xpath="(//input[@name='firstname'])[1]")
	WebElement first_name;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement last_name;
	
	@FindBy(xpath="//input[@class='form-control ']")
	WebElement mob_num;
	
	
	@FindBy(xpath="//div[@id='mui-component-select-country']")
	WebElement countrydropdown;
	
	@FindBy(xpath="//button[@title='To update the Profile changes']")
	WebElement profileupdate;
	
	@FindBy(xpath="(//button[@role='tab'])[2]")
	WebElement settingstab;
	
	@FindBy(xpath="(//button[@role='tab'])[3]")
	WebElement pwd;
	
	@FindBy(xpath="(//input[@type='password'])[1]")
	WebElement currentpwd;
	
	@FindBy(xpath="(//input[@type='password'])[2]")
	WebElement newpwd;
	
	@FindBy(xpath="(//input[@type='password'])[3]")
	WebElement confirmpwd;
	
	@FindBy(xpath="//button[@title='To Change the Password']")
	WebElement changepwd;
	
	
	public void adminSettings() {
		adminsettings.click();

	}
	
	public void profile() {
		profile.click();
	}
	
	public void editProfile() {
		editprofile.click();
	}
	public void firstName(String firstname) {
		first_name.clear();
		first_name.sendKeys(firstname);
	}
	public void lastName(String lastname) {
		last_name.clear();
		last_name.sendKeys(lastname);
	}
	public void mobileNumber(String mobnumber) {
		mob_num.clear();
		mob_num.sendKeys(mobnumber);
	}
	
	public void countryDropDown() throws InterruptedException {
		boolean status = false;
		//String selected_country=countrydropdown.getText();
		
		System.out.println("Already selected country : "+countrydropdown.getText());
		Thread.sleep(3000);
		countrydropdown.click();
		
		WebDriverWait wait = new WebDriverWait(ldriver,30);
		ldriver.findElement(By.xpath(""));
		
		//List <WebElement>countries=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li")));
		
		List<WebElement> countries=ldriver.findElements(By.xpath("//ul[@role='listbox']"));

		//   //li[@name='country']
		//Thread.sleep(3000);
		System.out.println("No of countries :" + " " + countries.size());
		for(WebElement country:countries) {
			if (country.getText().equalsIgnoreCase("India")) {
		        country.click();
		        status = true;
		        break;
		    }
			if(!status) {
				System.out.println("No country is matched");
			}
			}
			
		}
	public void profileUpdate() {
		profileupdate.click();
		
	}
	public void settingsTab() {
		settingstab.click();
	}
	public void passWord() {
		pwd.click();
		currentpwd.sendKeys("Test@1234");
		newpwd.sendKeys("Test@123");
		confirmpwd.sendKeys("Test@123");
}
	
	public void changePassword() {
		changepwd.click();
	}
	
	
	
	}
	

	
		
	


