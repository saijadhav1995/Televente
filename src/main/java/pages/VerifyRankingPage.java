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
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.AppstringsConstant;
import Utility.Helper;
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
	public Helper helper=new Helper();

	BaseTest baseT = new BaseTest();
	String className = "";
	RankingPage ranking=new RankingPage(driver);
	AppstringsConstant appConst =new AppstringsConstant(); 
	public static RankingRelatedQueries ranking_related_queries=new RankingRelatedQueries();
	
	

	public void rankingPage(String TestName) throws Throwable {
		
		logger = baseT.extent.startTest(TestName);		
		ranking=	PageFactory.initElements(driver, RankingPage.class);
		createDirectory("TELEVENTE"+TestName); 
		
		ranking.Connection_button.click();
		ranking.slider.click();
		
		
		driver.navigate().to(appConst.Ranking_URL);

		logger
			.log(LogStatus.PASS,"1:user redirected to ranking page"
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
				
		String query = ranking_related_queries.Ranking_Total_GlobalSythesisTabQuery;
		
		ResultSet data = dataBase.getData(query);
		System.out.println(data);
		while(data.next()){
			System.out.println(data.getString(1)+"| "+data.getString(2)+"| "+data.getString(3)+"| "+data.getString(4)
			+"|"+data.getString(5));
			 
			
			if(Televente_title.equalsIgnoreCase(ranking_related_queries.televente_name)) {
				
				helper.javaScriptHighlightWebElement(ranking.Televente_title);
				
				logger
				.log(LogStatus.PASS,"1:compairing actual title with expected title"+"<br/>"
				+"<b><font color='green'>Result:Televente Title has been verified<font/>"
				+logger
	 				.addScreenCapture(captureScreenShot(driver, "Televente Title has been verified")));
				helper.javaScriptUn_HighlightWebElement(ranking.Televente_title);

				
			}else {
				helper.javaScriptHighlightWebElement(ranking.Televente_title);

				logger
				.log(LogStatus.FAIL,"1:compairing actual title with expected title"+"<br/>"
				+"<b><font color='red'>Result:Televente Title Does not matched to expected title<font/>"
	 				+logger
	 				.addScreenCapture(captureScreenShot(driver, "Televente Title Does not matched")));
				helper.javaScriptUn_HighlightWebElement(ranking.Televente_title);

				
			}
			
			if(odi_status_dt.equalsIgnoreCase(data.getString(5))) {
			
				helper.javaScriptHighlightWebElement(ranking.odi_status_dt);

				
				logger
				.log(LogStatus.PASS,"1:Actual ODI Execution date is"+"<b>"+odi_status_dt+"</b>"+"<br/>"
						+"2:Expected ODI_date is "+"<b>"+data.getString(5)+"</b>"+"From odi_data Table "+"<br/>"
				+"<b><font color='green'>Result:ODI Execution date has been verified<font/>"
	 				+logger
	 				.addScreenCapture(captureScreenShot(driver, "ODI Execution date has been verified")));
				helper.javaScriptUn_HighlightWebElement(ranking.odi_status_dt);

				
			}else {
				helper.javaScriptHighlightWebElement(ranking.odi_status_dt);

				logger
				.log(LogStatus.FAIL,"1:Actual ODI Execution date"+"<b>"+odi_status_dt+"</b>"+"<br/>"
						+"2: Expected ODI_date is "+"<b>"+data.getString(5)+"</b>"+" From odi_data Table "+"<br/>"
				+"<b><font color='red'>Result:ODI Execution date Does not matched<font/>"
	 				+logger
	 				.addScreenCapture(captureScreenShot(driver, "ODI Execution date Does not matched")));
				helper.javaScriptUn_HighlightWebElement(ranking.odi_status_dt);

			}
			
			
			if(total_result_orders_txt.equalsIgnoreCase(data.getString(1))) {
				
				helper.javaScriptHighlightWebElement(ranking.total_result_orders_txt);

				System.out.println("total orders is matched");
				logger
				.log(LogStatus.PASS,"1:Actual Total no. of orders "+"<b>"+total_result_orders_txt+"</b>"+"<br/>"
						+"2:Expected Total no.of orders "+"<b>"+data.getString(1)+"</b>"+" From orders Table"+"<br/>"
				+"<b><font color='green'>Result:Total no. of orders has been verified<font/>"
	 				+logger
	 				.addScreenCapture(captureScreenShot(driver, "total orders has been verified")));
				helper.javaScriptUn_HighlightWebElement(ranking.total_result_orders_txt);

				
			}else {
				
				helper.javaScriptHighlightWebElement(ranking.total_result_orders_txt);

				logger
				.log(LogStatus.FAIL,"1:Actual Total no. of orders "+"<b>"+total_result_orders_txt+"</b>"+"<br/>"
						+"2: Expected Total no.of orders "+"<b>"+data.getString(1)+"</b>"+" From orders Table"+"<br/>"
				+"<b><font color='red'>Result:Total no.of orders Does not matched<font/>"
	 				+logger
	 				.addScreenCapture(captureScreenShot(driver, "Total no.of orders Does not matched")));
				helper.javaScriptUn_HighlightWebElement(ranking.total_result_orders_txt);
	
				System.out.println("missmatched");
			}
			
				
			
			if (total_result_turnover1.equalsIgnoreCase(data.getString(2))) {
				
				helper.javaScriptHighlightWebElement(ranking.total_result_turnover_txt);

				System.out.println("total turnover is matched");
				logger
				.log(LogStatus.PASS,"1:Actual compairing Total results(CA)  "+"<b>"+total_result_turnover1+"</b>"+"<br/>"
						+"2: Expected Total results(CA) "+"<b>"+data.getString(2)+"</b>"+" From orders Table"+"<br/>"
				+"<b><font color='green'>Result:Total results(CA) has been verified<font/>"
	 				+logger
	 				.addScreenCapture(captureScreenShot(driver, "Total results has been verified")));
				helper.javaScriptUn_HighlightWebElement(ranking.total_result_turnover_txt);

			
			
			}else {
				
				helper.javaScriptHighlightWebElement(ranking.total_result_turnover_txt);

				logger
				.log(LogStatus.FAIL,"1:Actual compairing Total results(CA)  "+"<b>"+total_result_turnover1+"</b>"+"<br/>"
						+"2:Expected Total results(CA) "+"<b>"+data.getString(2)+"</b>"+" From orders Table"+"<br/>"
				+"<b><font color='red'>Result:Total results(CA) Does not matched<font/>"
	 				+logger
	 				.addScreenCapture(captureScreenShot(driver, "Total resultsDoes not matched")));
				
				helper.javaScriptUn_HighlightWebElement(ranking.total_result_turnover_txt);

				System.out.println("fail");
			}
			
			
			if (total_result_objective_txt.equalsIgnoreCase(data.getString(3))) {
				
				helper.javaScriptHighlightWebElement(ranking.total_result_objective_txt);

				logger
				.log(LogStatus.PASS,"1:Actual Total ObjectiveF "+"<b>"+total_result_objective_txt+"</b>"+"<br/>"
						+"2:Expected Total ObjectiveF "+"<b>"+data.getString(3)+"</b>"+" From orders Table"+"<br/>"
				+"<b><font color='green'>Result:Total ObjectiveF has been verified<font/>"
	 				+logger
	 				.addScreenCapture(captureScreenShot(driver, "Total ObjectiveF has been verified")));
				helper.javaScriptUn_HighlightWebElement(ranking.total_result_objective_txt);

				
				
				System.out.println("total objective is matched");
			}else {
			
				helper.javaScriptHighlightWebElement(ranking.total_result_objective_txt);

				logger
				.log(LogStatus.FAIL,"1:Actual Total ObjectiveF "+"<b>"+total_result_objective_txt+"</b>"+"<br/>"
						+"2:Expected Total ObjectiveF "+"<b>"+data.getString(3)+"</b>"+" From orders Table"+"<br/>"
				+"<b><font color='red'>Result:Total ObjectiveF Does not matched<font/>"
	 				+logger
	 				.addScreenCapture(captureScreenShot(driver, "Total ObjectiveF Does not matched")));
				helper.javaScriptUn_HighlightWebElement(ranking.total_result_objective_txt);

				System.out.println("fail");
			}
			
			
			if (total_result_rate.equalsIgnoreCase(data.getString(4))) {
				
				helper.javaScriptHighlightWebElement(ranking.total_result_rate_txt);

				logger
				.log(LogStatus.PASS,"1:Actual Total TAUX "+"<b>"+total_result_rate+"</b>"+"<br/>"
						+"2:Expected Total TAUX "+"<b>"+data.getString(4)+"</b>"+" From orders Table"+"<br/>"
				+"<b><font color='green'>Result:Total TAUX has been verified<font/>"
	 				+logger
	 				.addScreenCapture(captureScreenShot(driver, "Total TAUX has been verified")));
				helper.javaScriptUn_HighlightWebElement(ranking.total_result_rate_txt);

				System.out.println("Total RATE is matched");
			}else {
				
				helper.javaScriptHighlightWebElement(ranking.total_result_rate_txt);

				logger
				.log(LogStatus.FAIL,"1:Actual Total TAUX "+"<b>"+total_result_rate+"</b>"+"<br/>"
						+"2:Expected Total TAUX "+"<b>"+data.getString(4)+"</b>"+" From orders Table"+"<br/>"
				+"<b><font color='red'>Result:Total TAUX Does not matched<font/>"
	 				+logger
	 				.addScreenCapture(captureScreenShot(driver, "Total TAUX Does not matched")));
				helper.javaScriptUn_HighlightWebElement(ranking.total_result_rate_txt);

				System.out.println(" total rate fail");
			}
		
				
		}
		
		String query1=ranking_related_queries.Ranking_Day_GlobalSythesisTabQuery;
		
		ResultSet data1 = dataBase.getData(query1);
		
		while(data1.next()){
			System.out.println(data1.getString(1)+"| "+data1.getString(2)+"| "+data1.getString(3)+"| "+data1.getString(4)
			+"|"+data1.getString(5));
		
	
if(day_result_orders_txt.equalsIgnoreCase(data1.getString(1))) {
	
	helper.javaScriptHighlightWebElement(ranking.day_result_orders_txt);

	logger
	.log(LogStatus.PASS,"1:Actual Day no. of orders "+"<b>"+day_result_orders_txt+"</b>"+"<br/>"
			+"2:xpected Day no.of orders "+"<b>"+data1.getString(1)+"</b>"+"From orders Table"+"<br/>"
	+"<b><font color='green'>Result: Day no. of orders has been verified<font/>"
			+logger
			.addScreenCapture(captureScreenShot(driver, "Day orders has been verified")));
	
	helper.javaScriptUn_HighlightWebElement(ranking.day_result_orders_txt);

	
	System.out.println("day orders is matched");
			}else {
	
				helper.javaScriptHighlightWebElement(ranking.day_result_orders_txt);

				logger
				.log(LogStatus.FAIL,"1:Actual Day no. of orders "+"<b>"+day_result_orders_txt+"</b>"+"<br/>"
						+"2:Expected Total no.of orders "+"<b>"+data1.getString(1)+"</b>"+"From orders Table"+"<br/>"
				+"<b><font color='red'>Result: Day no.of orders Does not matched<font/>"
	 				+logger
	 				.addScreenCapture(captureScreenShot(driver, "Day no.of orders Does not matched")));
				helper.javaScriptUn_HighlightWebElement(ranking.day_result_orders_txt);
				
				System.out.println("nothing");
			}
			
				
			
			if (day_result_turnover1.equalsIgnoreCase(data1.getString(2))) {

				helper.javaScriptHighlightWebElement(ranking.day_result_turnover_txt);

				logger
				.log(LogStatus.PASS,"1:Actual Day results(CA)  "+"<b>"+day_result_turnover1+"</b>"+"<br/>"
						+"2: Expected Day results(CA) "+"<b>"+data1.getString(2)+"</b>"+" From orders Table"+"<br/>"
				+"<b><font color='green'>Result: Day results(CA) has been verified<font/>"
	 				+logger
	 				.addScreenCapture(captureScreenShot(driver, "Day results has been verified")));

				helper.javaScriptUn_HighlightWebElement(ranking.day_result_turnover_txt);
				
				System.out.println("day turnover is matched");
			}else {

				helper.javaScriptHighlightWebElement(ranking.day_result_turnover_txt);
	
				logger
				.log(LogStatus.FAIL,"1:compairing Day results(CA)  "+"<b>"+day_result_turnover1+"</b>"+"<br/>"
						+"2: Expected Day results(CA) "+"<b>"+data1.getString(2)+"</b>"+" From orders Table"+"<br/>"
				+"<b><font color='red'>Result: Day results(CA) Does not matched<font/>"
	 				+logger
	 				.addScreenCapture(captureScreenShot(driver, "Day resultsDoes not matched")));
				
				helper.javaScriptUn_HighlightWebElement(ranking.day_result_turnover_txt);
				System.out.println("fail");
			}
			
			
			if (day_result_objective.equalsIgnoreCase(data1.getString(3))) {
				
				helper.javaScriptHighlightWebElement(ranking.day_result_objective_txt);

				logger
				.log(LogStatus.PASS,"1:compairing Day ObjectiveF "+"<b>"+day_result_objective+"</b>"+"<br/>"
						+"2: Expected Day ObjectiveF "+"<b>"+data1.getString(3)+"</b>"+" From orders Table"+"<br/>"
				+"<b><font color='green'>Result: Day ObjectiveF has been verified<font/>"
	 				+logger
	 				.addScreenCapture(captureScreenShot(driver, "Day ObjectiveF has been verified")));
			
				helper.javaScriptUn_HighlightWebElement(ranking.day_result_objective_txt);

				
				System.out.println("day objective is matched");
			}else {

				helper.javaScriptHighlightWebElement(ranking.day_result_objective_txt);

				logger
				.log(LogStatus.FAIL,"1:compairing Day ObjectiveF "+"<b>"+day_result_objective+"</b>"+"<br/>"
						+"2: Expected Day ObjectiveF "+"<b>"+data1.getString(3)+"</b>"+" From orders Table"+"<br/>"
				+"<b><font color='red'>Result: Day ObjectiveF Does not matched<font/>"
	 				+logger
	 				.addScreenCapture(captureScreenShot(driver, "Day ObjectiveF Does not matched")));
				
				helper.javaScriptUn_HighlightWebElement(ranking.day_result_objective_txt);

				System.out.println("fail");
			}
			
			
			if (day_result_rate.equalsIgnoreCase(data1.getString(4))) {
				
				helper.javaScriptHighlightWebElement(ranking.day_result_rate_txt);

				
				logger
				.log(LogStatus.PASS,"1:compairing Day TAUX "+"<b>"+day_result_rate+"</b>"+"<br/>"
						+"2: Expected Day TAUX "+"<b>"+data1.getString(4)+"</b>"+" From orders Table"+"<br/>"
				+"<b><font color='green'>Result: Day TAUX has been verified<font/>"
	 				+logger
	 				.addScreenCapture(captureScreenShot(driver, "Day TAUX has been verified")));
				
				helper.javaScriptUn_HighlightWebElement(ranking.day_result_rate_txt);

				
				System.out.println("day rate is matched");
			}else {
				
				helper.javaScriptHighlightWebElement(ranking.day_result_rate_txt);

				logger
				.log(LogStatus.FAIL,"1:compairing Day TAUX "+"<b>"+day_result_rate+"</b>"+"<br/>"
						+"2: Expected Day TAUX "+"<b>"+data1.getString(4)+"</b>"+" From orders Table"+"<br/>"		
				+"<b><font color='red'>Result: Day TAUX Does not matched<font/>"
	 				+logger
	 				.addScreenCapture(captureScreenShot(driver, "Day TAUX Does not matched")));
				
				helper.javaScriptUn_HighlightWebElement(ranking.day_result_rate_txt);

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
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		logger
		.log(LogStatus.INFO,"<b><u><font color='Blue'>1:Ranking By agency option is selected from Ranking Drop Down List<font/>");
		Thread.sleep(2000);
	
		
		 int countColumns= driver.findElements(By.xpath("//*[@id='ranking_table']/thead/tr/th")).size()+1;
		
		 
		 int countercolumn=1;
		// get columns  
		 while(countColumns>countercolumn) {
			 
				WebElement  columns= driver.findElement(By.xpath("//*[@id='ranking_table']/thead/tr/th["+countercolumn+"]"));	
				
			    String Castcolumns = (String) js.executeScript("return arguments[0].innerText;",columns);

				
			    System.out.println(Castcolumns);
			    
			    if(Castcolumns.equalsIgnoreCase(ranking_related_queries.Classement)) {

			    	logger
					.log(LogStatus.PASS,"1:compairing Row column name with expected Name"+"<br/>"
					+"<b><font color='green'>Result: CLASSEMENT column has been verified<font/>"
			    	+logger
	 				.addScreenCapture(captureScreenShot(driver, "CLASSEMENT is matched for agency")));

			    	System.out.println("row column name is verified");
			    }else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.agency)) {
			    

			    	logger
					.log(LogStatus.PASS,"1:compairing agency column name with expected Name"+"<br/>"
					+"<b><font color='green'>Result: agency column has been verified<font/>"
					+logger
	 				.addScreenCapture(captureScreenShot(driver, "agency is matched for agency")));		
			    	System.out.println("agency column name is verified");
			    	

			    	
			    }else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.results)) {
			    	

			    	logger
					.log(LogStatus.PASS,"1:compairing results column name with expected Name"+"<br/>"
					+"<b><font color='green'>Result: RESULTAT column has been verified<font/>"
			    	+logger
	 				.addScreenCapture(captureScreenShot(driver, "RESULTAT is matched for agency")));		
			

			    	System.out.println("result column name is verified");
			    }else {

			    	logger
					.log(LogStatus.FAIL,"1:"+Castcolumns+"column name is Missing"+"<br/>"
					+"<b><font color='red'>Result:column name is Missing<font/>"
			    	+logger
		 				.addScreenCapture(captureScreenShot(driver, "coulumn is missing in agency Ranking ")));		
		

			    	System.out.println(" column name is Missing");
			    }
			    
		countercolumn=countercolumn+1;
		 }
		 
		


		
		        	
