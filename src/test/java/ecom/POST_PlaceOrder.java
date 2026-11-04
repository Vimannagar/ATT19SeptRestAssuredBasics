package ecom;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class POST_PlaceOrder extends BaseData {
	
	@Test
	public void placingOrder()
	{
		baseURI = "https://rahulshettyacademy.com";
		
	Response resp = given()
		
		.body("{\"orders\": [\r\n"
				+ "        {\r\n"
				+ "        \"country\": \"India\", \r\n"
				+ "        \"productOrderedId\" : \""+productId+"\"\r\n"
				+ "        }\r\n"
				+ "    ]\r\n"
				+ "}")
		
		.header("Content-Type", "application/json")
		
		.header("Authorization", tokenValue)
		
		.when()
		
		.post("api/ecom/order/create-order")
		
		.then()
		
		.extract()
		
		.response();
	
	System.out.println(resp.asPrettyString());
	}

}
