package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Element_TextContent {
	public static void main(String[] args) {
		WebDriver driver = Browsers.createDriver("chrome");
		driver.get("https://www.wikipedia.com");
		WebElement wikiHeader = driver.findElement(By.xpath("//*[@id='www-wikipedia-org']//h1/span"));
		System.out.println("displayed? " + wikiHeader.isDisplayed());
		System.out.println("enabled? " + wikiHeader.isEnabled());
		System.out.println("selected? " + wikiHeader.isSelected());
		System.out.println("print textcontent " + wikiHeader.getText());
		driver.quit();
	}
}
