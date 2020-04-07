package pages;



import org.testng.AssertJUnit;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


import java.io.IOException;



import com.relevantcodes.extentreports.LogStatus;

import Baselibrary.ExcelConfig;
import Baselibrary.Helper;
import Utility.AppstringsConstant;
import webBase.BaseTest;
import webBase.BasePage;
import webBase.BrowserFactory;
import webBase.Controller;
import webElements_Identifiers.Login;
import com.relevantcodes.extentreports.ExtentTest;



public class VerifyLoginPage extends BasePage   {
	
	
	
public ExtentTest logger;	
Login loginPage =new Login(driver);
public ExtentTest extentest;
public SoftAssert SAssert = new SoftAssert();
public PageFactory pf=new PageFactory();
BrowserFactory Bf=new BrowserFactory();
BaseTest baseT = new BaseTest();
String className = "";

public AppstringsConstant appConst=new AppstringsConstant();



Helper helper=new Helper();




	
	
	//Scenario1 : verify SSO page 

	public void open_chrome_browser_and_start_application(String TestName) throws Throwable {
		
		
		
	logger = baseT.extent.startTest(TestName);			
	loginPage=	PageFactory.initElements(driver, Login.class);
	createDirectory("TELEVENTE"+TestName);	


		logger.log(LogStatus.PASS,"OpenBrowser And Start Application"
		+logger.addScreenCapture(captureScreenShot(driver, "open chrome browser and start application")));		
				
						
	}
	
	
	public void page_has_been_verified() throws Throwable {
		
		
		 //Verify Login page
	 	if(helper.isElementPresent(loginPage.link)== true) {
	 		
	 		
	 		
	 		logger.log(LogStatus.PASS,"Login page has been verified"
	 				+logger.addScreenCapture(captureScreenShot(driver, "Login page has been verified")));
	 		
	 		loginPage.clicklink(); 
	   
	 	}
	 	
	}	
	
	

	//Scenario2: verify login functionality for Admin user 
	 
	  
	
	 public void verify_username_password_and_submit_button() throws Throwable {
	    
		//Verify  username , password and Submit button.
	 		try {
	 			
	 			Assert.assertTrue(helper.isElementPresent(loginPage.username), "username is displayed ");
	 			Assert.assertTrue(helper.isElementPresent(loginPage.password), "password is displayed");
	 			Assert.assertTrue(helper.isElementPresent(loginPage.submit), "submit is displayed");
	 			
	 			logger
	 			.log(LogStatus.PASS,"On Login page Username ,Password and Submit Button has been verified"
		 				+logger
		 				.addScreenCapture(captureScreenShot(driver, "Username ,Password and Submit Button")));
	 			
	 		
		} catch (Error login_page) {
			
		
			logger.log(LogStatus.FAIL,"On Login page Username ,Password Or Submit Button Does not displayed"
	 				+logger.addScreenCapture(captureScreenShot(driver, "Login page has been verified")));
 
			System.out.println("login failed");
			
		} 
		 			 	
		
  
	 }
	 
	
	
	 public void enter_username_and_Password_for(String username1, String password1)  throws Throwable {
		 
			
		//insert username & password
	 	
		 try {
			 
			 loginPage.typeUsername(username1);
			 	loginPage.typePassword(password1);
				logger.log(LogStatus.PASS,"Enter Username "+username1+" "+"and Paswword"+" "+password1
		 		+logger.addScreenCapture(captureScreenShot(driver, "Enter Username&and Paswword")));
				loginPage.clickSubmit();
				
			
		} catch (Exception enterFields) {
			
			logger.log(LogStatus.FAIL, " user does not able to enter Data on Login Fields ");
		}
				
		
	 }
	
	 
	 
	
	
	 public void admin_user_should_be_login_successfully() throws Throwable {
			
			
			try {
				
				loginPage.mouseHoverOnRunIcon();
				
				if (loginPage.usersMenu.isDisplayed()) {
		 			
		 			
					System.out.println("user logged in successfully");
		 			
					logger.log(LogStatus.PASS,"Admin user logged in successfully"
			 				+logger.addScreenCapture(captureScreenShot(driver, "Admin user logged in successfully")));
				 	
		 			loginPage.logOut();
		 			logger.log(LogStatus.PASS,"Admin user log-out successfully"
			 				+logger.addScreenCapture(captureScreenShot(driver, "Admin user log-out successfully")));
				 	
					
		 				
					}
				
			} catch (NoSuchElementException invalid_user) {
				
				if(loginPage.TeleventeImage.isDisplayed()) {
				loginPage.logOut();
				
				logger.log(LogStatus.FAIL, "Admin user does not have admin access"
		 				+logger.addScreenCapture(captureScreenShot(driver, "Admin user does not have admin access")));
				
				
				}
				try {
					
				} catch (NoSuchElementException invalid_user1) {
					logger.log(LogStatus.FAIL, "Admin user does not able to login"
			 				+logger.addScreenCapture(captureScreenShot(driver, "Admin user does not able to login")));
					
						}
			}	
				
				
						
	 } 
	 
	
	//Scenario2: verify login functionality for  Reader user
		

