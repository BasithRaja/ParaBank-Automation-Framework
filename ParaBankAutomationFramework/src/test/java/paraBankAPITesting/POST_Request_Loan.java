package paraBankAPITesting;


import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class POST_Request_Loan {

	
	@Test(priority=6,groups="API Test")
	public static void postRequestLoan() {
		
		
		RestAssured.baseURI="https://parabank.parasoft.com/";
		
		String Response = given().log().all().headers("content-type","application/json")
				.queryParam("customerId", 12656)
			    .queryParam("amount", 5000)
			    .queryParam("downPayment", 100)
			    .queryParam("fromAccountId", 15453)
				.when().post("parabank/services/bank/requestLoan")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(Response);

	}
	
	
}
