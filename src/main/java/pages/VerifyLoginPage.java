package pages;



import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import library.BrowserFactory;
import library.ExcelConfig;
import library.Helper;
import webElements_Identifiers.Login;




public class VerifyLoginPage extends BrowserFactory   {
	
	
public ExtentHtmlReporter reporter=new ExtentHtmlReporter("./target/Extent_Report.html");
public ExtentReports Extent=new ExtentReports();
public ExtentTest extentest;
public SoftAssert SAssert = new SoftAssert();
public PageFactory pf=new PageFactory();
BrowserFactory Bf=new BrowserFactory();




Helper helper=new Helper();




	
	//Scenario1 : verify SSO page 
	@When("^open chrome browser and start application$")
	public void open_chrome_browser_and_start_application() throws Throwable {
		 
		Extent.attachReporter(reporter);
		reporter.config().setTheme(Theme.DARK);
		
		ExtentTest logger= Extent.createTest("OpenBrowser And Start Application");

				
				Bf.startBrowser("chrome","https://televente.mutlp.test.pointp.saint-gobain.net");
				logger.log(Status.INFO, "open chrome browser and start application");
				logger.log(Status.PASS,"start application sucessfully");	
				Extent.flush();
						
	}
	
	
	@Then("^page has been verified$")
	public void page_has_been_verified() throws Throwable {
		
		Extent.attachReporter(reporter);
		ExtentTest logger1= Extent.createTest("VerifyloginPage");
		Login loginPage	=pf.initElements(driver,Login.class);
	
		 //Verify Login page
	 	if(helper.isElementPresent(loginPage.link)== true) {
	 		
	 		
	 		logger1.log(Status.PASS, "Login page has been verified");
	 		loginPage.clicklink(); 
	   
	 	}
	 	
	}	
	
	

	//Scenario2: verify login functionality for Admin user 
	 
	  
	
	 @When("^verify username password and submit button$")
	 public void verify_username_password_and_submit_button() throws Throwable {
	    
		 Extent.attachReporter(reporter);
			ExtentTest logger2= Extent.createTest("verify username password and submit button");
			Login loginPage	=pf.initElements(driver,Login.class);
		//Verify  username , password and Submit button.
	 		try {
	 			Assert.assertTrue(helper.isElementPresent(loginPage.username), "username is displayed");
	 			Assert.assertTrue(helper.isElementPresent(loginPage.password), "password is displayed");
	 			Assert.assertTrue(helper.isElementPresent(loginPage.submit), "submit is displayed");
	 			logger2.log(Status.PASS, "On Login page Username ,Password and Submit Button has been verified");	
	 		
		} catch (Error login_page) {
			logger2.log(Status.FAIL, "On Login page Username ,Password Or Submit Button Does not displayed");
			System.out.println("login failed");
			
		} 
		 			 	
		 	Extent.flush();
  
	 }
	 
	
	 @Given("^enter username \"([^\"]*)\" and Password \"([^\"]*)\" for Admin user$")
	 public void enter_username_and_Password_for_Admin_user(String username1, String password1)  throws Throwable {
		 
		 Extent.attachReporter(reporter);
		ExtentTest logger3= Extent.createTest("Verify Login Functionality for Admin user with Username and Password"); 
		Login loginPage	=pf.initElements(driver,Login.class);
		
		//insert username & password
	 	
		loginPage.typeUsername(username1);
	 	loginPage.typePassword(password1);
		logger3.log(Status.INFO, "Enter Username "+username1+" "+"and Paswword"+" "+password1);
		loginPage.clickSubmit();
		
		Extent.flush();
	 }
	
	 
	 
	
	 @Then("^Admin user should be login successfully$")
	 public void admin_user_should_be_login_successfully() throws Throwable {
		 Extent.attachReporter(reporter);
			ExtentTest logger4= Extent.createTest("Verify successfull login for admin user"); 
			Login loginPage	=pf.initElements(driver,Login.class);
			
			
			try {
				
				loginPage.mouseHoverOnRunIcon();
				
				if (loginPage.usersMenu.isDisplayed()) {
		 			
		 			
					System.out.println("user logged in successfully");
		 			logger4.log(Status.PASS,"Admin user logged in successfully");
		 			loginPage.logOut();
			 		logger4.log(Status.PASS, "Admin user log-out successfully");	
					}
				
			} catch (NoSuchElementException invalid_user) {
				
				if(loginPage.TeleventeImage.isDisplayed()) {
				loginPage.logOut();
				logger4.log(Status.FAIL, "Admin user does not have admin access");
				
				}
				try {
					
				} catch (NoSuchElementException invalid_user1) {
					logger4.log(Status.FAIL, "Admin user does not able to login");
				}
			}	
				
			Extent.flush();
				
						
	 } 
	 
	
 	//Scenario: verify login functionality for Reader user			
	 @Given("^enter username \"([^\"]*)\" and Password \"([^\"]*)\" for Reader user$")
	 public void enter_username_and_Password_for_Reader_user(String username1, String password1) throws Throwable {
	     
		 Extent.attachReporter(reporter);
			ExtentTest logger4= Extent.createTest("Verify Login Functionality for Reader user with Username and Password"); 
			Login loginPage	=pf.initElements(driver,Login.class);
			
			//insert username & password
		 	
			loginPage.typeUsername(username1);
		 	loginPage.typePassword(password1);
			logger4.log(Status.INFO, "Enter Username "+username1+" "+"and Paswword"+" "+password1);
			loginPage.clickSubmit();
			
			Extent.flush();
		 
	 }

