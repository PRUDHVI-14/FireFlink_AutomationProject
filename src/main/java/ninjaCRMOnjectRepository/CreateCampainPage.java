package ninjaCRMOnjectRepository;

import java.awt.print.PageFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampainPage {

	@FindBy(name="campaignName")
	private WebElement campainName;
	
	@FindBy(name="targetSize")
	private WebElement targetSize;
	
	@FindBy(xpath ="//button[.='Create Campaign']")
	private WebElement createCampain;
	
	public CreateCampainPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampainName() {
		return campainName;
	}

	public WebElement getTargetSize() {
		return targetSize;
	}

	public WebElement getCreateCampain() {
		return createCampain;
	}
	
	
	
	//business library
	public void createCampain(String campName,String targetSize) {
		getCampainName().sendKeys(campName);
		getTargetSize().sendKeys(targetSize);
		getCreateCampain().click();
	}
}
