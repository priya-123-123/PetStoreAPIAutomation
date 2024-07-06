package stepDefinition;

import io.cucumber.java.en.Given;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BackGroundTest {
	
	@Given("valid base url is defined")
	public void valid_base_url_is_defined() {
		baseURI = "https://petstore.swagger.io/v2";
	    
	}

}
