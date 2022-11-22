package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import testBase.TestBase;

public class LoginStepDef extends TestBase {
	public static LoginPage loginPage;

	@Given("User is on login page")
	public void user_is_on_login_page() {
		loginPage = new LoginPage();

	}

	@When("User enters login credentials")
	public void user_enters_login_credentials() {
		loginPage.enterCredentials(username, password);
	}

	@Then("User login to application")
	public void user_login_to_application() {
		System.out.println(driver.getTitle());
	}

}
