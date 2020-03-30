package testCases;

import org.testng.annotations.Test;



import library.BrowserFactory;
import pages.VerifyLoginPage;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


public class LoginTest extends BrowserFactory {


	
	VerifyLoginPage loginpage=new VerifyLoginPage();
	
	@BeforeMethod
	
	public void openBrowser() throws Throwable {
		
		loginpage.open_chrome_browser_and_start_application();
	}
	
	@Test(priority=0)
	
	public void verifyAdminUser() throws Throwable {
		
		loginpage.page_has_been_verified();
		loginpage.verify_username_password_and_submit_button();
		loginpage.enter_username_and_Password_for_Admin_user("S4333164", "sg!t@2020");
		loginpage.admin_user_should_be_login_successfully();
	}
	

@Test(priority=1)
	
	public void verifyReaderUser() throws Throwable {
		
		loginpage.page_has_been_verified();
		loginpage.verify_username_password_and_submit_button();
		loginpage.enter_username_and_Password_for_Reader_user("s4208983", "SNK!T@2020");
		loginpage.reader_user_should_be_login_successfully_as_Reader_Role();
	}

@Test(priority=2)

public void verifyConfiguratorUser() throws Throwable {
	
	loginpage.page_has_been_verified();
	loginpage.verify_username_password_and_submit_button();
	loginpage.enter_username_and_Password_for_configuratot_user("S4333164", "sg!t@2020");
	loginpage.user_should_be_login_successfully_as_configurator_Role();
}



@Test(priority=3)

public void verifyInvalidUser() throws Throwable {
	
	loginpage.page_has_been_verified();
	loginpage.verify_username_password_and_submit_button();
	loginpage.enter_username_and_Password_for_invalid_user("S4333164", "sg!t@2020");
	loginpage.invalid_user_should_be_not_be_login();
}

@AfterMethod

public void teardown( ) {

	
	driver.close();
}


}
