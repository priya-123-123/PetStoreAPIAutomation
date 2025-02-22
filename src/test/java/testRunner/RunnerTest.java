package testRunner;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;



@CucumberOptions(features = {"src/test/java/resources"},
	glue = {"stepDefinition"},monochrome = true,
    dryRun = false, tags="@smoke or @sanity or @delete",
    plugin = {
          "json:build/cucumber-reports/cucumber.json",
          "rerun:build/cucumber-reports/rerun.txt",
          "html:build/cucumber-reports/cucmberhtml.html"
    })

public class RunnerTest extends AbstractTestNGCucumberTests {
	

}
