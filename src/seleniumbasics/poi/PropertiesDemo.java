package seleniumbasics.poi;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
	public static void main(String[] args) {

		Properties prop = new Properties();
		prop.setProperty("browser", "chrome");
		prop.setProperty("url", "https://www.google.com");
		prop.setProperty("username", "user1");
		prop.setProperty("password", "pass1");

		System.out.println("Key:browser and value: " + prop.getProperty("browser"));
		System.out.println("Key:url and value: " + prop.getProperty("url"));
		System.out.println("Key:username and value: " + prop.getProperty("username"));
		System.out.println("Key:password and value: " + prop.getProperty("password"));

		Set<Object> keys = prop.keySet();
		Iterator<Object> keyItr = keys.iterator();
		while (keyItr.hasNext()) {
			String key = (String) keyItr.next();
			System.out.println("key: " + key + "and value: " + prop.getProperty(key));
		}
	}
}
