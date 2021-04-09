package seleniumbasics.poi;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//https://poi.apache.org/components/spreadsheet/examples.html

public class FillsAndColors {
	public static void main(String[] args) throws IOException {
		try (Workbook wb = new XSSFWorkbook()) { // or new HSSFWorkbook();
			Sheet sheet = wb.createSheet("new sheet");

			// Create a row and put some cells in it. Rows are 0 based.
			Row row = sheet.createRow(1);

			// 1st cell
			Cell cell = row.createCell(1);
			cell.setCellValue(new XSSFRichTextString("X"));

			// Aqua background
			CellStyle style = wb.createCellStyle();
			style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
			style.setFillPattern(FillPatternType.BIG_SPOTS);
			cell.setCellStyle(style);

			// 2nd cell
			cell = row.createCell(2);
			cell.setCellValue(new XSSFRichTextString("X"));

			// Orange "foreground", foreground being the fill foreground not the font color.
			style = wb.createCellStyle();
			style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell.setCellStyle(style);

			// Write the output to a file
			try (FileOutputStream fileOut = new FileOutputStream(
					System.getProperty("user.dir") + "\\src\\seleniumbasics\\poi\\fill_colors.xlsx")) {
				wb.write(fileOut);
			}
		}
	}
}