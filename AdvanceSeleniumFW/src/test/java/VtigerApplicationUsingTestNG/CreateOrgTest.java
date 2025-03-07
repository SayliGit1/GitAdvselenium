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
import POM_Repo.CreateOrgPage;
import POM_Repo.HomePage;
import POM_Repo.LoginPageEx;
import POM_Repo.OrgLookUp;
import POM_Repo.validateOrg;

public class CreateOrgTest extends BaseClass {
	
@Test(groups = {"smoke","regression"})
public void  CreateOrgTest() throws Throwable {
		
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
	    //validate.validateOrganization(driver, orgname);//for if else statement
	    //for assert method we use this
	    String actData = validate.validateOrganization(driver);
	    Assert.assertEquals(actData, orgname);
	    System.out.println("Organization is created");
	    	
//for logout.......................................................................................
	    home.logOut();
	    
			
		
	}

}

