package seleniumbasics.waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import seleniumbasics.Browsers;

public class FluentWaitExample {

	public static void main(String[] args) {
		Duration d = Duration.ofSeconds(10);
		Duration p = Duration.ofSeconds(2);
		WebDriver driver = Browsers.createDriver("chrome");
		driver.get(
				"https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(d).pollingEvery(p)
				.withMessage("Timeout occured!").ignoring(NoSuchElementException.class, StaleElementReferenceException.class);

		driver.findElement(By.xpath("//*[@class='rcMainTable']/tbody/tr[3]/td[3]/a")).click();
		WebElement spinner = driver.findElement(By.cssSelector(".raDiv"));

		fWait.until(ExpectedConditions.invisibilityOf(spinner));
		fWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='label']"))));
		String text = driver.findElement(By.xpath("//*[@class='label']")).getText();
		System.out.println("After click on date " + text);
		if (text.equals("Tuesday, April 13, 2021")) {
			System.out.println("Testcase passed acutal: " + text + " expected: Tuesday, April 13, 2021");
		} else {
			System.out.println("Testcase failed acutal: " + text + " expected: Tuesday, April 13, 2021");
		}
		driver.quit();
	}
}
