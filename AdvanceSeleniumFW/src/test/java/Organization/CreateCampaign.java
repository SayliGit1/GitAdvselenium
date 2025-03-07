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
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Generic_utility.Excel_utility;
import Generic_utility.File_Utility;
import Generic_utility.Java_utility;
import Generic_utility.WebDriver_utility;
import POM_Repo.CampLookUpImg;
import POM_Repo.CampvalidatePage;
import POM_Repo.CreatecampPage;
import POM_Repo.HomePage;
import POM_Repo.LoginPageEx;

public class CreateCampaign {

	public static void main(String[] args) throws Throwable {

//FileInputStream fis = new FileInputStream("C:\\workspaces\\8 Aug 24\\AdvanceSeleniumFW\\src\\test\\resources\\vtiger.properties");
		
	//	Properties pro = new Properties();
	//	pro.load(fis);
	//	String BROWSER = pro.getProperty("browser");
	//	String URL = pro.getProperty("url");
	//	String USERNAME = pro.getProperty("username");
	//	String PASSWORD = pro.getProperty("password");
		
		//from Fiel_utility
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
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  */
	WebDriver_utility wlib = new WebDriver_utility();
	wlib.maximizeWIndow(driver);
	wlib.loadTheElements(driver);
				
				driver.get(URL);
				
				//normal approach
		   /*   driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		        driver.findElement(By.id("submitButton")).click();  */
		        
		        //using getter methods
			/*	LoginPageEx login = new LoginPageEx(driver);
				login.getUserTextField().sendKeys(USERNAME);
				login.getPassWordTextField().sendKeys(PASSWORD);
				login.getLoginButton().click();   */
		        
				//using bussiness logic
				LoginPageEx login = new LoginPageEx(driver);
				login.loginToApp(USERNAME, PASSWORD);
				
		   /*   driver.findElement(By.linkText("More")).click();
		       driver.findElement(By.linkText("Campaigns")).click(); */
				HomePage home = new HomePage(driver);
				home.getMoreLink();
				home.ClickCampLink();
				
		     // driver.findElement(By.cssSelector("[title=\"Create Campaign...\"]")).click();   
				CampLookUpImg campLookUp = new CampLookUpImg(driver);
				campLookUp.ClickCampLookUpImg();
		       
		     //read data from excel sheet(champaign name)..............................................................................
		        
		        //random approach
		 /*       Random ran = new Random();
		       int ranNum = ran.nextInt(1000);
		    FileInputStream file= new FileInputStream("C:\\workspaces\\8 Aug 24\\AdvanceSeleniumFW\\src\\test\\resources\\excelsheet.xlsx");
		    
		    Workbook book = WorkbookFactory.create(file);
		    
		    //go to excel sheet
		   Sheet sheet = book.getSheet("champaigns");
		   Row row = sheet.getRow(0);
		   Cell cell = row.getCell(0);
		   String campName = cell.getStringCellValue()+ranNum;  */
		       
		      Java_utility jlib = new Java_utility();  //for random approach
		      int ranNum = jlib.getRandomValue();
		      
		      Excel_utility elib = new Excel_utility(); //from excel utility
			  String campName = elib.getExcelData("organization", 0, 0)+ranNum ;
			  System.out.println(campName);
		// driver.findElement(By.name("campaignname")).sendKeys(campName);
	    // driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			 CreatecampPage camp = new CreatecampPage(driver);
		     camp.entercampName(campName);
		     camp.clickSaveButton();
	   
	/*	 String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		 
		 if(actData.contains(campName)) 
		 {
			 System.out.println("campaign name is created");
		 }
		 else
		 {
			 System.out.println("campaign name is not created");
		 }        */
		   CampvalidatePage campValiate = new CampvalidatePage(driver);
		   //campValiate.ValidateCamp(driver, campName);//this is for if else condition
		   String actData = campValiate.ValidateCamp(driver);  //for using assert method we made changes in campvalidatepage  
           Assert.assertEquals(actData, campName);
           System.out.println("campName is created");
			//for logout.......................................................................................
		/*	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();        */
		   home.logOut();   
		        	        
	}

}
