package seleniumbasics.misc;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.Assert;

public class PDFReaderProgram {
	public static void main(String[] args) throws InvalidPasswordException, IOException {

		File file = new File(System.getProperty("user.dir") + "\\Notes\\json.pdf");
		PDDocument document = Loader.loadPDF(file);
		System.out.println("Total Pages " + document.getNumberOfPages());
		PDPage page = document.getPage(2);
		System.out.println("Page contents " + page.hasContents());

		PDFTextStripper pdfText = new PDFTextStripper();
		System.out.println("Text - " + pdfText.getText(document));
		try {
			Assert.assertTrue(pdfText.getText(document).contains("json"));
		} catch (Throwable e) {
			System.out.println("Assertion failed");
		}
		System.out.println("Execution completed");
	}
}
