package matrix.ca.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import matrix.ca.base.TestBase;

public class ClientFileSnapShotPage extends TestBase {

		// Matrix Client File
		@FindBy(xpath = "//span[@id='ProfileHeader1_matrixClientFileLabel']")
		@CacheLookup
		WebElement matrixClientFile;

	 
	 

		// Initializing the Page Objects:
		public ClientFileSnapShotPage() {
			PageFactory.initElements(driver, this); // Initialize constructor HomePage
		}

		// TC1: click on View/GoTo tab > select 'Clientfile Information' option
		// https://www.edureka.co/community/47161/select-item-from-menu-menu-using-mouse-over-action-selenium
		
		// TC1: validate ClientFileNumber
		public String verifyClientFileNumber() {
			return null;
			//return MatrixClientFile.getText();
		}
		
	}





