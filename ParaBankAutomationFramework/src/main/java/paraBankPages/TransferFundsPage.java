package paraBankPages;

import org.openqa.selenium.By;

public class TransferFundsPage {
	
	
	public static By transferFundLink() {
		
		return By.xpath("//a[@href=\"transfer.htm\"]");
	}
	
   public static By amountInput() {
		
		return By.xpath("//input[@id=\"amount\"]");
	}

   public static By fromAccountIDDropDown() {
		
   	return By.xpath("//select[@id=\"fromAccountId\"]");

	}
   
   public static By toAccountIDDropDown() {
		
	   	return By.xpath("//select[@id=\"toAccountId\"]");

		}
   
   public static By transferBtn() {
		
		return By.xpath("//input[@type=\"submit\"]");
	}
   
   public static By transferSuccessMessage() {
		
		return By.xpath("//h1[@class=\"title\" and text()=\"Transfer Complete!\"]");
	}
   
   public static By accountOverviewURL() {
		
		return By.xpath("//a[@href=\"overview.htm\"]");
	}
   
   public static By newAccountIDString(String ActualNewAccountOpenId) {
	   
	   return By.xpath("//a[text()='"+ActualNewAccountOpenId+"']");
   }
   
  public static By newAccountBalance() {
	   
	   return By.xpath("//td[@id=\"balance\"]");
   }
  
  public static By updatedAccountBalance() {
	   
	   return By.xpath("//td[@id=\"balance\"]");
  }
   
 
}
