package VtigerApplicationUsingTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_utility.BaseClass;
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

public class CreateCampaignAndAddproductTest extends BaseClass{
	
   @Test
	public void CreateCampaignAndAddproductTest() throws Throwable {

				   
				WebDriver_utility wlib = new WebDriver_utility();  //from webdriver utility 
				        //first add product....................................................................................
						HomePage home = new HomePage(driver);
						home.clickprdtLink();
				        ProductLookUpImg LookUp = new ProductLookUpImg(driver);
				        LookUp.prdLookUpImg();
	
					    //add product name from excel sheet ................................................................................................. */
				       Java_utility jlib = new Java_utility();
				       int ranNum = jlib.getRandomValue();
				       Excel_utility elib = new Excel_utility();
				       String PrdName = elib.getExcelData("product", 0, 0)+ranNum;
				       System.out.println(PrdName);
				       
				      CreateProductPage prdPage = new CreateProductPage(driver);
				      prdPage.enterprdName(PrdName);
				      prdPage.clicksaveButton(); 
			       
					   //now add campaign ................................................................................................................... 
				       home.ClickCampLink();
				       CampLookUpImg LookUp1 = new CampLookUpImg(driver);
				       LookUp1.ClickCampLookUpImg();
			
				       String campName = elib.getExcelData("champaigns", 0, 0)+ranNum;
					
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
					  //Validatecamp.ValidateCamp(driver, PrdName);
					   
					   //to use assert method
					   String actData = Validatecamp.ValidateCamp(driver);
						  Assert.assertEquals(actData, campName);
						  Assert.assertEquals(actData, PrdName);
					
					//for logout.......................................................................................
				    home.logOut();    
				        
}
}
