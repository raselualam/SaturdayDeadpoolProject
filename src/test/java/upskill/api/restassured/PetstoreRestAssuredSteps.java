package upskill.api.restassured;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.File;

public class PetstoreRestAssuredSteps {

	@Given("^Create pet$")
	public void create_pet() throws Throwable {
		
		given().														//Request Payload
			body(new File(System.getProperty("user.dir") 
				+ "/src/test/resource/ApiRequestPayloads/CreatePetRequest.json")).
		when().															//Setting the Header & Request url
			header("Content-Type", "application/json").
			post("https://petstore.swagger.io/v2/pet").
		then().															//Printing Response in console
			log().body().
		and().															//Verify status code
			assertThat().statusCode(200).
		and().															//Verify Response using json schema
			body(matchesJsonSchema(new File(System.getProperty("user.dir") 
				+ "/src/test/resource/ApiResponseSchemas/CreatePetResponse.json")));
	    
	}

	@Given("^Get pet$")
	public void get_pet() throws Throwable {
		
		given().														//Request Payload
		when().															//Setting the Header & Request url
			header("Content-Type", "application/json").
			get("https://petstore.swagger.io/v2/pet/4567").
		then().															//Printing Response in console
			log().body().
		and().															//Verify status code
			assertThat().statusCode(200).
		and().															//Verify Response using json schema
			body(matchesJsonSchema(new File(System.getProperty("user.dir") 
					+ "/src/test/resource/ApiResponseSchemas/GetPetResponse.json")));	    
	}

	@When("^Update pet$")
	public void update_pet() throws Throwable {
		given().														//Request Payload
			body(new File(System.getProperty("user.dir") 
				+ "/src/test/resource/ApiRequestPayloads/UpdatePetRequest.json")).
		when().															//Setting the Header & Request url
			header("Content-Type", "application/json").
			put("https://petstore.swagger.io/v2/pet").
		then().															//Printing Response in console
			log().body().
		and().															//Verify status code
			assertThat().statusCode(200).
		and().															//Verify Response using json schema
			body(matchesJsonSchema(new File(System.getProperty("user.dir") 
				+ "/src/test/resource/ApiResponseSchemas/UpdatePetResponse.json")));
	}

	@Then("^Delete pet$")
	public void delete_pet() throws Throwable {
		given().														//Request Payload
		when().															//Setting the Header & Request url
			header("Content-Type", "application/json").
			delete("https://petstore.swagger.io/v2/pet/4567").
		then().															//Printing Response in console
			log().body().
		and().															//Verify status code
			assertThat().statusCode(200).
		and().															//Verify Response using json schema
			body(matchesJsonSchema(new File(System.getProperty("user.dir") 
					+ "/src/test/resource/ApiResponseSchemas/DeletePetResponse.json")));
		
	}
}