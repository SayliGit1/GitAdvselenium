package Organization;

import java.awt.Window;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
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
import POM_Repo.CreateProductPage;
import POM_Repo.CreatecampPage;
import POM_Repo.HomePage;
import POM_Repo.LoginPageEx;
import POM_Repo.ProductLookUpImg;
import POM_Repo.WindowSwitchingPage;

public class CreateCampaignAndAddProductToIt {

	public static void main(String[] args) throws Throwable {

// FileInputStream fis = new FileInputStream("C:\\workspaces\\8 Aug 24\\AdvanceSeleniumFW\\src\\test\\resources\\vtiger.properties");
		
	//	Properties pro = new Properties();
	//	pro.load(fis);
	//	String BROWSER = pro.getProperty("browser");
	//	String URL = pro.getProperty("url");
	//	String USERNAME = pro.getProperty("username");
	//	String PASSWORD = pro.getProperty("password");
		
		//from file_utility
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
			/*  driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); */
		WebDriver_utility wlib = new WebDriver_utility();  //from webdriver utility 
		wlib.maximizeWIndow(driver);
		wlib.loadTheElements(driver);
				
				driver.get(URL);
				LoginPageEx login = new LoginPageEx(driver);
				login.loginToApp(USERNAME, PASSWORD);
		 /*     driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		        driver.findElement(By.id("submitButton")).click(); */
		        //first add product....................................................................................
				HomePage home = new HomePage(driver);
				home.clickprdtLink();
		     // driver.findElement(By.linkText("Products")).click();
		        ProductLookUpImg LookUp = new ProductLookUpImg(driver);
		        LookUp.prdLookUpImg();
		    //  driver.findElement(By.cssSelector("[alt=\"Create Product...\"]")).click();
		        
	    /*    //random approach..........
		        Random ran = new Random();
		        int ranNum = ran.nextInt(1000);
		        
		        FileInputStream file= new FileInputStream("C:\\workspaces\\8 Aug 24\\AdvanceSeleniumFW\\src\\test\\resources\\excelsheet.xlsx");
			    
			    Workbook book = WorkbookFactory.create(file);
			    
			    //go to excel sheet
			   Sheet sheet = book.getSheet("product");
			   Row row = sheet.getRow(0);
			   Cell cell = row.getCell(0);
			   String PrdName = cell.getStringCellValue()+ranNum;
			    //add product name from excel sheet ................................................................................................. */
		       Java_utility jlib = new Java_utility();
		       int ranNum = jlib.getRandomValue();
		       Excel_utility elib = new Excel_utility();
		       String PrdName = elib.getExcelData("product", 0, 0)+ranNum;
		       System.out.println(PrdName);
		       
		      CreateProductPage prdPage = new CreateProductPage(driver);
		      prdPage.enterprdName(PrdName);
		      prdPage.clicksaveButton(); 
	        // driver.findElement(By.name("productname")).sendKeys(PrdName); 
	    	// driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
			   
			   //now add campaign ................................................................................................................... 
		       home.ClickCampLink();
		       CampLookUpImg LookUp1 = new CampLookUpImg(driver);
		       LookUp1.ClickCampLookUpImg();
		  /*   driver.findElement(By.linkText("More")).click();
		       driver.findElement(By.linkText("Campaigns")).click();
		       driver.findElement(By.cssSelector("[title=\"Create Campaign...\"]")).click();     */
		       
		       //step1-connecting to excel file ffor campaign
		/*     Sheet sheet1 = book.getSheet("champaigns");
			   Row row1 = sheet1.getRow(0);
			   Cell cell1 = row1.getCell(0);
			   String campName = cell1.getStringCellValue()+ranNum;    */
		       String campName = elib.getExcelData("champaigns", 0, 0)+ranNum;
			// System.out.println(campName);
		  //   driver.findElement(By.name("campaignname")).sendKeys(campName);
			  
			  //select product...........................................................................................................
			   WindowSwitchingPage window = new WindowSwitchingPage(driver);
			   window.clickPrdPlusSign();
			   CreatecampPage campPage = new CreatecampPage(driver);
			   campPage.entercampName(campName);
			   wlib.windowSwitching(driver, "Products&action");
			   window.enterPrdName(PrdName);
			   window.clickprdSearchBar();
			   window.selectPrdName(driver, PrdName);
			   
			   wlib.windowSwitching(driver, "Campaigns&action");
			   campPage.clickSaveButton();
			   
			   CampvalidatePage Validatecamp = new CampvalidatePage(driver);
			  // Validatecamp.ValidateCamp(driver, campName);
			 //  Validatecamp.ValidateCamp(driver, PrdName);
			  String actData = Validatecamp.ValidateCamp(driver);
			  Assert.assertEquals(actData, campName);
			  Assert.assertEquals(actData, PrdName);
		/*	   driver.findElement(By.cssSelector("[alt=\"Select\"]")).click();
			  
			  Thread.sleep(2000);
			  Set<String> allWins = driver.getWindowHandles();  //get all windows i.e win1,win2
			  Iterator<String> it = allWins.iterator();   //store all windows in variable
			 
			   while(it.hasNext()) {
				String win = it.next();
				driver.switchTo().window(win);
				String title = driver.getTitle();
				if(title.contains("Products&action"))
				{
					break;
				}
			 }
			 
			 //search the product we added................
			 driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(PrdName); //inspected search textbox
			 driver.findElement(By.name("search")).click();    //click on search now button
		       
			// driver.findElement(By.xpath("//a[text()='iphone761']")).click(); //it is static path for perticular product
			//we have to give dynamic path so that i can search any product that we have added
			 driver.findElement(By.xpath("//a[text()='"+PrdName+"']")).click();
			 
		    //switch driver control again to main window so use again iterator
			 Set<String> allWins1 = driver.getWindowHandles();  //get all windows i.e win1,win2
			 Iterator<String> it1 = allWins1.iterator();   //store all windows in variable
			 
			 while(it1.hasNext()) {
				String win1 = it1.next();
				driver.switchTo().window(win1);
				String title1 = driver.getTitle();
				if(title1.contains("Campaigns&action"))
				{
					break;
				}
			 }     */
			 
		//	 driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
			 	 
			//for logout.......................................................................................
	//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();        
		    home.logOut();    
		        
		        
	}

}