//verify rows  	 
		 
		 int countRows= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]")).size(); 
		 
		 System.out.println( countRows+"Rows are present");
		 
		 logger
			.log(LogStatus.PASS,"<font color='green'>Result: No.of rows are <font/>"+"<b>"+countRows);
	    	
		 
		int count= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]")).size()+1;		
    	
    	System.out.println(count+"count");
    		Thread.sleep(3000);
    	
    			int counter=1;
 
    	
    			while(count>counter) {
    				
    				while(data2.next()){  
		    	
	WebElement  AgencyNames= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[2]"));	
	 
	WebElement  Results= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[3]"));	
	   
       
		            		   
	  String castAgencyNames = (String) js.executeScript("return arguments[0].innerText;",AgencyNames);

	    String castResults = (String) js.executeScript("return arguments[0].innerText;",Results);
 	  
				        		
			    			
			    			String resultstext=castResults.replace(",", ".");
			    			
			    			String newresultstext=resultstext.replaceAll("[^0-9.]", "");
				    		
			    			
			    		
			    			
			    			 if (castAgencyNames.equalsIgnoreCase(data2.getString(1))
			    					 && newresultstext.equalsIgnoreCase(data2.getString(2)) ) {
			    				 System.out.println(data2.getString(1)+"| "+data2.getString(2));		 							    		
			    				 System.out.println(castAgencyNames +"|"+newresultstext);
			    				 System.out.println("Pass");
			    				 
			    					logger.log(LogStatus.PASS,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
			    							+"2:Actual row Content On App is "+"<b>"+castAgencyNames+"|"+newresultstext+"</b>"+"<br/>"
			    							+"3:Expected row Content From DB is "+"<b>"+data2.getString(1)+" | "+data2.getString(2)+"</b>"+"<br/>"
			    							+"<b><font color='green'>Result:Row has been Matched <font/>");
			    				
			    			 	}else {
			    			 		
			    			 		logger.log(LogStatus.FAIL,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
			    							+"2:Actual row Content On App is "+"<b>"+castAgencyNames+"|"+newresultstext+"</b>"+"<br/>"
			    							+"3:Expected row Content From DB is "+"<b>"+data2.getString(1)+" | "+data2.getString(2)+"</b>"+"<br/>"
			    							+"<b><font color='Orange'>Result:either row has same total amount or data is missMatched <font/>");			    				
		            	   
		            	   }   	
			    			 
		            	  break; 
		            	  
		    				
		               }     
	            	 System.out.println(counter);
    				counter=counter+1;    

		            }
		        		
			
	}
	
	
    public void verifyAarticleRanking() throws Throwable {
		
		
    	System.out.println("Ranking By Article");	
    	ranking.tlvt_ranking.click();
		
		Select select1=new Select(ranking.tlvt_ranking);
		select1.selectByValue("9");
		
		ResultSet data3 = dataBase.getData(ranking_related_queries.Article_Ranking_Query);
	
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		logger
		.log(LogStatus.INFO,"<b><u><font color='Blue'>2:Ranking By Articles option is selected from Ranking Drop Down List<font/>");
		Thread.sleep(2000);
	
		
	//sql loop
		
		 int countColumns= driver.findElements(By.xpath("//*[@id='ranking_table']/thead/tr/th")).size()+1;
		
		 
		 int countercolumn=1;
		// get columns  
		 while(countColumns>countercolumn) {
			 
				WebElement  columns= driver.findElement(By.xpath("//*[@id='ranking_table']/thead/tr/th["+countercolumn+"]"));	
				
			    String Castcolumns = (String) js.executeScript("return arguments[0].innerText;",columns);

				
			    System.out.println(Castcolumns);
			    
			    if(Castcolumns.equalsIgnoreCase(ranking_related_queries.Classement)) {

			    	logger
					.log(LogStatus.PASS,"1:compairing Row column name with expected Name"+"<br/>"
					+"<b><font color='green'>Result: CLASSEMENT column has been verified<font/>"
			    	+logger
	 				.addScreenCapture(captureScreenShot(driver, "CLASSEMENT is matched for Article")));

			    	System.out.println("row column name is verified");
			    }else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.article)) {
			    

			    	logger
					.log(LogStatus.PASS,"1:compairing Article column name with expected Name"+"<br/>"
					+"<b><font color='green'>Result: ARTICLE column has been verified<font/>"
					+logger
	 				.addScreenCapture(captureScreenShot(driver, "ARTICLE is matched for Article")));		
			    	System.out.println("Article column name is verified");
			    	

			    	
			    }else if(Castcolumns.equalsIgnoreCase(ranking_related_queries.Type)) {
			    	
			    	

			    	logger
					.log(LogStatus.PASS,"1:compairing Type column name with expected Name"+"<br/>"
					+"<b><font color='green'>Result: TYPE column has been verified<font/>"
					+logger
	 				.addScreenCapture(captureScreenShot(driver, "TYPE is matched for Article")));		
			    	System.out.println("Article column name is verified");
			    	

			    	
			    }
			    else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.results)) {
			    	

			    	logger
					.log(LogStatus.PASS,"1:compairing results column name with expected Name"+"<br/>"
					+"<b><font color='green'>Result: RESULTAT column has been verified<font/>"
			    	+logger
	 				.addScreenCapture(captureScreenShot(driver, "RESULTAT is matched for Article")));		
			

			    	System.out.println("result column name is verified");
			    }else {

			    	logger
					.log(LogStatus.FAIL,"1:"+Castcolumns+"column name is Missing"+"<br/>"
					+"<b><font color='red'>Result:column name is Missing<font/>"
			    	+logger
		 				.addScreenCapture(captureScreenShot(driver, "coulumn is missing in Article Ranking ")));		
		

			    	System.out.println(" column name is Missing");
			    }
			    
		countercolumn=countercolumn+1;
		 }
		 
		
		 
		 
	//verify rows  	 
		 
		 int countRows= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]")).size(); 
		 
		 System.out.println( countRows+"Rows are present");
		 
		 logger
			.log(LogStatus.PASS,"<font color='green'>Result: No.of rows are <font/>"+"<b>"+countRows);
	    	
		 
		int count= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]")).size()+1;		
    	
    	System.out.println(count+"count");
    		Thread.sleep(3000);
    	
    			int counter=1;
 
    	
    			while(count>counter) {
    				
    				while(data3.next()){  
		    	
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

		logger.log(LogStatus.PASS,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
				+"2:Actual row Content On App is "+"<b>"+castArticlenames+"|"+castArticleType+"|"+getresutls+"</b>"+"<br/>"
				+"3:Expected row Content From DB is "+"<b>"+data3.getString(2)+" - "+data3.getString(3)+"|"+data3.getString(4)+"|"+data3.getString(5)+"</b>"+"<br/>"
				+"<b><font color='green'>Result:Row has been Matched <font/>");
	
		
		System.out.println(articleCode+"|"+data3.getString(2)+"|"+data3.getString(3)+"|"+data3.getString(4)+"|"+castArticleType
				+"|"+ getresutls+"|"+data3.getString(5)+"sellers data matched");
		
			
		
	}else {
		
		
		logger.log(LogStatus.INFO,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
				+"2:Actual row Content On App is "+"<b>"+castArticlenames+"|"+castArticleType+"|"+getresutls+"</b>"+"<br/>"
				+"3:Expected row Content From DB is "+"<b>"+data3.getString(2)+" - "+data3.getString(3)+"|"+data3.getString(4)+"|"+data3.getString(5)+"</b>"+"<br/>"
				+"<b><font color='orange'>Result:either Row has Same total amount or data is missmatched <font/>");
	
		
		System.out.println(articleCode+"|"+data3.getString(2)+"|"+data3.getString(4)
		+"|"+castArticleType+"|"+ getresutls+"|"+data3.getString(5)
		+"Row has Same total amount");
	
	}
	
	break;	



    		}   
    				System.out.println(counter);

    				counter=counter+1;    
    				 
            
    	}
	      	
	   	
}
	   
	   
    		      
	        	
	//ranking By sellers 

	
		
    public void verifyRankingBySellers() throws Throwable {
		
    	System.out.println("Ranking By Sellers");
		ranking.tlvt_ranking.click();
		
		Select select1=new Select(ranking.tlvt_ranking);
		select1.selectByValue("1");

		logger
		.log(LogStatus.INFO,"<b><u><font color='Blue'>3:Ranking By Sellers option is selected from Ranking Drop Down List<font/>");
    
		Thread.sleep(2000);
		
		//Ranking By Sellers column
		JavascriptExecutor js=(JavascriptExecutor)driver;
	
 int countColumns= driver.findElements(By.xpath("//*[@id='ranking_table']/thead/tr/th")).size()+1;
		
	System.out.println(countColumns+"sellers Count Row");	 
		 int countercolumn=1;
		// get columns  
		 while(countColumns>countercolumn) {
			 
				WebElement  columns= driver.findElement(By.xpath("//*[@id='ranking_table']/thead/tr/th["+countercolumn+"]"));	
				
			    String Castcolumns = (String) js.executeScript("return arguments[0].innerText;",columns);

				
			    System.out.println(Castcolumns);
			    
			    if(Castcolumns.equalsIgnoreCase(ranking_related_queries.Classement)) {

			    	logger
					.log(LogStatus.PASS,"1:compairing Row column name with expected Name"+"<br/>"
					+"<b><font color='green'>Result: CLASSEMENT column has been verified<font/>"
			    	+logger
	 				.addScreenCapture(captureScreenShot(driver, "CLASSEMENT is matched for Ranking By sellers")));

			    	System.out.println("row column name is verified");
			    }else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.ATC)) {
			    

			    	logger
					.log(LogStatus.PASS,"1:compairing ATC column name with expected Name"+"<br/>"
					+"<b><font color='green'>Result: ATC column has been verified<font/>"
					+logger
	 				.addScreenCapture(captureScreenShot(driver, "ATC is matched for Ranking By sellers")));		
			    	System.out.println("ATC column name is verified");
			    	

			    	
			    }else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.results)) {
			    	

			    	logger
					.log(LogStatus.PASS,"1:compairing results column name with expected Name"+"<br/>"
					+"<b><font color='green'>Result: RESULTAT column has been verified<font/>"
			    	+logger
	 				.addScreenCapture(captureScreenShot(driver, "RESULTAT is matched for Ranking By sellers")));		
			

			    	System.out.println("result column name is verified");
			    }else {
					
			    	logger
					.log(LogStatus.FAIL,"1:"+Castcolumns+"column name is Missing"+"<br/>"
					+"<b><font color='red'>Result:column name is Missing<font/>"
			    	+logger
		 				.addScreenCapture(captureScreenShot(driver, "coulumn is missing in Ranking By sellers ")));		
		

			    	System.out.println(" column name is Missing");
			    }
			    
		countercolumn=countercolumn+1;
		 }
		 

		
	//verify Rows	
		 
 int countRows= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]")).size(); 
		 
		 System.out.println( countRows+"Rows are present");
		 
		 logger
			.log(LogStatus.PASS,"<font color='green'>Result: No.of rows are <font/>"+"<b>"+countRows);
	    
		
		
		ResultSet data4 = dataBase.getData(ranking_related_queries.RankingBySellers_Query);
		
		int count= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]")).size()+1;
		
    	
    	System.out.println(count+"count");
    Thread.sleep(3000);
    	
    	int counter=1;
 
    	
	 	while(count>counter) {
	
	 	 	
	 		 while(data4.next()){  	
	 		   
	 		
	
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
    
    
    if (SellersCode.equalsIgnoreCase(data4.getString(1)) 
    		&& getresutls.equalsIgnoreCase(data4.getString(3)) ) {
		
    	
    	logger.log(LogStatus.PASS,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
				+"2:Actual row Content On App is "+"<b>"+castSellersNames+"|"+getresutls+"</b>"+"<br/>"
				+"3:Expected row Content From DB is "+"<b>"+data4.getString(1)+" - "+data4.getString(2)+"|"+data4.getString(3)+"</b>"+"<br/>"
				+"<b><font color='green'>Result:Row has been Matched <font/>");

    	 System.out.println(data4.getString(1)+"|"+data4.getString(2)+"|"+data4.getString(3)+" DB");     	
    	System.out.println(SellersCode +"|"+ getresutls+"sellers data matched");
		 
	 	}else {
	 		
	 		logger.log(LogStatus.FAIL,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
					+"2:Actual row Content On App is "+"<b>"+castSellersNames+"|"+getresutls+"</b>"+"<br/>"
					+"3:Expected row Content From DB is "+"<b>"+data4.getString(1)+" - "+data4.getString(2)+"|"+data4.getString(3)+"</b>"+"<br/>"
					+"<b><font color='Orange'>Result:either row has same total amount or data is missMatched <font/>");

	 		
	 	}
   
    break;
    
    	}	
		 	    System.out.println(counter+"counter");

	 		 counter=counter+1;    
	 	   
		
  }	
 }	
    
  //ranking By sellers with customer

    public void verifyRankingBySellersWithCustomers() throws Throwable {
		
		
    	System.out.println("ranking By sellers with customers");
		 
		ranking.tlvt_ranking.click();
		
		Select select1=new Select(ranking.tlvt_ranking);
		select1.selectByValue("6");

		logger
		.log(LogStatus.INFO,"<b><u><font color='Blue'>4:Ranking By Sellers With Customers option is selected from Ranking Drop Down List<font/>");
		Thread.sleep(2000);

		//verify coulmns
		JavascriptExecutor js=(JavascriptExecutor)driver;

 int countColumns= driver.findElements(By.xpath("//*[@id='ranking_table']/thead/tr/th")).size()+1;
		
		 
		 int countercolumn=1;
		// get columns  
		 while(countColumns>countercolumn) {
			 
				WebElement  columns= driver.findElement(By.xpath("//*[@id='ranking_table']/thead/tr/th["+countercolumn+"]"));	
				
			    String Castcolumns = (String) js.executeScript("return arguments[0].innerText;",columns);

				
			    System.out.println(Castcolumns);
			    
			    if(Castcolumns.equalsIgnoreCase(ranking_related_queries.Classement)) {

			    	logger
					.log(LogStatus.PASS,"1:compairing Row column name with expected Name"+"<br/>"
					+"<b><font color='green'>Result: CLASSEMENT column has been verified<font/>"
			    	+logger
	 				.addScreenCapture(captureScreenShot(driver, "CLASSEMENT is matched for Ranking By sellers client")));

			    	System.out.println("row column name is verified");
			    }else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.ATC)) {
			    

			    	logger
					.log(LogStatus.PASS,"1:compairing ATC column name with expected Name"+"<br/>"
					+"<b><font color='green'>Result: ATC column has been verified<font/>"
					+logger
	 				.addScreenCapture(captureScreenShot(driver, "ATC is matched for Ranking By sellers client")));		
			    	System.out.println("Article column name is verified");
			    	

			    	
			    }else if(Castcolumns.equalsIgnoreCase(ranking_related_queries.Nombre_clients)) {
			    	
			    	

			    	logger
					.log(LogStatus.PASS,"1:compairing Nombre_clients column name with expected Name"+"<br/>"
					+"<b><font color='green'>Result: Nombre_clients column has been verified<font/>"
					+logger
	 				.addScreenCapture(captureScreenShot(driver, "TYPE is matched for Ranking By sellers client")));		
			    	System.out.println("Nombre_clients column name is verified");
			    	

			    	
			    }
			    else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.results)) {
			    	

			    	logger
					.log(LogStatus.PASS,"1:compairing results column name with expected Name"+"<br/>"
					+"<b><font color='green'>Result: RESULTAT column has been verified<font/>"
			    	+logger
	 				.addScreenCapture(captureScreenShot(driver, "RESULTAT is matched forRanking By sellers client")));		
			

			    	System.out.println("result column name is verified");
			    }else {

			    	logger
					.log(LogStatus.FAIL,"1:"+Castcolumns+"column name is Missing"+"<br/>"
					+"<b><font color='red'>Result:column name is Missing<font/>"
			    	+logger
		 				.addScreenCapture(captureScreenShot(driver, "coulumn is missing in for Ranking By sellers client ")));		
		

			    	System.out.println(" column name is Missing");
			    }
			    
		countercolumn=countercolumn+1;
		 }
		 
		
		 

		//verify Rows	
		 
		 int countRows= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]")).size(); 
				 
				 System.out.println( countRows+"Rows are present");
				 
				 logger
					.log(LogStatus.PASS,"<font color='green'>Result: No.of rows are <font/>"+"<b>"+countRows);
					
		
		
		
		
		ResultSet data5 = dataBase.getData(ranking_related_queries.RankingBySellersAndNoOFCutomers_Query);
		
		int count= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]")).size()+1;
		
    	
    	System.out.println(count+"count");
    Thread.sleep(3000);
    	
    	int counter=1;

