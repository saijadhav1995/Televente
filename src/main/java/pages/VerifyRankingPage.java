package pages;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.AppstringsConstant;
import Utility.RankingRelatedQueries;
import webBase.BasePage;
import webBase.BaseTest;
import webBase.DataBase;
import webElements_Identifiers.RankingPage;
import webElements_Identifiers.SettingTabs;

public class VerifyRankingPage extends BasePage{

	public ExtentTest logger;	
	public ExtentTest extentest;
	public SoftAssert SAssert = new SoftAssert();
	public PageFactory pf=new PageFactory();
	public  DataBase dataBase = new DataBase();

	BaseTest baseT = new BaseTest();
	String className = "";
	RankingPage ranking=new RankingPage(driver);
	AppstringsConstant appConst =new AppstringsConstant(); 
	public static	RankingRelatedQueries ranking_related_queries=new RankingRelatedQueries();
	
	

	public void rankingPage(String TestName) throws Throwable {
		
		logger = baseT.extent.startTest(TestName);		
		ranking=	PageFactory.initElements(driver, RankingPage.class);
		createDirectory("TELEVENTE"+TestName); 
		
		ranking.Connection_button.click();
		ranking.slider.click();
		
		
		driver.navigate().to(appConst.Ranking_URL);

		logger
			.log(LogStatus.PASS,"user redirected to ranking page"
 				+logger
 				.addScreenCapture(captureScreenShot(driver, "ranking page checked")));
			
String Televente_title= ranking.Televente_title.getText();
	
System.out.println(Televente_title);

String odi_status_dt= ranking.odi_status_dt.getText();
		
System.out.println(odi_status_dt);

	// checked all filters	
		ranking.click_on_sectors_dropDown.click();
		ranking.select_all_sectors.click();
		ranking.click_on_Managers_dropDown.click();
		ranking.select_all_managers.click();
		ranking.select_Brands.click();
		Select select=new Select(ranking.select_Brands);
		select.selectByValue("186");
		ranking.select_Date.sendKeys("2020-01-08");
		ranking.select_Date.sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		
		
		
		
		// global systhesis tabs
		
	String total_result_orders_txt =ranking.total_result_orders_txt.getText();
	String total_result_turnover_txt =ranking.total_result_turnover_txt.getText();
	String total_result_objective_txt =ranking.total_result_objective_txt.getText();
	String total_result_rate_txt =ranking.total_result_rate_txt.getText();
	
	String total_result_turnover=total_result_turnover_txt.replace(" ", "");
	String total_result_turnover1=total_result_turnover.replace(",", ".");

	String total_result_rate= total_result_rate_txt.replace(",", ".");
	
	System.out.println(total_result_orders_txt);
	System.out.println(total_result_turnover1);
	System.out.println(total_result_objective_txt);
	System.out.println(total_result_rate);
	
	
	
//	int total_result_orders_int= Integer.parseInt(total_result_orders_txt);
	
	
	String day_result_orders_txt =ranking.day_result_orders_txt.getText();
	String day_result_turnover_txt =ranking.day_result_turnover_txt.getText();
	String day_result_objective_txt =ranking.day_result_objective_txt.getText();
	String day_result_rate_txt =ranking.day_result_rate_txt.getText();
	
	String day_result_turnover=day_result_turnover_txt.replace(" ", "");
	String day_result_turnover1=day_result_turnover.replace(",", ".");

	String day_result_rate= day_result_rate_txt.replace(",", ".");
	
	String day_result_objective= day_result_objective_txt.replace(",", ".");
		
	System.out.println(day_result_orders_txt);
	System.out.println(day_result_turnover1);
	System.out.println(day_result_objective);
	System.out.println(day_result_rate);
		
	
	System.out.println(ranking_related_queries.Ranking_Total_GlobalSythesisTabQuery);
	
		
	
		
		
		String query = ranking_related_queries.Ranking_Total_GlobalSythesisTabQuery;
		
		ResultSet data = dataBase.getData(query);
		System.out.println(data);
		while(data.next()){
			System.out.println(data.getString(1)+"| "+data.getString(2)+"| "+data.getString(3)+"| "+data.getString(4)
			+"|"+data.getString(5));
			 
			
			
			if(total_result_orders_txt.equalsIgnoreCase(data.getString(1))) {
				
				System.out.println("total orders is matched");
			}else {
				
				System.out.println("nothing");
			}
			
				
			
			if (total_result_turnover1.equalsIgnoreCase(data.getString(2))) {
				
				System.out.println("total turnover is matched");
			}else {
				
				System.out.println("fail");
			}
			
			
			if (total_result_objective_txt.equalsIgnoreCase(data.getString(3))) {
				
				System.out.println("total objective is matched");
			}else {
				
				System.out.println("fail");
			}
			
			
			if (total_result_rate.equalsIgnoreCase(data.getString(4))) {
				
				System.out.println("total rate is matched");
			}else {
				
				System.out.println(" total rate fail");
			}
		
				
		}
		
		String query1=ranking_related_queries.Ranking_Day_GlobalSythesisTabQuery;
		
		ResultSet data1 = dataBase.getData(query1);
		
		System.out.println(data1);
		while(data1.next()){
			System.out.println(data1.getString(1)+"| "+data1.getString(2)+"| "+data1.getString(3)+"| "+data1.getString(4)
			+"|"+data1.getString(5));
		
	
if(day_result_orders_txt.equalsIgnoreCase(data1.getString(1))) {
				
				System.out.println("day orders is matched");
			}else {
				
				System.out.println("nothing");
			}
			
				
			
			if (day_result_turnover1.equalsIgnoreCase(data1.getString(2))) {
				
				System.out.println("day turnover is matched");
			}else {
				
				System.out.println("fail");
			}
			
			
			if (day_result_objective_txt.equalsIgnoreCase(data1.getString(3))) {
				
				System.out.println("day objective is matched");
			}else {
				
				System.out.println("fail");
			}
			
			
			if (day_result_rate.equalsIgnoreCase(data1.getString(4))) {
				
				System.out.println("day rate is matched");
			}else {
				
				System.out.println(" day rate fail");
			}
		
	
		}	
	
		
		
	
		
	}	
	

