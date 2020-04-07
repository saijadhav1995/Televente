package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;


import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.AppstringsConstant;
import webBase.BasePage;
import webBase.BaseTest;
import webBase.BrowserFactory;
import webElements_Identifiers.CreateForm;
import webElements_Identifiers.Home;

public class VerifyCreationPage extends BasePage 
{
	
	public ExtentTest logger;	
	public ExtentTest extentest;
	public SoftAssert SAssert = new SoftAssert();
	public PageFactory pf=new PageFactory();
	BrowserFactory Bf=new BrowserFactory();

	BaseTest baseT = new BaseTest();
	String className = "";
	CreateForm create=new CreateForm(driver);
	AppstringsConstant appConst =new AppstringsConstant(); 
	
	
	
	public void VerifyCreationButton(String TestName) throws Throwable 
	{
		 
		BasePage.Basepagedriver = BrowserFactory.startBrowser(appConst.select_Browser,appConst.URL);
		logger = baseT.extent.startTest(TestName);			
		create=	PageFactory.initElements(driver, CreateForm.class);
		createDirectory("TELEVENTE"+TestName);
		
		try {

			logger.log(LogStatus.PASS,"start application sucessfully"
					+logger.addScreenCapture(captureScreenShot(driver, "start application sucessfully")));		
					
			
			logger.log(LogStatus.INFO, "open chrome browser and start application");		
				
				driver.navigate().to(appConst.URL);
			 	create.link.click();
			 	create.username.sendKeys(appConst.Admin_SGID);
			 	create.password.sendKeys(appConst.Admin_password);
			 	create.submit.click();

		       create.CreateButton();
		       
		       logger.log(LogStatus.PASS,"user able to redirected on Creation Page"
						+logger.addScreenCapture(captureScreenShot(driver,"user able to redirected on Creation Page")));						           
		         	  		         			          
		}

		
			
		 catch (Exception e) {
			
			 logger.log(LogStatus.FAIL,"Getting Error To Open creation Page "
						+logger.addScreenCapture(captureScreenShot(driver,"Getting Error To Open creation Page ")));		
			 
		}
	}
	
	
public void VerifyRegionDropDown() throws Throwable {
	
	 create.Region(appConst.select_region_id);
     
     logger.log(LogStatus.PASS,"user able to select Region on Creation Page"
				+logger.addScreenCapture(captureScreenShot(driver,"user able to select Region on Creation Page")));			
	
}
	

public void VerifyTeleventeName() throws Throwable {
	
	
	
	create.userName("QA Automation"); 
     
     logger.log(LogStatus.PASS,"user able to enter Televent Name on Creation Page"
				+logger.addScreenCapture(captureScreenShot(driver,"user able to enter Televent Name on Creation Page")));
}



	public void VerifyStartDate() throws Throwable
	{
	     		 
	     		
	   	    	   
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date));	        	
			  
		        //get StartDate month
		     create.Stardate();
		     Thread.sleep(2000);
		              
		     try {
				
		    	 while(true) {
		
		    		 WebElement mon = driver.findElement(By.xpath(appConst.month_xpath)); 	
		 	        
				     String getStartmonth=mon.getText();
				     System.out.println(getStartmonth+" Start Month");
					 
		    		 	if(getStartmonth.equals(appConst.Start_month)) {
		        		 
		        		 driver.findElement(By.xpath(appConst.arrow_xpath)).click();
		        		 Thread.sleep(2000);
		        		 driver.findElement(By.xpath(appConst.Start_date_xpath)).click();
		        		
		        		 logger.log(LogStatus.PASS,"Start Date has been selected"
		 						+logger.addScreenCapture(captureScreenShot(driver,"Start Date has been selected")));
		        		 
		        		System.out.println("in loop");
		        		 
		        		break;
		        	
		        	 }else {
		        		 
		        		 driver.findElement(By.xpath(appConst.arrow_xpath)).click();
		        		 Thread.sleep(2000);		        			        		 
		        		 	 System.out.println("in else");
		        		 
		        		 
		        	 		}
	     
		    		 }
		    			 	        	 
		        	     	 
		  
		    	 
			} catch (Exception Startdate) {
				
				logger.log(LogStatus.FAIL,"Start Date does not able to selected"
 						+logger.addScreenCapture(captureScreenShot(driver,"Start Date does not able to selected")));		   		
    		 System.out.println("in else");
    		
				
			}
		     
			
			
			           
		}
	
	
	public void VerifyEndDate()  throws Throwable {
		
		String Endmonth=appConst.End_month;
          String date =appConst.End_date;
          
       //get end month date 
			 create.Enddate();
			 Thread.sleep(2000);
		   
		    	 
		    	
			     while(true) {
			    	 
			 
			    	 WebElement mon1 = driver.findElement(By.xpath(appConst.month_xpath));
					    
				     String getEndmonth=mon1.getText();
				     System.out.println(getEndmonth+"month");
				 
			    	 
			    	 	if(getEndmonth.equals(Endmonth)) {
		        		 
		        		 driver.findElement(By.xpath(appConst.arrow_xpath)).click();
		        		 Thread.sleep(2000);
		        		 driver.findElement(By.xpath(appConst.end_date_xpath)).click();
		        		 
		        		 logger.log(LogStatus.PASS,"End Date has been selected"
			 						+logger.addScreenCapture(captureScreenShot(driver,"Start Date has been selected")));		
		        		 
		        		 break; 		        		 
		  		       }
			    	 	else {
		        		 
		        		 driver.findElement(By.xpath(appConst.arrow_xpath)).click();
		        		 Thread.sleep(2000);
		        		 
		        	 }			    	 
			     }						
		}
	
	
	
		
	

