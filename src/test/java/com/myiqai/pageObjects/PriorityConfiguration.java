package com.myiqai.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PriorityConfiguration {
	WebDriver ldriver;
	public PriorityConfiguration(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		}
	
	@FindBy(xpath = "//div[@id='root']//header//div//button//span")
	WebElement adminsettings;
	
	@FindBy(xpath = "//a[normalize-space()='Settings']")
	WebElement settings;
	
	@FindBy(xpath="//a[@href='/priority-config']")
	WebElement configprioritycard;
	
	public void adminSettings() {
		adminsettings.click();

	}

	public void settingS() {
		settings.click();

	}
	
	public void configprioritesCard() {
		configprioritycard.click();
	}
	
	public void radioButton() throws InterruptedException {
		ldriver.findElement(By.xpath("(//input[@name='radio-buttons'])[1]")).click();
		ldriver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]")).clear();
		ldriver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]")).sendKeys("7");
		ldriver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		
	/*	List<WebElement>radiobuttons=ldriver.findElements(By.xpath("//tr/td/input"));
				//tr/td/input
				//ldriver.findElements(By.xpath("//input[@name='radio-buttons']"));
		int no_of_buttons=radiobuttons.size();
		System.out.println("NO of buttons"+no_of_buttons);
		for(WebElement rad:radiobuttons) {
			System.out.println(rad.getText());
			
			if(rad.getText().equals("Urgent")) {
				ldriver.findElement(By.xpath("(//input[@name='radio-buttons'])[1]")).click();
				//rad.click();
				Thread.sleep(5000);
			    ldriver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]")).sendKeys("5");
			    Thread.sleep(5000);
			    ldriver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
			    break;
				
			}
		}*/
		
	}
	
	
	
	

}
