package ninjaCRMOnjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninjaCRM.genericUtilities.WebDriverUtility;

public class CreateContactsPage extends WebDriverUtility{

	
	
	@FindBy(name="contactName")
	private WebElement contactNameTF;
	
	
	@FindBy(name="organizationName")
	private WebElement organizationTF;
	
	@FindBy(name="mobile")
	private WebElement mobileTF;
	
	
	@FindBy(name="title")
	private WebElement titleTF;
	
	@FindBy(xpath = "//button[@style='white-space: nowrap; margin: 5px 10px 16px 0px; padding: 8px; background-color: green; font-size: 12px; display: flex; align-items: center; justify-content: center;']")
	private WebElement campainADDbtn;
	
	@FindBy(id="search-input")
	private WebElement CampainSearchTF;
	
	
	@FindBy(xpath="//button[.='Select']")
	private WebElement selectBtn;
	
	@FindBy(xpath ="//button[.='Create Contact']")
	private WebElement createContactBtn;
	
	public CreateContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactNameTF() {
		return contactNameTF;
	}

	public WebElement getOrganizationTF() {
		return organizationTF;
	}

	public WebElement getMobileTF() {
		return mobileTF;
	}

	public WebElement getTitleTF() {
		return titleTF;
	}

	public WebElement getCampainADDbtn() {
		return campainADDbtn;
	}

	public WebElement getCampainSearchTF() {
		return CampainSearchTF;
	}

	public WebElement getSelectBtn() {
		return selectBtn;
	}

	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}

	public void createContact(WebDriver driver,String createContact,String contactName,String organizationName,String mobile,String title,String searchInput) {
		getContactNameTF().sendKeys(contactName);
		getOrganizationTF().sendKeys(organizationName);
		getMobileTF().sendKeys(mobile);
		getTitleTF().sendKeys(title);
		getCampainADDbtn().click();
		toWindow(driver);
		getCampainSearchTF().sendKeys(searchInput);
		getSelectBtn().click();
		toWindow(driver, "create-contact");
		getCreateContactBtn().click();
	}
	
	
	
}
