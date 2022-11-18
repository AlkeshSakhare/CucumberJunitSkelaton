package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features",
		glue = "stepDefinition",
		dryRun = false,
		monochrome = true, 
		plugin = {"pretty", 
				"json:target/cucumber.json",
				"html:target/junit/html/reports.html",
			    "json:target/junit/json/reports.json", 
				"junit:target/junit/xml/reports.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }
		)

public class TestRunner {

}
