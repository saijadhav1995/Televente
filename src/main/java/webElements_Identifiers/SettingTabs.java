package webElements_Identifiers;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Utility.SettingTabsData;
import webBase.BasePage;
import webBase.Controller;

public class SettingTabs {
	
	SettingTabsData settingtabsData=new SettingTabsData();
	public static WebDriver Basepagedriver=null;

	public   SettingTabs(WebDriver dr) {
			
		BasePage.Basepagedriver = Controller.InvokeWebDriver();
			this.Basepagedriver=dr;
		}

	
	//agency Tab 
	
	@FindBy(how=How.XPATH,using="//*[@class='col-md-3 text-right heading']/a[@class='btn btn-outline-primary']")
	@CacheLookup
	public WebElement SettingButton;
	

	
	@FindBy(how=How.XPATH,using="//*[@id='agenciesTab']/a")
	@CacheLookup
	public WebElement AgencyTab;
	
	@FindBy(how=How.XPATH,using="//*[@id='sellersTab']/a")
	@CacheLookup
	public WebElement SellersTab;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='articlesTab']/a")
	@CacheLookup
	public WebElement articlesTab;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='suppliersTab']/a")
	@CacheLookup
	public WebElement suppliersTab;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='totalObjective']")
	@CacheLookup
	public WebElement Total_DailyObjective;
	
	@FindBy(how=How.XPATH,using="//*[@id='btn_agency_save']/span[2]")
	@CacheLookup	
	public WebElement SaveButton;
	
	@FindBy(how=How.XPATH,using="//*[@id='btn_expandAll']/span[2]")
	@CacheLookup	
	public WebElement btn_expandAll;
	
	@FindBy(how=How.XPATH,using="//*[@id='btn_collapseAll']/span[2]")
	@CacheLookup	
	public WebElement btn_collapseAll;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='agencies_data_alert_message']/div/strong")
	@CacheLookup	
	public WebElement agencies_data_alert_message;
	
	
	
	
	
	//sector 


	@FindBy(how=How.XPATH,using="//*[@id='agencies_form']/div/div/ul/li[@data-id='248']/i")
	@CacheLookup
	public WebElement clickOnExpandCollapseButtonOfSector;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='agencies_form']/div/div/ul/li[@data-id='248']/label/input[1]")
	@CacheLookup
	public WebElement clickOncheckBoxButtonOfSector;
	

	@FindBy(how=How.XPATH,using="//*[@id='agencies_form']/div/div/ul/li[@data-id='248']/label/input[2]")
	@CacheLookup
	public WebElement clickOnSectorAmountfieldOfSector;
	
	//Site
	
	
	@FindBy(how=How.XPATH,using="//*[@id='site-950']/i")
	@CacheLookup
	public WebElement clickOnExpandCollapseButtonOfSite;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='site-950']/label/input[1]")
	@CacheLookup
	public WebElement clickOncheckBoxButtonOfSite;
	

	@FindBy(how=How.XPATH,using="//*[@id='site-950']/label/input[2]")
	@CacheLookup
	public WebElement clickOnSectorAmountfieldOfSite;

	
	
	
	// get all sites & agencies for specific sector.
	@FindBy(how=How.XPATH,using="//*[@id='agencies_form']/div/div/ul/li/label")
	@CacheLookup
	public List<WebElement> getAllSectors;
	
	
	
	@FindBy(how=How.XPATH,using="//*[@id='sec-278']/ul/li/label")
	@CacheLookup
	public List<WebElement> getAllSites;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='site-317']/ul/li/label")
	@CacheLookup
	public List<WebElement> getAllAgency;
	
	
	
	
	
	//ATC_CDV tab
	
	
	
	@FindBy(how=How.XPATH,using="//*[@id='btn_seller_add']")
	@CacheLookup
	public WebElement btn_seller_add;
	
	@FindBy(how=How.XPATH,using="//*[@id='btn-save-sellers']")
	@CacheLookup
	public WebElement btn_save_sellers;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='sellers_table_filter']/label/input")
	@CacheLookup
	public WebElement rechercherField;
	
	
	
	
	public WebElement getSettingButton() {
		return SettingButton;
	}

	
	
	public WebElement getAgencyTab() {
		return AgencyTab;
	}	
	
	public WebElement getSellersTab() {
		return SellersTab;
	}

	public WebElement getArticleTab() {
		return articlesTab;
	}

	public WebElement getSupplierTab() {
		return suppliersTab;
	}



	public List<WebElement> getAllSectors1() {
		// TODO Auto-generated method stub
		return getAllSectors;
	}



	


	
	
	
}
