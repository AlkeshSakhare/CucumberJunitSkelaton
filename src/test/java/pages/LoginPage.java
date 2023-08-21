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
		try {
			log.info(username);
			usernameTxt.sendKeys(username);
			Thread.sleep(1000);
			passwordTxt.sendKeys(password);
			Thread.sleep(2000);
			loginBtn.click();
			log.info(username + " is logged in successfully");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public LoginPage() {
		PageFactory.initElements(driver, this);
		// PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);

	}
}
