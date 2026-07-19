package paraBankTestCases;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constantClasses.ConstantData;
import paraBankPages.LogInPage;
import paraBankPages.TransferFundsPage;
import utilities.BaseClass;
import utilities.FetchDataFromExcel;
import utilities.TestListeners;


@Listeners(TestListeners.class)
public class TransferFundsTestCases extends BaseClass {
	
	private static final Logger logger = LogManager.getLogger(TransferFundsTestCases.class);
    WebElement fromAccountDropDownOptions;
	WebElement toAccountDropDownOptions;
	WebDriverWait wait;
    String actualTransferSuccessMessage;
	SoftAssert soft;
	String actualNewAccountNumber;
	String actualNewAccountBalance;
	
	@Test(priority=4,groups="regression",retryAnalyzer=utilities.RetryAnalyzer.class)
	public void verifyFundTransfer() throws IOException {
		
		OpenNewAccountTestCases.verifyNewAccountOpen();
		
		// To check initial transfer balance
		wait = new WebDriverWait(driver,Duration.ofSeconds(ConstantData.EXPLICIT_WAIT_TIME));
        wait.until(ExpectedConditions.visibilityOfElementLocated(TransferFundsPage.transferFundLink()));
		
		driver.findElement(TransferFundsPage.transferFundLink()).click();
		
		driver.findElement(TransferFundsPage.amountInput()).sendKeys(FetchDataFromExcel.readData(ConstantData.TRANSFER_AMOUNT_PAGE_INPUT_AMOUNT_EXCEL_ROW, ConstantData.TRANSFER_AMOUNT_PAGE_INPUT_AMOUNT_EXCEL_COLUMN));
		
	    fromAccountDropDownOptions = driver.findElement(TransferFundsPage.fromAccountIDDropDown());
		Select Cselect = new Select(fromAccountDropDownOptions);
		Cselect.selectByIndex(ConstantData.FROM_ACCOUNT_SELECTBY_INDEX);
		
		toAccountDropDownOptions = driver.findElement(TransferFundsPage.toAccountIDDropDown());
		Select Dselect = new Select(toAccountDropDownOptions);
		Dselect.selectByIndex(ConstantData.TO_ACCOUNT_SELECTBY_INDEX);
		
        driver.findElement(TransferFundsPage.transferBtn()).click();
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(TransferFundsPage.transferSuccessMessage()));
        
        actualTransferSuccessMessage = driver.findElement(TransferFundsPage.transferSuccessMessage()).getText();
        
        if (actualTransferSuccessMessage.equals(ConstantData.EXPECTED_TRANSFER_SUCCESS_MESSAGE)) {
        	logger.info("1st Transaction Succesfully Completed!");
		} else {
			logger.info("1st Transaction Not-Succesfully Completed!");
		}
        
        soft = new SoftAssert();
        soft.assertEquals(actualTransferSuccessMessage, ConstantData.EXPECTED_TRANSFER_SUCCESS_MESSAGE);
        
        driver.findElement(TransferFundsPage.accountOverviewURL()).click();
        
        actualNewAccountNumber = FetchDataFromExcel.readData(ConstantData.NEW_ACCOUNT_ID_STORE_IN_EXCEL_ROW, ConstantData.NEW_ACCOUNT_ID_STORE_IN_EXCEL_COLUMN);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(TransferFundsPage.newAccountIDString(actualNewAccountNumber)));
        
        driver.findElement(TransferFundsPage.newAccountIDString(actualNewAccountNumber)).click();
        
        wait.until(ExpectedConditions.textToBePresentInElementLocated(TransferFundsPage.updatedAccountBalance(), ConstantData.EXPECTED_NEW_ACCOUNT_BALANCE));
        
        actualNewAccountBalance = driver.findElement(TransferFundsPage.newAccountBalance()).getText();
        
        
        if (actualNewAccountBalance.equals(ConstantData.EXPECTED_NEW_ACCOUNT_BALANCE)) {
        	logger.info("1st Transaction Balance Updated");
		} else {
			logger.info("1st Transaction Balance Not-Updated");
		}
        
        soft.assertEquals(actualNewAccountBalance,ConstantData.EXPECTED_NEW_ACCOUNT_BALANCE);
        
        
       // To check incremental transfer balance
        driver.findElement(TransferFundsPage.transferFundLink()).click();
		
		driver.findElement(TransferFundsPage.amountInput()).sendKeys(FetchDataFromExcel.readData(ConstantData.TRANSFER_AMOUNT_PAGE_INPUT_AMOUNT_EXCEL_ROW, ConstantData.TRANSFER_AMOUNT_PAGE_INPUT_AMOUNT_EXCEL_COLUMN));
		
		fromAccountDropDownOptions = driver.findElement(TransferFundsPage.fromAccountIDDropDown());
		
        wait.until(ExpectedConditions.visibilityOf(fromAccountDropDownOptions));
        
		Select Eselect = new Select(fromAccountDropDownOptions);
		Eselect.selectByIndex(ConstantData.FROM_ACCOUNT_SELECTBY_INDEX);
		
		toAccountDropDownOptions = driver.findElement(TransferFundsPage.toAccountIDDropDown());
		
		
        wait.until(ExpectedConditions.visibilityOf(toAccountDropDownOptions));
        
		Select Fselect = new Select(toAccountDropDownOptions);
		Fselect.selectByIndex(ConstantData.TO_ACCOUNT_SELECTBY_INDEX);
		
        driver.findElement(TransferFundsPage.transferBtn()).click();
		
   
        wait.until(ExpectedConditions.visibilityOfElementLocated(TransferFundsPage.transferSuccessMessage()));
        
        actualTransferSuccessMessage = driver.findElement(TransferFundsPage.transferSuccessMessage()).getText();
        
        
         if (actualTransferSuccessMessage.equals(ConstantData.EXPECTED_TRANSFER_SUCCESS_MESSAGE)) {
        	logger.info("2nd Transaction Succcesfully Completed!");
		} else {
			logger.info("2nd Transaction Not-Succcesfully Completed!");
		}
         
        soft.assertEquals(actualTransferSuccessMessage, ConstantData.EXPECTED_TRANSFER_SUCCESS_MESSAGE);
        
        driver.findElement(TransferFundsPage.accountOverviewURL()).click();
        
        actualNewAccountNumber = FetchDataFromExcel.readData(ConstantData.NEW_ACCOUNT_ID_STORE_IN_EXCEL_ROW, ConstantData.NEW_ACCOUNT_ID_STORE_IN_EXCEL_COLUMN);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(TransferFundsPage.newAccountIDString(actualNewAccountNumber)));
        
        driver.findElement(TransferFundsPage.newAccountIDString(actualNewAccountNumber)).click();
        
        wait.until(ExpectedConditions.textToBePresentInElementLocated(TransferFundsPage.updatedAccountBalance(), ConstantData.EXPECTED_NEW_ACCOUNT_BALANCE_2));
        
        actualNewAccountBalance = driver.findElement(TransferFundsPage.updatedAccountBalance()).getText();
        
        
        if (actualNewAccountBalance.equals(ConstantData.EXPECTED_NEW_ACCOUNT_BALANCE_2)) {
        	logger.info("2nd Transaction Balance Updated");
		} else {
			logger.info("2nd Transaction Balance Not-Updated");
		}
        
        soft.assertEquals(actualNewAccountBalance,ConstantData.EXPECTED_NEW_ACCOUNT_BALANCE_2);
        
        soft.assertAll(); 
        
	}
}
