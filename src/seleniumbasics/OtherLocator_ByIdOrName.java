package seleniumbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ByIdOrName;

public class OtherLocator_ByIdOrName {
	public static void main(String[] args) {

		// ByAll,
		// ByChained,
		// ByIdOrName

		WebDriver driver = Browsers.createDriver("chrome");
		driver.get("https://www.wikipedia.org");

		//using id
		WebElement wikiSearch = driver.findElement(new ByIdOrName("searchInput"));
		//using name
		//WebElement wikiSearch = driver.findElement(new ByIdOrName("search"));
		wikiSearch.sendKeys("selenium java testng");
		System.out.println("displayed? " + wikiSearch.isDisplayed());
		System.out.println("enabled? " + wikiSearch.isEnabled());
		System.out.println("selected? " + wikiSearch.isSelected());
		driver.quit();
	}
}
