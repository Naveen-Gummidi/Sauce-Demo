package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Base {

	WebDriver driver;

	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	
	public void setup(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--guest");
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			throw new IllegalArgumentException("Invalid browser: " + browser);
		}

		driver.get("https://www.saucedemo.com/");
	}

//	@BeforeMethod
//	public void setup() {
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--guest");
//		driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
//		driver.get("https://www.saucedemo.com/");
//	}

	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}

	}

}