while(count>counter) {

	while(data5.next()){ 
	
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
    
    
    if (SellersCode.equalsIgnoreCase(data5.getString(1)) 
    		&& CastTotalcustomers.equalsIgnoreCase(data5.getString(4))
    		&& getresutls.equalsIgnoreCase(data5.getString(3)) ) {

    	
    	logger.log(LogStatus.PASS,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
				+"2:Actual row Content On App is "+"<b>"+castSellersNames+"|"+CastTotalcustomers+"|"+getresutls+"</b>"+"<br/>"
				+"3:Expected row Content From DB is "+"<b>"+data5.getString(1)+" - "+data5.getString(2)+"|"+data5.getString(3)+"|"+data5.getString(4)+"</b>"+"<br/>"
				+"<b><font color='green'>Result:Row has been Matched <font/>");

    	
    	 System.out.println(data5.getString(1)+"|"+data5.getString(2)+"|"+data5.getString(3)+"|"+data5.getString(4)+" DB");     	
    	System.out.println(SellersCode +"|" +CastTotalcustomers+"|"+ getresutls+"sellers data matched");
		 
	 }else {
		 logger.log(LogStatus.FAIL,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
					+"2:Actual row Content On App is "+"<b>"+castSellersNames+"|"+CastTotalcustomers+"|"+getresutls+"</b>"+"<br/>"
					+"3:Expected row Content From DB is "+"<b>"+data5.getString(1)+" - "+data5.getString(2)+"|"+data5.getString(3)+"|"+data5.getString(4)+"</b>"+"<br/>"
					+"<b><font color='red'>Result:either row has same total amount or data is missMatched <font/>");

		 
	 }
   
    break;
     
    	}	
	
    System.out.println(counter+"counter");

	counter=counter+1;    
  
  }	
 }	
    
  //ranking By sellers with distinct orders
    
 public void verifyRankingBySellersWithDistinctOrders() throws Throwable {
		
 	System.out.println("ranking By sellers with distinct orders");		
		
		ranking.tlvt_ranking.click();
		
		Select select1=new Select(ranking.tlvt_ranking);
		select1.selectByValue("5");
		logger
		.log(LogStatus.INFO,"<b><u><font color='Blue'>5:Ranking By Sellers With Distinct Orders option is selected from Ranking Drop Down List<font/>");
		Thread.sleep(2000);

		//verify coulmns
		JavascriptExecutor js=(JavascriptExecutor)driver;

		 int countColumns= driver.findElements(By.xpath("//*[@id='ranking_table']/thead/tr/th")).size()+1;
				
				 
				 int countercolumn=1;
				// get columns  
				 while(countColumns>countercolumn) {
					 
						WebElement  columns= driver.findElement(By.xpath("//*[@id='ranking_table']/thead/tr/th["+countercolumn+"]"));	
						
					    String Castcolumns = (String) js.executeScript("return arguments[0].innerText;",columns);

						
					    System.out.println(Castcolumns);
					    
					    if(Castcolumns.equalsIgnoreCase(ranking_related_queries.Classement)) {

					    	logger
							.log(LogStatus.PASS,"1:compairing Row column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: CLASSEMENT column has been verified<font/>"
					    	+logger
			 				.addScreenCapture(captureScreenShot(driver, "CLASSEMENT is matched for Ranking By sellers orders")));

					    	System.out.println("row column name is verified");
					    }else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.ATC)) {
					    

					    	logger
							.log(LogStatus.PASS,"1:compairing ATC column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: ATC column has been verified<font/>"
							+logger
			 				.addScreenCapture(captureScreenShot(driver, "ATC is matched for Ranking By sellers orders")));		
					    	System.out.println("Article column name is verified");
					    	

					    	
					    }else if(Castcolumns.equalsIgnoreCase(ranking_related_queries.Nombre_commandes)) {
					    	
					    	

					    	logger
							.log(LogStatus.PASS,"1:compairing Nombre_clients column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: Nombre_clients column has been verified<font/>"
							+logger
			 				.addScreenCapture(captureScreenShot(driver, "TYPE is matched for Ranking By sellers orders")));		
					    	System.out.println("Nombre_clients column name is verified");
					    	

					    	
					    }
					    else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.results)) {
					    	

					    	logger
							.log(LogStatus.PASS,"1:compairing results column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: RESULTAT column has been verified<font/>"
					    	+logger
			 				.addScreenCapture(captureScreenShot(driver, "RESULTAT is matched for Ranking By sellers orders ")));		
					

					    	System.out.println("result column name is verified");
					    }else {

					    	logger
							.log(LogStatus.FAIL,"1:"+Castcolumns+"column name is Missing"+"<br/>"
							+"<b><font color='red'>Result:column name is Missing<font/>"
					    	+logger
				 				.addScreenCapture(captureScreenShot(driver, "coulumn is missing in for Ranking By sellers orders")));		
				

					    	System.out.println(" column name is Missing");
					    }
					    
				countercolumn=countercolumn+1;
				 }
				 
				
				 
				//verify Rows	
				 
				 int countRows= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]")).size(); 
						 
						 System.out.println( countRows+"Rows are present");
						 
						 logger
							.log(LogStatus.PASS,"<font color='green'>Result: No.of rows are <font/>"+"<b>"+countRows);
					
		
		
		
		
		
		
		
		ResultSet data6 = dataBase.getData(ranking_related_queries.RankingBySellersAndDistinctOrders_Query);
		
		int count= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]")).size()+1;
		
    	
    	System.out.println(count+"count");
    Thread.sleep(3000);
    	
    	int counter=1;
 
 