	 public void reader_user_should_be_login_successfully_as_Reader_Role() throws Throwable {
	     
		 		
			
			try {
				
				if (loginPage.TeleventeImage.isDisplayed()) {
		 			
		 			
					System.out.println("Readeruser logged in successfully");
					logger.log(LogStatus.PASS,"Reader user logged in successfully"
			 				+logger.addScreenCapture(captureScreenShot(driver, "Reader user logged in successfully")));
					
					loginPage.logOut();
		 			
				}else if (loginPage.usersMenu.isDisplayed()) {
					
					logger.log(LogStatus.FAIL,"Reader user have Admin access"
			 				+logger.addScreenCapture(captureScreenShot(driver, "Reader user have Admin access")));
					loginPage.logOut();
		 			
		 			
					}
				
			} catch (NoSuchElementException invalid_user) {
				
				logger.log(LogStatus.FAIL, "Reader user does not able to login"
		 		+logger.addScreenCapture(captureScreenShot(driver,"Reader user does not able to login")));
			
				
			}	
				
	 
	 }

	//Scenario2: verify login functionality for  configurator user 
	 
		 public void user_should_be_login_successfully_as_configurator_Role() throws Throwable {
		     
				
				loginPage.usersMenu.click();
				
				logger.log(LogStatus.INFO,"open user menu"
				 		+logger.addScreenCapture(captureScreenShot(driver, "open user menu")));
				
						loginPage.role.click();
			
				
				logger.log(LogStatus.INFO,"Verify configurator role"
				 		+logger.addScreenCapture(captureScreenShot(driver, "Verify configurator role")));
			
				
				try {
					
					loginPage.selectRole("1");					
					logger.log(LogStatus.FAIL,"configurator has admin rights"
					 		+logger.addScreenCapture(captureScreenShot(driver,"configurator has admin rights")));
				
	
					loginPage.logOut();
					
				} catch (NoSuchElementException conf_user ) {
					
					logger.log(LogStatus.PASS,"configurator user logged in successfully"
					 	+logger.addScreenCapture(captureScreenShot(driver,"configurator user logged in successfully")));
				
					
					loginPage.logOut();
	
					logger.log(LogStatus.PASS,"configurator user log out successfully"
					 		+logger.addScreenCapture(captureScreenShot(driver,"configurator user log out successfully ")));
			
				}
				
				
			 
		 }
	 
	 
	 

		//Scenario2: verify login functionality for  invalid user 
			
	 
		 public void invalid_user_should_be_not_be_login() throws Throwable {
			
			
			try {
				
				if (loginPage.invalid.isDisplayed()) {
		 			
		 			
					System.out.println("Invaid user does Able not login");
					logger.log(LogStatus.PASS,"Invalid user not does not able to login "
					 	+logger.addScreenCapture(captureScreenShot(driver,"Invalid user not does not able to login ")));
					
					}
				
			} catch (NoSuchElementException invalid_user) {
			
				logger.log(LogStatus.FAIL, "invalid user able to login successfully"
				 +logger.addScreenCapture(captureScreenShot(driver,"invalid user able to login successfully")));
			
				
			
				}	
				
			 }
		 

		 
	 		 	
	 
	 
/*	 @Test(priority=0) //dataProvider="televentelogin",
	 @Then("^verify loginfunctionality with \"([^\"]*)\" and \"([^\"]*)\"$")
	 public void  verify_loginfunctionality_with_and(String username1, String password1) throws Exception {
	 			 		
	 			
				
			try {
				if (loginPage.invalid.isDisplayed()) {
					
					driver.navigate().to("https://televente.mutlp.test.pointp.saint-gobain.net/");
		 			System.out.println("invalid user");
		 			logger2.log(Status.PASS, "invalid user");
					}		
				
				}catch(NoSuchElementException incative_user) {
					
					
		 			System.out.println("inactive user");
		 			logger2.log(Status.PASS, "inActive user");
				}
	 		
			}
	 		
	 		Extent.flush();
	 		} 	
	 
	*/
	 
	



	
	 
	
	/* @DataProvider(name="televentelogin")
	 public Object[][] passdata() throws Exception{
	 	 
	 	 ExcelConfig config=new ExcelConfig(System.getProperty("user.dir")+"\\Excel\\Test.xlsx");
	 	 
	 	 int rows =config.getRowCount(0);
	 	 
	 	 System.out.println(rows);
	 	 
	 	 Object [][] data=new Object[rows][2];
	 	 
	 	 int i=0;
	 	 while(rows>i) {
	 		
	 		 data[i][0]=config.getData(0, i, 0);
	 		 data[i][1]=config.getData(0, i, 1);
	 		 i=i+1;
	 		 		 
	 	 }
	 	 return data;
	 }*/
	
	 
	 
	 


			
}		
		

	
		