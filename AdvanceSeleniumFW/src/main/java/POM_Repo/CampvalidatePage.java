package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CampvalidatePage {

	//bussiness logic
	public CampvalidatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateCamp(WebDriver driver )
	{
	 String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
	 
/*	 if(actData.contains(campName)) 
	 {
		 System.out.println("campaign name is created");
	 }
	 else
	 {
		 System.out.println("campaign name is not created");
	 }    */
	 return actData;
	 
	     
}
}