package webElements_Identifiers;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import webBase.BasePage;


public class Home extends BasePage {

	
	
	public WebDriver driver;
	
public  Home(WebDriver dr) {
		
		this.driver=dr;
	}
	

	// identifiers of home page 

@FindBy(how=How.XPATH,using="//*[@id='sidenav-main']/div/div[1]/div[1]/div/div")
@CacheLookup
public WebElement slider;


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

	
	@FindBy(how=How.XPATH,using="//*[@value='CONNECTION']")
	@CacheLookup
	public WebElement Connection_button;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"panel\"]/div[1]/div/div/div[1]/div/h6")
	@CacheLookup
	public WebElement title;
	
	

	@FindBy(how=How.XPATH,using="//select[@id='telev_region']")
	@CacheLookup
	public WebElement Region_dropDown;

	@FindBy(how=How.XPATH,using="//span[@class='switch-label'and @data-on='Yes']")
	@CacheLookup
	public WebElement ToggleButtonforPast;

	@FindBy(how=How.XPATH,using="//span[@class='switch-label'and @data-off='No']")
	@CacheLookup
	public WebElement ToggleButtonforfuture;
	
	
	@FindBy(how=How.XPATH,using="//*[@class='nav-link-text' and @title]")
	@CacheLookup
	public WebElement SGID;
	


	@FindBy(how=How.XPATH,using="//*[contains(text(),'Utilisateurs')]")
	@CacheLookup
	public	WebElement usersMenu;
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Télévente')]")
	@CacheLookup
	public	WebElement televente;
	
	
	@FindBy(how=How.XPATH,using="//*[@aria-controls='telev_table' and @class='custom-select custom-select-sm form-control form-control-sm']")
	@CacheLookup
	public	WebElement paginationDropDown;
	
	

	@FindBy(how=How.XPATH,using="//*[@placeholder='Rechercher']")
	@CacheLookup
	public	WebElement SearchField;
	
	
	@FindBy(how=How.XPATH,using="//*[@class='paginate_button page-item next disabled']")
	@CacheLookup
	public	WebElement NextpaginationButtonIsDisabled;
	
	
	@FindBy(how=How.XPATH,using="//*[@class='paginate_button page-item next']")
	@CacheLookup
	public	WebElement NextpaginationButtonIsEnable;
	
	
	@FindBy(how=How.XPATH,using="//*[@class='paginate_button page-item previous']")
	@CacheLookup
	public	WebElement PreviouspaginationButtonIsEnable;
	
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Supprimer')]")
	@CacheLookup
	public	WebElement deleteButton;

	@FindBy(how=How.XPATH,using="//*[@title='Création Télévente']")
	@CacheLookup
	public	WebElement createButton;
	
	
	@FindBy(how=How.XPATH,using="//*[@class='fa fa-eye']")
	@CacheLookup
	public	WebElement eyeIcon;
	
	@FindBy(how=How.XPATH,using="//*[@class='fas fa-euro-sign']")
	@CacheLookup
	public	WebElement euroIcon;
	
	@FindBy(how=How.XPATH,using="//*[@class='fa fa-edit']")
	@CacheLookup
	public	WebElement EditIcon;
	
	@FindBy(how=How.XPATH,using="//*[@class='fa fa-cog']")
	@CacheLookup
	public	WebElement settingIcon;
	
	

	@FindBy(how=How.XPATH,using="//*[@class='fa fa-trash']")
	@CacheLookup
	public	WebElement DeleteIcon;
	
	
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Déconnexion')]")
	@CacheLookup
	public	WebElement logout;
	


	



//Define Actions for WebElements

public void Connection() {
	
	 Connection_button.click();
		
	}

public void Region(String setRegion) {
	
	
	Select region=new Select(Region_dropDown);
	
	region.selectByValue(setRegion);
}
	
public void ToggleButtonforPast() {
	
	ToggleButtonforPast.click();
}

public void ToggleButtonforfuture() {
	
	ToggleButtonforfuture.click();
}

public void gettitle() {
	
String abc=	title.getText();
	
	System.out.println(abc);

}

public void paginationDropDown(String setPage) {
	
	
	Select Page=new Select(paginationDropDown);
	
	Page.selectByValue(setPage);
}


public void searchField(String search) throws Throwable {
	
	
SearchField.sendKeys(search);
Thread.sleep(2000);
SearchField.clear();

}

public void clickNextpaginationButton() {
	
	NextpaginationButtonIsEnable.click();
	
}

public void clickPreviouspaginationButton() {
	
	PreviouspaginationButtonIsEnable.click();
	
}


}

