package dataextraction;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class DataExtractionFromReadyMadeJson {
	
	
@Test
public void getReadFromReadyMadeResponse()
{
	
	String strResp = "{\r\n"
			+ "  \"dashboard\": {\r\n"
			+ "  \"purchaseAmount\":1000,\r\n"
			+ "    \"website\": \"https://abc.com\"\r\n"
			+ "   },\r\n"
			+ "\r\n"
			+ "  \"course\": [\r\n"
			+ "  {\r\n"
			+ "    \"title\":\"selenium\",\r\n"
			+ "    \"cost\": 50,\r\n"
			+ "    \"copies\": 6\r\n"
			+ "  },\r\n"
			+ "     {\r\n"
			+ "    \"title\":\"playwright\",\r\n"
			+ "    \"cost\": 40,\r\n"
			+ "    \"copies\": 4\r\n"
			+ "  },\r\n"
			+ "     {\r\n"
			+ "    \"title\":\"RPA\",\r\n"
			+ "    \"cost\": 45,\r\n"
			+ "    \"copies\": 10\r\n"
			+ "  }\r\n"
			+ "   \r\n"
			+ "  ]\r\n"
			+ " \r\n"
			+ "}";
	
	
	
	JsonPath jp = new JsonPath(strResp);
	
	String websiteValue = jp.getString("dashboard.website");
	
	System.out.println(websiteValue);
	
}
	

}
