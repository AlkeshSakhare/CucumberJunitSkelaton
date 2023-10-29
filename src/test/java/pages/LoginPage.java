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
			usernameTxt.sendKeys(username);
			passwordTxt.sendKeys(password);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickOnLoginBtn() {
		try {
			loginBtn.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public LoginPage() {
		PageFactory.initElements(driver, this);
		// PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);

	}
}
