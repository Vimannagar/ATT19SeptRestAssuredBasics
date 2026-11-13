package sendingdataasobject;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.annotations.Test;

public class ComplexDataHandling {
	
	@Test
	public void complexJsonSending()
	{
		
		// array of id which is just an integer
		
		List<Integer> arrayOfId = new ArrayList<Integer>();
		
		arrayOfId.add(5);
		arrayOfId.add(9);
		
		
		// batter's value which is an array
		
		HashMap<String, Object> batterHashMap1 = new HashMap<String, Object>();
		
		batterHashMap1.put("id", "1001");
		batterHashMap1.put("type", "Regular");
		
		
		HashMap<String, Object> batterHashMap2 = new HashMap<String, Object>();
		
		batterHashMap2.put("id", arrayOfId);
		batterHashMap2.put("type", "Chocolate");

		// batter's value 
		
		List<HashMap<String, Object>> batterArray = new ArrayList<HashMap<String,Object>>();
		
		batterArray.add(batterHashMap1);
		batterArray.add(batterHashMap2);
		
		
		// batters value which is an json of batter and its value
		
		
		HashMap<String, List<HashMap<String, Object>>> battersHashMap =  new HashMap<String, List<HashMap<String,Object>>>();
		
		battersHashMap.put("batter", batterArray);	
		
		
//		Topping's value which is array of json and now creating json
		
		
		HashMap<String, String> zerothIndex = new HashMap<String, String>();
		
		
		zerothIndex.put("id", "5001");
		zerothIndex.put("type", "None");
		
		HashMap<String, String> firstIndex = new HashMap<String, String>();
		
		
		firstIndex.put("id", "5002");
		firstIndex.put("type", "Glazed");
		
		HashMap<String, String> secondIndex = new HashMap<String, String>();
		
		
		secondIndex.put("id", "5005");
		secondIndex.put("type", "Sugar");
		
		
		List<HashMap<String, String>> toppingValue = new ArrayList<HashMap<String,String>>();
		
		
		toppingValue.add(zerothIndex);
		toppingValue.add(firstIndex);
		toppingValue.add(secondIndex);
		
		
//		final object to be created with all parent properties of json
		
		
		LinkedHashMap<String, Object> finalObject = new LinkedHashMap<String, Object>();
		
		finalObject.put("id", "0001");
		finalObject.put("type", "donut");
		finalObject.put("name", "Cake");
		finalObject.put("ppu", 0.55);
		finalObject.put("batters", battersHashMap);
		finalObject.put("topping", toppingValue);
		
		
		
		
		
		
	
	baseURI = "https://40cabe32-8d51-48d1-a34c-2b04134b2540.mock.pstmn.io";
	
	given()
	
	.header("Content-Type", "application/json")
	
	.header("x-mock-match-request-body", "true")
	
	.body(finalObject)
	
	.log().all()
	
	.when()
	
	.post("/complexdata")
	
	.then()
	
	.log().all()
	
	.extract()
	
	.response();
	
	
	
	
	
	}

}
