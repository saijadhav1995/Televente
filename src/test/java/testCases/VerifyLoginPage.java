package testCases;



import java.util.concurrent.TimeUnit;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.apache.poi.util.SystemOutLogger;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.pages.Login;

import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import lib.ExcelConfig;




public class VerifyLoginPage {
	
	WebDriver driver;
	
public ExtentHtmlReporter reporter=new ExtentHtmlReporter("./target/Extent_Report.html");
public ExtentReports Extent=new ExtentReports();

	
	@BeforeTest
	@Given("^open chrome browser and start application$")
	public void open_chrome_browser_and_start_application() throws Throwable {
		 
		Extent.attachReporter(reporter);
		reporter.config().setTheme(Theme.DARK);
		
		ExtentTest logger= Extent.createTest("OpenBrowser And Start Application");

				System.setProperty("webdriver.chrome.driver",
				 System.getProperty("user.dir")+"\\Drivers\\chromedriver_win32 (3)\\chromedriver.exe");
				 		
				 driver=new ChromeDriver();
					
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					driver.manage().window().maximize();
					driver.get("https://televente.mutlp.test.pointp.saint-gobain.net/");	 
				logger.log(Status.INFO, "open chrome browser and start application");
				logger.log(Status.PASS, "successfully Start Application");
				
				Extent.flush();
						
	}
	
	 @AfterTest
	 public void closeBrowser() {
		 
		 driver.quit();
	 }

	 
	 @Test(dataProvider="televentelogin")
	 @Then("^verify loginfunctionality with \"([^\"]*)\" and \"([^\"]*)\"$")
	 public void  verify_loginfunctionality_with_and(String username1, String password1) throws Exception {

		 
		 Extent.attachReporter(reporter);
			ExtentTest logger1= Extent.createTest("Verify Login Functionality with Username and Password");
		 
	 		Login login=new Login(driver);
	 		login.clicklink();
	 		
	 		
	 			
	 			login.typeUsername(username1);
		 		login.typePassword(password1);
		 		logger1.log(Status.INFO, "Enter Username "+username1+" "+"and Paswword"+" "+password1);
	 		   	login.clickSubmit();
	 		   	
				
	 			 		
	 		try {
				
	 			if (driver.findElement(login.image).isDisplayed()) {
		 			
	 			
	 				System.out.println("user logged in successfully with"+" "+username1+"and"+" "+password1 );
		 			logger1.log(Status.PASS,"user logged in successfully");
	 				   login.logOut();
			 		logger1.log(Status.PASS, "user log-out successfully");	
		 		}
	 				
			} catch (NoSuchElementException e) {
				
				
			try {
				if (driver.findElement(login.invalid).isDisplayed()) {
					
					driver.navigate().to("https://televente.mutlp.test.pointp.saint-gobain.net/");
		 			System.out.println("invalid user");
		 			logger1.log(Status.PASS, "invalid user");
					}		
				
				}catch(NoSuchElementException e1) {
					
					
		 			System.out.println("inactive user");
		 			logger1.log(Status.PASS, "inActive user");
				}
	 		
			}
	 		
	 		Extent.flush();
	 		} 	
	 
	
	 
	
	 @DataProvider(name="televentelogin")
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
	 }
	
	 
	 
	 


			
}		
		

	
		