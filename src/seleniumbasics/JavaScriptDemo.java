package seleniumbasics;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class JavaScriptDemo {
	public static void main(String[] args) {
		String chromeDriverPath = System.getProperty("user.dir") + "//drivers/chromedriver.exe";
		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		// driver.get('https://www.wikipedia.com')

		// javascript to launch the url
		js.executeScript("window.location = 'https://www.wikipedia.com';");
		String jsTitle = (String) js.executeScript("return document.title");

		System.out.println(driver.getTitle() + "\tjavscript title " + jsTitle);

		String jsURL = (String) js.executeScript("return document.URL");
		String jsReadyState = (String) js.executeScript("return document.readyState");
		List<Object> jsAllLinks = (List<Object>) js.executeScript("return document.links");
		System.out.println("jsURL:" + jsURL + "\tjsReadyState: " + jsReadyState);
		System.out.println("Total jsAllLinks: " + jsAllLinks.size());
		
		//create alert using js
		js.executeScript("window.window.alert('Hey, I am using js.executescript() to create this alert during testcase execution');");

	}

}
