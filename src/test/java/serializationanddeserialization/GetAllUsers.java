package serializationanddeserialization;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import pojo.Data;
import pojo.GetAllUsersResponseBody;

public class GetAllUsers {

	@Test
	public void fetchAllUsers() {
		RestAssured.baseURI = "https://reqres.in";

		Response resp = RestAssured.given()

				.log().all()

				.when()

				.get("api/users?page=2")

				.then()

				.log().all()

				.extract()

				.response();

		GetAllUsersResponseBody responseObject = resp.as(GetAllUsersResponseBody.class);

		Integer totalPagesValue = responseObject.getTotal_pages();

		System.out.println("Total pages value is : " + totalPagesValue);// 2

		List<Data> dataObject = responseObject.getData();

		Data secondIndexPosition = dataObject.get(2);

		String firstNameValue = secondIndexPosition.getFirst_name();

		System.out.println(firstNameValue);
	

// WAP to get the value of lastname whose id is 11
		
		for(Data dataObj :dataObject)
		{
			int idValue = dataObj.getId();
			
			if(idValue == 11)
			{
				String lastNameValue = dataObj.getLast_name();
				System.out.println(lastNameValue);
			}
		}
			
		
		
		
		

	}

}
