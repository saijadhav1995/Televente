package webBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;







public class BasePage extends Controller{
	
	public static WebDriver Basepagedriver=null;

	static String imagesDirectory = "";
	static String relativePathforImage = "";

	
	
	public BasePage()
	{
		BasePage.Basepagedriver = Controller.InvokeWebDriver();
		PageFactory.initElements(Basepagedriver, this);
		
	}
	
	
	public static void createDirectory(String classname) 
	{

		classname = classname.substring(0);

		imagesDirectory = System.getProperty("user.dir") +"/extentReports"
				+ "/" + classname + "/";

		relativePathforImage = classname + "/";

		File file = new File(imagesDirectory);
		if (!file.exists()) {
			file.mkdir();
		} else {
			try {
				FileUtils.cleanDirectory(file);
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out
			.println("Either directory is already prersent or Failed to create directory.");
		}
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

	
	

}
