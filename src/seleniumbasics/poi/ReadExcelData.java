package seleniumbasics.poi;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static void main(String[] args) {
		String excelFile = System.getProperty("user.dir") + "\\src\\seleniumbasics\\poi\\Employee.xlsx";
		Workbook book = null;
		try {
			book = new XSSFWorkbook(new File(excelFile));
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}

		// sheet details
		int noOfSheets = book.getNumberOfSheets();
		System.out.println("Total sheets in excel file: " + noOfSheets);
		System.out.println("Activesheet index: " + book.getActiveSheetIndex());
		System.out.println("---------");
		for (int i = 0; i < noOfSheets; i++) {
			System.out.println(i + " -- " + book.getSheetAt(i));
			String sheetName = book.getSheetName(i);
			if (sheetName.equals("Sheet5")) {
				Sheet sheet = book.getSheetAt(i);
				System.out.println("Total rows " + sheet.getLastRowNum());
				int noOfRows = sheet.getLastRowNum();
				Row row = sheet.getRow(0);
				System.out.print(row.getCell(0).getStringCellValue() + "\t");
				System.out.print(row.getCell(1).getStringCellValue() + "\t");
				System.out.print(row.getCell(2).getStringCellValue() + "\t");
				System.out.print(row.getCell(3).getStringCellValue() + "\t");
				System.out.println(row.getCell(4).getStringCellValue());

				row = sheet.getRow(1);
				System.out.print(row.getCell(0).getNumericCellValue() + "\t");
				System.out.print(row.getCell(1).getStringCellValue() + "\t");
				System.out.print(row.getCell(2).getStringCellValue() + "\t");
				System.out.print(row.getCell(3).getNumericCellValue() + "\t");
				System.out.println(row.getCell(4).getStringCellValue());
			}
		}
	}

}