while(count>counter) {

	 while(data6.next()){  	

	
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
		
    	
    	logger.log(LogStatus.PASS,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
				+"2:Actual row Content On App is "+"<b>"+castSellersNames+"|"+CastTotalOrders+"|"+getresutls+"</b>"+"<br/>"
				+"3:Expected row Content From DB is "+"<b>"+data6.getString(1)+" - "+data6.getString(2)+"|"+data6.getString(3)+"|"+data6.getString(4)+"</b>"+"<br/>"
				+"<b><font color='green'>Result:Row has been Matched <font/>");

    	
    	System.out.println(data6.getString(1)+"|"+data6.getString(2)+"|"+data6.getString(3)+"|"+data6.getString(4)+" DB");     	
    	System.out.println(SellersCode +"|" +CastTotalOrders+"|"+ getresutls+"sellers data matched ");
    	

	 }else {
		 
		 logger.log(LogStatus.FAIL,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
					+"2:Actual row Content On App is "+"<b>"+castSellersNames+"|"+CastTotalOrders+"|"+getresutls+"</b>"+"<br/>"
					+"3:Expected row Content From DB is "+"<b>"+data6.getString(1)+" - "+data6.getString(2)+"|"+data6.getString(3)+"|"+data6.getString(4)+"</b>"+"<br/>"
					+"<b><font color='orange'>Result:either row has same total amount or data is missMatched <font/>");

	 }
   
	 break;   
    
    	}
	 System.out.println(counter+"counter");
	   
	 counter=counter+1;    
	   	
  }	
 }	
    
    
    //ranking By sellers with Regional Articles
 
 public void verifyRankingBySellersRegionalArticles() throws Throwable {
		

	 System.out.println("ranking By sellers with Regional Articles");		

		ranking.tlvt_ranking.click();
		
		Select select1=new Select(ranking.tlvt_ranking);
		select1.selectByValue("13");
		logger
		.log(LogStatus.INFO,"<b><u><font color='Blue'>6:Ranking By Sellers Regional Articles option is selected from Ranking Drop Down List<font/>");
		Thread.sleep(2000);
		
		//verify coulmns
		JavascriptExecutor js=(JavascriptExecutor)driver;

		 int countColumns= driver.findElements(By.xpath("//*[@id='ranking_table']/thead/tr/th")).size()+1;
				
				 
				 int countercolumn=1;
				// get columns  
				 while(countColumns>countercolumn) {
					 
						WebElement  columns= driver.findElement(By.xpath("//*[@id='ranking_table']/thead/tr/th["+countercolumn+"]"));	
						
					    String Castcolumns = (String) js.executeScript("return arguments[0].innerText;",columns);

						
					    System.out.println(Castcolumns);
					    
					    if(Castcolumns.equalsIgnoreCase(ranking_related_queries.Classement)) {

					    	logger
							.log(LogStatus.PASS,"1:compairing Row column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: CLASSEMENT column has been verified<font/>"
					    	+logger
			 				.addScreenCapture(captureScreenShot(driver, "CLASSEMENT is matched for Ranking By regional Article")));

					    	System.out.println("row column name is verified");
					    }else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.ATC)) {
					    

					    	logger
							.log(LogStatus.PASS,"1:compairing ATC column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: ATC column has been verified<font/>"
							+logger
			 				.addScreenCapture(captureScreenShot(driver, "ATC is matched for Ranking By regional Article")));		
					    	System.out.println("Article column name is verified");
					    	

					    	
					    } else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.results)) {
					    	

					    	logger
							.log(LogStatus.PASS,"1:compairing results column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: RESULTAT column has been verified<font/>"
					    	+logger
			 				.addScreenCapture(captureScreenShot(driver, "RESULTAT is matched for Ranking By regional Article")));		
					

					    	System.out.println("result column name is verified");
					    }else {

					    	logger
							.log(LogStatus.FAIL,"1:"+Castcolumns+"column name is Missing"+"<br/>"
							+"<b><font color='red'>Result:column name is Missing<font/>"
					    	+logger
				 				.addScreenCapture(captureScreenShot(driver, "coulumn is missing in for Ranking By regional Article")));		
				

					    	System.out.println(" column name is Missing");
					    }
					    
				countercolumn=countercolumn+1;
				 }
				 
				

				//verify Rows	
				 
				 int countRows= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]")).size(); 
						 
						 System.out.println( countRows+"Rows are present");
						 
						 logger
							.log(LogStatus.PASS,"<font color='green'>Result: No.of rows are <font/>"+"<b>"+countRows);
					
		
		
		
		ResultSet data6 = dataBase.getData(ranking_related_queries.RankingBySellers_RegionalArticles_Query);
		
		int count= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]")).size()+1;
		
 	
 System.out.println(count+"count");
 Thread.sleep(3000);
 	
 	int counter=1;

 	
 	
     	
while(count>counter) {

	while(data6.next()){  	

	
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
 
 
 if (SellersCode.equalsIgnoreCase(data6.getString(1))
		 && getresutls.equalsIgnoreCase(data6.getString(3)) ) {

	 
	 logger.log(LogStatus.PASS,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
				+"2:Actual row Content On App is "+"<b>"+castSellersNames+"|"+getresutls+"</b>"+"<br/>"
				+"3:Expected row Content From DB is "+"<b>"+data6.getString(1)+" - "+data6.getString(2)+"|"+data6.getString(3)+"</b>"+"<br/>"
				+"<b><font color='green'>Result:Row has been Matched <font/>");


	 
	 
	 System.out.println(data6.getString(1)+"|"+data6.getString(2)+"|"+data6.getString(3)+"|"+" DB");
	 System.out.println(SellersCode +"|"+ getresutls+"sellers data matched ");
 	
	 }else {
		 
		 logger.log(LogStatus.FAIL,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
					+"2:Actual row Content On App is "+"<b>"+castSellersNames+"|"+getresutls+"</b>"+"<br/>"
					+"3:Expected row Content From DB is "+"<b>"+data6.getString(1)+" - "+data6.getString(2)+"|"+data6.getString(3)+"</b>"+"<br/>"
					+"<b><font color='Orange'>Result:either row has same total amount or data is missMatched <font/>");
	 }

 break;
 

 	}	
	 System.out.println(counter+"counter");

	 counter=counter+1;    
		
	}	
}	
  

 //ranking By sellers with National Articles
 
