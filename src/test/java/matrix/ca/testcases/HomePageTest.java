package matrix.ca.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import matrix.ca.base.TestBase;
import matrix.ca.pages.HomePage;
import matrix.ca.pages.LoginPage;

//https://www.youtube.com/watch?v=ea0P7MBQmiM (16:00)
// ctrl + shift all to import all extends class

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	// TestUtil testUtil;
	// ContactsPage contactsPage;

	// create constructor HomePageTest
	public HomePageTest() {
		super();
	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeMethod
	public void setUp() {

		// from TestBase class; initialize properties,open browser,maximize window,etc
		initialization();

		// initialize testUtil object - https://www.youtube.com/watch?v=ea0P7MBQmiM
		// (39:30)
		// testUtil = new TestUtil();

		// log in the application first (19:00)
		loginPage = new LoginPage();

		// after login > return homePage class object
		homePage = loginPage.verifyUserLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	// TC1: test HomePageTitle
	@Test(priority = 1)
	public void HomePageTitleTest() {

		// Soft Assert vs Hard Assert in TestNG:
		// https://www.youtube.com/watch?v=IQiZgpXRZIQ
		SoftAssert softAssert1 = new SoftAssert();

		String ActualPageTitle= homePage.verifyPageTitle();
		String ExpectedPageTitle = ("MyMatrix");
		softAssert1.assertEquals(ActualPageTitle, ExpectedPageTitle, "Page Title doesn't match");

	
		softAssert1.assertAll();
	}

	// TC2: test company image/logo
	@Test(priority = 2)
	public void CompanyLogoTest() {

		SoftAssert softAssert2 = new SoftAssert();

		boolean flag = homePage.verifyCompanyLogo();
		softAssert2.assertTrue(flag, "Company logo is not dislayed");
		//System.out.println("CompanyLogoTest - Completed");
		
		softAssert2.assertAll();
	}

	// TC3: test SignInName
	@Test(priority = 3)
	public void UserSignInTest() {

		SoftAssert softAssert3 = new SoftAssert();

		// get ActualSignInName
		String ActualSignInName = homePage.verifySignInUser();
		//System.out.println("ActualSignInName = " + ActualSignInName);
		
		// get ExpectedSignInName
		// enhancement/phase 2: Parameterizing the Tests with multiple data 
		
		StringBuilder buffer1 = new StringBuilder();

		String FName = prop.getProperty("FirstName");
		String LName = prop.getProperty("LastName");

		// appends the string argument to the StringBuilder
		// https://stackoverflow.com/questions/44289766/how-to-add-a-space-between-two-strings-using-stringbuilder-in-java
		buffer1.append(FName);
		buffer1.append(" "); 	// add a space between 2 string
		buffer1.append(LName);

		// after appending
		String ExpectedSignInName = buffer1.toString();
		//System.out.println("ExpectedSignInName = " + ExpectedSignInName);
		
		softAssert3.assertEquals(ActualSignInName, ExpectedSignInName, "Signed in name doesn't match.");
		
		softAssert3.assertAll();
	}

	// TC4: test signInBranch
	@Test(priority = 4)
	public void UserSignInBranchTest() {

		SoftAssert softAssert4 = new SoftAssert();

		String ActualSignInBranch = homePage.verifySignInBranch();
		//System.out.println("Actual SignInBranch = " + ActualSignInBranch);
		 
		// Java Remove Last Character from String
		String ActualSignInBranchNew = ActualSignInBranch.substring(0, ActualSignInBranch.length() - 1);
		
		String ExpectedSignInBranch = prop.getProperty("signInBranch");
		//System.out.println("Expected SignInBranch = " + ExpectedSignInBranch);

		softAssert4.assertEquals(ActualSignInBranchNew, ExpectedSignInBranch, "Signed in branch doesn't match.");
		
		softAssert4.assertAll();
	}

	// TC5: test welcome message
	@Test(priority = 5)
	public void WelcomeMessageTest() {

		SoftAssert softAssert5 = new SoftAssert();
		// String welcomeMassage = homePage.verifyWelcomeMessage();
		// Assert.assertEquals(welcomeMassage, "Welcome to the Global - My Matrix
		// system.");

		String ActualWelcomeMessage = homePage.verifyWelcomeMessage();
		//System.out.println("Actual Welcome Message = " + ActualWelcomeMessage);
		
		String ExpectedWelcomeMessage = ("Welcome to the Global - My Matrix system.");
		//System.out.println("Expected Welcome Message = " + ExpectedWelcomeMessage);
		
		softAssert5.assertEquals(ActualWelcomeMessage, ExpectedWelcomeMessage, "Welcome message doesn't match.");

		softAssert5.assertAll();
	}

	// TC6: test customer service email link
	@Test(priority = 6)
	public void CustomerServiceEmailTest() {

		SoftAssert softAssert6 = new SoftAssert();

		String ActualEmail = homePage.verifyMatrixCustomerServiceEmail();
		//System.out.println("Actual Email  = " + ActualEmail);
		
		String ExpectedEmail = ("matrixcustomerservice@mycwt");
		//System.out.println("Expected Email to be fail = " + ExpectedEmail);
		
		softAssert6.assertEquals(ActualEmail, ExpectedEmail, "Matrix Customer Service Email doesn't match.");
		
		softAssert6.assertAll();
	}

	@AfterMethod
	public void closeBrowser() {
		// closes the browser instance
		driver.quit();
	}

}
