package paraBankAPITesting;

public class PayloadData {
	
	public static String payload(String customerId, String newAccountType, String fromAccountId ) {
	
	String newAccountDetails =   "{\r\n" + "\"customerId\":\"" + customerId + "\",\r\n" 
	                                     + "\"newAccountType\":\"" + newAccountType + "\",\r\n"
	                                     + "\"fromAccountId\":\"" + fromAccountId + "\"\r\n" + "}";
	   return newAccountDetails;
	}
	
	
	public static String billPayPayload(String name, String street, String city,
	        String state, String zipCode, String phoneNumber, int accountNumber) {

	    String payeeData = "{\r\n"
	            + "  \"name\": \"" + name + "\",\r\n"
	            + "  \"address\": {\r\n"
	            + "    \"street\": \"" + street + "\",\r\n"
	            + "    \"city\": \"" + city + "\",\r\n"
	            + "    \"state\": \"" + state + "\",\r\n"
	            + "    \"zipCode\": \"" + zipCode + "\"\r\n"
	            + "  },\r\n"
	            + "  \"phoneNumber\": \"" + phoneNumber + "\",\r\n"
	            + "  \"accountNumber\": " + accountNumber + "\r\n"
	            + "}";

	    return payeeData;
	}
	
	
}
