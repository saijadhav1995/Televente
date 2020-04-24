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
		
		
		users.Connection_button.click();
		users.usersMenu.click();
		users.Create_User_button.click();
		
//Verify error messages on each field
		
		users.btn_save.click();
		Thread.sleep(2000);
		
		if(helper.isElementPresent(users.Err_sgid)==true) {
			
		String sgid_error=users.Err_sgid.getAttribute("innerHTML");
			
		System.out.println(sgid_error);
		}else {
			
			System.out.println("sgid_error message is missing");
		}
		
		if(helper.isElementPresent(users.Err_firstName)==true) {
			
			String Err_firstName=users.Err_firstName.getAttribute("innerHTML");
				
			System.out.println(Err_firstName);
			}else {
				
				System.out.println("sgid_error message is missing");
			}
			
		
		if(helper.isElementPresent(users.Err_LastName)==true) {
			
			String Err_LastName=users.Err_LastName.getAttribute("innerHTML");
				
			System.out.println(Err_LastName);
			}else {
				
				System.out.println("sgid_error message is missing");
			}
		
		if(helper.isElementPresent(users.Err_email)==true) {
			
			String Err_email=users.Err_email.getAttribute("innerHTML");
				
			System.out.println(Err_email);
			}else {
				
				System.out.println("sgid_error message is missing");
			}
		
		if(helper.isElementPresent(users.Err_Role)==true) {
			
			String Err_Role=users.Err_Role.getAttribute("innerHTML");
				
			System.out.println(Err_Role);
			}else {
				
				System.out.println("sgid_error message is missing");
			}
		
		
		if(helper.isElementPresent(users.Err_region)==true) {
			
			String Err_region=users.Err_region.getAttribute("innerHTML");
				
			System.out.println(Err_region);
			}else {
				
				System.out.println("sgid_error message is missing");
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
		users.btn_save.click();
		
		
		if(helper.isElementPresent(users.success_message)==true) {
			
		String sucess_message= users.success_message.getText();
			System.out.println(sucess_message);
			
		}
		
		users.user_table_filter.sendKeys("A1233456");
		users.selected_user.click();
		
		
		
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
