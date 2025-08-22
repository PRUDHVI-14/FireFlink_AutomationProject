package ninjaCRMOnjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {

	@FindBy(xpath="//span[.='Create Lead']")
	private WebElement createLeadBtn;
	
	
	@FindBy(xpath="//select[@class='form-control']")
	private WebElement leadSearchField;
	
	@FindBy(xpath="//input[@class='form-control' and @type='text']")
	private WebElement leadSearchTF;
	
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateLeadBtn() {
		return createLeadBtn;
	}

	public WebElement getLeadSearchField() {
		return leadSearchField;
	}

	public WebElement getLeadSearchTF() {
		return leadSearchTF;
	}
	
	
	
}
