package seleniumbasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElement_Radio {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Browsers.createDriver("chrome");
		driver.get("https://www.facebook.com");
		List<WebElement> genders = driver.findElements(By.xpath("//*[@data-name='gender_wrapper']//label"));
		for (WebElement gender : genders) {
			System.out.println(gender.getText());
			String gen = gender.getText();
			if (gen.equals("Female")) {
				gender.click();

			}
		}
		driver.quit();
	}
}