public void verifyRankingBySellersNationalArticles() throws Throwable {
		
try {
	
	
	 System.out.println("ranking By sellers with National Articles");		

		ranking.tlvt_ranking.click();
		
		Select select1=new Select(ranking.tlvt_ranking);
		select1.selectByValue("11");
		logger
		.log(LogStatus.INFO,"<b><u><font color='Blue'>7:Ranking By Sellers National Articles option is selected from Ranking Drop Down List<font/>");
		Thread.sleep(3000);
		
		//verify coulmns
		JavascriptExecutor js=(JavascriptExecutor)driver;

		 int countColumns= driver.findElements(By.xpath("//*[@id='ranking_table']/thead/tr/th")).size()+1;
				
				 
				 int countercolumn=1;
				// get columns  
				 while(countColumns>countercolumn) {
					 
						WebElement  columns= driver.findElement(By.xpath("//*[@id='ranking_table']/thead/tr/th["+countercolumn+"]"));	
						
					    String Castcolumns = (String) js.executeScript("return arguments[0].innerText;",columns);

						
					    System.out.println(Castcolumns);
					    
					    if(Castcolumns.equalsIgnoreCase(ranking_related_queries.Classement)) {

					    	logger
							.log(LogStatus.PASS,"1:compairing Row column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: CLASSEMENT column has been verified<font/>"
					    	+logger
			 				.addScreenCapture(captureScreenShot(driver, "CLASSEMENT is matched for Ranking By National Article")));

					    	System.out.println("row column name is verified");
					    }else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.ATC)) {
					    

					    	logger
							.log(LogStatus.PASS,"1:compairing ATC column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: ATC column has been verified<font/>"
							+logger
			 				.addScreenCapture(captureScreenShot(driver, "ATC is matched for Ranking By National Article")));		
					    	System.out.println("Article column name is verified");
					    	

					    	
					    } else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.results)) {
					    	

					    	logger
							.log(LogStatus.PASS,"1:compairing results column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: RESULTAT column has been verified<font/>"
					    	+logger
			 				.addScreenCapture(captureScreenShot(driver, "RESULTAT is matched for National By regional Article")));		
					

					    	System.out.println("result column name is verified");
					    }else {

					    	logger
							.log(LogStatus.FAIL,"1:"+Castcolumns+"column name is Missing"+"<br/>"
							+"<b><font color='red'>Result:column name is Missing<font/>"
					    	+logger
				 				.addScreenCapture(captureScreenShot(driver, "coulumn is missing in for Ranking By National Article")));		
				

					    	System.out.println(" column name is Missing");
					    }
					    
				countercolumn=countercolumn+1;
				 }
				 
				

				//verify Rows	
				 
				 int countRows= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]")).size(); 
						 
						 System.out.println( countRows+"Rows are present");
						 
						 logger
							.log(LogStatus.PASS,"<font color='green'>Result: No.of rows are <font/>"+"<b>"+countRows);
					
		
		
		
		ResultSet data6 = dataBase.getData(ranking_related_queries.RankingBySellers_NationalArticles_Query);
		
		int count= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]")).size()+1;
		
	
System.out.println(count+"count");
Thread.sleep(3000);
	
	int counter=1;

	
	
    	
while(count>counter) {

	while(data6.next()){  	

	
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


if (SellersCode.equalsIgnoreCase(data6.getString(1))
		 && getresutls.equalsIgnoreCase(data6.getString(3)) ) {

	 
	 logger.log(LogStatus.PASS,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
				+"2:Actual row Content On App is "+"<b>"+castSellersNames+"|"+getresutls+"</b>"+"<br/>"
				+"3:Expected row Content From DB is "+"<b>"+data6.getString(1)+" - "+data6.getString(2)+"|"+data6.getString(3)+"</b>"+"<br/>"
				+"<b><font color='green'>Result:Row has been Matched <font/>");


	 
	 
	 System.out.println(data6.getString(1)+"|"+data6.getString(2)+"|"+data6.getString(3)+"|"+" DB");
	 System.out.println(SellersCode +"|"+ getresutls+"sellers data matched ");
	
	 }else {
		 
		 logger.log(LogStatus.FAIL,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
					+"2:Actual row Content On App is "+"<b>"+castSellersNames+"|"+getresutls+"</b>"+"<br/>"
					+"3:Expected row Content From DB is "+"<b>"+data6.getString(1)+" - "+data6.getString(2)+"|"+data6.getString(3)+"</b>"+"<br/>"
					+"<b><font color='Orange'>Result:either row has same total amount or data is missMatched <font/>");
	 }

break;


	}	
	 System.out.println(counter+"counter");

	 counter=counter+1;    
		
	}


} catch (Exception national_Article) {
	
	logger.log(LogStatus.FAIL,"<b><font color='red'>Rows Does not present On National article Ranking View<font/>"
			+logger.addScreenCapture(captureScreenShot(driver, "National article Ranking View")));

	
	}

}	
 
 
 
 
 
	//ranking By Sellers MBI
 
 public void verifyRankingBySellersMBI() throws Throwable {
		
		
	 System.out.println("//ranking By Sellers MBI");		
		ranking.tlvt_ranking.click();
		
		Select select1=new Select(ranking.tlvt_ranking);
		select1.selectByValue("12");
		logger
		.log(LogStatus.INFO,"<b><u><font color='Blue'>8:Ranking By Sellers MBI option is selected from Ranking Drop Down List<font/>");
		Thread.sleep(2000);
	
		//verify coulmns
		JavascriptExecutor js=(JavascriptExecutor)driver;

		 int countColumns= driver.findElements(By.xpath("//*[@id='ranking_table']/thead/tr/th")).size()+1;
				
				 
				 int countercolumn=1;
				// get columns  
				 while(countColumns>countercolumn) {
					 
						WebElement  columns= driver.findElement(By.xpath("//*[@id='ranking_table']/thead/tr/th["+countercolumn+"]"));	
						
					    String Castcolumns = (String) js.executeScript("return arguments[0].innerText;",columns);

						
					    System.out.println(Castcolumns);
					    
					    if(Castcolumns.equalsIgnoreCase(ranking_related_queries.Classement)) {

					    	logger
							.log(LogStatus.PASS,"1:compairing Row column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: CLASSEMENT column has been verified<font/>"
					    	+logger
			 				.addScreenCapture(captureScreenShot(driver, "CLASSEMENT is matched for Ranking By MBI")));

					    	System.out.println("row column name is verified");
					    }else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.ATC)) {
					    

					    	logger
							.log(LogStatus.PASS,"1:compairing ATC column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: ATC column has been verified<font/>"
							+logger
			 				.addScreenCapture(captureScreenShot(driver, "ATC is matched for Ranking By MBI")));		
					    	System.out.println("Article column name is verified");
					    	

					    	
					    }else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.Nombre_commandes)) {
						    

						    	logger
								.log(LogStatus.PASS,"1:compairing Nombre_commandes column name with expected Name"+"<br/>"
								+"<b><font color='green'>Result: Nombre_commandes column has been verified<font/>"
								+logger
				 				.addScreenCapture(captureScreenShot(driver, "Nombre_commandes is matched for Ranking By MBI")));		
						    	System.out.println("Nombre_commandes column name is verified");
						    	

						    	
						    }
					    else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.Montant_MBI)) {
						    

					    	logger
							.log(LogStatus.PASS,"1:compairing Montant_MBI column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: Montant_MBI column has been verified<font/>"
							+logger
			 				.addScreenCapture(captureScreenShot(driver, "Montant_MBI is matched for Ranking By MBI")));		
					    	System.out.println("Montant_MBI column name is verified");
					    	
							helper.javaScriptUn_HighlightWebElement(columns);

					    	
					    }
					    else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.percentage_MBI)) {
						    

					    	logger
							.log(LogStatus.PASS,"1:compairing percentage_MBI column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: percentage_MBI column has been verified<font/>"
							+logger
			 				.addScreenCapture(captureScreenShot(driver, "percentage_MBI is matched for Ranking By MBI")));		
					    	System.out.println("percentage_MBI column name is verified");
					    	

					    	
					    }
					    else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.results)) {
					    	

					    	logger
							.log(LogStatus.PASS,"1:compairing results column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: RESULTAT column has been verified<font/>"
					    	+logger
			 				.addScreenCapture(captureScreenShot(driver, "RESULTAT is matched for Ranking By MBI")));		
					

					    	System.out.println("result column name is verified");
					    }else {

					    	logger
							.log(LogStatus.FAIL,"1:"+Castcolumns+"column name is Missing"+"<br/>"
							+"<b><font color='red'>Result:column name is Missing<font/>"
					    	+logger
				 				.addScreenCapture(captureScreenShot(driver, "coulumn is missing in for Ranking By MBI")));		
				

					    	System.out.println(" column name is Missing");
					    }
					    
				countercolumn=countercolumn+1;
				 }
				 
				
				//verify Rows	
				 
				 int countRows= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]")).size(); 
						 
						 System.out.println( countRows+"Rows are present");
						 
						 logger
							.log(LogStatus.PASS,"<font color='green'>Result: No.of rows are <font/>"+"<b>"+countRows);
					
	
		
		
		
		
		
		ResultSet data7 = dataBase.getData(ranking_related_queries.RankingBySellersMBI_Query);
		
		int count= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[1]")).size()+1;
		
	
System.out.println(count+"count");
Thread.sleep(3000);
	
	int counter=1;

	
	
  	
while(count>counter) {

	while(data7.next()){  	

	
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
		
	
	 logger.log(LogStatus.PASS,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
				+"2:Actual row Content On App is "+"<b>"+castManagersName+"|"+castNumberOfOrders
				+"|"+getcastMontantMBIText+"|"+getcastPercentageMBIText+"|"+getresutls+"</b>"+"<br/>"
				+"3:Expected row Content From DB is "+"<b>"+data7.getString(1)+"|"+data7.getString(2)
				 +"|"+data7.getString(4)+"|"+data7.getString(5)+"|"+data7.getString(6)+data7.getString(3)+"</b>"+"<br/>"
				+"<b><font color='green'>Result:Row has been Matched <font/>");


	 System.out.println(data7.getString(1)+"|"+data7.getString(2)
	 +"|"+data7.getString(3)+"|"+data7.getString(4)+"|"+data7.getString(5)+data7.getString(6)+" DB");
	
	 System.out.println(SellersCode+"|"+data7.getString(1)+"|"+castNumberOfOrders+"|"+
	 data7.getString(4)+"|"+getcastMontantMBIText+"|"+data7.getString(5)+"|"+getcastPercentageMBIText
	 +"|"+data7.getString(6)+"|"+getresutls+"|"+data7.getString(3)+"sellers data matched");
	
	 }else {
		 
		 logger.log(LogStatus.FAIL,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
					+"2:Actual row Content On App is "+"<b>"+castManagersName+"|"+castNumberOfOrders
					+"|"+getcastMontantMBIText+"|"+getcastPercentageMBIText+"|"+getresutls+"</b>"+"<br/>"
					+"3:Expected row Content From DB is "+"<b>"+data7.getString(1)+" - "+data7.getString(2)
					 +"|"+data7.getString(4)+"|"+data7.getString(5)+"|"+data7.getString(6)+data7.getString(3)+"</b>"+"<br/>"
					 +"<b><font color='Orange'>Result:either row has same total amount or data is missMatched <font/>");
		 
	 }

break;


	}	
	 System.out.println(counter+"counter");

	 counter=counter+1;    
		
	}	
}	
 
 
 
//ranking By CDV manager
 
