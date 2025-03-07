package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_utility.Excel_utility;
import Generic_utility.Java_utility;
import POM_Repo.OrgLookUp;

public class DataProviderEx2 {
	
/*	@Test(dataProvider ="readData")
	public void CreateOrganization()
	{
		WebDriver driver =  new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("user_password")).sendKeys("admin");
        driver.findElement(By.id("submitButton")).click();
        
        driver.findElement(By.linkText("Organizations")).click();
        driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click(); 
        
         Java_utility jlib = new Generic_utility.Java_utility();
		int ranNum = jlib.getRandomValue();
		driver.findElement(By.name("accountname")).sendKeys(name+ranNum);
		driver.findElement(By.name("phone")).sendKeys(phnNum);
		driver.findElement(By.name("email1")).sendKeys(mailId);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();
	}
       
     @DataProvider
     public Object[][] readData()
     {
    	Excel_utility elib = new Excel_utility();
    //	elib.readExcelDataForDataProvider("Dataprovider");
		return null; 
    	
     }*/
        
        
        
        
        
        
	

}
