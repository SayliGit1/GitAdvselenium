package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatecampPage {
	
	public CreatecampPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="campaignname")
	private WebElement campName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	//getter method
	public WebElement getCampName() {
		return campName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//bussiness logic
	public void entercampName(String name)
	{
		campName.sendKeys(name);
	}
	
	public void clickSaveButton()
	{
		saveButton.click();
	}
}
