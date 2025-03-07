package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
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

public class InsertAllFlipkartLinkIntoexcelSheet {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis = new FileInputStream("./src/test/resources/excelsheet.xlsx");
		
		Workbook book =WorkbookFactory.create(fis);
		
		//navigate to excel sheet
		Sheet sheet = book.getSheet("Sheet2");
		
		  
	     WebDriver driver = new ChromeDriver();
	     driver.get("https:/www.flipkart.com");
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	     
	     List<WebElement> alllinks = driver.findElements(By.xpath("//a"));
	     
	     for(int i=0; i<alllinks.size(); i++ )
	     {

	         Row row = sheet.createRow(i);
	         Cell cell = row.createCell(0);	 
             cell.setCellValue(alllinks.get(i).getAttribute("href"));
	}
	     
	 FileOutputStream fos = new FileOutputStream("./src/test/resources/excelsheet.xlsx") ;   
	     book.write(fos);
	    book.close();   
	     
   //to read data of alllinks from excel 
	//System.out.println("print all the links present in flipkart" +alllinks.size());  
	
	// for(int i=0; i<alllinks.size(); i++ )
   //  {  
//	 Row row = sheet.getRow(i); 
//	 Cell cell = row.getCell(0);
//	String link = cell.getStringCellValue();
//	System.out.println(link);
	     
//     }    
	     
	   //  book.close();	     
}
	
	
	
	
	
}
