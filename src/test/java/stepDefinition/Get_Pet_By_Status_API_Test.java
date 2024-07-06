package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class Get_Pet_By_Status_API_Test {
	Response response;
	
	@Given("valid endpoints to find pet details using status")
	public void valid_endpoints_to_find_pet_details_using_status() {
		basePath = "/pet/findByStatus";
	    
	}

	@When("get request is sent to server with status")
	public void get_request_is_sent_to_server_with_status() {
		response = given().header("api-key", "special-key").queryParam("status", "available,sold").
	               when().
		           get();
		
	}

	@Then("Validate the status code to be {string} for get pet details by status")
	public void validate_the_status_code_to_be_for_get_pet_details_by_status(String string) {
	    Assert.assertEquals(response.getStatusCode(), Integer.parseInt(string));
	}

	@Then("Validate the content type as {string} for get pet details by status")
	public void validate_the_content_type_as_for_get_pet_details_by_status(String string) {
	    Assert.assertEquals(response.getContentType(), string);
	}

	@Then("Validate response values matching with expected status")
	public void validate_response_values_matching_with_expected_status() {
		Assert.assertTrue(response.jsonPath().getList("status").contains("available"));
		Assert.assertTrue(response.jsonPath().getList("status").contains("sold"));
	   
	}


}