public void VerifyDailyObjective ()  throws Throwable{
		
		
		
		try {
			
			 
			WebElement StartDate=driver.findElement(By.xpath("//*[@id='telev_start_date']"));
	       	 
	       	 String GetStartDate=StartDate.getAttribute("data-oldvalue");
	       	 
	       	 Thread.sleep(2000);
	       	 WebElement EndDate=driver.findElement(By.xpath("//*[@id='telev_end_date']"));
	       	 
	       	 String GetEndDate=EndDate.getAttribute("data-oldvalue");
	       	 
	       	 
	       	logger.log(LogStatus.INFO, "televenteStartDate"+GetStartDate+"and EndDate is "+GetStartDate); 
	       	 
	       	 System.out.println(GetStartDate);
	       	 System.out.println(GetEndDate);				        	 
	       	 	 
			
			create.DailyObjecitve();
			Thread.sleep(2000);
			logger.log(LogStatus.PASS,"Daily objective PopUp has been open"
					+logger.addScreenCapture(captureScreenShot(driver,"PopUp open")));	
		
			
		String selectDailyObjective ="//td[@data-date='"+GetStartDate+"']/span";	
		
		System.out.println("//td[@data-date='"+GetStartDate+"']/span");
			
		WebElement clickDate=driver.findElement(By.xpath(selectDailyObjective));
		
		
		
		clickDate.click();
		
		
		
		Thread.sleep(2000);
		
		create.enterDailyAmount.sendKeys(appConst.dailyAmount);
		
		logger.log(LogStatus.PASS,"Daily objective  has been entered"
				+logger.addScreenCapture(captureScreenShot(driver,"Daily objective  has been entered")));		
		
		Thread.sleep(2000);
		create.saveDailyAmount();
		create.SaveAmounts();
								
		} 		
		
				
		 catch (Exception objective) {
			logger.log(LogStatus.FAIL," getting error on DailyObjective "
					+logger.addScreenCapture(captureScreenShot(driver,"getting error on DailyObjective")));		
			}
		
		
		
	}



