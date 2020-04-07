package Baselibrary;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.sun.corba.se.impl.orbutil.GetPropertyAction;

import webBase.BrowserFactory;



public class Helper  extends BrowserFactory{

	
	public boolean isElementPresent(WebElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	
	public void getscreenshots() throws IOException
	{
		
		File scfile = ((TakesScreenshot)BrowserFactory.driver).getScreenshotAs(OutputType.FILE);
		 String filename =  new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		 int i = 0;
		File DestFile=new File(System.getProperty("user.dir") +"\\Screenshots\\"+ filename + "Test"+i+++".png");
		 FileUtils.copyFile(scfile, DestFile);
	}


	
}
