package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenShotUtility;

public class Base {

	public WebDriver driver;
	public Properties properties;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void browserIntialization(String browser) throws Exception {

		try {
			properties = new Properties();
			FileInputStream fileinputstream = new FileInputStream(Constant.CONFIGFILE);
			properties.load(fileinputstream);
		}
		catch (Exception e) {
			System.out.println("File not found");
		}
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			// prefs.put("profile.default_content_setting_values.notifications", 2); //
			// block all
			prefs.put("profile.password_manager_leak_detection", false); // Disable "Change password" alerts
			options.setExperimentalOption("prefs", prefs);
			// WebDriver driver = new ChromeDriver(options);
			// ChromeOptions option=new ChromeOptions();
			// option.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		}
		else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().clearResolutionCache().forceDownload().setup();
			driver = new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			throw new Exception("invalid browser name");
		}
		driver.get(properties.getProperty("url"));
		
		
		driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun = true)

	public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ScreenShotUtility scrShot = new ScreenShotUtility(); // creating obj
			scrShot.getScreenShot(driver, iTestResult.getName());
		}
	driver.quit();
	}
}
