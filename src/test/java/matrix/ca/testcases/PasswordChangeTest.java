package matrix.ca.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import matrix.ca.base.TestBase;
import matrix.ca.pages.HomePage;
import matrix.ca.pages.LoginPage;
import matrix.ca.util.TestUtil;
import matrix.ca.pages.PasswordChangePage;

public class PasswordChangeTest extends TestBase {
	LoginPage loginPage; // define at class level
	HomePage homePage;
	PasswordChangePage changePasswordPage;
	TestUtil testUtil;
	String sheetName = "user";

	// STEP 1: create constructor LoginPageTest class
	// https://www.youtube.com/watch?v=LxJzeiTQGoE (58:00)
	public PasswordChangeTest() {
		super(); /* super keyword - call super/TestBase class constructor */
	}

	// STEP 2:
	// https://www.youtube.com/watch?v=LxJzeiTQGoE (1:00:00)
	@BeforeMethod
	public void setUp() throws InterruptedException {

		// call initialization() method from supper/TestBase class; launch browser, etc
		initialization();

		testUtil = new TestUtil();

		// create object of ChangePasswordPage class
		changePasswordPage = new PasswordChangePage();

		// after login > return homePage class object
		loginPage = new LoginPage();
		
		homePage = loginPage.verifyUserLogin(prop.getProperty("username"), prop.getProperty("password"));

		//TestUtil.runTimeInfo("error", "login successful");
		
		changePasswordPage =loginPage.clickOnForgotPasswordLink();

	}

	// TC1: test change password
	// https://www.youtube.com/watch?v=H2-3w-GQZ3g - 4 (30:00)
	/*
	 * @DataProvider public Object[][] getMatrixTestData() { Object data[][] =
	 * TestUtil.getTestData(sheetName); return data; }
	 */

	// https://www.youtube.com/watch?v=H2-3w-GQZ3g - 4 (19:00)
	@Test(priority = 1)
	//@Test(priority = 1, dataProvider = "getMatrixTestData")
	public void verifyPasswordChangeTest (String userID, String securityQuestion) {

		loginPage.clickOnForgotPasswordLink(); // click on forgot password link

		//(prop.getProperty("username")
		changePasswordPage.verifyPasswordChange ("116510", "tennis");
		//changePasswordPage.verifyPasswordChange (userID, securityQuestion);

		// https://www.youtube.com/watch?v=H2-3w-GQZ3g - 4 (38:40)
		// add assertion to verify CreateNewContact successful or not
		
	}

 

	// STEP 3:
	@AfterMethod
	public void closeBrowser() {
		// closes the browser instance
		driver.quit();
	}
}
