package paraBankAPITesting;


import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class POST_Bill_Pay {

	
	@Test(priority=3,groups="API Test")	
		public static void PostBillPay() {
		
		RestAssured.baseURI="https://parabank.parasoft.com/";
		
		String Response = given().log().all().headers("content-type","application/json")
				.queryParam("accountId", 13677)
			    .queryParam("amount", 20).body(PayloadData.billPayPayload(
			            "Tom",
			            "123 Main Street",
			            "Chennai",
			            "Tamil Nadu",
			            "600001",
			            "9876543210",
			            16452))
				.when().post("parabank/services/bank/billpay")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(Response);

	}
	
	
}
