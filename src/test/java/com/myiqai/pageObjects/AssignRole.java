package com.myiqai.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignRole {

	public WebDriver ldriver;
	public WebDriverWait wait;

	public AssignRole(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath="//a[normalize-space()='Users']")
	WebElement navigation_users;
	
	@FindBy(xpath="//button[@class='px-2 userMore-step']")
	WebElement kebabicon;
	
	@FindBy(xpath = "//button[normalize-space()='Add Organisation']")
	WebElement addorganisation;
	
	@FindBy(xpath="//input[@placeholder='Select Organisations']")
	
	//body[1]/div[3]/div[14]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]
	//body/div[@id='user-modal-root']/div[6]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]
	//body/div[@id='user-modal-root']/div[14]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]
	WebElement selectorg;
	
	@FindBy(xpath="//button[@title='Create']")
	
	WebElement createbt;
	
	@FindBy(xpath="(//div[@role='button'][normalize-space()='Select Role'])[1]")
	
	WebElement addrole;
	
	//@FindBy(xpath="//ul[@role='listbox']//li")
	//WebElement orgdropdown;
	
	@FindBy(xpath="//li[contains(text(),'Super Admin')]")
	WebElement defaultsuperadmin;
	
	public void navigationUsers() {
		wait = new WebDriverWait(ldriver, 40);
		By users_navigation = By.linkText("Users");
		wait.until(ExpectedConditions.presenceOfElementLocated(users_navigation));
		ldriver.findElement(users_navigation).click();
		//navigation_users.click();
	}
	
	public void usersList(String usersemail,String org_name_dropdown,String roles_dropdown) throws InterruptedException {
		List<WebElement> users_email_list = ldriver.findElements(By.xpath("//input[@value and @placeholder='example@email.com']"));//body[1]/div[1]/div[2]/div[1]/div[2]
		int usersemailcount = users_email_list.size();
		System.out.println("USERSCOUNT :"+" "+usersemailcount);
		
		for (WebElement usersemaillisting : users_email_list) {
			
			String onebyoneEMAIL = usersemaillisting.getAttribute("value");
			
			System.out.println(onebyoneEMAIL);
			
			Thread.sleep(1500);
			
			System.out.println("current data from external file (user email column):"+"  "+usersemail);
			
			if(usersemaillisting.getAttribute("value").contains(usersemail)) {
				
			WebElement searchbox =	ldriver.findElement(By.xpath("//input[@name='search']"));
			
			searchbox.clear();
			
			searchbox.sendKeys(usersemail);
			
			Thread.sleep(3000);
			
			selectOrg( org_name_dropdown, roles_dropdown);
			break;
			}
			//else if() {
				
		//	}
		
			else {
				
				ddefault();
			}
			
		}
	}
	
	public void kebabIcon() {
		kebabicon.click();
		
	}
	
	public void addOrganisation() {
		addorganisation.click();
	}
	public void selectOrg(String org_name_dropdown,String roles_dropdown) throws InterruptedException  {
		kebabicon.click();
		addorganisation.click();
		selectorg.click();
		List<WebElement> orgdropdown = ldriver.findElements(By.xpath("//ul[@role='listbox']//li"));
		int totalorg = orgdropdown.size();
		
		System.out.println("total org in dropdown :" + " " + totalorg);
		
		
		for (int i=0;i<=totalorg;i++) {
		
			String orgnames_onebyone  = orgdropdown.get(i).getText();
			
			System.out.println(orgnames_onebyone);
			
			System.out.println("current data from external file (org name column):"+" "+org_name_dropdown);
			
			boolean isExpectedOptionNotPresent = orgdropdown.stream().noneMatch(option -> option.getText().equals(orgnames_onebyone));
			
			if (orgnames_onebyone.contains(org_name_dropdown)) {
				orgdropdown.get(i).click();
				createBt();
				addRole(roles_dropdown);
			    break;
			}
			
			else if (isExpectedOptionNotPresent){
			
				System.out.println("No organisation options is present in the dropdown");
				
			}
			else {
				System.out.println("Not matching list: "+orgnames_onebyone +" and "+ org_name_dropdown);
				
			}
			
			
		}
		
		Thread.sleep(3000);
		ldriver.navigate().refresh();
		
	}
		
	public void ddefault() {
		System.out.println("NOT IN GIVEN LIST so only printing super admin:"+" "+defaultsuperadmin.getText());
		
		

	}
	public void createBt() {
		
		createbt.click();
		/*By alert_mess = By.cssSelector("div[role='presentation']");
		String alert_mess=ldriver.findElement(By.xpath("(//p[normalize-space()='Please Select Role and Organisation'])[1]")).getText();*/
	}
	
	
	public void addRole(String roles_dropdown) throws InterruptedException  {
		
		addrole.click();
		
		List<WebElement> rolelist = ldriver.findElements(By.xpath("//ul[@role='listbox']//li"));
		int no_of_roles = rolelist.size();
		System.out.println("Number of roles in the drp_down :" + +no_of_roles);
	
				
		//Select roledropdown = new Select(addrole);
		//List<WebElement> allroles = roledropdown.getOptions();
		//int total_roles = allroles.size();
		
		//System.out.println("total no of roles:"+" "+total_roles);
		
		for (int i=0;i<=no_of_roles;i++) {
			String rolenames_onebyone  = rolelist.get(i).getText();
				System.out.println(rolenames_onebyone);
				System.out.println("current data from external file (roles name column):"+" "+roles_dropdown);
		if(rolenames_onebyone.equalsIgnoreCase(roles_dropdown)) {
			
			System.out.println(" Matching : "+ rolenames_onebyone + " and "+ roles_dropdown);
			rolelist.get(i).click();
			Thread.sleep(3000);
			createBt();
		
			break;
			
			//roledropdown.selectByVisibleText(roles_dropdown);

		}
		else {
			System.out.println("Not matching list: "+ rolenames_onebyone + " and "+ roles_dropdown);
		}
		
		}
		ldriver.navigate().refresh();
		Thread.sleep(3000);
		System.out.println("Roles are assigned successfully");
	}

}
