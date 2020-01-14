package readandwrite;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class WriteExcelFile {
    public void writeExcel(String filePath,String fileName,String sheetName,String[] dataToWrite) throws IOException
    {    
        File file =    new File(filePath+"\\"+fileName); //Create an object of File class to open xlsx file   
        FileInputStream inputStream = new FileInputStream(file);   //Create an object of FileInputStream class to read excel file
        Workbook guru99Workbook = null;   
        String fileExtensionName = fileName.substring(fileName.indexOf(".")); // //Find the file extension by splitting  file name in substring and getting only extension name    
        if(fileExtensionName.equals(".xlsx"))  //Check condition if the file is xlsx file
        {  
        	guru99Workbook = new XSSFWorkbook(inputStream);  //If it is xlsx file then create object of XSSFWorkbook class
        }    
        else if(fileExtensionName.equals(".xls")) //Check condition if the file is xls file
        {         
            guru99Workbook = new HSSFWorkbook(inputStream);  //If it is xls file then create object of XSSFWorkbook class
        }      
    Sheet sheet = guru99Workbook.getSheet(sheetName);//Read excel sheet by sheet name      
    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum(); //Get the current count of rows in excel file  
    Row row = sheet.getRow(0);  //Get the first row from the sheet  
    Row newRow = sheet.createRow(rowCount+1); //Create a new row and append it at last of sheet
    //Create a loop over the cell of newly created Row
 /*   for (String currency : valueToWrite){
    	Cell cell = newRow.createCell(j);
        cell.setCellValue(dataToWrite[j]);
        System.out.println(currency); }*/
    for(int j = 0; j < row.getLastCellNum(); j++)
    {   
        Cell cell = newRow.createCell(j);   //Fill data in row
        cell.setCellValue(dataToWrite[j]);     
    }  
    inputStream.close();  //Close input stream   
    FileOutputStream outputStream = new FileOutputStream(file);  //Create an object of FileOutputStream class to create write data in excel file   
    guru99Workbook.write(outputStream); //write data in the excel file
    outputStream.close(); //close output stream
	    }
    public static void main(String...strings) throws IOException,IndexOutOfBoundsException{
   
        //Create an array with the data in the same order in which you expect to be filled in excel file
        String[] valueToWrite = { "Name4","oidnn"};
      /*  System.out.println("Supported currencies for trading : "); 
        for (String currency : valueToWrite){
         System.out.println(currency); }
*/   
       WriteExcelFile objExcelFile = new WriteExcelFile();   //Create an object of current class 
        objExcelFile.writeExcel(System.getProperty("user.dir")+"\\src\\readandwrite","ExportExcel.xlsx","ExcelGuru99Demo",valueToWrite);  //Write the file using file name, sheet name and the data to be filled

    }

}
