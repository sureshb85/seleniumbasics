package seleniumbasics.poi;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class SeleniumWithPropertyFile {
	public static void main(String[] args) {

		FileReader config = null;
		FileReader locators = null;
		Properties configFile = new Properties();
		Properties locatorsFile = new Properties();
		WebDriver driver = null;
		try {
			System.out.println("user.dir" + System.getProperty("user.dir"));
			config = new FileReader(System.getProperty("user.dir") + "\\src\\seleniumbasics\\poi\\config.properties");
			configFile.load(config);

			locators = new FileReader(System.getProperty("user.dir") + "\\src\\seleniumbasics\\poi\\locators.properties");
			locatorsFile.load(locators);

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (configFile.get("browser").equals("chrome")) {
			System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,
					System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.out.println("Firefox is not supported. please try with chrome!");
			System.exit(0);
		}
		driver.get(configFile.getProperty("url"));

		WebElement wikiSearch = driver.findElement(By.id(locatorsFile.getProperty("searchInput")));
		wikiSearch.sendKeys(locatorsFile.getProperty("searchText"));
		WebElement searchButton = driver.findElement(By.xpath(locatorsFile.getProperty("searchButton")));
		searchButton.click();
		if (locatorsFile.getProperty("title").equals(driver.getTitle()))
			System.out.println(driver.getTitle() + "\nMatched");
		else
			System.out.println("Actual:" + driver.getTitle() + "\nExepcted:" + locatorsFile.getProperty("title")
					+ "\nNot matched");
		driver.close();
	}
}
