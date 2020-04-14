package testCases;

import org.testng.annotations.Test;

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
	
	
	@Test(priority='0')
	public void VerifySettingPage() throws Throwable {
	
	setting.AgencyTab("agencyTabFunctionality");	
	Atc_cdv.ATC_CDV_Tab("ATC_CDV_tabFunctionality");
	article.artilceTab("Verify Article Tab Functionlity");	
	supplier_producer.supplierProducerTab("Verify supplliers producer Tab Functionlity");
	supplier_appro.supplierApproTab("Verify supplliers transporter Tab Functionlity");
		
	}	
	
	
	
}
