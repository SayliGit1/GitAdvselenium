package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_utility.BaseClass;
import Generic_utility.Excel_utility;
import Generic_utility.Java_utility;
import Generic_utility.WebDriver_utility;
import POM_Repo.CampLookUpImg;
import POM_Repo.CampvalidatePage;
import POM_Repo.CreatecampPage;
import POM_Repo.HomePage;

public class RetryAnalyserCamp {
	public class CreateCampaignTest extends BaseClass{
        
		  @Test(retryAnalyzer = Generic_utility.RetryAnalyserImp.class)
			public  void CreateCampaignTest() throws Throwable {

		       WebDriver_utility wlib = new WebDriver_utility();
			          
				HomePage home = new HomePage(driver);
				home.getMoreLink();
				home.ClickCampLink();
						 
				CampLookUpImg campLookUp = new CampLookUpImg(driver);
				campLookUp.ClickCampLookUpImg();
				 
				//fail the test script to check the retryanalyser concept
				Assert.fail("im failing the test script");
	//read data from excel sheet(champaign name).................................................................................... 
			    Java_utility jlib = new Java_utility();  //for random approach
			    int ranNum = jlib.getRandomValue();
				      
			     Excel_utility elib = new Excel_utility(); //from excel utility
			     String campName = elib.getExcelData("organization", 0, 0)+ranNum ;
			     System.out.println(campName);
				
				 CreatecampPage camp = new CreatecampPage(driver);
			     camp.entercampName(campName);
				 camp.clickSaveButton();
			
				 CampvalidatePage campValiate = new CampvalidatePage(driver);
				 //campValiate.ValidateCamp(driver, campName); //for if else condition
				   
				 //for using assert mentod 
				 String actData = campValiate.ValidateCamp(driver);  //for using assert method we made changes in campvalidatepage  
		         Assert.assertEquals(actData, campName);
		         System.out.println("campName is created");
				        

	//for logout.............................................................................................................................
				  home.logOut();   
				        	        
			}

	}
}
