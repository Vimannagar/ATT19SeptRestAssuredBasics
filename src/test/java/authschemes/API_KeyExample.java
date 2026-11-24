package authschemes;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class API_KeyExample {
	
	
	@Test
	public void getAllWorkspaces()
	{
		RestAssured.baseURI = "https://api.postman.com";
		
		RestAssured.given()
		
		.header("x-api-key", "")
				
		.log().all()
		
		.when()
		
		.get("/workspaces")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
	}

}
