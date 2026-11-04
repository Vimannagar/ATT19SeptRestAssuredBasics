package basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class POST_CreateUser {
	
	@Test
	public void createUser()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
	Response resp = RestAssured.given()
			
			.body("{\r\n"
					+ "  \"id\": 0,\r\n"
					+ "  \"username\": \"restassuredattuser\",\r\n"
					+ "  \"firstName\": \"postman\",\r\n"
					+ "  \"lastName\": \"evening\",\r\n"
					+ "  \"email\": \"restassuredattevening@gmail.com\",\r\n"
					+ "  \"password\": \"Test@1234\",\r\n"
					+ "  \"phone\": \"9981776655\",\r\n"
					+ "  \"userStatus\": 0\r\n"
					+ "}")
			
			.header("Content-Type", "application/json")
			
			.header("accept", "application/json")
			
			.log().all()
			
			.when()
			
			.post("user")
			
			.then()
			
			.log().all()
			
			.extract()
			
			.response();
	
	
String strResponse = resp.asPrettyString();

System.out.println(strResponse);


	JsonPath jp = resp.jsonPath();

	String messageValue = jp.getString("message");
		
	System.out.println("Message value is "+messageValue);
	
	
			



				
	
	
	}

}
