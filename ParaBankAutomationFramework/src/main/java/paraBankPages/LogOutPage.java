package paraBankPages;

import org.openqa.selenium.By;

public class LogOutPage {
	
	public static By logOutLink() {
		
		return By.xpath("//a[text()=\"Log Out\"]");
	}

public static By customerLoginText() {
		
		return By.xpath("//*[text()=\"Customer Login\"]");
	}
	
}
