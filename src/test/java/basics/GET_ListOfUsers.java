package basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_ListOfUsers {
	
	@Test
	public void fetchAllUsers()
	{
		RestAssured.baseURI = "https://reqres.in";
		
		
	RequestSpecification req = RestAssured.given();
	
	RequestSpecification reqq = req.when();
	
	Response resp = reqq.get("api/users?page=2");
	
	System.out.println("The response of this request is : "+ resp);
	
	String stringResponse = resp.asPrettyString();
	
	
	
	System.out.println(stringResponse);
		
	}

}
