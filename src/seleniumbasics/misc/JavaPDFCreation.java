package seleniumbasics.misc;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class JavaPDFCreation {

	public static void main(String[] args) {
		PDDocument pdf = new PDDocument();
		try {
			// creating a page
			PDPage page = new PDPage();
			pdf.addPage(page);

			// Create a new font object selecting one of the PDF base fonts

			// Start a new content stream which will "hold" the to be created content
			PDPageContentStream contentStream = new PDPageContentStream(pdf, page);

			// Define a text content stream using the selected font, moving the cursor and
			// drawing the text "Hello World"
			contentStream.beginText();
			contentStream.newLineAtOffset(20, 450);
			PDFont font = PDType1Font.TIMES_BOLD_ITALIC;
			contentStream.setFont(font, 12);
			// contentStream.moveTo(100, 700);
			// contentStream.moveTextPositionByAmount(100, 700);
			contentStream.showText("Hello World1");
			contentStream.newLine();
			contentStream.endText();
			contentStream.close();

			pdf.save(System.getProperty("user.dir") + "\\src\\seleniumbasics\\poi\\mypdffile.pdf");

			pdf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
