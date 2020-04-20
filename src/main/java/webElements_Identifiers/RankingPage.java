package webElements_Identifiers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Utility.RankingRelatedQueries;
import webBase.BasePage;
import webBase.Controller;

public class RankingPage extends BasePage {
	
	RankingRelatedQueries settingtabsData=new RankingRelatedQueries();
	public static WebDriver Basepagedriver=null;

	public  RankingPage(WebDriver dr) {
			
		BasePage.Basepagedriver = Controller.InvokeWebDriver();
			this.Basepagedriver=dr;
		}


	@FindBy(how=How.XPATH,using="//*[@value='CONNECTION']")
	@CacheLookup
	public WebElement Connection_button;
	
	@FindBy(how=How.XPATH,using="//*[@id='sidenav-main']/div/div[1]/div[1]/div/div")
	@CacheLookup
	public WebElement slider;
	
	
	
	@FindBy(how=How.XPATH,using="//*[@id='panel']/div[1]/div/div/div/div[1]/h6/span")
	@CacheLookup
	public WebElement Televente_title;
	
	@FindBy(how=How.XPATH,using="//*[@id='odi_status_dt']")
	@CacheLookup
	public WebElement odi_status_dt;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='tlvt_filters_form']/div/div[1]/div/div[1]/div")
	@CacheLookup
	public WebElement click_on_sectors_dropDown;
	
	@FindBy(how=How.XPATH,using="//*[@id='tlvt_filters_form']/div/div[1]/div/div[2]/div[2]/div[1]")
	@CacheLookup
	public WebElement select_all_sectors;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='tlvt_filters_form']/div/div[2]/div/div[1]/div")
	@CacheLookup
	public WebElement click_on_Managers_dropDown;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='tlvt_filters_form']/div/div[2]/div/div[2]/div[2]/div[1]")
	@CacheLookup
	public WebElement select_all_managers;
	
	@FindBy(how=How.XPATH,using="//*[@id='tlvt_filters_form']/div/div[3]/select[@id='tlvt_brand']")
	@CacheLookup
	public WebElement select_Brands;
	
	@FindBy(how=How.XPATH,using="//*[@id='tlvt_date']")
	@CacheLookup
	public WebElement select_Date;
	
	@FindBy(how=How.XPATH,using="//*[@id='btn_filters_reset']")
	@CacheLookup
	public WebElement btn_filters_reset;
	
	@FindBy(how=How.XPATH,using="//*[@id='btn_excel_export']")
	@CacheLookup
	public WebElement btn_excel_export;
	
	@FindBy(how=How.XPATH,using="//*[@id='tlvt_ranking']")
	@CacheLookup
	public WebElement tlvt_ranking;
	
	@FindBy(how=How.XPATH,using="//*[@id='end-toggle']/div[1]/label/span[1]")
	@CacheLookup
	public WebElement end_toggle;
	
	//global systhesis tabs for all Days
	
	@FindBy(how=How.XPATH,using="//*[@id='total_result_orders_txt']")
	@CacheLookup
	public WebElement total_result_orders_txt;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='total_result_turnover_txt']")
	@CacheLookup
	public WebElement total_result_turnover_txt;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='total_result_objective_txt']")
	@CacheLookup
	public WebElement total_result_objective_txt;
	

	@FindBy(how=How.XPATH,using="//*[@id='total_result_rate_txt']")
	@CacheLookup
	public WebElement total_result_rate_txt;
	
	
	
	//global systhesis tabs for selected Days
	
	@FindBy(how=How.XPATH,using="//*[@id='day_result_orders_txt']")
	@CacheLookup
	public WebElement day_result_orders_txt;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='day_result_turnover_txt']")
	@CacheLookup
	public WebElement day_result_turnover_txt;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='day_result_objective_txt']")
	@CacheLookup
	public WebElement day_result_objective_txt;
	

	@FindBy(how=How.XPATH,using="//*[@id='day_result_rate_txt']")
	@CacheLookup
	public WebElement day_result_rate_txt;
	
	
	
	
	
	
	
	
	
	
	
}
