package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.Driver;
//import utils.ExcelCode;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
public class FirstTest1 extends BaseTest{
	
	WebDriver driver; 
	
	/***
	 * Login to application
	 * @param usename
	 * @param passwd
	 * @throws Exception 
	 */
	
	
	/*
	 * @BeforeClass
	 * 
	 * @Parameters({"browser","mode","remoteURL"}) public void setup(String browser,
	 * String mode, String rURL) throws MalformedURLException { switch(mode) { case
	 * Driver.mode_local: driver = Driver.getInstance(browser);
	 * System.out.println("In Base Test browser - "+browser); break; case
	 * Driver.mode_remote: URL url = new URL(rURL); driver =
	 * Driver.getInstanceRemote(browser, url); default: driver =
	 * Driver.getInstance(browser); } }
	 */
	//@Test(testName="first test",dataProvider="TestData", dataProviderClass = ExcelCode.class)
	@Test
	void Login() throws Exception {
		
		driver = super.driver;
		
				
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        
        WebElement txtUsername = driver.findElement(By.id("my-text-id"));
        WebElement txtPassword = driver.findElement(By.name("my-password"));
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        
        txtUsername.sendKeys("abc");
        txtPassword.sendKeys("xyz");
        //this.takeSnapShot(driver, "C:\\Nilesh\\test.png");
        submit.click();
       
        driver.quit();
		
    
	}
	
	
}
