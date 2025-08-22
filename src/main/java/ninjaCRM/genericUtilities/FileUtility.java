package ninjaCRM.genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

/**
*This class consists of generic methods related to the file realted operations like property file,excel file
*@author Prudhvi B
*/
public class FileUtility {

	/**
	 * This method will read the data from the property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
	
	/**
	 * This method will help to read the data from the excel data
	 * @param row
	 * @param cell
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String sheetName,int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Copy_of_TestData.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sheet = wb.getSheet(sheetName);
//		Row r = sheet.getRow(row);
//		return r.getCell(cell).toString();
		
		return WorkbookFactory.create(fis).getSheet(sheetName).getRow(row).getCell(cell).toString();
	}
	
	public void readMultipleDataFromExcelFile(String sheetName,int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Copy_of_TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		  Row r = wb.getSheet(sheetName).getRow(row);
//		 List<String> l = new List<>();
		 for(int i=0;i<r.getLastCellNum();i++) {
			 
		 }
	}
		
		 public Object[][] readMultiDataFromExcel(int rows, int col,String sheet) throws EncryptedDocumentException, IOException{
			 FileInputStream fis1 = new FileInputStream(".\\\\src\\\\test\\\\resources\\\\Copy_of_TestData.xlsx");
			 Object[][] data = new Object[rows][col];
			 Workbook workb = WorkbookFactory.create(fis1);
			 for(int i=0;i<rows;i++) {
				 for(int j=0;j<col;j++) {
					data[i][j] = workb.getSheet(sheet).getRow(rows).getCell(col).toString();
				 }
			 }
			 return data;
		 }

	
}
