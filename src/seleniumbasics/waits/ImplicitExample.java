package seleniumbasics.waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByAll;

import seleniumbasics.Browsers;

public class ImplicitExample {
	public static void main(String[] args) {

		WebDriver driver = Browsers.createDriver("chrome");
		driver.get("https://www.wikipedia.org");

		// Exception in thread "main"
		// org.openqa.selenium.NoSuchElementException: Cannot locate an element
		// using By.all({By.xpath: //input[@id='searchInputttttt'],By.id:
		// searchInputtttttt,By.cssSelector: #searchInputtttt})
		// WebElement wikiSearch = driver.findElement(new
		// ByAll(By.xpath("//input[@id='searchInputttttt']"),
		// By.id("searchInputtttttt"), By.cssSelector("#searchInputtttt")));

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement wikiSearch = driver.findElement(new ByAll(By.xpath("//input[@id='searchInputttttt']"),
				By.id("searchInputtttttt"), By.cssSelector("#searchInput")));
		wikiSearch.sendKeys("selenium java testng");
		System.out.println("displayed? " + wikiSearch.isDisplayed());
		System.out.println("enabled? " + wikiSearch.isEnabled());
		System.out.println("selected? " + wikiSearch.isSelected());
		driver.quit();
	}
}
