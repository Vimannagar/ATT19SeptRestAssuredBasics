package serializationanddeserialization;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.CreateUserRequestBody;
import pojo.POST_CreateUserResponseBody;

public class CreateUserSerialization {
	
	
	@Test
	public void createUser()
	{
		CreateUserRequestBody curb = new CreateUserRequestBody();
		curb.setId(0);
		curb.setUsername("pojouser");
		curb.setFirstName("Ron");
		curb.setLastName("dutta");
		curb.setEmail("ron.dutta@gmail.com");
		curb.setPassword("Test@1234");
		curb.setPhone("9988776655");
		curb.setUserStatus(0);
		
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		Response resp = RestAssured.given()
				
				.body(curb)// serialization
				
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
		
	
	
	POST_CreateUserResponseBody createUserResponse = resp.as(POST_CreateUserResponseBody.class);
	
	
	String messageValue = createUserResponse.getMessage();
	
	System.out.println(messageValue);
	
	int codeValue = createUserResponse.getCode();
	
	System.out.println(codeValue);
	
		
		
	}

}