public void verifyRankingByCDV() throws Throwable {
		
	System.out.println("//ranking By CDV manager");	
	
		ranking.tlvt_ranking.click();
		
		Select select1=new Select(ranking.tlvt_ranking);
		select1.selectByValue("14");
	
		logger
		.log(LogStatus.INFO,"<b><u><font color='Blue'>9:Ranking By CDV option is selected from Ranking Drop Down List<font/>");
		Thread.sleep(2000);
		
		//verify coulmns
		
		JavascriptExecutor js=(JavascriptExecutor)driver;

		 int countColumns= driver.findElements(By.xpath("//*[@id='ranking_table']/thead/tr/th")).size()+1;
				
				 
				 int countercolumn=1;
				// get columns  
				 while(countColumns>countercolumn) {
					 
						WebElement  columns= driver.findElement(By.xpath("//*[@id='ranking_table']/thead/tr/th["+countercolumn+"]"));	
						
					    String Castcolumns = (String) js.executeScript("return arguments[0].innerText;",columns);

						
					    System.out.println(Castcolumns);
					    
					    if(Castcolumns.equalsIgnoreCase(ranking_related_queries.Classement)) {

					    	logger
							.log(LogStatus.PASS,"1:compairing Row column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: CLASSEMENT column has been verified<font/>"
					    	+logger
			 				.addScreenCapture(captureScreenShot(driver, "CLASSEMENT is matched for Ranking By CDV")));

					    	System.out.println("row column name is verified");
					    }else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.CDV)) {
					    

					    	logger
							.log(LogStatus.PASS,"1:compairing CDV column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: CDV column has been verified<font/>"
							+logger
			 				.addScreenCapture(captureScreenShot(driver, "CDV is matched for Ranking By CDV")));		
					    	System.out.println("CDV column name is verified");
					    	

					    	
					    }else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.Nombre_commandes)) {
						    

						    	logger
								.log(LogStatus.PASS,"1:compairing Nombre_commandes column name with expected Name"+"<br/>"
								+"<b><font color='green'>Result: Nombre_commandes column has been verified<font/>"
								+logger
				 				.addScreenCapture(captureScreenShot(driver, "Nombre_commandes is matched for Ranking By CDV")));		
						    	System.out.println("Nombre_commandes column name is verified");
						    	

						    	
						    }
					    else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.Objectif)) {
						    

					    	logger
							.log(LogStatus.PASS,"1:compairing Objectif column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: Objectif column has been verified<font/>"
							+logger
			 				.addScreenCapture(captureScreenShot(driver, "Objectif is matched for Ranking By CDV")));		
					    	System.out.println("Objectif column name is verified");
					    	

					    	
					    }
					    else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.tax)) {
						    
							//helper.javaScriptHighlightWebElement(columns);

					    	logger
							.log(LogStatus.PASS,"1:compairing tax column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: tax column has been verified<font/>"
							+logger
			 				.addScreenCapture(captureScreenShot(driver, "tax is matched for Ranking By CDV")));		
					    	System.out.println("percentage_MBI column name is verified");
					    	
							//helper.javaScriptUn_HighlightWebElement(columns);

					    	
					    }
					    else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.results)) {
					    	
							//helper.javaScriptHighlightWebElement(columns);

					    	logger
							.log(LogStatus.PASS,"1:compairing results column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: RESULTAT column has been verified<font/>"
					    	+logger
			 				.addScreenCapture(captureScreenShot(driver, "RESULTAT is matched for Ranking By CDV")));		
					
							//helper.javaScriptUn_HighlightWebElement(columns);

					    	System.out.println("result column name is verified");
					    }else {
						//	helper.javaScriptHighlightWebElement(columns);

					    	logger
							.log(LogStatus.FAIL,"1:"+Castcolumns+"column name is Missing"+"<br/>"
							+"<b><font color='red'>Result:column name is Missing<font/>"
					    	+logger
				 				.addScreenCapture(captureScreenShot(driver, "coulumn is missing in for Ranking By CDV")));		
				
						//	helper.javaScriptUn_HighlightWebElement(columns);

					    	System.out.println(" column name is Missing");
					    }
					    
				countercolumn=countercolumn+1;
				 }
				 
				//verify Rows	
				 
				 int countRows= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]")).size(); 
						 
						 System.out.println( countRows+"Rows are present");
						 
						 logger
							.log(LogStatus.PASS,"<font color='green'>Result: No.of rows are <font/>"+"<b>"+countRows);
								
		
		
		
		ResultSet data7 = dataBase.getData(ranking_related_queries.rankingByManager_Query);
		
		int count= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[1]")).size()+1;
		
	
System.out.println(count+"count");
Thread.sleep(3000);
	
	int counter=1;

	
	
 	
while(count>counter) {

	while(data7.next()){  	

	
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
		
	logger.log(LogStatus.PASS,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
			+"2:Actual row Content On App is "+"<b>"+castManagersName+"|"+castNumberOfOrders
			+"|"+getcastObjectiveFText+"|"+getcastTaxText+"|"+getresutls+"</b>"+"<br/>"
			+"3:Expected row Content From DB is "+"<b>"+data7.getString(1)+" - "+data7.getString(2)
			 +"|"+data7.getString(4)+"|"+data7.getString(5)+"|"+data7.getString(6)+data7.getString(3)+"</b>"+"<br/>"
			+"<b><font color='green'>Result:Row has been Matched <font/>");

	
	 System.out.println(data7.getString(1)+"|"+data7.getString(2)
	 +"|"+data7.getString(3)+"|"+data7.getString(4)+data7.getString(5)+data7.getString(6)+" DB");
	
	 System.out.println(SellersCode+"|"+data7.getString(1)+"|"+castNumberOfOrders+"|"+
	 "|"+data7.getString(4)+getcastObjectiveFText+"|"+data7.getString(5)+"|"+getcastTaxText
	 +"|"+data7.getString(6)+"|"+getresutls+"|"+data7.getString(3)+"sellers data matched");
	
	 }else {
		 
		 logger.log(LogStatus.FAIL,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
					+"2:Actual row Content On App is "+"<b>"+castManagersName+"|"+castNumberOfOrders
					+"|"+getcastObjectiveFText+"|"+getcastTaxText+"|"+getresutls+"</b>"+"<br/>"
					+"3:Expected row Content From DB is "+"<b>"+data7.getString(1)+" - "+data7.getString(2)
					 +"|"+data7.getString(4)+"|"+data7.getString(5)+"|"+data7.getString(6)+data7.getString(3)+"</b>"+"<br/>"
					 +"<b><font color='Orange'>Result:either row has same total amount or data is missMatched <font/>");
		 
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
	
	logger
	.log(LogStatus.INFO,"<b><u><font color='Blue'>10:Ranking By  Supplier Appro option is selected from Ranking Drop Down List<font/>");

	Thread.sleep(2000);
	
	//verify coulmns
	JavascriptExecutor js=(JavascriptExecutor)driver;

	 int countColumns= driver.findElements(By.xpath("//*[@id='ranking_table']/thead/tr/th")).size()+1;
			
			 
			 int countercolumn=1;
			// get columns  
			 while(countColumns>countercolumn) {
				 
					WebElement  columns= driver.findElement(By.xpath("//*[@id='ranking_table']/thead/tr/th["+countercolumn+"]"));	
					
				    String Castcolumns = (String) js.executeScript("return arguments[0].innerText;",columns);

					
				    System.out.println(Castcolumns);
				    
				    if(Castcolumns.equalsIgnoreCase(ranking_related_queries.Classement)) {
						//helper.javaScriptHighlightWebElement(columns);

				    	logger
						.log(LogStatus.PASS,"1:compairing Row column name with expected Name"+"<br/>"
						+"<b><font color='green'>Result: CLASSEMENT column has been verified<font/>"
				    	+logger
		 				.addScreenCapture(captureScreenShot(driver, "CLASSEMENT is matched for supplier_appro")));
						//helper.javaScriptUn_HighlightWebElement(columns);

				    	System.out.println("row column name is verified");
				    }else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.supplier_appro)) {
				    
						//helper.javaScriptHighlightWebElement(columns);

				    	logger
						.log(LogStatus.PASS,"1:compairing supplier_appro column name with expected Name"+"<br/>"
						+"<b><font color='green'>Result: supplier_appro column has been verified<font/>"
						+logger
		 				.addScreenCapture(captureScreenShot(driver, "supplier_appro is matched ")));		
				    	System.out.println("supplier_appro column name is verified");
				    	
						//helper.javaScriptUn_HighlightWebElement(columns);

				    	
				    } else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.results)) {
				    	
					//	helper.javaScriptHighlightWebElement(columns);

				    	logger
						.log(LogStatus.PASS,"1:compairing results column name with expected Name"+"<br/>"
						+"<b><font color='green'>Result: RESULTAT column has been verified<font/>"
				    	+logger
		 				.addScreenCapture(captureScreenShot(driver, "RESULTAT is matched for supplier_appro")));		
				
					//	helper.javaScriptUn_HighlightWebElement(columns);

				    	System.out.println("result column name is verified");
				    }else {
					//	helper.javaScriptHighlightWebElement(columns);

				    	logger
						.log(LogStatus.FAIL,"1:"+Castcolumns+"column name is Missing"+"<br/>"
						+"<b><font color='red'>Result:column name is Missing<font/>"
				    	+logger
			 				.addScreenCapture(captureScreenShot(driver, "coulumn is missing in supplier_appro")));		
			
					//	helper.javaScriptUn_HighlightWebElement(columns);

				    	System.out.println(" column name is Missing");
				    }
				    
			countercolumn=countercolumn+1;
			 }
			 
			
			//verify Rows	
			 
			 int countRows= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]")).size(); 
					 
					 System.out.println( countRows+"Rows are present");
					 
					 logger
						.log(LogStatus.PASS,"<font color='green'>Result: No.of rows are <font/>"+"<b>"+countRows);
				
	
	
	
	ResultSet data6 = dataBase.getData(ranking_related_queries.RankingBySupplierAppro_Query);
	
	int count= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[1]")).size()+1;
	
	
System.out.println(count+"count");
Thread.sleep(3000);
	
	int counter=1;

	
	
 	
while(count>counter) {

while(data6.next()){  	


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
	
	logger.log(LogStatus.PASS,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
			+"2:Actual row Content On App is "+"<b>"+castSupplierNames+"|"+getresutls+"</b>"+"<br/>"
			+"3:Expected row Content From DB is "+"<b>"+data6.getString(1)+" - "+data6.getString(2)+"|"+data6.getString(3)+"</b>"+"<br/>"
			+"<b><font color='green'>Result:Row has been Matched <font/>");
	
 System.out.println(data6.getString(1)+"|"+data6.getString(2)+"|"+data6.getString(3)+"|"+" DB");
 System.out.println(SellersCode +"|"+ getresutls+"sellers data matched ");
	
 }else {
	 
		logger.log(LogStatus.PASS,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
				+"2:Actual row Content On App is "+"<b>"+castSupplierNames+"|"+getresutls+"</b>"+"<br/>"
				+"3:Expected row Content From DB is "+"<b>"+data6.getString(1)+" - "+data6.getString(2)+"|"+data6.getString(3)+"</b>"+"<br/>"
				+"<b><font color='Orange'>Result:either row has same total amount or data is missMatched <font/>");
 }

break;


	}	
System.out.println(counter+"counter");

 counter=counter+1;    
	
	}	
}	

//ranking By Supplier producers

