package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;

public class OtherLocator_ByChained {
	public static void main(String[] args) {

		// ByAll,
		// ByChained,
		// ByIdOrName

		WebDriver driver = Browsers.createDriver("chrome");
		driver.get("https://www.wikipedia.org");

		//WebElement wikiSearch = driver.findElement(
				//new ByChained(By.xpath("//form[@id='search-form']"), By.xpath("//input[@id='searchInput']")));
		
		WebElement wikiSearch = driver.findElement(
				new ByChained(By.xpath("//form[@id='search-form']"), By.id("searchInput")));
		
		wikiSearch.sendKeys("selenium java testng");
		System.out.println("displayed? " + wikiSearch.isDisplayed());
		System.out.println("enabled? " + wikiSearch.isEnabled());
		System.out.println("selected? " + wikiSearch.isSelected());
		driver.quit();
	}
}
