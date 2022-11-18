package stepDefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testBase.TestBase;

public class Hooks {
	TestBase base;
	WebDriver driver;

	@Before
	public void setUp() {
		base = new TestBase();
		base.initialization();
		this.driver = TestBase.driver;
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) {

		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "image");

	}

	@After
	public void tearDown() {
		driver.quit();
	}

	// @AfterStep if need to attached screenshot for failed testcases
	public void addScreenshot1(Scenario scenario) {

		// validate if scenario has failed
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image");
		}

	}
}
