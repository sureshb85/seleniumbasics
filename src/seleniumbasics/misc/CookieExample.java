package seleniumbasics.misc;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import seleniumbasics.Browsers;

public class CookieExample {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		testCookie();

	}

	private static void testCookie() {
		initdriver("https://www.google.com");
		Set<Cookie> allCookies = driver.manage().getCookies();
		System.out.println(allCookies.size());
		for (Cookie c : allCookies) {
			System.out.println(c.getName() + " - " + c.getValue());
		}
		System.out.println(driver.manage().getCookieNamed("NID").getValue());
		Cookie cookie = new Cookie("course", "seleniumcookie");
		allCookies.add(cookie);
		for (Cookie c : allCookies) {
			System.out.println(c.getName() + " - " + c.getValue());
		}

	}

	private static void initdriver(String url) {
		driver = Browsers.createDriver("chrome");;
		driver.get(url);

		// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());

	}
}
