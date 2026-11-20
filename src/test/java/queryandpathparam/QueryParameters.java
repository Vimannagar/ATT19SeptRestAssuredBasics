package queryandpathparam;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.LinkedHashMap;

import io.restassured.response.Response;

public class QueryParameters {
	
	
	
	@Test
	public void queryParams()
	{
		
		LinkedHashMap<String, String> qp = new LinkedHashMap<String, String>();
		qp.put("page", "2");
		qp.put("line", "4");
		qp.put("word", "6");
		
		baseURI = "https://reqres.in";

		Response resp = given()
				
//				.queryParam("page", "2")
//				
//				.queryParam("line", "4")
//				
//				.queryParam("word", "6")
				
//				.queryParams("page", "2", "line", "4", "word", "6")
				
				.queryParams(qp)
				
				.log().all()

				.when()

				.get("api/users")
				
				.then()
				
				.log().all()
				
				.extract()
				
				.response();
		
	}

}
