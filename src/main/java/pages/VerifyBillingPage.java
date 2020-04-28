package pages;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.AppstringsConstant;
import Utility.BillingRelatedQueries;
import Utility.Helper;
import Utility.RankingRelatedQueries;
import webBase.BasePage;
import webBase.BaseTest;
import webBase.DataBase;
import webElements_Identifiers.BillingPage;
import webElements_Identifiers.RankingPage;

public class VerifyBillingPage extends BasePage {

	public ExtentTest logger;	
	public ExtentTest extentest;
	public SoftAssert SAssert = new SoftAssert();
	public PageFactory pf=new PageFactory();
	public  DataBase dataBase = new DataBase();
	public Helper helper=new Helper();

	BaseTest baseT = new BaseTest();
	String className = "";
	BillingPage billing=new BillingPage(driver);
	AppstringsConstant appConst =new AppstringsConstant(); 
	public static BillingRelatedQueries billing_related_queries=new BillingRelatedQueries();
	

public void billingPage(String TestName) throws Throwable {
		
		logger = baseT.extent.startTest(TestName);		
		billing=	PageFactory.initElements(driver, BillingPage.class);
		createDirectory("TELEVENTE"+TestName); 
		
	//	billing.Connection_button.click();
		billing.slider.click();
				
		driver.navigate().to(billing_related_queries.Billing_page_Url);
	
		billing.tlvt_sector.click();
		
		Select sector=new Select(billing.tlvt_sector);
		
		sector.selectByValue(billing_related_queries.sector_id);
		
		Thread.sleep(2000);
		
		billing.tlvt_sellManager.click();
		
		Select manager=new Select(billing.tlvt_sellManager);
		
		manager.selectByValue(billing_related_queries.SellManager_id);
		
		Thread.sleep(2000);
		billing.tlvt_seller.click();
		
		Select sellers=new Select(billing.tlvt_seller);
		sellers.selectByValue(billing_related_queries.Sellers_id);
		
	    billing.btn_apply_filter.click(); 
		
		
		String Televente_title= billing.Televente_title.getText();
				
		if(Televente_title.equalsIgnoreCase(billing_related_queries.televente_name)) {
			
			helper.javaScriptHighlightWebElement(billing.Televente_title);
			
			logger
			.log(LogStatus.PASS,"1:compairing actual title with expected title"+"<br/>"
			+"<b><font color='green'>Result:Televente Title has been verified<font/>"
			+logger
 				.addScreenCapture(captureScreenShot(driver, "Televente Title has been verified")));
			helper.javaScriptUn_HighlightWebElement(billing.Televente_title);

			
		}else {
			helper.javaScriptHighlightWebElement(billing.Televente_title);

			logger
			.log(LogStatus.FAIL,"1:compairing actual title with expected title"+"<br/>"
			+"<b><font color='red'>Result:Televente Title Does not matched to expected title<font/>"
 				+logger
 				.addScreenCapture(captureScreenShot(driver, "Televente Title Does not matched")));
			helper.javaScriptUn_HighlightWebElement(billing.Televente_title);

			
		}
		
	}
	
public  void verifyGlobalBillingSynthesisTab() throws Throwable, SQLException {
	
 String newresultstext="";
	
	ResultSet data = dataBase.getData(billing_related_queries.BillingSynthesis_Query);
	
	//sql loop
	
	JavascriptExecutor js=(JavascriptExecutor)driver;


	 int countRows= driver.findElements(By.xpath("//*[@id='telev_table']/tbody/tr/td")).size(); 
	 
	 System.out.println( countRows+"systhesis columns are present");
	 
	 logger
		.log(LogStatus.INFO,"<font color='blue'><u>No.of Global billing Synthesis Tabs are </u><font/>"+"<b>"+countRows);
    	
	 
	int count= driver.findElements(By.xpath("//*[@id='telev_table']/tbody/tr/td")).size()+1;		
	
	System.out.println(count+"count");
		Thread.sleep(3000);
	
			int counter=1;
			 int arraycounter=0;

			while(data.next()){  

			while(count>counter) {
				
	    	
WebElement  SythesisTabs= driver.findElement(By.xpath("//*[@id='telev_table']/tbody/tr/td["+counter+"]"));	

	
String castSythesisTabs = (String) js.executeScript("return arguments[0].innerText;",SythesisTabs);


	if(castSythesisTabs.contains(",")) {
			String resultstext=castSythesisTabs.replace(",", ".");

			 newresultstext=resultstext.replaceAll("[^0-9.]", "");

	}else {
		
		 newresultstext=castSythesisTabs;
	}
	
	 ArrayList<String> arrlist = new ArrayList<String>();
	 arrlist.add("Taux de Rapprochement	");
	 arrlist.add("Nombre de commandes");
	 arrlist.add("CA Commande");
	 arrlist.add("Nombre de Commandes avec Bons");
	 arrlist.add("CA Total Bon Facture");
	 arrlist.add("CA Articles Televente Facture");
	 arrlist.add("Marge Articles Televente Facture ");
	 arrlist.add("% Marge Articles Televente Facture");
	

	while(arrlist.size()>arraycounter) {
			
	if(newresultstext.equals(data.getString(counter))) {
		
		helper.javaScriptHighlightWebElement(SythesisTabs);
		logger.log(LogStatus.PASS,"1:Tab name  is "+"<b>"+arrlist.get(arraycounter)+"</b>"+"<br/>"
				+"2:Actual value On App is "+"<b>"+newresultstext+"</b>"+"<br/>"
				+"3:Expected value From DB is "+"<b>"+data.getString(counter)+"</b>"+"<br/>"
				+"<b><font color='green'>Result:Tab value has been Matched <font/>"
				+logger.addScreenCapture(captureScreenShot(driver, "Billing Synthesis"+arraycounter)));
		helper.javaScriptUn_HighlightWebElement(SythesisTabs);

		}else {
			
			helper.javaScriptHighlightWebElement(SythesisTabs);

			logger.log(LogStatus.FAIL,"1:Tab name  is "+"<b>"+arrlist.get(arraycounter)+"</b>"+"<br/>"
					+"2:Actual value On App is "+"<b>"+newresultstext+"</b>"+"<br/>"
					+"3:Expected value From DB is "+"<b>"+data.getString(counter)+"</b>"+"<br/>"
					+"<b><font color='red'>Result:Tab value does not matched as Expected <font/>"		
					+logger.addScreenCapture(captureScreenShot(driver, "Billing Synthesis"+arraycounter)));
			helper.javaScriptUn_HighlightWebElement(SythesisTabs);
			

		}
	
	System.out.println(arraycounter);
	System.out.println(arrlist.get(arraycounter));
	System.out.println(newresultstext+" app");	
	System.out.println(data.getString(counter)+" DB");	
	break;
	
	}
	arraycounter=arraycounter+1;

counter=counter+1;	

			}
				
		}		


}


// Sell View for Sectors

public void verifySellViewOfSector() throws Throwable, SQLException {
	
	ResultSet data = dataBase.getData(billing_related_queries.SellViewOfSector_Query);
	
	//sql loop
	
	Thread.sleep(3000);
	
	JavascriptExecutor js=(JavascriptExecutor)driver;


	 int countRows= driver.findElements(By.xpath("//tr[contains(@node-id,'sector')]/td[1]")).size(); 
	 
	 System.out.println( countRows+"sectors rows are ");
	 
	 logger
		.log(LogStatus.INFO,"<font color='blue'><u><b>1:Verifying Sell View For Sector</u><font/>"+"</br>"
	 +"2: and no.of rows are "+countRows);
    	
	 
	 List<WebElement> Axes= driver.findElements(By.xpath("//tr[contains(@node-id,'sector')]/td[1]"));	
	
	 List<WebElement> matching_rate= driver.findElements(By.xpath("//tr[contains(@node-id,'sector')]/td[2]"));
	 
	 List<WebElement>  total_orders= driver.findElements(By.xpath("//tr[contains(@node-id,'sector')]/td[3]"));
	 
	 List<WebElement>  total_turnover= driver.findElements(By.xpath("//tr[contains(@node-id,'sector')]/td[4]"));
	 
	 List<WebElement>  total_invoices_orders= driver.findElements(By.xpath("//tr[contains(@node-id,'sector')]/td[5]"));
	 
	 List<WebElement>  Article_invoices_turnover= driver.findElements(By.xpath("//tr[contains(@node-id,'sector')]/td[6]"));
	 
	 List<WebElement>  Article_televente_turnover= driver.findElements(By.xpath("//tr[contains(@node-id,'sector')]/td[7]"));
	 
	 List<WebElement>  Article_invoices_margin= driver.findElements(By.xpath("//tr[contains(@node-id,'sector')]/td[8]"));
	 
	 List<WebElement>  Article_invoices_percentage= driver.findElements(By.xpath("//tr[contains(@node-id,'sector')]/td[9]"));	


	
	 Iterator<WebElement> iter = Axes.iterator();
	 
	 Iterator<WebElement> iter1 = matching_rate.iterator();

	 Iterator<WebElement> iter2 = total_orders.iterator();

	 Iterator<WebElement> iter3 = total_turnover.iterator();

	 Iterator<WebElement> iter4 = total_invoices_orders.iterator();

	 Iterator<WebElement> iter5 = Article_invoices_turnover.iterator();

	 Iterator<WebElement> iter6 = Article_televente_turnover.iterator();

	 Iterator<WebElement> iter7 = Article_invoices_margin.iterator();

	 Iterator<WebElement> iter8 = Article_invoices_percentage.iterator();

 while(data.next()) {
	 
	 
	 while(iter.hasNext()) {
	  
		    WebElement getAxes = iter.next();

			 while(iter1.hasNext()) {

				    WebElement getmatching_rate = iter1.next();

					 while(iter2.hasNext()) {
						 
						    WebElement gettotal_orders = iter2.next();

						    
						    while(iter3.hasNext()) {
								 
							    WebElement gettotal_turnover = iter3.next();


							    while(iter4.hasNext()) {
									 
								    WebElement gettotal_invoices_orders = iter4.next();

								    while(iter5.hasNext()) {
										 
									    WebElement getArticle_invoices_turnover = iter5.next();
									    
									    
									    while(iter6.hasNext()) {
											 
										    WebElement getArticle_televente_turnover = iter6.next();
										
										    while(iter7.hasNext()) {
												 
											    WebElement getArticle_invoices_margin = iter7.next();
											
											    
											    while(iter8.hasNext()) {
													 
												    WebElement getArticle_invoices_percentage = iter8.next();
												

	 String castAxes = (String) js.executeScript("return arguments[0].innerText;",getAxes);
	 
	 String castmatching_rate = (String) js.executeScript("return arguments[0].innerText;",getmatching_rate);

	 String casttotal_orders = (String) js.executeScript("return arguments[0].innerText;",gettotal_orders);

	 String casttotal_turnover = (String) js.executeScript("return arguments[0].innerText;",gettotal_turnover);
	 
	 String casttotal_invoices_orders = (String) js.executeScript("return arguments[0].innerText;",gettotal_invoices_orders);
	 
	 String castArticle_invoices_turnover = (String) js.executeScript("return arguments[0].innerText;",getArticle_invoices_turnover);
	 
	 String castArticle_televente_turnover = (String) js.executeScript("return arguments[0].innerText;",getArticle_televente_turnover);
	 
	 String castArticle_invoices_margin = (String) js.executeScript("return arguments[0].innerText;",getArticle_invoices_margin);
	 
	 String castArticle_invoices_percentage = (String) js.executeScript("return arguments[0].innerText;",getArticle_invoices_percentage);
	 

	 //filtered matching rate column
	 String castmatching_rate_text=castmatching_rate.replace(",", ".");

	String  Newmatching_rate_text=castmatching_rate_text.replaceAll("[^0-9.]", "");
	 

	 //filtered  total turnover columns
	 String casttotal_turnover_Text=casttotal_turnover.replace(",", ".");

	String  NEw_total_turnover_Text=casttotal_turnover_Text.replaceAll("[^0-9.]", "");
	

	 //filtered  Article invoices turnover column
	 String castArticle_invoices_turnover_Text=castArticle_invoices_turnover.replace(",", ".");

		String  New_Article_invoices_turnover_Text=castArticle_invoices_turnover_Text.replaceAll("[^0-9.]", "");


		 //filtered Article Televente turnover column
		 String castArticle_televente_turnover_Text=castArticle_televente_turnover.replace(",", ".");

			String  New_Article_televente_turnover_Text=castArticle_televente_turnover_Text.replaceAll("[^0-9.]", "");


			 //filtered  Article_invoices_margin column
	
			 String castArticle_invoices_margin_Text=castArticle_invoices_margin.replace(",", ".");

				String  New_Article_invoices_margin_Text=castArticle_invoices_margin_Text.replaceAll("[^0-9.]", "");

				 //filtered  Article_invoices_percentage column

			
			 String castArticle_invoices_percentage_Text=castArticle_invoices_percentage.replace(",", ".");

				String  New_Article_invoices_percentage_Text=castArticle_invoices_percentage_Text.replaceAll("[^0-9.]", "");
		
	
				
			
if(castAxes.equalsIgnoreCase(data.getString(1))
		&& Newmatching_rate_text.equalsIgnoreCase(data.getString(2))
		&& casttotal_orders.equalsIgnoreCase(data.getString(3))
		&& NEw_total_turnover_Text.equalsIgnoreCase(data.getString(4))
		&& casttotal_invoices_orders.equalsIgnoreCase(data.getString(5))
		&& New_Article_invoices_turnover_Text.equalsIgnoreCase(data.getString(6))
		&& New_Article_televente_turnover_Text.equalsIgnoreCase(data.getString(7))
		&& New_Article_invoices_margin_Text.equalsIgnoreCase(data.getString(8))
		&& New_Article_invoices_percentage_Text.equalsIgnoreCase(data.getString(9))
		) {
	
	logger.log(LogStatus.PASS,"2:Actual row Content On App is "
			+"<b>"+castAxes+"|"+Newmatching_rate_text+"|"+casttotal_orders+"|"+
			NEw_total_turnover_Text+"|"+casttotal_invoices_orders+"|"+New_Article_invoices_turnover_Text
			+"|"+New_Article_televente_turnover_Text+"|"+New_Article_invoices_margin_Text+"|"+New_Article_invoices_percentage_Text+"</b>"+"<br/>"
			+"3:Expected row Content From DB is "+"<b>"+data.getString(1)+"|"+data.getString(2)+"|"+data.getString(3)+
			"|"+data.getString(4)+"|"+data.getString(5)+"|"+data.getString(6)+"|"+data.getString(7)+"|"+data.getString(8)+"|"+data.getString(9)+"</b>"+"<br/>"
			+"<b><font color='green'>Result:Row has been Matched <font/>");

}else {
	
	logger.log(LogStatus.FAIL,"2:Actual row Content On App is "
			+"<b>"+castAxes+"|"+Newmatching_rate_text+"|"+casttotal_orders+"|"+
			NEw_total_turnover_Text+"|"+casttotal_invoices_orders+"|"+New_Article_invoices_turnover_Text
			+"|"+New_Article_televente_turnover_Text+"|"+New_Article_invoices_margin_Text+"|"+New_Article_invoices_percentage_Text+"</b>"+"<br/>"
			+"3:Expected row Content From DB is "+"<b>"+data.getString(1)+"|"+data.getString(2)+"|"+data.getString(3)+
			"|"+data.getString(4)+"|"+data.getString(5)+"|"+data.getString(6)+"|"+data.getString(7)+"|"+data.getString(8)+"|"+data.getString(9)+"</b>"+"<br/>"
			+"<b><font color='red'>Result:Row has been missmatched <font/>");

}
				
				
	System.out.println(castAxes+" "+castmatching_rate+" "+casttotal_orders+" "
	+casttotal_turnover+" "+casttotal_invoices_orders+" "+castArticle_invoices_turnover+" "+castArticle_televente_turnover 
	+""+castArticle_invoices_margin+" "+castArticle_invoices_percentage);						
	 
	System.out.println(data.getString(1)+" "+data.getString(2)+" "+data.getString(3)+" "
	+data.getString(4)+" "+data.getString(5)+" "+data.getString(6)+" "+data.getString(7)+" "
	+data.getString(8)+" "+data.getString(9)+" "+data.getString(10)+" DB"); 
	
												break;
											    } 
	
					                     break;
					                  }
		                     	break;		 
			                  }
					       break; 
	                    }			 
						break;
					}
			      break; 
			}
			break;						    
		}
	
	break;					    
	 }
	break;				 
}		 

}
	 
}	 


public void verifySellViewofSellManager() throws Throwable, SQLException {
	

 driver.findElement(By.xpath("//*[@node-id='sector-"+billing_related_queries.sector_id+"']")).click();
	
	ResultSet data = dataBase.getData(billing_related_queries.SellView_sellManagerRelated_Query);
	
	//sql loop
	
	Thread.sleep(3000);
	
	JavascriptExecutor js=(JavascriptExecutor)driver;


 int countRows= driver.findElements(By.xpath("//tr[contains(@node-id,'sellManager-1431')]/td[1]")).size(); 
	 
	 System.out.println( countRows+"no.of sellmanager rows are");
	 
	 logger
		.log(LogStatus.INFO,"<font color='blue'><u><b>1:Verifying Sell View For Sell Managers</u><font/>"+"</br>"
	 +"2: and no.of rows are "+countRows);
 	
	 
	 List<WebElement> Axes= driver.findElements(By.xpath("//tr[contains(@node-id,'sellManager-"+billing_related_queries.SellManager_id+"')]/td[1]"));	
	
	 List<WebElement> matching_rate= driver.findElements(By.xpath("//tr[contains(@node-id,'sellManager-"+billing_related_queries.SellManager_id+"')]/td[2]"));
	 
	 List<WebElement>  total_orders= driver.findElements(By.xpath("//tr[contains(@node-id,'sellManager-"+billing_related_queries.SellManager_id+"')]/td[3]"));
	 
	 List<WebElement>  total_turnover= driver.findElements(By.xpath("//tr[contains(@node-id,'sellManager-"+billing_related_queries.SellManager_id+"')]/td[4]"));
	 
	 List<WebElement>  total_invoices_orders= driver.findElements(By.xpath("//tr[contains(@node-id,'sellManager-"+billing_related_queries.SellManager_id+"')]/td[5]"));
	 
	 List<WebElement>  Article_invoices_turnover= driver.findElements(By.xpath("//tr[contains(@node-id,'sellManager-"+billing_related_queries.SellManager_id+"')]/td[6]"));
	 
	 List<WebElement>  Article_televente_turnover= driver.findElements(By.xpath("//tr[contains(@node-id,'sellManager-"+billing_related_queries.SellManager_id+"')]/td[7]"));
	 
	 List<WebElement>  Article_invoices_margin= driver.findElements(By.xpath("//tr[contains(@node-id,'sellManager-"+billing_related_queries.SellManager_id+"')]/td[8]"));
	 
	 List<WebElement>  Article_invoices_percentage= driver.findElements(By.xpath("//tr[contains(@node-id,'sellManager-"+billing_related_queries.SellManager_id+"')]/td[9]"));	


	
	 Iterator<WebElement> iter = Axes.iterator();
	 
	 Iterator<WebElement> iter1 = matching_rate.iterator();

	 Iterator<WebElement> iter2 = total_orders.iterator();

	 Iterator<WebElement> iter3 = total_turnover.iterator();

	 Iterator<WebElement> iter4 = total_invoices_orders.iterator();

	 Iterator<WebElement> iter5 = Article_invoices_turnover.iterator();

	 Iterator<WebElement> iter6 = Article_televente_turnover.iterator();

	 Iterator<WebElement> iter7 = Article_invoices_margin.iterator();

	 Iterator<WebElement> iter8 = Article_invoices_percentage.iterator();

 while(data.next()) {
	 
	 
	 while(iter.hasNext()) {
	  
		    WebElement getAxes = iter.next();

			 while(iter1.hasNext()) {

				    WebElement getmatching_rate = iter1.next();

					 while(iter2.hasNext()) {
						 
						    WebElement gettotal_orders = iter2.next();

						    
						    while(iter3.hasNext()) {
								 
							    WebElement gettotal_turnover = iter3.next();


							    while(iter4.hasNext()) {
									 
								    WebElement gettotal_invoices_orders = iter4.next();

								    while(iter5.hasNext()) {
										 
									    WebElement getArticle_invoices_turnover = iter5.next();
									    
									    
									    while(iter6.hasNext()) {
											 
										    WebElement getArticle_televente_turnover = iter6.next();
										
										    while(iter7.hasNext()) {
												 
											    WebElement getArticle_invoices_margin = iter7.next();
											
											    
											    while(iter8.hasNext()) {
													 
												    WebElement getArticle_invoices_percentage = iter8.next();
												

	 String castAxes = (String) js.executeScript("return arguments[0].innerText;",getAxes);
	 
	 String castmatching_rate = (String) js.executeScript("return arguments[0].innerText;",getmatching_rate);

	 String casttotal_orders = (String) js.executeScript("return arguments[0].innerText;",gettotal_orders);

	 String casttotal_turnover = (String) js.executeScript("return arguments[0].innerText;",gettotal_turnover);
	 
	 String casttotal_invoices_orders = (String) js.executeScript("return arguments[0].innerText;",gettotal_invoices_orders);
	 
	 String castArticle_invoices_turnover = (String) js.executeScript("return arguments[0].innerText;",getArticle_invoices_turnover);
	 
	 String castArticle_televente_turnover = (String) js.executeScript("return arguments[0].innerText;",getArticle_televente_turnover);
	 
	 String castArticle_invoices_margin = (String) js.executeScript("return arguments[0].innerText;",getArticle_invoices_margin);
	 
	 String castArticle_invoices_percentage = (String) js.executeScript("return arguments[0].innerText;",getArticle_invoices_percentage);
	 

	 //filtered matching rate column
	 String castmatching_rate_text=castmatching_rate.replace(",", ".");

	String  Newmatching_rate_text=castmatching_rate_text.replaceAll("[^0-9.]", "");
	 

	 //filtered  total turnover columns
	 String casttotal_turnover_Text=casttotal_turnover.replace(",", ".");

	String  NEw_total_turnover_Text=casttotal_turnover_Text.replaceAll("[^0-9.]", "");
	

	 //filtered  Article invoices turnover column
	 String castArticle_invoices_turnover_Text=castArticle_invoices_turnover.replace(",", ".");

		String  New_Article_invoices_turnover_Text=castArticle_invoices_turnover_Text.replaceAll("[^0-9.]", "");


		 //filtered Article Televente turnover column
		 String castArticle_televente_turnover_Text=castArticle_televente_turnover.replace(",", ".");

			String  New_Article_televente_turnover_Text=castArticle_televente_turnover_Text.replaceAll("[^0-9.]", "");


			 //filtered  Article_invoices_margin column
	
			 String castArticle_invoices_margin_Text=castArticle_invoices_margin.replace(",", ".");

				String  New_Article_invoices_margin_Text=castArticle_invoices_margin_Text.replaceAll("[^0-9.]", "");

				 //filtered  Article_invoices_percentage column

			
			 String castArticle_invoices_percentage_Text=castArticle_invoices_percentage.replace(",", ".");

				String  New_Article_invoices_percentage_Text=castArticle_invoices_percentage_Text.replaceAll("[^0-9.]", "");
		
	
				
			
if(castAxes.equalsIgnoreCase(data.getString(1))
		&& Newmatching_rate_text.equalsIgnoreCase(data.getString(2))
		&& casttotal_orders.equalsIgnoreCase(data.getString(3))
		&& NEw_total_turnover_Text.equalsIgnoreCase(data.getString(4))
		&& casttotal_invoices_orders.equalsIgnoreCase(data.getString(5))
		&& New_Article_invoices_turnover_Text.equalsIgnoreCase(data.getString(6))
		&& New_Article_televente_turnover_Text.equalsIgnoreCase(data.getString(7))
		&& New_Article_invoices_margin_Text.equalsIgnoreCase(data.getString(8))
		&& New_Article_invoices_percentage_Text.equalsIgnoreCase(data.getString(9))
		) {
	
	logger.log(LogStatus.PASS,"2:Actual row Content On App is "
			+"<b>"+castAxes+"|"+Newmatching_rate_text+"|"+casttotal_orders+"|"+
			NEw_total_turnover_Text+"|"+casttotal_invoices_orders+"|"+New_Article_invoices_turnover_Text
			+"|"+New_Article_televente_turnover_Text+"|"+New_Article_invoices_margin_Text+"|"+New_Article_invoices_percentage_Text+"</b>"+"<br/>"
			+"3:Expected row Content From DB is "+"<b>"+data.getString(1)+"|"+data.getString(2)+"|"+data.getString(3)+
			"|"+data.getString(4)+"|"+data.getString(5)+"|"+data.getString(6)+"|"+data.getString(7)+"|"+data.getString(8)+"|"+data.getString(9)+"</b>"+"<br/>"
			+"<b><font color='green'>Result:Row has been Matched <font/>");

}else {
	
	logger.log(LogStatus.FAIL,"2:Actual row Content On App is "
			+"<b>"+castAxes+"|"+Newmatching_rate_text+"|"+casttotal_orders+"|"+
			NEw_total_turnover_Text+"|"+casttotal_invoices_orders+"|"+New_Article_invoices_turnover_Text
			+"|"+New_Article_televente_turnover_Text+"|"+New_Article_invoices_margin_Text+"|"+New_Article_invoices_percentage_Text+"</b>"+"<br/>"
			+"3:Expected row Content From DB is "+"<b>"+data.getString(1)+"|"+data.getString(2)+"|"+data.getString(3)+
			"|"+data.getString(4)+"|"+data.getString(5)+"|"+data.getString(6)+"|"+data.getString(7)+"|"+data.getString(8)+"|"+data.getString(9)+"</b>"+"<br/>"
			+"<b><font color='red'>Result:Row has been missmatched <font/>");

}
				

	 
	System.out.println(castAxes+" "+castmatching_rate+" "+casttotal_orders+" "
	+casttotal_turnover+" "+casttotal_invoices_orders+" "+castArticle_invoices_turnover+" "+castArticle_televente_turnover 
	+""+castArticle_invoices_margin+" "+castArticle_invoices_percentage);						
	 
	System.out.println(data.getString(1)+" "+data.getString(2)+" "+data.getString(3)+" "
	+data.getString(4)+" "+data.getString(5)+" "+data.getString(6)+" "+data.getString(7)+" "
	+data.getString(8)+" "+data.getString(9)+" "+data.getString(10)+" DB"); 
	
												break;
											    } 
	
					                     break;
					                  }
		                     	break;		 
			                  }
					       break; 
	                    }			 
						break;
					}
			      break; 
			}
			break;						    
		}
	
	break;					    
	 }
	break;				 
  }		 

}

}




