package paraBankPages;

import org.openqa.selenium.By;

public class UpdateProfileInfoPage {

public static By updateProfileLink() {
		
		return By.xpath("//a[@href=\"updateprofile.htm\"]");
	}

    public static By updateAddressField() {
		
		return By.xpath("//input[@id=\"customer.address.street\"]");
	}
    
    public static By updateProfileBtn() {
		
		return By.xpath("//input[@type=\"button\"]");
	}
}
