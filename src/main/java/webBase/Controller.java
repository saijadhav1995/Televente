package webBase;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

import com.sun.javafx.print.Units;

import okio.Timeout;

public class Controller {

	public static WebDriver driver = null;

	public static WebDriver InvokeWebDriver() {
		
		
		if (driver != null) {
			return driver;
		}

		System.setProperty("webdriver.chrome.driver",
		System.getProperty("user.dir")+"\\Drivers\\chromedriver_win32 (3)\\chromedriver.exe");

		driver = new ChromeDriver();
		System.out.println("Driver Created");

		driver.get("https://televente.mutlp.test.pointp.saint-gobain.net");

		System.out.println("Website Open");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		return driver;
	}

	
		
	
}  


