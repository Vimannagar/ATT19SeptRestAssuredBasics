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
	
	baseURI = "https://40cabe32-8d51-48d1-a34c-2b04134b2540.mock.pstmn.io";
	
	given()
	
	.header("Content-Type", "application/json")
	
	.header("x-mock-match-request-body", "true")
	
	.body(mainObject)
	
	.log().all()
	
	.when()
	
	.post("/att19septevening")
	
	.then()
	
	.log().all()
	
	.extract()
	
	.response();
	
	
	
	
	
	}

}
