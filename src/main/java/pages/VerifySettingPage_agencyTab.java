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
import Utility.SettingTabsData;
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
	SettingTabsData settingtabsData=new SettingTabsData();
	
	

	public void AgencyTab(String TestName) throws Throwable {
		
				
		setting=	PageFactory.initElements(driver, SettingTabs.class);
		createDirectory("TELEVENTE"+TestName); 
		
		
		driver.navigate().to("https://televente.mutlp.test.pointp.saint-gobain.net"
				+ "/editTelevente/eyJpdiI6IjBySngxTnM3RVZQQUN3UzF6aUV2UUE9PSIsInZhbHVlIjoiM3czYkFQR2lMaXVrY2lzajREWkpqQT09Ii"
				+ "wibWFjIjoiMzMzMDMyMzE5YmIxMjZjNzNlZGMwMGZjODA1NTYyYzBjMjc4ODI5OWQ4OTNhY2VlYTdkYjYyZjdmNGVmYzQ0YyJ9");
		
		setting.getSettingButton().click();
		
		
		Thread.sleep(4000);

	setting.btn_expandAll.click();

	//getallsectors	
		for (WebElement webElement : setting.getAllSectors) {
		String sectorslabel=webElement.getText();

		System.out.println(sectorslabel);
		}
		

		//getAllsitesofselectedSector	
				for (WebElement webElement1 : setting.getAllSites) {
					String siteslabel=webElement1.getText();

					System.out.println(siteslabel+" sites");
					}

		//getAllagenciesofselectedSite	
			
				
		           for (WebElement webElement2 : setting.getAllAgency) {
					String agencieslabel=webElement2.getText();

					System.out.println(agencieslabel+"agencies");
					}
				
	
		
		
	//gettotaldailyobjective
		
	String totalDailyobjective=setting.Total_DailyObjective.getText();
		
	System.out.println(totalDailyobjective+"dailyObjective");
	
		
	setting.btn_collapseAll.click();

	
	
	//clickonexpandcollapsecheckBox
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", setting.clickOnExpandCollapseButtonOfSector);
		System.out.println("clickedoncollapse button");
		
	//clickoncheckBox	
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;	
		executor1.executeScript("arguments[0].click();", setting.clickOncheckBoxButtonOfSector);
		System.out.println("checkBox button");
		
	//entersectoramount	
		setting.clickOnSectorAmountfieldOfSector.sendKeys(settingtabsData.Sector_amount);
		System.out.println("amountfield button");
		
	//entersiteamount
		setting.clickOnSectorAmountfieldOfSite.sendKeys(settingtabsData.Site_amount);
		System.out.println("amountfield button");
		
		
		
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

setting.clickOnSectorAmountfieldOfSite.clear();
setting.clickOnSectorAmountfieldOfSite.sendKeys(objectiveamount);
setting.clickOnSectorAmountfieldOfSector.clear();
setting.clickOnSectorAmountfieldOfSector.sendKeys(objectiveamount);

System.out.println(newsectorAmount+"test"+newSiteAmount);


}else {
	
	System.out.println("sectoramount Is less than site amount");
}





if(newobjectiveamount<newsectorAmount) {
	
		
setting.SaveButton.click();	

Thread.sleep(2000);

WebElement Alertmessage= driver.findElement(By.xpath("//*[@id='agencies_data_alert_message']/div/strong"));
String getAlertMessage=Alertmessage.getText();
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
		
	}
	
	
	
	
}
