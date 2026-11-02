package basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GETUserInformation {
	
	
		@Test
		public void getUsersInfo()
		{
			RestAssured.baseURI = "https://reqres.in";
			
		Response resp = RestAssured.given()
			
			.when()
			
			.get("api/users/2")
			
			.then()
			
			.extract()
			
			.response();
		
		
		String value = resp.asPrettyString();
		
		System.out.println(value);
			
			
			
		}
	
	}
