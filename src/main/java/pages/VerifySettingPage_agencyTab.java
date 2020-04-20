package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.AppstringsConstant;
import Utility.RankingRelatedQueries;
import webBase.BasePage;
import webBase.BaseTest;
import webElements_Identifiers.CreateForm;
import webElements_Identifiers.SettingTabs;

public class VerifySettingPage_agencyTab extends BasePage {

	public ExtentTest logger;	
	public ExtentTest extentest;
	public SoftAssert SAssert = new SoftAssert();
	public PageFactory pf=new PageFactory();
	

	BaseTest baseT = new BaseTest();
	String className = "";
	SettingTabs setting=new SettingTabs(driver);
	AppstringsConstant appConst =new AppstringsConstant(); 
	RankingRelatedQueries settingtabsData=new RankingRelatedQueries();
	
	

	public void AgencyTab(String TestName) throws Throwable {
		
		logger = baseT.extent.startTest(TestName);		
		setting=	PageFactory.initElements(driver, SettingTabs.class);
		createDirectory("TELEVENTE"+TestName); 
		
		
	try {
		
		Thread.sleep(6000);
		
		setting.getSettingButton().click();	
		
		Thread.sleep(4000);

		logger.log(LogStatus.PASS,"1: open manage setting page" + "<br/>" + "2 : go to the agency tab" + "<br/>"
				+logger.addScreenCapture(captureScreenShot(driver,"user redirected on agency tab in manage setting page")));						           
	
	
		
	setting.btn_expandAll.click();


	logger.log(LogStatus.INFO,"agency tree view has been expanded"
			+logger.addScreenCapture(captureScreenShot(driver,"agency tree view has been expand")));						           


	
	//getallsectors	
	logger.log(LogStatus.INFO,"sectors are");
		for (WebElement webElement : setting.getAllSectors) {
		String sectorslabel=webElement.getText();

		System.out.println(sectorslabel);
		
		logger.log(LogStatus.INFO,"<b>"+sectorslabel+"<b>");
		
		}
		

		//getAllsitesofselectedSector	
		logger.log(LogStatus.INFO,"sites of selected sector are");
				for (WebElement webElement1 : setting.getAllSites) {
					String siteslabel=webElement1.getText();

					System.out.println(siteslabel+" sites");
					logger.log(LogStatus.INFO,"<b>"+siteslabel+"<b>");
					}

		//getAllagenciesofselectedSite	
			
				logger.log(LogStatus.INFO,"agencies of selected site");
							
		           for (WebElement webElement2 : setting.getAllAgency) {
					String agencieslabel=webElement2.getText();
					logger.log(LogStatus.INFO,"<b>"+agencieslabel+"<b>");
					System.out.println(agencieslabel+"agencies");
					}
				
	
		
		
	//gettotaldailyobjective
		
	String totalDailyobjective=setting.Total_DailyObjective.getText();
		
	System.out.println(totalDailyobjective+"dailyObjective");
	
	logger.log(LogStatus.PASS,"Total Daily Objective amount is "+"<b>"+totalDailyobjective+"<b>"
			+logger.addScreenCapture(captureScreenShot(driver,"Total Daily Objective amount is displayed")));						           

		
	setting.btn_collapseAll.click();

	logger.log(LogStatus.PASS,"Tree view has successfully collapsed"
			+logger.addScreenCapture(captureScreenShot(driver,"Tree view has successfully collapse")));						           

	
	//clickonexpandcollapsecheckBox
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", setting.clickOnExpandCollapseButtonOfSector);
		System.out.println("clickedoncollapse button");


		logger.log(LogStatus.PASS,"user able to expand Tree view by selecting sector"
				+logger.addScreenCapture(captureScreenShot(driver,"user able to expand Tree view by selecting sector")));						           

		
	//clickoncheckBox	
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;	
		executor1.executeScript("arguments[0].click();", setting.clickOncheckBoxButtonOfSector);
		System.out.println("checkBox button");

		logger.log(LogStatus.PASS,"on Tree view user able to clicked on check Box"
				+logger.addScreenCapture(captureScreenShot(driver,"on Tree view user able to clicked on check Box")));						           

		
	//entersectoramount	
		setting.clickOnSectorAmountfieldOfSector.sendKeys(settingtabsData.Sector_amount);
		System.out.println("amountfield button");

		logger.log(LogStatus.PASS,"on Tree view user able to enter sector amount"
				+logger.addScreenCapture(captureScreenShot(driver,"on Tree view user able to enter sector amount")));						           

		
		
	//entersiteamount
		setting.clickOnSectorAmountfieldOfSite.sendKeys(settingtabsData.Site_amount);
		System.out.println("amountfield button");

		logger.log(LogStatus.PASS,"on Tree view user able to enter site amount"
				+logger.addScreenCapture(captureScreenShot(driver,"on Tree view user able to enter site amount")));						           
		
		
		
String totalDaily[]	=totalDailyobjective.split(",");
		
String objectiveamount=totalDaily[0];

System.out.println(objectiveamount);


int newobjectiveamount= Integer.parseInt(objectiveamount);
int newsectorAmount=Integer.parseInt(settingtabsData.Sector_amount);
int newSiteAmount=Integer.parseInt(settingtabsData.Site_amount);





if(newsectorAmount<newSiteAmount) {
	
	
setting.SaveButton.click();	
Thread.sleep(2000);
String alertMessage=setting.agencies_data_alert_message.getText();
System.out.println(alertMessage+"SectorAmountIsGreaterThanTotalAmount");

logger.log(LogStatus.PASS,"1:verifying"+alertMessage+"<br/>"+
"2:if site amount is greater than sector amount then total objective amount will inserted in sector & site fields"
		+logger.addScreenCapture(captureScreenShot(driver,"site amount greater than sector amount")));						           


setting.clickOnSectorAmountfieldOfSite.clear();
setting.clickOnSectorAmountfieldOfSite.sendKeys(objectiveamount);
setting.clickOnSectorAmountfieldOfSector.clear();
setting.clickOnSectorAmountfieldOfSector.sendKeys(objectiveamount);

System.out.println(newsectorAmount+"test"+newSiteAmount);


}else {
	
	System.out.println("sector amount Is less than site amount");
}





if(newobjectiveamount<newsectorAmount) {
	
		
setting.SaveButton.click();	

Thread.sleep(2000);

WebElement Alertmessage= driver.findElement(By.xpath("//*[@id='agencies_data_alert_message']/div/strong"));
String getAlertMessage=Alertmessage.getText();

logger.log(LogStatus.PASS,"1:verifying"+getAlertMessage+"<br/>"+
"2:if site amount is greater than sector amount then total objective amount will inserted in sector & site fields"
		+logger.addScreenCapture(captureScreenShot(driver,"sector amount greater than total objective amount")));						           


setting.clickOnSectorAmountfieldOfSector.clear();
setting.clickOnSectorAmountfieldOfSector.sendKeys(objectiveamount);
System.out.println(getAlertMessage);
System.out.println(newobjectiveamount+"test"+newsectorAmount);
	

}else {
	
	System.out.println("sector amount is less than total objective amount");
}


setting.SaveButton.click();
Thread.sleep(4000);

WebElement Alertmessage1= driver.findElement(By.xpath("//*[@id='agencies_data_alert_message']/div/strong"));
String getAlertMessage1=Alertmessage1.getText();

System.out.println(getAlertMessage1);

logger.log(LogStatus.PASS,"1:site & sector amount successfully saved success message is "+"</br>"+getAlertMessage1
		+logger.addScreenCapture(captureScreenShot(driver,"site & sector amount succefully saved")));						           


	} catch (Exception e) {
		
		e.printStackTrace();

		logger.log(LogStatus.FAIL,"getting error while inserting site & sector amount on agency tab"
		+logger.addScreenCapture(captureScreenShot(driver,"getting error while inserting site & sector amount on agency tab")));						           

		
		
			}	
	

	}
	
	
			
	
}
