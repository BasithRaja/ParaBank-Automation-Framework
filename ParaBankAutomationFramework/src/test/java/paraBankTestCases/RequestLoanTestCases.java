package paraBankTestCases;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constantClasses.ConstantData;
import paraBankPages.RequestLoanPage;
import utilities.BaseClass;
import utilities.FetchDataFromExcel;
import utilities.TestListeners;

@Listeners(TestListeners.class)

public class RequestLoanTestCases extends BaseClass{
	
	private static final Logger logger = LogManager.getLogger(RequestLoanTestCases.class);

	@Test(priority=5,groups="regression",retryAnalyzer=utilities.RetryAnalyzer.class)
	public static void verifyLoanRequest() throws IOException {
		
		LogInTestCases.verifyLoginFunctionality();
		
		driver.findElement(RequestLoanPage.loanRequestLink()).click();
		
		driver.findElement(RequestLoanPage.loanAmountInput()).sendKeys(FetchDataFromExcel.readData(ConstantData.LOAN_REQUEST_PAGE_LOAN_INPUT_AMOUNT_EXCEL_ROW, ConstantData.LOAN_REQUEST_PAGE_LOAN_INPUT_AMOUNT_EXCEL_COLUMN));
		driver.findElement(RequestLoanPage.downPaymentAmountInput()).sendKeys(FetchDataFromExcel.readData(ConstantData.LOAN_REQUEST_PAGE_LOAN_DOWN_PAYMENT_AMOUNT_EXCEL_ROW, ConstantData.LOAN_REQUEST_PAGE_LOAN_DOWN_PAYMENT_AMOUNT_EXCEL_COLUMN));
		
		
	    WebElement loanFromAccountDropDown = driver.findElement(RequestLoanPage.loanFromAccountIdDropDown());
		Select Fselect = new Select(loanFromAccountDropDown);
		Fselect.selectByIndex(ConstantData.LOAN_FROM_ACCOUNT_ID_SELECT_BY_INDEX);
		
		driver.findElement(RequestLoanPage.loanApplyBtn()).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(ConstantData.EXPLICIT_WAIT_TIME));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(RequestLoanPage.loanSuccessMessage(), ConstantData.EXPECTED_LOAN_SUCCESS_MESSAGE));
		
		String ActualLoanSuccessMessage = driver.findElement(RequestLoanPage.loanSuccessMessage()).getText();
		
		String newLoanAccountID = driver.findElement(RequestLoanPage.loanNewAccountId()).getText();
		
		if (ActualLoanSuccessMessage.equals(ConstantData.EXPECTED_LOAN_SUCCESS_MESSAGE +" "+newLoanAccountID)) {
			logger.info("Loan Request Successfully Approved!");
		} else {
			logger.info("Loan Request Denied");
		}
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(ActualLoanSuccessMessage, ConstantData.EXPECTED_LOAN_SUCCESS_MESSAGE +" "+newLoanAccountID);
		
		soft.assertAll();
		
	}
}
