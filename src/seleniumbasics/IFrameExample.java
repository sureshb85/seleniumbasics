package seleniumbasics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class IFrameExample {

	public static void main(String[] args) {
		// Radio button
		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,
				System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY,
				System.getProperty("user.dir") + "\\logs\\chromeLogs.txt");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.navigate().to("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_radio");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Title " + driver.getTitle());
		List<WebElement> totalFrames = driver.findElements(By.tagName("iframe"));
		System.out.println("Total Frames: " + totalFrames.size());
		for (int i = 0; i < totalFrames.size(); i++) {
			System.out.println(i + " - " + totalFrames.get(i).getAttribute("name"));
		}
		driver.switchTo().frame(0);
		WebElement headerTitle = driver.findElement(By.xpath("/html/body/h2"));
		System.out.println(headerTitle.getText());
	}

}
