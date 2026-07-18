package paraBankTestCases;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constantClasses.ConstantData;
import paraBankPages.LogInPage;
import paraBankPages.OpenNewAccountPage;
import paraBankPages.UserRegistrationPage;
import utilities.BaseClass;
	import utilities.FetchDataFromExcel;
import utilities.TestListeners;

	@Listeners(TestListeners.class)
	public class OpenNewAccountTestCases extends BaseClass {
		
		private static final Logger logger = LogManager.getLogger(OpenNewAccountTestCases.class);

		@Test(priority=3,groups="regression",retryAnalyzer=utilities.RetryAnalyzer.class)
		public static void verifyNewAccountOpen() throws IOException {
			
			LogInTestCases.verifyLoginFunctionality();
			
			driver.findElement(OpenNewAccountPage.openNewAccountLink()).click();
			
			WebElement newAccountTypeDropDown = driver.findElement(OpenNewAccountPage.accountTypeDropDown());
			Select Aselect = new Select(newAccountTypeDropDown);
			Aselect.selectByVisibleText(ConstantData.NEW_ACCOUNT_OPEN_SELECTBY_VISIBLE_TEXT);
			
			WebElement newAccountIdDropDown = driver.findElement(OpenNewAccountPage.accountIdDropDown());
			Select Bselect = new Select(newAccountIdDropDown);
			Bselect.selectByIndex(ConstantData.NEW_ACCOUNT_OPEN_SELECTBY_INDEX);
			
			driver.findElement(OpenNewAccountPage.openNewAccountBtn()).click();
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(ConstantData.EXPLICIT_WAIT_TIME));
			wait.until(ExpectedConditions.visibilityOfElementLocated(OpenNewAccountPage.newAccountOpenedMessage()));
			
			String ActualNewAccountOpenMessage = driver.findElement(OpenNewAccountPage.newAccountOpenedMessage()).getText();
			
            String ActualNewAccountOpenId= driver.findElement(OpenNewAccountPage.newAccountOpenedId()).getText();
			
			FetchDataFromExcel.writeData(ConstantData.NEW_ACCOUNT_ID_STORE_IN_EXCEL_ROW, ConstantData.NEW_ACCOUNT_ID_STORE_IN_EXCEL_COLUMN, ActualNewAccountOpenId);
			
			if (ActualNewAccountOpenMessage.equals(ConstantData.EXPECTED_NEW_ACCOUNT_OPEN_MESSAGE)) {
				logger.info("New Account Successfully Opened and New Account Id has been saved in Excel");
			} else {
				logger.info("New Account Not Successfully Opened and also New Account Id has not been saved in Excel");
			}
			SoftAssert soft = new SoftAssert();
		    soft.assertEquals(ActualNewAccountOpenMessage, ConstantData.EXPECTED_NEW_ACCOUNT_OPEN_MESSAGE);
		    soft.assertAll();
			
		}
	}