	 @Then("^Reader user should be login successfully as Reader Role$")
	 public void reader_user_should_be_login_successfully_as_Reader_Role() throws Throwable {
	     
		 Extent.attachReporter(reporter);
			ExtentTest logger5= Extent.createTest("Verify successfull login for Reader user"); 
			Login loginPage	=pf.initElements(driver,Login.class);
			
			
			try {
				
				if (loginPage.TeleventeImage.isDisplayed()) {
		 			
		 			
					System.out.println("Readeruser logged in successfully");
		 			logger5.log(Status.PASS,"Reader user logged in successfully");
		 			
				}else if (loginPage.usersMenu.isDisplayed()) {
					
		 			loginPage.logOut();
			 		logger5.log(Status.FAIL, "Reader user have Admin access");	
					}
				
			} catch (NoSuchElementException invalid_user) {
				logger5.log(Status.FAIL, "Reader user does not able to login");
			}	
				
			Extent.flush();
		 
	 }

	 // configurator user ;
	 
	//Scenario: verify login functionality for configurator user			
		 @Given("^enter username \"([^\"]*)\" and Password \"([^\"]*)\" for configurator user$")
		 public void enter_username_and_Password_for_configuratot_user(String username1, String password1) throws Throwable {
		     
			 Extent.attachReporter(reporter);
				ExtentTest logger7= Extent.createTest("Verify Login Functionality for configurator user with Username and Password"); 
				Login loginPage	=pf.initElements(driver,Login.class);
				
				//insert username & password
			 	
				loginPage.typeUsername(username1);
			 	loginPage.typePassword(password1);
			 	logger7.log(Status.INFO, "Enter Username "+username1+" "+"and Paswword"+" "+password1);
				loginPage.clickSubmit();
				
				Extent.flush();
			 
		 }

		 @Then("^ user should be login successfully as configurator Role$")
		 public void user_should_be_login_successfully_as_configurator_Role() throws Throwable {
		     
			 Extent.attachReporter(reporter);
				ExtentTest logger7= Extent.createTest("Verify successfull login for configurator user"); 
				Login loginPage	=pf.initElements(driver,Login.class);
				
				loginPage.usersMenu.click();
				logger7.log(Status.INFO, "open users menu");
				loginPage.role.click();
				logger7.log(Status.INFO, "Verify configurator role");
				
				try {
					
					loginPage.selectRole("1");					
					logger7.log(Status.FAIL,"configurator has admin rights");
					loginPage.logOut();
					
				} catch (NoSuchElementException conf_user ) {
					logger7.log(Status.PASS,"configurator user logged in successfully");
					loginPage.logOut();
					logger7.log(Status.PASS,"configurator user log out successfully ");
				}
				
				
				
				Extent.flush();
			 
		 }
	 
	 
	 
	 
	 
	 
	 
	 	// Scenario: verify login functionality for invalid user
	 @Given("^enter username \"([^\"]*)\" and Password \"([^\"]*)\" for invalid user$")
	 public void enter_username_and_Password_for_invalid_user(String username1, String password1) throws Throwable {
	    
		 Extent.attachReporter(reporter);
			ExtentTest logger6= Extent.createTest("Verify Login Functionality for Invalid user with Username and Password"); 
			Login loginPage	=pf.initElements(driver,Login.class);
			
			//insert username & password
		 	
			loginPage.typeUsername(username1);
		 	loginPage.typePassword(password1);
			logger6.log(Status.INFO, "Enter Username "+username1+" "+"and Paswword"+" "+password1);
			loginPage.clickSubmit();
			
			Extent.flush();
		 
	 }

	 @Then("^Invalid user should be not be login$")
	 public void invalid_user_should_be_not_be_login() throws Throwable {
		 Extent.attachReporter(reporter);
			ExtentTest logger5= Extent.createTest("Verify successfull login for invalid user"); 
			Login loginPage	=pf.initElements(driver,Login.class);
			
			
			try {
				
				if (loginPage.invalid.isDisplayed()) {
		 			
		 			
					System.out.println("Invaid user does Able not login");
		 			logger5.log(Status.PASS,"Invalid user not does not able to login ");
		 				
					}
				
			} catch (NoSuchElementException invalid_user) {
				logger5.log(Status.FAIL, "invalid user able to login successfully");
			}	
				
			Extent.flush();
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
		

	
		