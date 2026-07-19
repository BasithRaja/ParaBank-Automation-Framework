package paraBankPages;

import org.openqa.selenium.By;

public class UserRegistrationPage {
	
public static By userregisterationLink() {
		
		return By.xpath("//a[text()=\"Register\"]");
	}

	public static By customerFirstNameInput() {
		
		return By.xpath("//input[@id=\"customer.firstName\"]");
	}
	
public static By customerLastNameInput() {
		
		return By.xpath("//input[@id=\"customer.lastName\"]");
	}
	
public static By customerAddressInput() {
	
	return By.xpath("//input[@id=\"customer.address.street\"]");
}

public static By customerCityInput() {
	
	return By.xpath("//input[@id=\"customer.address.city\"]");
}
	
public static By customerStateInput() {
	
	return By.xpath("//input[@id=\"customer.address.state\"]");
}

public static By customerZipCodeInput() {
	
	return By.xpath("//input[@id=\"customer.address.zipCode\"]");
}

public static By customerPhoneInput() {
	
	return By.xpath("//input[@id=\"customer.phoneNumber\"]");
}

public static By customerSSNInput() {
	
	return By.xpath("//input[@id=\"customer.ssn\"]");
}

public static By customerUserNameInput() {
	
	return By.xpath("//input[@id=\"customer.username\"]");
}

public static By customerPasswordInput() {
	
	return By.xpath("//input[@id=\"customer.password\"]");
}

public static By passwordConfirmation() {
	
	return By.xpath("//input[@id=\"repeatedPassword\"]");
}

public static By registerBtn() {
	
	return By.xpath("//input[@value=\"Register\"]");
}

public static By accountServicesPage() {
	
	return By.xpath("//*[text()=\"Account Services\"]");
}

public static By initialAccountID() {
	
	return By.xpath("//table[@id='accountTable']/tbody/tr/td[1]/a");
}


}
