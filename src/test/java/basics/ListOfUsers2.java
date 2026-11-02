package basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ListOfUsers2 {

	
	@Test
	public void fetchAllUsers() {
		RestAssured.baseURI = "https://reqres.in";

		Response resp = RestAssured.given()

				.when()

				.get("api/users?page=2");

		String stringResponse = resp.asPrettyString();

		System.out.println(stringResponse);

	}

}
