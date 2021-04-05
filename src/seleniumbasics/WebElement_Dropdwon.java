package seleniumbasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebElement_Dropdwon {
	public static void main(String[] args) {

		withoutSelectClass();
		withSelectClass();
	}

	private static void withSelectClass() {
		WebDriver driver = Browsers.createDriver("chrome");
		driver.get("https://www.wikipedia.com");

		WebElement langDropdown = driver.findElement(By.id("searchLanguage"));
		Select selectLanguage = new Select(langDropdown);

		System.out.println(selectLanguage.getFirstSelectedOption().getText());
		selectLanguage.selectByValue("pl");
		selectLanguage.selectByValue("EN");

		// getOptions
		List<WebElement> allOptions = selectLanguage.getOptions();
		for (int i = 0; i < allOptions.size(); i++) {
			System.out.println(i + " -- " + allOptions.get(i).getText());
		}
		System.out.println(selectLanguage.getFirstSelectedOption().getText());
		driver.quit();

	}

	private static void withoutSelectClass() {
		WebDriver driver = Browsers.createDriver("chrome");
		driver.get("https://www.wikipedia.com");

		WebElement langDropdown = driver.findElement(By.id("searchLanguage"));
		List<WebElement> langValues = langDropdown.findElements(By.tagName("option"));
		System.out.println("total options " + langValues.size());

		for (WebElement lang : langValues) {
			if (lang.getText().equals("Polski")) {
				lang.click();
				System.out.println("textarea:" + lang.getText() + " -- :attribute " + lang.getAttribute("value")
						+ "displayed? " + lang.isDisplayed() + "enabled? " + lang.isEnabled() + "selected? "
						+ lang.isSelected());
			}
		}
		driver.quit();
	}
}
