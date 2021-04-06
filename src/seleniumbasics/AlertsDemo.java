	package seleniumbasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsDemo {
	public static void main(String[] args) throws InterruptedException {
		Alert alert;
		String alertText;
		String enteredText;
		String chromeDriverPath = System.getProperty("user.dir") + "//drivers/chromedriver.exe";
		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		// js alert
		WebElement jsAlert = driver.findElement(By.xpath("//*[text()='Click for JS Alert']"));
		jsAlert.click();
		alert = driver.switchTo().alert();
		alertText = alert.getText();
		alert.accept(); // ok
		System.out.println("JS Alert text: " + alertText);

		// js confirm -- ok accept()
//		WebElement jsConfirm = driver.findElement(By.xpath("//*[text()='Click for JS Confirm']"));
//		jsConfirm.click();
//		alert = driver.switchTo().alert();
//		alertText = alert.getText();
//		alert.accept(); // ok
//		System.out.println("JS Confirm text: " + alertText);

		// js confirm -- ok dismiss()
		WebElement jsConfirmDismiss = driver.findElement(By.xpath("//*[text()='Click for JS Confirm']"));
		jsConfirmDismiss.click();
		alert = driver.switchTo().alert();
		alertText = alert.getText();
		alert.dismiss(); // cancel
		System.out.println("JS Confirm text: " + alertText);

		// js prompt -- ok
//		WebElement jsPromptOk = driver.findElement(By.xpath("//*[text()='Click for JS Prompt']"));
//		jsPromptOk.click();
//		alert = driver.switchTo().alert();
//		alertText = alert.getText();
//		alert.accept(); // ok
//		enteredText = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
//		System.out.println("JS Prompt text: " + alertText + "inputText: " + enteredText);

		// js prompt -- dismiss
//		WebElement jsPromptDismiss = driver.findElement(By.xpath("//*[text()='Click for JS Prompt']"));
//		jsPromptDismiss.click();
//		alert = driver.switchTo().alert();
//		alertText = alert.getText();
//		alert.dismiss(); // ok
//		enteredText = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
//		System.out.println("JS Prompt text: " + alertText + "inputText: " + enteredText);

		// js prompt -- with input text and ok
//		WebElement jsPromptOk = driver.findElement(By.xpath("//*[text()='Click for JS Prompt']"));
//		jsPromptOk.click();
//		alert = driver.switchTo().alert();
//		alert.sendKeys("Java Selenium");
//		alertText = alert.getText();
//		alert.accept(); // ok
//		enteredText = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
//		System.out.println("JS Prompt text: " + alertText + "inputText: " + enteredText);

		//WebDriverWait wait = new WebDriverWait(driver, 10);
		// js prompt -- with input text and dismiss
		//WebElement jsPromptDismiss = driver.findElement(By.xpath("//*[text()='Click for JS Prompt']"));
		//jsPromptDismiss.click();
		//alert = wait.until(ExpectedConditions.alertIsPresent());
		//alert = driver.switchTo().alert();
		//alert.sendKeys("Java Selenium");
		//Thread.sleep(1000);
		//alertText = alert.getText();
		//alert.dismiss(); // cancel
		//enteredText = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
		//System.out.println("JS Prompt text: " + alertText + " inputText: " + enteredText);

		//driver.quit();
	}
}
