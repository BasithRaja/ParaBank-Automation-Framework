package paraBankAPITesting;


import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class POST_Transfer_Funds {

	
	@Test(priority=7,groups="API Test")
	public static void postTransferFunds() {
		
		
		RestAssured.baseURI="https://parabank.parasoft.com/";
		
		String Response = given().log().all().headers("content-type","application/json")
				.queryParam("fromAccountId", 15564)
			    .queryParam("toAccountId", 13677)
			    .queryParam("amount", 500)
				.when().post("parabank/services/bank/transfer")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(Response);

	}
	
	
}
