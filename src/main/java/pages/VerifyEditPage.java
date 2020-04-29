package pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.AppstringsConstant;
import Utility.Helper;
import webBase.BasePage;
import webBase.BaseTest;
import webElements_Identifiers.CreateForm;

public class VerifyEditPage extends BasePage{
	
	public ExtentTest logger;	
	public ExtentTest extentest;
	public SoftAssert SAssert = new SoftAssert();
	public PageFactory pf=new PageFactory();
	public Helper helper=new Helper();
	

	BaseTest baseT = new BaseTest();
	String className = "";
	CreateForm create=new CreateForm(driver);
	AppstringsConstant appConst =new AppstringsConstant(); 
	
	
	// Edit Form	
	
		public void regionFieldOnEditForm(String TestName) throws Throwable {
			
			try {
			logger = baseT.extent.startTest(TestName);			
			create=	PageFactory.initElements(driver, CreateForm.class);
			createDirectory("TELEVENTE"+TestName); 
			 
			
			 if(create.Region_dropDown.isEnabled()) {
				 
					 
			 create.Region(appConst.select_region_id);
				
			 System.out.println("region field is enabled");
			 
			 helper.javaScriptHighlightWebElement(create.Region_dropDown);
			 logger.log(LogStatus.FAIL,"1:clicked on Region Field"
					 +"<b><font color='red'>Result:region Feild is enabled on Edit Page"
						+logger.addScreenCapture(captureScreenShot(driver,"region Feild is enabled on Edit Page")));			
			helper.javaScriptUn_HighlightWebElement(create.Region_dropDown);
			 
			 }else {

				 helper.javaScriptHighlightWebElement(create.Region_dropDown);
				 logger.log(LogStatus.PASS,"1:clicked on Region Field"
						 +"<b><font color='green'>Result:region Feild is Disabled on Edit Page"
							+logger.addScreenCapture(captureScreenShot(driver,"region Feild is Disabled on Edit Page")));			
				 helper.javaScriptUn_HighlightWebElement(create.Region_dropDown);
					
				 
			 }
		     
				
			} catch (Exception e) {
		
				 logger.log(LogStatus.FAIL,"<b><font color='red'>Result:Error On  region Feild on Edit Page"
							+logger.addScreenCapture(captureScreenShot(driver,"Error On  region Feild on Edit Page")));			
			
			
			}
		    
		}
		
