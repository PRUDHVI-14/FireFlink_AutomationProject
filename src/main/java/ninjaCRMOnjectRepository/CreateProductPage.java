package ninjaCRMOnjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninjaCRM.genericUtilities.WebDriverUtility;

public class CreateProductPage extends WebDriverUtility {

	@FindBy(name="quantity")
	private WebElement quantityTF;
	
	@FindBy(name="productName")
	private WebElement prodNameTF;
	
	@FindBy(name="productCategory")
	private WebElement prodcategoryTF;
	
	@FindBy(name="price")
	private WebElement priceTF;
	
	@FindBy(name="vendorId")
	private WebElement venderDropdown;
	
	@FindBy(xpath = "//button[.='Add']")
	private WebElement addBtn;
	
	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getQuantityTF() {
		return quantityTF;
	}

	public WebElement getProdNameTF() {
		return prodNameTF;
	}

	public WebElement getProdcategoryTF() {
		return prodcategoryTF;
	}

	public WebElement getPriceTF() {
		return priceTF;
	}

	public WebElement getVenderDropdown() {
		return venderDropdown;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}
	
	//business library
	public void addProduct(WebDriver driver,String quantity,String prodName, String price, String prodcategory,String vender) {
		getQuantityTF().sendKeys(quantity);
		getProdNameTF().sendKeys(prodName);
		getPriceTF().clear();
		getPriceTF().sendKeys(price);
		handleDropDown(vender, getVenderDropdown());
		handleDropDown(getProdcategoryTF(), prodcategory);
//		getProdcategoryTF().sendKeys(prodcategory);
//		getVenderDropdown().sendKeys(vender);
		getAddBtn().click();
	}
}
