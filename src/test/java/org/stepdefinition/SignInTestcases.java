package org.stepdefinition;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.test.api.baseclass.BaseClass;
import org.test.api.payloads.SignInPayLoad;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SignInTestcases extends BaseClass{
	
	private static final String BASE_URI = "https://api.realworld.io";
	private static RequestSpecification request;
	private static Response response;

	
	@Given("Sending the signin payload with {string} and {string}")
	public void sending_the_signin_payload_with_and(String email, String password) {
	   
		RestAssured.baseURI = BASE_URI;
		request = RestAssured.given().header("Content-Type", "application/json")
				.body(SignInPayLoad.signIn(email, password));
	}

	
	@When("signin with post request")
	public void signin_with_post_request() {
		response = request.when().post("/api/users/login");
	}
	
	@Then("Should get proper signin response")
	public void should_get_proper_signin_response() throws ParseException {

		String getResp = getResp(response);
		System.out.println(getResp);
		//getStringvalue(getResp, "errors");

	}
	
	@Then("Status code should be {int}")
	public void status_code_should_be(int statusCode) {
		Assert.assertEquals(statusCode, statusCode(response));
	}
	
	


}
