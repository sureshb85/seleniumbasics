package seleniumbasics.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumbasics.Browsers;

public class ExplicitWaitExample {

	public static void main(String[] args) {

		WebDriver driver = Browsers.createDriver("chrome");
		driver.get(
				"https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

	
		String text = driver.findElement(By.xpath("//*[@class='label']")).getText();
		System.out.println("Before click on date " + text);
		driver.findElement(By.xpath("//*[@class='rcMainTable']/tbody/tr[3]/td[3]/a")).click();
		WebElement spinner = driver.findElement(By.cssSelector(".raDiv"));
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOf(spinner));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='label']"))));
		
		
		text = driver.findElement(By.xpath("//*[@class='label']")).getText();
		System.out.println("After click on date " + text);
		driver.quit();
	}
}
