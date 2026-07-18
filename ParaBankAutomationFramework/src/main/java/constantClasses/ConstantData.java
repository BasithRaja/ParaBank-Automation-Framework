package constantClasses;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.text.Utilities;

public class ConstantData {
	
	
	// GLOBAL CONSTANT VALUES
	public static final String PROP_FILE_PATH="src/main/java/Global.properties";
	public static final String EXCEL_PATH= System.getProperty("user.dir") + "/src/main/java/ParaBank-TestData/ParaBank-TestDataExcelSheet.xlsx";
	public static final String FAILED_SCREENSHOT_PATH="target/FailedScreenshots/" + LocalDateTime.now()
    .format(DateTimeFormatter.ofPattern("YYYYMMDD_HHMMSS")) + "_test.png";
	public static final int EXPLICIT_WAIT_TIME=30;


	//USER REGISTRATION PAGE
	public static final int USER_REGISTRATION_CUSTOMER_FIRST_NAME_EXCEL_ROW=0;
	public static final int USER_REGISTRATION_CUSTOMER_FIRST_NAME_EXCEL_COLUMN=1;
	public static final int USER_REGISTRATION_CUSTOMER_LAST_NAME_EXCEL_ROW=1;
	public static final int USER_REGISTRATION_CUSTOMER_LAST_NAME_EXCEL_COLUMN=1;
	public static final int USER_REGISTRATION_CUSTOMER_ADDRESS_EXCEL_ROW=2;
	public static final int USER_REGISTRATION_CUSTOMER_ADDRESS_EXCEL_COLUMN=1;
	public static final int USER_REGISTRATION_CUSTOMER_CITY_EXCEL_ROW=3;
	public static final int USER_REGISTRATION_CUSTOMER_CITY_EXCEL_COLUMN=1;
	public static final int USER_REGISTRATION_CUSTOMER_STATE_EXCEL_ROW=4;
	public static final int USER_REGISTRATION_CUSTOMER_STATE_EXCEL_COLUMN=1;
	public static final int USER_REGISTRATION_CUSTOMER_ZIPCODE_EXCEL_ROW=5;
	public static final int USER_REGISTRATION_CUSTOMER_ZIPCODE_EXCEL_COLUMN=1;
	public static final int USER_REGISTRATION_CUSTOMER_PHONE_EXCEL_ROW=6;
	public static final int USER_REGISTRATION_CUSTOMER_PHONE_EXCEL_COLUMN=1;
	public static final int USER_REGISTRATION_CUSTOMER_SSN_EXCEL_ROW=7;
	public static final int USER_REGISTRATION_CUSTOMER_SSN_EXCEL_COLUMN=1;
	public static final int USER_REGISTRATION_CUSTOMER_USERNAME_EXCEL_ROW=8;
	public static final int USER_REGISTRATION_CUSTOMER_USERNAME_EXCEL_COLUMN=1;
	public static final int USER_REGISTRATION_CUSTOMER_PASSWORD_EXCEL_ROW=9;
	public static final int USER_REGISTRATION_CUSTOMER_PASSWORD_EXCEL_COLUMN=1;
	public static final int USER_REGISTRATION_PASSWORD_CONFIRMATION_EXCEL_ROW=10;
	public static final int USER_REGISTRATION_PASSWORD_CONFIRMATION_EXCEL_COLUMN=1;
	public static final String EXPECTED_WELCOME_PAGE_TITLE="ParaBank | Customer Created";
	
	// LogIn Page
	public static final int LOGINPAGE_CUSTOMER_USERNAME_EXCEL_ROW=8;
	public static final int LOGINPAGE_CUSTOMER_USERNAME_EXCEL_COLUMN=1;
	public static final int LOGINPAGE_CUSTOMER_PASSWORD_EXCEL_ROW=9;
	public static final int LOGINPAGE_CUSTOMER_PASSWORD_EXCEL_COLUMN=1;
	public static final String EXPECTED_WELCOME_USER_MESSAGE="Welcome hardy hardy"; 
	
	// OPEN NEW ACCOUNT PAGE
	public static final String EXPECTED_NEW_ACCOUNT_OPEN_MESSAGE="Account Opened!";
	public static final String NEW_ACCOUNT_OPEN_SELECTBY_VISIBLE_TEXT = "SAVINGS";
	public static final int NEW_ACCOUNT_OPEN_SELECTBY_INDEX = 0;
	public static final int NEW_ACCOUNT_ID_STORE_IN_EXCEL_ROW=11;
	public static final int NEW_ACCOUNT_ID_STORE_IN_EXCEL_COLUMN=1;
	
	// TRANSFER AMOUNT PAGE
	public static final int TRANSFER_AMOUNT_PAGE_INPUT_AMOUNT_EXCEL_ROW=12;
	public static final int TRANSFER_AMOUNT_PAGE_INPUT_AMOUNT_EXCEL_COLUMN=1;
	public static final String EXPECTED_TRANSFER_SUCCESS_MESSAGE = "Transfer Complete!";
	public static final String EXPECTED_NEW_ACCOUNT_BALANCE = "$200.00";
	public static final String EXPECTED_NEW_ACCOUNT_BALANCE_2 = "$300.00";
	public static final int FROM_ACCOUNT_SELECTBY_INDEX = 0;
	public static final int TO_ACCOUNT_SELECTBY_INDEX = 2;
	
	// LOAN REQUEST PAGE
	public static final int LOAN_FROM_ACCOUNT_ID_SELECT_BY_INDEX = 0;
	public static final String EXPECTED_LOAN_SUCCESS_MESSAGE="Congratulations, your loan has been approved.\n"
			+ "Your new account number:";
	public static final int LOAN_REQUEST_PAGE_LOAN_INPUT_AMOUNT_EXCEL_ROW=13;
	public static final int LOAN_REQUEST_PAGE_LOAN_INPUT_AMOUNT_EXCEL_COLUMN=1;
	public static final int LOAN_REQUEST_PAGE_LOAN_DOWN_PAYMENT_AMOUNT_EXCEL_ROW=14;
	public static final int LOAN_REQUEST_PAGE_LOAN_DOWN_PAYMENT_AMOUNT_EXCEL_COLUMN=1;
	
	// UPDATE PROFILE PAGE
	 public static final int UPDATE_PROFILE_PAGE_UPDATED_CUSTOMER_ADDRESS_EXCEL_ROW=15;
	 public static final int UPDATE_PROFILE_PAGE_UPDATED_CUSTOMER_ADDRESS_EXCEL_COLUMN=1;
}  
