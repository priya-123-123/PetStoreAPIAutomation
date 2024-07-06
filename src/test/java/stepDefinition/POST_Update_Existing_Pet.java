package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class POST_Update_Existing_Pet {
	RequestSpecification reqspec;
	Response response;
	
	
	@Given("valid end points to update pet status and name")
	public void valid_end_points_to_update_pet_status_and_name() {
		
		basePath = "/pet/176";
	    
	}

	@Given("Valid pet data is available to update pet name and status")
	public void valid_pet_data_is_available_to_update_pet_name_and_status() {
		reqspec=
		given().
		header("api-key","special-key") .
		config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig().
				encodeContentTypeAs("x-www-form-urlencoded",ContentType.URLENC))).
		contentType(ContentType.URLENC.withCharset("UTF-8")).
		formParam("petId", "111").
		formParam("name", "Jhony").
		formParam("status", "available");
	    
	}

	@When("Post request is sent to the server")
	public void post_request_is_sent_to_the_server() {
		response=reqspec.post();
	    
	}

	@Then("Validate the status code to be {string} for post update request")
	public void validate_the_status_code_to_be_for_post_update_request(String string) {
	    Assert.assertEquals(response.getStatusCode(), Integer.parseInt(string));
	}

	@Then("Validate the content type as {string} in post update request")
	public void validate_the_content_type_as_in_post_update_request(String string) {
		 String actual_content_type = response.getContentType();
		 Assert.assertEquals(actual_content_type, string);
	}

	@Then("Validate response metadata value matching with input data in post update request")
	public void validate_response_metadata_value_matching_with_input_data_in_post_update_request() {
	    Assert.assertEquals(response.jsonPath().getInt("message"), 176);
	}


}
