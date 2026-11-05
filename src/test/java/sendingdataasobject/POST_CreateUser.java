package sendingdataasobject;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class POST_CreateUser {
	
	@Test
	public void createUser()
	{
		
		LinkedHashMap<String, Object> obj = new LinkedHashMap<String, Object>();
		
		obj.put("id", 0);
		obj.put("username", "restassuredattuser1");
		obj.put("firstName", "restassured");
		obj.put("lastName", "automation");
		obj.put("email", "restassuredattevening@gmail.com");
		obj.put("password", "Test@1234");
		obj.put("phone", "9981776655");
		obj.put("userStatus", 0);
		
		
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
	Response resp = RestAssured.given()
			
			.body(obj)
			
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
