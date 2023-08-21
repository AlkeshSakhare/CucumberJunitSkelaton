package testBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static String browser;
	public static String url;
	public static String username;
	public static String password;
	public static Properties properties;
	public static WebDriver driver;
	public static Actions action;
	public static WebDriverWait wait;
	public static JavascriptExecutor js;
	public static Logger log;
	public static int IMPLICIT_WAIT;
	public static int webDriverWait;
	public static String userdir = System.getProperty("user.dir");

	public TestBase() {
		try {
			properties = new Properties();
			log = LogManager.getLogger();
			properties.load(new FileReader(userdir + "/src/test/resources/config/config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialization() {
		browser = properties.getProperty("browser");
		IMPLICIT_WAIT = Integer.parseInt(properties.getProperty("IMPLICIT_WAIT"));
		webDriverWait = Integer.parseInt(properties.getProperty("WEBDRIVER_WAIT"));
		url = properties.getProperty("url");
		username = properties.getProperty("USERNAME");
		password = properties.getProperty("PASSWORD");

		switch (browser) {

		case "chrome":
			/* Set system property */
			// System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

			/* WebDriverManager */
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			/* Set system property */
			// System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");

			/* WebDriverManager */
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "edge":
			/* Set system property */
			// System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");

			/* WebDriverManager */
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		}
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(webDriverWait));
		js = (JavascriptExecutor) driver;
		action = new Actions(driver);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
		driver.get(url);
	}
}
