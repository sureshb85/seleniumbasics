package seleniumtestng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryExample {
	int i = 0;

	@Test(retryAnalyzer = seleniumtestng.MyTestNGRetryer.class)
	public void testA() {
		i++;
		if (i == 2) {
			Assert.assertTrue(true);
		} else {
			Assert.fail();
		}
	}
}
