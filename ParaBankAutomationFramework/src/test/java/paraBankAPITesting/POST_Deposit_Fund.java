package paraBankAPITesting;


import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class POST_Deposit_Fund {

	
	@Test(priority=5,groups="API Test")
	public static void postDepositFund() {
		
		
		RestAssured.baseURI="https://parabank.parasoft.com/";
		
		String Response = given().log().all().headers("content-type","application/json")
				.queryParam("accountId", 13677)
			    .queryParam("amount", 2000)
				.when().post("parabank/services/bank/deposit")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(Response);

	}
	
	
}
