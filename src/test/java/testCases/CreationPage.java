package testCases;

import org.testng.annotations.Test;


import pages.VerifyCreationPage;
import pages.VerifyEditPage;
import pages.VerifyHome;
import webBase.BaseTest;

public class CreationPage extends BaseTest {

	VerifyCreationPage creation=new VerifyCreationPage();
	VerifyEditPage Edit =new VerifyEditPage();
		
	@Test(priority='0')
	public void VerifyCreationForm() throws Throwable {
		
		
		creation.clickOnCreationButton("Televente Creation functionality");
		creation.VerifyRegionDropDown();
		creation.VerifyTeleventeName();
		creation.VerifyobjectiveField();
		creation.VerifyRankingAndBrandField();
		creation.VerifyStartDate();
		creation.VerifyEndDate();
		creation.VerifyDailyObjective();
		creation.saveFunctionality();
		Edit.regionFieldOnEditForm(" Verify  Edit Form");
		Edit.VerifyNomFieldOnEditForm();
		Edit.VerifyStartDateOnEditForm();
		Edit.VerifyEndDateOnEditForm();
		Edit.VerifyObjectiveFOnEditForm();
		Edit.VerifyDailyAmountOnEditForm();
		Edit.VerifyRankingFieldOnEditForm();
		Edit.VerifyBrandFieldOnEditForm();
		Edit.clickOnSaveButton();
	}
	
	
		

	
	
}
