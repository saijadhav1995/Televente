package webElements_Identifiers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Utility.RankingRelatedQueries;
import webBase.BasePage;
import webBase.Controller;

public class BillingPage extends BasePage {
	
	RankingRelatedQueries settingtabsData=new RankingRelatedQueries();
	public static WebDriver Basepagedriver=null;

	public  BillingPage(WebDriver dr) {
			
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
	
	
	@FindBy(how=How.XPATH,using="//*[@id='tlvt_axis']")
	@CacheLookup
	public WebElement tlvt_axis;
	
	@FindBy(how=How.XPATH,using="//*[@id='tlvt_sector']")
	@CacheLookup
	public WebElement tlvt_sector;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='tlvt_sellManager']")
	@CacheLookup
	public WebElement tlvt_sellManager;
	
	@FindBy(how=How.XPATH,using="//*[@id='tlvt_seller']")
	@CacheLookup
	public WebElement tlvt_seller;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='btn_apply_filter']/span")
	@CacheLookup
	public WebElement btn_apply_filter;
	
	

	@FindBy(how=How.XPATH,using="//*[@id='btn_filters_reset']/span")
	@CacheLookup
	public WebElement btn_filters_reset;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='btn_excel_export']/span")
	@CacheLookup
	public WebElement btn_excel_export;
	
	
	
	
	
	
	
	
	
}
