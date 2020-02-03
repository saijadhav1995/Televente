package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.Home;
import com.pages.Login;

import cucumber.api.java.en.Given;



public class VerifyHome {

	WebDriver driver;
	
	 
	
	@BeforeTest
	public void open_chrome_browser_and_start_application() throws Throwable {
		 
				System.setProperty("webdriver.chrome.driver",
				 System.getProperty("user.dir")+"\\Drivers\\chromedriver_win32 (3)\\chromedriver.exe");
				 		
				 driver=new ChromeDriver();
					
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					driver.manage().window().maximize();
					driver.get("https://televente.mutlp.test.pointp.saint-gobain.net/");	 
					
						
	}
	
	/*@AfterTest
	 public void closeBrowser() {
		 
		 driver.quit();
	 }*/
	@Test(priority='0')
	public void VerifyRegionDropDownField() {
	
	Home home=new Home(driver);
	home.Connection();
	home.Region();
		
	}
	
	@Test(priority='0')
	public void VerifyToggleButton() throws Exception {
		Home home=new Home(driver);
		
		home.ToggleButtonforPast();
		Thread.sleep(2000);
		home.ToggleButtonforfuture();
			
		}
	
	
	
}
