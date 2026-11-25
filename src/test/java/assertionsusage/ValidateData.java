package assertionsusage;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;



public class ValidateData {
	
	
	@Test
	public void getAllWorkspaces()
	{
		RestAssured.baseURI = "https://api.postman.com";
		
		RestAssured.given()
		
		.header("x-api-key", "")
				
		.log().all()
		
		.when()
		
		.get("/workspaces")
		
		.then()
		
		.log().all()
		
		.statusCode(200)// to validate if the status code is 200, if it is not 200 then it will mark the test case as fail
		
		.contentType(ContentType.JSON)// validate the content type of the response
		
		.header("Server", "cloudflare")// validate the header's key and value
		
		.time(lessThan(5000l))// validate if the response is less than 5 msec
		
		.body(containsString("13295064")) // to validate if we have a string available in the response or not
		
		.body("workspaces[58].id", equalTo("88201122-a7e9-4fb7-9ca7-3b7391d28c1f")) // to validate if the path provided has a specific data or not
		
		.body("workspaces[58]", hasKey("visibility"))// to validate if we have the key available at a certain path
		
		.body("workspaces[58]", hasEntry("name", "Workspace using API4")) // to validate the complete entry available at the defined path
		
		.body("workspaces.name",contains("Team Workspace","My Workspace","ModifyingTest Workspace","ATTObjectWorkspace","Manual Workspace","Latest workspace123","ATT batch Workspace2","Test workspaceevening","ATT25JanPostmanWorkspace","RestAssured workspace","RestAssured workspace","Manually created workspace","workspace created through restassured","updated ATT morning restassured","ATT morning restassured post request","workspacecreated using postman","ATT20JanWorkspace","UpdatedworkspaceATT20Jan","ATT20RestAssuredWorkspace","ATT20JanWorkspace3","latestFeb23RestAssuredWorkspace","modified workspace name ATT 6Apr","Restassured workspace 29 May","ATT11MayWorkspace by RestAssured","ATT11MayWorkspace by RestAssured","ATT11MayWorkspace by RestAssured","Updated ATT11MayWorkspaceLatest by Code","Restassured workspace 29 May","ATT13July workspace","ATT13JulyWorkspace Postman","ATT13JulyWorkspace-RestAssured","Manualtestingworkspacecreation","ATT28SeptWorkspace","ATT28SeptWorkspaceMorning","ATT28SeptWorkspaceMorningByRestAssured","ATT28SeptWorkspaceMorningByRestAssured","New Workspace created manually","New Workspace created manually","Workspace Two","19thMarchWorkspace","19th March postman workspace","ATT29MarchWorkspace-manual_UPDATED","ATT29March Postman workspace","ATT29March Postman workspace1_updatedat2145","ATT29March Postman workspace2","ATT29March Postman workspace3","ATT29March restassured workspace","test att14 workspace","ATT 14 june postman workspace","ATT 14 - 2 june postman workspace","ATT 14 june morning workspace","ATT 14 june evening workspace","ATT13SeptWorkspace","ATT13SeptWorkspaceUsingRestAssured","Manually created workspace","Workspace using API","Workspace using API2","Workspace using API3","Workspace using API4","Workspace using API4","RestAssured workspace Feb 5","ATT28MarchEvening","Manually created workspace on 28th May","Postman workspace using Request","Postman workspace using Request","RestAssured created workspace 29 May","ATT06JuneMorning","ATT06JunemanualWorkspace","ATT06june morning Postman workspace","ATT06june morning 22nd july","ATT06june morning workspace","ATT06june postman workspace2","ATT19SeptEvening","Manually created workspace 23 Nov","ATT19SeptPostman workspace","ATT19SeptPostman workspace2"))
//		contains method is used to validate if we have all the matching data available at the defined path if any single value gets missed or the sequence of data gets differ then it mark the testcase as failed
		
		.body("workspaces.name",containsInAnyOrder("My Workspace","Team Workspace","ModifyingTest Workspace","ATTObjectWorkspace","Manual Workspace","Latest workspace123","ATT batch Workspace2","Test workspaceevening","ATT25JanPostmanWorkspace","RestAssured workspace","RestAssured workspace","Manually created workspace","workspace created through restassured","updated ATT morning restassured","ATT morning restassured post request","workspacecreated using postman","ATT20JanWorkspace","UpdatedworkspaceATT20Jan","ATT20RestAssuredWorkspace","ATT20JanWorkspace3","latestFeb23RestAssuredWorkspace","modified workspace name ATT 6Apr","Restassured workspace 29 May","ATT11MayWorkspace by RestAssured","ATT11MayWorkspace by RestAssured","ATT11MayWorkspace by RestAssured","Updated ATT11MayWorkspaceLatest by Code","Restassured workspace 29 May","ATT13July workspace","ATT13JulyWorkspace Postman","ATT13JulyWorkspace-RestAssured","Manualtestingworkspacecreation","ATT28SeptWorkspace","ATT28SeptWorkspaceMorning","ATT28SeptWorkspaceMorningByRestAssured","ATT28SeptWorkspaceMorningByRestAssured","New Workspace created manually","New Workspace created manually","Workspace Two","19thMarchWorkspace","19th March postman workspace","ATT29MarchWorkspace-manual_UPDATED","ATT29March Postman workspace","ATT29March Postman workspace1_updatedat2145","ATT29March Postman workspace2","ATT29March Postman workspace3","ATT29March restassured workspace","test att14 workspace","ATT 14 june postman workspace","ATT 14 - 2 june postman workspace","ATT 14 june morning workspace","ATT 14 june evening workspace","ATT13SeptWorkspace","ATT13SeptWorkspaceUsingRestAssured","Manually created workspace","Workspace using API","Workspace using API2","Workspace using API3","Workspace using API4","Workspace using API4","RestAssured workspace Feb 5","ATT28MarchEvening","Manually created workspace on 28th May","Postman workspace using Request","Postman workspace using Request","RestAssured created workspace 29 May","ATT06JuneMorning","ATT06JunemanualWorkspace","ATT06june morning Postman workspace","ATT06june morning 22nd july","ATT06june morning workspace","ATT06june postman workspace2","ATT19SeptEvening","Manually created workspace 23 Nov","ATT19SeptPostman workspace","ATT19SeptPostman workspace2"))
// 		containsInAnyOrder is used to validate the data but not the sequence so that data validation is full but order is not
		
		.body("workspaces.name", hasItems("ATT batch Workspace2","Test workspaceevening")) // this method is used to validate only some of the matched values based on the path provided
		
		.body("workspaces.size()", greaterThan(30)) // to validate if the size of an array is greater than the defined value
		
		.body("workspaces[5].name", notNullValue()) // to validate if the data at the specified path is non null or not
		
		.extract()
		
		.response();
	}

}
