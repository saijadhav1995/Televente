package pages;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Baselibrary.ExcelConfig;
import Utility.AppstringsConstant;
import Utility.Helper;
import Utility.SettingTabsData;
import bsh.Variable;
import webBase.BasePage;
import webBase.BaseTest;
import webElements_Identifiers.SettingTabs;

public class VerifySettingPage_ATC_CDV_Tab extends BasePage {

	
	public ExtentTest logger;	
	public ExtentTest extentest;
	public SoftAssert SAssert = new SoftAssert();
	public PageFactory pf=new PageFactory();
	public Helper helper=new Helper();

	
	BaseTest baseT = new BaseTest();
	String className = "";
	SettingTabs setting=new SettingTabs(driver);
	AppstringsConstant appConst =new AppstringsConstant(); 
	SettingTabsData settingtabsData=new SettingTabsData();
	
	
	public void ATC_CDV_Tab(String TestName) throws Throwable {
		
		logger = baseT.extent.startTest(TestName);		
		setting=PageFactory.initElements(driver, SettingTabs.class);
		createDirectory("TELEVENTE"+TestName); 
		
		
		
		
		//setting.SettingButton.click();
		setting.getSellersTab().click();
		
		logger.log(LogStatus.PASS,"1: open manage setting page" + "<br/>" + "2 : go to the ATC_CDV tab" + "<br/>"
				+logger.addScreenCapture(captureScreenShot(driver,"user redirected on ATC_CDV tab in manage setting page")));						           
	
		
		Thread.sleep(4000);

		setting.btn_seller_add.click();
		
		logger.log(LogStatus.INFO,"Add ATC_CDV PopUp has been opened"
				+logger.addScreenCapture(captureScreenShot(driver,"Add ATC_CDV PopUp has been opened")));						           
	
		
		
		Thread.sleep(4000);

		ExcelConfig conf=
				new ExcelConfig(System.getProperty("user.dir")+"\\Excel\\Test.xlsx");
			
			
		
		int count=conf.getRowCount(0);
		
		System.out.println(count);
		
		
		int counter=0;
		
		while (count>counter) {
	
			
			for(int i=0;i<6;i++) {
				
				int j=counter; //row count
				
				
				System.out.println(""+conf.getData(0, j, i));
				
				String Id1=i+"-"+j;
				
				System.out.println(Id1);
				
				String testData=conf.getData(0, j, i);
				
				String line1="document.getElementById('";
				String line2="').innerText='";
				String line3= "'";
				System.out.println(line1+Id1+line2+testData+line3);
				
				
				
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript(line1+Id1+line2+testData+line3);
				
			String doubleclick="//td[@id='"+i+"-"+counter+"']";
			System.out.println(doubleclick);
					WebElement TEST=driver.findElement(By.xpath(doubleclick));
					
			Actions actions = new Actions(driver);
			actions.doubleClick(TEST).perform();
					
			}
			
			
			counter=counter+1;
			System.out.println(counter);
		}
		
		logger.log(LogStatus.PASS,"1:excel sheet has been configured for ATC_CDV data" + "<br/>" + 
				"2 :getting data from excel sheet & inserted on jexcel fields" + "<br/>"
						+logger.addScreenCapture(captureScreenShot(driver,"data inseted on ATC_CDV jexcel fields")));						           
			

		
		setting.btn_save_sellers.click();
		
	
		Thread.sleep(2000);
		logger.log(LogStatus.PASS,"articles successfully inserted on ATC_CDV Tab"
						+logger.addScreenCapture(captureScreenShot(driver,"articles successfully inserted on ATC_CDV Tab")));						           
		
		
	}	
		
	 			
					
		
				
		


			
		
		 
		

	
	
}