	//agency ranking

	public void verifyRankingByAgency() throws Throwable {
		
		System.out.println("Ranking By agency");
		ranking.tlvt_ranking.click();
		
		Select select1=new Select(ranking.tlvt_ranking);
		select1.selectByValue("2");
		
		ResultSet data2 = dataBase.getData(ranking_related_queries.agency_Ranking_Query);
	
		//sql loop
		
		
		
		
		  int attempts = 0;
		    while(attempts < 2) {
		        try {
		           
		        	
		    	int count= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]")).size();
		    		
		        	
		    System.out.println(count+"count");
		        	
		    	
		        	Thread.sleep(2000);
		        		
		               List<WebElement> agencynames= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]"));	
		        	
		               List<WebElement> results= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[3]"));	
				        
		               
		               while(data2.next()){
		               
		               for(WebElement getAgency:agencynames ) {
		            					    		
		            	   for(WebElement getResults:results ) {
		            		   
		            	  
				        		
			    			String agencytext=getAgency.getText();
			    			
			    			String resultstext=getResults.getText().replace(",", ".");
			    			
			    			String newresultstext=resultstext.replaceAll("[^0-9.]", "");
				    		
			    			
			    		
			    			
			    			 if (agencytext.equalsIgnoreCase(data2.getString(1)) && newresultstext.equalsIgnoreCase(data2.getString(2)) ) {
			    				 System.out.println(data2.getString(1)+"| "+data2.getString(2));		 							    		
			    				 System.out.println(agencytext +"|"+newresultstext);
			    				 System.out.println("Pass");
			    				 break;
			    			 	}
		            	   
		            	   }   	
		            	   
		            	   
		               }      
		        	
		            }
		        		} catch(StaleElementReferenceException e) {
		        		
		        		
		        }
		        attempts++;
		        
		    }
			
	}
	
	
    public void verifyAarticleRanking() throws Throwable {
		
		
    	System.out.println("Ranking By Article");	
    	ranking.tlvt_ranking.click();
		
		Select select1=new Select(ranking.tlvt_ranking);
		select1.selectByValue("9");
		
		ResultSet data3 = dataBase.getData(ranking_related_queries.Article_Ranking_Query);
					
	//sql loop
		
		
		int count= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]")).size()+1;
		
    	
    	System.out.println(count+"count");
    		Thread.sleep(3000);
    	
    			int counter=1;
 
    	
    			while(count>counter) {
    				
    				while(data3.next()){  

    						

    							JavascriptExecutor js=(JavascriptExecutor)driver;
	

		    	
	WebElement  Articlenames= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[2]"));	
	 
	WebElement  ArticleType= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[3]"));	
	   
	
    WebElement  results= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[4]"));	
   
    String castArticlenames = (String) js.executeScript("return arguments[0].innerText;",Articlenames);

    String castArticleType = (String) js.executeScript("return arguments[0].innerText;",ArticleType);
    
    String castresults = (String) js.executeScript("return arguments[0].innerText;",results);
    
    
    

    String[] arrayArticle= castArticlenames.split(" - ");

    String articleCode= arrayArticle[0];

String resultstext=castresults.replace(",", ".");
String getresutls=resultstext.replaceAll("[^0-9.]", "");

System.out.println(articleCode+" "+getresutls+"test");


	
		System.out.println(data3.getString(2)+"|"+data3.getString(3)+"|"+data3.getString(5)+" DB");

	if (articleCode.equalsIgnoreCase(data3.getString(2)) 
			&& castArticleType.equalsIgnoreCase(data3.getString(4))
			&& getresutls.equalsIgnoreCase(data3.getString(5)) ) {

		System.out.println(articleCode+"|"+data3.getString(2)+"|"+data3.getString(4)+"|"+castArticleType
				+"|"+ getresutls+"|"+data3.getString(5)+"sellers data matched");
		
			
		
	}else {
		
		System.out.println(articleCode+"|"+data3.getString(2)+"|"+data3.getString(4)
		+"|"+castArticleType+"|"+ getresutls+"|"+data3.getString(5)
		+"Row has Same total amount");
	
	}
	
	break;	



    		}   
 
    				counter=counter+1;    
    				 
    				System.out.println(counter);
            
    	}
	      	
	   	
}
	   
	   
    		      
	        	
	//ranking By sellers 

	
		
    public void verifyRankingBySellers() throws Throwable {
		
    	System.out.println("Ranking By Sellers");
		ranking.tlvt_ranking.click();
		
		Select select1=new Select(ranking.tlvt_ranking);
		select1.selectByValue("1");
		
		ResultSet data4 = dataBase.getData(ranking_related_queries.RankingBySellers_Query);
		
		int count= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]")).size()+1;
		
    	
    	System.out.println(count+"count");
    Thread.sleep(3000);
    	
    	int counter=1;
 
    	
	 	while(count>counter) {
	
	 	 	
	 		 while(data4.next()){  	
	 		   
	 		
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
   // Thread.sleep(2000);
	   
	
	WebElement  SellersNames= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[2]"));	
	
    WebElement  results= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[3]"));	
   
    String castSellersNames = (String) js.executeScript("return arguments[0].innerText;",SellersNames);

    String castresults = (String) js.executeScript("return arguments[0].innerText;",results);
    
    
    System.out.println(castSellersNames+ castresults +"print");

    
    String[] arrayArticle= castSellersNames.split(" - ");
    
     
    String SellersCode= arrayArticle[0];
   
    String resultstext=castresults.replace(",", ".");
    String getresutls=resultstext.replaceAll("[^0-9.]", "");
    
    
    if (SellersCode.equalsIgnoreCase(data4.getString(1)) && getresutls.equalsIgnoreCase(data4.getString(3)) ) {
		

    	 System.out.println(data4.getString(1)+"|"+data4.getString(2)+"|"+data4.getString(3)+" DB");     	
    	System.out.println(SellersCode +"|"+ getresutls+"sellers data matched");
		 
	 	}
   
    break;
    
    	}	
	 		 counter=counter+1;    
	 	    System.out.println(counter+"counter");
	 	   
		
  }	
 }	
  //ranking By sellers with customer

    public void verifyRankingBySellersWithCustomers() throws Throwable {
		
		
    	System.out.println("ranking By sellers with customers");
		 
		ranking.tlvt_ranking.click();
		
		Select select1=new Select(ranking.tlvt_ranking);
		select1.selectByValue("6");
		
		ResultSet data5 = dataBase.getData(ranking_related_queries.RankingBySellersAndNoOFCutomers_Query);
		
		int count= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]")).size()+1;
		
    	
    	System.out.println(count+"count");
    Thread.sleep(3000);
    	
    	int counter=1;

