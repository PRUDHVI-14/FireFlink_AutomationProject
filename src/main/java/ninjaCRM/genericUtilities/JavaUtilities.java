package ninjaCRM.genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consists of generic methods related to the java
 * @author Prudhvi B
 */
public class JavaUtilities {

	/**
	 * This method  print the current date with time
	 * @return
	 */
	public  String getSystemDate() {
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String date = s.format(d);
		return date;
	}
	
	/**
	 * This method prints the random number
	 * @return
	 */
	public int getRandomNum() {
		Random r = new Random();
		return r.nextInt(1000);
	}
}
