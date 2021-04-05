package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Element_Textbox {
	public static void main(String[] args) {
		WebDriver driver = Browsers.createDriver("chrome");
		driver.get("https://www.wikipedia.com");
		
		WebElement wikiSearch = driver.findElement(By.id("searchInput"));
		System.out.println("displayed? " + wikiSearch.isDisplayed());
		System.out.println("enabled? " + wikiSearch.isEnabled());
		System.out.println("selected? " + wikiSearch.isSelected());
		
		// System.out.println("displayed? " + wikiSearch.isSelected()); only for
		// radio, checkbox and dropdowns
		if (wikiSearch.isEnabled()) {
			System.out.println("Entering textt");
			wikiSearch.sendKeys("some new text");
		}
		else {
			System.out.println("Not enabled ");
		}
		driver.quit();
	}
}
