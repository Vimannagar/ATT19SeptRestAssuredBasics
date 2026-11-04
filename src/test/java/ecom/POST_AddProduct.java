package ecom;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class POST_AddProduct extends BaseData
{
	@Test
	public void loginToApp()
	{
		
		String path = System.getProperty("user.dir")+"\\src\\test\\resources\\Trouser_Women.png";
		
		File file = new File(path);

		baseURI = "https://rahulshettyacademy.com";
		
	Response resp = given()
		
		.param("productName", "Jeans")
		
		.param("productAddedBy", userId)
		
		.param("productCategory", "Fashion")
		
		.param("productSubCategory", "long trouser")
		
		.param("productPrice", "1200")
		
		.param("productDescription", "Casual Trouser")
		
		.param("productFor", "Women")
		
		.multiPart("productImage",file)
		
		.header("Authorization", tokenValue)
		
		.when()
		
		.post("api/ecom/product/add-product")
		
		.then()
		
		.extract()
		
		.response();
	
	
	System.out.println(resp.asPrettyString());
	
	
	JsonPath jp = resp.jsonPath();
	
	 productId = jp.getString("productId");
	
	System.out.println(productId);
		}

}
