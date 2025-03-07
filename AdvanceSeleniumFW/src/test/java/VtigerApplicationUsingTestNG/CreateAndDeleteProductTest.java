package VtigerApplicationUsingTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_utility.BaseClass;
import Generic_utility.Excel_utility;
import Generic_utility.File_Utility;
import Generic_utility.Java_utility;
import Generic_utility.WebDriver_utility;
import POM_Repo.CreateProductPage;
import POM_Repo.DeleteProduct;
import POM_Repo.HomePage;
import POM_Repo.LoginPageEx;
import POM_Repo.ProductLookUp;

@Listeners(Generic_utility.ListenerImp2.class)
public class CreateAndDeleteProductTest extends BaseClass{
     @Test
	public void CreateAndDeleteProductTest() throws Throwable {

				WebDriver_utility wlib = new WebDriver_utility();
						
				        //first add product....................................................................................................
					    HomePage home = new HomePage(driver);
					    home.clickprdtLink(); 
					    ProductLookUp prdLookUp = new ProductLookUp(driver);
					    prdLookUp.clickProductLookUp();
			
				        Java_utility jlib = new Java_utility();
				        Excel_utility elib = new Excel_utility();
				        int ranNum = jlib.getRandomValue();
					       
				         String PrdName = elib.getExcelData("product", 0, 0)+ranNum;
				       
					   System.out.println(PrdName);
					   
					   //add product name from excel sheet
					   CreateProductPage prdPage = new CreateProductPage(driver);
						  prdPage.enterprdName(PrdName);
						  prdPage.clicksaveButton();
						  
						  //force to stop the execution
						  Assert.fail("im failing the test scripts");
		                 home.clickprdtLink();
		                DeleteProduct deletePrd = new DeleteProduct(driver);
		                deletePrd.SelectPrdCheckBox(driver, PrdName);
		                deletePrd.ClickOnDeleteButton();
		                wlib.alertAccept(driver);
		                deletePrd.ValidateDeletedPrd(driver, PrdName);
       Thread.sleep(2000);
	   home.logOut();
					   
			}

		}

