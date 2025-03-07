package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class validateOrg {

	public validateOrg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateOrganization(WebDriver driver )
	{
		 String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
			
  /*    	if(actData.contains(name)) 
      	{
      	System.out.println("organization is created");
          }
      	else
          {
      	System.out.println("organization is not created");
	
          }   */

		 return actData;
	}
	
	
	
	
}
