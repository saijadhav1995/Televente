package webElements_Identifiers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import webBase.BasePage;
import webBase.Controller;

public class UsersMenu extends BasePage {

	
	public static WebDriver Basepagedriver=null;

	public   UsersMenu(WebDriver dr) {
			
		BasePage.Basepagedriver = Controller.InvokeWebDriver();
			this.Basepagedriver=dr;
		}

	
	@FindBy(how=How.XPATH,using="//*[@value='CONNECTION']")
	@CacheLookup
	public WebElement Connection_button;
	
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Utilisateurs')]")
	@CacheLookup
	public	WebElement usersMenu;
	
	@FindBy(how=How.XPATH,using="//*[@id='usr-first-half']/div/div[1]/div/div[2]/a")
	@CacheLookup
	public	WebElement Create_User_button;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='usr_sgid']")
	@CacheLookup
	public	WebElement usr_sgid;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='usr_lastname']")
	@CacheLookup
	public	WebElement usr_lastname;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='usr_firstname']")
	@CacheLookup
	public	WebElement usr_firstname;
	
	
	
	@FindBy(how=How.XPATH,using="//*[@id='usr_mail']")
	@CacheLookup
	public	WebElement usr_mail;
	
	
	
	@FindBy(how=How.XPATH,using="//*[@id='usr_role']")
	@CacheLookup
	public	WebElement usr_role;
	
	public static final String Role="//*[@id='usr_role']";
	
	@FindBy(how=How.XPATH,using="//*[@id='usr_region_div']/div/div[1]/input")
	@CacheLookup
	public	WebElement left_region_searchField;
	
	public static final String left_region_searchField_xpath="//*[@id='usr_region_div']/div/div[1]/input";

	
	@FindBy(how=How.XPATH,using="//*[@id='usr_region_div']/div/div[2]/input")
	@CacheLookup
	public	WebElement right_region_searchField;
	
	public static final String right_region_searchField_xpath="//*[@id='usr_region_div']/div/div[2]/input";

	
	
	@FindBy(how=How.XPATH,using="//*[@id='usr_region_div']/div/div[1]/div/button")
	@CacheLookup
	public	WebElement left_region_Button;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='usr_region_div']/div/div[2]/div/button")
	@CacheLookup
	public	WebElement right_region_Button;
	
	
	

	@FindBy(how=How.XPATH,using="//*[@id='bootstrap-duallistbox-selected-list_usr_region[]']/option[@value='16']")
	@CacheLookup
	public	WebElement list_usr_region_selected;
	

	@FindBy(how=How.XPATH,using="//*[@id='btn-save']")
	@CacheLookup
	public	WebElement btn_save;
	
	@FindBy(how=How.XPATH,using="//*[@id='btn-reset']")
	@CacheLookup
	public	WebElement btn_reset;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='user_table_filter']/label/input")
	@CacheLookup
	public	WebElement user_table_filter;
	
	@FindBy(how=How.XPATH,using="//*[@id='user_table']/tbody/tr[1]")
	@CacheLookup
	public	WebElement selected_user;
	

	@FindBy(how=How.XPATH,using="//*[@id='panel']/div[1]/div/div/div[2]/strong")
	@CacheLookup
	public	WebElement success_message;

	
	public static final String successMessageXpath="//*[@id='panel']/div[1]/div/div/div[2]/strong";
	
	// error messages identifiers
	
	@FindBy(how=How.XPATH,using="//*[@id='usr_form']/div[1]/span/label")
	@CacheLookup
	public	WebElement Err_sgid;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='usr_form']/div[2]/span/label")
	@CacheLookup
	public	WebElement Err_firstName;

	
	@FindBy(how=How.XPATH,using="//*[@id='usr_form']/div[3]/span/label")
	@CacheLookup
	public	WebElement Err_LastName;

	@FindBy(how=How.XPATH,using="//*[@id='usr_form']/div[4]/span/label")
	@CacheLookup
	public	WebElement Err_email;

	@FindBy(how=How.XPATH,using="//*[@id='usr_form']/div[5]/span/label")
	@CacheLookup
	public	WebElement Err_Role;

	@FindBy(how=How.XPATH,using="//*[@id='usr_form']/div[6]/span/label")
	@CacheLookup
	public	WebElement Err_region;
	
	
	
}