public void verifyRankingBySupplierProducer() throws Throwable {
	
	System.out.println("//ranking By Supplier producers");

	ranking.tlvt_ranking.click();
	
	Select select1=new Select(ranking.tlvt_ranking);
	select1.selectByValue("8");
	
	logger
	.log(LogStatus.INFO,"<b><u><font color='Blue'>10:Ranking By  Supplier Producer option is selected from Ranking Drop Down List<font/>");
	Thread.sleep(2000);
	
	//verify coulmns
	JavascriptExecutor js=(JavascriptExecutor)driver;

		 int countColumns= driver.findElements(By.xpath("//*[@id='ranking_table']/thead/tr/th")).size()+1;
				
				 
				 int countercolumn=1;
				// get columns  
				 while(countColumns>countercolumn) {
					 
						WebElement  columns= driver.findElement(By.xpath("//*[@id='ranking_table']/thead/tr/th["+countercolumn+"]"));	
						
					    String Castcolumns = (String) js.executeScript("return arguments[0].innerText;",columns);

						
					    System.out.println(Castcolumns);
					    
					    if(Castcolumns.equalsIgnoreCase(ranking_related_queries.Classement)) {
						//	helper.javaScriptHighlightWebElement(columns);

					    	logger
							.log(LogStatus.PASS,"1:compairing Row column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: CLASSEMENT column has been verified<font/>"
					    	+logger
			 				.addScreenCapture(captureScreenShot(driver, "CLASSEMENT is matched for supplier_producer")));
						//	helper.javaScriptUn_HighlightWebElement(columns);

					    	System.out.println("row column name is verified");
					    }else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.supplier_producer)) {
					    
						//	helper.javaScriptHighlightWebElement(columns);

					    	logger
							.log(LogStatus.PASS,"1:compairing supplier_producer column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: supplier_producer column has been verified<font/>"
							+logger
			 				.addScreenCapture(captureScreenShot(driver, "supplier_producer is matched ")));		
					    	System.out.println("supplier_producer column name is verified");
					    	
							//helper.javaScriptUn_HighlightWebElement(columns);

					    	
					    } else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.results)) {
					    	
						//	helper.javaScriptHighlightWebElement(columns);

					    	logger
							.log(LogStatus.PASS,"1:compairing results column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: RESULTAT column has been verified<font/>"
					    	+logger
			 				.addScreenCapture(captureScreenShot(driver, "RESULTAT is matched for supplier_producer")));		
					
						//	helper.javaScriptUn_HighlightWebElement(columns);

					    	System.out.println("result column name is verified");
					    }else {
						//	helper.javaScriptHighlightWebElement(columns);

					    	logger
							.log(LogStatus.FAIL,"1:"+Castcolumns+"column name is Missing"+"<br/>"
							+"<b><font color='red'>Result:column name is Missing<font/>"
					    	+logger
				 				.addScreenCapture(captureScreenShot(driver, "coulumn is missing in supplier_producer")));		
				
						//	helper.javaScriptUn_HighlightWebElement(columns);

					    	System.out.println(" column name is Missing");
					    }
					    
				countercolumn=countercolumn+1;
				 }
				 
				//verify Rows	
				 
				 int countRows= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]")).size(); 
						 
						 System.out.println( countRows+"Rows are present");
						 
						 logger
							.log(LogStatus.PASS,"<font color='green'>Result: No.of rows are <font/>"+"<b>"+countRows);
								

	
	
	
	
	ResultSet data6 = dataBase.getData(ranking_related_queries.RankingBySupplierProducer_Query);
	
	int count= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[1]")).size()+1;
	
	
System.out.println(count+"count");
Thread.sleep(3000);
	
	int counter=1;

	
	
 	
while(count>counter) {

while(data6.next()){  	


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


if (SellersCode.equalsIgnoreCase(data6.getString(2))
		&& getresutls.equalsIgnoreCase(data6.getString(3)) ) {
	
	logger.log(LogStatus.PASS,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
			+"2:Actual row Content On App is "+"<b>"+castSupplierNames+"|"+getresutls+"</b>"+"<br/>"
			+"3:Expected row Content From DB is "+"<b>"+data6.getString(1)+" - "+data6.getString(2)+"|"+data6.getString(3)+"</b>"+"<br/>"
			+"<b><font color='green'>Result:Row has been Matched <font/>");
	
	
 System.out.println(data6.getString(2)+"|"+data6.getString(3)+"|"+data6.getString(4)+"|"+" DB");
 System.out.println(SellersCode +"|"+ getresutls+"sellers data matched ");
	
 }else {
	 
	 logger.log(LogStatus.FAIL,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
				+"2:Actual row Content On App is "+"<b>"+castSupplierNames+"|"+getresutls+"</b>"+"<br/>"
				+"3:Expected row Content From DB is "+"<b>"+data6.getString(1)+" - "+data6.getString(2)+"|"+data6.getString(3)+"</b>"+"<br/>"
				+"<b><font color='Orange'>Result:either row has same total amount or data is missMatched <font/>");		
 }

break;


	}	
System.out.println(counter+"counter");

 counter=counter+1;    
	
	}	
}	

 
//ranking By sectors

public void verifyRankingBySector() throws Throwable {
	
	System.out.println("ranking By sectors");
	
	ranking.tlvt_ranking.click();
	
	Select select1=new Select(ranking.tlvt_ranking);
	select1.selectByValue("4");
	
	logger
	.log(LogStatus.INFO,"<b><u><font color='Blue'>12:Ranking By Sector option is selected from Ranking Drop Down List<font/>");
	Thread.sleep(2000);
		
	//verify coulmns
	JavascriptExecutor js=(JavascriptExecutor)driver;

	 int countColumns= driver.findElements(By.xpath("//*[@id='ranking_table']/thead/tr/th")).size()+1;
			
			 
			 int countercolumn=1;
			// get columns  
			 while(countColumns>countercolumn) {
				 
					WebElement  columns= driver.findElement(By.xpath("//*[@id='ranking_table']/thead/tr/th["+countercolumn+"]"));	
					
				    String Castcolumns = (String) js.executeScript("return arguments[0].innerText;",columns);

					
				    System.out.println(Castcolumns);
				    
				    if(Castcolumns.equalsIgnoreCase(ranking_related_queries.Classement)) {
				//		helper.javaScriptHighlightWebElement(columns);

				    	logger
						.log(LogStatus.PASS,"1:compairing Row column name with expected Name"+"<br/>"
						+"<b><font color='green'>Result: CLASSEMENT column has been verified<font/>"
				    	+logger
		 				.addScreenCapture(captureScreenShot(driver, "CLASSEMENT is matched for Sector")));
					//	helper.javaScriptUn_HighlightWebElement(columns);

				    	System.out.println("row column name is verified");
				    }else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.Sector)) {
				    
					//	helper.javaScriptHighlightWebElement(columns);

				    	logger
						.log(LogStatus.PASS,"1:compairing Sector column name with expected Name"+"<br/>"
						+"<b><font color='green'>Result: Sector column has been verified<font/>"
						+logger
		 				.addScreenCapture(captureScreenShot(driver, "Sector is matched ")));		
				    	System.out.println("Sector column name is verified");
				    	
					//	helper.javaScriptUn_HighlightWebElement(columns);

				    	
				    } 
				    else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.Objectif)) {
					    
					//	helper.javaScriptHighlightWebElement(columns);

				    	logger
						.log(LogStatus.PASS,"1:compairing Objectif column name with expected Name"+"<br/>"
						+"<b><font color='green'>Result: Objectif column has been verified<font/>"
						+logger
		 				.addScreenCapture(captureScreenShot(driver, "Objectif is matched ranking By sector ")));		
				    	System.out.println("Sector column name is verified");
				    	
					//	helper.javaScriptUn_HighlightWebElement(columns);

				    	
				    }
				    else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.tax)) {
					    
					//	helper.javaScriptHighlightWebElement(columns);

				    	logger
						.log(LogStatus.PASS,"1:compairing tax column name with expected Name"+"<br/>"
						+"<b><font color='green'>Result: tax column has been verified<font/>"
						+logger
		 				.addScreenCapture(captureScreenShot(driver, "tax is matched ranking By sector ")));		
				    	System.out.println("tax column name is verified");
				    	
					//	helper.javaScriptUn_HighlightWebElement(columns);

				    	
				    }
				    
				    else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.results)) {
				    	
					//	helper.javaScriptHighlightWebElement(columns);

				    	logger
						.log(LogStatus.PASS,"1:compairing results column name with expected Name"+"<br/>"
						+"<b><font color='green'>Result: RESULTAT column has been verified<font/>"
				    	+logger
		 				.addScreenCapture(captureScreenShot(driver, "RESULTAT is matched for Sector")));		
				
					//	helper.javaScriptUn_HighlightWebElement(columns);

				    	System.out.println("result column name is verified");
				    }else {
						//helper.javaScriptHighlightWebElement(columns);

				    	logger
						.log(LogStatus.FAIL,"1:"+Castcolumns+"column name is Missing"+"<br/>"
						+"<b><font color='red'>Result:column name is Missing<font/>"
				    	+logger
			 				.addScreenCapture(captureScreenShot(driver, "coulumn is missing in Sector")));		
			
						//helper.javaScriptUn_HighlightWebElement(columns);

				    	System.out.println(" column name is Missing");
				    }
				    
			countercolumn=countercolumn+1;
			 }
			 
			
			//verify Rows	
			 
			 int countRows= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]")).size(); 
					 
					 System.out.println( countRows+"Rows are present");
					 
					 logger
						.log(LogStatus.PASS,"<font color='green'>Result: No.of rows are <font/>"+"<b>"+countRows);
				


	
	
	
	ResultSet data7 = dataBase.getData(ranking_related_queries.RankingBySector_Query);
	
	int count= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[1]")).size()+1;
	

System.out.println(count+"count");
Thread.sleep(3000);

int counter=1;



	
while(count>counter) {

while(data7.next()){  	


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
	
	logger.log(LogStatus.PASS,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
			+"2:Actual row Content On App is "+"<b>"+castSectorName+"|"+getcastObjectiveFText
			+"|"+getcastTaxText+"|"+getresutls+"</b>"+"<br/>"
			+"3:Expected row Content From DB is "+"<b>"+data7.getString(1)+" - "+data7.getString(2)
			 +"|"+data7.getString(4)+"|"+data7.getString(5)+data7.getString(6)+data7.getString(3)+"</b>"+"<br/>"
			+"<b><font color='green'>Result:Row has been Matched <font/>");
	

 System.out.println(SellersCode+"|"+data7.getString(2)+"|"+getcastObjectiveFText
+"|"+data7.getString(5)+"|"+getcastTaxText
 +"|"+data7.getString(6)+"|"+getresutls+"|"+data7.getString(4)+"sellers data matched");

 }else {
	 
	 logger.log(LogStatus.FAIL,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
				+"2:Actual row Content On App is "+"<b>"+castSectorName+"|"+getcastObjectiveFText
				+"|"+getcastTaxText+"|"+getresutls+"</b>"+"<br/>"
				+"3:Expected row Content From DB is "+"<b>"+data7.getString(1)+" - "+data7.getString(2)
				 +"|"+data7.getString(4)+"|"+data7.getString(5)+data7.getString(6)+data7.getString(3)+"</b>"+"<br/>"
				 +"<b><font color='Orange'>Result:either row has same total amount or data is missMatched <font/>");		
	 
 }

break;


}	
System.out.println(counter+"counter");

 counter=counter+1;    
	
	}	
}	


