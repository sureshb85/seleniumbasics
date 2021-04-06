package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class EventListenerUsgaeDemo extends EventListenerDemo {

	public static void main(String[] args) {
		
		WebDriver driver = Browsers.createDriver("chrome");
		// event listener
		EventListenerDemo eventListener = new EventListenerDemo();

		// Event firing
		EventFiringWebDriver eventFiring = new EventFiringWebDriver(driver);
		eventFiring.register(eventListener);

		eventFiring.get("https://www.wikipedia.com");
		System.out.println("Title: " + eventFiring.getTitle());
		WebElement wikiHeader = eventFiring.findElement(By.xpath("//*[@id='www-wikipedia-org']//h1/span"));
		System.out.println("displayed? " + wikiHeader.isDisplayed());
		System.out.println("enabled? " + wikiHeader.isEnabled());
		System.out.println("selected? " + wikiHeader.isSelected());
		String text = wikiHeader.getText();
		System.out.println("print textcontent " + text);

		eventFiring.findElement(By.xpath("//*[@id=\"search-form\"]/fieldset/button/i")).click();

		eventFiring.quit();
	}

}
