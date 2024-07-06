package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class Get_Pet_By_Id_API_Test {
	
	Response response;
	
	@Given("valid endpoints to get pet details using id")
	public void valid_endpoints_to_get_pet_details_using_id() {
		basePath="/pet/176";
	   
	}

	@When("get request is sent to server with id")
	public void get_request_is_sent_to_server_with_id() {
		response = given().header("api-key", "special-key").
	               when().
		           get();
		response.getStatusCode();
		
	    
	}
	
	@Then("Validate the status code to be {string} for get pet details")
	public void validate_the_status_code_to_be_for_get_pet_details(String status) {
		Assert.assertEquals(response.getStatusCode(), Integer.parseInt(status));
	}

	@Then("Validate the content type as {string} for get pet details")
	public void validate_the_content_type_as_for_get_pet_details(String string) {
	    Assert.assertEquals(response.getContentType(), string);
	}

	@Then("Validate response values matching with expected data")
	public void validate_response_values_matching_with_expected_data() {
	    Assert.assertEquals(response.jsonPath().getInt("id"), 176);
	}

}
