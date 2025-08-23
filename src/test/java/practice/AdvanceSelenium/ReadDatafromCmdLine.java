package practice.AdvanceSelenium;

import org.testng.annotations.Test;

public class ReadDatafromCmdLine {

	@Test
	public void readData() {
		String BROWSER = System.getProperty("browser");
		
		System.out.println(BROWSER);
		
		String USERNAME = System.getProperty("username");
		System.out.println(USERNAME +" osnvcjasdb");
		
		String PASSWORD = System.getProperty("password");
		System.out.println(PASSWORD);
	
	}
}
