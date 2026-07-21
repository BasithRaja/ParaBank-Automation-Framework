package paraBankAPITesting;


import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GET_List_Of_Transaction_For_An_Account {

	
	@Test(priority=1,groups="API Test")
	 public static void getListOfTransactionForAnAccount() {
		
		
		RestAssured.baseURI="https://parabank.parasoft.com/";
		
		String Response = given().log().all().headers("content-type","application/json")
				.queryParam("accountId", 13677)
				.when().get("parabank/services/bank/accounts/13677/transactions")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(Response);

	}
	
	
}
