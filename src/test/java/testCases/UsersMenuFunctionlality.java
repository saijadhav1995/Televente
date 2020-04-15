package testCases;

import org.testng.annotations.Test;


import Utility.AppstringsConstant;
import pages.VerifyLoginPage;
import pages.VerifyUsersMenu;
import webBase.BaseTest;


public class UsersMenuFunctionlality extends BaseTest {


	AppstringsConstant appConst =new AppstringsConstant(); 
	VerifyUsersMenu users=new VerifyUsersMenu();	
	@Test(priority=0)
	
	public void verifyAdminUser() throws Throwable {
		
	users.usersMenu("Verify Users Menu Functionality");
	
	}
	
}



