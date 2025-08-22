package practice.AdvanceSelenium;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ninjaCRM.genericUtilities.FileUtility;

public class TestNGPractice extends FileUtility{

//	@Test
//	public void sampleTest() {
//		System.out.println("done");
//	}
	
	
	@Test (dataProvider =  "customerInfo")
	public void create(String name, int id) {
		System.out.println(name+" and "+ id+ " -created");
	}
	@DataProvider(name="customerInfo")
	public Object[][] getData()
	{
		
		Object[][] data = new Object[4][2];
		
//		data[0][0] = "Ironman";
//		data[0][1] = 1;
//		
//		data[1][0] = "Batman";
//		data[1][1] = 2;
//		
//		data[2][0] = "Hulk";
//		data[2][1] = 3;
//		
//		data[3][0] = "Spiderman";
//		data[3][1] = 4;
		
		
		return data;
		
	}
	
}
