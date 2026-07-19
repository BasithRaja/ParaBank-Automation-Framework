package paraBankTestCases;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import constantClasses.ConstantData;
import paraBankPages.LogOutPage;
import paraBankPages.RequestLoanPage;
import paraBankPages.TransferFundsPage;
import utilities.BaseClass;
import utilities.FetchDataFromExcel;
import utilities.TestListeners;

@Listeners(TestListeners.class)
public class RetestingTestCases extends BaseClass{
	
	private static final Logger logger = LogManager.getLogger(RetestingTestCases.class);
	
	@Test(priority=0,groups="retest")
	public static void verifyBalanceAmountUpdate() throws IOException {
		
		UserRegistrationTestCases.verifyUserRegistration();
		driver.findElement(LogOutPage.logOutLink()).click();
		verifyFundTransferReusables();
	}
	
	@Test(priority=1,groups="retest")
	public static void verifyUniqueAccountNumber() throws IOException {
		
		verifyUserRegistrationReusables();
		
		String User1_ID = FetchDataFromExcel.readData(16, 1).toString();
		String User2_ID = FetchDataFromExcel.readData(24, 1).toString();
		
		if (User1_ID != User2_ID) {
			logger.info("The unique account numbers got generated for each users after multiple users registration.");
		} else {
			logger.info("The unique account numbers are not generated for each users after multiple users registration.");
		}
		
		SoftAssert soft = new SoftAssert();
		soft.assertNotEquals(User1_ID, User2_ID);
		soft.assertAll();
		
	}
	
	@Test(priority=2,groups="retest")
	public static void verifyLoanDetailsVisibility() throws IOException {
		
		RequestLoanTestCases.verifyLoanRequest();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(ConstantData.EXPLICIT_WAIT_TIME));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(TransferFundsPage.accountOverviewURL()));
		
		driver.findElement(TransferFundsPage.accountOverviewURL()).click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(RequestLoanPage.loanNewAccountIdInAccountSummary()));
		
		driver.findElement(RequestLoanPage.loanNewAccountIdInAccountSummary()).click();
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated(RequestLoanPage.accountTypeInfo(), ConstantData.ACCOUNT_TYPE_INFO));
		
		String AccountType = driver.findElement(RequestLoanPage.accountTypeInfo()).getText();
		
		if (AccountType.equals(ConstantData.ACCOUNT_TYPE_INFO)) {
			logger.info("The loan details are visible in account summary after loan request got approved.");         
		} else {
			logger.info("The loan details are not visible in account summary after loan request got approved.");  
			}	
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(AccountType, ConstantData.ACCOUNT_TYPE_INFO);
		soft.assertAll();
}


    @Test(priority=3,groups="retest")
    public static void verifyProfileUpdate() throws IOException {
		
    	UpdateProfileInfoTestCases.verifyUpdateProfileInfo();
		
	}
}
