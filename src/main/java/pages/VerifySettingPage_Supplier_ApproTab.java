package pages;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class VerifySettingPage_Supplier_ApproTab extends BasePage {

	
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
	
	
	public void supplierApproTab(String TestName) throws Throwable {
		
		logger = baseT.extent.startTest(TestName);		
		setting=PageFactory.initElements(driver, SettingTabs.class);
		createDirectory("TELEVENTE"+TestName); 
		
		
		
		
	//	setting.SettingButton.click();
		setting.getSupplierTab().click();
		
		
		Thread.sleep(4000);
		
		
	
		ExcelConfig conf=
				new ExcelConfig(System.getProperty("user.dir")+"\\Excel\\Test.xlsx");
		
	
	// supplier appro tab ;	
				
			setting.suppliers_type.click();
		
			Select result=new Select(setting.suppliers_type);
			
			result.selectByValue("supplier_transporter");
			
			Thread.sleep(4000);

			logger.log(LogStatus.PASS,"1: open manage setting page" + "<br/>" + "2 : go to the supplier_transporter Tab tab" + "<br/>"
					+logger.addScreenCapture(captureScreenShot(driver,"user redirected on supplier_transporter tab in manage setting page")));						           
		

			
			setting.btn_supplier_add.click();
			
			logger.log(LogStatus.INFO,"Add supplier_transporter PopUp has been opened"
					+logger.addScreenCapture(captureScreenShot(driver,"Add supplier_transporter PopUp has been opened")));						           

			
			int count=conf.getRowCount(2);
			
			System.out.println(count); //get row count of selected sheet 
				
				
				int counter=0;
				
				while (count>counter) {
			
					
					for(int i=0;i<1;i++) {
						
						int j=counter; //row count
						
						
						System.out.println(""+conf.getData(2, j, i));
						
						String Id1=i+"-"+j;
						
						System.out.println(Id1);
						
						String testData=conf.getData(2, j, i);
						
						
						
						String search="//div[@id='addSuppliers']/div[2]/table/tbody/tr/td[@id='"+Id1+"']";
						
						System.out.println(search);
						
						WebElement searchInput=	driver.findElement(By.xpath(search));
						
					
						String line1="arguments[0].innerText='";
						String line2= "'";
						System.out.println(line1+testData+line2);
						
						JavascriptExecutor executor = (JavascriptExecutor)driver;
						executor.executeScript(line1+testData+line2, searchInput);			
						
						Thread.sleep(2000);
						
						Actions actions = new Actions(driver);
						actions.doubleClick(searchInput).perform();
					
					
					}
					
					
					counter=counter+1;
					System.out.println(counter);
				}
				
				logger.log(LogStatus.PASS,"1:excel sheet has been configured for supplier_transporter data" + "<br/>" + 
						"2 :getting data from excel sheet & inserted on jexcel fields" + "<br/>"
								+logger.addScreenCapture(captureScreenShot(driver,"data inseted on supplier_transporter jexcel fields")));						           
				
	
	setting.btn_save_suppliers.click();
	
	logger.log(LogStatus.PASS,"articles successfully inserted on supplier_transporter Tab"
			+logger.addScreenCapture(captureScreenShot(driver,"articles successfully inserted on supplier_transporter Tab")));						           


	}	
		
	 			
					
		
	
//rechercher field					
public void rechercherField() throws Throwable {


if(helper.isElementEnabled(setting.suppliers_table_filter)==true) {

	Thread.sleep(4000);
	
	driver.findElement(By.xpath("//*[@id='suppliers_table_filter']/label/input")).sendKeys("manager");
	
logger.log(LogStatus.PASS,"user able to search data on rechercher field"
		+logger.addScreenCapture(captureScreenShot(driver,"rechercher field checked")));						           

driver.findElement(By.xpath("//*[@id='suppliers_table_filter']/label/input")).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);

Thread.sleep(2000);

}else {

logger.log(LogStatus.FAIL,"user does not able to search on rechercher Field"
		+logger.addScreenCapture(captureScreenShot(driver,"user does not able to search on rechercher Field")));

}


}
	



//pagination drop down field

public void paginationDropDown() throws Throwable {

if(helper.isElementEnabled(setting.suppliers_table_length)==true) {
Thread.sleep(2000);
	
	setting.suppliers_table_length.click();
	
	Select Page=new Select(setting.suppliers_table_length);
	
	Page.selectByValue("25");
	logger.log(LogStatus.PASS,"user able to row filters from pagination drop Down"
			+logger.addScreenCapture(captureScreenShot(driver,"row filters field checked")));						           
	
	
	
}else {
	
	logger.log(LogStatus.FAIL,"pagination Drop Down field is disabled"
			+logger.addScreenCapture(captureScreenShot(driver,"pagination Drop Down field is disabled")));
	
}



}


// sorting arrows

public void sortingArrows() throws Throwable {

if(helper.isElementEnabled(setting.suppliers_table_sorting)==true) {
	
	Thread.sleep(2000);
	setting.suppliers_table_sorting.click();
	Thread.sleep(2000);
	setting.suppliers_table_sorting.click();
	logger.log(LogStatus.PASS,"user able to sort columns by asceding & descending order"
			+logger.addScreenCapture(captureScreenShot(driver,"sorting checked")));						           
	
	
}else {

	logger.log(LogStatus.FAIL,"user does not able to sort columns by asceding & descending order"
			+logger.addScreenCapture(captureScreenShot(driver,"sorting not checked")));						           

	
}
}

// delete rows 


public void deleteArticles() throws Throwable{

if(helper.isElementEnabled(setting.btn_supplier_delete)==true) {
	
	setting.suppliers_table_checkBox.click();
	setting.btn_supplier_delete.click();
	Thread.sleep(2000);
	Alert alert = driver.switchTo().alert();
    String alertText = alert.getText();
    logger.log(LogStatus.INFO, "Alert data: " + alertText);
    alert.accept();
    Thread.sleep(4000);
    logger.log(LogStatus.PASS,"delete button is enabled"
			+logger.addScreenCapture(captureScreenShot(driver,"delete button is enabled")));						           
	
	
}else {
	
	logger.log(LogStatus.INFO,"delete button is disabled"
			+logger.addScreenCapture(captureScreenShot(driver,"delete button is disabled")));						           

	
	}

}
		 
		

	
}
