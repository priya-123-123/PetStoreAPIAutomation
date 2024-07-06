package testRunner;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/java/FeatureFile",
	glue = {"stepDefinition"},monochrome = false,
    dryRun = false, tags="@smoke or @sanity or @delete",
    plugin = {
          "json:build/cucumber-reports/cucumber.json",
          "rerun:build/cucumber-reports/rerun.txt"
    })

public class Runner extends AbstractTestNGCucumberTests {
	

}
