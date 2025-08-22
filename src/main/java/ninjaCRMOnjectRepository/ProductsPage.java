package ninjaCRMOnjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninjaCRM.genericUtilities.WebDriverUtility;

public class ProductsPage extends WebDriverUtility {

	@FindBy(xpath="//span[.='Add Product']")
	private WebElement addProductBtn;
	
	
	@FindBy(xpath="//select[@class='form-control']")
	private WebElement prodIdDropDown;
	
	@FindBy(xpath="//input[@class='form-control' and @type='text']")
	private WebElement prodSearchTF;
	
	//constructor
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddProductBtn() {
		return addProductBtn;
	}

	public WebElement getProdIdDropDown() {
		return prodIdDropDown;
	}

	public WebElement getProdSearchTF() {
		return prodSearchTF;
	}
	
	
	/**
	 * This method helps to click on add product
	 */
	public void ClickOnAddProductBtn() {
		getAddProductBtn().click();
	}
	
	/**
	 * This helps to handle dropdown by selecting value 
	 * @param value
	 */
	public void prodIdDropDown(String value) {
		handleDropDown(prodIdDropDown, value);
	}
	
	/**
	 * This helps to handle dropdown by selecting index
	 * @param idx
	 */
	public void prodIdDropDown(int idx) {
		handleDropDown(prodIdDropDown, idx);
	}
	
	/**
	 * This helps to handle dropdown by selecting visible text
	 * @param visibleText
	 */
	public void prodIdDropDownVT(String visibleText) {
		handleDropDown(visibleText, addProductBtn);
	}
	
	/**
	 * This helps to give value to the text field
	 * @param value
	 */
	public void prodSearchTF(String value) {
		getProdSearchTF().sendKeys(value);
	}
}
