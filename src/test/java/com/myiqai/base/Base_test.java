package com.myiqai.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.uncommons.reportng.HTMLReporter;

import com.aventstack.extentreports.ExtentReports;
import com.myiqai.pageObjects.Loginpage;
import com.myiqai.utilities.Readconfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_test {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static Properties browser = new Properties();
	public FileInputStream read;
	public ExtentReports er;
	HTMLReporter hr;

	static Readconfig readconfig = new Readconfig();

	public static String newuserbusinessemail1 = readconfig.getnewUseremail();
	public static String userPassword1 = readconfig.getuserPassword();

	@BeforeClass
	public void setUp() throws IOException {
		// er = new ExtentReports();
		// hr = new HTMLReporter("extentreport.html");

		if (driver == null) {

			System.out.println("the path is" + System.getProperty("user.dir"));

			// URL and browser getting passed.
			String file1 = System.getProperty("user.dir")
					+ "/src/test/resources/configfiles/configFile_read.properties";
			String file2 = (System.getProperty("user.dir") + "/src/test/resources/configfiles/locators.properties");

			FileInputStream read1 = new FileInputStream(file1);
			FileInputStream read2 = new FileInputStream(file2);

			prop.load(read1);
			loc.load(read2);

			// String browser_name=prop.getProperty("browser");
			// System.out.println("browser name ;"+browser_name);

		}

//		The key difference lies in their use cases: System.getProperty is for system-level information 
// (like user directory, Java version, file separator, etc.), while the Properties class is generally used for application-level
// settings and configurations.

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {

			System.out.println("Browser value from configfile: " + prop.getProperty("browser"));

			WebDriverManager.chromedriver().setup();

			// driver.manage().window().maximize();
			// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			/*
			 * DesiredCapabilities caps = new DesiredCapabilities();
			 * caps.setAcceptInsecureCerts(true); ChromeOptions options = new
			 * ChromeOptions(); options.addArguments("--disable-infobars");
			 * options.addArguments("--disable-notifications"); options.merge(caps);
			 */

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");

			options.addArguments("--incognito");

			driver = new ChromeDriver(options);
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();

		}

		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.out.println("Browser value from configfile: " + prop.getProperty("browser"));

			// WebDriverManager.firefoxdriver().setup();
			WebDriverManager.firefoxdriver().setup();
			System.out.println("wvedv");
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(new FirefoxProfile());
			options.addPreference("dom.webnotifications.enabled", false);
			driver = new FirefoxDriver(options);
			driver.get(prop.getProperty("url"));

			driver.manage().window().maximize();

		}
		Loginpage login = new Loginpage(driver);
		login.setBusiness_email(newuserbusinessemail1);
		login.setPwd(userPassword1);
		login.login_bt();
	}

	@AfterClass
	public void tearDown() {

		driver.close();
		System.out.println("BSF testing Completed");
	}

	@AfterTest
	public void driverQuit() {
		driver.quit();
		System.out.println("Driver get quit successfully after test completion...");
	}

}
