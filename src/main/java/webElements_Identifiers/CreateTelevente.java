package webElements_Identifiers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateTelevente {

	WebDriver driver;
	
	By Connection=By.xpath("//*[@value='CONNECTION']");
	
	By CreateButton=By.xpath("//*[@class='btn btn-outline-primary create-tele-btn']");

	By region=By.xpath("//*[@id='telev_region']");
	By name=By.xpath("//*[@id='telev_name']");
	By startDate=By.xpath("//*[@id='telev_start_date']");
	By endDate=By.xpath("//*[@id='telev_end_date']");
	By Objectivef=By.xpath("//*[@id='telev_objective']");
	By ObjectivefAmount=By.xpath("//*[@id='btnDailyObjectiveModal']");
	By Saveamount=By.xpath("//*[@id='dailyObjBtnSave']");
	By ranking=By.xpath("//*[@class='fs-wrap multiple']/div[@class='fs-label-wrap']");
	By brand =By.xpath("//*[@class='fs-wrap multiple fs-default']/div[@class='fs-label-wrap']");
	
public  CreateTelevente(WebDriver dr) {
		
		this.driver=dr;
	}

public void Connection() {
	
	driver.findElement(Connection).click();
}

public void CreateButton() {
	
	driver.findElement(CreateButton).click();
}
	

}
