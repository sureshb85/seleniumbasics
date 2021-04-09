package seleniumtestng;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Test;

public class MyTestNGListener extends TestListenerAdapter {
	@Override
	public void onTestFailure(ITestResult tr) {
		System.out.println("onTestFailure -- is executed");
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		System.out.println("onTestSkipped -- is executed");
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		System.out.println("onTestSuccess -- is executed");
	}

}
