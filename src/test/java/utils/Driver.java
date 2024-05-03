package utils;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.edge.*;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	// ThreadLocal used to manage the driver
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static final String mode_remote = "remote";
	public static final String mode_local = "local";

	// Private constructor to prevent the creation of new instances of Driver
	private Driver() {
	}

	// Public method to access the driver instance (uses lazy instantiation)
	public static WebDriver getInstance(String browser) {

		switch (browser.toLowerCase()) {

		case "chrome":

			if (driver.get() == null) {
				driver.set(new ChromeDriver());
			}

			break;
		case "edge":

			if (driver.get() == null) {
				driver.set(new EdgeDriver());
			}

			break;

		}

		return driver.get();
	}
	
	// for RemoteDirver
	
	public static WebDriver getInstanceRemote(String browser, URL url) {

		switch (browser.toLowerCase()) {
		
		case "chrome":

			if (driver.get() == null) {
				  
				 ChromeOptions options = new ChromeOptions();
				  options.addArguments("--headless=new"); 
				  WebDriverManager.chromedriver().setup();
				  driver.set(new RemoteWebDriver(url, options));
				}

			break;
		case "edge":

			if (driver.get() == null) {
				EdgeOptions options = new EdgeOptions();
			      options.addArguments("--headless=new");
			      WebDriverManager.edgedriver().setup();
				  driver.set(new RemoteWebDriver(url, options));
			}

			break;

		}

		return driver.get();
	}


	/*
	 * Public method to quit the driver and remove the current thread's value for
	 * this thread-local variable
	 */
	public static void quit() {
		driver.get().quit();
		driver.remove();
	}

	public static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return null;
	}
}
