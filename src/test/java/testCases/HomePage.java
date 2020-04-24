package testCases;

import org.testng.annotations.Test;


import pages.VerifyHome;
import pages.VerifyLoginPage;
import webBase.BaseTest;
import webBase.BrowserFactory;
import webElements_Identifiers.Home;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class HomePage extends BaseTest {

	VerifyHome Homepage=new VerifyHome();
	
	@Test(priority='0')
	public void VerifyHomePage() throws Throwable {
		
		Homepage.Verify_the_Home_Page("Verify Home Page");
		Homepage.Verifytitle();
		Homepage.VerifyContent();
		Homepage.VerifyRegionDropDwon();
		Homepage.VerifyCreationAndDeletionButton();
		Homepage.pastToggleButton();
		Homepage.VerifyPaginationArrows();
		Homepage.VerifySearchFeild();
		Homepage.VerifyPaginationDropDown();
		Homepage.futureToggleButton();
		Homepage.VerifyActionColumn();

	}
	
	
	
}
