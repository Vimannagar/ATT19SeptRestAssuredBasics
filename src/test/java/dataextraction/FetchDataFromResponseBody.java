package dataextraction;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FetchDataFromResponseBody {
	
	
	@Test
	public void fetchResponseBodyData()
	{
		baseURI = "https://reqres.in";

		Response resp = given()

				.when()

				.get("api/users?page=2")
				
				.then()
				
				.extract()
				
				.response();

		String stringResponse = resp.asPrettyString();

		System.out.println(stringResponse);
		
		
		JsonPath jp = resp.jsonPath();
		
		int totalValue = jp.getInt("total");
		
		System.out.println(totalValue +" is the value of total");
		
		
		String strData = jp.getString("support.url");
		
		
		System.out.println(strData);
		
		
		String value = jp.getString("_meta.cta.url");
		
		System.out.println("Valie of url is :"+value);
		
		
		// read the data from array:
		
		String emailOfSecondIndex = jp.getString("data[2].email");
		
		System.out.println(emailOfSecondIndex);
		
		
		
		
		//Assignment: WAP to find the email address of the user whose last name is “Edwards”
		
		for(int i=0; i<6; i++)
		{
			String lastNameOfUser = jp.getString("data["+i+"].last_name");
			
			if(lastNameOfUser.equals("Edwards"))
			{
				String emailValue = jp.getString("data["+i+"].email");
				
				System.out.println("Email address is "+emailValue);
				
				break;
			}
			
		}
		
		
		int sizeOfAnArray = jp.getInt("data.size()");
		
		System.out.println("Size of an array is : "+ sizeOfAnArray);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
