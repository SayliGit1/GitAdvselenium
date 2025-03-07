package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchAllFlipkartLinks {

	public static void main(String[] args) throws Throwable {

	FileInputStream fis = new FileInputStream("./src/test/resources/excelsheet.xlsx");
		
		    Workbook book =WorkbookFactory.create(fis);
		
		    //navigate to excel sheet
		    Sheet sheet = book.getSheet("Sheet2");
		
	    	WebDriver driver = new ChromeDriver();
	    	driver.get("https:/www.flipkart.com");
		    List<WebElement> alllinks = driver.findElements(By.xpath("//a"));
		
     //to read data of alllinks from excel 
		    System.out.println("print all the links present in flipkart" +alllinks.size());  
		
		 for(int i=0; i<alllinks.size(); i++ )
	     {  
		 Row row = sheet.getRow(i); 
		 Cell cell = row.getCell(0);
		String link = cell.getStringCellValue();
		System.out.println(link);
	}

}
}