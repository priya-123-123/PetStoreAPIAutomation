package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.CategoryPOJO;
import pojo.PetPojoClass;
import pojo.TagsPOJO;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import org.testng.Assert;

public class Put_Update_Existing_PET {
	PetPojoClass pg;
	RequestSpecification reqspec;
	Response response;
	
	@Given("valid endpoints to update pet details")
	public void valid_endpoints_to_update_pet_details() {
	   basePath="/pet";
	}

	@Given("Authorisation is added in header")
	public void authorisation_is_added_in_header() {
		reqspec= given().header("api-key","special-key").contentType(ContentType.JSON);
	}

	@Given("valid pet data is available to update")
	public void valid_pet_data_is_available_to_update() {
		CategoryPOJO cp= new CategoryPOJO(1188,"Hound2");
		TagsPOJO tp1 = new TagsPOJO(120,"hound7");
		ArrayList<TagsPOJO> tparray = new ArrayList<TagsPOJO>();
		tparray.add(tp1);
		String[] photoarray = {"https://image.in"};
		pg=new PetPojoClass(176, cp, "doogie2", photoarray, tparray, "pending");
	}

	@When("Put request is sent to the server")
	public void put_request_is_sent_to_the_server() {
		response = reqspec.body(pg).put();
	   
	}

	@Then("Validate the status code to be {string} for put update request")
	public void validate_the_status_code_to_be_for_put_update_request(String status) {
	    Assert.assertEquals(response.getStatusCode(), Integer.parseInt(status));
	}

	@Then("Validate the content type as {string} in put request")
	public void validate_the_content_type_as_in_put_request(String contenttype) {
	    Assert.assertEquals(response.getContentType(), contenttype);
	}

	@Then("Validate response metadata value matching with input data in put request")
	public void validate_response_metadata_value_matching_with_input_data_in_put_request() {
	    PetPojoClass pg1= response.as(PetPojoClass.class);
	    Assert.assertTrue(pg1.equals(pg));
	    
	   
	}

	
}
