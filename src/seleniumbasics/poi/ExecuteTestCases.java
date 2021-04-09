package seleniumbasics.poi;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExecuteTestCases {

	public static void main(String[] args) {
		Workbook book = null;
		String fileName = System.getProperty("user.dir") + "\\src\\seleniumbasics\\poi\\TestCase.xlsx";

		try {
			book = new XSSFWorkbook(new File(fileName));
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}

		Sheet sheet = book.getSheet("Login");
		int noOfRows = sheet.getLastRowNum();
		for (int i = 0; i <= noOfRows; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				switch (cell.getCellType()) {
				case STRING:
					String col = row.getCell(j).getStringCellValue();
					if (col.equals("Y")) {
						System.out.println("Execute the testcase");
					}
					break;
				}
			}
		}
	}
}
