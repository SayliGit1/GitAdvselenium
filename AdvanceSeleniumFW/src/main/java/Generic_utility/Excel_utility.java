package Generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_utility {

	public String getExcelData(String sheetName,int rowNum,int cellNum) throws Throwable {
	
		  FileInputStream file= new FileInputStream("C:\\workspaces\\8 Aug 24\\AdvanceSeleniumFW\\src\\test\\resources\\excelsheet.xlsx");
		    
		    Workbook book = WorkbookFactory.create(file);
		    
		    //go to excel sheet
		   Sheet sheet = book.getSheet(sheetName);
		   Row row = sheet.getRow(rowNum);
		   Cell cell = row.getCell(cellNum);
		   String excelData = cell.getStringCellValue();
	    	System.out.println(excelData);
	    	
		    return excelData;
		
	}
	
//...............................................................................................................................................
	
//get excel data using the data formatter
	public String readDataUsingDataFormatter(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		 FileInputStream file= new FileInputStream("C:\\workspaces\\8 Aug 24\\AdvanceSeleniumFW\\src\\test\\resources\\excelsheet.xlsx");
		    
		    Workbook book = WorkbookFactory.create(file);
		    
		    //go to excel sheet
		    Sheet sheet = book.getSheet(sheetName);
		    Row row = sheet.getRow(rowNum);
	        Cell cell = row.getCell(cellNum);
		
		    DataFormatter format =new DataFormatter();
	    	String excelData = format.formatCellValue(cell);
	    	System.out.println(excelData);	
	    	
	    	return excelData;
		
	}

	public void readExcelDataForDataProvider() {
		
		
	}
	
	
	
	
	
	
	
	
	
}
