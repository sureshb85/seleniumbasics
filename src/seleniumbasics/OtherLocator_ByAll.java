package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByAll;

public class OtherLocator_ByAll {
	public static void main(String[] args) {

		// ByAll,
		// ByChained,
		// ByIdOrName

		WebDriver driver = Browsers.createDriver("chrome");
		driver.get("https://www.wikipedia.org");

		// Exception in thread "main"
		// org.openqa.selenium.NoSuchElementException: Cannot locate an element
		// using By.all({By.xpath: //input[@id='searchInputttttt'],By.id:
		// searchInputtttttt,By.cssSelector: #searchInputtttt})
		// WebElement wikiSearch = driver.findElement(new
		// ByAll(By.xpath("//input[@id='searchInputttttt']"),
		// By.id("searchInputtttttt"), By.cssSelector("#searchInputtttt")));

		WebElement wikiSearch = driver.findElement(new ByAll(By.xpath("//input[@id='searchInputttttt']"),
				By.id("searchInputtttttt"), By.cssSelector("#searchInput")));
		wikiSearch.sendKeys("selenium java testng");
		System.out.println("displayed? " + wikiSearch.isDisplayed());
		System.out.println("enabled? " + wikiSearch.isEnabled());
		System.out.println("selected? " + wikiSearch.isSelected());
		driver.quit();
	}
}
