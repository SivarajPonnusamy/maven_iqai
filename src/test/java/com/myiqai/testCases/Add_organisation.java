package com.myiqai.testCases;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.myiqai.base.Base_test;
import com.myiqai.pageObjects.Addorganisation;
import com.myiqai.utilities.XLUtils;

public class Add_organisation extends Base_test {

	int rownum;
	Addorganisation addorg;

	@Test
	public void add_org() throws InterruptedException {
		addorg = new Addorganisation(driver);
		addorg.adminSettings();
		addorg.settingS();
		addorg.addorgCard();
		// addorg.sidebarOrg();
		//System.out.println("check.....123");
		
	}

	@Test(dataProvider = "addorganisation")
	public void add_organisation(String orgdomainname, String orgname, String regno, String address1,String orgcode,
			String updateorgdomainname, String updateorgname, String updateregno, 
			String updateaddress)
			throws InterruptedException {
		    addorg = new Addorganisation(driver);
		//System.out.println("Add org " + rownum);
		for (int i = 1; i <= rownum;) {

			addorg.addorgBt();
			addorg.orgDomainName(orgdomainname);
			Thread.sleep(3000);
			addorg.orgName(orgname);
			addorg.regNo(regno);
			addorg.orgCode(orgcode);
			addorg.Address(address1);
			addorg.orgCountry();
			Thread.sleep(5000);
			addorg.nextButton();
			Thread.sleep(3000);
			//addorg.parkinG();
			
			//addorg.threewayMatching();
			//Thread.sleep(3000);
			
			addorg.btncreatenewOrg();
			Thread.sleep(5000);
			/*addorg.orgList(orgname);
			addorg.OrgUpdate(updateorgdomainname, updateorgname, updateregno, updateaddress);
			Thread.sleep(4000);
			driver.navigate().refresh();*/
			
			break;

		}
	}
	
	/*@Test(dataProvider = "addorganisation", priority = 3)
	public void updateorg(String orgdomainname, String orgname, String regno, String address1,String updateorgdomainname, 
			String updateorgname, String updateregno, 
			String updateaddress) throws InterruptedException
	{
		addorg = new Addorganisation(driver);
		//addorg.orgList(orgname);
		for (int i = 1; i <= rownum;) {
			addorg.OrgUpdate(orgname, updateorgdomainname, updateorgname, updateregno, updateaddress);
			driver.navigate().refresh();
			break;
		}
	}*/
	
	
	/*
	 * @DataProvider(name="addorganisation") public Object[][] logintest() { return
	 * new Object[][] { { "www.zzdaikin.com", "ZZDaikin pvt ltd",
	 * "Dk-12345","LEEDS,Prince Sqaure,UK" }
	 * 
	 * }; }
	 */

	@DataProvider(name = "addorganisation")
	public String[][] getOrgData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/resources/testData/addorg_data1.xlsx";
		rownum = XLUtils.getRowCount(path, "addorg");
		System.out.println("RowNmber:"+rownum);// starts from zero.; 0, 1,2,3...
		XLUtils.fillColour(path, "addorg",1,2);
		
		int cellnum = XLUtils.getCellCount(path, "addorg", 1);
		System.out.println("ColumnNmber:"+cellnum);// starts from 1, 2,3,4....
		String orgdata[][] = new String[rownum][cellnum];
		//System.out.println("From XL Sheet add_orgData: "+Arrays.deepToString(orgdata));
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < cellnum; j++) {
				orgdata[i - 1][j] = XLUtils.getCellData(path, "addorg", i, j);// here the data fetch from xl sheet and store in
				// orgdata 2D array which should be start from [0][0], thats y [i-1][j]=[1-1][0],[0][0]
				System.out.println(orgdata[i - 1][j] = XLUtils.getCellData(path, "addorg", i, j));
				
			}
		}
		return orgdata;
	}

}