package com.myiqai.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.myiqai.base.Base_test;
import com.myiqai.pageObjects.RoleCreation;
import com.myiqai.utilities.XLUtils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Role_Creation extends Base_test {
	int rownum;
	public RoleCreation rolecreation;

	@Test
	public void role_creation() {

		rolecreation = new RoleCreation(driver);
		rolecreation.adminSet();
		rolecreation.settingS();
		rolecreation.roleMaster();

	}

	@Test(dataProvider = "rolename",dependsOnMethods = "role_creation")
	public void roleCreation(String rolename, String role_description) throws InterruptedException {

		rolecreation = new RoleCreation(driver);
		System.out.println("Total no of roles" + " " + rownum);
		for (int i = 1; i <= rownum;) {

			rolecreation.addRole();
			rolecreation.roleName(rolename);
			rolecreation.roleDescription(role_description);
			// adminsettings.roleInvoice();
			// adminsettings.roleCreation();
			Thread.sleep(3000);
			break;

			// why break instead of i++? because if you give increament operator next data
			// from xl doesnot get pass until last rownum,
			// only after last row completes, next get pass, thus to exit, I used break
			// statement which breaks the 1st data and then moves to next data..
		}

	}

	@DataProvider(name = "rolename")
	public String[][] getOrgData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/resources/testData/rolecreation.xlsx";
		rownum = XLUtils.getRowCount(path, "roles");
		int cellnum = XLUtils.getCellCount(path, "roles", 1);
		String roledata[][] = new String[rownum][cellnum];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < cellnum; j++) {
				roledata[i - 1][j] = XLUtils.getCellData(path, "roles", i, j);
				System.out.println(roledata[i - 1][j] = XLUtils.getCellData(path, "roles", i, j));
			}
		}
		return roledata;
	}

}
