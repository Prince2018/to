package readandwrite;
import java.io.*;  
import java.util.Scanner;  
public class ReadCSV1  
{  
	public static void main(String[] args) throws Exception  
	{  
		Scanner sc = new Scanner(new File("D:\\Automation\\Excelfiles\\demo.txt"));  //parsing a CSV file into Scanner class constructor  
		sc.useDelimiter(",");   //sets the delimiter pattern  
		while (sc.hasNext())  //returns a boolean value  
		{  
			System.out.print(sc.next());  //find and returns the next complete token from this scanner  
		}   
		sc.close();  //closes the scanner  
	}  
}  