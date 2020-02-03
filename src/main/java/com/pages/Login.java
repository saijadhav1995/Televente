package com.pages;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;




public class Login {

	WebDriver driver;
	
//Login page webElements	
	
	By link =By.xpath("//*[@class='link text-primary d-inline-block']");
	By username=By.xpath("//input[@id='username']");
	By password=By.xpath("//input[@id='password']");
	By submit=By.xpath("//input[@type='submit']");
	By logout=By.xpath("//*[contains(text(),'Déconnexion')]");
public	By refuse=By.xpath("//*[contains(text(),'Connexion refusée')]");
public	By image=By.xpath("//*[@class='navbar-brand-img main-logo']");
public By invalid=By.xpath("//*[contains(text(),'Invalid credentials.')]");
	
	
	
	public  Login(WebDriver dr) {
		
		this.driver=dr;
	}
	
// Define Actions for each WebElements	
	public void clicklink() {
		
		driver.findElement(link).click();
	}
	
		
public void typeUsername(String username1 ) {
		
	driver.findElement(username).sendKeys(username1);
		
		
	}
	
public void typePassword(String passowrd2) {
		
	driver.findElement(password).sendKeys(passowrd2);
	}
public void clickSubmit() {
	
	driver.findElement(submit).click();
}
public void logOut() {
	
	driver.findElement(logout).click();
}

/*public void refuseconnection() {
	
	driver.findElement(refuse).isDisplayed();
}

public void afterloginImage() {
	driver.findElement(image).isDisplayed();
	
}*/

}
