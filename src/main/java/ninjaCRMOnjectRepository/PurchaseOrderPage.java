package ninjaCRMOnjectRepository;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderPage {


	@FindBy(xpath="//span[.='Create Order']")
	private WebElement createPurchaseOrderBtn;
	
	
	@FindBy(xpath="//select[@class='form-control']")
	private WebElement purchaseOrderSearchField;
	
	@FindBy(xpath="//input[@class='form-control' and @type='text']")
	private WebElement purchaseOrderSearchTF;
	
	public PurchaseOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreatePurchaseOrderBtn() {
		return createPurchaseOrderBtn;
	}

	public WebElement getPurchaseOrderSearchField() {
		return purchaseOrderSearchField;
	}

	public WebElement getPurchaseOrderSearchTF() {
		return purchaseOrderSearchTF;
	}
	
	
}
