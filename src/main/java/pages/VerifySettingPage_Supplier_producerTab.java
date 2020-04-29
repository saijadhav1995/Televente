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

public class VerifySettingPage_Supplier_producerTab extends BasePage {

	
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
	
	
	public void supplierProducerTab(String TestName) throws Throwable {
		
		try {
			
		
		logger = baseT.extent.startTest(TestName);		
		setting=PageFactory.initElements(driver, SettingTabs.class);
		createDirectory("TELEVENTE"+TestName); 
			
		//setting.SettingButton.click();
		setting.getSupplierTab().click();
		
		logger.log(LogStatus.PASS,"1:open manage setting page" + "<br/>" 
		+ "2 : go to the supplier_producer Tab" + "<br/>"
				+"<b><font color='green'>Result: user successfully redirected to supplier_producer tab  "
				+logger.addScreenCapture(captureScreenShot(driver,"user redirected on supplier_producer tab in manage setting page")));						           
	
		
		Thread.sleep(4000);

		setting.btn_supplier_add.click();

		logger.log(LogStatus.PASS,"<b><font color='green'>Result: Add supplier_producer PopUp has been opened"
				+logger.addScreenCapture(captureScreenShot(driver,"Add supplier_producer PopUp has been opened")));						           


		
		ExcelConfig conf=
				new ExcelConfig(System.getProperty("user.dir")+"\\Excel\\Test.xlsx");
			
		
int count=conf.getRowCount(3);
		
	System.out.println(count); //get row count of selected sheet 
		
		
		int counter=0;
		
		while (count>counter) {
	
			
			for(int i=0;i<1;i++) {
				
				int j=counter; //row count
				
				
				System.out.println(""+conf.getData(3, j, i));
				
				String Id1=i+"-"+j;
				
				System.out.println(Id1);
				
				String testData=conf.getData(3, j, i);
				
				
				
				String search="//div[@id='addSuppliers']/div[2]/table/tbody/tr/td[@id='"+Id1+"']";
				
				System.out.println(search);
				
				WebElement searchInput=	driver.findElement(By.xpath(search));
				
			
				String line1="arguments[0].innerText='";
				String line2= "'";
				System.out.println(line1+testData+line2);
				

				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript(line1+testData+line2, searchInput);			
				
				Actions actions = new Actions(driver);
				actions.doubleClick(searchInput).perform();
			
			
			}
			
			
			counter=counter+1;
			System.out.println(counter);
		}
		
		
		logger.log(LogStatus.PASS,"1:excel sheet has been configured for supplier_producer data" + "<br/>" + 
				"2 :getting data from excel sheet & inserted on jexcel fields" + "<br/>"
				+"<b><font color='green'>Result: successfully add data on supplier_producer insertion popUp "
						+logger.addScreenCapture(captureScreenShot(driver,"data inseted on supplier_producer jexcel fields")));						           
	
		
		setting.btn_save_suppliers.click();
		
		logger.log(LogStatus.PASS,"<b><font color='green'>Result: articles successfully inserted on supplier_producer Tab"
				+logger.addScreenCapture(captureScreenShot(driver,"articles successfully inserted on supplier_producer Tab")));						           

		} catch (Exception e) {
			logger.log(LogStatus.FAIL,"<b><font color='red'>Result: does not able to add rows on supplier_producer Tab"
					+logger.addScreenCapture(captureScreenShot(driver,"Error on supplier_producer Tab")));						           
		}
		
	
	}	
		
	//rechercher field					
	public void rechercherField() throws Throwable {

		try {
			
		
	if(helper.isElementEnabled(setting.suppliers_table_filter)==true) {

		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//*[@id='suppliers_table_filter']/label/input")).sendKeys("manager");
			

	logger.log(LogStatus.PASS,"<b><font color='green'>Result: user able to search data on rechercher field"
			+logger.addScreenCapture(captureScreenShot(driver,"rechercher field checked")));						           

	driver.findElement(By.xpath("//*[@id='suppliers_table_filter']/label/input")).sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);

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

	public void paginationDropDown() throws Throwable{

try {
	
		
		if(helper.isElementEnabled(setting.suppliers_table_length)==true) {
		Thread.sleep(2000);
		setting.suppliers_table_length.click();
		
		Select Page=new Select(setting.suppliers_table_length);
		
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
			
		
	if(helper.isElementEnabled(setting.suppliers_table_sorting)==true) {
		Thread.sleep(2000);
		setting.suppliers_table_sorting.click();
		Thread.sleep(2000);
		setting.suppliers_table_sorting.click();
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


	public void deleteArticles()throws Throwable {

		try {
			
		
	if(helper.isElementEnabled(setting.btn_supplier_delete)==true) {
		
		setting.suppliers_table_checkBox.click();
		setting.btn_supplier_delete.click();
		Thread.sleep(2000);
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
		
			logger.log(LogStatus.FAIL,"<b><font color='red'>Result: getting Error While deleting Rows"
					+logger.addScreenCapture(captureScreenShot(driver,"delete button is disabled")));						           

		}
		

	}




	
	
	
	
}
