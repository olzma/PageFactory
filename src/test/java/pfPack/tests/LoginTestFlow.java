package pfPack.tests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import junit.extensions.TestSetup;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pfPack.util.Constants;
import pfPack.util.ExtentManager;
import pfPack.pages.LaunchPage;
import pfPack.tests.base.BaseTest;

public class LoginTestFlow extends BaseTest{
	
	@Test
	public void testLoginFlow() {
		
		//create for the report a test
		eTest =eReport.startTest("LoginTest");
		
		eTest.log(LogStatus.INFO, "Login test has started");
		
		openBrowser(Constants.BROWSER_TYPE);
		
		LaunchPage launchPage =new LaunchPage(driver,eTest);
		PageFactory.initElements(driver, launchPage);
		
		boolean LoginNowStatus =launchPage.goToLoginPage();
		
		if(LoginNowStatus) {
			
			reportPass("LoginTest Testcase passed");
			
		}else {
			
			reportFail("LoginTest Testcase failed");
			
		}
		
	}
	
	
	
}
