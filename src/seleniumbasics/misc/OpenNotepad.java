package seleniumbasics.misc;

import java.io.IOException;

public class OpenNotepad {

	public static void main(String[] args) {
		Runtime rs = Runtime.getRuntime();

		try {
			rs.exec("notepad");
			rs.exec("mspaint");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
