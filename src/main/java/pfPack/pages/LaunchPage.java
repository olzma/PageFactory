package pfPack.pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.sql.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pfPack.base.BasePage;
import pfPack.util.Constants;

public class LaunchPage extends BasePage{

	//lets take care only the for elements that interest us, we ignore the rest
	@FindBy(className="zh-customers")
	public WebElement Customers;
	
	@FindBy(className="zh-support")
	public WebElement Support;
	
	@FindBy(className="zh-login")
	public WebElement Login;
	
	@FindBy(className="zh-signup")
	public WebElement SignUp;
	
	//any other locators
	
	
	
	//Reusable methods of Launch Page
	
	public boolean goToLoginPage() {
		//code for taking the user to the login page
		
		driver.get(Constants.APP_URL);
		eTest.log(LogStatus.INFO, "Application URL "+Constants.APP_URL + " got opened");
		
		Login.click();
		eTest.log(LogStatus.INFO, "Navigate to Login page clicking Login option");
		
		LoginPage loginPage =new LoginPage(driver,eTest);
		PageFactory.initElements(driver, loginPage);
		
		boolean loginStatus =loginPage.doLogin();
		
		return loginStatus;
		
	}

	public LaunchPage(WebDriver driver, ExtentTest eTest) {
		this.driver =driver;
		this.eTest =eTest;
		
	}
	
	
	
}
