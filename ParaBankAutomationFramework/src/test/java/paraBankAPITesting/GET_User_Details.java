package paraBankAPITesting;


import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GET_User_Details {

	@Test(priority=2,groups="API Test")
		public static void getUserDetails() {
		
		RestAssured.baseURI="https://parabank.parasoft.com/";
		
		String Response = given().log().all().headers("content-type","application/json")
				.queryParam("Customer Username", "love")
				.queryParam("Customer Password", "love")
				.when().get("parabank/services/bank/login/love/love")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(Response);

	}
	
	
}
