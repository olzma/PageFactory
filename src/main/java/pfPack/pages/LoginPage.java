package pfPack.pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pfPack.base.BasePage;
import pfPack.util.Constants;

public class LoginPage extends BasePage{
	
	//here we have the necesarry elements requested by Login: user/email,password, accept terms, etc
	@FindBy(id="login_id")
	public WebElement emailField;
	
	@FindBy(id="nextbtn")
	public WebElement NextButton;
	
	@FindBy(id="password")
	public WebElement PasswordField;
	
	@FindBy(id="nextbtn")
	public WebElement SignButton;
	
	//Any other WebElements on Login page
	
	public LoginPage(WebDriver driver, ExtentTest eTest) {
		
		this.driver =driver;
		this.eTest =eTest;
		
	}
	
	//Reusable methods of Login page
	
	public boolean doLogin() {
		
		emailField.sendKeys(Constants.USERNAME);
		NextButton.click();
		eTest.log(LogStatus.INFO, "Add user: "+ Constants.USERNAME + " and click next");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		PasswordField.sendKeys(Constants.PASSWORD);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		SignButton.click();
		eTest.log(LogStatus.INFO, "Add password ***** and click Sign in button to login in");
		
		HomePage homePage =new HomePage(driver,eTest);
		PageFactory.initElements(driver, homePage);
		
		boolean isHomePageStatus =homePage.verifyDisplayOfHomePage();
		
		return isHomePageStatus;
		
		
		
	}
	
}
