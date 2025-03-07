package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProduct {
	
	public CreateProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="productname")
	private WebElement prdName;
	
	@FindBy(css = "[title=\"Save [Alt+S]\"]")
	private WebElement saveButton;
	
	//bussiness logic
	public void enterproductname(String name) 
	{
		prdName.sendKeys(name);
	}
	
	public void clicksaveButton() 
	{
		saveButton.click();
	}
	

}
