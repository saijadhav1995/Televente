package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Home {

	
	
	WebDriver driver;

	// webElements of home page 
	By Connection=By.xpath("//*[@value='CONNECTION']");
	By Region =By.xpath("//select[@id='telev_region']");
	By ToggleButtonforPast=By.xpath("//span[@class='switch-label'and @data-on='Yes']");
	By ToggleButtonforfuture=By.xpath("//span[@class='switch-label'and @data-off='No']");

public  Home(WebDriver dr) {
		
		this.driver=dr;
	}
	
public void Connection() {
	
	driver.findElement(Connection).click();
}


//Define Actions for WebElements

public void Region() {
	
	
	Select region=new Select(driver.findElement(Region));
	
	region.selectByIndex(16);
}
	
public void ToggleButtonforPast() {
	
	driver.findElement(ToggleButtonforPast).click();
}
public void ToggleButtonforfuture() {
	
	driver.findElement(ToggleButtonforfuture).click();
}


}

