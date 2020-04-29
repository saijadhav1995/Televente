package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import Utility.Helper;
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
	public Helper helper=new Helper();

	BaseTest baseT = new BaseTest();
	String className = "";
	CreateForm create=new CreateForm(driver);
	AppstringsConstant appConst =new AppstringsConstant(); 
	
	
	
	
		
	public void clickOnCreationButton(String TestName) throws Throwable 
	{
		 
		logger = baseT.extent.startTest(TestName);			
		create=	PageFactory.initElements(driver, CreateForm.class);
		createDirectory("TELEVENTE"+TestName);

			//create.Connection_button.click();
		
		try {

			if(create.createButton.isDisplayed()) {
				
				create.CreateButton();
			       
			       logger.log(LogStatus.PASS,"1:clicked on Create Button"+"<br/>"
			    		   +"<b><font color='green'>Result:user Redirected to Creation Page successfully <font/>"
							+logger.addScreenCapture(captureScreenShot(driver,"user able to redirected on Creation Page")));						           
				
			}
		               	  		         			          
		}

		
			
		 catch (Exception e) {
			
			 logger.log(LogStatus.FAIL,"<b><font color='red'>Result:user Redirected to Creation Page successfully <font/>"
						+logger.addScreenCapture(captureScreenShot(driver,"Getting Error To Open creation Page ")));		
			 
		}
	}
	
	
public void VerifyRegionDropDown() throws Throwable {
	
	
	try {
		
	 create.Region(appConst.select_region_id);
     
     logger.log(LogStatus.PASS,"1:clicked on Region Field"+"<br/>"
    		 +"<b><font color='green'>Result:user able to select Region on Creation Page <font/>"
				+logger.addScreenCapture(captureScreenShot(driver,"user able to select Region on Creation Page")));			
	
	} catch (Exception e) {
	
		 logger.log(LogStatus.FAIL,"<b><font color='red'>Result:user Does not able to select Region on Creation Page<font/>"
					+logger.addScreenCapture(captureScreenShot(driver,"user able to select Region on Creation Page")));			
		
	}
	
     
}
	

public void VerifyTeleventeName() throws Throwable {
	
	
	try {
		
	
	create.TeleventeName("QA Automation"); 
     
     logger.log(LogStatus.PASS,"<b><font color='green'>Result:user able to enter Televent Name on Creation Page"
				+logger.addScreenCapture(captureScreenShot(driver,"user able to enter Televent Name on Creation Page")));

	
	} catch (Exception e) {
	
		 logger.log(LogStatus.FAIL,"<b><font color='red'>Result:user does not able to enter Televent Name on Creation Page"
					+logger.addScreenCapture(captureScreenShot(driver,"user able to enter Televent Name on Creation Page")));

	
	}
	
	
	}



	public void VerifyStartDate() throws Throwable
	{
	     		 
	     		
		 try {
	   
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date));	        	
			  
		        //get StartDate month
		     create.Stardate();
		     Thread.sleep(2000);
		              
		    				
		    	 while(true) {
		
		    		 WebElement mon = driver.findElement(By.xpath(appConst.month_xpath)); 	
		 	        
				     String getStartmonth=mon.getText();
				     System.out.println(getStartmonth+" Start Month");
					 
		    		 	if(getStartmonth.equals(appConst.Start_month)) {
		        		 
		        		 driver.findElement(By.xpath(appConst.arrow_xpath)).click();
		        		 Thread.sleep(2000);
		        		 driver.findElement(By.xpath(appConst.Start_date_xpath)).click();
		        		
		        		 logger.log(LogStatus.PASS,"<b><font color='green'>Result:Start Date has been selected"
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
				
				logger.log(LogStatus.FAIL,"<b><font color='red'>Result:Start Date does not able to selected"
 						+logger.addScreenCapture(captureScreenShot(driver,"Start Date does not able to selected")));		   		
    		 System.out.println("in else");
    		
				
			}
		     
			
			
			           
		}
	
	
	public void VerifyEndDate()  throws Throwable {
		
		try {
			
		
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
		        		 
		        		 logger.log(LogStatus.PASS,"<b><font color='green'>Result:End Date has been selected"
			 						+logger.addScreenCapture(captureScreenShot(driver,"Start Date has been selected")));		
		        		 
		        		 break; 		        		 
		  		       }
			    	 	else {
		        		 
		        		 driver.findElement(By.xpath(appConst.arrow_xpath)).click();
		        		 Thread.sleep(2000);
		        		 
		        	 }			    	 
			     }
			     
		} catch (Exception e) {
	   		 logger.log(LogStatus.FAIL,"<b><font color='red'>Result:Error on End date"
						+logger.addScreenCapture(captureScreenShot(driver,"Start Date has been selected")));		
	}
	 
		}
	
	
	
		
	

