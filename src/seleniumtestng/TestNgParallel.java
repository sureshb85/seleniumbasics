package seleniumtestng;

import org.testng.annotations.Test;

public class TestNgParallel {

	@Test
	public void testA() {
		System.out.println("TestA");
	}

	@Test
	public void testB() {
		System.out.println("TestB");
	}

	@Test
	public void testC() {
		System.out.println("TestC");
	}

	@Test
	public void testD() {
		System.out.println("TestD");
	}

}
