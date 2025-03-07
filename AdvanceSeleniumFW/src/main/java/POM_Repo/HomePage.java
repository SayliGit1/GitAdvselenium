package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campLink;
	
	@FindBy(linkText = "Products")
	private WebElement prdtLink;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement admnLink;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getCampLink() {
		return campLink;
	}

	public WebElement getPrdtLink() {
		return prdtLink;
	}

	public WebElement getAdmnLink() {
		return admnLink;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	//bussiness logic
	public void clickorgLink()
	{
		orgLink.click();
	}
	
	public void ClickCampLink()
	{
		moreLink.click();
		campLink.click();
	}
	
	public void clickprdtLink()
	{
		prdtLink.click();
	}
	
	public void logOut()
	{
		admnLink.click();
		signOutLink.click();
	}
	
	
}
