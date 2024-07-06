package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class Delete_PET_By_ID_Test {
	RequestSpecification reqspec;
	Response response;
	@Given("valid endpoints to delete  pet details")
	public void valid_endpoints_to_delete_pet_details() {
	    basePath = "/pet/176";
	    
	    
	}

	@Given("Authorisation is added in header for deleting pet")
	public void authorisation_is_added_in_header_for_deleting_pet() {
	    reqspec = given().header("api-key","special-key");
	}

	@When("Delete request is sent to server")
	public void delete_request_is_sent_to_server() {
		response = reqspec.delete();
	    
	}

	@Then("Element should be successfully deleted from the server with status code as {string}")
	public void element_should_be_successfully_deleted_from_the_server_with_status_code_as(String string) {
	  Assert.assertEquals(response.getStatusCode(), Integer.parseInt(string));
	}

	@Then("Validate the content type as {string} in delete response")
	public void validate_the_content_type_as_in_delete_response(String string) {
	   
	    Assert.assertEquals(response.getContentType(), string);
	}

	@Then("Validate response content")
	public void validate_response_content() {
	    System.out.println(response.getBody());
	}

}
