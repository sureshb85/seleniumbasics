package seleniumbasics.misc;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class JavaPDFReader {

	// download the jar from below link and to project build path
	// pdfbox-app-2.0.15.jar
	// https://pdfbox.apache.org/download.cgi
	public static void main(String[] args) {
		PDDocument document = null;
		try {
			document = Loader.loadPDF(new File(System.getProperty("user.dir") + "\\Notes\\json.pdf"));
			System.out.println("Total Number of Pages:" + document.getNumberOfPages());

			// More details
			// https://pdfbox.apache.org

			// Reading Text
			// https://pdfbox.apache.org/1.8/cookbook/textextraction.html
			PDFTextStripper pdfStripper = new PDFTextStripper();
			String text = pdfStripper.getText(document);
			System.out.println(text);
			System.out.println("pdf text " + text.length());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				document.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
