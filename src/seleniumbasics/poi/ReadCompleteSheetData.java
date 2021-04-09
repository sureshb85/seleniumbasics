package seleniumbasics.poi;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadCompleteSheetData {
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
				for (int j = 0; j <= noOfRows; j++) {
					Row row = sheet.getRow(j);
					int noOfCols = row.getLastCellNum();
					for (int k = 0; k < noOfCols; k++) {
						Cell cell = row.getCell(k);
						// System.out.print(cell.getCellType() + " -- " + k + "\t");

						switch (cell.getCellType()) {
						case STRING:
							System.out.print(cell.getStringCellValue() + "\t");
							break;
						case NUMERIC:
							System.out.print(cell.getNumericCellValue() + "\t");
							break;
						default:
							break;
						}
					}
					System.out.println();
				}

			}
		}
	}

}
