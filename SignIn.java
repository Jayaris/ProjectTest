package main;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class SignIn extends BaseTest {
	/*@@Test
	public static void Failure() {
		driver.get(baseUrl);
	    driver.findElement(By.id(locators.getProperty("usernameField"))).sendKeys("system.admin");
	    driver.findElement(By.id(locators.getProperty("passwordField"))).sendKeys("incorrect");
	    driver.findElement(By.name(locators.getProperty("loginButton"))).click();
	    Assert.assertEquals(driver.findElement(By.cssSelector("strong:nth-child(1)")).getText(),("Sign in failed"));
	}

	@Test
	public static void Success() {
		driver.get(baseUrl);
	    driver.findElement(By.id(locators.getProperty("usernameField"))).sendKeys("system.admin");
	    driver.findElement(By.id(locators.getProperty("passwordField"))).sendKeys("password");
	    driver.findElement(By.name(locators.getProperty("loginButton"))).click();
	}
	
	Test
	public static void AddExternal() {
		driver.get(baseUrl);
	    driver.findElement(By.id(locators.getProperty("usernameField"))).sendKeys("system.admin");
	    driver.findElement(By.id(locators.getProperty("passwordField"))).sendKeys("password");
	    driver.findElement(By.name(locators.getProperty("loginButton"))).click();
		driver.get("https://rd.spencer.org.uk/sysadmin/addperson.php?unique=1650562777");
	    driver.findElement(By.id("branchOfficeDD")).click();
	    new Select(driver.findElement(By.id("branchOfficeDD"))).selectByVisibleText("Manchester");
	    driver.findElement(By.id("firstname")).click();
	    driver.findElement(By.id("firstname")).clear();
	    driver.findElement(By.id("firstname")).sendKeys("User");
	    driver.findElement(By.id("lastname")).clear();
	    driver.findElement(By.id("lastname")).sendKeys("Name");
	    driver.findElement(By.xpath("//fieldset[@id='personalDetailsFS']/table/tbody/tr[5]/td[4]")).click();
	    driver.findElement(By.id("savePerson")).click();
	    driver.get("https://rd.spencer.org.uk/home.php");
	}*/
	
	
}
