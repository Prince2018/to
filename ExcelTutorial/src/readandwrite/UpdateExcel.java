package readandwrite;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UpdateExcel {

	public void updateXLSFile() {

		FileInputStream inputFile = null;
		XSSFWorkbook workbook = null;
		String filePath = "D:\\Automation\\Keyword\\Login.xlsx";

		try {
			inputFile = new FileInputStream(new File(filePath));
			workbook = new XSSFWorkbook(inputFile);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFCell cell = null;

		// Updating value of cell with integer
		cell = sheet.getRow(1).getCell(1);
		cell.setCellValue(123456);

		// Updating value of cell with String
		cell = sheet.getRow(1).getCell(0);
		cell.setCellValue("test666");

		// Updating value of cell with boolean
		cell = sheet.getRow(2).getCell(1);
		cell.setCellValue(true);

		try {
			FileOutputStream outFile = null;
			outFile = new FileOutputStream(new File(filePath));
			workbook.write(outFile);
			outFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String args[]) {
		UpdateExcel updateExcel = new UpdateExcel();
		updateExcel.updateXLSFile();
	}
}