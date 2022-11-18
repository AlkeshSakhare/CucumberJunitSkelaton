package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class LoginPage extends TestBase {

	@FindBy(name = "username")
	WebElement usernameTxt;

	@FindBy(name = "password")
	WebElement passwordTxt;

	@FindBy(css = "[value='Login']")
	WebElement loginBtn;

	public void enterCredentials(String username, String password) {
		System.out.println(username);
		usernameTxt.sendKeys(username);
		passwordTxt.sendKeys(password);
		loginBtn.click();
	}

	public LoginPage() {
		PageFactory.initElements(driver, this);
		// PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);

	}
}
