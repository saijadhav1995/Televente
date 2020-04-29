package pages;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.AppstringsConstant;
import Utility.Helper;

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



public class VerifyHome extends BasePage {


	public ExtentTest logger;	
	public ExtentTest extentest;
	public SoftAssert SAssert = new SoftAssert();
	public PageFactory pf=new PageFactory();
	BrowserFactory Bf=new BrowserFactory();
	public Helper helper=new Helper();

	BaseTest baseT = new BaseTest();
	String className = "";
	Home homePage = new Home(driver);
	AppstringsConstant appConst =new AppstringsConstant(); 
	
	 

	public void Verify_the_Home_Page(String TestName) throws Throwable {
		
		
	try {
		
	
		logger = baseT.extent.startTest(TestName);			
		homePage=	PageFactory.initElements(driver, Home.class);
		createDirectory("TELEVENTE"+TestName);

				
		logger.log(LogStatus.PASS,"<b><font color='green'>Result:start application sucessfully"
				+logger.addScreenCapture(captureScreenShot(driver, "start application sucessfully")));		
				
			
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
	        	 
	 
	        	 logger.log(LogStatus.PASS,"<b><font color='green'>Result:HomePage has been verified"
	     				+logger.addScreenCapture(captureScreenShot(driver,"HomePage has been verified")));		
	     				

	         
	         
	         }
	             else {
	             
	            	 System.out.println("getting Error to open HomePage url");
	            	 
	            	 logger.log(LogStatus.FAIL,"<b><font color='red'>Result:getting Error to open HomePage"
	 	     				+logger.addScreenCapture(captureScreenShot(driver,"getting Error to open HomePage")));		
	 	     		
	            	 
	             }	           
	       
	} catch (Exception e) {
      	 logger.log(LogStatus.FAIL,"<b><font color='red'>Result:getting Error to open HomePage"
	     				+logger.addScreenCapture(captureScreenShot(driver,"getting Error to open HomePage")));		
	}        
						
	}
		
	
		
	public void Verifytitle() throws Throwable {
		 
		try {
			

				
			WebElement title=driver.findElement(By.xpath("//*[@id=\"panel\"]/div[1]/div/div/div[1]/div/h6"));	
 		

			String ActualTitle=title.getText();
			
     	 System.out.println(ActualTitle);
         
         String ExpectedTitle=appConst.PAGETITLE;
           
         if(ExpectedTitle.equals(ActualTitle)){
            
        	 System.out.println("Title "+ActualTitle+" has been verified");
        	 
        	 
        	helper.javaScriptHighlightWebElement(title);
        	
        	 logger.log(LogStatus.PASS,"1:Actual Title is "+"<b>"+ActualTitle+"</b>"+"<br/>"
        			 +"1:Expected Title is "+"<b>"+ExpectedTitle+"</b>"+"<br/>"        			 
        			+ "<b><font color='green'>Result:Title has been verified<font/>"
	     				+logger.addScreenCapture(captureScreenShot(driver," Title has been verified")));		
	     		
        	 helper.javaScriptUn_HighlightWebElement(title);
        	 

         }
             else {
             
            	 System.out.println(ExpectedTitle+" its not equals to "+ActualTitle);
            	 
             	helper.javaScriptHighlightWebElement(title);            	 
             	 logger.log(LogStatus.FAIL,"1:Actual Title is "+"<b>"+ActualTitle+"</b>"+"<br/>"
            			 +"2:Expected Title is "+"<b>"+ExpectedTitle+"</b>"+"<br/>"        			 
            			+ "<b><font color='red'>Result:Title Does not Get Matched<font/>" 
             	+logger.addScreenCapture(captureScreenShot(driver,ExpectedTitle+" its not equals to "+ActualTitle)));		
 	    
            	 helper.javaScriptUn_HighlightWebElement(title);
                 
             }	           
       
		} catch (Exception e) {
			
       	 logger.log(LogStatus.FAIL,"<b><font color='red'>Result: Error on televente Title"
   				+logger.addScreenCapture(captureScreenShot(driver,"Error on televente Title")));		
		}
	 	
    
	}
	
	
	
	public void VerifyContent() throws Throwable {
		
		
		
	
		
		 
		try {
			WebElement user=driver.findElement(By.xpath("//*[@class='nav-link-text' and @title]"));
			
			String ActualUser=user.getText();	
			
			if(ActualUser!=" ") {
			
			System.out.println(ActualUser);		
			
		helper.javaScriptHighlightWebElement(user);
			 logger.log(LogStatus.PASS,"1:Verifying logged in user SGID is present on Drawer "+"<br/>"
					 +"<font color='green'>Result:  SGID "+"<b>"+ActualUser+"</b>"+" has been verified on Drawer<font/>"
	     				+logger.addScreenCapture(captureScreenShot(driver,"SGID "+ActualUser+" has been verified on Drawer")));		
	     	
		helper.javaScriptUn_HighlightWebElement(user);	
			 
			}else {

				helper.javaScriptHighlightWebElement(user);
							
				logger.log(LogStatus.FAIL,"<b><font color='red'>Result: failed to get SGID"
	     				+logger.addScreenCapture(captureScreenShot(driver,"failed to get SGID")));		
	     	
				helper.javaScriptUn_HighlightWebElement(user);	
				
					
			}
		
			if(homePage.televente.isDisplayed()) {
				
				helper.javaScriptHighlightWebElement(homePage.televente);

				logger.log(LogStatus.PASS,"1: Verifying Televente Menu on Drawer"+"<br/>"
						+"<b><font color='green'>Result: televente menu is present on Drawer"
	     				+logger.addScreenCapture(captureScreenShot(driver,"televente menu is present on Drawer")));		
				
				helper.javaScriptUn_HighlightWebElement(homePage.televente);	

		
			}else {
				
				logger.log(LogStatus.FAIL,"1: Verifying Televente Menu on Drawer"+"<br/>"
						+"<b><font color='red'>Result: televente menu is missing on Drawer"
	     				+logger.addScreenCapture(captureScreenShot(driver,"televente menu is missing on Drawer")));		
	     	
			}
			
			if (homePage.usersMenu.isDisplayed()) {
				
				helper.javaScriptHighlightWebElement(homePage.usersMenu);

				logger.log(LogStatus.PASS,"1: Verifying Users Menu on Drawer"+"<br/>"
						+"<b><font color='green'>Result: users menu is present on Drawer"
	     				+logger.addScreenCapture(captureScreenShot(driver,"users menu is present on Drawer")));		
	     	
				helper.javaScriptUn_HighlightWebElement(homePage.usersMenu);	

	
			}else {
				
				logger.log(LogStatus.FAIL,"1:Verifying Users Menu on Drawer"+"<br/>"
						+"<b><font color='red'>Result: Users menu is missing on Drawer"
	     				+logger.addScreenCapture(captureScreenShot(driver,"televente menu is missing on Drawer")));		
	     	
			}
			
			if (homePage.logout.isDisplayed()) {
				
				helper.javaScriptHighlightWebElement(homePage.logout);

				logger.log(LogStatus.PASS,"Verifying Deconnexion Button On Drawer "+"<br/>"
						+"<b><font color='green'>Result: deconnexion button is present on Drawer"
	     				+logger.addScreenCapture(captureScreenShot(driver,"deconnexion button is present on Drawer")));		
				
				helper.javaScriptUn_HighlightWebElement(homePage.logout);	

				
			
			} else {
				
				logger.log(LogStatus.FAIL,"<b><font color='green'>Result: televente menu is present on Drawer"
	     				+logger.addScreenCapture(captureScreenShot(driver,"televente menu is present on Drawer")));		
	     	
			}
	
		
			homePage.slider.click();
			
		} catch (Exception content) {
			
			logger.log(LogStatus.FAIL,"<b><font color='red'>Result: content missing on Drawer Menu"
     				+logger.addScreenCapture(captureScreenShot(driver,"content missing on Drawer Menu")));		
     	
		}
		
	
		
		
		
	}
	
	public void VerifyRegionDropDwon() throws Throwable {
		 
		
	
		
		try {
			homePage.Region(appConst.select_region_id);
			
			helper.javaScriptHighlightWebElement(homePage.Region_dropDown);
			logger.log(LogStatus.PASS,"1:click on Region Drop Down Field"+"<br/>"
					+"<b><font color='green'>Result: user able to select region"
     				+logger.addScreenCapture(captureScreenShot(driver,"user able to select region")));		
     	
			helper.javaScriptUn_HighlightWebElement(homePage.Region_dropDown);	
			
		} catch (Exception region) {
			
			logger.log(LogStatus.FAIL,"<b><font color='red'>Result: user does not  able to select region"
     				+logger.addScreenCapture(captureScreenShot(driver,"user does not  able to select region")));		
     	
		}
				
	}
	
	
