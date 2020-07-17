package matrix.ca.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import matrix.ca.base.TestBase;

public class PasswordChangePage extends TestBase {

	// Page Factory - OR / object repository:
	// Define page library - https://www.youtube.com/watch?v=LxJzeiTQGoE (38:45)

	// mymatrix/Security/PasswordChange/PasswordChange.aspx

	// please enter your UserID
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_Label3']")
	WebElement enterUserIDTitle;

	// enter userID
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_userIdTextBox']")
	WebElement changePWuserID;

	// next button
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_nextButton']")
	WebElement nextButton1;

	// cancel button
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_cancelButton']")
	WebElement cancelButton;

	// change password security question
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_questionLabel']")
	WebElement securityQuestion;

	// change password security question > next button
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_nextButton']")
	WebElement nextButton2;

	// Password change request has been submitted successfully. Please check your
	// email in a few seconds.
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_emailMessageLabel']")
	WebElement emailMessageLabel;

	// Initializing the Page Objects: https://www.youtube.com/watch?v=LxJzeiTQGoE
	// (46:00)
	// create PageFactory constructor of this class
	// this driver come from TestBase class
	// all variable (@FindBy ...) will be initialize with this driver

	// ChangePasswordPage title
	public PasswordChangePage() {
		PageFactory.initElements(driver, this);
	}

	// TC1: : verify valid userID
	public PasswordChangePage verifyPasswordChange(String UserID, String question) {

		// 1. check "Please enter your UserID' text present then enter validate userID
		//if (changePWuserID.isDisplayed()) {

			//System.out.println("Element is Visible");

			// enter user name/email and password
			changePWuserID.sendKeys(UserID);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", nextButton1);

			// enter security question
			securityQuestion.sendKeys(question);
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("arguments[0].click();", nextButton2);

		//} else {
			//System.out.println("Element is InVisible");

		//}

		return new PasswordChangePage(); /* return ChangePasswordPage object */

	}
}
