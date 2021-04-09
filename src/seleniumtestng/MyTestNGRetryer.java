package seleniumtestng;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyTestNGRetryer implements IRetryAnalyzer {

	private int counter = 0;
	private int retryLimit = 3;

	public boolean retry(ITestResult result) {
		if (counter < retryLimit) {
			counter++;
			return true;
		}
		return false;
	}

}