	public void VerifyNomFieldOnEditForm() {
		
		try {
			
		
		if(create.Nom.isEnabled()) {
			
			create.Nom.clear();
			create.TeleventeName("QA automation Edit");
			helper.javaScriptHighlightWebElement(create.Nom);
			 logger.log(LogStatus.PASS,"<b><font color='green'>Result:Nom Feild is enabled on Edit Page"
						+logger.addScreenCapture(captureScreenShot(driver,"Nom Feild is enabled on Edit Page")));			
			 
			helper.javaScriptUn_HighlightWebElement(create.Nom);
			 
		}else {
			 
			 logger.log(LogStatus.FAIL,"<b><font color='red'>Result:Nom Feild is Disabled on Edit Page"
						+logger.addScreenCapture(captureScreenShot(driver,"Nom Feild is Disabled on Edit Page")));			
			 
		 }
	      
		} catch (Exception e) {
		
			 logger.log(LogStatus.FAIL,"<b><font color='red'>Result:Error  on Edit Page"
						+logger.addScreenCapture(captureScreenShot(driver,"Nom Feild is Disabled on Edit Page")));			
		
		
		}			
	}
	
public void VerifyStartDateOnEditForm() {
		
		try {
			
		
		if(create.StartDate.isEnabled()) {
			
			System.out.println("startdate is enabled");
			
			helper.javaScriptHighlightWebElement(create.StartDate);
			 logger.log(LogStatus.PASS,"<b><font color='green'>Result:startdate is enabled on Edit Page"
						+logger.addScreenCapture(captureScreenShot(driver,"startdate is enabled on Edit Page")));			
			
				helper.javaScriptUn_HighlightWebElement(create.StartDate);			
		}else {
			 
			 logger.log(LogStatus.FAIL,"<b><font color='red'>Result:startdate is  Disabled on Edit Page"
						+logger.addScreenCapture(captureScreenShot(driver,"startdate is enabled on Edit Page")));			
			
		   }
		} catch (Exception e) {
			 logger.log(LogStatus.FAIL,"<b><font color='red'>Result:Error On startdate on Edit Page"
						+logger.addScreenCapture(captureScreenShot(driver,"startdate is enabled on Edit Page")));			
				}
	}

public void VerifyEndDateOnEditForm() {
	
	try {
		
		if(create.EndDate.isEnabled()) {
		
		System.out.println("Enddate is enabled");
		
helper.javaScriptHighlightWebElement(create.EndDate);
		 logger.log(LogStatus.PASS,"<b><font color='green'>Result:Enddate is enabled on Edit Page"
					+logger.addScreenCapture(captureScreenShot(driver,"Enddate is enabled on Edit Page")));			
		
		 helper.javaScriptUn_HighlightWebElement(create.EndDate);
		
	}else {
		 
		 logger.log(LogStatus.FAIL,"<b><font color='red'>Result:Enddate is  Disabled on Edit Page"
					+logger.addScreenCapture(captureScreenShot(driver,"Enddate is enabled on Edit Page")));			
		 
	 }

	} catch (Exception e) {

		 logger.log(LogStatus.FAIL,"<b><font color='red'>Result:Error On Enddate on Edit Page"
					+logger.addScreenCapture(captureScreenShot(driver,"Enddate is enabled on Edit Page")));			

	}
	

}

public void VerifyObjectiveFOnEditForm() {
	
	try {
		

	if(create.Objectivef.isEnabled()) {
		
		System.out.println("ObjectiveF field is enabled");
		
		create.Objectivef.clear();
		create.ObjectiveF("121");
		
		helper.javaScriptHighlightWebElement(create.Objectivef);
		logger.log(LogStatus.PASS," <b><font color='green'>Result:ObjectiveF field is enabled on Edit Page"
				+logger.addScreenCapture(captureScreenShot(driver," ObjectiveF field is enabled on Edit Page")));
		helper.javaScriptUn_HighlightWebElement(create.Objectivef);
		
	}else {
		 
		 logger.log(LogStatus.FAIL," <b><font color='red'>Result:ObjectiveF field is Disabled on Edit Page"
					+logger.addScreenCapture(captureScreenShot(driver,"Daily Objectivef field is on Edit Page")));			
		 
	 }

	} catch (Exception e) {
		 logger.log(LogStatus.FAIL,"<b><font color='red'>Result: ObjectiveF field is Disabled on Edit Page"
					+logger.addScreenCapture(captureScreenShot(driver,"Daily Objectivef field is on Edit Page")));			
		 
		}
	
}

public void VerifyDailyAmountOnEditForm() {
	
	try {
		
	
	
	if(create.DailyObjectivefAmount.isEnabled()) {
		
		System.out.println("Daily Objective field is enabled");
		
		helper.javaScriptHighlightWebElement(create.DailyObjectivefAmount);
		logger.log(LogStatus.PASS,"<b><font color='green'>Result:Daily Objective field is enabled on Edit Page"
				+logger.addScreenCapture(captureScreenShot(driver,"Daily Objective field is enabled on Edit Page")));
		
		helper.javaScriptUn_HighlightWebElement(create.DailyObjectivefAmount);

		
	}else {
		 
		 logger.log(LogStatus.FAIL,"<b><font color='red'>Result:Nom Feild is Disabled on Edit Page"
					+logger.addScreenCapture(captureScreenShot(driver,"Daily Objective field is Disabled on Edit Page")));			
		 
	 }

	} catch (Exception e) {
		 logger.log(LogStatus.FAIL,"<b><font color='red'>Result:Error On Nom Feild  on Edit Page"
					+logger.addScreenCapture(captureScreenShot(driver,"Daily Objective field is Disabled on Edit Page")));			
			}
	
}


public void VerifyRankingFieldOnEditForm() {
	
	
	try {
		
		if(create.EditRankingField.isEnabled()) {
		
		System.out.println("ranking field is enabled");
		helper.javaScriptHighlightWebElement(create.EditRankingField);
		 logger.log(LogStatus.PASS,"<b><font color='green'>Result: Ranking field is enabled on Edit Page"
					+logger.addScreenCapture(captureScreenShot(driver,"Ranking field is enabled on Edit Page")));			

helper.javaScriptUn_HighlightWebElement(create.EditRankingField);
		
	}else {
		 
		 logger.log(LogStatus.FAIL,"<b><font color='red'>Result:Ranking field is disabled on Edit Page"
					+logger.addScreenCapture(captureScreenShot(driver,"Ranking field is Disabled on Edit Page")));			
		 
	 }
	} catch (Exception e) {
		 logger.log(LogStatus.FAIL,"<b><font color='red'>Result:Error On Ranking field  on Edit Page"
					+logger.addScreenCapture(captureScreenShot(driver,"Ranking field is Disabled on Edit Page")));			
		}
	


}



public void VerifyBrandFieldOnEditForm() {
	
	try {
		
	
	if(create.EditBrandField.isEnabled()) {
		
		System.out.println("brand field is enabled");
		create.EditBrandField.click();
		helper.javaScriptHighlightWebElement(create.EditBrandField);
		 logger.log(LogStatus.PASS,"<b><font color='green'>Result:brand field is enabled on Edit Page"
					+logger.addScreenCapture(captureScreenShot(driver,"brand field is enabled on Edit Page")));			
		helper.javaScriptUn_HighlightWebElement(create.EditBrandField);
		
	}else {
		 
		 logger.log(LogStatus.FAIL,"<b><font color='red'>Result:Brand Feild is Disabled on Edit Page"
					+logger.addScreenCapture(captureScreenShot(driver,"Brand Feild is Disabled on Edit Page")));			
		 
	 }

	} catch (Exception e) {
		 logger.log(LogStatus.FAIL,"<b><font color='red'>Result:Error On Nom Feild  on Edit Page"
					+logger.addScreenCapture(captureScreenShot(driver,"Brand Feild is Disabled on Edit Page")));			
		}

}

public void clickOnSaveButton() {
	
	create.SaveButton();
}



}
