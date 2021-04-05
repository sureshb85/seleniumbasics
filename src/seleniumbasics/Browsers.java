package seleniumbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browsers {

	static final String PROJECT_DIR = System.getProperty("user.dir");

	public static WebDriver createDriver(String browser) {
		if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", PROJECT_DIR + "\\drivers\\msedgedriver.exe");
			return new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", PROJECT_DIR + "\\drivers\\geckodriver.exe");
			return new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", PROJECT_DIR + "\\drivers\\chromedriver.exe");
			return new ChromeDriver();

		}
	}
}