public void saveFunctionality() throws Throwable {
	
	create.SaveButton();
	
	try {

		while(true) {
			
			Thread.sleep(4000);	
			
			WebElement existingPeriod=create.anotherTeleventeAlreadyExist;
			
			String periodErrorLabel= existingPeriod.getText();
			System.out.println(periodErrorLabel);
		
			
			if(periodErrorLabel != null) {
				
					logger.log(LogStatus.INFO,"Televentes already exist"
						+logger.addScreenCapture(captureScreenShot(driver,"another Televente already exist")));		
			
			
			
				Thread.sleep(3000);
				create.Enddate();
				Thread.sleep(1000);
				driver.findElement(By.xpath(appConst.arrow_xpath)).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath(appConst.end_date_xpath)).click();
				Thread.sleep(1000);
				create.Stardate();
				Thread.sleep(1000);
				driver.findElement(By.xpath(appConst.arrow_xpath)).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath(appConst.Start_date_xpath)).click();
				Thread.sleep(2000);
				
				Alert alert = driver.switchTo().alert();
		        String alertText = alert.getText();
		        System.out.println("Alert data: " + alertText);
		        alert.accept();
				
				Thread.sleep(2000);
				 
				WebElement StartDate1=driver.findElement(By.xpath("//*[@id='telev_start_date']"));
		      	 
		      	 String GetStartDate1=StartDate1.getAttribute("data-oldvalue");
		      	 
		      	 WebElement EndDate1=driver.findElement(By.xpath("//*[@id='telev_end_date']"));
		      	 
		      	 String GetEndDate1=EndDate1.getAttribute("data-oldvalue");
		      	 
		      	 
		      	 System.out.println(GetStartDate1+"startDate");
		      	 System.out.println(GetEndDate1+"endDate");	
		      	 
		     	logger.log(LogStatus.INFO, "televenteStartDate"+GetStartDate1+"and EndDate is "+GetStartDate1); 
			       
		      	 create.DailyObjecitve();
				
				
		    	String selectDailyObjective ="//td[@data-date='"+GetStartDate1+"']/span";	
		    	
		    	System.out.println("//td[@data-date='"+GetStartDate1+"']/span");
		    		
		    	WebElement clickDate=driver.findElement(By.xpath(selectDailyObjective));
		    		    	
		    	clickDate.click();	
		    	Thread.sleep(2000);	
		    	create.enterDailyAmount.sendKeys(appConst.dailyAmount);	
		    	Thread.sleep(2000);
		    	create.saveDailyAmount();
		    	create.SaveAmounts();
		    	create.SaveButton();
				
		    	break;
			}		
			
		}
		
	} catch (Exception handleDate) {
		logger.log(LogStatus.PASS,"Televente Create Succefully"
				+logger.addScreenCapture(captureScreenShot(driver,"Televente Create Succefully")));		
	
	}
			
	
}





		

public void VerifyobjectiveField ()  throws Throwable{
	
	
	
	try {
		create.ObjectiveF(appConst.objectiveF);
		logger.log(LogStatus.PASS,"objective f has been entered by user"
					+logger.addScreenCapture(captureScreenShot(driver,"objective f has been entered by user")));		
	
		
	} catch (Exception objective) {
		logger.log(LogStatus.FAIL," getting error on objective f "
				+logger.addScreenCapture(captureScreenShot(driver,"getting error on objective f ")));		
		}
	
	
	
}





public void VerifyRankingAndBrandField()  throws Throwable{
	
	

	try {
		create.brand.click();
		
	 	List<WebElement> brands=driver.findElements(By.xpath("//div[@class='fs-dropdown']/div[2]/div[@data-value]"));
		
	 	for(int i=0;i<brands.size();i++) {
	 		
	 		WebElement brand=brands.get(i);
	 		
	 		
	 		String	brand_id=brand.getAttribute("data-value");
	 		
	 		
	 		brand.click();
	 		logger.log(LogStatus.INFO," Brand selected"+brand_id);
	 		
	 	}
	 	
	 	logger.log(LogStatus.PASS,"brands are selected"
				+logger.addScreenCapture(captureScreenShot(driver,"brands are selected")));	
	 	
		create.ranking.click();
		
		List<WebElement> rankings=driver.findElements(By.xpath("//div[@class='fs-dropdown']/div[2]/div[@data-value]"));
		
		for(int i=0;i<rankings.size();i++) {
	 		
	 		WebElement ranking=rankings.get(i);
	 		
	 		String	rankingId=ranking.getAttribute("data-value");
	 		
	 		logger.log(LogStatus.INFO,"Ranking id are"+rankingId);
	 		
	 		if(rankingId.equalsIgnoreCase("1")) {
	 			
	 			ranking.click();
	 		}
	 		
	 	}
		
		logger.log(LogStatus.PASS,"ranking deselected"
					+logger.addScreenCapture(captureScreenShot(driver,"ranking deselected")));		
	
		
	} catch (Exception objective) {
		logger.log(LogStatus.FAIL," getting error on ranking & branding Fields "
				+logger.addScreenCapture(captureScreenShot(driver,"getting error on ranking & branding Fields")));		
		}
	

	
}

	


	
// Edit Form	
	
	public void regionFieldOnEditForm() throws Throwable {
		
		 
		 
		 if(create.Region_dropDown.isEnabled()) {
			 
				 
		 create.Region(appConst.select_region_id);
			
		 logger.log(LogStatus.FAIL,"region Feild is enabled on Edit Page"
					+logger.addScreenCapture(captureScreenShot(driver,"region Feild is enabled on Edit Page")));			
		
		 
		 }else {
			 
			 logger.log(LogStatus.FAIL,"region Feild is Disabled on Edit Page"
						+logger.addScreenCapture(captureScreenShot(driver,"region Feild is enabled on Edit Page")));			
			 
		 }
	     
	    
	}

	
	
	
}




	
			         
				         



	        	
			
		         
		             
			  
	
		
				         
         					


