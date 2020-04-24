package testCases;

import org.testng.annotations.Test;

import pages.VerifyBillingPage;
import webBase.BaseTest;

public class BillingPage extends BaseTest {

	VerifyBillingPage billing=new VerifyBillingPage();
	
	@Test(priority='0')
	public void billingFunctionality() throws Throwable {
	
	billing.billingPage("Verify Billing functionality");
	billing.verifyGlobalBillingSynthesisTab();
	billing.verifySellViewOfSector();
	}
}
