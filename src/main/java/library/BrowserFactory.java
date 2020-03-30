package library;

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

public class BrowserFactory {

	public static WebDriver driver;
	static String imagesDirectory = "";
	static String relativePathforImage = "";
	
	public  WebDriver startBrowser(String BrowserName,String url) {
		
		
		
		if(BrowserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",
			System.getProperty("user.dir")+"\\Drivers\\chromedriver_win32 (3)\\chromedriver.exe");
			
			driver=new ChromeDriver();
			
		}else if (BrowserName.equalsIgnoreCase("firefox")) {
			
			driver=new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	
	public static String captureScreenShot(WebDriver driver,
			String screenshotName) 
	{
		try {
			Calendar calander = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat(
					"dd_MM_yy_hh_mm_ss");
			File src = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			String filename = screenshotName + "-"
					+ formater.format(calander.getTime()) + ".png";
			String dest = imagesDirectory + filename;
			File destination = new File(dest);
			FileUtils.copyFile(src, destination);
			String finaldest = relativePathforImage + filename;
			return finaldest;
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot"
					+ e.getMessage());
			return e.getMessage();
		}
		
	}	
	
	/*public void closeBrowserMethod() {
	driver.quit(); 
}*/
	
}
