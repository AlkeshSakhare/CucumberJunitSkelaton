package testBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paulhammant.ngwebdriver.NgWebDriver;

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
	public static NgWebDriver ngWebDriver;
	public static Logger log;
	public static int IMPLICIT_WAIT;
	public static int PAGE_LOAD_TIMEOUT;
	public static int webDriverWait;
	public static String userdir = System.getProperty("user.dir");

	public TestBase() {
		try {
			properties = new Properties();
			log = Logger.getLogger(this.getClass());
			properties.load(new FileReader(userdir + "/src/test/resources/config/config.properties"));
			PropertyConfigurator.configure(userdir + "/src/test/resources/config/log4j.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialization() {
		System.out.println("im called");
		browser = properties.getProperty("browser");
		IMPLICIT_WAIT = Integer.parseInt(properties.getProperty("IMPLICIT_WAIT"));
		PAGE_LOAD_TIMEOUT = Integer.parseInt(properties.getProperty("PAGE_LOAD_TIMEOUT"));
		webDriverWait = Integer.parseInt(properties.getProperty("WEBDRIVER_WAIT"));
		url = properties.getProperty("url");
		username = properties.getProperty("USERNAME");
		password = properties.getProperty("PASSWORD");

		switch (browser) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		case "edgeChromium":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "chromeHeadless":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			// OR
			// options.setHeadless(true);
			driver = new ChromeDriver(options);
			break;

		case "firefoxHeadless":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions foption = new FirefoxOptions();
			foption.setHeadless(true);
			driver = new FirefoxDriver(foption);
			break;
		}
		wait = new WebDriverWait(driver, webDriverWait);
		js = (JavascriptExecutor) driver;
		ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
		action = new Actions(driver);

		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(url);
	}
}
