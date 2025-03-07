package Organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Generic_utility.Excel_utility;
import Generic_utility.File_Utility;
import Generic_utility.Java_utility;
import Generic_utility.WebDriver_utility;
import POM_Repo.CreateProductPage;
import POM_Repo.HomePage;
import POM_Repo.LoginPageEx;
import POM_Repo.ProductLookUp;
import POM_Repo.ValidateProduct;

public class CreateProduct {

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
				
				        //automation script........................................................................................................
					/*	driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); */
						WebDriver_utility wlib = new WebDriver_utility();
						wlib.maximizeWIndow(driver);
						wlib.loadTheElements(driver);
						
						driver.get(URL);
						LoginPageEx login = new LoginPageEx(driver);
						login.loginToApp(USERNAME, PASSWORD);
				    /*  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				        driver.findElement(By.id("submitButton")).click();    */
				        //first add product..........................................................................................
						HomePage home = new HomePage(driver);
						home.clickprdtLink();
				   //   driver.findElement(By.linkText("Products")).click();
						ProductLookUp prdLookUp = new ProductLookUp(driver);
						prdLookUp.clickProductLookUp();
				   //   driver.findElement(By.cssSelector("[alt=\"Create Product...\"]")).click();

				        //random approach..............................................................................................................
				      //  Random ran = new Random();
				      //  int ranNum = ran.nextInt(1000);
				        Java_utility jlib = new Java_utility();
				       int ranNum = jlib.getRandomValue();
				        
				     /*   FileInputStream file= new FileInputStream("C:\\workspaces\\8 Aug 24\\AdvanceSeleniumFW\\src\\test\\resources\\excelsheet.xlsx");
					    
					    Workbook book = WorkbookFactory.create(file);
					    
					    //go to excel sheet
					   Sheet sheet = book.getSheet("product");
					   Row row = sheet.getRow(0);
					   Cell cell = row.getCell(0);
					   String PrdName = cell.getStringCellValue()+ranNum;
					   System.out.println(PrdName);   */
				       
					   Excel_utility elib = new Excel_utility();
					   String PrdName = elib.getExcelData("product", 0, 0)+ranNum;
					   //add product name from excel sheet
					  CreateProductPage prdPage = new CreateProductPage(driver);
					  prdPage.enterprdName(PrdName);
					  prdPage.clicksaveButton();
				/*	   driver.findElement(By.name("productname")).sendKeys(PrdName);
					   driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();  */
					   
					 //validation of orgname i. mandatory field...............................................................................................
                       ValidateProduct validatePrd = new ValidateProduct(driver);
                      // validatePrd.ValidatePrd(driver, PrdName);//for if else statement
                      String actData = validatePrd.ValidatePrd(driver);
                      Assert.assertEquals(actData, PrdName);
                      System.out.println("product name is created");
					  /*			String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
						
						if(actData.contains(PrdName)) 
						{
							System.out.println("product name is created");
						}
						else
						{
							System.out.println("product name is not created");
							
						}     */
	}

}
