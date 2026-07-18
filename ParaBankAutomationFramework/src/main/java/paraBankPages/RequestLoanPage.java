package paraBankPages;

import org.openqa.selenium.By;

public class RequestLoanPage {
	
	public static By loanRequestLink() {
		
		return By.xpath("//a[@href=\"requestloan.htm\"]");
				
	}

    public static By loanAmountInput() {
	
	return By.xpath("//input[@id=\"amount\"]");
			
    }

    public static By downPaymentAmountInput() {
    	
	return By.xpath("//input[@id=\"downPayment\"]");
			
    }

    public static By loanFromAccountIdDropDown() {
    	
    	return By.xpath("//select[@id=\"fromAccountId\"]");
    			
        }
    
  public static By loanApplyBtn() {
    	
    	return By.xpath("//input[@type=\"button\"]");
    			
        }
    
  public static By loanSuccessMessage() {
  	
  	return By.xpath("//div[@id=\"loanRequestApproved\"]");
  			
      }
  public static By loanNewAccountId() {
	  	
	  	return By.xpath("//a[@id=\"newAccountId\"]");
	  			
	      }
  

}