while(count>counter) {

	while(data5.next()){ 
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
   // Thread.sleep(2000);
	
	WebElement  SellersNames= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[2]"));	
	
	WebElement  total_customers= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[3]"));	
	  	
    WebElement  results= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[4]"));	
   
    String castSellersNames = (String) js.executeScript("return arguments[0].innerText;",SellersNames);

    String CastTotalcustomers = (String) js.executeScript("return arguments[0].innerText;",total_customers);
    
    String castresults = (String) js.executeScript("return arguments[0].innerText;",results);
    
    
    
    
    System.out.println(castSellersNames+ CastTotalcustomers+castresults +"print");

    
    String[] arrayArticle= castSellersNames.split(" - ");
    
      
    String SellersCode= arrayArticle[0];
   
    String resultstext=castresults.replace(",", ".");
    String getresutls=resultstext.replaceAll("[^0-9.]", "");
    
    
    if (SellersCode.equalsIgnoreCase(data5.getString(1)) && CastTotalcustomers.equalsIgnoreCase(data5.getString(4))
    		&& getresutls.equalsIgnoreCase(data5.getString(3)) ) {

    	 System.out.println(data5.getString(1)+"|"+data5.getString(2)+"|"+data5.getString(3)+"|"+data5.getString(4)+" DB");     	
    	System.out.println(SellersCode +"|" +CastTotalcustomers+"|"+ getresutls+"sellers data matched");
		 
	 }
   
    break;
     
    	}	
	
	counter=counter+1;    
    System.out.println(counter+"counter");
  
  }	
 }	
    
  //ranking By sellers with distinct orders
    
 public void verifyRankingBySellersWithDistinctOrders() throws Throwable {
		
 	System.out.println("ranking By sellers with distinct orders");		
		
		ranking.tlvt_ranking.click();
		
		Select select1=new Select(ranking.tlvt_ranking);
		select1.selectByValue("5");
		
		ResultSet data6 = dataBase.getData(ranking_related_queries.RankingBySellersAndDistinctOrders_Query);
		
		int count= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]")).size()+1;
		
    	
    	System.out.println(count+"count");
    Thread.sleep(3000);
    	
    	int counter=1;
 
 
