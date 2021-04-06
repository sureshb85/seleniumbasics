package seleniumbasics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTables2 {

	public static void main(String[] args) {
		WebDriver driver = Browsers.createDriver("chrome");
		driver.get("https://www.nyse.com/ipo-center/recent-ipo");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> totalRows = driver.findElements(By.xpath("//table[2]/tbody/tr"));
		System.out.println("Total rows: " + totalRows.size());

		List<WebElement> totalCols = driver.findElements(By.xpath("//table[2]/tbody/tr/td"));
		System.out.println("Total cols: " + totalCols);

		driver.quit();
	}

}