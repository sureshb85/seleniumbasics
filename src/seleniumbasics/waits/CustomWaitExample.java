package seleniumbasics.waits;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumbasics.Browsers;

class PageReadyStateWait implements ExpectedCondition<Boolean> {

	@Override
	public Boolean apply(WebDriver driver) {
		int i = 0;
		while (i != 10) {
			Boolean isReadyState = ((JavascriptExecutor) driver).executeScript("return document.readyState")
					.equals("complete");
			if (isReadyState) {
				return isReadyState;
			} else {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			i++;
			System.out.println(i);
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("Page is not in readystate");
	}
}

class PageUrl implements ExpectedCondition<Boolean> {

	String expectedUrl = null;
	String actualUrl = null;

	public PageUrl(String expectedUrl) {
		this.expectedUrl = expectedUrl;
	}

	@Override
	public Boolean apply(WebDriver driver) {
		actualUrl = driver.getCurrentUrl();
		Boolean isUrlCorrect = driver.getCurrentUrl().equals(expectedUrl);
		return isUrlCorrect;
	}

	@Override
	public String toString() {
		return String.format("Expecturl: " + expectedUrl + " actualurl: " + actualUrl);
	}
}

public class CustomWaitExample {

	public static void main(String[] args) {

		WebDriver driver = Browsers.createDriver("chrome");
		driver.get("https://edition.cnn.com");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(new PageReadyStateWait());
		wait.until(new PageUrl("https://www.facebook.com"));
		driver.quit();
	}
}