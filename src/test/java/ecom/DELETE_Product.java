package ecom;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DELETE_Product extends BaseData {
	
	@Test
	public void deleteProduct()
	{
		
			baseURI = "https://rahulshettyacademy.com";
			
		Response resp = given()
				
				.header("Authorization", tokenValue)
		
			
			.when()
			
			.delete("api/ecom/product/delete-product/"+productId)
			
			.then()
			
			.extract()
			
			.response();
		
		String strResp = resp.asPrettyString();
		
		System.out.println(strResp);
	}

}
