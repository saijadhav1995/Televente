package testCases;

import org.testng.annotations.Test;



import library.BrowserFactory;
import pages.VerifyHome;
import pages.VerifyLoginPage;
import webElements_Identifiers.Home;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class HomeTest extends BrowserFactory {

	VerifyHome Homepage=new VerifyHome();
	
	@Test(priority='0')
	public void VerifyHomePage() throws Throwable {
		
		Homepage.Verify_the_Home_Page();
		
	}
	
	@Test(priority='1')
	public void Verifytitle() throws Throwable {
		
		Homepage.Verifytitle();
		
	}
	
	@Test(priority='2')
	public void VerifyContentPresentOnDrawer() throws Throwable {
		
		Homepage.VerifyContent();
		
	}
	
	@Test(priority='3')
	public void VerifyRegionField() throws Throwable {
		
		Homepage.VerifyRegionDropDwon();
		
	}
	
	
	
	
	@Test(priority='4')
	public void VerifyToggleButton() throws Throwable {
		
	Homepage.VerifyToggleButton();
		
		}
	
	@Test(priority='5')
	public void VerifypaginationDropDown() throws Throwable {
		
	Homepage.VerifyPaginationDropDown();
		
		}
	
	
	@Test(priority='6')
	public void VerifySearchField() throws Throwable {
		
	Homepage.VerifySearchFeild();
		
		}
	
	
	@Test(priority='7')
	public void VerifypaginationArrows() throws Throwable {
		
	Homepage.VerifyPaginationArrows();
		
		}
	
	@Test(priority='8')
	public void VerifyCreationAndDeletionButtons() throws Throwable {
		
	Homepage.VerifyCreationAndDeletionButton();
		
		}
	
	
	@Test(priority='9')
	public void VerifyActionColumn() throws Throwable {
		
	Homepage.VerifyActionColumn();
		
		}
	
	
}
