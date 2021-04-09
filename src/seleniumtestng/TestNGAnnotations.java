package seleniumtestng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {

	// beforeSuite
	// beforeTest
	// BeforeClass
	// BeforeMethod
	// Test -- getTitle
	// afterMethod
	// BeforeMethod
	// Test -- verifyTitle
	// afterMethod
	// afterClass
	// afterTest
	// afterSuite

	@BeforeClass
	public void beforeClass() {
		System.out.println("BeforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("afterClass");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod");
	}

	@Test
	public void firstTest() {
		System.out.println("First Testng Test Annotations");
	}

	@Test
	public void secondTest() {
		System.out.println("Second Testng Test Annotations");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite");
	}

	@BeforeGroups
	public void beforeGroup() {
		System.out.println("beforeSuite");
	}

	@AfterGroups
	public void afterGroup() {
		System.out.println("afterSuite");
	}
}
