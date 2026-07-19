package utilities;
	
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import constantClasses.ConstantData;
import paraBankPages.TransferFundsPage;
import paraBankPages.UserRegistrationPage;
import paraBankTestCases.OpenNewAccountTestCases;
import paraBankTestCases.TransferFundsTestCases;

	public class BaseClass {
		
		public static WebDriver driver;
		
		@BeforeMethod(alwaysRun=true)
		
		public void launchBrowser() throws IOException
		{
			
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--disable-notifications");
			opt.addArguments("--disable-password-generation");
			opt.addArguments("--incognito");
			
			String browserName = FetchDataFromProperty.getDataFromProperty().getProperty("browser");
			String URL = FetchDataFromProperty.getDataFromProperty().getProperty("url");
			
			
			if (browserName.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver(opt);
				driver.get(URL);
				driver.manage().window().maximize();
			}
			
			if (browserName.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
				driver.get(URL);
				driver.manage().window().maximize();
			}
			
			if (browserName.equalsIgnoreCase("edge"))
			{
				driver = new EdgeDriver();
				driver.get(URL);
				driver.manage().window().maximize();
			}
		}
		
		
		public static void scrollDown()
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,400)","");
		}
		
		public static void acceptAlert()
		{
			driver.switchTo().alert().accept();
		}

		@AfterMethod(alwaysRun=true)
		
		public void closeBrowser()
		{
			driver.quit();
		}
		
		public static void verifyFundTransferReusables() throws IOException {
			
			Logger logger = LogManager.getLogger(TransferFundsTestCases.class);
			WebElement fromAccountDropDownOptions;
			WebElement toAccountDropDownOptions;
			WebDriverWait wait;
			String actualTransferSuccessMessage;
			SoftAssert soft;
		    String actualNewAccountNumber;
			String actualNewAccountBalance;
			
			
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
	        	logger.info("Transaction Succesfully Completed!");
			} else {
				logger.info("Transaction Not-Succesfully Completed!");
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
	        	logger.info("Transaction Balance Updated");
			} else {
				logger.info("Transaction Balance Not-Updated");
			}
	        
	        soft.assertEquals(actualNewAccountBalance,ConstantData.EXPECTED_NEW_ACCOUNT_BALANCE);
	        soft.assertAll();
		
	 }
		
		public static void verifyUserRegistrationReusables() throws IOException {
			
		    Logger logger = LogManager.getLogger(BaseClass.class);
			
			driver.findElement(UserRegistrationPage.userregisterationLink()).click();
			driver.findElement(UserRegistrationPage.customerFirstNameInput()).sendKeys(FetchDataFromExcel.readData(ConstantData.RETEST_USER2_USER_REGISTRATION_CUSTOMER_FIRST_NAME_EXCEL_ROW, ConstantData.RETEST_USER2_USER_REGISTRATION_CUSTOMER_FIRST_NAME_EXCEL_COLUMN));
			driver.findElement(UserRegistrationPage.customerLastNameInput()).sendKeys(FetchDataFromExcel.readData(ConstantData.RETEST_USER2_USER_REGISTRATION_CUSTOMER_LAST_NAME_EXCEL_ROW, ConstantData.RETEST_USER2_USER_REGISTRATION_CUSTOMER_LAST_NAME_EXCEL_COLUMN));
			driver.findElement(UserRegistrationPage.customerAddressInput()).sendKeys(FetchDataFromExcel.readData(ConstantData.USER_REGISTRATION_CUSTOMER_ADDRESS_EXCEL_ROW, ConstantData.USER_REGISTRATION_CUSTOMER_ADDRESS_EXCEL_COLUMN));
			driver.findElement(UserRegistrationPage.customerCityInput()).sendKeys(FetchDataFromExcel.readData(ConstantData.USER_REGISTRATION_CUSTOMER_CITY_EXCEL_ROW, ConstantData.USER_REGISTRATION_CUSTOMER_CITY_EXCEL_COLUMN));
			driver.findElement(UserRegistrationPage.customerStateInput()).sendKeys(FetchDataFromExcel.readData(ConstantData.USER_REGISTRATION_CUSTOMER_STATE_EXCEL_ROW, ConstantData.USER_REGISTRATION_CUSTOMER_STATE_EXCEL_COLUMN));
			driver.findElement(UserRegistrationPage.customerZipCodeInput()).sendKeys(FetchDataFromExcel.readData(ConstantData.USER_REGISTRATION_CUSTOMER_ZIPCODE_EXCEL_ROW, ConstantData.USER_REGISTRATION_CUSTOMER_ZIPCODE_EXCEL_COLUMN));
			driver.findElement(UserRegistrationPage.customerPhoneInput()).sendKeys(FetchDataFromExcel.readData(ConstantData.USER_REGISTRATION_CUSTOMER_PHONE_EXCEL_ROW, ConstantData.USER_REGISTRATION_CUSTOMER_PHONE_EXCEL_COLUMN));
			driver.findElement(UserRegistrationPage.customerSSNInput()).sendKeys(FetchDataFromExcel.readData(ConstantData.USER_REGISTRATION_CUSTOMER_SSN_EXCEL_ROW, ConstantData.USER_REGISTRATION_CUSTOMER_SSN_EXCEL_COLUMN));
			driver.findElement(UserRegistrationPage.customerUserNameInput()).sendKeys(FetchDataFromExcel.readData(ConstantData.RETEST_USER2_USER_REGISTRATION_CUSTOMER_USERNAME_EXCEL_ROW, ConstantData.RETEST_USER2_USER_REGISTRATION_CUSTOMER_USERNAME_EXCEL_COLUMN));
			driver.findElement(UserRegistrationPage.customerPasswordInput()).sendKeys(FetchDataFromExcel.readData(ConstantData.RETEST_USER2_USER_REGISTRATION_CUSTOMER_PASSWORD_EXCEL_ROW, ConstantData.RETEST_USER2_USER_REGISTRATION_CUSTOMER_PASSWORD_EXCEL_COLUMN));
			driver.findElement(UserRegistrationPage.passwordConfirmation()).sendKeys(FetchDataFromExcel.readData(ConstantData.RETEST_USER2_USER_REGISTRATION_PASSWORD_CONFIRMATION_EXCEL_ROW, ConstantData.RETEST_USER2_USER_REGISTRATION_PASSWORD_CONFIRMATION_EXCEL_COLUMN));
			driver.findElement(UserRegistrationPage.registerBtn()).click();
			

			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(ConstantData.EXPLICIT_WAIT_TIME));
			wait.until(ExpectedConditions.visibilityOfElementLocated(UserRegistrationPage.accountServicesPage()));
				
		    String actualPageTitle = driver.getTitle();
		    
		    if (actualPageTitle.equals(ConstantData.EXPECTED_WELCOME_PAGE_TITLE)) {
		    	 logger.info("User registration completed successfully. User navigated to the Account Services page.");
			} else {
				 logger.info("User registration not completed successfully. User is not navigated to the Account Services page.");
			}
		    
		    SoftAssert soft = new SoftAssert();
		    soft.assertEquals(actualPageTitle, ConstantData.EXPECTED_WELCOME_PAGE_TITLE);
		    
		    soft.assertAll();
		    
		    driver.findElement(TransferFundsPage.accountOverviewURL()).click();
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(UserRegistrationPage.initialAccountID()));
		    
		    String initialAccountID = driver.findElement(UserRegistrationPage.initialAccountID()).getText();
		    FetchDataFromExcel.writeData(ConstantData.RETEST_USER2_NEW_ACCOUNT_ID_STORE_IN_EXCEL_ROW, ConstantData.RETEST_USER2_NEW_ACCOUNT_ID_STORE_IN_EXCEL_COLUMN, initialAccountID);
		   
			
		}
		

	}


