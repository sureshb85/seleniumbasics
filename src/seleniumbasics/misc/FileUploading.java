package seleniumbasics.misc;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploading {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		textFileUploading();
	}

	private static void textFileUploading() throws InterruptedException {
		// w3schools
		initdriver("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_fileupload_get");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//*[@type='file']"))
				.sendKeys(System.getProperty("user.dir") + "\\screenshots\\flowers.jpg");
		driver.switchTo().defaultContent();
		List<WebElement> menuList = driver.findElements(By.xpath("//*[@class='w3-bar']/a"));
		for (WebElement menu : menuList) {
			System.out.println(menu.getAttribute("title"));
		}
		Thread.sleep(4000);
		driver.quit();

	}

	private static void initdriver(String url) {

		WebDriverManager.firefoxdriver().setup();

		driver = new FirefoxDriver();
		driver.get(url);
		System.out.println(driver.getTitle());
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
}
