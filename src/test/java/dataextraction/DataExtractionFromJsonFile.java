package dataextraction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class DataExtractionFromJsonFile {
	
	@Test
	public void readDataFromJsonFile() throws FileNotFoundException
	{
		String jsonFilePath = System.getProperty("user.dir") +"\\src\\test\\resources\\SampleData.json";
		
		FileInputStream fis  = new FileInputStream(jsonFilePath);
		
		JsonPath jp = new JsonPath(fis);
		
		int purchaseAmount = jp.getInt("dashboard.purchaseAmount");
		
		System.out.println(purchaseAmount);
		
		
		
	
	}

}
