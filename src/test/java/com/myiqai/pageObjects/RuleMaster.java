package com.myiqai.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Iterator;

// POM Rule master
public class RuleMaster {

	public WebDriver ldriver;
	public WebDriverWait wait;

	public RuleMaster(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//div[@id='root']//header//div//button//span")
	WebElement adminsettings;

	@FindBy(xpath = "//a[normalize-space()='Settings']")
	WebElement settings;

	@FindBy(xpath = "//a[@href='/invoice-rule']")
	WebElement rule_card;

	@FindBy(xpath = "//button[normalize-space()='New Rule']")
	WebElement new_rulebutton;

	//
	@FindBy(xpath = "//div[@id='mui-component-select-documentGroup']")
	WebElement doctyperule;

	@FindBy(xpath = "//input[@id='rulebar']")
	// input[@id='rulebar']
	WebElement rule_name;

	@FindBy(xpath = "//textarea[@placeholder='Max. 250 characters' and @name='description']")
	WebElement rule_des;

	// rule field
	@FindBy(xpath = "//div[@role='button'and @id='mui-component-select-filed-0']")
	WebElement rulefield;

	@FindBy(xpath = "//button[@title='Save']")
	WebElement rulesave;

	public void adminSettings() {
		adminsettings.click();

	}

	public void settingS() {
		settings.click();

	}

	public void ruleCard() {
		rule_card.click();

	}

	public void newruleButton() {
		new_rulebutton.click();

	}

	public void doctypeRule(String rulename) throws InterruptedException {
		
		doctyperule.click();
		Thread.sleep(4000);		
		List<WebElement> doctypes = ldriver.findElements(By.xpath("//ul[@role='listbox']//li"));
		for (WebElement doctype : doctypes) {
			System.out.println(doctype.getText());
			if (doctype.getText().equalsIgnoreCase("Retention Release")) {
				doctype.click();
				ruleName(rulename);

			}

		}

		/*
		 * Iterator<WebElement>doctypesiterator=doctypes.iterator();
		 * while(doctypesiterator.hasNext()){ Object typesdoc=doctypesiterator.next();
		 * System.out.println(typesdoc); }
		 */

	}

	public void ruleName(String rulename) {
		rule_name.sendKeys(rulename);
	}

	public void ruleDescription(String ruledescription, String Operators, String VendorCountry, String Currency)
			throws InterruptedException {
		rule_des.sendKeys(ruledescription);
		rulefield.click();
		WebDriverWait wait = new WebDriverWait(ldriver, 50);

		// WebElement ul =
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@role='listbox']")));
		// List<WebElement> fieldtypes = ul.findElements(By.xpath(".//li"));

		Thread.sleep(3000);
		List<WebElement> fieldtypes = wait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[@class]")));

		int field_count = fieldtypes.size();

		System.out.println("Field types " + " " + field_count);

		// field selection

		for (WebElement single_field : fieldtypes) {
			// System.out.println("hi siva");
			String fieldname = single_field.getText();

			System.out.println(fieldname);// vendor name

			if (ruledescription.equalsIgnoreCase("Vendor Country") || ruledescription.equalsIgnoreCase("Currency")) {

				if (ruledescription.contains(single_field.getText())) {
					System.out.println(ruledescription);
					single_field.click();
					ldriver.findElement(By.xpath("//div[@id='mui-component-select-fileds-0' and @role='button']"))
							.click();
					List<WebElement> list_operators = wait.until(
							ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li")));
					// li[normalize-space()='=']
					int operators_count = list_operators.size();
					System.out.println("Number of operators" + " " + operators_count);

					// operator selection
					for (WebElement operatorsList : list_operators) {
						wait = new WebDriverWait(ldriver, 40);

						wait.withMessage(operatorsList.getText());
						operatorsList.getText();
						System.out.println(wait.withMessage(operatorsList.getText()));

						Thread.sleep(4000);
						System.out.println("DLF");
						if (operatorsList.getText().contains(Operators)) {
							System.out.println("1234");
							System.out.println("Operators from XL Sheet: " + Operators);
							operatorsList.click();
							Thread.sleep(3000);

							// Vendor country drop down selection :
							ldriver.findElement(By.xpath("//input[@id='checkboxes-tags-demo']")).click();
							List<WebElement> vendorcountry = wait
									.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
											By.xpath("//ul[@id='checkboxes-tags-demo-listbox']//li")));
							int vendorcountry_count = vendorcountry.size();
							System.out.println("Number of operators" + " " + vendorcountry_count);

							// operator selection
							for (WebElement vendorcountrylist : vendorcountry) {
								Thread.sleep(3000);
								System.out.println(vendorcountrylist.getText());

								if (vendorcountrylist.getText().contains(VendorCountry)) {
									vendorcountrylist.click();
									ruleSave();
									break;
									

								} else {
									System.out.println("Country not matched with given data...");

								}

							}
						}
					}
				}

			}

			else {

				if (ruledescription.contains(single_field.getText())) {

					System.out.println("From XLSheet: " + ruledescription);

					System.out.println("hi siva");

					single_field.click();
					// operators field.
					ldriver.findElement(By.xpath("//div[@id='mui-component-select-fileds-0' and @role='button']"))
							.click();

					List<WebElement> list_operators = wait.until(
							ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[@name='operators']")));
					int operators_count = list_operators.size();
					System.out.println("Number of operators" + " " + operators_count);

					// operator selection
					for (WebElement operatorsList : list_operators) {
						Thread.sleep(3000);
						System.out.println(operatorsList.getText());

						if (operatorsList.getText().contains(Operators)) {
							// Operators.equalsIgnoreCase(operatorsList.getText())) {
							operatorsList.click();
							Thread.sleep(3000);
							System.out.println("hi isai-1");
							// JavascriptExecutor js = (JavascriptExecutor) ldriver;
							// boolean isElementVisible = (boolean) js.executeScript("return
							// arguments[0].style.display === 'block';", ldriver.findElement(By.id("")));

							if (ruledescription.equalsIgnoreCase("Vendor Name")) {

								WebElement dynamicfieldElement = wait.until(ExpectedConditions
										.visibilityOfElementLocated(By.xpath("//input[@id='tags-filled']")));
								dynamicfieldElement.sendKeys("A");
							} else {
								WebElement valuefield = wait.until(ExpectedConditions
										.visibilityOfElementLocated(By.xpath("//input[@placeholder='Input Value']")));
								valuefield.sendKeys("7000");

							}
							// ldriver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/div[1]/div[1]/div[1]")).sendKeys("a");
							// ldriver.findElement(By.xpath("//button[normalize-space()='+ Add
							// New']")).click();

							// ldriver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
							ruleSave();
							break;

						}

					}

				}
			}
			/*
			 * if (ruledescription.contains(single_field.getText())) {
			 * System.out.println(ruledescription); single_field.click();
			 * ldriver.findElement(By.
			 * xpath("//div[@id='mui-component-select-fileds-0' and @role='button']")).click
			 * (); List<WebElement> list_operators_netamount = wait
			 * .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
			 * "//li[@name='operators']"))); int net_operatorsCount =
			 * list_operators_netamount.size();
			 * System.out.println(" no.of operators - netAmount" + " " +
			 * net_operatorsCount); for (WebElement operatorsList_net :
			 * list_operators_netamount) { Thread.sleep(3000);
			 * System.out.println(operatorsList_net.getText()); if
			 * (Operators.contains(operatorsList_net.getText())) {
			 * operatorsList_net.click(); Thread.sleep(3000);
			 * System.out.println("hi isai-2"); WebElement dynamicfieldElement = wait.until(
			 * ExpectedConditions.visibilityOfElementLocated(By.
			 * xpath("//input[@placeholder='Input Value']")));
			 * dynamicfieldElement.sendKeys("7000");
			 * ldriver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
			 * //break;
			 * 
			 * 
			 * } }
			 * 
			 * }
			 */

		}
	}

	public void ruleSave() throws InterruptedException {
		rulesave.click();
		wait = new WebDriverWait(ldriver, 40);
		WebElement rulealert = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[2]")));

		String rulealertmess = ldriver.findElement(By.xpath("(//div[@role='alert'])[2]")).getText();
		System.out.println("Alert message :" + rulealertmess);
		Thread.sleep(3000);
		if (rulealertmess.equalsIgnoreCase("Rule Name already exists...")) {

			ldriver.findElement(By.xpath("//a[@title='Cancel']")).click();
		} else {
			System.out.println("124");
			System.out.println(rulealertmess);
		}

	}

}
