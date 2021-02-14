package pfPack.tests.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;
import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import pfPack.util.*;

public class BaseTest{

	
	//create a test report using extentReports
	public ExtentReports eReport =ExtentManager.getInstance();
	public ExtentTest eTest =null;
	//driver and eTest are shared by all the pages since we have the same driver when navigate and same eTest for the report
	//generated
	public WebDriver driver =null;
	
	//this create an instance of driver so needs to be called before using other methods that uses driver
	public void openBrowser(String browserType) {
		
		eTest.log(LogStatus.INFO, "Successfully opened the Browser "+browserType);
		
		if(browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",Constants.FIREFOX_DRIVER );
			driver =new FirefoxDriver();
			
		}else if(browserType.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER);
			driver =new ChromeDriver();
			
		}else if(browserType.equalsIgnoreCase("edge")) {
			
			System.setProperty("webdriver.edge.driver", Constants.IE_DRIVER);
			driver =new EdgeDriver();
			
		}
		
		driver.manage().window().maximize();
		
		eTest.log(LogStatus.INFO, "Browser got maximized and now waiting...");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	public void reportPass(String message) {
		
		eTest.log(LogStatus.PASS, message);
		
	}
	
	public void reportFail(String message) {
		
		eTest.log(LogStatus.FAIL, message);
		
		takeScreenshot();
		
		Assert.fail(message);
		
	}
	
	public void takeScreenshot() {
		
		Date d =new Date();
		String screenshotFile =d.toString().replace(":", "_").replace(" ", "_")+".png";
		
		File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			
			FileUtils.getFileUtils().copyFile(srcFile, new File("screenshots//"+screenshotFile));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		eTest.log(LogStatus.INFO,"Screenshots-> "+ eTest.addScreenCapture(System.getProperty("user.dir")+"//screenshots//"+ screenshotFile));
		
	}
	
	@AfterMethod
	public void testClosure() {
		
		if(eReport!=null) {
			eReport.endTest(eTest);
			eReport.flush();
		}
		if(driver!=null)
			driver.close();
		
	}
	
}
