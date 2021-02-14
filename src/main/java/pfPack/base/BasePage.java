package pfPack.base;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

	public WebDriver driver =null;
	public ExtentTest eTest =null;
	
	
	
	
	public boolean isElementPresent(WebElement element) {
		
		boolean displayedStatus =element.isDisplayed() ? true : false;
		
		return displayedStatus;
	}
}
