package seleniumbasics.poi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcelFile {

	// Apache POI - the Java API for Microsoft Documents
	// https://poi.apache.org/

	public static void main(String[] args) {

		// Examples on Excel writing and reading
		// https://poi.apache.org/components/spreadsheet/quick-guide.html#NewWorkbook

		Workbook book = new XSSFWorkbook(); // xlsx
		// Workbook book = new HSSFWorkbook(); // xls

		try (OutputStream fileOut = new FileOutputStream(
				System.getProperty("user.dir") + "\\src\\seleniumbasics\\poi\\workbook_cts.xlsx")) {
			Sheet sheet1 = book.createSheet();
			Sheet sheet = book.createSheet("SecondSheet");
			Row row = sheet.createRow(0);
			Cell cell = row.createCell(0);
			cell.setCellValue("Hello");

			// row = sheet.createRow(0);
			cell = row.createCell(1);
			cell.setCellValue("World");

			book.write(fileOut);
			System.out.println("File saved successfully");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
