package testlerningng;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 {
	
	
	@BeforeTest
	public void createDbConn() {
		System.out.println("Creating db connection");
	}
	
	@AfterTest
	public void closeDbConn() {
		System.out.println("close db connection");
	}
	
	@BeforeMethod
	public void launchBrowser() {

		System.out.println("lauching a browser");
	}

	@AfterMethod
	public void closeBrowser() {

		System.out.println("closing a browser");
	}

	@Test(priority = 2,groups = "low")
	public void doLogin() {

		System.out.println("Executing login test");
		Reporter.log("Inside Do LogIn Test");
		Reporter.log("Capture Screenshot");


	}

	@Test(priority = 1,groups = "high")
	public void doUserReg() {
		System.out.println("Executing User reg test");
		Reporter.log("Inside Do User Reg Test");
	}

}