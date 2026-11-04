package ecom;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class POST_LoginAPI extends BaseData {
	
	
	@Test
	public void loginToApp()
	{
		baseURI = "https://rahulshettyacademy.com";
		
	Response resp = given()
		
		.body("{\r\n"
				+ "        \"userEmail\": \"att19sept@gmail.com\", \r\n"
				+ "        \"userPassword\": \"Test@1234\"\r\n"
				+ "    }")
		
		.header("Content-Type", "application/json")
		
		.when()
		
		.post("/api/ecom/auth/login")
		
		.then()
		
		.extract()
		
		.response();
	
	
	System.out.println(resp.asPrettyString());
	
	
	JsonPath jp = resp.jsonPath();
	
	 tokenValue = jp.getString("token");
	
	System.out.println(tokenValue);
	
	
	 userId = jp.getString("userId");
		
	System.out.println(userId);
	}

}
