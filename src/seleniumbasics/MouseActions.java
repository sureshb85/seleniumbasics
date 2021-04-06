package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseActions {

	public static void main(String[] args) throws InterruptedException {
		moveToElementDemo();
		dragAndDropDemo();
		draggableByoffSetDemo();
		moveToElementAmazonSignIn();

	}

	private static void moveToElementAmazonSignIn() {
		WebDriver driver = Browsers.createDriver("chrome");
		driver.get("https://www.amazon.in");
		//driver.manage().window().maximize();
		driver.manage().window().fullscreen();
		WebElement accountLists = driver.findElement(By.xpath("//span[text()='Account & Lists']"));
		Actions action = new Actions(driver);
		action.moveToElement(accountLists).perform();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Sign in']")));
		
		driver.findElement(By.xpath("//span[text()='Sign in']")).click();
		driver.quit();
	}

	public static void moveToElementDemo() throws InterruptedException {
		String chromeDriverPath = System.getProperty("user.dir") + "//drivers/chromedriver.exe";
		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/menu/");
		driver.manage().window().maximize();
		WebElement aFrames = driver.findElement(By.xpath("//*[@class='demo-frame']"));
		driver.switchTo().frame(aFrames);
		WebElement mouseHover = driver.findElement(By.xpath("//*[text()='Electronics' and @role='menuitem']"));
		Actions action = new Actions(driver);
		action.moveToElement(mouseHover).perform();
		WebElement mouseHoverMenuItem = driver.findElement(By.xpath("//*[text()='Car Hifi' and @role='menuitem']"));
		Thread.sleep(10);
		System.out.println("Dispalyed:" + mouseHoverMenuItem.isDisplayed());
		System.out.println("Enabled:" + mouseHoverMenuItem.isEnabled());
		driver.quit();
	}

	public static void dragAndDropDemo() {
		WebDriver driver = Browsers.createDriver("chrome");
		driver.get("https://jqueryui.com/droppable");
		WebElement aFrame = driver.findElement(By.xpath("//*[@class='demo-frame']"));
		driver.switchTo().frame(aFrame);
		WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']/p"));
		System.out.println("Dispalyed:" + draggable.isDisplayed());
		System.out.println("Enabled:" + draggable.isEnabled());
		WebElement dropable = driver.findElement(By.xpath("//div[@id='droppable']/p"));
		System.out.println("Dispalyed:" + dropable.isDisplayed());
		System.out.println("Enabled:" + dropable.isEnabled());
		Actions action = new Actions(driver);
		action.dragAndDrop(draggable, dropable).build().perform();
		driver.quit();
	}

	public static void draggableByoffSetDemo() {
		String chromeDriverPath = System.getProperty("user.dir") + "//drivers/chromedriver.exe";
		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/draggable");
		driver.manage().window().maximize();
		WebElement aFrames = driver.findElement(By.xpath("//*[@class='demo-frame']"));
		driver.switchTo().frame(aFrames);
		WebElement dragable = driver.findElement(By.xpath("//div[@id='draggable']/p"));
		int xOffset = dragable.getRect().getX();
		int yOffset = dragable.getRect().getY();
		System.out.println("Before dragging/moving the element X:" + xOffset + "\tY:" + yOffset);
		Actions action = new Actions(driver);
		action.dragAndDropBy(dragable, 76, 11).build().perform();

		WebElement drag = driver.findElement(By.id("draggable"));
		xOffset = drag.getRect().getX();
		yOffset = drag.getRect().getY();
		System.out.println("After dragging/moving the element X:" + xOffset + "\tY:" + yOffset);
		driver.quit();
	}
}
