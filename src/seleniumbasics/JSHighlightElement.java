package seleniumbasics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class JSHighlightElement {
	public static void main(String[] args) throws IOException {
		String chromeDriverPath = System.getProperty("user.dir") + "//drivers/chromedriver.exe";
		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		// driver.get('https://www.wikipedia.com')

		// javascript to launch the url
		js.executeScript("window.location = 'https://www.wikipedia.com';");
		WebElement searchButton = driver.findElement(By.xpath("//*[@type='submit']"));
		System.out.println(searchButton.isDisplayed() + "Displayed");
		System.out.println(searchButton.isEnabled() + "Enabled");
		js.executeScript("arguments[0].setAttribute('style', 'border:8px solid orange;')", searchButton);
		searchButton.getScreenshotAs(OutputType.FILE);
		File scrFile = searchButton.getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scrFile, new File(Browsers.PROJECT_DIR + "\\screenshots\\searchButton.png"));
	}
}
