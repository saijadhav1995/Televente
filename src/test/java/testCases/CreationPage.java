package testCases;

import org.testng.annotations.Test;


import pages.VerifyCreationPage;
import pages.VerifyHome;
import webBase.BaseTest;

public class CreationPage extends BaseTest {

	VerifyCreationPage creation=new VerifyCreationPage();
		
	@Test(priority='0')
	public void VerifyCreationForm() throws Throwable {
		
		
		creation.clickOnCreationButton("TeleventeCreation functionality");
		creation.VerifyRegionDropDown();
		creation.VerifyTeleventeName();
		creation.VerifyobjectiveField();
		creation.VerifyRankingAndBrandField();
		creation.VerifyStartDate();
		creation.VerifyEndDate();
		creation.VerifyDailyObjective();
		creation.saveFunctionality();
	}
	
	
		

	
	
}
