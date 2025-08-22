package ninjaCRMOnjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {

	@FindBy(xpath="//span[.='Create Campaign']")
	private WebElement createCampain;
	
	
	@FindBy(xpath="//select[@class='form-control']")
	private WebElement campainDropDown;
	
	
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement campainTF;
	
	public CampaignsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateCampain() {
		return createCampain;
	}

	public WebElement getCampainDropDown() {
		return campainDropDown;
	}

	public WebElement getCampainTF() {
		return campainTF;
	}
	
	public void clickOnCreateCampain() {
		getCreateCampain().click();
	}
	
}
