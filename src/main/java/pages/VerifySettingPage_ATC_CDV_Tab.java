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
		
				
		setting=PageFactory.initElements(driver, SettingTabs.class);
		createDirectory("TELEVENTE"+TestName); 
		
		
		driver.navigate().to("https://televente.mutlp.test.pointp.saint-gobain.net"
				+ "/editTelevente/eyJpdiI6IjBySngxTnM3RVZQQUN3UzF6aUV2UUE9PSIsInZhbHVlIjoiM3czYkFQR2lMaXVrY2lzajREWkpqQT09Ii"
				+ "wibWFjIjoiMzMzMDMyMzE5YmIxMjZjNzNlZGMwMGZjODA1NTYyYzBjMjc4ODI5OWQ4OTNhY2VlYTdkYjYyZjdmNGVmYzQ0YyJ9");
		
		
		setting.SettingButton.click();
		setting.getSellersTab().click();
		
		
		Thread.sleep(4000);

		setting.btn_seller_add.click();
		

		
		
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
		
		
		setting.btn_save_sellers.click();
		
	
	
		
	}	
		
	 			
					
		
				
		


			
		
		 
		

	
	
}
