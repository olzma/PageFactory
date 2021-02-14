package pfPack.pages;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pfPack.base.BasePage;

public class HomePage extends BasePage{

	@FindBy(css="span[class^='zicon-apps-calendar']")
	public WebElement Calendar;
	
	@FindBy(css="span[class^='zicon-apps-chat']")
	public WebElement Cliq;
	
	@FindBy(css="span[class^='_logo-crm']")
	public WebElement CRM;
	
	@FindBy(css="span[class^='zicon-apps-mail']")
	public WebElement Mail;
	
	@FindBy(css="span[class^='zicon-apps-salesiq']")
	public WebElement SalesIQ;
	
	public HomePage(WebDriver driver, ExtentTest eTest) {
		
		this.driver =driver;
		this.eTest =eTest;
		
	}
	
	//Reusable method for verifying if the user got successfully logged in or not
	public boolean verifyDisplayOfHomePage() {
		
		return isElementPresent(CRM);
	}
	
	//Reusable method to navigate to Calender page
	
	//Reusable method to navigate to Cliq page

	//Ruesable method to navigate to CRM
	
	//Reusable method to navigate to Mail page
	
	//Ruesable method to navigate to CRM
	
	//Reusable method to naivigate to Sales
	
	
	
	
	
}
