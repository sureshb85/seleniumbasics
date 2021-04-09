package seleniumtestng.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import seleniumbasics.Browsers;

public class LoginTest {
	WebDriver driver = null;

	@Parameters("browser")
	@BeforeMethod
	public void initDriver(@Optional("chrome") String browser) {
		driver = Browsers.createDriver(browser);
		driver.get("https://www.facebook.com");
	}

	@Test()
	public void testLogut() {
		// code to logout from facebook
		System.out.println(driver.getTitle() + " -- " + driver.getCurrentUrl());
		driver.findElement(By.id("pass")).sendKeys("password");
	}

	@Test()
	public void testLogin() {
		// code to login to facebook
		System.out.println(driver.getTitle() + " -- " + driver.getCurrentUrl());
		driver.findElement(By.id("email")).sendKeys("username");
	}

	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}
}
