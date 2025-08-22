package practice.AdvanceSelenium;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import ninjaCRM.genericUtilities.FileUtility;

public class Basic {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileUtility fu = new FileUtility();
		System.out.println(fu.readDataFromExcelFile("Sheet1", 4, 3));
	}

	
}
