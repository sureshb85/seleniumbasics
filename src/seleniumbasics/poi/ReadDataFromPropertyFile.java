package seleniumbasics.poi;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) {

		FileReader config = null;
		Properties propFile = new Properties();

		try {
			config = new FileReader(System.getProperty("user.dir") + "\\src\\seleniumbasics\\poi\\config.properties");
			propFile.load(config);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Key:browser and value: " + propFile.getProperty("browser"));
		System.out.println("Key:url and value: " + propFile.getProperty("url"));
		System.out.println("Key:username and value: " + propFile.getProperty("username"));
		System.out.println("Key:password and value: " + propFile.getProperty("password"));

	}
}
