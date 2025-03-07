package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampLookUpImg {

	public CampLookUpImg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title=\"Create Campaign...\"]")
	private WebElement lookUpimg;
	
    //getter method
	public WebElement getLookUpimg() {
		return lookUpimg;
	}
	
	//bussiness logic
	public void ClickCampLookUpImg()
	{
		lookUpimg.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
