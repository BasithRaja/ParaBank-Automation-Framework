package paraBankPages;

import org.openqa.selenium.By;

public class OpenNewAccountPage {
	
	public static By openNewAccountLink() {
		
		return By.xpath("//a[@href=\"openaccount.htm\"]");
	}
	
    public static By accountTypeDropDown() {
		
    	return By.xpath("//select[@id=\"type\"]");
	}
    
    public static By accountIdDropDown() {
		
    	return By.xpath("//select[@id=\"fromAccountId\"]");
 	}
    
    public static By openNewAccountBtn() {
		
    	return By.xpath("//input[@type=\"button\"]");
 	}
    
    public static By newAccountOpenedMessage() {
		
    	return By.xpath("//*[text()=\"Account Opened!\"]");
   	}
    
    public static By newAccountOpenedId() {
		
    	return By.xpath("//a[@id=\"newAccountId\"]");
   	}

    
}