//Ranking By Site
public void verifyRankingBySite() throws Throwable {
	

	System.out.println("ranking By site");

	ranking.tlvt_ranking.click();
	
	Select select1=new Select(ranking.tlvt_ranking);
	select1.selectByValue("3");
	
	logger
	.log(LogStatus.INFO,"<b><u><font color='Blue'>13:Ranking By Site option is selected from Ranking Drop Down List<font/>");
	Thread.sleep(3000);

	//verify coulmns
	JavascriptExecutor js=(JavascriptExecutor)driver;

		 int countColumns= driver.findElements(By.xpath("//*[@id='ranking_table']/thead/tr/th")).size()+1;
				
				 
				 int countercolumn=1;
				// get columns  
				 while(countColumns>countercolumn) {
					 
						WebElement  columns= driver.findElement(By.xpath("//*[@id='ranking_table']/thead/tr/th["+countercolumn+"]"));	
						
					    String Castcolumns = (String) js.executeScript("return arguments[0].innerText;",columns);

						
					    System.out.println(Castcolumns);
					    
					    if(Castcolumns.equalsIgnoreCase(ranking_related_queries.Classement)) {
						//	helper.javaScriptHighlightWebElement(columns);

					    	logger
							.log(LogStatus.PASS,"1:compairing Row column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: CLASSEMENT column has been verified<font/>"
					    	+logger
			 				.addScreenCapture(captureScreenShot(driver, "CLASSEMENT is matched for site")));
						//	helper.javaScriptUn_HighlightWebElement(columns);

					    	System.out.println("row column name is verified");
					    }else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.Site)) {
					    
						//	helper.javaScriptHighlightWebElement(columns);

					    	logger
							.log(LogStatus.PASS,"1:compairing site column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: site column has been verified<font/>"
							+logger
			 				.addScreenCapture(captureScreenShot(driver, "site is matched ")));		
					    	System.out.println("site column name is verified");
					    	
						//	helper.javaScriptUn_HighlightWebElement(columns);

					    	
					    } 
					    else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.Objectif)) {
						    
							//helper.javaScriptHighlightWebElement(columns);

					    	logger
							.log(LogStatus.PASS,"1:compairing Objectif column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: Objectif column has been verified<font/>"
							+logger
			 				.addScreenCapture(captureScreenShot(driver, "Objectif is matched ranking By site ")));		
					    	System.out.println("Sector column name is verified");
					    	
						//	helper.javaScriptUn_HighlightWebElement(columns);

					    	
					    }
					    else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.tax)) {
						    
							//helper.javaScriptHighlightWebElement(columns);

					    	logger
							.log(LogStatus.PASS,"1:compairing tax column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: tax column has been verified<font/>"
							+logger
			 				.addScreenCapture(captureScreenShot(driver, "tax is matched ranking By site ")));		
					    	System.out.println("tax column name is verified");
					    	
						//	helper.javaScriptUn_HighlightWebElement(columns);

					    	
					    }
					    
					    else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.results)) {
					    	
						//	helper.javaScriptHighlightWebElement(columns);

					    	logger
							.log(LogStatus.PASS,"1:compairing results column name with expected Name"+"<br/>"
							+"<b><font color='green'>Result: RESULTAT column has been verified<font/>"
					    	+logger
			 				.addScreenCapture(captureScreenShot(driver, "RESULTAT is matched for site")));		
					
						//	helper.javaScriptUn_HighlightWebElement(columns);

					    	System.out.println("result column name is verified");
					    }else {
						//	helper.javaScriptHighlightWebElement(columns);

					    	logger
							.log(LogStatus.FAIL,"1:"+Castcolumns+"column name is Missing"+"<br/>"
							+"<b><font color='red'>Result:column name is Missing<font/>"
					    	+logger
				 				.addScreenCapture(captureScreenShot(driver, "coulumn is missing in site")));		
				
						//	helper.javaScriptUn_HighlightWebElement(columns);

					    	System.out.println(" column name is Missing");
					    }
					    
				countercolumn=countercolumn+1;
				 }
				 
				
				//verify Rows	
				 
				 int countRows= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]")).size(); 
						 
						 System.out.println( countRows+"Rows are present");
						 
						 logger
							.log(LogStatus.PASS,"<font color='green'>Result: No.of rows are <font/>"+"<b>"+countRows);
					
	
	
	
	
	ResultSet data7 = dataBase.getData(ranking_related_queries.RankingBySite_Query);
	
	int count= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[1]")).size()+1;
	

System.out.println(count+"count");
Thread.sleep(3000);

int counter=1;



	
while(count>counter) {

while(data7.next()){  	


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
	
	logger.log(LogStatus.PASS,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
			+"2:Actual row Content On App is "+"<b>"+castSiteName+"|"+getcastObjectiveFText
			+"|"+getcastTaxText+"|"+getresutls+"</b>"+"<br/>"
			+"3:Expected row Content From DB is "+"<b>"+data7.getString(1)+" - "+data7.getString(2)
			 +"|"+data7.getString(4)+"|"+data7.getString(5)+data7.getString(6)+data7.getString(3)+"</b>"+"<br/>"
			+"<b><font color='green'>Result:Row has been Matched <font/>");
	
 System.out.println(data7.getString(1)+"|"+data7.getString(2)
 +"|"+data7.getString(3)+"|"+data7.getString(4)+data7.getString(5)+data7.getString(6)+" DB");

 System.out.println(SellersCode+"|"+data7.getString(2)+"|"+getcastObjectiveFText
+"|"+data7.getString(5)+"|"+getcastTaxText
 +"|"+data7.getString(6)+"|"+getresutls+"|"+data7.getString(4)+"sellers data matched");

 }else {
	 
	 logger.log(LogStatus.FAIL,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
				+"2:Actual row Content On App is "+"<b>"+castSiteName+"|"+getcastObjectiveFText
				+"|"+getcastTaxText+"|"+getresutls+"</b>"+"<br/>"
				+"3:Expected row Content From DB is "+"<b>"+data7.getString(1)+" - "+data7.getString(2)
				 +"|"+data7.getString(4)+"|"+data7.getString(5)+data7.getString(6)+data7.getString(3)+"</b>"+"<br/>"
				 +"<b><font color='Orange'>Result:either row has same total amount or data is missMatched <font/>");		
 }

break;


}
System.out.println(counter+"counter");

 counter=counter+1;    
	
	}	
}	



//ranking By Speciality

public void verifyRankingBySpeciality() throws Throwable {
	
	System.out.println("ranking By speciality");

	
	ranking.tlvt_ranking.click();
	
	Select select1=new Select(ranking.tlvt_ranking);
	select1.selectByValue("10");
	
	logger
	.log(LogStatus.INFO,"<b><u><font color='Blue'>14:Ranking By Specialite option is selected from Ranking Drop Down List<font/>");
	Thread.sleep(3000);
	
	//verify coulmns
	JavascriptExecutor js=(JavascriptExecutor)driver;

	 int countColumns= driver.findElements(By.xpath("//*[@id='ranking_table']/thead/tr/th")).size()+1;
			
			 
			 int countercolumn=1;
			// get columns  
			 while(countColumns>countercolumn) {
				 
					WebElement  columns= driver.findElement(By.xpath("//*[@id='ranking_table']/thead/tr/th["+countercolumn+"]"));	
					
				    String Castcolumns = (String) js.executeScript("return arguments[0].innerText;",columns);

					
				    System.out.println(Castcolumns);
				    
				    if(Castcolumns.equalsIgnoreCase(ranking_related_queries.Classement)) {
					//	helper.javaScriptHighlightWebElement(columns);

				    	logger
						.log(LogStatus.PASS,"1:compairing Row column name with expected Name"+"<br/>"
						+"<b><font color='green'>Result: CLASSEMENT column has been verified<font/>"
				    	+logger
		 				.addScreenCapture(captureScreenShot(driver, "CLASSEMENT is matched for speciality")));
				//		helper.javaScriptUn_HighlightWebElement(columns);

				    	System.out.println("row column name is verified");
				    }else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.speciality)) {
				    
					//	helper.javaScriptHighlightWebElement(columns);

				    	logger
						.log(LogStatus.PASS,"1:compairing speciality column name with expected Name"+"<br/>"
						+"<b><font color='green'>Result: speciality column has been verified<font/>"
						+logger
		 				.addScreenCapture(captureScreenShot(driver, "speciality is matched ")));		
				    	System.out.println("site column name is verified");
				    	
					//	helper.javaScriptUn_HighlightWebElement(columns);

				    	
				    } 
				 				    
				    else if (Castcolumns.equalsIgnoreCase(ranking_related_queries.results)) {
				    	
						//helper.javaScriptHighlightWebElement(columns);

				    	logger
						.log(LogStatus.PASS,"1:compairing results column name with expected Name"+"<br/>"
						+"<b><font color='green'>Result: RESULTAT column has been verified<font/>"
				    	+logger
		 				.addScreenCapture(captureScreenShot(driver, "RESULTAT is matched for speciality")));		
				
					//	helper.javaScriptUn_HighlightWebElement(columns);

				    	System.out.println("result column name is verified");
				    }else {
					//	helper.javaScriptHighlightWebElement(columns);

				    	logger
						.log(LogStatus.FAIL,"1:"+Castcolumns+"column name is Missing"+"<br/>"
						+"<b><font color='red'>Result:column name is Missing<font/>"
				    	+logger
			 				.addScreenCapture(captureScreenShot(driver, "coulumn is missing in speciality")));		
			
						//helper.javaScriptUn_HighlightWebElement(columns);

				    	System.out.println(" column name is Missing");
				    }
				    
			countercolumn=countercolumn+1;
			 }
			 
			
			//verify Rows	
			 
			 int countRows= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[2]")).size(); 
					 
					 System.out.println( countRows+"Rows are present");
					 
					 logger
						.log(LogStatus.PASS,"<font color='green'>Result: No.of rows are <font/>"+"<b>"+countRows);
				

	
	
	ResultSet data6 = dataBase.getData(ranking_related_queries.RankingBySpeciality_Query);
	
	int count= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td[1]")).size()+1;
	
	
System.out.println(count+"count");
Thread.sleep(3000);
	
	int counter=1;

	
	
while(count>counter) {

while(data6.next()){  	


//Thread.sleep(2000);
  	
WebElement  SpecialityNames= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[2]"));	

WebElement  results= driver.findElement(By.xpath("//*[@id='ranking_table']/tbody/tr["+counter+"]/td[3]"));	

String castSpecialityNames = (String) js.executeScript("return arguments[0].innerText;",SpecialityNames);

String castresults = (String) js.executeScript("return arguments[0].innerText;",results);




System.out.println(castSpecialityNames+castresults +"print");



String resultstext=castresults.replace(",", ".");
String getresutls=resultstext.replaceAll("[^0-9.]", "");


if (castSpecialityNames.equalsIgnoreCase(data6.getString(1))&& getresutls.equalsIgnoreCase(data6.getString(2)) ) {
	
	logger.log(LogStatus.PASS,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
			+"2:Actual row Content On App is "+"<b>"+castSpecialityNames+"|"+getresutls+"</b>"+"<br/>"
			+"3:Expected row Content From DB is "+"<b>"+data6.getString(1)+"|"+"|"+data6.getString(2)+"</b>"+"<br/>"
			+"<b><font color='green'>Result:Row has been Matched <font/>");
	
	
System.out.println(data6.getString(1)+"|"+data6.getString(2)+"|"+" DB");
System.out.println(castSpecialityNames +"|"+ getresutls+"sellers data matched ");
	
}else {
	
	logger.log(LogStatus.FAIL,"1:Row no. is "+"<b>"+counter+"</b>"+"<br/>"
			+"2:Actual row Content On App is "+"<b>"+castSpecialityNames+"|"+getresutls+"</b>"+"<br/>"
			+"3:Expected row Content From DB is "+"<b>"+data6.getString(1)+"|"+data6.getString(2)+"</b>"+"<br/>"
			+"<b><font color='Orange'>Result:either row has same total amount or data is missMatched <font/>");	
}

break;


	}
System.out.println(counter+"counter");

counter=counter+1;    
	
	}	
}	


    
}	
