package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProduct {

	public DeleteProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@value=\"Delete\"]")
	private WebElement deletePrd;
	
	public void SelectPrdCheckBox(WebDriver driver,String PrdName)
	{
		driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='"+PrdName+"']/../preceding-sibling::td//input[@type='checkbox']")).click();

	}
	
	public void ClickOnDeleteButton()
	{
		deletePrd.click();
	}
	
	public void ValidateDeletedPrd(WebDriver driver,String PrdName)
	{
 WebElement DeletedData = driver.findElement(By.xpath("//table[@class=\"lvt small\"]//a[text()='"+PrdName+"']"));
		 
		 if(DeletedData.equals(PrdName))
		 {
			System.out.println("product is deleted"); 
		 }
		 else
		 {
			 System.out.println("product is not deleted");
		 }
	}
	
	
	
	
	
}
