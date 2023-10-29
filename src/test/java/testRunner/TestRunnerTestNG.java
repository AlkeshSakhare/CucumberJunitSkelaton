package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/Features",
		glue = "stepDefinition",
		dryRun = false,
		monochrome = true, 
		plugin = {"pretty", 
				"html:target/testng/html/reports.html",
			    "json:target/testng/json/reports.json", 
				"rerun:target/testng/xml/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }
		)

public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
	
	 @Override
	    @DataProvider(parallel = false)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }
	
}

/*https://qaautomation.expert/2021/06/22/integration-of-cucumber-with-selenium-and-testng/*/