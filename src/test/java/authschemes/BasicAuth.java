package authschemes;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BasicAuth {
	
	
	@Test
	public void sendBasicAuthReq()
	{
		RestAssured.baseURI = "https://postman-echo.com";
		
		RestAssured.given()
		
//		.header("Authorization", "Basic cG9zdG1hbjpwYXNzd29yZA==")
		
		.auth()
		
		.basic("postman", "password")
		
		.log().all()
		
		.when()
		
		.get("basic-auth")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
	}

}