public void VerifyDailyObjective ()  throws Throwable{
		
		
		
		try {
			
			 
			WebElement StartDate=driver.findElement(By.xpath("//*[@id='telev_start_date']"));
	       	 
	       	 String GetStartDate=StartDate.getAttribute("data-oldvalue");
	       	 
	       	 Thread.sleep(2000);
	       	 WebElement EndDate=driver.findElement(By.xpath("//*[@id='telev_end_date']"));
	       	 
	       	 String GetEndDate=EndDate.getAttribute("data-oldvalue");
	       	 
	       	 
	       	logger.log(LogStatus.INFO, "televenteStartDate"+"<b>"+GetStartDate+"</b>"+"and EndDate is "+"<b>"+GetEndDate+"</b>"); 
	       	 
	       	 System.out.println(GetStartDate);
	       	 System.out.println(GetEndDate);				        	 
	       	 	 
			
			create.DailyObjecitve();
			Thread.sleep(2000);
			logger.log(LogStatus.PASS,"<b><font color='green'>Result:Daily objective PopUp has been open"
					+logger.addScreenCapture(captureScreenShot(driver,"PopUp open")));	
		
			
		String selectDailyObjective ="//td[@data-date='"+GetStartDate+"']/span";	
		
		System.out.println("//td[@data-date='"+GetStartDate+"']/span");
			
		WebElement clickDate=driver.findElement(By.xpath(selectDailyObjective));
		
		
		
		clickDate.click();
		
		
		
		Thread.sleep(2000);
		
		create.enterDailyAmount.sendKeys(appConst.dailyAmount);
		
		logger.log(LogStatus.PASS,"<b><font color='green'>Result:Daily objective  has been entered"
				+logger.addScreenCapture(captureScreenShot(driver,"Daily objective  has been entered")));		
		
		Thread.sleep(2000);
		create.saveDailyAmount();
		create.SaveAmounts();
								
		} 		
		
				
		 catch (Exception objective) {
			logger.log(LogStatus.FAIL,"<b><font color='red'>Result: getting error on DailyObjective "
					+logger.addScreenCapture(captureScreenShot(driver,"getting error on DailyObjective")));		
			}
		
		
		
	}



public void saveFunctionality() throws Throwable {
	
	
	
	try {
		
		create.SaveButton();
		
		while(true) {
			
	Thread.sleep(4000);	
				
	WebElement anotherTeleventeAlreadyExist	=driver.findElement(By.xpath("//*[@class='alert alert-danger']"));
			
			if(anotherTeleventeAlreadyExist.isDisplayed()) {
				
					logger.log(LogStatus.INFO,"<b><font color='blue'>Result:Televentes already exist"
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
				
		    	logger.log(LogStatus.PASS, "<b><font color='green'>Result:televente already Exist from period StartDate "+GetStartDate1+"and EndDate is "+GetEndDate1+" "
		    +logger.addScreenCapture(captureScreenShot(driver,"televente created successfully")));
			}		
			
		}
		
	} catch (org.openqa.selenium.NoSuchElementException handledates) {
		
	
		logger.log(LogStatus.PASS,"<b><font color='green'>Result:televente created successfully"
				+logger.addScreenCapture(captureScreenShot(driver,"televente created successfully")));		

		
	}

			
	
}





		

public void VerifyobjectiveField ()  throws Throwable{
	
	
	
	try {
		create.ObjectiveF(appConst.objectiveF);
		logger.log(LogStatus.PASS,"<b><font color='green'>Result:objective f has been entered by user"
					+logger.addScreenCapture(captureScreenShot(driver,"objective f has been entered by user")));		
	
		
	} catch (Exception objective) {
		logger.log(LogStatus.FAIL,"<b><font color='red'>Result: getting error on objective f "
				+logger.addScreenCapture(captureScreenShot(driver,"getting error on objective f ")));		
		}
	
	
	
}





public void VerifyRankingAndBrandField()  throws Throwable{
	
	

	try {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		create.brand.click();
		
	 	List<WebElement> brands=driver.findElements(By.xpath("//div[@class='fs-dropdown']/div[2]/div[@data-value]/div"));
		
	 	for(int i=0;i<brands.size();i++) {
	 		
	 		WebElement brand=brands.get(i);
	 		
	 		
	 		//String	brand_id=brand.getAttribute("data-value");
	 		
	 		String castSythesisTabs = (String) js.executeScript("return arguments[0].innerText;",brand);

	 		
	 		brand.click();
	 		logger.log(LogStatus.PASS,"<font color='green'>Result:Selected Brands are<font/> "+"<b>"+castSythesisTabs);
	 		
	 	}
	 	

				logger.addScreenCapture(captureScreenShot(driver,"brands are selected"));	
	 	
		create.ranking.click();
		
		List<WebElement> rankings=driver.findElements(By.xpath("//div[@class='fs-dropdown']/div[2]/div[@data-value]/div"));
		
		for(int i=0;i<rankings.size();i++) {
	 		
	 		WebElement ranking=rankings.get(i);
	 		
	 		
	 		String castSythesisTabs = (String) js.executeScript("return arguments[0].innerText;",ranking);

	 		logger.log(LogStatus.PASS,"<font color='green'>Result: Rankings are "+"<b>"+castSythesisTabs);
	 		
	 		if(castSythesisTabs.equalsIgnoreCase("Par Site")) {
	 			
	 			ranking.click();
	 		}
	 		
	 	}
		
		logger.log(LogStatus.PASS,"<b><font color='green'>Result:ranking deselected"
					+logger.addScreenCapture(captureScreenShot(driver,"ranking deselected")));		
	
		
	} catch (Exception objective) {
		logger.log(LogStatus.FAIL,"<b><font color='red'>Result: getting error on ranking & branding Fields "
				+logger.addScreenCapture(captureScreenShot(driver,"getting error on ranking & branding Fields")));		
		}
	

	
}

	


	

	
	
	
}




	
			         
				         



	        	
			
		         
		             
			  
	
		
				         
         					


