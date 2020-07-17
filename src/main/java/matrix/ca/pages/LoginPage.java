package matrix.ca.pages;


import java.awt.desktop.SystemSleepEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import matrix.ca.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - OR / object repository:
	// Define page library - https://www.youtube.com/watch?v=LxJzeiTQGoE (38:45)

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_userIdTextBox']")
	WebElement username;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_passwordTextBox']")
	WebElement password;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_changePasswordCheckBox']")
	WebElement changePassword;
	
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_newPassword1TextBox']")
	WebElement newPassword;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_newPassword2TextBox']")
	WebElement verifyNewPassword;

	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_langDropDownList']")
	WebElement language;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_loginImageButton']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_passwordChangeHyperLink']")
	WebElement forgotPassword;

	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_emailHyperLink']")
	WebElement csEmail;

	// Initializing the Page Objects: https://www.youtube.com/watch?v=LxJzeiTQGoE
	// (46:00)
	// create PageFactory constructor of this class
	// this driver come from TestBase class
	// all variable (@FindBy ...) will be initialize with this driver

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions - different features of the page :
	// https://www.youtube.com/watch?v=LxJzeiTQGoE (47:00)

	// test case 1: verify LoginPageTitle
	public String verifyLoginPageTitle() {
		return driver.getTitle(); /* this method return title of the page */
	}

	// test case 2: verify userID and password
	public HomePage verifyUserLogin(String Uname, String Upassword) {

		// re-direct to https://ui.freecrm.com
		// logInLink.click();

		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].click();", logInLink);

		// enter user name/email and password
		username.sendKeys(Uname);
		password.sendKeys(Upassword);

		// loginBtn.click();
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", loginBtn);

		return new HomePage(); /* return HomePage object */
	}

	// TC3: verify Forgot Your Password
	public PasswordChangePage clickOnForgotPasswordLink(){
		forgotPassword.click();
		return new PasswordChangePage();  
	}
	
	// TC4: verify change password
	// public boolean verifyChangePassword() {

	// https://www.guru99.com/checkbox-and-radio-button-webdriver.html
	// 1. click on changePassword check box 
	// 2. if changePassword is checked then enter required fields; 
		// username, password, newPassword, verifyNewPassword
		// valid New Password and Verify New Password format
 
	// Boolean checkButtonPresence = changePassword.isDisplayed();
	// return checkButtonPresence;

	// return changePassword.isDisplayed();
	// }

}
