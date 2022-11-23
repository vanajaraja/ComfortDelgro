package org.stepdefinition;

import java.util.List;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.test.api.baseclass.BaseClass;
import org.test.api.payloads.CreatePostPayLoad;
import org.test.api.payloads.SignInPayLoad;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreatePostTestcases extends BaseClass {
	private static final String BASE_URI = "https://api.realworld.io";
	private static RequestSpecification request;
	private static Response response;
	private static Response createPostResponse;
	private static RequestSpecification createPostRequest;
	private static String token;

	@Given("Sending the signin post request with {string} and {string}")
	public void sending_the_signin_post_request_with_and(String email, String password) {
		email = getDataFromConfigPropertyFile("email");
		password =getDataFromConfigPropertyFile("password");
		RestAssured.baseURI = BASE_URI;
		response = RestAssured.given().header("Content-Type", "application/json")
				.body(SignInPayLoad.signIn(email, password)).when().post("/api/users/login");
		logger.info("Signin payload : " + SignInPayLoad.signIn(email, password));
	}

	@Given("Get token from signin response")
	public void get_token_from_signin_response() throws Exception {
		logger.info(" Signin Response : " + getResp(response));
		token = getStringvalue(getResp(response),"user", "token");
		
	}

	@Given("Sending the create post payload with token")
	public void sending_the_create_post_payload_with_token(io.cucumber.datatable.DataTable dataTable) {
		int num = serialNumtoAppendemailID();
		List<String> asList = dataTable.asList();
		RestAssured.baseURI = BASE_URI;
		createPostRequest = RestAssured.given().header("Content-Type", "application/json").auth().oauth2(token)
				.body(CreatePostPayLoad.createPost(asList.get(0),asList.get(1),asList.get(2),asList.get(3),num));
		logger.info("Create Post Payload : " + CreatePostPayLoad.createPost(asList.get(0),asList.get(1),asList.get(2),asList.get(3),num));
	}

	@When("create a new post with post request")
	public void create_a_new_post_with_post_request() {
		createPostResponse = createPostRequest.when().post("/api/articles");

	}

	@Then("Should get proper create post response")
	public void should_get_proper_create_post_response() {
		String getResp = getResp(createPostResponse);
		logger.info("Create Post Response : " + getResp);

	}

	@Then("Create Post Status code should be {int}")
	public void create_post_status_code_should_be(int statusCode) {
		Assert.assertEquals(statusCode, statusCode(createPostResponse));
		logger.info("Assertion done on Status Code: " + statusCode(response));

	}

}