//toggle buttons	
	
	public void pastToggleButton() throws Throwable {		
	try {
	
		homePage.ToggleButtonforPast();		
		Thread.sleep(2000);    
		logger.log(LogStatus.PASS,"<b><font color='green'>Result: user able to click on toggle Button to See past Televentes"
 				+logger.addScreenCapture(captureScreenShot(driver,"user able to click on toggle Button to See past Televentes")));		
 			 	    	
	} catch (Exception toggle) {
	
		logger.log(LogStatus.FAIL,"<b><font color='red'>Result: user does not able to click on toggle Button "
 				+logger.addScreenCapture(captureScreenShot(driver,"user does not able to click on toggle Button ")));		
		
		}
	}		
	
	public void futureToggleButton() throws Throwable {
		 
		try {
							
			Thread.sleep(2000);
		    					
		    homePage.ToggleButtonforfuture();
		    
		    logger.log(LogStatus.PASS,"<b><font color='green'>Result: user able to click on toggle Button to See Future Televentes"
	 				+logger.addScreenCapture(captureScreenShot(driver,"user able to click on toggle Button to See Future Televentes")));		
	 			    
			
		} catch (Exception toggle) {
		
			logger.log(LogStatus.FAIL,"<b><font color='red'>Result: user does not able to click on toggle Button "
	 				+logger.addScreenCapture(captureScreenShot(driver,"user does not able to click on toggle Button ")));		
	 				
		}
			


		}
		


	
