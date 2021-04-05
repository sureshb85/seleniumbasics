package seleniumbasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Frames {
	public static void main(String[] args) {

		WebDriver driver = Browsers.createDriver("chrome");
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_radio");
		List<WebElement> all_frames = driver.findElements(By.tagName("iframe"));
		for (WebElement frame : all_frames) {
			System.out.println(frame.getAttribute("name"));
		}
		WebElement tryHome = driver.findElement(By.id("tryhome"));
		System.out.println("before switching to frame " + tryHome.isDisplayed());
		for (int i = 0; i < all_frames.size(); i++) {
			System.out.println((i + 1) + " -- name: " + all_frames.get(i).getAttribute("name") + " id:"
					+ all_frames.get(i).getAttribute("id"));
			String myFrame = all_frames.get(i).getAttribute("name");
			if (myFrame.equals("iframeResult")) {
				driver.switchTo().frame("iframeResult");
				try {
					System.out.println("after switching to frame " + tryHome.isDisplayed());
				} catch (Exception e) {
					System.out.println("Element tryHome is not found on the frame");
				}

				List<WebElement> genders = driver.findElements(By.xpath("//input[@type='radio']"));
				for (WebElement gender : genders) {
					System.out.println(gender.getAttribute("value"));
					String gen = gender.getAttribute("value");
					if (gen.equals("male")) {
						gender.click();
						break;
					}
				}
				driver.switchTo().parentFrame();
				System.out.println("after coming out of the frame " + tryHome.isDisplayed());
				// driver.switchTo().defaultContent();
			}

		}
		driver.quit();
	}
}
