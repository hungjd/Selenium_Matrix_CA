package matrix.ca.pages;

//import mymatrix.ca.base.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import matrix.ca.base.TestBase;

public class ClientFileSearchPage extends TestBase {

		// signInNameLabel
		@FindBy(xpath = "//span[@id='ProfileHeader1_signInNameLabel']")
		@CacheLookup
		WebElement signInNameLabel;

		// SearchClientFiles
		@FindBy(xpath = "//span[@id='ContentPlaceHolder1_Label3']")
		WebElement SearchClientFilesLabel;

		// search: PNR Locator
		@FindBy(xpath = "//input[@id='ContentPlaceHolder1_pnrLocatorTextBox']")
		WebElement SearchPNRLocator;

		// search: Client File Number
		@FindBy(xpath = "//input[@id='ContentPlaceHolder1_cfaTextBox']")
		WebElement SearchClientFileNumber;

		// Search button
		@FindBy(xpath = "//input[@id='ContentPlaceHolder1_searchButton']")
		WebElement SearchBtn;

		// New button
		@FindBy(xpath = "//input[@id='ContentPlaceHolder1_newButton']")
		WebElement NewBtn;

		// Initializing the Page Objects:
		public ClientFileSearchPage() {
			PageFactory.initElements(driver, this); // Initialize constructor HomePage
		}

		// TC1: click on View/GoTo tab > select 'Clientfile Information' option
		// https://www.edureka.co/community/47161/select-item-from-menu-menu-using-mouse-over-action-selenium
		
 
		
	}

		// TC2: Search Client Files label
		//public boolean verifySearchClientFilesLabel() {
			//return SearchClientFilesLabel.isDisplayed();
		//}

		// TC3: search 'PNR Locator'

		// TC4: search 'Client File Number'



