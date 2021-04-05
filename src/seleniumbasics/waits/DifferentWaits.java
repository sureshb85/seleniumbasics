package seleniumbasics.waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.pagefactory.ByAll;

/*
 * pageLoadStrategy :
 * When Page Loading takes too much time and you need to stop downloading additional subresources (images, css, js etc) you can change the  pageLoadStrategy through the webdriver.

pageLoadStrategy supports the following values :
normal:Selenium to wait for the full page loading (html content and subresources downloaded and parsed).
eager: Selenium to wait for the DOMContentLoaded event (html content downloaded and parsed only).
none: Selenium to return immediately after the initial page content is fully received (html content downloaded).
By default selenium loads page in NORMAL pageLoadStrategy.
 */

public class DifferentWaits {
	/*
	 * 
	 * ''' implicit_wait: Specifies the amount of time the driver should wait when
	 * searching for an element if it is not immediately present. When searching for
	 * a single element, the driver should poll the page until the element has been
	 * found, or this timeout expires before throwing a NoSuchElementException. When
	 * searching for multiple elements, the driver should poll the page until at
	 * least one element has been found or this timeout has expired. Increasing the
	 * implicit wait timeout should be used judiciously as it will have an adverse
	 * effect on test run time, especially when used with slower location strategies
	 * like XPath.
	 * 
	 * setScriptTimeout: Sets the amount of time to wait for an asynchronous script
	 * to finish execution before throwing an error. If the timeout is negative,
	 * then the script will be allowed to run indefinitely.
	 * 
	 * pageLoadTimeout: Sets the amount of time to wait for a page load to complete
	 * before throwing an error. If the timeout is negative, page loads can be
	 * indefinite. '''
	 * 
	 * ''' What is pageLoadTimeout Selenium defines different timeouts and wait
	 * mechanisms. One of the timeouts is focused on the time a webpage needs to be
	 * loaded – the pageLoadTimeout limits the time that the script allots for a web
	 * page to be displayed. If the page loads within the time then the script
	 * continues. If the page does not load within the timeout the script will be
	 * stopped by a TimeoutException. '''
	 * 
	 */

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,
				System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

		// firefox
		// FirefoxOptions options = new FirefoxOptions();
		// options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

		// chrome
		// ChromeOptions options = new ChromeOptions();
		// options.addArguments("start-maximized");
		// options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		// WebDriver driver = new ChromeDriver(options);

		WebDriver driver = new ChromeDriver();
		// Exception in thread "main" org.openqa.selenium.TimeoutException:
		// timeout
		// driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS); --
		// because the complete page is not laoded in 2 seconds
		// driver.manage().timeouts().setScriptTimeout(2, TimeUnit.SECONDS); //
		// this is for any asynchronous scripts to be loaded
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.wikipedia.com");
		WebElement wikiSearch = driver.findElement(new ByAll(By.xpath("//input[@id='searchInputttttt']"),
				By.id("searchInputtttttt"), By.cssSelector("#searchInput")));
		wikiSearch.sendKeys("selenium java testng");
		// Thread.sleep(10);
		System.out.println(driver.getTitle());
		driver.quit();

	}
}
