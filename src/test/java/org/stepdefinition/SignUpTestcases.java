package org.stepdefinition;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Properties;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.test.api.baseclass.BaseClass;
import org.test.api.payloads.SignUpPayLoad;

import com.google.j2objc.annotations.Property;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SignUpTestcases extends BaseClass {
	private static final String BASE_URI = "https://api.realworld.io";
	private static RequestSpecification request;
	private static Response response;

	@Given("Sending the signup payload")
	public void sending_the_signup_payload() throws ParseException, Exception {
		RestAssured.baseURI = BASE_URI;
		int num = serialNumtoAppendemailID();
		request = RestAssured.given().header("Content-Type", "application/json").body(SignUpPayLoad.signUPUser(num));
		logger.info("SignUp Payload : " + SignUpPayLoad.signUPUser(num));
	}

	@When("create user with post request")
	public void create_user_with_post_request() {
		response = request.when().post("/api/users");
	}

	@Then("Should get proper response")
	public void should_get_proper_response() throws ParseException {

		String getResp = getResp(response);
		logger.info("Signup Response : " + getResp);
	}

	@Then("Signup Status code should be {int}")
	public void signup_status_code_should_be(int statusCode) {
		Assert.assertEquals(statusCode, statusCode(response));
		logger.info("Assertion done on Status Code: " + statusCode(response));
	}

	@Given("Sending the signup payload with {string},{string} and {string}")
	public void sending_the_signup_payload_with_and(String username, String email, String password) {
		RestAssured.baseURI = BASE_URI;
		request = RestAssured.given().header("Content-Type", "application/json")
				.body(SignUpPayLoad.signUpUserInvalidData(username, email, password));
		logger.info("SignUp Payload : " + SignUpPayLoad.signUpUserInvalidData(username, email, password));

	}

	@Then("error message should be {string} based on the inputs {string},{string} and {string}")
	public void error_message_should_be_based_on_the_inputs_and(String expectedMessage, String username, String email,
			String password) throws ParseException {
		String actualMessage = null;
		System.out.println("test data" + email + username + password);
		if (email.isEmpty()) {
			actualMessage = getStringValueFromJsonArray(getResp(response), "errors", "email");
			Assert.assertEquals(expectedMessage, actualMessage);
		} else if (username.isEmpty()) {
			actualMessage = getStringValueFromJsonArray(getResp(response), "errors", "username");
			Assert.assertEquals(expectedMessage, actualMessage);
		} else if (password.isEmpty()) {
			actualMessage = getStringValueFromJsonArray(getResp(response), "errors", "password");
			Assert.assertEquals(expectedMessage, actualMessage);
		} else {
			String[] expectedSplitMessage = expectedMessage.split(",");
			if (expectedSplitMessage.length > 1) {

				actualMessage = getStringValueFromJsonArray(getResp(response), "errors", "username");
				Assert.assertEquals(expectedSplitMessage[0], actualMessage);

				actualMessage = getStringValueFromJsonArray(getResp(response), "errors", "email");
				String expectedMessage1 = expectedSplitMessage[1].replace(",", "");
				Assert.assertEquals(expectedMessage1, actualMessage);
			}
		}
		logger.info("Assertion done on Error message: " );
		logger.info("Actual error message: " + actualMessage);
		logger.info("Expected error messgae: " + expectedMessage);
		
	}
}
