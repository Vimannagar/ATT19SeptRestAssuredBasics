package specbuilders;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestAndResponseSpecBuilder {

	ResponseSpecification responseSpecification;
	RequestSpecification requestSpecification;

	@BeforeClass
	public void requestAndResponseSpecification() {
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

		requestSpecBuilder.addHeader("Content-Type", "application/json");

		requestSpecBuilder.addHeader("accept", "application/json");

		requestSpecBuilder.setBaseUri("https://petstore.swagger.io");

		requestSpecBuilder.setBasePath("v2");

		requestSpecBuilder.log(LogDetail.ALL);

		requestSpecification = requestSpecBuilder.build();

		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();

		responseSpecBuilder.expectContentType("application/json");

		responseSpecBuilder.expectStatusCode(200);

		responseSpecBuilder.log(LogDetail.ALL);

		responseSpecification = responseSpecBuilder.build();

	}

	@Test
	public void createUser() {

		Response resp = RestAssured.given(requestSpecification)

				.body("{\r\n" + "  \"id\": 0,\r\n" + "  \"username\": \"restassuredattuser\",\r\n"
						+ "  \"firstName\": \"postman\",\r\n" + "  \"lastName\": \"evening\",\r\n"
						+ "  \"email\": \"restassuredattevening@gmail.com\",\r\n" + "  \"password\": \"Test@1234\",\r\n"
						+ "  \"phone\": \"9981776655\",\r\n" + "  \"userStatus\": 0\r\n" + "}")

				.when()

				.post("user")

				.then()

				.spec(responseSpecification)

				.extract()

				.response();

	}

}
