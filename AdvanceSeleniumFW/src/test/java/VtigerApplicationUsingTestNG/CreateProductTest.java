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
import POM_Repo.CreateProductPage;
import POM_Repo.HomePage;
import POM_Repo.LoginPageEx;
import POM_Repo.ProductLookUp;
import POM_Repo.ValidateProduct;

public class CreateProductTest extends BaseClass {

        @Test(groups = "smoke")
		public void CreateProductTest() throws Throwable {
 //automation script........................................................................................................
		 WebDriver_utility wlib = new WebDriver_utility();
							
 //first add product..........................................................................................
	   	 HomePage home = new HomePage(driver);
		 home.clickprdtLink();
					
		 ProductLookUp prdLookUp = new ProductLookUp(driver);
		 prdLookUp.clickProductLookUp();
					   
//random approach..............................................................................................................
	     Java_utility jlib = new Java_utility();
	     int ranNum = jlib.getRandomValue();
					     
		 Excel_utility elib = new Excel_utility();
	     String PrdName = elib.getExcelData("product", 0, 0)+ranNum;
//add product name from excel sheet
		 CreateProductPage prdPage = new CreateProductPage(driver);
		 prdPage.enterprdName(PrdName);
		 prdPage.clicksaveButton();
						  
//validation of orgname i. mandatory field...............................................................................................
	     ValidateProduct validatePrd = new ValidateProduct(driver);
// validatePrd.ValidatePrd(driver, PrdName);
	     String actData = validatePrd.ValidatePrd(driver);
	     Assert.assertEquals(actData, PrdName);
	     System.out.println("product name is created");
					
		}

	}

