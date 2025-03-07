package VtigerApplicationUsingTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_utility.BaseClass;
import Generic_utility.Excel_utility;
import Generic_utility.Java_utility;
import Generic_utility.WebDriver_utility;
import POM_Repo.CampLookUpImg;
import POM_Repo.CampvalidatePage;
import POM_Repo.CreateOrgPage;
import POM_Repo.CreatecampPage;
import POM_Repo.HomePage;
import POM_Repo.OrgLookUp;
import POM_Repo.validateOrg;

public class RegionalRegressionTesting extends BaseClass{
	@Test
	public void  RegionalRegressionTesting() throws Throwable {
			
					WebDriver_utility wlib = new WebDriver_utility();        
			        //click on organization
					HomePage home = new HomePage(driver);
					home.clickorgLink();
					OrgLookUp lookUp = new OrgLookUp(driver);
					lookUp.clickOrgLookUp();		       
	//read data from excel sheet(org name,phone,mailid)..............................................................................
			    Java_utility jlib = new Java_utility();  //from java utility
			    int ranNum = jlib.getRandomValue();
			    Excel_utility elib = new Excel_utility();
			    
			     String orgname = elib.getExcelData("organization", 0, 0)+ranNum;
			  
	 //phone number.............................................................................................................
			       String phnNum = elib.readDataUsingDataFormatter("organization", 1, 0);
			
	//mailid........................................................................................................................
		    	  String mailid = elib.readDataUsingDataFormatter("organization", 2, 0);
		    	  CreateOrgPage orgPage = new CreateOrgPage(driver);
		    	  orgPage.enterOrgDetails(orgname, phnNum, mailid);
		    	  orgPage.clicksaveButton();
			
	//validation of orgname i. mandatory field.............................................................................................................................
		    	validateOrg validate = new validateOrg(driver);
		    	//validate.validateOrganization(driver, orgname);
		    	String actData = validate.validateOrganization(driver);
		    	  Assert.assertEquals(actData, orgname);
		    	  System.out.println("Organization is created");
	//for logout.......................................................................................
		    	home.logOut();
		        driver.quit();
	}
//create camp==================================================================================================================
	
	 @Test
		public  void CreateCampaignTest() throws Throwable {

	        	WebDriver_utility wlib = new WebDriver_utility();
		          
					HomePage home = new HomePage(driver);
					home.getMoreLink();
					home.ClickCampLink();
					 
					CampLookUpImg campLookUp = new CampLookUpImg(driver);
					campLookUp.ClickCampLookUpImg();
			    
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
			   //campValiate.ValidateCamp(driver, campName);
			   String actData = campValiate.ValidateCamp(driver);  //for using assert method we made changes in campvalidatepage  
	           Assert.assertEquals(actData, campName);
	           System.out.println("campName is created");
			        

//for logout.............................................................................................................................
			   home.logOut();   
			   driver.quit();    	        
		}
//add 3 method=======================================================================================================================
	 @Test
	 public void m3()
	 {
		 System.out.println("checking for regional regression in TestNG");
	 }
}
