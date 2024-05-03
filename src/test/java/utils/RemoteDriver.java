package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class RemoteDriver {

	// ThreadLocal used to manage the driver
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static final String browser_Chrome = "chrome";
	public static final String browser_Edge = "edge";

	// Private constructor to prevent the creation of new instances of Driver
	private RemoteDriver() {
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
				driver.set(new ChromeDriver());
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
