package pages;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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
	
		
	
		
		DataBase dataBase = new DataBase();
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
			
			
			if (day_result_objective.equalsIgnoreCase(data.getString(3))) {
				
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
	
		
		//agency ranking
		ranking.tlvt_ranking.click();
		
		Select select1=new Select(ranking.tlvt_ranking);
		select1.selectByValue("2");
		
		List<WebElement> agencydata= driver.findElements(By.xpath("//*[@id='ranking_table']/tbody/tr/td"));
		
		for(WebElement test:agencydata ) {
			
		String test1=	test.getText();
			
			System.out.println(test1);
			
		}
	
		
		
		//ranking.btn_filters_reset.click();
		//ranking.btn_excel_export.click();
		
	}	
}	
