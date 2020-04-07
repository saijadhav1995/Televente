package pages;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.AppstringsConstant;

import java.io.IOException;

import webBase.BasePage;
import webBase.BaseTest;
import webBase.BrowserFactory;
import webElements_Identifiers.CreateForm;
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



public class VerifyHome extends BasePage {


	public ExtentTest logger;	
	public ExtentTest extentest;
	public SoftAssert SAssert = new SoftAssert();
	public PageFactory pf=new PageFactory();
	BrowserFactory Bf=new BrowserFactory();

	BaseTest baseT = new BaseTest();
	String className = "";
	Home homePage = new Home(driver);
	AppstringsConstant appConst =new AppstringsConstant(); 
	
	 

	public void Verify_the_Home_Page(String TestName) throws Throwable {
		
		
		BasePage.Basepagedriver = BrowserFactory.startBrowser(appConst.select_Browser,appConst.URL);
		logger = baseT.extent.startTest(TestName);			
		homePage=	PageFactory.initElements(driver, Home.class);
		createDirectory("TELEVENTE"+TestName);

				
		logger.log(LogStatus.PASS,"start application sucessfully"
				+logger.addScreenCapture(captureScreenShot(driver, "start application sucessfully")));		
				
		
		logger.log(LogStatus.INFO, "open chrome browser and start application");		
			
			Thread.sleep(3000);
			
			driver.navigate().to(appConst.URL);
			  homePage.link.click();
	          homePage.username.sendKeys(appConst.Admin_SGID);
	          homePage.password.sendKeys(appConst.Admin_password);
	          homePage.submit.click();
	           
	         String ActualHomePageurl= driver.getCurrentUrl();
	           
	         System.out.println(ActualHomePageurl);
	         
	         String Expected_homepageurl ="https://televente.mutlp.test.pointp.saint-gobain.net/televente/home";
	           
	         if(Expected_homepageurl.equals(ActualHomePageurl)){
	            
	        	 System.out.println("HomePage has been verified");
	        	 
	 
	        	 logger.log(LogStatus.PASS,"HomePage has been verified"
	     				+logger.addScreenCapture(captureScreenShot(driver,"HomePage has been verified")));		
	     				

	         
	         
	         }
	             else {
	             
	            	 System.out.println("getting Error to open HomePage url");
	            	 
	            	 logger.log(LogStatus.FAIL,"getting Error to open HomePage"
	 	     				+logger.addScreenCapture(captureScreenShot(driver,"getting Error to open HomePage")));		
	 	     		
	            	 
	             }	           
	       
	        
						
	}
		
	
		
	public void Verifytitle() throws Throwable {
		 
		
	
		String ActualTitle=driver.findElement(By.xpath("//*[@id=\"panel\"]/div[1]/div/div/div[1]/div/h6")).getText();	
 		
     	
     	 System.out.println(ActualTitle);
         
         String ExpectedTitle=appConst.PAGETITLE;
           
         if(ExpectedTitle.equals(ActualTitle)){
            
        	 System.out.println("Title "+ActualTitle+" has been verified");
        	
        	 logger.log(LogStatus.PASS,"Title "+ActualTitle+" has been verified"
	     				+logger.addScreenCapture(captureScreenShot(driver," has been verified")));		
	     		
        	 
        	 

         }
             else {
             
            	 System.out.println(ExpectedTitle+" its not equals to "+ActualTitle);
            	 
            	 
            	 logger.log(LogStatus.FAIL,ExpectedTitle+" its not equals to "+ActualTitle
 	     				+logger.addScreenCapture(captureScreenShot(driver,ExpectedTitle+" its not equals to "+ActualTitle)));		
 	     	
             }	           
       
     	
    
	}
	
	
	
