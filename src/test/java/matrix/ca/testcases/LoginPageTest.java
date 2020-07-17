package matrix.ca.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import matrix.ca.base.TestBase;
import matrix.ca.pages.HomePage;
import matrix.ca.pages.LoginPage;
//import src.test.java.mymatrix.ca.testcases.SoftAssert;
//import src.test.java.mymatrix.ca.testcases.String;


public class LoginPageTest extends TestBase {
	LoginPage loginPage; // define at class level
	HomePage homePage;

	// STEP 1: create constructor LoginPageTest class
	// https://www.youtube.com/watch?v=LxJzeiTQGoE (58:00)
	public LoginPageTest() {
		super(); /* super keyword - call super/TestBase class constructor */
	}

	// STEP 2:
	// https://www.youtube.com/watch?v=LxJzeiTQGoE (1:00:00)
	@BeforeMethod
	public void setUp() {

		// call initialization() method from supper/TestBase class; launch browser, etc
		initialization();

		// create object of LoginPage class
		loginPage = new LoginPage();
	}

	// STEP 4: verify test cases
	// https://www.youtube.com/watch?v=LxJzeiTQGoE (1:02:00)

	// test case 1: test LoginPageTitle
	@Test(priority = 1)
	public void LoginPageTitleTest() {

		// Soft Assert vs Hard Assert in TestNG:
		// https://www.youtube.com/watch?v=IQiZgpXRZIQ
		SoftAssert softAssert1 = new SoftAssert();

		String ActualTitle = loginPage.verifyLoginPageTitle();
		String ExpectedTitle = "MyMatrix";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		//System.out.println("LoginPageTitleTest - Completed");
		
		softAssert1.assertAll();
	}

	// test case 2: test userID and password
	@Test(priority = 2)
	public void UserLoginTest() {

		// call loginPage.java, login page method
		// passing user name and password defined in config.property file
		// assigned to homePage
		
		loginPage.verifyUserLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		// enhancement: 
		// 1. paramertize user and password from excel (data provider)
		// 2. add assertion; validate user role/right
		
		// softAssert2.assertAll();

	}
	// TC3: test change password
	// @Test(priority = 3)
	// public void ChangePasswordTest() {

	// SoftAssert softAssert7 = new SoftAssert();

	// boolean flag = homePage.verifyChangePassword();
	// softAssert7.assertTrue(flag, "Change Password is not dislayed");

	// softAssert7.assertAll();

	// }

	// TC4: test Forgot Your Password
	// @Test(priority = 4)
	// public boolean ForgotPasswordTest() {
	// boolean flag = loginPage.validateForgotPasswordLink();
	// Assert.assertTrue(flag);
	// loginPage.verifyForgotPassword();
	// }

	// STEP 3:
	@AfterMethod
	public void closeBrowser() {
		// closes the browser instance
		driver.quit();
	}

}
