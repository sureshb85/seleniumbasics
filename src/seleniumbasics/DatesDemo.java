package seleniumbasics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;

public class DatesDemo {
	static WebDriver driver;
	static String converetedDay;
	static String converetedMonth;
	static String converetedYear;

	public static void main(String[] args) throws ParseException {
		convertStringToDateFormat();
		// testDateField();
		testDateDropDown();
	}

	static void convertStringToDateFormat() throws ParseException {
		String purchaseDate = "20/02/2015";
		Date pDate = new SimpleDateFormat("dd/MM/yyyy").parse(purchaseDate);
		converetedDay = new SimpleDateFormat("dd").format(pDate);
		converetedMonth = new SimpleDateFormat("MMM").format(pDate);
		converetedYear = new SimpleDateFormat("yyyy").format(pDate);
		System.out.println(converetedDay + "-" + converetedMonth + "-" + converetedYear);
		Date curDate = new Date();
		System.out.println("Date: " + curDate);

		/*
		 * String format2 = "dd/MMM/yy"; Date date = new
		 * SimpleDateFormat("dd/MM/yyyy").parse(purchaseDate); SimpleDateFormat sdf =
		 * new SimpleDateFormat(format2); System.out.println(sdf.format(date));
		 */
	}

	static void testDateField() {
		initdriver("https://www.onlineservices.nsdl.com/paam/endUserRegisterContact.html");
		driver.findElement(By.id("date_of_birth_reg")).sendKeys("15/03/2019");
		driver.findElement(By.id("date_of_birth_reg")).sendKeys(Keys.TAB);
	}

	static void testDateDropDown() {
		initdriver("https://www.onlineservices.nsdl.com/paam/endUserRegisterContact.html");
		driver.findElement(By.id("date_of_birth_reg")).click();

		// select year
		WebElement yearSelect = driver.findElement(By.xpath("//*[@class='yearselect form-control input-sm']"));
		Select year = new Select(yearSelect);
		year.selectByValue(converetedYear);

		// select month
		WebElement monthSelect = driver.findElement(By.xpath("//*[@class='monthselect form-control input-sm']"));
		Select month = new Select(monthSelect);
		month.selectByVisibleText(converetedMonth);

		// days table
		WebElement daysList = driver
				.findElement(By.xpath("//*[@class='calendar left single']//table[@class='table-condensed']/tbody"));
		// day rows
		List<WebElement> tableRows = daysList.findElements(By.tagName("tr"));
		for (int i = 0; i < tableRows.size(); i++) {
			// day columns
			List<WebElement> tableCols = tableRows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < tableCols.size(); j++) {
				String dayXpath = "//*[@class='calendar left single']//table[@class='table-condensed']/tbody/tr["
						+ (i + 1) + "]/td[" + (j + 1) + "]";
				String day = tableCols.get(j).findElement(By.xpath(dayXpath)).getText();
				if (day.equals(converetedDay)) {
					tableCols.get(j).findElement(By.xpath(dayXpath)).click();
					break;
				}
				// System.out.print(day + "\t");
			}
			// System.out.println();
		}
		driver.quit();
	}

	static void initdriver(String url) {
		String chromeDriverPath = System.getProperty("user.dir") + "//drivers/chromedriver.exe";
		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, chromeDriverPath);
		driver = new ChromeDriver();
		driver.get(url);
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
	}
}
