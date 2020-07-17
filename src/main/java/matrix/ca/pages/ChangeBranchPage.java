package matrix.ca.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import matrix.ca.base.TestBase;

public class ChangeBranchPage extends TestBase {

	// Page Factory - OR / object repository:
	// Define page factory library - https://www.youtube.com/watch?v=LxJzeiTQGoE (38:45)
	
	// Change Branch tab
	@FindBy(xpath = "//a[@class='menuButton'][contains(text(),'Change Branch')]")
	WebElement clickOnChangeBranchTab;

	// Change Branch tab > select Change Branch option
	@FindBy(xpath = "//a[@class='menuItem'][contains(text(),'Change Branch')]")
	WebElement selectChangeBranch;

	// company drop down list
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_companyDropDownList']")
	WebElement company;

	// Branch
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_branchTextBox']")
	WebElement branch;

	// Consultant
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_agentTextBox']")
	WebElement consultant;

	// Quick Change
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_quickChangeTextBox']")
	WebElement quickChange;

	// Change button
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_saveButton']")
	WebElement changeButton;

	// Cancel button
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_cancelButton']")
	WebElement cancelButton;

	// Initializing the Page Objects:
	public ChangeBranchPage() {
		PageFactory.initElements(driver, this); // Initialize constructor HomePage
	}

	// TC1: verify ChangeBranch  
	//public ChangeBranchPage clickOnChangeBranch() {
		//ChangeBranchTab.click();
		//return new ChangeBranchPage(); // should return ChangeBranchPage object
	//}

	// TC2:
	
	public ChangeBranchPage verifyChangeBranch(String changeBranchNumber) {

		// define the action object
		Actions action = new Actions(driver);

		// check if user have access to ChangeBranch option (Change Branch tab > Change Branch)
		// perform movetoElement action on “action” object
		// wait for submenus to be appear because on hover, submenus will be loaded
		try {
			if (clickOnChangeBranchTab.isDisplayed()) {
				action.moveToElement(selectChangeBranch).perform();
				
				try {
					if (selectChangeBranch.isDisplayed()) {
						action.moveToElement(selectChangeBranch).click().perform();
					}
				} catch (NoSuchElementException e) {
					e.printStackTrace();
				}
				
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}		
		
		// select company - drop down
		//company.
	 
		company.sendKeys(changeBranchNumber);
	 
		
		// enter branch (* required field)
		// branch.
		
		// enter consultant (* required field) or quick change
		// option 1: consultant
		// option 2: quickChange
		

		try {
			if (changeButton.isDisplayed()) {
				changeButton.click();
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		
		
		return new ChangeBranchPage(); // should return ClientfileInfoPage object
	}


}