while(count>counter) {

	 while(data6.next()){  	

	JavascriptExecutor js=(JavascriptExecutor)driver;
	
   // Thread.sleep(2000);
    	
	WebElement  SellersNames= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[2]"));	
	
	WebElement  total_orders= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[3]"));	
	  	
    WebElement  results= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[4]"));	
   
    String castSellersNames = (String) js.executeScript("return arguments[0].innerText;",SellersNames);

    String CastTotalOrders = (String) js.executeScript("return arguments[0].innerText;",total_orders);
    
    String castresults = (String) js.executeScript("return arguments[0].innerText;",results);
    
    
    
    
    System.out.println(castSellersNames+ CastTotalOrders+castresults +"print");

    
    String[] arrayArticle= castSellersNames.split(" - ");
      
    String SellersCode= arrayArticle[0];
   
    String resultstext=castresults.replace(",", ".");
    String getresutls=resultstext.replaceAll("[^0-9.]", "");
    
    
    if (SellersCode.equalsIgnoreCase(data6.getString(1)) && CastTotalOrders.equalsIgnoreCase(data6.getString(4))
    		&& getresutls.equalsIgnoreCase(data6.getString(3)) ) {
		
    	System.out.println(data6.getString(1)+"|"+data6.getString(2)+"|"+data6.getString(3)+"|"+data6.getString(4)+" DB");     	
    	System.out.println(SellersCode +"|" +CastTotalOrders+"|"+ getresutls+"sellers data matched ");
    	

	 }
   
	 break;   
    
    	}	
	 counter=counter+1;    
	    System.out.println(counter+"counter");
	   	
  }	
 }	
    
    
    //ranking By sellers with Regional Articles
 
 public void verifyRankingBySellersRegionalArticles() throws Throwable {
		

	 System.out.println("ranking By sellers with Regional Articles");		

		ranking.tlvt_ranking.click();
		
		Select select1=new Select(ranking.tlvt_ranking);
		select1.selectByValue("13");
		
		ResultSet data6 = dataBase.getData(ranking_related_queries.RankingBySellers_RegionalArticles_Query);
		
		int count= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]")).size()+1;
		
 	
 System.out.println(count+"count");
 Thread.sleep(3000);
 	
 	int counter=1;

 	
 	
     	
