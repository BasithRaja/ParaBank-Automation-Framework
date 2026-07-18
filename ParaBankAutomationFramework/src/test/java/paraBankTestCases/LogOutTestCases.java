package paraBankTestCases;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constantClasses.ConstantData;
import paraBankPages.LogInPage;
import paraBankPages.LogOutPage;
import utilities.BaseClass;
import utilities.TestListeners;


@Listeners(TestListeners.class)
public class LogOutTestCases extends BaseClass {

	private static final Logger logger = LogManager.getLogger(LogOutTestCases.class);
	
	
	@Test(priority=2,groups="regression",retryAnalyzer=utilities.RetryAnalyzer.class)
	public static void verifyLogOutFunctionality() throws IOException {
		
		LogInTestCases.verifyLoginFunctionality();
		
		driver.findElement(LogOutPage.logOutLink()).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(ConstantData.EXPLICIT_WAIT_TIME));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LogOutPage.customerLoginText()));
		
		Boolean result = driver.findElement(LogOutPage.customerLoginText()).isDisplayed();
		
		if (result == true) {
			logger.info("User Successfully Logged out and navigated to Customer Login Page");
		} else {
			logger.info("User Not Successfully Logged out and also not navigated to Customer Login Page");
		}
		
		SoftAssert soft = new SoftAssert();
	    soft.assertEquals(result, true);
	    soft.assertAll();
	
	}
	
}
