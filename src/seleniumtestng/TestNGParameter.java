package seleniumtestng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameter {

	@Parameters({ "browser", "browserVersion" })
	@Test
	public void testParameter(String browser, String browserVersion) {
		System.out.println("Browser: " + browser + "\tbrowserVersion: " + browserVersion);
	}

}
