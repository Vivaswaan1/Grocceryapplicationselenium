package automationcore;

import java.io.FileInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;

import utilities.Screenshotutility;

public class Testngbase {
	Properties prop;
	public WebDriver driver;
	FileInputStream fs;

	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void initializebrowser(String browser) throws Exception {
		prop=new Properties();
		fs=new FileInputStream(Constant.CONFIGFILE);
		prop.load(fs);
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver()
			.clearResolutionCache()
		    .forceDownload()
		    .setup();
			driver=new EdgeDriver();
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
//			
		else 
		{
			throw new Exception("Invalid browser");
		}
//		
//			driver.get("https://selenium.qabible.in/");//open url
		driver.get(prop.getProperty("Url"));
		

		driver.manage().window().maximize();
		//implicitwait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod(alwaysRun=true)
	public void driverQuit(ITestResult iTestResult) throws IOException {

		if (iTestResult.getStatus() == ITestResult.FAILURE) {

			Screenshotutility screenShot = new Screenshotutility();
			screenShot.getScreenshot(driver, iTestResult.getName());
		}
		driver.quit();

	}
}