 public void verifySellViewofSellers() throws Throwable, SQLException {
		

		Thread.sleep(3000);

	 driver.findElement(By.xpath("//*[@node-id='sellManager-"+billing_related_queries.SellManager_id+"']")).click();
		
		ResultSet data = dataBase.getData(billing_related_queries.SellView_sellersRelated_Query);
		
		//sql loop
		
		Thread.sleep(2000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;


	 int countRows= driver.findElements(By.xpath("//tr[contains(@node-id,'seller-"+billing_related_queries.Sellers_id+"')]/td[1]")).size(); 
		 
		 System.out.println( countRows+"no.of sellers rows are");
		 
		 logger
			.log(LogStatus.INFO,"<font color='blue'><u><b>1:Verifying Sell View For Sellers</u><font/>"+"</br>"
		 +"2: and no.of rows are "+countRows);
	 	    	
		 
		 List<WebElement> Axes= driver.findElements(By.xpath("//tr[contains(@node-id,'seller-"+billing_related_queries.Sellers_id+"')]/td[1]"));	
		
		 List<WebElement> matching_rate= driver.findElements(By.xpath("//tr[contains(@node-id,'seller-"+billing_related_queries.Sellers_id+"')]/td[2]"));
		 
		 List<WebElement>  total_orders= driver.findElements(By.xpath("//tr[contains(@node-id,'seller-"+billing_related_queries.Sellers_id+"')]/td[3]"));
		 
		 List<WebElement>  total_turnover= driver.findElements(By.xpath("//tr[contains(@node-id,'seller-"+billing_related_queries.Sellers_id+"')]/td[4]"));
		 
		 List<WebElement>  total_invoices_orders= driver.findElements(By.xpath("//tr[contains(@node-id,'seller-"+billing_related_queries.Sellers_id+"')]/td[5]"));
		 
		 List<WebElement>  Article_invoices_turnover= driver.findElements(By.xpath("//tr[contains(@node-id,'seller-"+billing_related_queries.Sellers_id+"')]/td[6]"));
		 
		 List<WebElement>  Article_televente_turnover= driver.findElements(By.xpath("//tr[contains(@node-id,'seller-"+billing_related_queries.Sellers_id+"')]/td[7]"));
		 
		 List<WebElement>  Article_invoices_margin= driver.findElements(By.xpath("//tr[contains(@node-id,'seller-"+billing_related_queries.Sellers_id+"')]/td[8]"));
		 
		 List<WebElement>  Article_invoices_percentage= driver.findElements(By.xpath("//tr[contains(@node-id,'seller-"+billing_related_queries.Sellers_id+"')]/td[9]"));	


		
		 Iterator<WebElement> iter = Axes.iterator();
		 
		 Iterator<WebElement> iter1 = matching_rate.iterator();

		 Iterator<WebElement> iter2 = total_orders.iterator();

		 Iterator<WebElement> iter3 = total_turnover.iterator();

		 Iterator<WebElement> iter4 = total_invoices_orders.iterator();

		 Iterator<WebElement> iter5 = Article_invoices_turnover.iterator();

		 Iterator<WebElement> iter6 = Article_televente_turnover.iterator();

		 Iterator<WebElement> iter7 = Article_invoices_margin.iterator();

		 Iterator<WebElement> iter8 = Article_invoices_percentage.iterator();

	 while(data.next()) {
		 
		 
		 while(iter.hasNext()) {
		  
			    WebElement getAxes = iter.next();

				 while(iter1.hasNext()) {

					    WebElement getmatching_rate = iter1.next();

						 while(iter2.hasNext()) {
							 
							    WebElement gettotal_orders = iter2.next();

							    
							    while(iter3.hasNext()) {
									 
								    WebElement gettotal_turnover = iter3.next();


								    while(iter4.hasNext()) {
										 
									    WebElement gettotal_invoices_orders = iter4.next();

									    while(iter5.hasNext()) {
											 
										    WebElement getArticle_invoices_turnover = iter5.next();
										    
										    
										    while(iter6.hasNext()) {
												 
											    WebElement getArticle_televente_turnover = iter6.next();
											
											    while(iter7.hasNext()) {
													 
												    WebElement getArticle_invoices_margin = iter7.next();
												
												    
												    while(iter8.hasNext()) {
														 
													    WebElement getArticle_invoices_percentage = iter8.next();
													

		 String castAxes = (String) js.executeScript("return arguments[0].innerText;",getAxes);
		 
		 String castmatching_rate = (String) js.executeScript("return arguments[0].innerText;",getmatching_rate);

		 String casttotal_orders = (String) js.executeScript("return arguments[0].innerText;",gettotal_orders);

		 String casttotal_turnover = (String) js.executeScript("return arguments[0].innerText;",gettotal_turnover);
		 
		 String casttotal_invoices_orders = (String) js.executeScript("return arguments[0].innerText;",gettotal_invoices_orders);
		 
		 String castArticle_invoices_turnover = (String) js.executeScript("return arguments[0].innerText;",getArticle_invoices_turnover);
		 
		 String castArticle_televente_turnover = (String) js.executeScript("return arguments[0].innerText;",getArticle_televente_turnover);
		 
		 String castArticle_invoices_margin = (String) js.executeScript("return arguments[0].innerText;",getArticle_invoices_margin);
		 
		 String castArticle_invoices_percentage = (String) js.executeScript("return arguments[0].innerText;",getArticle_invoices_percentage);
		 
		 
		 
		 //filtered matching rate column
		 String castmatching_rate_text=castmatching_rate.replace(",", ".");

		String  Newmatching_rate_text=castmatching_rate_text.replaceAll("[^0-9.]", "");
		 

		 //filtered  total turnover columns
		 String casttotal_turnover_Text=casttotal_turnover.replace(",", ".");

		String  NEw_total_turnover_Text=casttotal_turnover_Text.replaceAll("[^0-9.]", "");
		

		 //filtered  Article invoices turnover column
		 String castArticle_invoices_turnover_Text=castArticle_invoices_turnover.replace(",", ".");

			String  New_Article_invoices_turnover_Text=castArticle_invoices_turnover_Text.replaceAll("[^0-9.]", "");


			 //filtered Article Televente turnover column
			 String castArticle_televente_turnover_Text=castArticle_televente_turnover.replace(",", ".");

				String  New_Article_televente_turnover_Text=castArticle_televente_turnover_Text.replaceAll("[^0-9.]", "");


				 //filtered  Article_invoices_margin column
		
				 String castArticle_invoices_margin_Text=castArticle_invoices_margin.replace(",", ".");

					String  New_Article_invoices_margin_Text=castArticle_invoices_margin_Text.replaceAll("[^0-9.]", "");

					 //filtered  Article_invoices_percentage column

				
				 String castArticle_invoices_percentage_Text=castArticle_invoices_percentage.replace(",", ".");

					String  New_Article_invoices_percentage_Text=castArticle_invoices_percentage_Text.replaceAll("[^0-9.]", "");
			
		
					
				
	if(castAxes.equalsIgnoreCase(data.getString(1))
			&& Newmatching_rate_text.equalsIgnoreCase(data.getString(2))
			&& casttotal_orders.equalsIgnoreCase(data.getString(3))
			&& NEw_total_turnover_Text.equalsIgnoreCase(data.getString(4))
			&& casttotal_invoices_orders.equalsIgnoreCase(data.getString(5))
			&& New_Article_invoices_turnover_Text.equalsIgnoreCase(data.getString(6))
			&& New_Article_televente_turnover_Text.equalsIgnoreCase(data.getString(7))
			&& New_Article_invoices_margin_Text.equalsIgnoreCase(data.getString(8))
			&& New_Article_invoices_percentage_Text.equalsIgnoreCase(data.getString(9))
			) {
		
		logger.log(LogStatus.PASS,"2:Actual row Content On App is "
				+"<b>"+castAxes+"|"+Newmatching_rate_text+"|"+casttotal_orders+"|"+
				NEw_total_turnover_Text+"|"+casttotal_invoices_orders+"|"+New_Article_invoices_turnover_Text
				+"|"+New_Article_televente_turnover_Text+"|"+New_Article_invoices_margin_Text+"|"+New_Article_invoices_percentage_Text+"</b>"+"<br/>"
				+"3:Expected row Content From DB is "+"<b>"+data.getString(1)+"|"+data.getString(2)+"|"+data.getString(3)+
				"|"+data.getString(4)+"|"+data.getString(5)+"|"+data.getString(6)+"|"+data.getString(7)+"|"+data.getString(8)+"|"+data.getString(9)+"</b>"+"<br/>"
				+"<b><font color='green'>Result:Row has been Matched <font/>");

	}else {
		
		logger.log(LogStatus.FAIL,"2:Actual row Content On App is "
				+"<b>"+castAxes+"|"+Newmatching_rate_text+"|"+casttotal_orders+"|"+
				NEw_total_turnover_Text+"|"+casttotal_invoices_orders+"|"+New_Article_invoices_turnover_Text
				+"|"+New_Article_televente_turnover_Text+"|"+New_Article_invoices_margin_Text+"|"+New_Article_invoices_percentage_Text+"</b>"+"<br/>"
				+"3:Expected row Content From DB is "+"<b>"+data.getString(1)+"|"+data.getString(2)+"|"+data.getString(3)+
				"|"+data.getString(4)+"|"+data.getString(5)+"|"+data.getString(6)+"|"+data.getString(7)+"|"+data.getString(8)+"|"+data.getString(9)+"</b>"+"<br/>"
				+"<b><font color='red'>Result:Row has been missmatched <font/>");

	}
					


		System.out.println(castAxes+" "+castmatching_rate+" "+casttotal_orders+" "
		+casttotal_turnover+" "+casttotal_invoices_orders+" "+castArticle_invoices_turnover+" "+castArticle_televente_turnover 
		+""+castArticle_invoices_margin+" "+castArticle_invoices_percentage);						
		 
		System.out.println(data.getString(1)+" "+data.getString(2)+" "+data.getString(3)+" "
		+data.getString(4)+" "+data.getString(5)+" "+data.getString(6)+" "+data.getString(7)+" "
		+data.getString(8)+" "+data.getString(9)+" "+data.getString(10)+" DB"); 
		
													break;
												    } 
		
						                     break;
						                  }
			                     	break;		 
				                  }
						       break; 
		                    }			 
							break;
						}
				      break; 
				}
				break;						    
			}
		
		break;					    
		 }
		break;				 
	  }		 

	}

 }

 
 //Sell view for customers

 public void verifySellViewofCustomers() throws Throwable, SQLException {
		

		Thread.sleep(3000);

	 driver.findElement(By.xpath("//*[@node-id='seller-"+billing_related_queries.Sellers_id+"']")).click();
		
		ResultSet data = dataBase.getData(billing_related_queries.SellView_CustomerRelated_Query);
		
		//sql loop
		
		Thread.sleep(2000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;


	 int countRows= driver.findElements(By.xpath("//tr[contains(@node-id,'sell-customer')]/td[1]")).size(); 
		 
		 System.out.println( countRows+"customers rows are ");
		 
		 logger
			.log(LogStatus.INFO,"<font color='blue'><u><b>1:Verifying Sell View For customers</u><font/>"+"</br>"
		 +"2: and no.of rows are "+countRows);
	 		
		 
		 List<WebElement> Axes= driver.findElements(By.xpath("//tr[contains(@node-id,'sell-customer')]/td[1]"));	
		
		 List<WebElement> matching_rate= driver.findElements(By.xpath("//tr[contains(@node-id,'sell-customer')]/td[2]"));
		 
		 List<WebElement>  total_orders= driver.findElements(By.xpath("//tr[contains(@node-id,'sell-customer')]/td[3]"));
		 
		 List<WebElement>  total_turnover= driver.findElements(By.xpath("//tr[contains(@node-id,'sell-customer')]/td[4]"));
		 
		 List<WebElement>  total_invoices_orders= driver.findElements(By.xpath("//tr[contains(@node-id,'sell-customer')]/td[5]"));
		 
		 List<WebElement>  Article_invoices_turnover= driver.findElements(By.xpath("//tr[contains(@node-id,'sell-customer')]/td[6]"));
		 
		 List<WebElement>  Article_televente_turnover= driver.findElements(By.xpath("//tr[contains(@node-id,'sell-customer')]/td[7]"));
		 
		 List<WebElement>  Article_invoices_margin= driver.findElements(By.xpath("//tr[contains(@node-id,'sell-customer')]/td[8]"));
		 
		 List<WebElement>  Article_invoices_percentage= driver.findElements(By.xpath("//tr[contains(@node-id,'sell-customer')]/td[9]"));	


		
		 Iterator<WebElement> iter = Axes.iterator();
		 
		 Iterator<WebElement> iter1 = matching_rate.iterator();

		 Iterator<WebElement> iter2 = total_orders.iterator();

		 Iterator<WebElement> iter3 = total_turnover.iterator();

		 Iterator<WebElement> iter4 = total_invoices_orders.iterator();

		 Iterator<WebElement> iter5 = Article_invoices_turnover.iterator();

		 Iterator<WebElement> iter6 = Article_televente_turnover.iterator();

		 Iterator<WebElement> iter7 = Article_invoices_margin.iterator();

		 Iterator<WebElement> iter8 = Article_invoices_percentage.iterator();

	 while(data.next()) {
		 
		 
		 while(iter.hasNext()) {
		  
			    WebElement getAxes = iter.next();

				 while(iter1.hasNext()) {

					    WebElement getmatching_rate = iter1.next();

						 while(iter2.hasNext()) {
							 
							    WebElement gettotal_orders = iter2.next();

							    
							    while(iter3.hasNext()) {
									 
								    WebElement gettotal_turnover = iter3.next();


								    while(iter4.hasNext()) {
										 
									    WebElement gettotal_invoices_orders = iter4.next();

									    while(iter5.hasNext()) {
											 
										    WebElement getArticle_invoices_turnover = iter5.next();
										    
										    
										    while(iter6.hasNext()) {
												 
											    WebElement getArticle_televente_turnover = iter6.next();
											
											    while(iter7.hasNext()) {
													 
												    WebElement getArticle_invoices_margin = iter7.next();
												
												    
												    while(iter8.hasNext()) {
														 
													    WebElement getArticle_invoices_percentage = iter8.next();
													

		 String castAxes = (String) js.executeScript("return arguments[0].innerText;",getAxes);
		 
		 String castmatching_rate = (String) js.executeScript("return arguments[0].innerText;",getmatching_rate);

		 String casttotal_orders = (String) js.executeScript("return arguments[0].innerText;",gettotal_orders);

		 String casttotal_turnover = (String) js.executeScript("return arguments[0].innerText;",gettotal_turnover);
		 
		 String casttotal_invoices_orders = (String) js.executeScript("return arguments[0].innerText;",gettotal_invoices_orders);
		 
		 String castArticle_invoices_turnover = (String) js.executeScript("return arguments[0].innerText;",getArticle_invoices_turnover);
		 
		 String castArticle_televente_turnover = (String) js.executeScript("return arguments[0].innerText;",getArticle_televente_turnover);
		 
		 String castArticle_invoices_margin = (String) js.executeScript("return arguments[0].innerText;",getArticle_invoices_margin);
		 
		 String castArticle_invoices_percentage = (String) js.executeScript("return arguments[0].innerText;",getArticle_invoices_percentage);
		 
		 
		 
		 //filtered matching rate column
		 String castmatching_rate_text=castmatching_rate.replace(",", ".");

		String  Newmatching_rate_text=castmatching_rate_text.replaceAll("[^0-9.]", "");
		 

		 //filtered  total turnover columns
		 String casttotal_turnover_Text=casttotal_turnover.replace(",", ".");

		String  NEw_total_turnover_Text=casttotal_turnover_Text.replaceAll("[^0-9.]", "");
		

		 //filtered  Article invoices turnover column
		 String castArticle_invoices_turnover_Text=castArticle_invoices_turnover.replace(",", ".");

			String  New_Article_invoices_turnover_Text=castArticle_invoices_turnover_Text.replaceAll("[^0-9.]", "");


			 //filtered Article Televente turnover column
			 String castArticle_televente_turnover_Text=castArticle_televente_turnover.replace(",", ".");

				String  New_Article_televente_turnover_Text=castArticle_televente_turnover_Text.replaceAll("[^0-9.]", "");


				 //filtered  Article_invoices_margin column
		
				 String castArticle_invoices_margin_Text=castArticle_invoices_margin.replace(",", ".");

					String  New_Article_invoices_margin_Text=castArticle_invoices_margin_Text.replaceAll("[^0-9.]", "");

					 //filtered  Article_invoices_percentage column

				
				 String castArticle_invoices_percentage_Text=castArticle_invoices_percentage.replace(",", ".");

					String  New_Article_invoices_percentage_Text=castArticle_invoices_percentage_Text.replaceAll("[^0-9.]", "");
			
		
					
				
	if(castAxes.equalsIgnoreCase(data.getString(1))
			&& Newmatching_rate_text.equalsIgnoreCase(data.getString(2))
			&& casttotal_orders.equalsIgnoreCase(data.getString(3))
			&& NEw_total_turnover_Text.equalsIgnoreCase(data.getString(4))
			&& casttotal_invoices_orders.equalsIgnoreCase(data.getString(5))
			&& New_Article_invoices_turnover_Text.equalsIgnoreCase(data.getString(6))
			&& New_Article_televente_turnover_Text.equalsIgnoreCase(data.getString(7))
			&& New_Article_invoices_margin_Text.equalsIgnoreCase(data.getString(8))
			&& New_Article_invoices_percentage_Text.equalsIgnoreCase(data.getString(9))
			) {
		
		logger.log(LogStatus.PASS,"2:Actual row Content On App is "
				+"<b>"+castAxes+"|"+Newmatching_rate_text+"|"+casttotal_orders+"|"+
				NEw_total_turnover_Text+"|"+casttotal_invoices_orders+"|"+New_Article_invoices_turnover_Text
				+"|"+New_Article_televente_turnover_Text+"|"+New_Article_invoices_margin_Text+"|"+New_Article_invoices_percentage_Text+"</b>"+"<br/>"
				+"3:Expected row Content From DB is "+"<b>"+data.getString(1)+"|"+data.getString(2)+"|"+data.getString(3)+
				"|"+data.getString(4)+"|"+data.getString(5)+"|"+data.getString(6)+"|"+data.getString(7)+"|"+data.getString(8)+"|"+data.getString(9)+"</b>"+"<br/>"
				+"<b><font color='green'>Result:Row has been Matched <font/>");

	}else {
		
		logger.log(LogStatus.FAIL,"2:Actual row Content On App is "
				+"<b>"+castAxes+"|"+Newmatching_rate_text+"|"+casttotal_orders+"|"+
				NEw_total_turnover_Text+"|"+casttotal_invoices_orders+"|"+New_Article_invoices_turnover_Text
				+"|"+New_Article_televente_turnover_Text+"|"+New_Article_invoices_margin_Text+"|"+New_Article_invoices_percentage_Text+"</b>"+"<br/>"
				+"3:Expected row Content From DB is "+"<b>"+data.getString(1)+"|"+data.getString(2)+"|"+data.getString(3)+
				"|"+data.getString(4)+"|"+data.getString(5)+"|"+data.getString(6)+"|"+data.getString(7)+"|"+data.getString(8)+"|"+data.getString(9)+"</b>"+"<br/>"
				+"<b><font color='red'>Result:Row has been missmatched <font/>");

	}
					


		System.out.println(castAxes+" "+castmatching_rate+" "+casttotal_orders+" "
		+casttotal_turnover+" "+casttotal_invoices_orders+" "+castArticle_invoices_turnover+" "+castArticle_televente_turnover 
		+""+castArticle_invoices_margin+" "+castArticle_invoices_percentage);						
		 
		System.out.println(data.getString(1)+" "+data.getString(2)+" "+data.getString(3)+" "
		+data.getString(4)+" "+data.getString(5)+" "+data.getString(6)+" "+data.getString(7)+" "
		+data.getString(8)+" "+data.getString(9)+" "+data.getString(10)+" DB"); 
		
													break;
												    } 
		
						                     break;
						                  }
			                     	break;		 
				                  }
						       break; 
		                    }			 
							break;
						}
				      break; 
				}
				break;						    
			}
		
		break;					    
		 }
		break;				 
	  }		 

	}

 }
 
 
 
 
 
//Sell View for Sectors

public void verifyGeographicViewForSector() throws Throwable, SQLException {
	
	ResultSet data = dataBase.getData(billing_related_queries.SellViewOfSector_Query);
	
	//sql loop
	
	Thread.sleep(3000);
	
	billing.btn_filters_reset.click();
	
	billing.tlvt_axis.click();
	
	Select axis=new Select(billing.tlvt_axis);
	
	axis.selectByValue("geographic");
	
	
	Thread.sleep(3000);
	
	billing.tlvt_sector.click();
	
	Select sector=new Select(billing.tlvt_sector);
	
	sector.selectByValue(billing_related_queries.sector_id);
	

	Thread.sleep(3000);
	billing.tlvt_site.click();
	
	Select tlvt_site=new Select(billing.tlvt_site);
	
	tlvt_site.selectByValue(billing_related_queries.site_id);
	
	
	Thread.sleep(3000);
	billing.tlvt_agency.click();
	
	Select tlvt_agency=new Select(billing.tlvt_agency);
	
	tlvt_agency.selectByValue(billing_related_queries.agency_id);
	
	Thread.sleep(3000);
	billing.btn_apply_filter.click();
	
	
	JavascriptExecutor js=(JavascriptExecutor)driver;

	Thread.sleep(3000);

	 int countRows= driver.findElements(By.xpath("//tr[contains(@node-id,'sector')]/td[1]")).size(); 
	 
	 System.out.println( countRows+"sectors rows are ");
	 
	 logger
		.log(LogStatus.INFO,"<font color='blue'><u><b>1:Verifying Geographic View For Sector</u><font/>"+"</br>"
	 +"2: and no.of rows are "+countRows);
  	
	 
	 List<WebElement> Axes= driver.findElements(By.xpath("//tr[contains(@node-id,'sector')]/td[1]"));	
	
	 List<WebElement> matching_rate= driver.findElements(By.xpath("//tr[contains(@node-id,'sector')]/td[2]"));
	 
	 List<WebElement>  total_orders= driver.findElements(By.xpath("//tr[contains(@node-id,'sector')]/td[3]"));
	 
	 List<WebElement>  total_turnover= driver.findElements(By.xpath("//tr[contains(@node-id,'sector')]/td[4]"));
	 
	 List<WebElement>  total_invoices_orders= driver.findElements(By.xpath("//tr[contains(@node-id,'sector')]/td[5]"));
	 
	 List<WebElement>  Article_invoices_turnover= driver.findElements(By.xpath("//tr[contains(@node-id,'sector')]/td[6]"));
	 
	 List<WebElement>  Article_televente_turnover= driver.findElements(By.xpath("//tr[contains(@node-id,'sector')]/td[7]"));
	 
	 List<WebElement>  Article_invoices_margin= driver.findElements(By.xpath("//tr[contains(@node-id,'sector')]/td[8]"));
	 
	 List<WebElement>  Article_invoices_percentage= driver.findElements(By.xpath("//tr[contains(@node-id,'sector')]/td[9]"));	


	
	 Iterator<WebElement> iter = Axes.iterator();
	 
	 Iterator<WebElement> iter1 = matching_rate.iterator();

	 Iterator<WebElement> iter2 = total_orders.iterator();

	 Iterator<WebElement> iter3 = total_turnover.iterator();

	 Iterator<WebElement> iter4 = total_invoices_orders.iterator();

	 Iterator<WebElement> iter5 = Article_invoices_turnover.iterator();

	 Iterator<WebElement> iter6 = Article_televente_turnover.iterator();

	 Iterator<WebElement> iter7 = Article_invoices_margin.iterator();

	 Iterator<WebElement> iter8 = Article_invoices_percentage.iterator();

while(data.next()) {
	 
	 
	 while(iter.hasNext()) {
	  
		    WebElement getAxes = iter.next();

			 while(iter1.hasNext()) {

				    WebElement getmatching_rate = iter1.next();

					 while(iter2.hasNext()) {
						 
						    WebElement gettotal_orders = iter2.next();

						    
						    while(iter3.hasNext()) {
								 
							    WebElement gettotal_turnover = iter3.next();


							    while(iter4.hasNext()) {
									 
								    WebElement gettotal_invoices_orders = iter4.next();

								    while(iter5.hasNext()) {
										 
									    WebElement getArticle_invoices_turnover = iter5.next();
									    
									    
									    while(iter6.hasNext()) {
											 
										    WebElement getArticle_televente_turnover = iter6.next();
										
										    while(iter7.hasNext()) {
												 
											    WebElement getArticle_invoices_margin = iter7.next();
											
											    
											    while(iter8.hasNext()) {
													 
												    WebElement getArticle_invoices_percentage = iter8.next();
												

	 String castAxes = (String) js.executeScript("return arguments[0].innerText;",getAxes);
	 
	 String castmatching_rate = (String) js.executeScript("return arguments[0].innerText;",getmatching_rate);

	 String casttotal_orders = (String) js.executeScript("return arguments[0].innerText;",gettotal_orders);

	 String casttotal_turnover = (String) js.executeScript("return arguments[0].innerText;",gettotal_turnover);
	 
	 String casttotal_invoices_orders = (String) js.executeScript("return arguments[0].innerText;",gettotal_invoices_orders);
	 
	 String castArticle_invoices_turnover = (String) js.executeScript("return arguments[0].innerText;",getArticle_invoices_turnover);
	 
	 String castArticle_televente_turnover = (String) js.executeScript("return arguments[0].innerText;",getArticle_televente_turnover);
	 
	 String castArticle_invoices_margin = (String) js.executeScript("return arguments[0].innerText;",getArticle_invoices_margin);
	 
	 String castArticle_invoices_percentage = (String) js.executeScript("return arguments[0].innerText;",getArticle_invoices_percentage);
	 

	 //filtered matching rate column
	 String castmatching_rate_text=castmatching_rate.replace(",", ".");

	String  Newmatching_rate_text=castmatching_rate_text.replaceAll("[^0-9.]", "");
	 

	 //filtered  total turnover columns
	 String casttotal_turnover_Text=casttotal_turnover.replace(",", ".");

	String  NEw_total_turnover_Text=casttotal_turnover_Text.replaceAll("[^0-9.]", "");
	

	 //filtered  Article invoices turnover column
	 String castArticle_invoices_turnover_Text=castArticle_invoices_turnover.replace(",", ".");

		String  New_Article_invoices_turnover_Text=castArticle_invoices_turnover_Text.replaceAll("[^0-9.]", "");


		 //filtered Article Televente turnover column
		 String castArticle_televente_turnover_Text=castArticle_televente_turnover.replace(",", ".");

			String  New_Article_televente_turnover_Text=castArticle_televente_turnover_Text.replaceAll("[^0-9.]", "");


			 //filtered  Article_invoices_margin column
	
			 String castArticle_invoices_margin_Text=castArticle_invoices_margin.replace(",", ".");

				String  New_Article_invoices_margin_Text=castArticle_invoices_margin_Text.replaceAll("[^0-9.]", "");

				 //filtered  Article_invoices_percentage column

			
			 String castArticle_invoices_percentage_Text=castArticle_invoices_percentage.replace(",", ".");

				String  New_Article_invoices_percentage_Text=castArticle_invoices_percentage_Text.replaceAll("[^0-9.]", "");
		
	
				
			
if(castAxes.equalsIgnoreCase(data.getString(1))
		&& Newmatching_rate_text.equalsIgnoreCase(data.getString(2))
		&& casttotal_orders.equalsIgnoreCase(data.getString(3))
		&& NEw_total_turnover_Text.equalsIgnoreCase(data.getString(4))
		&& casttotal_invoices_orders.equalsIgnoreCase(data.getString(5))
		&& New_Article_invoices_turnover_Text.equalsIgnoreCase(data.getString(6))
		&& New_Article_televente_turnover_Text.equalsIgnoreCase(data.getString(7))
		&& New_Article_invoices_margin_Text.equalsIgnoreCase(data.getString(8))
		&& New_Article_invoices_percentage_Text.equalsIgnoreCase(data.getString(9))
		) {
	
	logger.log(LogStatus.PASS,"2:Actual row Content On App is "
			+"<b>"+castAxes+"|"+Newmatching_rate_text+"|"+casttotal_orders+"|"+
			NEw_total_turnover_Text+"|"+casttotal_invoices_orders+"|"+New_Article_invoices_turnover_Text
			+"|"+New_Article_televente_turnover_Text+"|"+New_Article_invoices_margin_Text+"|"+New_Article_invoices_percentage_Text+"</b>"+"<br/>"
			+"3:Expected row Content From DB is "+"<b>"+data.getString(1)+"|"+data.getString(2)+"|"+data.getString(3)+
			"|"+data.getString(4)+"|"+data.getString(5)+"|"+data.getString(6)+"|"+data.getString(7)+"|"+data.getString(8)+"|"+data.getString(9)+"</b>"+"<br/>"
			+"<b><font color='green'>Result:Row has been Matched <font/>");

}else {
	
	logger.log(LogStatus.FAIL,"2:Actual row Content On App is "
			+"<b>"+castAxes+"|"+Newmatching_rate_text+"|"+casttotal_orders+"|"+
			NEw_total_turnover_Text+"|"+casttotal_invoices_orders+"|"+New_Article_invoices_turnover_Text
			+"|"+New_Article_televente_turnover_Text+"|"+New_Article_invoices_margin_Text+"|"+New_Article_invoices_percentage_Text+"</b>"+"<br/>"
			+"3:Expected row Content From DB is "+"<b>"+data.getString(1)+"|"+data.getString(2)+"|"+data.getString(3)+
			"|"+data.getString(4)+"|"+data.getString(5)+"|"+data.getString(6)+"|"+data.getString(7)+"|"+data.getString(8)+"|"+data.getString(9)+"</b>"+"<br/>"
			+"<b><font color='red'>Result:Row has been missmatched <font/>");

}
				
				
	System.out.println(castAxes+" "+castmatching_rate+" "+casttotal_orders+" "
	+casttotal_turnover+" "+casttotal_invoices_orders+" "+castArticle_invoices_turnover+" "+castArticle_televente_turnover 
	+""+castArticle_invoices_margin+" "+castArticle_invoices_percentage);						
	 
	System.out.println(data.getString(1)+" "+data.getString(2)+" "+data.getString(3)+" "
	+data.getString(4)+" "+data.getString(5)+" "+data.getString(6)+" "+data.getString(7)+" "
	+data.getString(8)+" "+data.getString(9)+" "+data.getString(10)+" DB"); 
	
												break;
											    } 
	
					                     break;
					                  }
		                     	break;		 
			                  }
					       break; 
	                    }			 
						break;
					}
			      break; 
			}
			break;						    
		}
	
	break;					    
	 }
	break;				 
}		 

}
	 
}	 

 //verify geoghraphic view for Site
public void verifyGeographicViewForSite() throws Throwable, SQLException {
	
	Thread.sleep(3000);


	 driver.findElement(By.xpath("//*[@node-id='sector-"+billing_related_queries.sector_id+"']")).click();
		
		ResultSet data = dataBase.getData(billing_related_queries.GeographicViewForSite_Query);
		
		//sql loop
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;


	 int countRows= driver.findElements(By.xpath("//*[@node-id='sector-"+billing_related_queries.sector_id+"']")).size(); 
		 
		 System.out.println( countRows+"no.of Sites rows are");
		 
		 logger
			.log(LogStatus.INFO,"<font color='blue'><u><b>1:Verifying Geographic View For Site</u><font/>"+"</br>"
		 +"2: and no.of rows are "+countRows);
	 	
		 
		 List<WebElement> Axes= driver.findElements(By.xpath("//tr[contains(@node-id,'site-"+billing_related_queries.site_id+"')]/td[1]"));	
		
		 List<WebElement> matching_rate= driver.findElements(By.xpath("//tr[contains(@node-id,'site-"+billing_related_queries.site_id+"')]/td[2]"));
		 
		 List<WebElement>  total_orders= driver.findElements(By.xpath("//tr[contains(@node-id,'site-"+billing_related_queries.site_id+"')]/td[3]"));
		 
		 List<WebElement>  total_turnover= driver.findElements(By.xpath("//tr[contains(@node-id,'site-"+billing_related_queries.site_id+"')]/td[4]"));
		 
		 List<WebElement>  total_invoices_orders= driver.findElements(By.xpath("//tr[contains(@node-id,'site-"+billing_related_queries.site_id+"')]/td[5]"));
		 
		 List<WebElement>  Article_invoices_turnover= driver.findElements(By.xpath("//tr[contains(@node-id,'site-"+billing_related_queries.site_id+"')]/td[6]"));
		 
		 List<WebElement>  Article_televente_turnover= driver.findElements(By.xpath("//tr[contains(@node-id,'site-"+billing_related_queries.site_id+"')]/td[7]"));
		 
		 List<WebElement>  Article_invoices_margin= driver.findElements(By.xpath("//tr[contains(@node-id,'site-"+billing_related_queries.site_id+"')]/td[8]"));
		 
		 List<WebElement>  Article_invoices_percentage= driver.findElements(By.xpath("//tr[contains(@node-id,'site-"+billing_related_queries.site_id+"')]/td[9]"));	


		
		 Iterator<WebElement> iter = Axes.iterator();
		 
		 Iterator<WebElement> iter1 = matching_rate.iterator();

		 Iterator<WebElement> iter2 = total_orders.iterator();

		 Iterator<WebElement> iter3 = total_turnover.iterator();

		 Iterator<WebElement> iter4 = total_invoices_orders.iterator();

		 Iterator<WebElement> iter5 = Article_invoices_turnover.iterator();

		 Iterator<WebElement> iter6 = Article_televente_turnover.iterator();

		 Iterator<WebElement> iter7 = Article_invoices_margin.iterator();

		 Iterator<WebElement> iter8 = Article_invoices_percentage.iterator();

	 while(data.next()) {
		 
		 
		 while(iter.hasNext()) {
		  
			    WebElement getAxes = iter.next();

				 while(iter1.hasNext()) {

					    WebElement getmatching_rate = iter1.next();

						 while(iter2.hasNext()) {
							 
							    WebElement gettotal_orders = iter2.next();

							    
							    while(iter3.hasNext()) {
									 
								    WebElement gettotal_turnover = iter3.next();


								    while(iter4.hasNext()) {
										 
									    WebElement gettotal_invoices_orders = iter4.next();

									    while(iter5.hasNext()) {
											 
										    WebElement getArticle_invoices_turnover = iter5.next();
										    
										    
										    while(iter6.hasNext()) {
												 
											    WebElement getArticle_televente_turnover = iter6.next();
											
											    while(iter7.hasNext()) {
													 
												    WebElement getArticle_invoices_margin = iter7.next();
												
												    
												    while(iter8.hasNext()) {
														 
													    WebElement getArticle_invoices_percentage = iter8.next();
													

		 String castAxes = (String) js.executeScript("return arguments[0].innerText;",getAxes);
		 
		 String castmatching_rate = (String) js.executeScript("return arguments[0].innerText;",getmatching_rate);

		 String casttotal_orders = (String) js.executeScript("return arguments[0].innerText;",gettotal_orders);

		 String casttotal_turnover = (String) js.executeScript("return arguments[0].innerText;",gettotal_turnover);
		 
		 String casttotal_invoices_orders = (String) js.executeScript("return arguments[0].innerText;",gettotal_invoices_orders);
		 
		 String castArticle_invoices_turnover = (String) js.executeScript("return arguments[0].innerText;",getArticle_invoices_turnover);
		 
		 String castArticle_televente_turnover = (String) js.executeScript("return arguments[0].innerText;",getArticle_televente_turnover);
		 
		 String castArticle_invoices_margin = (String) js.executeScript("return arguments[0].innerText;",getArticle_invoices_margin);
		 
		 String castArticle_invoices_percentage = (String) js.executeScript("return arguments[0].innerText;",getArticle_invoices_percentage);
		 

		 //filtered matching rate column
		 String castmatching_rate_text=castmatching_rate.replace(",", ".");

		String  Newmatching_rate_text=castmatching_rate_text.replaceAll("[^0-9.]", "");
		 

		 //filtered  total turnover columns
		 String casttotal_turnover_Text=casttotal_turnover.replace(",", ".");

		String  NEw_total_turnover_Text=casttotal_turnover_Text.replaceAll("[^0-9.]", "");
		

		 //filtered  Article invoices turnover column
		 String castArticle_invoices_turnover_Text=castArticle_invoices_turnover.replace(",", ".");

			String  New_Article_invoices_turnover_Text=castArticle_invoices_turnover_Text.replaceAll("[^0-9.]", "");


			 //filtered Article Televente turnover column
			 String castArticle_televente_turnover_Text=castArticle_televente_turnover.replace(",", ".");

				String  New_Article_televente_turnover_Text=castArticle_televente_turnover_Text.replaceAll("[^0-9.]", "");


				 //filtered  Article_invoices_margin column
		
				 String castArticle_invoices_margin_Text=castArticle_invoices_margin.replace(",", ".");

					String  New_Article_invoices_margin_Text=castArticle_invoices_margin_Text.replaceAll("[^0-9.]", "");

					 //filtered  Article_invoices_percentage column

				
				 String castArticle_invoices_percentage_Text=castArticle_invoices_percentage.replace(",", ".");

					String  New_Article_invoices_percentage_Text=castArticle_invoices_percentage_Text.replaceAll("[^0-9.]", "");
			
		
					
				
	if(castAxes.equalsIgnoreCase(data.getString(1))
			&& Newmatching_rate_text.equalsIgnoreCase(data.getString(2))
			&& casttotal_orders.equalsIgnoreCase(data.getString(3))
			&& NEw_total_turnover_Text.equalsIgnoreCase(data.getString(4))
			&& casttotal_invoices_orders.equalsIgnoreCase(data.getString(5))
			&& New_Article_invoices_turnover_Text.equalsIgnoreCase(data.getString(6))
			&& New_Article_televente_turnover_Text.equalsIgnoreCase(data.getString(7))
			&& New_Article_invoices_margin_Text.equalsIgnoreCase(data.getString(8))
			&& New_Article_invoices_percentage_Text.equalsIgnoreCase(data.getString(9))
			) {
		
		logger.log(LogStatus.PASS,"2:Actual row Content On App is "
				+"<b>"+castAxes+"|"+Newmatching_rate_text+"|"+casttotal_orders+"|"+
				NEw_total_turnover_Text+"|"+casttotal_invoices_orders+"|"+New_Article_invoices_turnover_Text
				+"|"+New_Article_televente_turnover_Text+"|"+New_Article_invoices_margin_Text+"|"+New_Article_invoices_percentage_Text+"</b>"+"<br/>"
				+"3:Expected row Content From DB is "+"<b>"+data.getString(1)+"|"+data.getString(2)+"|"+data.getString(3)+
				"|"+data.getString(4)+"|"+data.getString(5)+"|"+data.getString(6)+"|"+data.getString(7)+"|"+data.getString(8)+"|"+data.getString(9)+"</b>"+"<br/>"
				+"<b><font color='green'>Result:Row has been Matched <font/>");

	}else {
		
		logger.log(LogStatus.FAIL,"2:Actual row Content On App is "
				+"<b>"+castAxes+"|"+Newmatching_rate_text+"|"+casttotal_orders+"|"+
				NEw_total_turnover_Text+"|"+casttotal_invoices_orders+"|"+New_Article_invoices_turnover_Text
				+"|"+New_Article_televente_turnover_Text+"|"+New_Article_invoices_margin_Text+"|"+New_Article_invoices_percentage_Text+"</b>"+"<br/>"
				+"3:Expected row Content From DB is "+"<b>"+data.getString(1)+"|"+data.getString(2)+"|"+data.getString(3)+
				"|"+data.getString(4)+"|"+data.getString(5)+"|"+data.getString(6)+"|"+data.getString(7)+"|"+data.getString(8)+"|"+data.getString(9)+"</b>"+"<br/>"
				+"<b><font color='red'>Result:Row has been missmatched <font/>");

	}
					

		 
		System.out.println(castAxes+" "+castmatching_rate+" "+casttotal_orders+" "
		+casttotal_turnover+" "+casttotal_invoices_orders+" "+castArticle_invoices_turnover+" "+castArticle_televente_turnover 
		+""+castArticle_invoices_margin+" "+castArticle_invoices_percentage);						
		 
		System.out.println(data.getString(1)+" "+data.getString(2)+" "+data.getString(3)+" "
		+data.getString(4)+" "+data.getString(5)+" "+data.getString(6)+" "+data.getString(7)+" "
		+data.getString(8)+" "+data.getString(9)+" "+data.getString(10)+" DB"); 
		
													break;
												    } 
		
						                     break;
						                  }
			                     	break;		 
				                  }
						       break; 
		                    }			 
							break;
						}
				      break; 
				}
				break;						    
			}
		
		break;					    
		 }
		break;				 
	  }		 

	}

	}

//verify geoghraphic view for Agency
public void verifyGeographicViewForAgency() throws Throwable, SQLException {
	

	Thread.sleep(3000);

 driver.findElement(By.xpath("//*[@node-id='site-"+billing_related_queries.site_id+"']")).click();
	
	ResultSet data = dataBase.getData(billing_related_queries.GeographicViewForAgency_Query);
	
	//sql loop
	
	Thread.sleep(2000);
	
	JavascriptExecutor js=(JavascriptExecutor)driver;


 int countRows= driver.findElements(By.xpath("//tr[contains(@node-id,'agency-"+billing_related_queries.agency_id+"')]/td[1]")).size(); 
	 
	 System.out.println( countRows+"no.of sellers rows are");
	 
	 logger
		.log(LogStatus.INFO,"<font color='blue'><u><b>1:Verifying Geographic View For Agency</u><font/>"+"</br>"
	 +"2: and no.of rows are "+countRows);
 	    	
	 
	 List<WebElement> Axes= driver.findElements(By.xpath("//tr[contains(@node-id,'agency-"+billing_related_queries.agency_id+"')]/td[1]"));	
	
	 List<WebElement> matching_rate= driver.findElements(By.xpath("//tr[contains(@node-id,'agency-"+billing_related_queries.agency_id+"')]/td[2]"));
	 
	 List<WebElement>  total_orders= driver.findElements(By.xpath("//tr[contains(@node-id,'agency-"+billing_related_queries.agency_id+"')]/td[3]"));
	 
	 List<WebElement>  total_turnover= driver.findElements(By.xpath("//tr[contains(@node-id,'agency-"+billing_related_queries.agency_id+"')]/td[4]"));
	 
	 List<WebElement>  total_invoices_orders= driver.findElements(By.xpath("//tr[contains(@node-id,'agency-"+billing_related_queries.agency_id+"')]/td[5]"));
	 
	 List<WebElement>  Article_invoices_turnover= driver.findElements(By.xpath("//tr[contains(@node-id,'agency-"+billing_related_queries.agency_id+"')]/td[6]"));
	 
	 List<WebElement>  Article_televente_turnover= driver.findElements(By.xpath("//tr[contains(@node-id,'agency-"+billing_related_queries.agency_id+"')]/td[7]"));
	 
	 List<WebElement>  Article_invoices_margin= driver.findElements(By.xpath("//tr[contains(@node-id,'agency-"+billing_related_queries.agency_id+"')]/td[8]"));
	 
	 List<WebElement>  Article_invoices_percentage= driver.findElements(By.xpath("//tr[contains(@node-id,'agency-"+billing_related_queries.agency_id+"')]/td[9]"));	


	
	 Iterator<WebElement> iter = Axes.iterator();
	 
	 Iterator<WebElement> iter1 = matching_rate.iterator();

	 Iterator<WebElement> iter2 = total_orders.iterator();

	 Iterator<WebElement> iter3 = total_turnover.iterator();

	 Iterator<WebElement> iter4 = total_invoices_orders.iterator();

	 Iterator<WebElement> iter5 = Article_invoices_turnover.iterator();

	 Iterator<WebElement> iter6 = Article_televente_turnover.iterator();

	 Iterator<WebElement> iter7 = Article_invoices_margin.iterator();

	 Iterator<WebElement> iter8 = Article_invoices_percentage.iterator();

 while(data.next()) {
	 
	 
	 while(iter.hasNext()) {
	  
		    WebElement getAxes = iter.next();

			 while(iter1.hasNext()) {

				    WebElement getmatching_rate = iter1.next();

					 while(iter2.hasNext()) {
						 
						    WebElement gettotal_orders = iter2.next();

						    
						    while(iter3.hasNext()) {
								 
							    WebElement gettotal_turnover = iter3.next();


							    while(iter4.hasNext()) {
									 
								    WebElement gettotal_invoices_orders = iter4.next();

								    while(iter5.hasNext()) {
										 
									    WebElement getArticle_invoices_turnover = iter5.next();
									    
									    
									    while(iter6.hasNext()) {
											 
										    WebElement getArticle_televente_turnover = iter6.next();
										
										    while(iter7.hasNext()) {
												 
											    WebElement getArticle_invoices_margin = iter7.next();
											
											    
											    while(iter8.hasNext()) {
													 
												    WebElement getArticle_invoices_percentage = iter8.next();
												

	 String castAxes = (String) js.executeScript("return arguments[0].innerText;",getAxes);
	 
	 String castmatching_rate = (String) js.executeScript("return arguments[0].innerText;",getmatching_rate);

	 String casttotal_orders = (String) js.executeScript("return arguments[0].innerText;",gettotal_orders);

	 String casttotal_turnover = (String) js.executeScript("return arguments[0].innerText;",gettotal_turnover);
	 
	 String casttotal_invoices_orders = (String) js.executeScript("return arguments[0].innerText;",gettotal_invoices_orders);
	 
	 String castArticle_invoices_turnover = (String) js.executeScript("return arguments[0].innerText;",getArticle_invoices_turnover);
	 
	 String castArticle_televente_turnover = (String) js.executeScript("return arguments[0].innerText;",getArticle_televente_turnover);
	 
	 String castArticle_invoices_margin = (String) js.executeScript("return arguments[0].innerText;",getArticle_invoices_margin);
	 
	 String castArticle_invoices_percentage = (String) js.executeScript("return arguments[0].innerText;",getArticle_invoices_percentage);
	 
	 
	 
	 //filtered matching rate column
	 String castmatching_rate_text=castmatching_rate.replace(",", ".");

	String  Newmatching_rate_text=castmatching_rate_text.replaceAll("[^0-9.]", "");
	 

	 //filtered  total turnover columns
	 String casttotal_turnover_Text=casttotal_turnover.replace(",", ".");

	String  NEw_total_turnover_Text=casttotal_turnover_Text.replaceAll("[^0-9.]", "");
	

	 //filtered  Article invoices turnover column
	 String castArticle_invoices_turnover_Text=castArticle_invoices_turnover.replace(",", ".");

		String  New_Article_invoices_turnover_Text=castArticle_invoices_turnover_Text.replaceAll("[^0-9.]", "");


		 //filtered Article Televente turnover column
		 String castArticle_televente_turnover_Text=castArticle_televente_turnover.replace(",", ".");

			String  New_Article_televente_turnover_Text=castArticle_televente_turnover_Text.replaceAll("[^0-9.]", "");


			 //filtered  Article_invoices_margin column
	
			 String castArticle_invoices_margin_Text=castArticle_invoices_margin.replace(",", ".");

				String  New_Article_invoices_margin_Text=castArticle_invoices_margin_Text.replaceAll("[^0-9.]", "");

				 //filtered  Article_invoices_percentage column

			
			 String castArticle_invoices_percentage_Text=castArticle_invoices_percentage.replace(",", ".");

				String  New_Article_invoices_percentage_Text=castArticle_invoices_percentage_Text.replaceAll("[^0-9.]", "");
		
	
				
			
if(castAxes.equalsIgnoreCase(data.getString(1))
		&& Newmatching_rate_text.equalsIgnoreCase(data.getString(2))
		&& casttotal_orders.equalsIgnoreCase(data.getString(3))
		&& NEw_total_turnover_Text.equalsIgnoreCase(data.getString(4))
		&& casttotal_invoices_orders.equalsIgnoreCase(data.getString(5))
		&& New_Article_invoices_turnover_Text.equalsIgnoreCase(data.getString(6))
		&& New_Article_televente_turnover_Text.equalsIgnoreCase(data.getString(7))
		&& New_Article_invoices_margin_Text.equalsIgnoreCase(data.getString(8))
		&& New_Article_invoices_percentage_Text.equalsIgnoreCase(data.getString(9))
		) {
	
	logger.log(LogStatus.PASS,"2:Actual row Content On App is "
			+"<b>"+castAxes+"|"+Newmatching_rate_text+"|"+casttotal_orders+"|"+
			NEw_total_turnover_Text+"|"+casttotal_invoices_orders+"|"+New_Article_invoices_turnover_Text
			+"|"+New_Article_televente_turnover_Text+"|"+New_Article_invoices_margin_Text+"|"+New_Article_invoices_percentage_Text+"</b>"+"<br/>"
			+"3:Expected row Content From DB is "+"<b>"+data.getString(1)+"|"+data.getString(2)+"|"+data.getString(3)+
			"|"+data.getString(4)+"|"+data.getString(5)+"|"+data.getString(6)+"|"+data.getString(7)+"|"+data.getString(8)+"|"+data.getString(9)+"</b>"+"<br/>"
			+"<b><font color='green'>Result:Row has been Matched <font/>");

}else {
	
	logger.log(LogStatus.FAIL,"2:Actual row Content On App is "
			+"<b>"+castAxes+"|"+Newmatching_rate_text+"|"+casttotal_orders+"|"+
			NEw_total_turnover_Text+"|"+casttotal_invoices_orders+"|"+New_Article_invoices_turnover_Text
			+"|"+New_Article_televente_turnover_Text+"|"+New_Article_invoices_margin_Text+"|"+New_Article_invoices_percentage_Text+"</b>"+"<br/>"
			+"3:Expected row Content From DB is "+"<b>"+data.getString(1)+"|"+data.getString(2)+"|"+data.getString(3)+
			"|"+data.getString(4)+"|"+data.getString(5)+"|"+data.getString(6)+"|"+data.getString(7)+"|"+data.getString(8)+"|"+data.getString(9)+"</b>"+"<br/>"
			+"<b><font color='red'>Result:Row has been missmatched <font/>");

}
				


	System.out.println(castAxes+" "+castmatching_rate+" "+casttotal_orders+" "
	+casttotal_turnover+" "+casttotal_invoices_orders+" "+castArticle_invoices_turnover+" "+castArticle_televente_turnover 
	+""+castArticle_invoices_margin+" "+castArticle_invoices_percentage);						
	 
	System.out.println(data.getString(1)+" "+data.getString(2)+" "+data.getString(3)+" "
	+data.getString(4)+" "+data.getString(5)+" "+data.getString(6)+" "+data.getString(7)+" "
	+data.getString(8)+" "+data.getString(9)+" "+data.getString(10)+" DB"); 
	
												break;
											    } 
	
					                     break;
					                  }
		                     	break;		 
			                  }
					       break; 
	                    }			 
						break;
					}
			      break; 
			}
			break;						    
		}
	
	break;					    
	 }
	break;				 
  }		 

}

}

 

//Geographic  view for customers

public void verifyGeographicViewForCustomers() throws Throwable, SQLException {
		

		Thread.sleep(3000);

	 driver.findElement(By.xpath("//*[@node-id='agency-"+billing_related_queries.agency_id+"']")).click();
		
		ResultSet data = dataBase.getData(billing_related_queries.GeographicViewForCustomer_Query);
		
		//sql loop
		
		Thread.sleep(2000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;


	 int countRows= driver.findElements(By.xpath("//tr[contains(@node-id,'customer')]/td[1]")).size(); 
		 
		 System.out.println( countRows+"customers rows are ");
		 
		 logger
			.log(LogStatus.INFO,"<font color='blue'><u><b>1:Verifying Geographic  View For customers</u><font/>"+"</br>"
		 +"2: and no.of rows are "+countRows);
	 		
		 
		 List<WebElement> Axes= driver.findElements(By.xpath("//tr[contains(@node-id,'customer')]/td[1]"));	
		
		 List<WebElement> matching_rate= driver.findElements(By.xpath("//tr[contains(@node-id,'customer')]/td[2]"));
		 
		 List<WebElement>  total_orders= driver.findElements(By.xpath("//tr[contains(@node-id,'customer')]/td[3]"));
		 
		 List<WebElement>  total_turnover= driver.findElements(By.xpath("//tr[contains(@node-id,'customer')]/td[4]"));
		 
		 List<WebElement>  total_invoices_orders= driver.findElements(By.xpath("//tr[contains(@node-id,'customer')]/td[5]"));
		 
		 List<WebElement>  Article_invoices_turnover= driver.findElements(By.xpath("//tr[contains(@node-id,'customer')]/td[6]"));
		 
		 List<WebElement>  Article_televente_turnover= driver.findElements(By.xpath("//tr[contains(@node-id,'customer')]/td[7]"));
		 
		 List<WebElement>  Article_invoices_margin= driver.findElements(By.xpath("//tr[contains(@node-id,'customer')]/td[8]"));
		 
		 List<WebElement>  Article_invoices_percentage= driver.findElements(By.xpath("//tr[contains(@node-id,'customer')]/td[9]"));	


		
		 Iterator<WebElement> iter = Axes.iterator();
		 
		 Iterator<WebElement> iter1 = matching_rate.iterator();

		 Iterator<WebElement> iter2 = total_orders.iterator();

		 Iterator<WebElement> iter3 = total_turnover.iterator();

		 Iterator<WebElement> iter4 = total_invoices_orders.iterator();

		 Iterator<WebElement> iter5 = Article_invoices_turnover.iterator();

		 Iterator<WebElement> iter6 = Article_televente_turnover.iterator();

		 Iterator<WebElement> iter7 = Article_invoices_margin.iterator();

		 Iterator<WebElement> iter8 = Article_invoices_percentage.iterator();

	 while(data.next()) {
		 
		 
		 while(iter.hasNext()) {
		  
			    WebElement getAxes = iter.next();

				 while(iter1.hasNext()) {

					    WebElement getmatching_rate = iter1.next();

						 while(iter2.hasNext()) {
							 
							    WebElement gettotal_orders = iter2.next();

							    
							    while(iter3.hasNext()) {
									 
								    WebElement gettotal_turnover = iter3.next();


								    while(iter4.hasNext()) {
										 
									    WebElement gettotal_invoices_orders = iter4.next();

									    while(iter5.hasNext()) {
											 
										    WebElement getArticle_invoices_turnover = iter5.next();
										    
										    
										    while(iter6.hasNext()) {
												 
											    WebElement getArticle_televente_turnover = iter6.next();
											
											    while(iter7.hasNext()) {
													 
												    WebElement getArticle_invoices_margin = iter7.next();
												
												    
												    while(iter8.hasNext()) {
														 
													    WebElement getArticle_invoices_percentage = iter8.next();
													

		 String castAxes = (String) js.executeScript("return arguments[0].innerText;",getAxes);
		 
		 String castmatching_rate = (String) js.executeScript("return arguments[0].innerText;",getmatching_rate);

		 String casttotal_orders = (String) js.executeScript("return arguments[0].innerText;",gettotal_orders);

		 String casttotal_turnover = (String) js.executeScript("return arguments[0].innerText;",gettotal_turnover);
		 
		 String casttotal_invoices_orders = (String) js.executeScript("return arguments[0].innerText;",gettotal_invoices_orders);
		 
		 String castArticle_invoices_turnover = (String) js.executeScript("return arguments[0].innerText;",getArticle_invoices_turnover);
		 
		 String castArticle_televente_turnover = (String) js.executeScript("return arguments[0].innerText;",getArticle_televente_turnover);
		 
		 String castArticle_invoices_margin = (String) js.executeScript("return arguments[0].innerText;",getArticle_invoices_margin);
		 
		 String castArticle_invoices_percentage = (String) js.executeScript("return arguments[0].innerText;",getArticle_invoices_percentage);
		 
		 
		 
		 //filtered matching rate column
		 String castmatching_rate_text=castmatching_rate.replace(",", ".");

		String  Newmatching_rate_text=castmatching_rate_text.replaceAll("[^0-9.]", "");
		 

		 //filtered  total turnover columns
		 String casttotal_turnover_Text=casttotal_turnover.replace(",", ".");

		String  NEw_total_turnover_Text=casttotal_turnover_Text.replaceAll("[^0-9.]", "");
		

		 //filtered  Article invoices turnover column
		 String castArticle_invoices_turnover_Text=castArticle_invoices_turnover.replace(",", ".");

			String  New_Article_invoices_turnover_Text=castArticle_invoices_turnover_Text.replaceAll("[^0-9.]", "");


			 //filtered Article Televente turnover column
			 String castArticle_televente_turnover_Text=castArticle_televente_turnover.replace(",", ".");

				String  New_Article_televente_turnover_Text=castArticle_televente_turnover_Text.replaceAll("[^0-9.]", "");


				 //filtered  Article_invoices_margin column
		
				 String castArticle_invoices_margin_Text=castArticle_invoices_margin.replace(",", ".");

					String  New_Article_invoices_margin_Text=castArticle_invoices_margin_Text.replaceAll("[^0-9.]", "");

					 //filtered  Article_invoices_percentage column

				
				 String castArticle_invoices_percentage_Text=castArticle_invoices_percentage.replace(",", ".");

					String  New_Article_invoices_percentage_Text=castArticle_invoices_percentage_Text.replaceAll("[^0-9.]", "");
			
		
					
				
	if(castAxes.equalsIgnoreCase(data.getString(1))
			&& Newmatching_rate_text.equalsIgnoreCase(data.getString(2))
			&& casttotal_orders.equalsIgnoreCase(data.getString(3))
			&& NEw_total_turnover_Text.equalsIgnoreCase(data.getString(4))
			&& casttotal_invoices_orders.equalsIgnoreCase(data.getString(5))
			&& New_Article_invoices_turnover_Text.equalsIgnoreCase(data.getString(6))
			&& New_Article_televente_turnover_Text.equalsIgnoreCase(data.getString(7))
			&& New_Article_invoices_margin_Text.equalsIgnoreCase(data.getString(8))
			&& New_Article_invoices_percentage_Text.equalsIgnoreCase(data.getString(9))
			) {
		
		logger.log(LogStatus.PASS,"2:Actual row Content On App is "
				+"<b>"+castAxes+"|"+Newmatching_rate_text+"|"+casttotal_orders+"|"+
				NEw_total_turnover_Text+"|"+casttotal_invoices_orders+"|"+New_Article_invoices_turnover_Text
				+"|"+New_Article_televente_turnover_Text+"|"+New_Article_invoices_margin_Text+"|"+New_Article_invoices_percentage_Text+"</b>"+"<br/>"
				+"3:Expected row Content From DB is "+"<b>"+data.getString(1)+"|"+data.getString(2)+"|"+data.getString(3)+
				"|"+data.getString(4)+"|"+data.getString(5)+"|"+data.getString(6)+"|"+data.getString(7)+"|"+data.getString(8)+"|"+data.getString(9)+"</b>"+"<br/>"
				+"<b><font color='green'>Result:Row has been Matched <font/>");

	}else {
		
		logger.log(LogStatus.FAIL,"2:Actual row Content On App is "
				+"<b>"+castAxes+"|"+Newmatching_rate_text+"|"+casttotal_orders+"|"+
				NEw_total_turnover_Text+"|"+casttotal_invoices_orders+"|"+New_Article_invoices_turnover_Text
				+"|"+New_Article_televente_turnover_Text+"|"+New_Article_invoices_margin_Text+"|"+New_Article_invoices_percentage_Text+"</b>"+"<br/>"
				+"3:Expected row Content From DB is "+"<b>"+data.getString(1)+"|"+data.getString(2)+"|"+data.getString(3)+
				"|"+data.getString(4)+"|"+data.getString(5)+"|"+data.getString(6)+"|"+data.getString(7)+"|"+data.getString(8)+"|"+data.getString(9)+"</b>"+"<br/>"
				+"<b><font color='red'>Result:Row has been missmatched <font/>");

	}
					


		System.out.println(castAxes+" "+castmatching_rate+" "+casttotal_orders+" "
		+casttotal_turnover+" "+casttotal_invoices_orders+" "+castArticle_invoices_turnover+" "+castArticle_televente_turnover 
		+""+castArticle_invoices_margin+" "+castArticle_invoices_percentage);						
		 
		System.out.println(data.getString(1)+" "+data.getString(2)+" "+data.getString(3)+" "
		+data.getString(4)+" "+data.getString(5)+" "+data.getString(6)+" "+data.getString(7)+" "
		+data.getString(8)+" "+data.getString(9)+" "+data.getString(10)+" DB"); 
		
													break;
												    } 
		
						                     break;
						                  }
			                     	break;		 
				                  }
						       break; 
		                    }			 
							break;
						}
				      break; 
				}
				break;						    
			}
		
		break;					    
		 }
		break;				 
	  }		 

	}

}



 






 
}
			 





