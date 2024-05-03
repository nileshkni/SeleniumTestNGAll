package utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	public WebDriver driver;

	/*
	 * public void takeSnapShot(WebDriver webdriver,String fileWithPath) throws
	 * Exception{ //Convert web driver object to TakeScreenshot TakesScreenshot
	 * scrShot =((TakesScreenshot)webdriver);
	 * 
	 * //Call getScreenshotAs method to create image file File
	 * SrcFile=scrShot.getScreenshotAs(OutputType.FILE); //Move image file to new
	 * destination File DestFile=new File(fileWithPath); //Copy file at destination
	 * FileUtils.copyFile(SrcFile, DestFile); }
	 */
	
	@BeforeClass
	@Parameters({"browser","mode","remoteURL"})
	public  void setup(String browser, String mode, String rURL) throws MalformedURLException {
		switch(mode) {
		case Driver.mode_local:
			driver = Driver.getInstance(browser);
			System.out.println("In Base Test browser - "+browser);
			break;
		case Driver.mode_remote:
			URL url = new URL(rURL);
			driver = Driver.getInstanceRemote(browser, url);
			break;
		default:
			driver = Driver.getInstance(browser);
		}
		
		
	}

}