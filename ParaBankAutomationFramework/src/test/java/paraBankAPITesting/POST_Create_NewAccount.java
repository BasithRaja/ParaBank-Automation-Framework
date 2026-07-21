package paraBankAPITesting;


import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class POST_Create_NewAccount {

	
	@Test(priority=4,groups="API Test")
	public static void postCreateNewAccount() {
		
		
		RestAssured.baseURI="https://parabank.parasoft.com/";
		
		String Response = given().log().all().headers("content-type","application/json")
				.queryParam("customerId", 12656)
			    .queryParam("newAccountType", 0)
			    .queryParam("fromAccountId", 13677)
				.when().post("parabank/services/bank/createAccount")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(Response);

	}
	
	
}
