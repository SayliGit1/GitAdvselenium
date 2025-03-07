package Organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import Generic_utility.Excel_utility;
import Generic_utility.File_Utility;
import Generic_utility.Java_utility;
import Generic_utility.WebDriver_utility;
import POM_Repo.CreateOrgPage;
import POM_Repo.HomePage;
import POM_Repo.LoginPageEx;
import POM_Repo.OrgLookUp;
import POM_Repo.validateOrg;

public class CreateOrganization {

	public static void main(String[] args) throws Throwable {


	//	FileInputStream fis = new FileInputStream("C:\\workspaces\\8 Aug 24\\AdvanceSeleniumFW\\src\\test\\resources\\vtiger.properties");
		
	//	Properties pro = new Properties();
	//  pro.load(fis);
	//	String BROWSER = pro.getProperty("browser");
	//	String URL = pro.getProperty("url");
	//	String USERNAME = pro.getProperty("username");
	//	String PASSWORD = pro.getProperty("password");
		
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
			/*	driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));   */
		WebDriver_utility wlib = new WebDriver_utility();
		wlib.maximizeWIndow(driver);
		wlib.loadTheElements(driver);
				
				driver.get(URL);
				LoginPageEx login = new LoginPageEx(driver);
				login.loginToApp(USERNAME, PASSWORD);
		  /*    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		        driver.findElement(By.id("submitButton")).click();   */
		        
		        //click on organization
				HomePage home = new HomePage(driver);
				home.clickorgLink();
		   //   driver.findElement(By.linkText("Organizations")).click();
				OrgLookUp lookUp = new OrgLookUp(driver);
				lookUp.clickOrgLookUp();
		   //   driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();   
		       
	//read data from excel sheet(org name,phone,mailid)..............................................................................
		        
		        //random approach
		   //    Random ran = new Random();
		   //    int ranNum = ran.nextInt(1000);
		    Java_utility jlib = new Java_utility();  //from java utility
		    int ranNum = jlib.getRandomValue();
		    Excel_utility elib = new Excel_utility();
		        
		  //  FileInputStream file= new FileInputStream("C:\\workspaces\\8 Aug 24\\AdvanceSeleniumFW\\src\\test\\resources\\excelsheet.xlsx");
		    
		  //  Workbook book = WorkbookFactory.create(file);
		    
		    //go to excel sheet
		  /*   Sheet sheet = book.getSheet("organization");
		     Row row = sheet.getRow(0);
		     Cell cell = row.getCell(0);
		     String orgname = cell.getStringCellValue()+ranNum;
		     System.out.println(orgname);     */
		    
		     String orgname = elib.getExcelData("organization", 0, 0)+ranNum;
		//   driver.findElement(By.name("accountname")).sendKeys(orgname);
		  
		  //phone number..............................................................................................................
		/*    Row row1 = sheet.getRow(1);
	        Cell cell1 = row1.getCell(0);
		
		    DataFormatter format =new DataFormatter();
	    	String phnNum = format.formatCellValue(cell1);
	    	System.out.println(phnNum);        */
		     
		       String phnNum = elib.readDataUsingDataFormatter("organization", 1, 0);
	    	// driver.findElement(By.name("phone")).sendKeys(phnNum);
		
		//mailid........................................................................................................................
	    /*	Row row2 = sheet.getRow(2);
	    	Cell cell2 = row2.getCell(0);
		
	    	String mailid = cell2.getStringCellValue();
		    System.out.println(mailid);       */
	    	
	    	//String mailid = elib.getExcelData("organization", 2, 0)+ranNum;
	    	   //or we can use either dataformatter
	    	  String mailid = elib.readDataUsingDataFormatter("organization", 2, 0);
	    	  CreateOrgPage orgPage = new CreateOrgPage(driver);
	    	  orgPage.enterOrgDetails(orgname, phnNum, mailid);
	    	  orgPage.clicksaveButton();
	    //	  driver.findElement(By.id("email1")).sendKeys(mailid);
	    //	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//validation of orgname i. mandatory field.............................................................................................................................
	    	validateOrg validate = new validateOrg(driver);
	    	//validate.validateOrganization(driver, orgname);//for if else statement
	    	String actData = validate.validateOrganization(driver);
	    	  Assert.assertEquals(actData, orgname);
	    	  System.out.println("Organization is created");
	    	/*  String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		
	            	if(actData.contains(orgname)) 
	            	{
		        	System.out.println("organization is created");
		            }
	            	else
		            {
		        	System.out.println("organization is not created");
			
		            }     */
		
		//for logout.......................................................................................
	    	home.logOut();
	    /*	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	    	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();   */
			
		
	}

}
