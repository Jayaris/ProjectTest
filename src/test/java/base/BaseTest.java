package base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties properties = new Properties();
	public static Properties locators = new Properties();
	public static String baseUrl;
	public static FileReader frConfig;
	public static FileReader frLocators;
	public static FluentWait<WebDriver> wait;
	public static String username;
	public static String password;
	
	public static void WaitForVisible(By by) {
	    wait.withTimeout(Duration.ofSeconds(10));
	    wait.pollingEvery(Duration.ofSeconds(1));
	    wait.ignoring(NoSuchElementException.class);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	  }
	
	public static void WaitForClickable(By by) {
		System.out.println("hi");
		
	    wait.withTimeout(Duration.ofSeconds(10));
	    wait.pollingEvery(Duration.ofSeconds(2));
	    wait.ignoring(ElementNotInteractableException.class, NoSuchElementException.class);
	    wait.until(ExpectedConditions.elementToBeClickable(by));
	  }
	
	public static void LogIn(String user, String pass) {
	    username = user;
	    password = pass;
		driver.get(baseUrl);
	    driver.findElement(By.id(locators.getProperty("usernameField"))).sendKeys(user);
	    driver.findElement(By.id(locators.getProperty("passwordField"))).sendKeys(pass);
	    driver.findElement(By.name(locators.getProperty("loginButton"))).click();
}
	
	

	@BeforeTest
	public void setUp() throws IOException {
		if(driver==null) {
			FileReader frConfig = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
			properties.load(frConfig);
			FileReader frLocators = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\locators\\SignIn.properties");
			locators.load(frLocators);
		}
		//Sets the environment url from the config file
		baseUrl = properties.getProperty("baseUrl");
		
		//Sets the browser driver from the config file
		if(properties.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			wait = new FluentWait(driver);
			driver.manage().window().setSize(new Dimension(1920, 1080));
		}
		else if (properties.getProperty("browser").equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			wait = new FluentWait(driver);
			driver.manage().window().maximize();
		}
	}
			
			
	@AfterTest
	public void tearDown(){
		driver.close();
		System.out.println("WebDriver closed.");
	}
}


