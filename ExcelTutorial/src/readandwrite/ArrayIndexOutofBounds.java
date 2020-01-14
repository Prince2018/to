package readandwrite;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
public class ArrayIndexOutofBounds{
	
	public static void main(String args[]) {
		BasicConfigurator.configure();
		Logger log = Logger.getLogger("devpinoyLogger");
		String[] currencies = {"GBP", "USD", "JPY", "EUR", "INR"};
		  
		System.out.println("Supported currencies for trading : ");
		
		 log.debug("opening webiste");
		for (int i = 0; i <= currencies.length; i++) { 
			System.out.println(currencies[i]);
			}
		} 
	}

