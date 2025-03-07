package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductLookUp {
	
	public ProductLookUp(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[alt=\"Create Product...\"]")
	private WebElement plusSign;
	
	//bussiness logic
	public void clickProductLookUp()
	{
		plusSign.click();
	}
	
	
	
	
	
	

}
