package seleniumbasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElement_Checkbox {
	public static void main(String[] args) {

		WebDriver driver = Browsers.createDriver("chrome");
		driver.get("file:///C:/Users/sbollina/Selenium/TrishanaB2/src/Sunday0217/htmlpage.html");
		List<WebElement> courses = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (WebElement course : courses) {
			course.click();
//			System.out.println(course.getAttribute("name"));
//			String cour = course.getAttribute("name");
//			if (cour.equals("aws")) {
//				course.click();
//				break;
//			}
		}
		//driver.quit();
	}
}