while(count>counter) {

	while(data6.next()){  	

	JavascriptExecutor js=(JavascriptExecutor)driver;
	
   // Thread.sleep(2000);
	    	
	WebElement  ArticleNames= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[2]"));	
	
 WebElement  results= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[3]"));	

 String castSellersNames = (String) js.executeScript("return arguments[0].innerText;",ArticleNames);
 
 String castresults = (String) js.executeScript("return arguments[0].innerText;",results);
 
 
 
 
 System.out.println(castSellersNames+castresults +"print");

 
 String[] arrayArticle= castSellersNames.split(" - ");
 
 	   
 String SellersCode= arrayArticle[0];

 String resultstext=castresults.replace(",", ".");
 String getresutls=resultstext.replaceAll("[^0-9.]", "");
 
 
 if (SellersCode.equalsIgnoreCase(data6.getString(1))&& getresutls.equalsIgnoreCase(data6.getString(3)) ) {
		
	 System.out.println(data6.getString(1)+"|"+data6.getString(2)+"|"+data6.getString(3)+"|"+" DB");
	 System.out.println(SellersCode +"|"+ getresutls+"sellers data matched ");
 	
	 }

 break;
 

 	}	
	 counter=counter+1;    
	 System.out.println(counter+"counter");
		
	}	
}	
  
 
	//ranking By Sellers MBI
 
 public void verifyRankingBySellersMBI() throws Throwable {
		
		
	 System.out.println("//ranking By Sellers MBI");		
		ranking.tlvt_ranking.click();
		
		Select select1=new Select(ranking.tlvt_ranking);
		select1.selectByValue("12");
		
		ResultSet data7 = dataBase.getData(ranking_related_queries.RankingBySellersMBI_Query);
		
		int count= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[1]")).size()+1;
		
	
System.out.println(count+"count");
Thread.sleep(3000);
	
	int counter=1;

	
	
  	
while(count>counter) {

	while(data7.next()){  	

	JavascriptExecutor js=(JavascriptExecutor)driver;
	
// Thread.sleep(2000);
	    	
	WebElement  ManagersName= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[2]"));	
	
WebElement  NumberOfOrders= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[3]"));	

WebElement  MontantMBI= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[4]"));	

WebElement  PercentageMBI= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[5]"));

WebElement  results= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[6]"));	

String castManagersName = (String) js.executeScript("return arguments[0].innerText;",ManagersName);

String castNumberOfOrders = (String) js.executeScript("return arguments[0].innerText;",NumberOfOrders);

String castMontantMBI = (String) js.executeScript("return arguments[0].innerText;",MontantMBI);

String castPercentageMBI = (String) js.executeScript("return arguments[0].innerText;",PercentageMBI);

String castresults = (String) js.executeScript("return arguments[0].innerText;",results);






String[] arrayManagers= castManagersName.split(" - ");


//manager code
String SellersCode= arrayManagers[0];
//total amount
String resultstext=castresults.replace(",", ".");
String getresutls=resultstext.replaceAll("[^0-9.]", "");
//montant mbi
String castMontantMBIText=castMontantMBI.replace(",", ".");
String getcastMontantMBIText=castMontantMBIText.replaceAll("[^0-9.]", "");
//mbi percentage
String castPercentageMBIText=castPercentageMBI.replace(",", ".");
String getcastPercentageMBIText=castPercentageMBIText.replaceAll("[^0-9.]", "");

System.out.println(castManagersName+" "+castNumberOfOrders+" "+getcastMontantMBIText+" "+getcastPercentageMBIText+" "+getresutls +"print");


if (SellersCode.equalsIgnoreCase(data7.getString(1))
		&& getresutls.equalsIgnoreCase(data7.getString(3)) 
		&& castNumberOfOrders.equalsIgnoreCase(data7.getString(4))
		&& getcastMontantMBIText.equalsIgnoreCase(data7.getString(5))
		&&	getcastPercentageMBIText.equalsIgnoreCase(data7.getString(6))	
	) {
		
	
	 System.out.println(data7.getString(1)+"|"+data7.getString(2)
	 +"|"+data7.getString(3)+"|"+data7.getString(4)+"|"+data7.getString(5)+data7.getString(6)+" DB");
	
	 System.out.println(SellersCode+"|"+data7.getString(1)+"|"+castNumberOfOrders+"|"+
	 data7.getString(4)+"|"+getcastMontantMBIText+"|"+data7.getString(5)+"|"+getcastPercentageMBIText
	 +"|"+data7.getString(6)+"|"+getresutls+"|"+data7.getString(3)+"sellers data matched");
	
	 }

break;


	}	
	 counter=counter+1;    
	 System.out.println(counter+"counter");
		
	}	
}	
 
 
 
//ranking By CDV manager
 
