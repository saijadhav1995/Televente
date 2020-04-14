package testCases;

import org.testng.annotations.Test;

import pages.VerifySettingPage_ATC_CDV_Tab;
import pages.VerifySettingPage_agencyTab;
import webBase.BaseTest;



public class SettingPage extends BaseTest{

	VerifySettingPage_agencyTab setting=new VerifySettingPage_agencyTab();
	VerifySettingPage_ATC_CDV_Tab Atc_cdv=new VerifySettingPage_ATC_CDV_Tab();
	
	@Test(priority='0')
	public void VerifySettingPage() throws Throwable {
	
	//	setting.AgencyTab("agencyTabFunctionality");

		Atc_cdv.ATC_CDV_Tab("ATC_CDV_tabFunctionality");
	}	
	
	
	
}
