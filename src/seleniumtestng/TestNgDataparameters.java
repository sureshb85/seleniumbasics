package seleniumtestng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgDataparameters {

	@Test(dataProvider = "getData")
	public void testData(String user, String pass, String id) {
		System.out.println("Username " + user + " - " + " Password " + pass + " - " + " Id " + id);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][3];
		data[0][0] = "User1";
		data[0][1] = "Pass1";
		data[0][2] = "id1";
		
		data[1][0] = "User2";
		data[1][1] = "Pass2";
		data[1][2] = "id2";
		
		data[2][0] = "User2";
		data[2][1] = "Pass2";
		data[2][2] = "id3";
		return data;

	}
}
