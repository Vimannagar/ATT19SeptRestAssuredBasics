package dataextraction;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class FetchingResponseProperties {
	
	
	@Test
	public void fetchAllUsers()
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
		
		int stsCode = resp.statusCode();// to fetch the status code of the response
		
		System.out.println("Status code is "+stsCode);
		
		String stsLine = resp.statusLine();// it fetches the status line i.e status code + message
		
		System.out.println("Status line is : "+stsLine);

		long respTime = resp.getTime();
		
		System.out.println(respTime);// fetch the response time it takes to get the output
		
		
		long responseTimeInSeconds = resp.timeIn(TimeUnit.SECONDS);
		
		System.out.println(responseTimeInSeconds);
		
		Headers allHeaderFromResponse = resp.headers();// fetches all header values from the response
		
		System.out.println(allHeaderFromResponse);
		
		for(Header header :allHeaderFromResponse)
		{
			System.out.println(header);
		}
		
		String refPolicy = resp.getHeader("Referrer-Policy");// get the value to the corresponding key of header
		
		System.out.println(refPolicy);
		
		
		 ResponseBody bodyOfResp = resp.getBody();// to fetch the response body from response
		 
		String strResponseBody =  bodyOfResp.asPrettyString();
		
		
		System.out.println(strResponseBody);
		
		
		
		
	}

}
