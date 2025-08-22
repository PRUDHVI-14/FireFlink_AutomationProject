package ninjaCRMOnjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //rule no 1
	
	//identify web element using annotation using @FindBy, @FindAll, @FindBys
	//@FindBy - helps to identify the single webElement using single locator

	@FindBy(id="username")
	private WebElement userNameTF;
	
	@FindBy(id="inputPassword")
	private WebElement passwordTF;
	
	@FindBy(xpath = "//button[.='Sign In']")
	private WebElement loginBtn ;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameTF() {
		return userNameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	//step-5
//	Generic methods but they are specific to to th particular application
//	resusable inside the application
//	 we are writing Business logic inside the pom class only
	/**
	 * This method helps to login into the Ninza CRM Application
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username,String password) {
		userNameTF.sendKeys(username);
		getPasswordTF().sendKeys(password);
		getLoginBtn().click();
	}
	
	
}
