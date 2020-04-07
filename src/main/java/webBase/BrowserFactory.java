package webBase;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

public class BrowserFactory {

	public static WebDriver driver=null;
	static String imagesDirectory = "";
	static String relativePathforImage = "";
	
	public static  WebDriver startBrowser(String BrowserName,String url) {
		
		
		if (driver != null) {
			return driver;
		}
		
		if(BrowserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",
			System.getProperty("user.dir")+"\\Drivers\\chromedriver_win32 (3)\\chromedriver.exe");
			
			driver=new ChromeDriver();
			System.out.println("Driver Created");
			
		}else if (BrowserName.equalsIgnoreCase("firefox")) {
			
			driver=new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	
	/*@AfterSuite
		 public void stop() {
		
		 driver.close();
		 System.out.println("Driver closed");
		
	}*/
	
	
}
