package Organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_utility.Excel_utility;
import Generic_utility.File_Utility;
import Generic_utility.Java_utility;
import Generic_utility.WebDriver_utility;
import POM_Repo.CreateProductPage;
import POM_Repo.DeleteProduct;
import POM_Repo.HomePage;
import POM_Repo.LoginPageEx;
import POM_Repo.ProductLookUp;
import POM_Repo.ProductLookUpImg;
import POM_Repo.ValidateProduct;

public class CreateAndDeleteProduct {

	public static void main(String[] args) throws Throwable {


//FileInputStream fis = new FileInputStream("C:\\workspaces\\8 Aug 24\\AdvanceSeleniumFW\\src\\test\\resources\\vtiger.properties");
		
	//	Properties pro = new Properties();
	//	pro.load(fis);
	//	String BROWSER = pro.getProperty("browser");
	//	String URL = pro.getProperty("url");
	//	String USERNAME = pro.getProperty("username");
	//	String PASSWORD = pro.getProperty("password");
		
		//from file-utility
		File_Utility flib = new File_Utility();
		String BROWSER = flib.getCommonData("browser");
		String URL = flib.getCommonData("url");
		String USERNAME = flib.getCommonData("username");
		String PASSWORD = flib.getCommonData("password");
		
		WebDriver driver =  new ChromeDriver();
	//	if(BROWSER.equalsIgnoreCase("chrome")) 
	//	{
	//		driver = new ChromeDriver();
	//	}
	//	else if(BROWSER.equalsIgnoreCase("edge")) 
	//	{
	//		driver = new EdgeDriver();
	//	}
		
	//	else 
	//	{
	//		driver = new ChromeDriver();
	//	}
		
		        //automation script
				/*driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  */
		WebDriver_utility wlib = new WebDriver_utility();
				wlib.maximizeWIndow(driver);
				wlib.loadTheElements(driver);
				
				driver.get(URL);
			    LoginPageEx login = new LoginPageEx(driver);
			    login.loginToApp(USERNAME, PASSWORD);
		 /*     driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		        driver.findElement(By.id("submitButton")).click();    */
		        //first add product....................................................................................................
			    HomePage home = new HomePage(driver);
			    home.clickprdtLink(); 
		    //  driver.findElement(By.linkText("Products")).click();
			    ProductLookUp prdLookUp = new ProductLookUp(driver);
			    prdLookUp.clickProductLookUp();
		    //  driver.findElement(By.cssSelector("[alt=\"Create Product...\"]")).click();

		        //random approach..........
		     /*   Random ran = new Random();
		        int ranNum = ran.nextInt(1000); 
		        
		        FileInputStream file= new FileInputStream("C:\\workspaces\\8 Aug 24\\AdvanceSeleniumFW\\src\\test\\resources\\excelsheet.xlsx");
			    
			    Workbook book = WorkbookFactory.create(file);
			    
			    //go to excel sheet
			   Sheet sheet = book.getSheet("product");
			   Row row = sheet.getRow(0);
			   Cell cell = row.getCell(0);
			   String PrdName = cell.getStringCellValue()+ranNum;   */
		        Java_utility jlib = new Java_utility();
		        Excel_utility elib = new Excel_utility();
		        int ranNum = jlib.getRandomValue();
			       
		         String PrdName = elib.getExcelData("product", 0, 0)+ranNum;
		       
			   System.out.println(PrdName);
			   
			   //add product name from excel sheet
			   CreateProductPage prdPage = new CreateProductPage(driver);
				  prdPage.enterprdName(PrdName);
				  prdPage.clicksaveButton();
		//	   driver.findElement(By.name("productname")).sendKeys(PrdName);
		//	   driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
			   
			 //validation of orgname i. mandatory field.................................................................................................
			// ValidateProduct validatePrd = new ValidateProduct(driver);
              //  validatePrd.ValidatePrd(driver, PrdName);
			/*	String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
				
				if(actData.(rdName)) 
				{
					System.out.println("product name is created");
				}
				else
				{
					System.out.println("product name is not created");
					
				}   */
				
                  home.clickprdtLink();
		//	driver.findElement(By.linkText("Products")).click();	
			
                DeleteProduct deletePrd = new DeleteProduct(driver);
                deletePrd.SelectPrdCheckBox(driver, PrdName);
                deletePrd.ClickOnDeleteButton();
                wlib.alertAccept(driver);
                deletePrd.ValidateDeletedPrd(driver, PrdName);
                Thread.sleep(2000);
                home.logOut();
			//it will select all check boxes
			//driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='Product Name']/../preceding-sibling::td//input[@type='checkbox']")).click();
			
		/*	driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='"+PrdName+"']/../preceding-sibling::td//input[@type='checkbox']")).click();
			driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();   
			
			//handle the alert popup or javascript popup
			 
			driver.switchTo().alert().accept();
			
			//validate the product is deleted or not
		 WebElement DeletedData = driver.findElement(By.xpath("//table[@class=\"lvt small\"]//a[text()='"+PrdName+"']"));
		 
		 if(DeletedData.equals(PrdName))
		 {
			System.out.println("product is deleted"); 
		 }
		 else
		 {
			 System.out.println("product is not deleted");
		 }
				  */
			   
	}

}