//pagination DropDown Field	
	public void VerifyPaginationDropDown() throws Throwable {
		
		
	
		
		try {
			homePage.paginationDropDown("25");
		
			logger.log(LogStatus.PASS,"<b><font color='green'>Result: user able to select pagination rows from Drop down "
	 				+logger.addScreenCapture(captureScreenShot(driver,"user able to select pagination rows from Drop down ")));		
	 	
			
			
		} catch (Exception region) {
			
			logger.log(LogStatus.FAIL,"<b><font color='red'>Result: user does not  able to select pagination rows from Drop down"
	 				+logger.addScreenCapture(captureScreenShot(driver,"user does not  able to select pagination rows from Drop down")));		
	 	
			
			
		}
				
	}
		
	
//rechercher field	
	public void VerifySearchFeild() throws Throwable {
		 
		
			
		
		try {
			homePage.searchField("test");
			
			logger.log(LogStatus.PASS,"<b><font color='green'>Result: user able to enter Text on Search field"
	 				+logger.addScreenCapture(captureScreenShot(driver,"user able to enter Text on Search field")));		
	 	
					
			
		} catch (Exception region) {
			
			logger.log(LogStatus.FAIL,"<b><font color='red'>Result: user Deos not able to enter Text on Search field"
	 				+logger.addScreenCapture(captureScreenShot(driver,"user Deos not able to enter Text on Search field")));		
	 	
			
		}
				
		
	}
	
	
	public void VerifyPaginationArrows( ) throws Throwable {
		 


		
		
		try {
			
			Actions action=new Actions(driver);
			action.sendKeys(Keys.PAGE_DOWN);

			if(homePage.NextpaginationButtonIsDisabled.isDisplayed()) {
				
				logger.log(LogStatus.INFO,"pagination Arrows are disabled"
		 				+logger.addScreenCapture(captureScreenShot(driver,"pagination Arrows are disabled")));		
		
				action.sendKeys(Keys.PAGE_UP);
			} 
			
				
		} catch (Exception pagination) {
			
			
			try {
			if(homePage.NextpaginationButtonIsEnable.isDisplayed()) {
				
				
				logger.log(LogStatus.INFO," Next pagination Arrows is enabled"
		 				+logger.addScreenCapture(captureScreenShot(driver," Next pagination Arrows is enabled")));		
		 	
				
				homePage.clickNextpaginationButton();
				
				logger.log(LogStatus.PASS,"<b><font color='green'>Result: user clicked on next pagination button"
		 				+logger.addScreenCapture(captureScreenShot(driver,"user clicked on next pagination button")));		
		
				Thread.sleep(3000);
				homePage.clickPreviouspaginationButton();
				
				logger.log(LogStatus.PASS,"<b><font color='green'>Result: user clicked on Previous pagination Arrows"
		 				+logger.addScreenCapture(captureScreenShot(driver,"user clicked on Previous pagination Arrows")));		
		
				Thread.sleep(3000);
				Actions action=new Actions(driver);
				action.sendKeys(Keys.PAGE_UP);
					
			} 
				
			} catch (Exception next) {
				
		
				
				logger.log(LogStatus.FAIL,"<b><font color='red'>Result: user deosnt able to clicked on pagination arrows"
		 				+logger.addScreenCapture(captureScreenShot(driver,"user deosnt able to clicked on pagination arrows")));		
		
				
				
			}
			
				}
				

	}
	
	
	public void VerifyCreationAndDeletionButton( ) throws Throwable {
		 
	
	
		
		try {
			if(homePage.deleteButton.isDisplayed()) {
				
				helper.javaScriptHighlightWebElement(homePage.deleteButton);
				logger.log(LogStatus.PASS,"<b><font color='green'>Result: delete button is visible on HomePage"
		 				+logger.addScreenCapture(captureScreenShot(driver,"delete button is visible on HomePage")));		
		
			helper.javaScriptUn_HighlightWebElement(homePage.deleteButton);
				
				
			}
			if(homePage.createButton.isDisplayed()) {
				
				helper.javaScriptHighlightWebElement(homePage.createButton);
				logger.log(LogStatus.PASS,"<b><font color='green'>Result: create button is visible on HomePage"
		 				+logger.addScreenCapture(captureScreenShot(driver,"create button is visible on HomePage")));		
		
				helper.javaScriptUn_HighlightWebElement(homePage.createButton);
				
				
			}
			
		} catch (Exception creationDeletion) {
			
			logger.log(LogStatus.FAIL,"<b><font color='red'>Result: create & delete button are Not visible on HomePage"
	 				+logger.addScreenCapture(captureScreenShot(driver,"create & delete button are Not visible on HomePage")));		
	
			
		}
				
		
	}
		
	
	public void VerifyActionColumn( ) throws Throwable {
		 
	
	
		
		
		try {
			if(homePage.eyeIcon.isDisplayed()) {
				
				helper.javaScriptHighlightWebElement(homePage.eyeIcon);
				logger.log(LogStatus.PASS,"<b><font color='green'>Result: Ranking icon is visible on HomePage"
		 				+logger.addScreenCapture(captureScreenShot(driver,"Ranking icon is visible on HomePage")));		
		
				helper.javaScriptUn_HighlightWebElement(homePage.eyeIcon);
				
			}
			
			} catch (Exception eyeIcon) {
			
			logger.log(LogStatus.FAIL,"<b><font color='red'>Result: Ranking icon is missing"
	 				+logger.addScreenCapture(captureScreenShot(driver,"Ranking icon is missing")));	
			}
		
		try {
			
		
		
			if(homePage.euroIcon.isDisplayed()) {
				
				helper.javaScriptHighlightWebElement(homePage.euroIcon);
				logger.log(LogStatus.PASS,"<b><font color='green'>Result: Billing icon is visible on HomePage"
		 				+logger.addScreenCapture(captureScreenShot(driver,"Billing icon is visible on HomePage")));		
				
				helper.javaScriptUn_HighlightWebElement(homePage.euroIcon);
				
			}
		} catch (Exception euroIcon) {
			
			logger.log(LogStatus.FAIL,"<b><font color='red'>Result: euro Icon  is missing"
	 				+logger.addScreenCapture(captureScreenShot(driver,"euro icon is missing")));	
			}
		
		try {
			
			
			if(homePage.settingIcon.isDisplayed()) {
				
				helper.javaScriptHighlightWebElement(homePage.settingIcon);
				logger.log(LogStatus.PASS,"<b><font color='green'>Result: Setting icon is visible on HomePage"
		 				+logger.addScreenCapture(captureScreenShot(driver,"Setting icon is visible on HomePage")));	
				
				
				helper.javaScriptUn_HighlightWebElement(homePage.settingIcon);
			}
} catch (Exception settingIcon) {
			
			logger.log(LogStatus.FAIL,"<b><font color='red'>Result: setting Icon  is missing"
	 				+logger.addScreenCapture(captureScreenShot(driver,"setting icon is missing")));	
			}
			
			
			
		try {
			
			if(homePage.DeleteIcon.isDisplayed()) {
				
				helper.javaScriptHighlightWebElement(homePage.DeleteIcon);
				logger.log(LogStatus.PASS,"<b><font color='green'>Result: delete icon is visible on HomePage"
		 				+logger.addScreenCapture(captureScreenShot(driver,"delete icon is visible on HomePage")));	
		
				helper.javaScriptUn_HighlightWebElement(homePage.DeleteIcon);
				
			}
			
			
		} catch (Exception deleteicon) {
		
			logger.log(LogStatus.INFO,"<b><font color='Blue'>Result: delete icon is disabled as televente is not avaialable or televente in past or inprogress"
	 				+logger.addScreenCapture(captureScreenShot(driver,"delete icon is disabled as televente is not avaialable or televente in past or inprogress")));		
	
			
			
		}	
		
			
				
	
	}
	
	
	
}