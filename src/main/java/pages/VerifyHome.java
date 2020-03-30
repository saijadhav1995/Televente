package pages;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

import library.BrowserFactory;
import webElements_Identifiers.Home;
import webElements_Identifiers.Login;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import javax.swing.plaf.ActionMapUIResource;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;



public class VerifyHome extends BrowserFactory {

	
	public ExtentHtmlReporter reporter=new ExtentHtmlReporter("./target/Extent_Report.html");
	public ExtentReports Extent=new ExtentReports();
	public ExtentTest extentest;
	public SoftAssert SAssert = new SoftAssert();
	public PageFactory pf=new PageFactory();
	BrowserFactory Bf=new BrowserFactory();

	
	
	 

	public void Verify_the_Home_Page() throws Throwable {
		 
		Extent.attachReporter(reporter);
		reporter.config().setTheme(Theme.DARK);
		
		ExtentTest logger= Extent.createTest("Verify the Televente Home Page");

				
				Bf.startBrowser("chrome","https://televente.mutlp.test.pointp.saint-gobain.net");
				logger.log(Status.INFO, "open chrome browser and start application");
				logger.log(Status.PASS,"start application sucessfully");
				
	           Home homePage =pf.initElements(driver,Home.class);
	           
	           homePage.Connection();
	           
	         String ActualHomePageurl= driver.getCurrentUrl();
	           
	         System.out.println(ActualHomePageurl);
	         
	         String Expected_homepageurl ="https://televente.mutlp.test.pointp.saint-gobain.net/televente/home";
	           
	         if(Expected_homepageurl.equals(ActualHomePageurl)){
	            
	        	 System.out.println("HomePage has been verified");
	        	 logger.log(Status.PASS,"HomePage has been verified");
	         }
	             else {
	             
	            	 System.out.println("getting Error to open HomePage url");
	            	 logger.log(Status.FAIL,"getting Error to open HomePage");
	             }	           
	       
	         
	         
	     	
				Extent.flush();
						
	}
		
	
		
	public void Verifytitle() throws Throwable {
		 
		Extent.attachReporter(reporter);
		reporter.config().setTheme(Theme.DARK);
		
		ExtentTest logger1= Extent.createTest("Verify the Televente title On Home Page");
	
		String ActualTitle=driver.findElement(By.xpath("//*[@id=\"panel\"]/div[1]/div/div/div[1]/div/h6")).getText();	
 		
     	
     	 System.out.println(ActualTitle);
         
         String ExpectedTitle="Télévente";
           
         if(ExpectedTitle.equals(ActualTitle)){
            
        	 System.out.println("Title "+ActualTitle+" has been verified");
        	 logger1.log(Status.PASS,"Title "+ActualTitle+" has been verified");
         }
             else {
             
            	 System.out.println(ExpectedTitle+" its not equals to "+ActualTitle);
            	 logger1.log(Status.FAIL,ExpectedTitle+" its not equals to "+ActualTitle);
             }	           
       
     	
     	
     	Extent.flush();
	}
	
	
	
	public void VerifyContent() throws Throwable {
		 
		Extent.attachReporter(reporter);
		reporter.config().setTheme(Theme.DARK);	
		ExtentTest logger2= Extent.createTest("Verify content present on Drawer");
		Home homePage =pf.initElements(driver,Home.class);
         
		try {
			
			String ActualUser=driver.findElement(By.xpath("//*[@class='nav-link-text' and @title]")).getText();	
			if(ActualUser!=" ") {
			
			System.out.println(ActualUser);		
			
			logger2.log(Status.PASS,"SGID "+ActualUser+" has been verified on Drawer");
			
			}else {
					
				
				logger2.log(Status.FAIL,"failed to get SGID");
					
			}
		
			if(homePage.televente.isDisplayed()) {
				
				logger2.log(Status.PASS,"televente menu is present on Drawer");
			}
			
			if (homePage.SGID.isDisplayed()) {
				
				logger2.log(Status.PASS,"users menu is present on Drawer");
			}
			
			if (homePage.logout.isDisplayed()) {
				
				logger2.log(Status.PASS,"deconnexion button is present on Drawer");
			}
	
			
		} catch (Exception content) {
			
			logger2.log(Status.FAIL,"content missing on Drawer Menu");
		}
		
		Extent.flush();	
	}
	
	public void VerifyRegionDropDwon() throws Throwable {
		 
		Extent.attachReporter(reporter);
		reporter.config().setTheme(Theme.DARK);	
		ExtentTest logger3= Extent.createTest("Verify Region Drop Dwon field");
		Home homePage =pf.initElements(driver,Home.class);
    
		try {
			homePage.Region("6");
			logger3.log(Status.PASS,"user able to select region");
		
			
		} catch (Exception region) {
			logger3.log(Status.FAIL,"user does not  able to select region");
		}
				
		Extent.flush();	
	}
	
