package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidateProduct {
	
	public ValidateProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String ValidatePrd(WebDriver driver)
	{
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		
	/*	if(actData.contains(PrdName)) 
		{
			System.out.println("product name is created");
		}
		else
		{
			System.out.println("product name is not created");
			
		}   */
		return actData;

	}

}
