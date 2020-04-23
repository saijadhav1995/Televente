package testCases;

import org.testng.annotations.Test;

import pages.VerifyRankingPage;
import webBase.BaseTest;

public class RankingPage extends BaseTest{
	
	VerifyRankingPage ranking=new VerifyRankingPage();
	
	@Test(priority='0')
	public void RankingFunctionality() throws Throwable {
		
		ranking.rankingPage("Verify Ranking Functionality");
		ranking.verifyRankingByAgency();
		ranking.verifyAarticleRanking();
		ranking.verifyRankingBySellers();
		ranking.verifyRankingBySellersWithCustomers();
		ranking.verifyRankingBySellersWithDistinctOrders();
		ranking.verifyRankingBySellersRegionalArticles();
		ranking.verifyRankingBySellersNationalArticles();
		ranking.verifyRankingBySellersMBI();
		ranking.verifyRankingByCDV();
		ranking.verifyRankingBySupplierAppro();
		ranking.verifyRankingBySupplierProducer();
		ranking.verifyRankingBySector();
		ranking.verifyRankingBySite();
		ranking.verifyRankingBySpeciality();
		
		
	}
	

}
