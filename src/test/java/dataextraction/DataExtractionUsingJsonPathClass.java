package dataextraction;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DataExtractionUsingJsonPathClass {

	
	
	
	@Test
	public void fetchResponseBodyData()
	{
		baseURI = "https://reqres.in";

		Response resp = given()

				.when()

				.get("api/users?page=2")
				
				.then()
				
				.extract()
				
				.response();

		String stringResponse = resp.asPrettyString();

		System.out.println(stringResponse);
		
		
		JsonPath jp = new JsonPath(stringResponse);
		
		int totalValue = jp.getInt("total");
		
		System.out.println(totalValue +" is the value of total");
		
		
		String strData = jp.getString("support.url");
		
		
		System.out.println(strData);
		
	}
}