	public void VerifyContent() throws Throwable {
		
		
		
	
		
		 
		try {
			
			String ActualUser=driver.findElement(By.xpath("//*[@class='nav-link-text' and @title]")).getText();	
			if(ActualUser!=" ") {
			
			System.out.println(ActualUser);		
			
		
			 logger.log(LogStatus.PASS,"SGID "+ActualUser+" has been verified on Drawer"
	     				+logger.addScreenCapture(captureScreenShot(driver,"SGID "+ActualUser+" has been verified on Drawer")));		
	     	
			
			}else {
					
				logger.log(LogStatus.FAIL,"failed to get SGID"
	     				+logger.addScreenCapture(captureScreenShot(driver,"failed to get SGID")));		
	     	
		
					
			}
		
			if(homePage.televente.isDisplayed()) {
				
				logger.log(LogStatus.PASS,"televente menu is present on Drawer"
	     				+logger.addScreenCapture(captureScreenShot(driver,"televente menu is present on Drawer")));		
	     	
		
			}
			
			if (homePage.SGID.isDisplayed()) {
				
				logger.log(LogStatus.PASS,"users menu is present on Drawer"
	     				+logger.addScreenCapture(captureScreenShot(driver,"users menu is present on Drawer")));		
	     	
				
	
			}
			
			if (homePage.logout.isDisplayed()) {
				
				logger.log(LogStatus.PASS,"deconnexion button is present on Drawer"
	     				+logger.addScreenCapture(captureScreenShot(driver,"deconnexion button is present on Drawer")));		
	     	
				
			
			}
	
			
		} catch (Exception content) {
			
			logger.log(LogStatus.FAIL,"content missing on Drawer Menu"
     				+logger.addScreenCapture(captureScreenShot(driver,"content missing on Drawer Menu")));		
     	
		}
		
	
	}
	
	public void VerifyRegionDropDwon() throws Throwable {
		 
		
	
		
		try {
			homePage.Region(appConst.select_region_id);
			logger.log(LogStatus.PASS,"user able to select region"
     				+logger.addScreenCapture(captureScreenShot(driver,"user able to select region")));		
     	
			
	
			
		} catch (Exception region) {
			
			logger.log(LogStatus.FAIL,"user does not  able to select region"
     				+logger.addScreenCapture(captureScreenShot(driver,"user does not  able to select region")));		
     	
		}
				
	}
	
	
//toggle buttons	
	
	public void pastToggleButton() throws Throwable {		
	try {
	
		homePage.ToggleButtonforPast();		
		Thread.sleep(2000);    
		logger.log(LogStatus.PASS,"user able to click on toggle Button to See past Televentes"
 				+logger.addScreenCapture(captureScreenShot(driver,"user able to click on toggle Button to See past Televentes")));		
 			 	    	
	} catch (Exception toggle) {
	
		logger.log(LogStatus.FAIL,"user does not able to click on toggle Button "
 				+logger.addScreenCapture(captureScreenShot(driver,"user does not able to click on toggle Button ")));		
		
		}
	}		
	
