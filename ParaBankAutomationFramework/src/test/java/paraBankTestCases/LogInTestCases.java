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
import paraBankPages.UserRegistrationPage;
import utilities.BaseClass;
import utilities.FetchDataFromExcel;
import utilities.TestListeners;


@Listeners(TestListeners.class)
public class LogInTestCases extends BaseClass {
	
	private static final Logger logger = LogManager.getLogger(LogInTestCases.class);
	
	@Test(priority=1,groups="regression",retryAnalyzer=utilities.RetryAnalyzer.class)
	public static void verifyLoginFunctionality() throws IOException {
		
		driver.findElement(LogInPage.userNameInput()).sendKeys(FetchDataFromExcel.readData(ConstantData.LOGINPAGE_CUSTOMER_USERNAME_EXCEL_ROW, ConstantData.LOGINPAGE_CUSTOMER_USERNAME_EXCEL_COLUMN));
		
		driver.findElement(LogInPage.passwordInput()).sendKeys(FetchDataFromExcel.readData(ConstantData.LOGINPAGE_CUSTOMER_PASSWORD_EXCEL_ROW, ConstantData.LOGINPAGE_CUSTOMER_PASSWORD_EXCEL_COLUMN));
		
		driver.findElement(LogInPage.logInBtn()).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(ConstantData.EXPLICIT_WAIT_TIME));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LogInPage.welcomeUserMessage()));
		
		String actualWelcomeUserName = driver.findElement(LogInPage.welcomeUserMessage()).getText();
		
		if (actualWelcomeUserName.equals(ConstantData.EXPECTED_WELCOME_USER_MESSAGE)) {
			logger.info(" Dashboard loads with correct customer name. ");
		} else {
			logger.info(" Dashboard Not loaded and incorrect customer name. ");
		}
		
		SoftAssert soft = new SoftAssert();
	    soft.assertEquals(actualWelcomeUserName, ConstantData.EXPECTED_WELCOME_USER_MESSAGE);
	    soft.assertAll();
			
		
	}

}
