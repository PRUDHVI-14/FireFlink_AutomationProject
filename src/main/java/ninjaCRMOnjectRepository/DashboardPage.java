package ninjaCRMOnjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	@FindBy(linkText = "Campaigns")
	private WebElement campainsLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Leads")
	private WebElement leadLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLink;
	
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	
	@FindBy(linkText = "Quotes")
	private WebElement quotesLink;
	
	@FindBy(linkText = "Purchase Order")
	private WebElement purchaseOrderLink;
	
	@FindBy(linkText = "Sales Order")
	private WebElement salesOrderLink;
	
	@FindBy(linkText = "Invoice")
	private WebElement invoiceLink;
	
	@FindBy(linkText = "Admin Console")
	private WebElement adminConsoleLink;
	
	@FindBy(className = "user-icon")
	private WebElement profileIcon;
	
	@FindBy(xpath = "//div[.='Logout ']")
	private WebElement logoutBtn;
	
	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampainsLink() {
		return campainsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getLeadLink() {
		return leadLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getQuotesLink() {
		return quotesLink;
	}

	public WebElement getPurchaseOrderLink() {
		return purchaseOrderLink;
	}

	public WebElement getSalesOrderLink() {
		return salesOrderLink;
	}

	public WebElement getInvoiceLink() {
		return invoiceLink;
	}

	public WebElement getAdminConsoleLink() {
		return adminConsoleLink;
	}
	/**
	 * This methods helps to click on contact link in Dashboard
	 */
	public void clickOnContacts() {
		getContactsLink().click();
	}
	
	/**
	 * This methods helps to click on Campains Link in Dashboard
	 */
	public void clickOnCampains() {
		getCampainsLink().click();
	}
	
	
	/**
	 * This methods helps to click on Leads link in Dashboard
	 */
	public void clickOnLeads() {
		getLeadLink().click();
	}
	
	
	/**
	 * This methods helps to click on Opportunities link in Dashboard
	 */
	public void clickOnOpportunities() {
		getOpportunitiesLink().click();
	}
	
	
	/**
	 * This methods helps to click on Products link in Dashboard
	 */
	public void clickOnProducts() {
		getProductsLink().click();
	}
	
	/**
	 * This methods helps to click on Quotes link in Dashboard
	 */
	public void clickOnQuotes() {
		getQuotesLink().click();
	}
	
	
	/**
	 * This methods helps to click on Purchase order link in Dashboard
	 */
	public void clickOnPurchaseOrder() {
		getPurchaseOrderLink().click();
	}
	
	
	/**
	 * This methods helps to click on Sales order link in Dashboard
	 */
	public void clickOnSalesOrder() {
		getSalesOrderLink().click();
	}
	
	
	/**
	 * This methods helps to click on Admin console link in Dashboard
	 */
	public void clickOnAdminConsole(){
		getAdminConsoleLink().click();
	}
	
	/**
	 * This methods helps to click on Invoice link in Dashboard
	 */
	public void clickOnInvoice(){
		getInvoiceLink().click();
	}
	
	/**
	 * This method helps to logout from the ninza CRM application
	 */
	public void logoutApp() {
		getProfileIcon().click();
		getLogoutBtn().click();
	}
	
	
	
}