	public void VerifyToggleButton() throws Throwable {
		 
		Extent.attachReporter(reporter);
		reporter.config().setTheme(Theme.DARK);	
		ExtentTest logger4= Extent.createTest("Verify the functionality of toggle button ");
		Home homePage =pf.initElements(driver,Home.class);
		
	try {
	
		homePage.ToggleButtonforPast();
		
		Thread.sleep(2000);
	    
	    logger4.log(Status.PASS,"user able to click on toggle Button to See past Televentes");

	    homePage.ToggleButtonforfuture();
	    
	    logger4.log(Status.PASS,"user able to click on toggle Button to See Future Televentes");
		
	} catch (Exception toggle) {
	
		logger4.log(Status.FAIL,"user does not able to click on toggle Button ");
		
	}
		
	Extent.flush();

	}
	
	public void VerifyPaginationDropDown() throws Throwable {
		 
		Extent.attachReporter(reporter);
		reporter.config().setTheme(Theme.DARK);	
		ExtentTest logger5= Extent.createTest("Verify Pagination Drop Down Field");
		Home homePage =pf.initElements(driver,Home.class);
    
		try {
			homePage.paginationDropDown("25");
			logger5.log(Status.PASS,"user able to select pagination rows from Drop down ");
		
			
		} catch (Exception region) {
			logger5.log(Status.FAIL,"user does not  able to select pagination rows from Drop down");
		}
				
		Extent.flush();	
	}
		
	
	
	public void VerifySearchFeild() throws Throwable {
		 
		Extent.attachReporter(reporter);
		reporter.config().setTheme(Theme.DARK);	
		ExtentTest logger6= Extent.createTest("Verify Rechercher Field");
		Home homePage =pf.initElements(driver,Home.class);
    
		try {
			homePage.searchField("test");
			logger6.log(Status.PASS,"user able to enter Text on Search field");
		
			
		} catch (Exception region) {
			logger6.log(Status.FAIL,"user Deos not able to enter Text on Search field");
		}
				
		Extent.flush();	
	}
	
	
	public void VerifyPaginationArrows() throws Throwable {
		 
		Extent.attachReporter(reporter);
		reporter.config().setTheme(Theme.DARK);	
		ExtentTest logger7= Extent.createTest("Verify Pagination Arrows");
		Home homePage =pf.initElements(driver,Home.class);
    
		try {
			
			Actions action=new Actions(driver);
			action.sendKeys(Keys.PAGE_DOWN);

			if(homePage.NextpaginationButtonIsDisabled.isDisplayed()) {
				
				logger7.log(Status.INFO,"pagination Buttons are disabled");
			} 
			
				
		} catch (Exception pagination) {
			
			
			try {
			if(homePage.NextpaginationButtonIsEnable.isDisplayed()) {
				
				logger7.log(Status.INFO," Next pagination Buttons is enabled");
				homePage.clickNextpaginationButton();
				logger7.log(Status.PASS,"user clicked on next pagination button");
				Thread.sleep(3000);
				homePage.clickPreviouspaginationButton();
				logger7.log(Status.PASS,"user clicked on Previous pagination button");
				Thread.sleep(3000);
				Actions action=new Actions(driver);
				action.sendKeys(Keys.PAGE_UP);
					
			} 
				
			} catch (Exception next) {
				
				logger7.log(Status.FAIL,"user deosnt able to clicked on pagination arrows");
				
				
			}
			
				}
				
		Extent.flush();	
	}
	
	
	public void VerifyCreationAndDeletionButton() throws Throwable {
		 
		Extent.attachReporter(reporter);
		reporter.config().setTheme(Theme.DARK);	
		ExtentTest logger8= Extent.createTest("Verify Creation & Deletion Buttons On Home Page");
		Home homePage =pf.initElements(driver,Home.class);
    
		try {
			if(homePage.deleteButton.isDisplayed()) {
				logger8.log(Status.PASS,"delete button is visible on HomePage");
				
				
			}
			if(homePage.createButton.isDisplayed()) {
				logger8.log(Status.PASS,"create button is visible on HomePage");
				
				
			}
			
		} catch (Exception creationDeletion) {
			logger8.log(Status.FAIL,"create & delete button are Not visible on HomePage");
		}
				
		Extent.flush();	
	}
		
	
	public void VerifyActionColumn() throws Throwable {
		 
		Extent.attachReporter(reporter);
		reporter.config().setTheme(Theme.DARK);	
		ExtentTest logger8= Extent.createTest("Verify Action Coulmn on Televente Grid");
		Home homePage =pf.initElements(driver,Home.class);
    
		try {
			if(homePage.eyeIcon.isDisplayed()) {
				logger8.log(Status.PASS,"Ranking icon is visible on HomePage");
				
				
			}
			if(homePage.euroIcon.isDisplayed()) {
				logger8.log(Status.PASS,"Billing icon is visible on HomePage");
				
				
			}
			
			if(homePage.settingIcon.isDisplayed()) {
				logger8.log(Status.PASS,"Setting icon is visible on HomePage");
				
				
			}
			
		} catch (Exception icons) {
			logger8.log(Status.INFO,"Televente doesnt available on homePage hence icons are missing");
		}
		
		try {
			
			if(homePage.DeleteIcon.isDisplayed()) {
				logger8.log(Status.PASS,"delete icon is visible on HomePage");
				
				
			}
			
			
		} catch (Exception deleteicon) {
			
			logger8.log(Status.INFO,"delete icon is disabled as televente is not avaialable or televente in past or inprogress");
		}	
		
			
			
				
		Extent.flush();	
	}
	
	
	
}