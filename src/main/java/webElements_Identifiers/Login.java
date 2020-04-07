package webElements_Identifiers;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import webBase.BasePage;





public class Login extends BasePage{

	
public WebDriver driver;
	
	
//Login page Identifiers	
	
	@FindBy(how=How.XPATH,using="//*[@class='link text-primary d-inline-block']")
	@CacheLookup
	public WebElement link;
	
	
	@FindBy(how=How.XPATH,using="//input[@id='username']")
	@CacheLookup
	public WebElement username;
	
	
	@FindBy(how=How.XPATH,using="//input[@id='password']")
	@CacheLookup
	public WebElement password;
	
	
	@FindBy(how=How.XPATH,using="//input[@type='submit']")
	@CacheLookup
	public	WebElement submit;

	
	@FindBy(how=How.XPATH,using="//*[@class='ni ni-user-run']")
	@CacheLookup
	public	WebElement RunIcon;
	
	
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Déconnexion')]")
	@CacheLookup
	public	WebElement logout;
	
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Connexion refusée')]")
	@CacheLookup
	public	WebElement refuse;
	
	
	@FindBy(how=How.XPATH,using="//*[@class='navbar-brand-img main-logo']")
	@CacheLookup
	public	WebElement TeleventeImage;
	
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Invalid credentials.')]")
	@CacheLookup
	public	WebElement invalid;
	
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Utilisateurs')]")
	@CacheLookup
	public	WebElement usersMenu;
	
	
	@FindBy(how=How.ID,using="usr_role")
	@CacheLookup
	public	WebElement role;
	
	
	
	
	
	
public  Login(WebDriver dr) {
		
		this.driver=dr;
	}
	
		
		
	
// Define Actions for each Identifiers
	
	public void clicklink() {
		
		link.click();

		
	}
	
		
public void typeUsername(String username1 ) {
		
	username.clear();
	username.sendKeys(username1);
		
		
	}
	
public void typePassword(String passowrd2) {
		
	password.clear();
	password.sendKeys(passowrd2);
	}
public void clickSubmit() {
	
	submit.click();
}

public void mouseHoverOnRunIcon() {
	Actions action=new Actions(driver);
	action.moveToElement(RunIcon).perform();
	
}

public void logOut() {
	
	logout.click();
}

public void selectRole(String rolevalue) {
	
	Select result=new Select(role);
	
	result.selectByValue(rolevalue);
	
}

/*public void refuseconnection() {
	
	driver.findElement(refuse).isDisplayed();
}

public void afterloginImage() {
	driver.findElement(image).isDisplayed();
	
}*/

}
