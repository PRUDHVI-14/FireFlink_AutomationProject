package practice.AdvanceSelenium;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ninjaCRM.genericUtilities.BaseClass;
import ninjaCRMOnjectRepository.ContactPage;
import ninjaCRMOnjectRepository.CreateContactsPage;
import ninjaCRMOnjectRepository.DashboardPage;

@Listeners(ninjaCRM.genericUtilities.ListnerImpimentations.class)
public class CreateContactTest extends BaseClass {

	@Test
	public void tc_02_CreateContactTest() throws EncryptedDocumentException, IOException {
		DashboardPage dp = new DashboardPage(driver);
		dp.clickOnContacts();
		
		ContactPage cp = new ContactPage(driver);
		cp.clickCreateContact();
		
		CreateContactsPage ccp = new CreateContactsPage(driver);
		ccp.createContact(driver, fUtil.readDataFromExcelFile("Sheet1", 4, 2), fUtil.readDataFromExcelFile("Sheet1", 4, 3), fUtil.readDataFromExcelFile("Sheet1", 4, 3), fUtil.readDataFromExcelFile("Sheet1", 4, 4), fUtil.readDataFromExcelFile("Sheet1", 4, 5), fUtil.readDataFromExcelFile("Sheet1", 4, 6));
		
		driver.findElement(By.xpath("//button[@aria-label=\"close\"]")).click();
		
		System.out.println("github changes");
	}
}
