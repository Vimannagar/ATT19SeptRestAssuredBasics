package queryandpathparam;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PathParameters {

	@Test
	public void getUsersInfo() {
		
		HashMap<String, String> pp = new HashMap<String, String>();
		
		pp.put("pathKey1", "2");
//		
		pp.put("pathKey2", "3");
//		
		pp.put("pathKey3", "4");
		
		RestAssured.baseURI = "https://reqres.in";

		Response resp = RestAssured.given()

//				.pathParam("pathKey1", "2")
//				
//				.pathParam("pathKey2", "3")
//				
//				.pathParam("pathKey3", "4")
				
//				.pathParams("pathKey1", "2", "pathKey2","3", "pathKey3","4")
					
				
				.pathParams(pp)
				
				.log().all()

				.when()

				.get("api/users/{pathKey1}/{pathKey2}/{pathKey3}")

				.then()
				
				.log().all()

				.extract()

				.response();

		

	}

}
