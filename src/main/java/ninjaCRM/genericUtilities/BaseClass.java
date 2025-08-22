package ninjaCRM.genericUtilities;

import java.io.IOException;

//import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import ninjaCRMOnjectRepository.DashboardPage;
import ninjaCRMOnjectRepository.LoginPage;

public class BaseClass {
	
	public FileUtility fUtil = new FileUtility();
	public JavaUtilities jUtil = new JavaUtilities();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sDriver;
	
//	WebDriverManager.firefoxdriver().setup();
	@BeforeSuite(alwaysRun = true)
	public void bsConfig() {
		System.out.println("=====database is connection===");
	}
	
//	@Parameters("browser")//for cross browser execution
	@BeforeTest(alwaysRun = true) //for group executions (either smoke or regression 
	public void bcConfig(/*String BROWSER*/) throws IOException {
		String BROWSER=fUtil.readDataFromPropertyFile("browser");
		String URL = fUtil.readDataFromPropertyFile("url");
		
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if (BROWSER.equals("Edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new ChromeDriver();
		}
	
		wUtil.maximizeWindow(driver);
		wUtil.implicitlyWait(driver,10);
		driver.get(URL);
		
		System.out.println("loaded the url");
		//for listners in screen shot usage method
		sDriver = driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException {
		String USERNAME =fUtil.readDataFromPropertyFile("username");
		String PASSWORD=fUtil.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("login successful");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() {
		DashboardPage dp = new DashboardPage(driver) ;
			dp.logoutApp();
			System.out.println("logout successful");
	}
	@AfterTest(alwaysRun = true)
	public void acConfig() {
		driver.close();
		System.out.println("closed the browser");
	}
	@AfterSuite(alwaysRun = true)
	public void asConfig() {
		System.out.println("====database connection removed====");
	}
	
}
