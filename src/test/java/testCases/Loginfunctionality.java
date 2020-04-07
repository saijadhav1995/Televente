package testCases;

import org.testng.annotations.Test;


import Utility.AppstringsConstant;
import pages.VerifyLoginPage;
import webBase.BaseTest;


public class Loginfunctionality extends BaseTest {


	AppstringsConstant appConst =new AppstringsConstant(); 
	VerifyLoginPage loginpage=new VerifyLoginPage();
	
	@Test(priority=0)
	
	public void verifyAdminUser() throws Throwable {
		
		loginpage.open_chrome_browser_and_start_application("loginFunctionlaityForAdminUser");
		loginpage.page_has_been_verified();
		loginpage.verify_username_password_and_submit_button();
		loginpage.enter_username_and_Password_for(appConst.Admin_SGID,appConst.Admin_password);
		loginpage.admin_user_should_be_login_successfully();
	}
	

@Test(priority=1)
	
	public void verifyReaderUser() throws Throwable {
		
		loginpage.open_chrome_browser_and_start_application("loginFunctionlaityForReaderUser");
		loginpage.page_has_been_verified();
		loginpage.verify_username_password_and_submit_button();
		loginpage.enter_username_and_Password_for(appConst.Reader_SGID, appConst.Reader_password);
		loginpage.reader_user_should_be_login_successfully_as_Reader_Role();
	}

@Test(priority=2)

public void verifyConfiguratorUser() throws Throwable {
	loginpage.open_chrome_browser_and_start_application("loginFunctionlaityForConfiguratorUser");
	loginpage.page_has_been_verified();
	loginpage.verify_username_password_and_submit_button();
	loginpage.enter_username_and_Password_for(appConst.conf_SGID, appConst.conf_password);
	loginpage.user_should_be_login_successfully_as_configurator_Role();
}



@Test(priority=3)

	public void verifyInvalidUser() throws Throwable {
	loginpage.open_chrome_browser_and_start_application("loginFunctionlaityForInvalidUser");
	loginpage.page_has_been_verified();
	loginpage.verify_username_password_and_submit_button();
	loginpage.enter_username_and_Password_for(appConst.invalidUser_SGID,appConst.invalidUser_SGID);
	loginpage.invalid_user_should_be_not_be_login();
}



}



