package ninjaCRM.genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * THis class consists of generic methods related to webDriver
 * @author Bandi Prudhvi Narayana
 */
public class WebDriverUtility {

	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * This method will make the winow Fullscreen
	 * @param driver
	 */
	public void fullScreenWindow(WebDriver driver) {
		driver.manage().window().fullscreen();
	}
	
	/**
	 * This method will helps to wait until the element will found
	 * @param driver
	 * @param sec
	 */
	public void implicitlyWait(WebDriver driver, int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	/**
	 * This method will wait until element is visible
	 * @param driver
	 * @param ele
	 */
	public void explicitlyWaitUntilVisible(WebDriver driver,WebElement ele) {
		WebDriverWait webWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		webWait.until(ExpectedConditions.visibilityOf(ele));
	}
	/**
	 * This method will wait until element is clickable
	 * @param driver
	 * @param ele
	 */
	public void explicitlyWaitUntilClickble(WebDriver driver,WebElement ele) {
		WebDriverWait webWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		webWait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	/**
	 * This method will handle the dropdown by selecting based on index
	 * @param ele
	 * @param idx
	 */
	public void handleDropDown(WebElement ele,int idx) {
		Select s = new Select(ele);
		s.selectByIndex(idx);
	}
	
	/**
	 * This method will handle the dropdown by selecting based on value
	 * @param ele
	 * @param val
	 */
	public void handleDropDown(WebElement ele, String val) {
		Select s = new Select(ele);
		s.selectByValue(val);
	}
	/** 
	 * This method will handle the dropdown by selecting based on visible text
	 * @param visText
	 * @param ele
	 */
	public void handleDropDown(String visText, WebElement ele) {
		Select s = new Select(ele);
		s.selectByVisibleText(visText);
	}
	
	/**
	 * This method helps to perform mouse overing action
	 * @param driver
	 * @param ele
	 */
	public void mouseOveringAction(WebDriver driver,WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
	/**
	 * This method helps to perform drag and drop action
	 * @param driver
	 * @param src
	 * @param dest
	 */
	public void dragAndDropActions(WebDriver driver, WebElement src, WebElement dest) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dest).perform();;
	}
	/**
	 * This method helps to perform click and hold action
	 * @param driver
	 * @param ele
	 */
	public void clickAndHoldAction(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.clickAndHold(ele).perform();
	}
	/**
	 * This method helps to perform release action
	 * @param driver
	 * @param ele
	 */
	public void releaseAction(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.release(ele).perform();
	}
	/**
	 * This method helps to perform move by offset action
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void moveByOffsetAction(WebDriver driver, int x, int y) {
		Actions act = new Actions(driver);
		act.moveByOffset(x, y).perform();
	}
	/**
	 * This method helps to perform double click action
	 * @param driver
	 * @param ele
	 */
	public void doubleClickAction(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();
	}
	/**
	 * This method helps to perform right click action
	 * @param driver
	 * @param ele
	 */
	public void contextClickAction(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.contextClick(ele).perform();
	}
	/**
	 * This method helps to scroll upto element
	 * @param driver
	 * @param ele
	 */
	public void scrollToElementAction(WebDriver driver,WebElement ele) {
		Actions act = new Actions(driver);
		act.scrollToElement(ele).perform();
	}
	
	/**
	 * This method will switch to iframe based on idx
	 * @param driver
	 * @param idx
	 */
	public void switchToChildFrame(WebDriver driver,int idx) {
		driver.switchTo().frame(idx);
	}
	/**
	 * This method will switch to iframe based on name or Id
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToChildFrame(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * This method will switch to iframe based on WebElement
	 * @param driver
	 * @param ele
	 */
	public void switchToChildFrame(WebDriver driver,WebElement ele) {
		driver.switchTo().frame(ele);
	}
	/**
	 * This method will switch to parent frame
	 * @param driver
	 */
	public void switchToparentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	/**
	 * This method will switch to default frame
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method will accepts the popups
	 * @param driver
	 */
	public void acceptAlertPopups(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will dismiss the popups
	 * @param driver
	 */
	public void dismissAlertPopups(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will send the data to the popups
	 * @param driver
	 * @param data
	 */
	public void sendKeysToPopups(WebDriver driver,String data) {
		driver.switchTo().alert().sendKeys(data);
	}
	/**
	 * This method will get the data from the popups
	 * @param driver
	 * @return
	 */
	public String getPopupsText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method helps to switch the handle when two windows are there
	 * @param driver
	 */
	public void toWindow(WebDriver driver) {
		String mainId = driver.getWindowHandle();
		Set<String> allIds = driver.getWindowHandles();
		for(String id:allIds) {
			if(!mainId.equals(id)) {
				driver.switchTo().window(id);
			}
		}
	}
	/**
	 * This method helps to switch the handle based on the title of the webpage
	 * @param driver
	 * @param title
	 */
	public void toWindow(WebDriver driver, String title) {
		
		Set<String> allIds = driver.getWindowHandles();
		for(String id:allIds) {
			driver.switchTo().window(id);
			if((driver.getTitle()).contains(title)){
				break;
			}
		}
	}
	
	/**
	 * This method will capture the screen shot and returns the path to caller
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver,String screenShotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\ScreenShots\\"+ screenShotName+".png");
		FileHandler.copy(src,dest);
		return dest.getAbsolutePath(); //for extend report
	}
}