public void verifyRankingByCDV() throws Throwable {
		
	System.out.println("//ranking By CDV manager");	
	
		ranking.tlvt_ranking.click();
		
		Select select1=new Select(ranking.tlvt_ranking);
		select1.selectByValue("14");
		
		ResultSet data7 = dataBase.getData(ranking_related_queries.rankingByManager_Query);
		
		int count= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[1]")).size()+1;
		
	
System.out.println(count+"count");
Thread.sleep(3000);
	
	int counter=1;

	
	
 	
while(count>counter) {

	while(data7.next()){  	

	JavascriptExecutor js=(JavascriptExecutor)driver;
	
//Thread.sleep(2000);
	    	
	WebElement  ManagersName= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[2]"));	
	
WebElement  NumberOfOrders= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[3]"));	

WebElement  ObjectiveF= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[4]"));	

WebElement  Tax= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[5]"));

WebElement  results= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[6]"));	

String castManagersName = (String) js.executeScript("return arguments[0].innerText;",ManagersName);

String castNumberOfOrders = (String) js.executeScript("return arguments[0].innerText;",NumberOfOrders);

String castObjectiveF = (String) js.executeScript("return arguments[0].innerText;",ObjectiveF);

String castTax = (String) js.executeScript("return arguments[0].innerText;",Tax);

String castresults = (String) js.executeScript("return arguments[0].innerText;",results);






String[] arrayManagers= castManagersName.split(" - ");


//manager code
String SellersCode= arrayManagers[0];
//total amount
String resultstext=castresults.replace(",", ".");
String getresutls=resultstext.replaceAll("[^0-9.]", "");
//montant mbi
String castObjectiveFText=castObjectiveF.replace(",", ".");
String getcastObjectiveFText=castObjectiveFText.replaceAll("[^0-9.]", "");
//mbi percentage
String castTaxText=castTax.replace(",", ".");
String getcastTaxText=castTaxText.replaceAll("[^0-9.]", "");

System.out.println(castManagersName+" "+castNumberOfOrders+" "+getcastObjectiveFText+" "+getcastTaxText+" "+getresutls +"print");


if (SellersCode.equalsIgnoreCase(data7.getString(1))
		&& getresutls.equalsIgnoreCase(data7.getString(3)) 
		&& castNumberOfOrders.equalsIgnoreCase(data7.getString(4))
		&& getcastObjectiveFText.equalsIgnoreCase(data7.getString(5))
		&&	getcastTaxText.equalsIgnoreCase(data7.getString(6))	
	) {
		
	
	 System.out.println(data7.getString(1)+"|"+data7.getString(2)
	 +"|"+data7.getString(3)+"|"+data7.getString(4)+data7.getString(5)+data7.getString(6)+" DB");
	
	 System.out.println(SellersCode+"|"+data7.getString(1)+"|"+castNumberOfOrders+"|"+
	 "|"+data7.getString(4)+getcastObjectiveFText+"|"+data7.getString(5)+"|"+getcastTaxText
	 +"|"+data7.getString(6)+"|"+getresutls+"|"+data7.getString(3)+"sellers data matched");
	
	 }

break;


	}	
	 counter=counter+1;    
	 System.out.println(counter+"counter");
		
	}	
}	

//ranking By supplier Appro

public void verifyRankingBySupplierAppro() throws Throwable {
	
	
	System.out.println("ranking By supplier Appro");
	ranking.tlvt_ranking.click();
	
	Select select1=new Select(ranking.tlvt_ranking);
	select1.selectByValue("7");
	
	ResultSet data6 = dataBase.getData(ranking_related_queries.RankingBySupplierAppro_Query);
	
	int count= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[1]")).size()+1;
	
	
System.out.println(count+"count");
Thread.sleep(3000);
	
	int counter=1;

	
	
 	
while(count>counter) {

while(data6.next()){  	

JavascriptExecutor js=(JavascriptExecutor)driver;

// Thread.sleep(2000);
    	
WebElement  SupplierNames= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[2]"));	

WebElement  results= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[3]"));	

String castSupplierNames = (String) js.executeScript("return arguments[0].innerText;",SupplierNames);

String castresults = (String) js.executeScript("return arguments[0].innerText;",results);




System.out.println(castSupplierNames+castresults +"print");


String[] arraySupplierCode= castSupplierNames.split(" - ");

	   
String SellersCode= arraySupplierCode[0];

String resultstext=castresults.replace(",", ".");
String getresutls=resultstext.replaceAll("[^0-9.]", "");


if (SellersCode.equalsIgnoreCase(data6.getString(1))&& getresutls.equalsIgnoreCase(data6.getString(3)) ) {
	
 System.out.println(data6.getString(1)+"|"+data6.getString(2)+"|"+data6.getString(3)+"|"+" DB");
 System.out.println(SellersCode +"|"+ getresutls+"sellers data matched ");
	
 }

break;


	}	
 counter=counter+1;    
 System.out.println(counter+"counter");
	
	}	
}	

