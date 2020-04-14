package pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.AppstringsConstant;
import webBase.BasePage;
import webBase.BaseTest;
import webElements_Identifiers.CreateForm;

public class VerifyEditPage extends BasePage{
	
	public ExtentTest logger;	
	public ExtentTest extentest;
	public SoftAssert SAssert = new SoftAssert();
	public PageFactory pf=new PageFactory();
	

	BaseTest baseT = new BaseTest();
	String className = "";
	CreateForm create=new CreateForm(driver);
	AppstringsConstant appConst =new AppstringsConstant(); 
	
	
	// Edit Form	
	
		public void regionFieldOnEditForm(String TestName) throws Throwable {
			
			logger = baseT.extent.startTest(TestName);			
			create=	PageFactory.initElements(driver, CreateForm.class);
			createDirectory("TELEVENTE"+TestName); 
			 
			
			 if(create.Region_dropDown.isEnabled()) {
				 
					 
			 create.Region(appConst.select_region_id);
				
			 System.out.println("region field is enabled");
			 logger.log(LogStatus.FAIL,"region Feild is enabled on Edit Page"
						+logger.addScreenCapture(captureScreenShot(driver,"region Feild is enabled on Edit Page")));			
			
			 
			 }else {
				 
				 logger.log(LogStatus.PASS,"region Feild is Disabled on Edit Page"
							+logger.addScreenCapture(captureScreenShot(driver,"region Feild is Disabled on Edit Page")));			
				 
			 }
		     
		    
		}
		
	public void VerifyNomFieldOnEditForm() {
		
		
		if(create.Nom.isEnabled()) {
			
			create.Nom.clear();
			create.TeleventeName("QA automation Edit");
			 logger.log(LogStatus.PASS,"Nom Feild is enabled on Edit Page"
						+logger.addScreenCapture(captureScreenShot(driver,"Nom Feild is enabled on Edit Page")));			
			 
			
		}else {
			 
			 logger.log(LogStatus.FAIL,"Nom Feild is Disabled on Edit Page"
						+logger.addScreenCapture(captureScreenShot(driver,"Nom Feild is Disabled on Edit Page")));			
			 
		 }
	      
					
	}
	
public void VerifyStartDateOnEditForm() {
		
		
		if(create.StartDate.isEnabled()) {
			
			System.out.println("startdate is enabled");
			 logger.log(LogStatus.PASS,"startdate is enabled on Edit Page"
						+logger.addScreenCapture(captureScreenShot(driver,"startdate is enabled on Edit Page")));			
			
			
		}else {
			 
			 logger.log(LogStatus.FAIL,"startdate is  Disabled on Edit Page"
						+logger.addScreenCapture(captureScreenShot(driver,"startdate is enabled on Edit Page")));			
			
		 }

	}

public void VerifyEndDateOnEditForm() {
	
	
	if(create.EndDate.isEnabled()) {
		
		System.out.println("Enddate is enabled");
		

		 logger.log(LogStatus.PASS,"Enddate is enabled on Edit Page"
					+logger.addScreenCapture(captureScreenShot(driver,"Enddate is enabled on Edit Page")));			
		
		
	}else {
		 
		 logger.log(LogStatus.FAIL,"Enddate is  Disabled on Edit Page"
					+logger.addScreenCapture(captureScreenShot(driver,"Enddate is enabled on Edit Page")));			
		 
	 }

}

public void VerifyObjectiveFOnEditForm() {
	
	
	if(create.Objectivef.isEnabled()) {
		
		System.out.println("ObjectiveF field is enabled");
		
		create.Objectivef.clear();
		create.ObjectiveF("121");
		
		logger.log(LogStatus.PASS," ObjectiveF field is enabled on Edit Page"
				+logger.addScreenCapture(captureScreenShot(driver," ObjectiveF field is enabled on Edit Page")));
		
		
	}else {
		 
		 logger.log(LogStatus.FAIL," ObjectiveF field is Disabled on Edit Page"
					+logger.addScreenCapture(captureScreenShot(driver,"Daily Objectivef field is on Edit Page")));			
		 
	 }

}

public void VerifyDailyAmountOnEditForm() {
	
	
	if(create.DailyObjectivefAmount.isEnabled()) {
		
		System.out.println("Daily Objective field is enabled");
		
		logger.log(LogStatus.PASS,"Daily Objective field is enabled on Edit Page"
				+logger.addScreenCapture(captureScreenShot(driver,"Daily Objective field is enabled on Edit Page")));
		

		
	}else {
		 
		 logger.log(LogStatus.FAIL,"Nom Feild is Disabled on Edit Page"
					+logger.addScreenCapture(captureScreenShot(driver,"Daily Objective field is Disabled on Edit Page")));			
		 
	 }

}


public void VerifyRankingFieldOnEditForm() {
	
	
	if(create.EditRankingField.isEnabled()) {
		
		System.out.println("ranking field is enabled");
		 logger.log(LogStatus.PASS,"brand field is enabled on Edit Page"
					+logger.addScreenCapture(captureScreenShot(driver,"brand field is enabled on Edit Page")));			


		
	}else {
		 
		 logger.log(LogStatus.FAIL,"brand field is disabled on Edit Page"
					+logger.addScreenCapture(captureScreenShot(driver,"brand field is Disabled on Edit Page")));			
		 
	 }

}



public void VerifyBrandFieldOnEditForm() {
	
	
	if(create.EditBrandField.isEnabled()) {
		
		System.out.println("brand field is enabled");
		create.EditBrandField.click();
		 logger.log(LogStatus.PASS,"brand field is enabled on Edit Page"
					+logger.addScreenCapture(captureScreenShot(driver,"brand field is enabled on Edit Page")));			
		
		
	}else {
		 
		 logger.log(LogStatus.FAIL,"Nom Feild is Disabled on Edit Page"
					+logger.addScreenCapture(captureScreenShot(driver,"region Feild is Disabled on Edit Page")));			
		 
	 }

}

public void clickOnSaveButton() {
	
	create.SaveButton();
}



}
