package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.CategoryPOJO;
import pojo.PetPojoClass;
import pojo.TagsPOJO;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Post_PetDetails_APITest {
	
	Response response;
	PetPojoClass petData;
	String json;
	
	@Given("valid endpoints to add a new pet")
	public void valid_endpoints_to_add_a_new_pet() {
	   basePath = "/pet";
	}

	@Given("header key is known for authentication")
	public void header_key_is_known_for_authentication() {
	}

	@Given("valid pet data available in required format")
	public void valid_pet_data_available_in_required_format() {
		CategoryPOJO cp= new CategoryPOJO(1109,"Hound");
		TagsPOJO tp1 = new TagsPOJO(119,"Jhony");
		ArrayList<TagsPOJO> tparray = new ArrayList<TagsPOJO>();
		tparray.add(tp1);
		String[] photoarray = {"https://"};
		
		
		petData = new PetPojoClass(176, cp, "doogie1", photoarray, tparray, "available");
		ObjectMapper mapper = new ObjectMapper();
        try {
			json = mapper.writeValueAsString(petData);
			System.out.println(json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}

	@When("post request is sent to server with data")
	public void post_request_is_sent_to_server_with_data() {
		 response =given().accept(ContentType.JSON)
				 .contentType(ContentType.JSON).
		    header("api-key", "special-key").
		    body(petData).
		  when().
		    post();
		    
	}

	@Then("Validate the status code to be {string}")
	public void validate_the_status_code_to_be(String status) {
	    Assert.assertEquals(response.getStatusCode(), Integer.parseInt(status));
	}

	@Then("Validate the content type as {string}")
	public void validate_the_content_type_as(String contenttype) {
	    Assert.assertEquals(response.getContentType(),contenttype );
	}

	
	  @Then("Validate response values matching with input data") public void
	  validate_response_values_matching_with_input_data() {
	  Assert.assertEquals(response.jsonPath().getString("category.name"), "Hound");
	  }
	 

}
