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

public class VerifySettingPage_ArticlesTab extends BasePage {

	
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
	
	
	public void artilceTab(String TestName) throws Throwable {
		
		logger = baseT.extent.startTest(TestName);		
		setting=PageFactory.initElements(driver, SettingTabs.class);
		createDirectory("TELEVENTE"+TestName); 
		
		
		
		
		//setting.SettingButton.click();
		setting.getArticleTab().click();
		
		logger.log(LogStatus.PASS,"1: open manage setting page" + "<br/>" + "2 : go to the Article tab" + "<br/>"
				+logger.addScreenCapture(captureScreenShot(driver,"user redirected on article tab in manage setting page")));						           
	
		
		Thread.sleep(4000);

		setting.btn_article_add.click();
		ExcelConfig conf=
				new ExcelConfig(System.getProperty("user.dir")+"\\Excel\\Test.xlsx");
			
		logger.log(LogStatus.INFO,"Add articles PopUp has been opened"
				+logger.addScreenCapture(captureScreenShot(driver,"Add articles PopUp has been opened")));						           
	
		
int count=conf.getRowCount(1);
		
		System.out.println(count); //get row count of selected sheet 
		
		
		int counter=0;
		
		while (count>counter) {
	
			
			for(int i=0;i<2;i++) {
				
				int j=counter; //row count
				
				
				System.out.println(""+conf.getData(1, j, i));
				
				String Id1=i+"-"+j;
				
				System.out.println(Id1);
				
				String testData=conf.getData(1, j, i);
				
				
				
				String search="//div[@id='addArticles']/div[2]/table/tbody/tr/td[@id='"+Id1+"']";
				
				System.out.println(search);
				
				WebElement searchInput=	driver.findElement(By.xpath(search));
				
			
				String line1="arguments[0].innerText='";
				String line2= "'";
				System.out.println(line1+testData+line2);
				

				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript(line1+testData+line2, searchInput);			
				
				Actions actions = new Actions(driver);
				actions.doubleClick(searchInput).perform();
				
				Actions actions1 = new Actions(driver);
				actions1.click(searchInput).perform();
			
			}
			
			
			counter=counter+1;
			System.out.println(counter);
		}
		
		logger.log(LogStatus.PASS,"1:excel sheet has been configured for articles data" + "<br/>" + 
		"2 :getting data from excel sheet & inserted on jexcel fields" + "<br/>"
				+logger.addScreenCapture(captureScreenShot(driver,"data inseted on article jexcel fields")));						           
	
		
		setting.btn_save_articles.click();
		
		Thread.sleep(2000);
		logger.log(LogStatus.PASS,"articles successfully inserted on article Tab"
						+logger.addScreenCapture(captureScreenShot(driver,"articles successfully inserted on article Tab")));						           
			
		
	}	
		
	 			
					
		
				
		


			
		
		 
		

	
	
}
