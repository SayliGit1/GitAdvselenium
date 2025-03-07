package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDataFromExcelFile {

	public static void main(String[] args) throws Throwable {

//step1 - connecting the excel file
		FileInputStream fis = new	FileInputStream("./src/test/resources/excelsheet.xlsx");
		
		//step2 -keel excel in read mode
		 Workbook book = WorkbookFactory.create(fis);
		 
		//step3- navigate into excel sheet 
		Sheet sheet = book.getSheet("Sheet1");
		
		//step4-navigate into row
		Row row = sheet.getRow(0);
		
		//step5-navigate into cell
		Cell cell = row.getCell(0);
		
		String exceldata = cell.getStringCellValue();
		System.out.println(exceldata);
		 
		 
		 
		 
		 
		 
		 
		 
	
	}

}
