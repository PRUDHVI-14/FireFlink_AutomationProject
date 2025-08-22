package practice.AdvanceSelenium;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import ninjaCRM.genericUtilities.BaseClass;
import ninjaCRMOnjectRepository.CampaignsPage;
import ninjaCRMOnjectRepository.CreateCampainPage;
import ninjaCRMOnjectRepository.CreateContactsPage;
import ninjaCRMOnjectRepository.DashboardPage;

@Listeners(ninjaCRM.genericUtilities.ListnerImpimentations.class)
public class CreateCampainTest extends BaseClass{

	
	@Test(groups = {"smokeSuite"})
	public void tc_001_creatCampainTest() {
		
		DashboardPage dp = new DashboardPage(driver);
		dp.clickOnCampains();
		
		//helps to print message in report and console also 
		//that report msg we can see in the test-output folder--->emailable-report file
		Reporter.log("clicked on campaign link",true);//true helps to log in report also
		
		
		
		CampaignsPage cp = new CampaignsPage(driver);
		cp.clickOnCreateCampain();
		
		//helps to print message in report and console also
		Reporter.log("clicked on create campain button",true);
		
//		Assert.fail();
		
		CreateCampainPage ccp = new CreateCampainPage(driver);
		ccp.createCampain("vinod", "6");
		Reporter.log("Campain created successfully",true);
		
		driver.findElement(By.xpath("//button[@aria-label=\"close\"]")).click();
	}
	
//	@Test(groups = {"regressionSuite"})
//	public void regressSuiteTest() {
//		System.out.println("===regression suite is executed=====");
//	}
//	
//	public void sample() {
//		System.out.println("===regional regression suite is executed=====");
//	}
}
