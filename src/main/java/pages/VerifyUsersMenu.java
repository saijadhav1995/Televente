package pages;

import java.sql.ResultSet;
import java.sql.SQLException;

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
import webBase.DataBase;
import webBase.ExcelConfig;
import webElements_Identifiers.SettingTabs;
import webElements_Identifiers.UsersMenu;

public class VerifyUsersMenu extends BasePage {

	
	public ExtentTest logger;	
	public ExtentTest extentest;
	public SoftAssert SAssert = new SoftAssert();
	public PageFactory pf=new PageFactory();
	public Helper helper=new Helper();
	public VerifyHome home=new VerifyHome();
	
	BaseTest baseT = new BaseTest();
	String className = "";
	UsersMenu users=new UsersMenu(driver);
	AppstringsConstant appConst =new AppstringsConstant(); 
	RankingRelatedQueries settingtabsData=new RankingRelatedQueries();
	
	
	public void usersMenu(String TestName) throws Throwable {
		
		logger = baseT.extent.startTest(TestName);		
		users=PageFactory.initElements(driver, UsersMenu.class);
		createDirectory("TELEVENTE"+TestName); 
		
		
	//	users.Connection_button.click();
		users.usersMenu.click();
		users.Create_User_button.click();
		
//Verify error messages on each field
		
		users.btn_save.click();
		Thread.sleep(3000);
		
		
		logger.log(LogStatus.PASS,"1:Redirected to the Users Menu"+"<br/>"
				+"2:click on Create users menu button"+"<br/>"
				+"3:then click on Save button to Verifying error Messages on each fields of creation form "
				+logger
 				.addScreenCapture(captureScreenShot(driver, "Creation Form has been checked")));
			

		
		
		if(helper.isElementPresent(users.Err_sgid)==true) {
			
		String sgid_error=users.Err_sgid.getAttribute("innerHTML");
			
		System.out.println(sgid_error);
		
		logger.log(LogStatus.PASS,"1:Open create users Form "+"<br/>"
				+"2:Compairing Actual Error Message On SGID Field With Expected "+"<br/>"
				+"<b><font color='green'>Result:Error message has been Verified <font/>");
		
		}else {
			
			logger.log(LogStatus.FAIL,"1:Open create users Form "+"<br/>"
					+"2:Compairing Actual Error Message On SGID Field With Expected "+"<br/>"
					+"<b><font color='red'>Result:Error message Does not Dispalyed As Expected <font/>");
			
			System.out.println("sgid_error message is missing");
		}
		
		if(helper.isElementPresent(users.Err_firstName)==true) {
			
			String Err_firstName=users.Err_firstName.getAttribute("innerHTML");
				
			System.out.println(Err_firstName);
			
			logger.log(LogStatus.PASS,"1:Open create users Form "+"<br/>"
					+"2:Compairing Actual Error Message On First Name Field With Expected "+"<br/>"
					+"<b><font color='green'>Result:Error message has been Verified <font/>");
			
			
			}else {
				
				logger.log(LogStatus.FAIL,"1:Open create users Form "+"<br/>"
						+"2:Compairing Actual Error Message On First Name Field With Expected "+"<br/>"
						+"<b><font color='red'>Result:Error message Does not Dispalyed As Expected <font/>");
				
				System.out.println("sgid_error message is missing");
			}
			
		
		if(helper.isElementPresent(users.Err_LastName)==true) {
			
			String Err_LastName=users.Err_LastName.getAttribute("innerHTML");
			
			logger.log(LogStatus.PASS,"1:Open create users Form "+"<br/>"
					+"2:Compairing Actual Error Message On Last Name Field With Expected "+"<br/>"
					+"<b><font color='green'>Result:Error message has been Verified <font/>");
			
			System.out.println(Err_LastName);
			}else {
				
				logger.log(LogStatus.FAIL,"1:Open create users Form "+"<br/>"
						+"2:Compairing Actual Error Message On Last Name Field With Expected "+"<br/>"
						+"<b><font color='red'>Result:Error message Does not Dispalyed As Expected <font/>");
				
				System.out.println("sgid_error message is missing");
			}
		
		if(helper.isElementPresent(users.Err_email)==true) {
			
			String Err_email=users.Err_email.getAttribute("innerHTML");
			
			logger.log(LogStatus.PASS,"1:Open create users Form "+"<br/>"
					+"2:Compairing Actual Error Message On Email  Field With Expected "+"<br/>"
					+"<b><font color='green'>Result:Error message has been Verified <font/>");
			
			System.out.println(Err_email);
			}else {
				
				logger.log(LogStatus.FAIL,"1:Open create users Form "+"<br/>"
						+"2:Compairing Actual Error Message On Email Field With Expected "+"<br/>"
						+"<b><font color='red'>Result:Error message Does not Dispalyed As Expected <font/>");
				
				System.out.println("sgid_error message is missing");
			}
		
		if(helper.isElementPresent(users.Err_Role)==true) {
			
			String Err_Role=users.Err_Role.getAttribute("innerHTML");
			logger.log(LogStatus.PASS,"1:Open create users Form "+"<br/>"
					+"2:Compairing Actual Error Message On Role Field With Expected "+"<br/>"
					+"<b><font color='green'>Result:Error message has been Verified <font/>");
				
			System.out.println(Err_Role);
			}else {
				
				logger.log(LogStatus.FAIL,"1:Open create users Form "+"<br/>"
						+"2:Compairing Actual Error Message On Role Field With Expected "+"<br/>"
						+"<b><font color='red'>Result:Error message Does not Dispalyed As Expected <font/>");
			
				System.out.println("sgid_error message is missing");
			}
		
		
		if(helper.isElementPresent(users.Err_region)==true) {
			
			String Err_region=users.Err_region.getAttribute("innerHTML");
			
			logger.log(LogStatus.PASS,"1:Open create users Form "+"<br/>"
					+"2:Compairing Actual Error Message On Region Field With Expected "+"<br/>"
					+"<b><font color='green'>Result:Error message has been Verified <font/>");
				
			System.out.println(Err_region);
			}else {
				
				logger.log(LogStatus.FAIL,"1:Open create users Form "+"<br/>"
						+"2:Compairing Actual Error Message On Region Field With Expected "+"<br/>"
						+"<b><font color='red'>Result:Error message Does not Dispalyed As Expected <font/>");
			
				System.out.println("Region message is missing");
			}
		
		Thread.sleep(2000);
		
		users.usr_sgid.sendKeys("A1233456");
		users.usr_firstname.sendKeys("QA");
		users.usr_lastname.sendKeys("Automation");
		users.usr_mail.sendKeys("QaAutomation@gmail.com");
		users.usr_role.click();
		Select select=new Select(users.usr_role);
		select.selectByValue("2");
		users.left_region_searchField.sendKeys("ASTURIENNE");
		users.left_region_searchField.clear();
		users.left_region_Button.click();
		users.right_region_searchField.sendKeys("ASTURIENNE");
		users.right_region_searchField.clear();
		
		logger.log(LogStatus.PASS,"1:entered valid data in all the Fields On Creation Form"+"<br/>"
				+"<b><font color='green'>Result:user success fully able to enter data on All Field <font/>"
		+logger
			.addScreenCapture(captureScreenShot(driver, "Creation Form All fields has been checked")));
	
		
		users.btn_save.click();
		
		
		if(helper.isElementPresent(users.success_message)==true) {
			
		String sucess_message= users.success_message.getText();
			System.out.println(sucess_message);
			
			logger.log(LogStatus.PASS,"1:entered valid data On Creation Form & click on Save Button"+"<br/>"
					+"<b><font color='green'>Result:Success message has been Verified <font/>"
			+logger
			.addScreenCapture(captureScreenShot(driver, "Success Message On Creation Form")));	

		}else {
			
			logger.log(LogStatus.FAIL,"1:entered valid data On Creation Form & click on Save Button"+"<br/>"
					+"<b><font color='green'>Result:Success message Does not displayed as Expected <font/>"
			+logger
			.addScreenCapture(captureScreenShot(driver, "Success Message On Creation Form")));	

			
		}
		
		users.user_table_filter.sendKeys("A1233456");
		
		logger.log(LogStatus.PASS,"1:go to the Users List"+"<br/>"
				+"2:search user on Users List"+"<br/>"
				+"<b><font color='green'>Result:user successfully able to search on Users List <font/>"
		+logger
		.addScreenCapture(captureScreenShot(driver, "users List has been checked")));

		
		users.selected_user.click();
		
		logger.log(LogStatus.PASS,"1:go to the Users List"+"<br/>"
				+"2:search user on Users List & select user"+"<br/>"
				+"<b><font color='green'>Result:selected user Appeared on Edit Form <font/>"
		+logger
		.addScreenCapture(captureScreenShot(driver, "Edit Form has been checked")));	
		}	
	
	
	public void VerifyEditForm() throws Throwable {
		
		Thread.sleep(2000);
	

		driver.findElement(By.id("usr_sgid")).clear();
		driver.findElement(By.id("usr_sgid")).sendKeys("A1233456");
		
		driver.findElement(By.id("usr_firstname")).clear();
		driver.findElement(By.id("usr_firstname")).sendKeys("QA");
		
		driver.findElement(By.id("usr_lastname")).clear();
		driver.findElement(By.id("usr_lastname")).sendKeys("Automation");
		
		driver.findElement(By.id("usr_mail")).clear();
		driver.findElement(By.id("usr_mail")).sendKeys("QaAutomation@gmail.com");
		

		WebElement Role= driver.findElement(By.xpath(users.Role));
		Role.click();
		Select select=new Select(Role);
		select.selectByValue("2");
		
		driver.findElement(By.xpath(users.right_region_searchField_xpath)).sendKeys("ASTURIENNE");
		driver.findElement(By.xpath(users.right_region_searchField_xpath)).clear();
		
		logger.log(LogStatus.PASS,"1:go to the Edit Form"+"<br/>"
				+"2:Entered Data On All the Field"+"<br/>"
				+"<b><font color='green'>Result:user able to entered Data on Edit Form <font/>"
		+logger
		.addScreenCapture(captureScreenShot(driver, "Enter data On Edit Form")));	
	
		
		
		driver.findElement(By.id("btn-save")).click();
		
		Thread.sleep(3000);
		
	 WebElement successMessage=	driver.findElement(By.xpath(users.successMessageXpath));
		
		
		if(helper.isElementPresent(successMessage)==true) {
			
			String sucess_message= successMessage.getText();
				System.out.println(sucess_message);
				
				logger.log(LogStatus.PASS,"1:entered valid data On Edit Form & click on Save Button"+"<br/>"
						+"<b><font color='green'>Result:Update message has been Verified <font/>"
				+logger
				.addScreenCapture(captureScreenShot(driver, "Success Message On Edit Form")));	

				
			}else {
				
				logger.log(LogStatus.FAIL,"1:entered valid data On Edit Form & click on Save Button"+"<br/>"
						+"<b><font color='green'>Result:Update message Does not displayed as Expected <font/>"
				+logger
				.addScreenCapture(captureScreenShot(driver, "Success Message On Edit Form")));	

				
			}
			
		
		
	}
	
	
	public static String user_id="";
	
	public static void getUSerDetails() throws ClassNotFoundException, SQLException, Throwable{
		
		DataBase dataBase = new DataBase();
		String query = "select * from usr where usr_sgid='A1233456'";
		
		ResultSet data = dataBase.getData(query);
		System.out.println(data);
		while(data.next()){
			System.out.println(data.getString(1)+"| "+data.getString(2)+"| "+data.getString(3)+"| "+data.getString(4)
			+" "+data.getString(5)+"| "+data.getString(6)+"| "+data.getString(7)+"| "+data.getString(8));
			 
			user_id =data.getString(1);
			
			System.out.println(user_id);
				
		}
		
		Thread.sleep(2000);
		
			
		
	}
	
	
	public static void deleteuserDetails()   throws ClassNotFoundException, SQLException{
		
		
		String query = "delete  from user_region where user_region.URG_USR_ID='"+user_id+"'";
		String query1="delete from usr where usr_sgid='A1233456'";
		
		System.out.println(query);
		DataBase dataBase = new DataBase();
		dataBase.updateData(query);
		dataBase.updateData(query1);
	
		
	}
}
