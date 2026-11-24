package assertionsusage;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ValidateData {
	
	
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
		
		.statusCode(200)// to validate if the status code is 200, if it is not 200 then it will mark the test case as fail
		
		.contentType(ContentType.JSON)// validate the content type of the response
		
		.header("Server", "cloudflare")// validate the header's key and value
		
		.time(Matchers.lessThan(5000l))// validate if the response is less than 5 msec
		
		.extract()
		
		.response();
	}

}
