package seleniumbasics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

/*
 * We use cookies to personalize content and ads, to provide social media features and to analyze our traffic. 
 * Some of these cookies also help improve your user experience on our websites, 
 * assist with navigation and your ability to provide feedback, and assist with our promotional 
 * and marketing efforts. Please read our Cookie Policy for a more detailed description and
 *  click on the settings button to customize how the site uses cookies for you.
 */
public class CookiesDemo {
	public static void main(String[] args) {
		Set<Cookie> allCookies;
		String chromeDriverPath = System.getProperty("user.dir") + "//drivers/chromedriver.exe";
		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.com");
		allCookies = driver.manage().getCookies();
		System.out.println("Total Cookies: " + allCookies.size());
		for (Cookie c : allCookies) {
			System.out.println("Name:" + c.getName() + "\tValue:" + c.getValue() + "\tDomain:" + c.getDomain()
					+ "\tPath:" + c.getPath());
		}
		System.out.println(driver.manage().getCookieNamed("GeoIP"));

		Cookie myCookie = new Cookie("newCookie", "newCookieValue");
		driver.manage().addCookie(myCookie);

		allCookies = driver.manage().getCookies();
		System.out.println("Total Cookies after adding new cookie: " + allCookies.size());
		for (Cookie c : allCookies) {
			System.out.println("Name:" + c.getName() + "\tValue:" + c.getValue() + "\tDomain:" + c.getDomain()
					+ "\tPath:" + c.getPath());
		}

		// driver.manage().deleteCookieNamed("newCookie");
		driver.manage().deleteCookie(myCookie);
		allCookies = driver.manage().getCookies();
		System.out.println("Total Cookies after deleting the new Cookie: " + allCookies.size());
		driver.manage().deleteAllCookies();
		allCookies = driver.manage().getCookies();
		System.out.println("Total Cookies after deleting all: " + allCookies.size());
		driver.quit();
	}
}
