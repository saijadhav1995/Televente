package webElements_Identifiers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import webBase.BasePage;

public class CreateForm extends BasePage {

public WebDriver driver;
	
//identifiers

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
	
		
		@FindBy(how=How.XPATH,using="//*[@title='Création Télévente']")
		@CacheLookup
		public	WebElement createButton;
		
	
		@FindBy(how=How.XPATH,using="//*[@id='telev_region']")
		@CacheLookup
		public	WebElement Region_dropDown;
		
		@FindBy(how=How.XPATH,using="//*[@id='telev_name']")
		@CacheLookup
		public	WebElement Nom;
		
		@FindBy(how=How.XPATH,using="//*[@id='telev_start_date']")
		@CacheLookup
		public	WebElement StartDate;
		
		
				
		@FindBy(how=How.XPATH,using="//*[@id='telev_end_date']")
		@CacheLookup
		public	WebElement EndDate;
		
	
		@FindBy(how=How.XPATH,using="//*[@id='telev_objective']")
		@CacheLookup
		public	WebElement Objectivef;
		
		
		@FindBy(how=How.XPATH,using="//*[@id='btnDailyObjectiveModal']")
		@CacheLookup
		public	WebElement ObjectivefAmount;
		
				
		@FindBy(how=How.XPATH,using="//*[@id='addObjectiveList']")
		@CacheLookup
		public	WebElement enterDailyAmount;
			
		
		@FindBy(how=How.XPATH,using="//*[@id='dailyObjBtnSave']")
		@CacheLookup
		public	WebElement SaveAmounts;
		
		
	
		@FindBy(how=How.XPATH,using="//*[@id='btn_addObjective']")
		@CacheLookup
		public	WebElement SaveDailyAmount;
		
		
		@FindBy(how=How.XPATH,using="//*[@class='fs-wrap multiple']/div[@class='fs-label-wrap']")
		@CacheLookup
		public	WebElement ranking;
		
		
		@FindBy(how=How.XPATH,using="//div[@class='fs-dropdown']/div[2]/div[@data-value='6']")
		@CacheLookup
		public	WebElement selectRanking;
		
		@FindBy(how=How.XPATH,using="//div[@class='fs-dropdown']/div[2]/div[@data-value]")
		@CacheLookup
		public	WebElement selectBrand;
				
	
		@FindBy(how=How.XPATH,using="//*[@class='fs-wrap multiple fs-default']/div[@class='fs-label-wrap']")
		@CacheLookup
		public	WebElement brand;
			
		
		@FindBy(how=How.XPATH,using="//*[@id='btn_televente_save']")
		@CacheLookup
		public	WebElement saveButton;
	
		@FindBy(how=How.XPATH,using="//*[@id='btn_televente_reset']")
		@CacheLookup
		public	WebElement cancelButton;
		
		
//Error messages identifiers
		
		@FindBy(how=How.XPATH,using="//*[@class='telev_region text-danger error']/label")
		@CacheLookup
		public	WebElement regionErrorMessage;
		
		@FindBy(how=How.XPATH,using="//*[@class='telev_name text-danger error']/label")
		@CacheLookup
		public	WebElement NameErrorMessage;
		
		
		@FindBy(how=How.XPATH,using="//*[@class='telev_start_date text-danger error']/label")
		@CacheLookup
		public	WebElement StartDateErrorMessage;
		
		
		@FindBy(how=How.XPATH,using="//*[@class='telev_end_date text-danger error']/label")
		@CacheLookup
		public	WebElement EndDateErrorMessage;
		
		
		@FindBy(how=How.XPATH,using="//*[@class='telev_objective text-danger error']/label")
		@CacheLookup
		public	WebElement ObjectiveFErrorMessage;
		
		@FindBy(how=How.XPATH,using="//*[@class='telev_ranking text-danger error']/label")
		@CacheLookup
		public	WebElement RankingErrorMessage;
		
		
		@FindBy(how=How.XPATH,using="//*[@class='telev_brands text-danger error']/label")
		@CacheLookup
		public	WebElement BrandErrorMessage;
		
		//div[@class='alert alert-danger']
		
		//*[contains(text(),'Une télévente existe déjà pour cette période')]
		
		@FindBy(how=How.XPATH,using="//*[contains(text(),'Une télévente existe déjà pour cette période')]")
		@CacheLookup
		public	WebElement anotherTeleventeAlreadyExist;
		
		
		
		
	
public  CreateForm(WebDriver dr) {
		
		this.driver=dr;
	}

public void Connection() {
	
	Connection_button.click();
}

public void CreateButton() {
	
createButton.click();	

}
	
public void userName(String name ) {
	
Nom.sendKeys(name);	

}

public void Region(String setRegion) {
	
	
	Select region=new Select(Region_dropDown);
	
	region.selectByValue(setRegion);
}


public void Stardate() {
	
StartDate.click();
	
	
}

public void Enddate() {
	
	EndDate.click();
	
	
}

public void ObjectiveF(String objective) {
	
	Objectivef.sendKeys(objective);
	
}


public void DailyObjecitve() {
	
	ObjectivefAmount.click();
}



public void enterDailyAmount(String amount ) {
	
enterDailyAmount.sendKeys(amount);	

}

public void saveDailyAmount() {
	
	SaveDailyAmount.click();
}

public void SaveAmounts() {
	
	SaveAmounts.click();
}

public void SaveButton() {
	
	saveButton.click();
}





}
