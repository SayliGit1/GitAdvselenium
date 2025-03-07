package Generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


public class BaseClass {

    public WebDriver driver;
    public static WebDriver sdriver;
	@BeforeSuite(groups = {"smoke" ,"regression"})
	public void BS()
	{
		System.out.println("Database Connection is created");
	}
	
	@BeforeTest(groups = {"smoke" ,"regression"})
	public void BT()
	{
		System.out.println("Parallel execution");
	}
	
	@BeforeClass(groups = {"smoke" ,"regression"})
	public void BC() throws Throwable
	{
		
		File_Utility flib = new File_Utility();
		//String BROWSER = flib.getCommonData("browser");
		String BROWSER = System.getProperty("browser");
		if(BROWSER.equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge")) 
		{
			driver = new EdgeDriver();
		}
		
		else 
		{
			driver = new ChromeDriver();
		}
		System.out.println("Launch the browser");
		sdriver=driver;
	}
	
	@BeforeMethod(groups = {"smoke" ,"regression"})
	public void BM() throws Throwable
	{
		WebDriver_utility wlib = new WebDriver_utility();
		wlib.maximizeWIndow(driver);
		wlib.loadTheElements(driver);
		
		File_Utility flib = new File_Utility();
		//String URL = flib.getCommonData("url");
		String URL = System.getProperty("url");
		//String USERNAME = flib.getCommonData("username");
		String USERNAME = System.getProperty("username");
		//String PASSWORD = flib.getCommonData("password");
		String PASSWORD = System.getProperty("password");
		driver.get(URL);
		
		//using bussiness logic
		LoginPageEx login = new LoginPageEx(driver);
		login.loginToApp(USERNAME, PASSWORD);
		System.out.println("Login to application");
	}
	
	@AfterMethod(groups = {"smoke" ,"regression"})
	public void AM()
	{
		HomePage home = new HomePage(driver);
        home.logOut();
        System.out.println("Logout from application");
	}
	
	@AfterClass(groups = {"smoke" ,"regression"})
	public void AC()
	{
		driver.quit();
		System.out.println("close the browser");
	}
	
	@AfterTest(groups = {"smoke" ,"regression"})
	public void AT()
	{
		System.out.println("parallel execution is ended");	
	}
	
	@AfterSuite(groups = {"smoke" ,"regression"})
	public void AS()
	{
		System.out.println("Database Connection is terminated");
	}
	
}