//ranking By Supplier producers

public void verifyRankingBySupplierProducer() throws Throwable {
	
	System.out.println("//ranking By Supplier producers");

	ranking.tlvt_ranking.click();
	
	Select select1=new Select(ranking.tlvt_ranking);
	select1.selectByValue("8");
	
	ResultSet data6 = dataBase.getData(ranking_related_queries.RankingBySupplierProducer_Query);
	
	int count= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[1]")).size()+1;
	
	
System.out.println(count+"count");
Thread.sleep(3000);
	
	int counter=1;

	
	
 	
while(count>counter) {

while(data6.next()){  	

JavascriptExecutor js=(JavascriptExecutor)driver;

// Thread.sleep(2000);
    	
WebElement  SupplierNames= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[2]"));	

WebElement  results= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[3]"));	

String castSupplierNames = (String) js.executeScript("return arguments[0].innerText;",SupplierNames);

String castresults = (String) js.executeScript("return arguments[0].innerText;",results);




System.out.println(castSupplierNames+castresults +"print");


String[] arraySupplierCode= castSupplierNames.split(" - ");

	   
String SellersCode= arraySupplierCode[0];

String resultstext=castresults.replace(",", ".");
String getresutls=resultstext.replaceAll("[^0-9.]", "");


if (SellersCode.equalsIgnoreCase(data6.getString(2))&& getresutls.equalsIgnoreCase(data6.getString(3)) ) {
	
 System.out.println(data6.getString(2)+"|"+data6.getString(3)+"|"+data6.getString(4)+"|"+" DB");
 System.out.println(SellersCode +"|"+ getresutls+"sellers data matched ");
	
 }

break;


	}	
 counter=counter+1;    
 System.out.println(counter+"counter");
	
	}	
}	

 
//ranking By sectors

public void verifyRankingBySector() throws Throwable {
	
	System.out.println("ranking By sectors");
	
	ranking.tlvt_ranking.click();
	
	Select select1=new Select(ranking.tlvt_ranking);
	select1.selectByValue("4");
	
	ResultSet data7 = dataBase.getData(ranking_related_queries.RankingBySector_Query);
	
	int count= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[1]")).size()+1;
	

System.out.println(count+"count");
Thread.sleep(3000);

int counter=1;



	
while(count>counter) {

while(data7.next()){  	

JavascriptExecutor js=(JavascriptExecutor)driver;

//Thread.sleep(2000);
    	
WebElement  SectorName= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[2]"));	


WebElement  ObjectiveF= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[3]"));	

WebElement  Tax= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[4]"));

WebElement  results= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[5]"));	

String castSectorName = (String) js.executeScript("return arguments[0].innerText;",SectorName);

String castObjectiveF = (String) js.executeScript("return arguments[0].innerText;",ObjectiveF);

String castTax = (String) js.executeScript("return arguments[0].innerText;",Tax);

String castresults = (String) js.executeScript("return arguments[0].innerText;",results);






String[] arraySector= castSectorName.split(" - ");

for (String string : arraySector) {

System.out.println(string);
	
}


//manager code
String SellersCode= arraySector[0];
//total amount
String resultstext=castresults.replace(",", ".");
String getresutls=resultstext.replaceAll("[^0-9.]", "");
//montant mbi
String castObjectiveFText=castObjectiveF.replace(",", ".");
String getcastObjectiveFText=castObjectiveFText.replaceAll("[^0-9.]", "");
//mbi percentage
String castTaxText=castTax.replace(",", ".");
String getcastTaxText=castTaxText.replaceAll("[^0-9.]", "");

System.out.println(castSectorName+" "+getcastObjectiveFText+" "+getcastTaxText+" "+getresutls +"print");


if (SellersCode.equalsIgnoreCase(data7.getString(2))
	&& getresutls.equalsIgnoreCase(data7.getString(4)) 
	&& getcastObjectiveFText.equalsIgnoreCase(data7.getString(5))
	&&	getcastTaxText.equalsIgnoreCase(data7.getString(6))	
) {
	

 System.out.println(data7.getString(1)+"|"+data7.getString(2)
 +"|"+data7.getString(3)+"|"+data7.getString(4)+data7.getString(5)+data7.getString(6)+" DB");

 System.out.println(SellersCode+"|"+data7.getString(2)+"|"+getcastObjectiveFText
+"|"+data7.getString(5)+"|"+getcastTaxText
 +"|"+data7.getString(6)+"|"+getresutls+"|"+data7.getString(4)+"sellers data matched");

 }

break;


}	
 counter=counter+1;    
 System.out.println(counter+"counter");
	
	}	
}	


