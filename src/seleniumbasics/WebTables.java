package seleniumbasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebTables {
	public static void main(String[] args) throws InterruptedException {

		// Google Search
		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,
				System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY,
				System.getProperty("user.dir") + "\\logs\\chromeLogs.txt");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.navigate().to("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_table_intro");
		System.out.println("Title " + driver.getTitle());

		driver.switchTo().frame("iframeResult");
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		System.out.println("Total Rows " + rows.size());
		List<WebElement> cols = null;
		for (int i = 1; i <= rows.size(); i++) {
			cols = driver.findElements(By.xpath("//table/tbody/tr[" + i + "]/th"));
			for (int j = 1; j <= cols.size(); j++) {
				WebElement col = driver.findElement(
						By.xpath("//table/tbody/tr[" + i + "]/th[" + j + "]"));
				System.out.print(col.getText() + "\t\t\t");
			}
		}
		cols = null;
		for (int i = 1; i <= rows.size(); i++) {
			cols = driver.findElements(By.xpath("//table/tbody/tr[" + i + "]/td"));
			for (int j = 1; j <= cols.size(); j++) {
				WebElement col = driver.findElement(
						By.xpath("//table/tbody/tr[" + i + "]/td[" + j + "]"));
				System.out.print(col.getText() + "\t\t\t");
			}
			System.out.println("");
		}
		driver.quit();
	}

}
