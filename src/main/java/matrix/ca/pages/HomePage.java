package matrix.ca.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import matrix.ca.base.TestBase;


public class HomePage extends TestBase {

	// Page Factory - OR / object repository:
	// Define page factory library - https://www.youtube.com/watch?v=LxJzeiTQGoE (38:45)

	@FindBy(xpath = "//span[@id='ProfileHeader1_signInNameLabel']")
	@CacheLookup
	WebElement signInNameLabel;

	@FindBy(xpath = "//span[@id='ProfileHeader1_sigInBranchLabel']")
	WebElement sigInBranchLabel;

	@FindBy(xpath = "//img[@id='ProfileHeader1_companyImage']")
	WebElement companyLogo;

	// Welcome to MyMatrix System.
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_ctl00_welcome1Label']")
	WebElement welcome1Label;

	@FindBy(xpath = "//a[@id='Footer1_emailHyperLink']")
	WebElement emailHyperLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this); // Initialize constructor HomePage
	}

	// TC1: verify HomePageTitle
	public String verifyPageTitle() {
		return driver.getTitle();
	}

	// TC2: verify companyImage/Logo
	public boolean verifyCompanyLogo() {
		return companyLogo.isDisplayed();
	}

	// TC3: verify SignInUser
	public String verifySignInUser() {
		return signInNameLabel.getText();
	}

	// TC4: verify signInBranch
	public String verifySignInBranch() {
		return sigInBranchLabel.getText();
	}

	// TC5: verify welcome message
	public String verifyWelcomeMessage() {
		return welcome1Label.getText();
	}

	// TC6: verify customer service email link
	public String verifyMatrixCustomerServiceEmail() {
		return emailHyperLink.getText();
	}

}