//Ranking By Site
public void verifyRankingBySite() throws Throwable {
	

	System.out.println("ranking By site");

	ranking.tlvt_ranking.click();
	
	Select select1=new Select(ranking.tlvt_ranking);
	select1.selectByValue("3");
	
	ResultSet data7 = dataBase.getData(ranking_related_queries.RankingBySite_Query);
	
	int count= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[1]")).size()+1;
	

System.out.println(count+"count");
Thread.sleep(3000);

int counter=1;



	
while(count>counter) {

while(data7.next()){  	

JavascriptExecutor js=(JavascriptExecutor)driver;

//Thread.sleep(2000);
    	
WebElement  SiteName= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[2]"));	


WebElement  ObjectiveF= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[3]"));	

WebElement  Tax= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[4]"));

WebElement  results= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[5]"));	

String castSiteName = (String) js.executeScript("return arguments[0].innerText;",SiteName);

String castObjectiveF = (String) js.executeScript("return arguments[0].innerText;",ObjectiveF);

String castTax = (String) js.executeScript("return arguments[0].innerText;",Tax);

String castresults = (String) js.executeScript("return arguments[0].innerText;",results);






String[] arraySite= castSiteName.split(" - ");


//manager code
String SellersCode= arraySite[0];
//total amount
String resultstext=castresults.replace(",", ".");
String getresutls=resultstext.replaceAll("[^0-9.]", "");
//montant mbi
String castObjectiveFText=castObjectiveF.replace(",", ".");
String getcastObjectiveFText=castObjectiveFText.replaceAll("[^0-9.]", "");
//mbi percentage
String castTaxText=castTax.replace(",", ".");
String getcastTaxText=castTaxText.replaceAll("[^0-9.]", "");

System.out.println(SellersCode+" "+getcastObjectiveFText+" "+getcastTaxText+" "+getresutls +"print");


if (SellersCode.equalsIgnoreCase(data7.getString(2))
	&& getresutls.equalsIgnoreCase(data7.getString(4)) 
	&& getcastObjectiveFText.equalsIgnoreCase(data7.getString(5))
	&&	getcastTaxText.equalsIgnoreCase(data7.getString(6))	
) {
	

 System.out.println(data7.getString(1)+"|"+data7.getString(2)
 +"|"+data7.getString(3)+"|"+data7.getString(4)+data7.getString(5)+data7.getString(6)+" DB");

 System.out.println(SellersCode+"|"+data7.getString(2)+"|"+getcastObjectiveFText
+"|"+data7.getString(5)+"|"+getcastTaxText
 +"|"+data7.getString(6)+"|"+getresutls+"|"+data7.getString(4)+"sellers data matched");

 }

break;


}	
 counter=counter+1;    
 System.out.println(counter+"counter");
	
	}	
}	



//ranking By Speciality

public void verifyRankingBySpeciality() throws Throwable {
	
	System.out.println("ranking By speciality");

	
	ranking.tlvt_ranking.click();
	
	Select select1=new Select(ranking.tlvt_ranking);
	select1.selectByValue("10");
	
	ResultSet data6 = dataBase.getData(ranking_related_queries.RankingBySpeciality_Query);
	
	int count= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[1]")).size()+1;
	
	
System.out.println(count+"count");
Thread.sleep(3000);
	
	int counter=1;

	
	
	
while(count>counter) {

while(data6.next()){  	

JavascriptExecutor js=(JavascriptExecutor)driver;

//Thread.sleep(2000);
  	
WebElement  SpecialityNames= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[2]"));	

WebElement  results= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[3]"));	

String castSpecialityNames = (String) js.executeScript("return arguments[0].innerText;",SpecialityNames);

String castresults = (String) js.executeScript("return arguments[0].innerText;",results);




System.out.println(castSpecialityNames+castresults +"print");



String resultstext=castresults.replace(",", ".");
String getresutls=resultstext.replaceAll("[^0-9.]", "");


if (castSpecialityNames.equalsIgnoreCase(data6.getString(1))&& getresutls.equalsIgnoreCase(data6.getString(2)) ) {
	
System.out.println(data6.getString(1)+"|"+data6.getString(2)+"|"+" DB");
System.out.println(castSpecialityNames +"|"+ getresutls+"sellers data matched ");
	
}

break;


	}	
counter=counter+1;    
System.out.println(counter+"counter");
	
	}	
}	


    
}	
