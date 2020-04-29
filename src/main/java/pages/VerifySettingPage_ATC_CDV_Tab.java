package pages;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.AppstringsConstant;
import Utility.Helper;
import Utility.RankingRelatedQueries;
import bsh.Variable;
import webBase.BasePage;
import webBase.BaseTest;
import webBase.ExcelConfig;
import webElements_Identifiers.SettingTabs;

public class VerifySettingPage_ATC_CDV_Tab extends BasePage {

	
	public ExtentTest logger;	
	public ExtentTest extentest;
	public SoftAssert SAssert = new SoftAssert();
	public PageFactory pf=new PageFactory();
	public Helper helper=new Helper();
	public VerifyHome home=new VerifyHome();

	
	BaseTest baseT = new BaseTest();
	String className = "";
	SettingTabs setting=new SettingTabs(driver);
	AppstringsConstant appConst =new AppstringsConstant(); 
	RankingRelatedQueries settingtabsData=new RankingRelatedQueries();
	
	
	public void ATC_CDV_Tab(String TestName) throws Throwable {
		
	try {
		
		
		logger = baseT.extent.startTest(TestName);		
		setting=PageFactory.initElements(driver, SettingTabs.class);
		createDirectory("TELEVENTE"+TestName); 
	
		
		//setting.SettingButton.click();
		setting.getSellersTab().click();
		
		logger.log(LogStatus.PASS,"1: open manage setting page" + "<br/>" 
		+ "2 : go to the ATC_CDV tab" + "<br/>"
				+"<b><font color='green'>Result: successfully able to redirected on ATC/CDV Tab "
				+logger.addScreenCapture(captureScreenShot(driver,"user redirected on ATC_CDV tab in manage setting page")));						           
	
		
		Thread.sleep(4000);

		setting.btn_seller_add.click();
		
		logger.log(LogStatus.PASS,"<b><font color='green'>Result: Add ATC_CDV PopUp has been opened"
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
				+"<b><font color='green'>Result: successfully able to add Data on ATC/CDV insertion PopUP"
						+logger.addScreenCapture(captureScreenShot(driver,"data inseted on ATC_CDV jexcel fields")));						           
			

		
		setting.btn_save_sellers.click();
		
	
		Thread.sleep(2000);
		logger.log(LogStatus.PASS,"<b><font color='green'>Result:articles successfully inserted on ATC_CDV Tab"
						+logger.addScreenCapture(captureScreenShot(driver,"articles successfully inserted on ATC_CDV Tab")));						           
		
	
	} catch (Exception e) {
	
		logger.log(LogStatus.FAIL,"<b><font color='red'>Result:user does not able to add Rows on ATC/CDV Tabs"
				+logger.addScreenCapture(captureScreenShot(driver,"Error  on ATC_CDV Tab")));						           

		
	}	
	
		
	}	
		
	 			
					
	//rechercher field					
		public void rechercherField() throws Throwable {
			
			
			try {
				
			
			if(helper.isElementEnabled(setting.sellers_table_filter)==true) {
				
				setting.sellers_table_filter.sendKeys("manager");
				logger.log(LogStatus.PASS,"<b><font color='green'>Result: user able to search data on rechercher field"
						+logger.addScreenCapture(captureScreenShot(driver,"rechercher field checked")));						           
				
				setting.sellers_table_filter.sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
				
				Thread.sleep(2000);
				
			}else {
				
				logger.log(LogStatus.FAIL,"<b><font color='red'>Result: user does not able to search on rechercher Field"
						+logger.addScreenCapture(captureScreenShot(driver,"user does not able to search on rechercher Field")));
				
			}
			
			} catch (Exception e) {
				
				logger.log(LogStatus.FAIL,"<b><font color='red'>Result: user does not able to search on rechercher Field"
						+logger.addScreenCapture(captureScreenShot(driver,"user does not able to search on rechercher Field")));
					}
			
			
		}
					
			

			
	//pagination drop down field
			
			public void paginationDropDown() {
				
				try {
					
				
				if(helper.isElementEnabled(setting.sellers_table_length)==true) {
				
					setting.sellers_table_length.click();
					
					Select Page=new Select(setting.sellers_table_length);
					
					Page.selectByValue("25");
					logger.log(LogStatus.PASS,"<b><font color='green'>Result: user able to row filters from pagination drop Down"
							+logger.addScreenCapture(captureScreenShot(driver,"row filters field checked")));						           
					
					
					
				}else {
					
					logger.log(LogStatus.FAIL,"<b><font color='red'>Result: pagination Drop Down field is disabled"
							+logger.addScreenCapture(captureScreenShot(driver,"pagination Drop Down field is disabled")));
					
				}
				
				} catch (Exception e) {
					logger.log(LogStatus.FAIL,"<b><font color='red'>Result: pagination Drop Down field is disabled"
							+logger.addScreenCapture(captureScreenShot(driver,"pagination Drop Down field is disabled")));
					}
				
			}
			
			 
	// sorting arrows
			
			public void sortingArrows() throws Throwable {
				
				try {
					
				
				
				if(helper.isElementEnabled(setting.sellers_table_sorting)==true) {
					
					setting.sellers_table_sorting.click();
					Thread.sleep(2000);
					setting.sellers_table_sorting.click();
					logger.log(LogStatus.PASS,"<b><font color='green'>Result: user able to sort columns by asceding & descending order"
							+logger.addScreenCapture(captureScreenShot(driver,"sorting checked")));						           
					
					
				}else {
				
					logger.log(LogStatus.FAIL,"<b><font color='red'>Result: user does not able to sort columns by asceding & descending order"
							+logger.addScreenCapture(captureScreenShot(driver,"sorting not checked")));						           
				
					
				}
				
				} catch (Exception e) {
					logger.log(LogStatus.FAIL,"<b><font color='red'>Result: user does not able to sort columns by asceding & descending order"
							+logger.addScreenCapture(captureScreenShot(driver,"sorting not checked")));						           
					}
			}

	// delete rows 
			
		
			public void deleteArticles() throws Throwable {
				
			try {
				
			
				
				if(helper.isElementEnabled(setting.btn_seller_delete)==true) {
					
					setting.sellers_table_checkBox.click();
					setting.btn_seller_delete.click();
					
					Alert alert = driver.switchTo().alert();
			        String alertText = alert.getText();
			        logger.log(LogStatus.INFO, "<b><font color='blue'>Result: Alert Message is displayed while deleting rows");
			         alert.accept();
			        
			        Thread.sleep(4000);
				
			        logger.log(LogStatus.PASS,"<b><font color='green'>Result: delete button is enabled"
							+logger.addScreenCapture(captureScreenShot(driver,"delete button is enabled")));						           
					
					
				}else {
					
					logger.log(LogStatus.FAIL,"<b><font color='red'>Result: delete button is disabled"
							+logger.addScreenCapture(captureScreenShot(driver,"delete button is disabled")));						           
				
					
				}
			
			} catch (Exception e) {
				logger.log(LogStatus.FAIL,"<b><font color='red'>Result: getting Error While Deleting Rows"
						+logger.addScreenCapture(captureScreenShot(driver,"delete button is disabled")));						           
			}
				
			}
		
				
}	


			
