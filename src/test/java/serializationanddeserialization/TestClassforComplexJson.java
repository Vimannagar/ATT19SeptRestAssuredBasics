package serializationanddeserialization;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import complexpojo.Batter;
import complexpojo.Batters;
import complexpojo.ComplexJsonRequestBody;
import complexpojo.Topping;

public class TestClassforComplexJson {

	@Test
	public void sendingComplexData() {
		ComplexJsonRequestBody mainObj = new ComplexJsonRequestBody();

		mainObj.setId("0001");
		mainObj.setType("donut");
		mainObj.setName("Cake");
		mainObj.setPpu(0.55);

		Batter ele1 = new Batter();

		ele1.setId("1001");
		ele1.setType("Regular");

		Batter ele2 = new Batter();

		Integer[] ele = new Integer[2];

		ele[0] = 5;
		ele[1] = 9;

		ele2.setId(ele);
		ele2.setType("Chocolate");

		Batters battersObj = mainObj.getBatters();

		List<Batter> batterObj = battersObj.getBatter();

		batterObj.add(ele1);
		batterObj.add(ele2);

		Topping zerothElement = new Topping();

		zerothElement.setId("5001");
		zerothElement.setType("None");

		Topping firstElement = new Topping();

		firstElement.setId("5002");
		firstElement.setType("Glazed");
		
		Topping secondElement = new Topping();

		secondElement.setId("5005");
		secondElement.setType("Sugar");
		
		
		List<Topping> listOfTopping = mainObj.getTopping();
		
		listOfTopping.add(zerothElement);
		listOfTopping.add(firstElement);
		listOfTopping.add(secondElement);
		
		
		
		baseURI = "https://40cabe32-8d51-48d1-a34c-2b04134b2540.mock.pstmn.io";

		given()

				.header("Content-Type", "application/json")

				.header("x-mock-match-request-body", "true")

				.body(mainObj)

				.log().all()

				.when()

				.post("/complexdata")

				.then()

				.log().all()

				.extract()

				.response();

	}

}
