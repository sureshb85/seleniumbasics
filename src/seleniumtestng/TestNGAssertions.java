package seleniumtestng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGAssertions {

	SoftAssert sAssert = new SoftAssert();

	@Test
	public void verifyTitle() {
		// Hard Assert
		/*
		 * System.out.println("Username text"); Assert.assertEquals("Username",
		 * "Username");
		 * 
		 * System.out.println("Password text"); Assert.assertEquals("Password",
		 * "Password");
		 * 
		 * System.out.println("Title text"); Assert.assertEquals("Title", "Title");
		 */

		// =====================soft assert===

		System.out.println("Username text");
		sAssert.assertEquals("Username", "Userame");
		System.out.println("Password text");
		sAssert.assertEquals("Password", "Password");
		System.out.println("Title text");
		sAssert.assertEquals("Title", "Title");
		sAssert.assertAll();

	}

	/*
	 * @Test public void getTitle() {
	 * System.out.println("get Title from getTitle() method"); Assert.fail(); //
	 * Assert.assertTrue(10 > 8); // Assert.assertFalse(10 > 20); // Assert.fail();
	 * 
	 * }
	 * 
	 * 
	 * @Test public void getTitle1() {
	 * System.out.println("get Title from getTitle() method"); Assert.fail(); //
	 * Assert.assertTrue(10 > 8); // Assert.assertFalse(10 > 20); // Assert.fail();
	 * 
	 * }
	 */
}
