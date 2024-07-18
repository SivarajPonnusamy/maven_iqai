package com.myiqai.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.myiqai.base.Base_test;
import com.myiqai.pageObjects.AssignRole;
import com.myiqai.utilities.XLUtils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Assign_role extends Base_test{
	int rownum;
	public AssignRole role;
	@Test(priority=1)
	public void assignRoless() {
		System.out.println("USA vs USSR");
		role = new AssignRole(driver);
		role.navigationUsers();
		System.out.println("Democracy vs Communism");
	}
	
	@Test(dataProvider="assignrole",priority=2)
	public static void assignRole(String username,String org_name_dropdown, String roles_dropdown ) throws InterruptedException {
		AssignRole role = new AssignRole(driver);
		
		role.usersList(username,org_name_dropdown,roles_dropdown);
		//role.kebabIcon();
		//role.addOrganisation();
		
		//role.selectOrg();
		Thread.sleep(3000);
		//role.createBt();
		
		//role.addRole();
		Thread.sleep(3000);
		//role.createBt();
		//Thread.sleep(3000);
		
		
	}
	@DataProvider(name = "assignrole")
	public String[][] getOrgData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/resources/testData/assign_role.xlsx";
		rownum = XLUtils.getRowCount(path, "assign_role");
		int cellnum = XLUtils.getCellCount(path, "assign_role", 1);
		String assignrole[][] = new String[rownum][cellnum];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < cellnum; j++) {
				assignrole[i - 1][j] = XLUtils.getCellData(path, "assign_role", i, j);
				System.out.println(assignrole[i - 1][j] = XLUtils.getCellData(path, "assign_role", i, j));
			}
		}
		return assignrole;
	}

}
