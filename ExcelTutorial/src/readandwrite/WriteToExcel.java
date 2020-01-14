package readandwrite;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
//import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import statements 
public class WriteToExcel { 
public static void main(String[] args) 
	{ 		
		XSSFWorkbook workbook = new XSSFWorkbook(); // Blank workbook 
		XSSFSheet sheet = workbook.createSheet("student Details"); 	// Create a blank sheet 	
		Map<String, Object[]> data = new TreeMap<String, Object[]>(); // This data needs to be written (Object[]) 
		data.put("1", new Object[]{ "ID", "NAME", "LASTNAME", "y78y" }); 
		data.put("2", new Object[]{ 1, "Pankaj", "Kumar" }); 
		data.put("3", new Object[]{ 2, "Prakashni", "Yadav" }); 
		data.put("4", new Object[]{ 3, "Ayan", "M" }); 
		data.put("5", new Object[]{ 4, "Vat", "kohli" }); 			
		Set<String> keyset = data.keySet();// Iterate over data and write to sheet 
		int rownum = 0; 
		for (String key : keyset)
		{ 		
			Row row = sheet.createRow(rownum++); //this creates a new row in the sheet 
			Object[] objArr = data.get(key); 
			int cellnum = 0; 
			for (Object obj : objArr)
			{ 				
				Cell cell = row.createCell(cellnum++); // this line creates a cell in the next column of that row 
				if (obj instanceof String) cell.setCellValue((String)obj); 		
				else if (obj instanceof Integer) cell.setCellValue((Integer)obj); 					
			} 
		} 
		try { 
			// this Writes the workbook gfgcontribute 
			FileOutputStream out = new FileOutputStream(new File("D:\\Automation\\Test.xlsx")); 
			workbook.write(out); 
			out.close(); 
			System.out.println("Written successfully on disk.");		 
		} 	catch (Exception e) { e.printStackTrace(); 	}
					
	} 
} 
//https://www.geeksforgeeks.org/reading-writing-data-excel-file-using-apache-poi/