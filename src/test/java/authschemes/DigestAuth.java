package authschemes;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DigestAuth {
	
	@Test
	public void sendDigestAuthReq()
	{
		RestAssured.baseURI = "https://postman-echo.com";
		
		RestAssured.given()
		
//		.header("Authorization", "Basic cG9zdG1hbjpwYXNzd29yZA==")
		
		.auth()
		
		.digest("postman", "password")
		
		.log().all()
		
		.when()
		
		.get("/digest-auth")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
	}
	

}
