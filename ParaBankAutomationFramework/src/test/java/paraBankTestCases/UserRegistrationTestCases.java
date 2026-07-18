package paraBankTestCases;

import java.io.IOException;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constantClasses.ConstantData;
import paraBankPages.UserRegistrationPage;
import utilities.BaseClass;
import utilities.FetchDataFromExcel;
import utilities.TestListeners;


@Listeners(TestListeners.class)
public class UserRegistrationTestCases extends BaseClass {
	
	private static final Logger logger = LogManager.getLogger(UserRegistrationTestCases.class);

	@Test(priority=0,groups="regression",retryAnalyzer=utilities.RetryAnalyzer.class)
	public static void verifyUserRegistration() throws IOException {
		
		driver.findElement(UserRegistrationPage.userregisterationLink()).click();
		driver.findElement(UserRegistrationPage.customerFirstNameInput()).sendKeys(FetchDataFromExcel.readData(ConstantData.USER_REGISTRATION_CUSTOMER_FIRST_NAME_EXCEL_ROW, ConstantData.USER_REGISTRATION_CUSTOMER_FIRST_NAME_EXCEL_COLUMN));
		driver.findElement(UserRegistrationPage.customerLastNameInput()).sendKeys(FetchDataFromExcel.readData(ConstantData.USER_REGISTRATION_CUSTOMER_LAST_NAME_EXCEL_ROW, ConstantData.USER_REGISTRATION_CUSTOMER_LAST_NAME_EXCEL_COLUMN));
		driver.findElement(UserRegistrationPage.customerAddressInput()).sendKeys(FetchDataFromExcel.readData(ConstantData.USER_REGISTRATION_CUSTOMER_ADDRESS_EXCEL_ROW, ConstantData.USER_REGISTRATION_CUSTOMER_ADDRESS_EXCEL_COLUMN));
		driver.findElement(UserRegistrationPage.customerCityInput()).sendKeys(FetchDataFromExcel.readData(ConstantData.USER_REGISTRATION_CUSTOMER_CITY_EXCEL_ROW, ConstantData.USER_REGISTRATION_CUSTOMER_CITY_EXCEL_COLUMN));
		driver.findElement(UserRegistrationPage.customerStateInput()).sendKeys(FetchDataFromExcel.readData(ConstantData.USER_REGISTRATION_CUSTOMER_STATE_EXCEL_ROW, ConstantData.USER_REGISTRATION_CUSTOMER_STATE_EXCEL_COLUMN));
		driver.findElement(UserRegistrationPage.customerZipCodeInput()).sendKeys(FetchDataFromExcel.readData(ConstantData.USER_REGISTRATION_CUSTOMER_ZIPCODE_EXCEL_ROW, ConstantData.USER_REGISTRATION_CUSTOMER_ZIPCODE_EXCEL_COLUMN));
		driver.findElement(UserRegistrationPage.customerPhoneInput()).sendKeys(FetchDataFromExcel.readData(ConstantData.USER_REGISTRATION_CUSTOMER_PHONE_EXCEL_ROW, ConstantData.USER_REGISTRATION_CUSTOMER_PHONE_EXCEL_COLUMN));
		driver.findElement(UserRegistrationPage.customerSSNInput()).sendKeys(FetchDataFromExcel.readData(ConstantData.USER_REGISTRATION_CUSTOMER_SSN_EXCEL_ROW, ConstantData.USER_REGISTRATION_CUSTOMER_SSN_EXCEL_COLUMN));
		driver.findElement(UserRegistrationPage.customerUserNameInput()).sendKeys(FetchDataFromExcel.readData(ConstantData.USER_REGISTRATION_CUSTOMER_USERNAME_EXCEL_ROW, ConstantData.USER_REGISTRATION_CUSTOMER_USERNAME_EXCEL_COLUMN));
		driver.findElement(UserRegistrationPage.customerPasswordInput()).sendKeys(FetchDataFromExcel.readData(ConstantData.USER_REGISTRATION_CUSTOMER_PASSWORD_EXCEL_ROW, ConstantData.USER_REGISTRATION_CUSTOMER_PASSWORD_EXCEL_COLUMN));
		driver.findElement(UserRegistrationPage.passwordConfirmation()).sendKeys(FetchDataFromExcel.readData(ConstantData.USER_REGISTRATION_PASSWORD_CONFIRMATION_EXCEL_ROW, ConstantData.USER_REGISTRATION_PASSWORD_CONFIRMATION_EXCEL_COLUMN));
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
	
		
	}
}
