package seleniumbasics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class ScreenShotsDemo {
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
		js.executeScript("arguments[0].setAttribute('style', 'border:4px dotted yellow;')", searchButton);
		String filePath = System.getProperty("user.dir") + "//screenshots/wiki_search_page.png";
		System.out.println("FilePath " + filePath);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// FileUtile is from apache common api
		// download the jar from the below link and add to build path
		// https://commons.apache.org/proper/commons-io/download_io.cgi -- file Name
		// commons-io-2.6-bin.zip
		FileUtils.copyFile(screenshotFile, new File(filePath));
		
		//element screenshot
		String elementPath = System.getProperty("user.dir") + "//screenshots/wiki_search_button.png";
		File elementScreenshot = searchButton.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(elementScreenshot, new File(elementPath));
		driver.quit();
	}
}