	public void futureToggleButton() throws Throwable {
		 
		try {
							
			Thread.sleep(2000);
		    					
		    homePage.ToggleButtonforfuture();
		    
		    logger.log(LogStatus.PASS,"user able to click on toggle Button to See Future Televentes"
	 				+logger.addScreenCapture(captureScreenShot(driver,"user able to click on toggle Button to See Future Televentes")));		
	 			    
			
		} catch (Exception toggle) {
		
			logger.log(LogStatus.FAIL,"user does not able to click on toggle Button "
	 				+logger.addScreenCapture(captureScreenShot(driver,"user does not able to click on toggle Button ")));		
	 				
		}
			


		}
		


	
//pagination DropDown Field	
	public void VerifyPaginationDropDown() throws Throwable {
		
		
	
		
		try {
			homePage.paginationDropDown("25");
		
			logger.log(LogStatus.PASS,"user able to select pagination rows from Drop down "
	 				+logger.addScreenCapture(captureScreenShot(driver,"user able to select pagination rows from Drop down ")));		
	 	
			
			
		} catch (Exception region) {
			
			logger.log(LogStatus.FAIL,"user does not  able to select pagination rows from Drop down"
	 				+logger.addScreenCapture(captureScreenShot(driver,"user does not  able to select pagination rows from Drop down")));		
	 	
			
			
		}
				
	}
		
	
//rechercher field	
	public void VerifySearchFeild() throws Throwable {
		 
		
			
		
		try {
			homePage.searchField("test");
			
			logger.log(LogStatus.PASS,"user able to enter Text on Search field"
	 				+logger.addScreenCapture(captureScreenShot(driver,"user able to enter Text on Search field")));		
	 	
					
			
		} catch (Exception region) {
			
			logger.log(LogStatus.FAIL,"user Deos not able to enter Text on Search field"
	 				+logger.addScreenCapture(captureScreenShot(driver,"user Deos not able to enter Text on Search field")));		
	 	
			
		}
				
		
	}
	
	
	public void VerifyPaginationArrows( ) throws Throwable {
		 


		
		
		try {
			
			Actions action=new Actions(driver);
			action.sendKeys(Keys.PAGE_DOWN);

			if(homePage.NextpaginationButtonIsDisabled.isDisplayed()) {
				
				logger.log(LogStatus.INFO,"pagination Buttons are disabled"
		 				+logger.addScreenCapture(captureScreenShot(driver,"pagination Buttons are disabled")));		
		
				action.sendKeys(Keys.PAGE_UP);
			} 
			
				
		} catch (Exception pagination) {
			
			
			try {
			if(homePage.NextpaginationButtonIsEnable.isDisplayed()) {
				
				
				logger.log(LogStatus.INFO," Next pagination Buttons is enabled"
		 				+logger.addScreenCapture(captureScreenShot(driver," Next pagination Buttons is enabled")));		
		 	
				
				homePage.clickNextpaginationButton();
				
				logger.log(LogStatus.PASS,"user clicked on next pagination button"
		 				+logger.addScreenCapture(captureScreenShot(driver,"user clicked on next pagination button")));		
		
				Thread.sleep(3000);
				homePage.clickPreviouspaginationButton();
				
				logger.log(LogStatus.PASS,"user clicked on Previous pagination button"
		 				+logger.addScreenCapture(captureScreenShot(driver,"user clicked on Previous pagination button")));		
		
				Thread.sleep(3000);
				Actions action=new Actions(driver);
				action.sendKeys(Keys.PAGE_UP);
					
			} 
				
			} catch (Exception next) {
				
		
				
				logger.log(LogStatus.FAIL,"user deosnt able to clicked on pagination arrows"
		 				+logger.addScreenCapture(captureScreenShot(driver,"user deosnt able to clicked on pagination arrows")));		
		
				
				
			}
			
				}
				

	}
	
	
	public void VerifyCreationAndDeletionButton( ) throws Throwable {
		 
	
	
		
		try {
			if(homePage.deleteButton.isDisplayed()) {
				
				logger.log(LogStatus.PASS,"delete button is visible on HomePage"
		 				+logger.addScreenCapture(captureScreenShot(driver,"delete button is visible on HomePage")));		
		
			
				
				
			}
			if(homePage.createButton.isDisplayed()) {
				
				logger.log(LogStatus.PASS,"create button is visible on HomePage"
		 				+logger.addScreenCapture(captureScreenShot(driver,"create button is visible on HomePage")));		
		
				
				
				
			}
			
		} catch (Exception creationDeletion) {
			
			logger.log(LogStatus.FAIL,"create & delete button are Not visible on HomePage"
	 				+logger.addScreenCapture(captureScreenShot(driver,"create & delete button are Not visible on HomePage")));		
	
			
		}
				
		
	}
		
	
	public void VerifyActionColumn( ) throws Throwable {
		 
	
	
		
		
		try {
			if(homePage.eyeIcon.isDisplayed()) {
				
				logger.log(LogStatus.PASS,"Ranking icon is visible on HomePage"
		 				+logger.addScreenCapture(captureScreenShot(driver,"Ranking icon is visible on HomePage")));		
		
				
				
			}
			if(homePage.euroIcon.isDisplayed()) {
				
				logger.log(LogStatus.PASS,"Billing icon is visible on HomePage"
		 				+logger.addScreenCapture(captureScreenShot(driver,"Billing icon is visible on HomePage")));		
		
			
				
				
			}
			
			if(homePage.settingIcon.isDisplayed()) {
				
				logger.log(LogStatus.PASS,"Setting icon is visible on HomePage"
		 				+logger.addScreenCapture(captureScreenShot(driver,"Setting icon is visible on HomePage")));		
		
			
				
				
			}
			
		} catch (Exception icons) {
			
			logger.log(LogStatus.INFO,"Televente doesnt available on homePage hence icons are missing"
	 				+logger.addScreenCapture(captureScreenShot(driver,"Televente doesnt available on homePage hence icons are missing")));		
	
	
		
		}
		
		try {
			
			if(homePage.DeleteIcon.isDisplayed()) {
				
				
				logger.log(LogStatus.PASS,"delete icon is visible on HomePage"
		 				+logger.addScreenCapture(captureScreenShot(driver,"delete icon is visible on HomePage")));		
		
				
				
			}
			
			
		} catch (Exception deleteicon) {
		
			logger.log(LogStatus.INFO,"delete icon is disabled as televente is not avaialable or televente in past or inprogress"
	 				+logger.addScreenCapture(captureScreenShot(driver,"delete icon is disabled as televente is not avaialable or televente in past or inprogress")));		
	
			
			
		}	
		
			
			
				
	
	}
	
	
	
}