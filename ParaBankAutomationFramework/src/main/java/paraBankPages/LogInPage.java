package paraBankPages;

import org.openqa.selenium.By;

public class LogInPage {
	
	public static By userNameInput() {
		
		return By.xpath("//input[@name=\"username\"]");
	}

public static By passwordInput() {
		
		return By.xpath("//input[@name=\"password\"]");
	}

public static By logInBtn() {
	
	    return By.xpath("//input[@value=\"Log In\"]");
    }

public static By welcomeUserMessage() {
	
        return By.xpath("//p[@class=\"smallText\"]");
    }


}
