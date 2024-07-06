package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.PetPojoClass;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.Assert;

public class Post_PetImage_WithID_APITest {
	 Response response;
	 PetPojoClass pg2 = new PetPojoClass();
@Given("valid endpoints to add a image to existing pet or create new pet if pet id is not present")
public void valid_endpoints_to_add_a_image_to_existing_pet_or_create_new_pet_if_pet_id_is_not_present() {
    basePath = "pet/176/uploadImage";
}

@Given("valid pet data for image and additional meta data is available in required format")
public void valid_pet_data_for_image_and_additional_meta_data_is_available_in_required_format() {
   
    pg2.setAdditionalMetadata("This Pet is so cute Find the image");
    File image = new File("C:\\Users\\BSR\\OneDrive\\Desktop\\RestTesting\\PetStoreAssignmentL3\\resources\\imageupload.png");
    pg2.setFile(image);
}

@When("post request is sent to server with image data")
public void post_request_is_sent_to_server_with_image_data() {
	 response =given().
			 		header("api-key", "special-key").
			 		contentType("multipart/form-data").
			 		multiPart(pg2.getFile()).
			 		multiPart("additionalMetadata", pg2.getAdditionalMetadata()).
			   when().
			   		post();
}

@Then("Validate response metadata value matching with input data")
public void validate_response_metadata_value_matching_with_input_data() {
	//String additional_Information = response.jsonPath().getString("additionalMetadata");
	//Assert.assertEquals(additional_Information, pg2.getAdditionalMetadata());
	System.out.println(response.getBody().asPrettyString());
	Assert.assertTrue(response.getBody().asString().contains(pg2.getAdditionalMetadata()));
  
}

@Then("Validate the status code to be {string}  in post pet image details")
public void validate_the_status_code_to_be_in_post_pet_image_details(String string) {
   int actualstatus = response.getStatusCode();
   Assert.assertEquals(actualstatus, Integer.parseInt(string));
}

@Then("Validate the content type as {string} in post image details")
public void validate_the_content_type_as_in_post_image_details(String string) {
    String actual_content_type = response.getContentType();
    Assert.assertEquals(actual_content_type, string);
}


}
