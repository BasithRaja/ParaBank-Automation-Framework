package paraBankTestCases;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constantClasses.ConstantData;
import paraBankPages.LogOutPage;
import paraBankPages.UpdateProfileInfoPage;
import paraBankPages.UserRegistrationPage;
import utilities.BaseClass;
import utilities.FetchDataFromExcel;
import utilities.TestListeners;

@Listeners(TestListeners.class)
public class UpdateProfileInfoTestCases extends BaseClass {
	
	private static final Logger logger = LogManager.getLogger(UpdateProfileInfoTestCases.class);
	
	@Test(priority=6,groups="regression",retryAnalyzer=utilities.RetryAnalyzer.class)
	public static void verifyUpdateProfileInfo() throws IOException {
		
	    LogInTestCases.verifyLoginFunctionality();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(ConstantData.EXPLICIT_WAIT_TIME));
		wait.until(ExpectedConditions.visibilityOfElementLocated(UserRegistrationPage.accountServicesPage()));
				
		driver.findElement(UpdateProfileInfoPage.updateProfileLink()).click();
		
		WebElement addressFieldBeforeUpdate = driver.findElement(UpdateProfileInfoPage.updateAddressField());
		wait.until(ExpectedConditions.attributeToBeNotEmpty(addressFieldBeforeUpdate, "value"));
		
		String initialAddress = driver.findElement(UpdateProfileInfoPage.updateAddressField()).getAttribute("value");
	
		wait.until(ExpectedConditions.attributeContains(UpdateProfileInfoPage.updateAddressField(), "value", initialAddress));
		
		driver.findElement(UpdateProfileInfoPage.updateAddressField()).clear();
		
		driver.findElement(UpdateProfileInfoPage.updateAddressField()).sendKeys(FetchDataFromExcel.readData(ConstantData.UPDATE_PROFILE_PAGE_UPDATED_CUSTOMER_ADDRESS_EXCEL_ROW, ConstantData.UPDATE_PROFILE_PAGE_UPDATED_CUSTOMER_ADDRESS_EXCEL_COLUMN));
		
		driver.findElement(UpdateProfileInfoPage.updateProfileBtn()).click();
		
		driver.findElement(LogOutPage.logOutLink()).click();
		
		LogInTestCases.verifyLoginFunctionality();
		
		driver.findElement(UpdateProfileInfoPage.updateProfileLink()).click();
	
		WebElement addressFieldAfterUpdate = driver.findElement(UpdateProfileInfoPage.updateAddressField());
		wait.until(ExpectedConditions.attributeToBeNotEmpty(addressFieldAfterUpdate, "value"));
		
		String updatedAddress = driver.findElement(UpdateProfileInfoPage.updateAddressField()).getAttribute("value");
		
		if (initialAddress != updatedAddress) {
			logger.info("Customer Address has been successfully updated after relogin");
			logger.info("Initial Address: "+ initialAddress);
			logger.info("Newly updated Address: "+ updatedAddress);
		} else {
			logger.info("Customer Address has not been updated after relogin");
			logger.info("Initial Address: "+ initialAddress);
			logger.info("Newly updated Address: "+ updatedAddress);
		}
		
		SoftAssert soft = new SoftAssert();
		soft.assertNotEquals(initialAddress, updatedAddress);;
		soft.assertAll();
		
	}
	
}