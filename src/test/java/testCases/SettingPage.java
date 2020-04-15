package testCases;

import org.testng.annotations.Test;

import pages.VerifyHome;
import pages.VerifySettingPage_ATC_CDV_Tab;
import pages.VerifySettingPage_ArticlesTab;
import pages.VerifySettingPage_Supplier_ApproTab;
import pages.VerifySettingPage_Supplier_producerTab;
import pages.VerifySettingPage_agencyTab;
import webBase.BaseTest;



public class SettingPage extends BaseTest{

	VerifySettingPage_agencyTab setting=new VerifySettingPage_agencyTab();
	VerifySettingPage_ATC_CDV_Tab Atc_cdv=new VerifySettingPage_ATC_CDV_Tab();
	VerifySettingPage_ArticlesTab article=new VerifySettingPage_ArticlesTab();
	VerifySettingPage_Supplier_producerTab supplier_producer=new VerifySettingPage_Supplier_producerTab();
	VerifySettingPage_Supplier_ApproTab supplier_appro=new VerifySettingPage_Supplier_ApproTab();
	VerifyHome home=new VerifyHome();
	
	
	@Test(priority='0')
	public void VerifyagencyTab() throws Throwable {
	
	setting.AgencyTab("agencyTabFunctionality");					
	}	
	
	@Test(priority='1')
	public void VerifySellersManagerTab() throws Throwable {	
		Atc_cdv.ATC_CDV_Tab("ATC_CDV_tabFunctionality");
		Atc_cdv.rechercherField();
		//home.VerifyPaginationArrows();
		Atc_cdv.sortingArrows();
		Atc_cdv.paginationDropDown();
		Atc_cdv.deleteArticles();
	
	}
	
	@Test(priority='2')
	public void VerifyArticlesTab() throws Throwable {	
		article.artilceTab("Verify Article Tab Functionlity");
		article.rechercherField();
		//home.VerifyPaginationArrows();
		article.sortingArrows();
		article.paginationDropDown();
		article.deleteArticles();
	
	}
	
	
	@Test(priority='3')
	public void VerifysupplierProducerTab() throws Throwable {	
		supplier_producer.supplierProducerTab("Verify suppliers producer Tab Functionlity");
		supplier_producer.rechercherField();
		//home.VerifyPaginationArrows();
		supplier_producer.sortingArrows();
		supplier_producer.paginationDropDown();
		supplier_producer.deleteArticles();
	
	}
	
	@Test(priority='4')
	public void VerifysupplierApproTab() throws Throwable {	
		supplier_appro.supplierApproTab("Verify suppliers transporter Tab Functionlity");
		supplier_appro.rechercherField();
		//home.VerifyPaginationArrows();
		supplier_appro.sortingArrows();
		supplier_appro.paginationDropDown();
		supplier_appro.deleteArticles();
	
	}
	
	
	
}
