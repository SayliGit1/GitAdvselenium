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

public class Insertdataintoexcel {

	public static void main(String[] args) throws Throwable {

      FileInputStream fis = new  FileInputStream("./src/test/resources/excelsheet.xlsx");
 
      //step2-keep excel in read mode
      Workbook book = WorkbookFactory.create(fis);  
 
     //step3-navigate into excel sheet
     Sheet sheet = book.getSheet("Sheet1");
     
     Row row = sheet.createRow(5);
     Cell cell = row.createCell(3);

     cell.setCellValue("pooja");
     
    FileOutputStream fos = new FileOutputStream("./src/test/resources/excelsheet.xlsx");
    book.write(fos);
    book.close();

 
	}

}
