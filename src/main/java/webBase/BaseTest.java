package webBase;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;


public class BaseTest extends BrowserFactory{
	
	public static WebDriver Basetestdriver=null;
	public  static ExtentReports extent;	
	
	public BaseTest()
	{
		BaseTest.Basetestdriver = Controller.InvokeWebDriver();
		PageFactory.initElements(Basetestdriver, this);
		
	}

	
	
@BeforeSuite
	
	public static  ExtentReports getReporter() {
		if (extent == null) {
		//	extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/CAMAL.html", true);
			extent = new ExtentReports(System.getProperty("user.dir") +"/extentReports/index.html", true);
			extent.loadConfig(new File(System.getProperty("user.dir") +"/Files/extent-config.xml"));
			extent
			.addSystemInfo("Host Name", "TELEVENTE")
			.addSystemInfo("Environment", "QA")
			.addSystemInfo("Testapp", "WEB-APP");
			
		}
		
		 
		return extent;
		
	}
	
@AfterSuite
public void closeextend()
{
	extent.flush();
}

}
