package testCases;

import org.testng.annotations.Test;

import pages.VerifyRankingPage;
import webBase.BaseTest;

public class RankingPage extends BaseTest{
	
	VerifyRankingPage ranking=new VerifyRankingPage();
	
	@Test(priority='0')
	public void RankingFunctionality() throws Throwable {
		
		ranking.rankingPage("Verify Ranking Functionality");
		
	}
	

}
