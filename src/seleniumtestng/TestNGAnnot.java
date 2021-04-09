package seleniumtestng;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAnnot {

	@Test(alwaysRun = true)
	public void testLoginPass() {
		System.out.println("Always run");
	}

	@Test(enabled = false)
	public void testLoginFail() {
		System.out.println("enabled ");
	}

	@Test(invocationCount = 5)
	public void testLoginRefersh() {
		System.out.println("invocationCount ");
	}

	@Test(priority = 0, groups = "regression")
	public void testLoginPriority0() {
		System.out.println("First Testcase");
	}

	@Test(priority = 1)
	public void testLoginPriority1() {
		System.out.println("Third Testcase");
		AssertJUnit.assertFalse(true);
	}

	@Test(priority = 2, dependsOnMethods = { "testLoginPriority0", "testLoginPriority1" })
	public void testLoginPriority2() {
		System.out.println("Second TestCase");
	}

	@Test(groups = "smoke")
	public void testSuccessLogin() {
		System.out.println("testSuccessLogin");
		AssertJUnit.assertFalse(true);
	}

	@Test(dependsOnMethods = "testSuccessLogin", groups = { "smoke", "regression" })
	public void testHomePage() {
		System.out.println("testHomePage");
	}
}
