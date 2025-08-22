package practice.AdvanceSelenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import ninjaCRM.genericUtilities.FileUtility;
import ninjaCRM.genericUtilities.WebDriverUtility;

public class TC_E2E_02 {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.edgedriver().setup();
//		FileInputStream fis = new FileInputStream("C:\\EclipseFolder\\Fireflink.ninzaCRM.AutomationFramework\\src\\test\\resources\\CommonData.properties");
//		Properties prop = new Properties();
//		prop.load(fis);
		FileUtility fileu = new FileUtility();
		WebDriverUtility webUty = new WebDriverUtility();
		String BROWSER=fileu.readDataFromPropertyFile("browser");
		String URL = fileu.readDataFromPropertyFile("url");
		WebDriver driver = null;
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if (BROWSER.equals("Edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new ChromeDriver();
		}
	
		webUty.maximizeWindow(driver);
		webUty.implicitlyWait(driver,10);
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(fileu.readDataFromPropertyFile("username"));
		driver.findElement(By.id("inputPassword")).sendKeys(fileu.readDataFromPropertyFile("password"));
		driver.findElement(By.xpath("//button[.='Sign In']")).click();
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//span[.='Create Contact']")).click();
		

		driver.findElement(By.name("contactName")).sendKeys(fileu.readDataFromExcelFile("Sheet1", 4, 2));
		driver.findElement(By.name("organizationName")).sendKeys(fileu.readDataFromExcelFile("Sheet1", 4, 3));
		driver.findElement(By.name("mobile")).sendKeys(fileu.readDataFromExcelFile("Sheet1", 4, 4));//col.getCell(4).toString()
		driver.findElement(By.name("title")).sendKeys(fileu.readDataFromExcelFile("Sheet1", 4, 5));
		driver.findElement(By.xpath("//button[@style='white-space: nowrap; margin: 5px 10px 16px 0px; padding: 8px; background-color: green; font-size: 12px; display: flex; align-items: center; justify-content: center;']")).click();
		String currId = driver.getWindowHandle();

		webUty.toWindow(driver);
		driver.findElement(By.id("search-input")).sendKeys(fileu.readDataFromExcelFile("Sheet1", 4, 6));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[.='Select']")).click();
		driver.switchTo().window(currId);
		driver.findElement(By.xpath("//button[.='Create Contact']")).click();
		
		driver.findElement(By.xpath("//a[.='Products']")).click();
		WebElement productVerify = driver.findElement(By.xpath("//span[.='Add Product']"));
		driver.findElement(By.xpath("//button[@aria-label=\"close\"]")).click();
		if(productVerify.isDisplayed()) {
			System.out.println("status---> PASS");
			productVerify.click();
		}
		driver.findElement(By.name("quantity")).sendKeys(fileu.readDataFromExcelFile("Sheet1", 4, 7));
		driver.findElement(By.name("productName")).sendKeys(fileu.readDataFromExcelFile("Sheet1", 4, 8));//col.getCell(8).toString()
		WebElement pricePerUnEle = driver.findElement(By.name("price"));
		pricePerUnEle.clear();
		pricePerUnEle.sendKeys(fileu.readDataFromExcelFile("Sheet1", 4, 9));
		WebElement prodCategEle = driver.findElement(By.name("productCategory"));
		Select catgSel = new Select(prodCategEle);
		catgSel.selectByValue(fileu.readDataFromExcelFile("Sheet1", 4, 10));
		Select venderSel = new Select(driver.findElement(By.name("vendorId")));
		venderSel.selectByVisibleText(fileu.readDataFromExcelFile("Sheet1", 4, 11));
		driver.findElement(By.xpath("//button[.='Add']")).click();
		try {
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		}catch(Exception e) {Thread.sleep(5000);}
		driver.findElement(By.xpath("//a[.='Purchase Order']")).click();
		driver.findElement(By.xpath("//span[.='Create Order']")).click();
		driver.findElement(By.name("dueDate")).sendKeys(fileu.readDataFromExcelFile("Sheet1", 4, 12));
		driver.findElement(By.name("subject")).sendKeys(fileu.readDataFromExcelFile("Sheet1", 4, 13));
		driver.findElement(By.xpath("//div[@style='display: flex; align-items: center;']/child::button[@class='action-button']")).click();

		webUty.toWindow(driver);
		driver.findElement(By.id("search-input")).sendKeys("Sumit Ghosh");
		driver.findElement(By.xpath("//button[.='Select']")).click();
		driver.switchTo().window(currId);
		driver.findElement(By.name("address")).sendKeys(fileu.readDataFromExcelFile("Sheet1", 4, 14));
		driver.findElement(By.xpath("(//textarea[@name='address'])[2]")).sendKeys(fileu.readDataFromExcelFile("Sheet1", 4, 14));
		driver.findElement(By.xpath("(//input[@name='poBox'])[1]")).sendKeys(fileu.readDataFromExcelFile("Sheet1", 4, 15));
		driver.findElement(By.xpath("(//input[@name='poBox'])[2]")).sendKeys(fileu.readDataFromExcelFile("Sheet1", 4, 15));
		driver.findElement(By.xpath("(//input[@name='city'])[1]")).sendKeys(fileu.readDataFromExcelFile("Sheet1", 4, 16));
		driver.findElement(By.xpath("(//input[@name='city'])[2]")).sendKeys(fileu.readDataFromExcelFile("Sheet1", 4, 16));
		driver.findElement(By.xpath("(//input[@name='state'])[1]")).sendKeys(fileu.readDataFromExcelFile("Sheet1", 4, 17));
		driver.findElement(By.xpath("(//input[@name='state'])[2]")).sendKeys(fileu.readDataFromExcelFile("Sheet1", 4, 17));
		driver.findElement(By.xpath("(//input[@name='postalCode'])[1]")).sendKeys(fileu.readDataFromExcelFile("Sheet1", 4, 18));
		driver.findElement(By.xpath("(//input[@name='postalCode'])[2]")).sendKeys(fileu.readDataFromExcelFile("Sheet1", 4, 18));
		driver.findElement(By.xpath("(//input[@name='country'])[1]")).sendKeys(fileu.readDataFromExcelFile("Sheet1", 4, 19));
		driver.findElement(By.xpath("(//input[@name='country'])[2]")).sendKeys(fileu.readDataFromExcelFile("Sheet1", 4, 19));		
		driver.findElement(By.xpath("//div[@style='margin-top: 20px;']/child::button")).click();	

		webUty.toWindow(driver);
		WebElement searchEle = driver.findElement(By.id("search-criteria"));

		webUty.handleDropDown(searchEle, "productName");
		driver.findElement(By.id("search-input")).sendKeys(fileu.readDataFromExcelFile("Sheet1", 4, 8));
		driver.findElement(By.xpath("//button[.='Select']")).click();
		driver.switchTo().window(currId);
		driver.findElement(By.xpath("//button[.='Create Purchase Order']")).click();
		try {
			driver.findElement(By.xpath("//button[@aria-label='close']")).click();
			}catch(Exception e) {Thread.sleep(6000);}
		driver.findElement(By.className("user-icon")).click();
		driver.findElement(By.xpath("//div[.='Logout ']")).click();
		
		
//		Row col2 = sheet.getRow(7);
//		5)Click on Products and search that product by it's name
		driver.findElement(By.xpath("//a[.='Products']")).click();
		Select prodIdEle = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		prodIdEle.selectByValue("productName");
		driver.findElement(By.xpath("//input[@placeholder='Search by product Name']")).sendKeys(fileu.readDataFromExcelFile("Sheet1", 7, 5));
		driver.findElement(By.xpath("//i[@class='material-icons' and @title='Edit']")).click();
		WebElement priceEle = driver.findElement(By.name("price"));
		priceEle.clear();
		priceEle.sendKeys("78000");
		driver.findElement(By.xpath("//button[.='Update']")).click();
		try {
		driver.findElement(By.className("Toastify__close-button Toastify__close-button--success")).click();
		}catch(Exception e) {Thread.sleep(5000);}
		driver.findElement(By.xpath("//a[.='Purchase Order']")).click();
		Select orderEle = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		orderEle.selectByValue("subject");
		driver.findElement(By.xpath("//input[@placeholder='Search by Subject']")).sendKeys(fileu.readDataFromExcelFile(currId, 4, 13));
		driver.findElement(By.xpath("//i[@class='material-icons' and @title='Edit']")).click();
		driver.findElement(By.name("dueDate")).sendKeys(fileu.readDataFromExcelFile("Sheet1", 4, 12));
		driver.findElement(By.xpath("//button[.='Update Purchase Order']")).click();
		try {
			driver.findElement(By.className("Toastify__close-button Toastify__close-button--success")).click();
			}catch(Exception e) {Thread.sleep(5000);}
		driver.findElement(By.className("user-icon")).click();
		driver.findElement(By.xpath("//div[.='Logout ']")).click();
	}
}
