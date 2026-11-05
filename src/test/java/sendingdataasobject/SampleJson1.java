package sendingdataasobject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class SampleJson1 {
	
	
	@Test
	public void getDetails()
	{
		LinkedHashMap<String, String> zerothIndex = new LinkedHashMap<String, String>();
		
		zerothIndex.put("id", "1000");
		zerothIndex.put("type", "grains");
		
		LinkedHashMap<String, String> firstIndex = new LinkedHashMap<String, String>();
		
	firstIndex.put("id", "1001");
	firstIndex.put("type", "beverage");
	
	
	
	List<HashMap<String, String>> mainObject = new ArrayList<HashMap<String,String>>();
	
		
	mainObject.add(zerothIndex);
	mainObject.add(firstIndex);
	
	baseURI = "http://localhost.com";
	
	given()
	
	.header("Content-Type", "application/json")
	
	.body(mainObject)
	
	.log().all()
	
	.when()
	
	.post("/testing")
	
	.then()
	
	.log().all()
	
	.extract()
	
	.response();
	
	
	
	
	
	}

}
