package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgPage {
	
	public CreateOrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgName;
	
	@FindBy(id="phone")
	private WebElement phoneNum;
	
	@FindBy(id = "email1")
	private WebElement emailId;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	//bussiness logic
	public void enterOrgDetails(String Name,String phnNum, String email)
	{
		orgName.sendKeys(Name);	
		phoneNum.sendKeys(phnNum);
		emailId.sendKeys(email);
	}
	
	
	public void clicksaveButton()
	{
		saveButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
