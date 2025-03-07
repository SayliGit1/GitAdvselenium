package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FetchdataFrompropertiesFile {

	public static void main(String[] args) throws Throwable {

        //step 1-get path ot the properties file 
		//FileInputStream fis = new FileInputStream("C:\\Users\\ROCKSTAR SALES\\Desktop\\properties.properties");  //fread data from desktop
	
		//read data from file pasted in test/resourse
		 FileInputStream fis = new  FileInputStream("C:\\workspaces\\8 Aug 24\\AdvanceSeleniumFW\\src\\test\\resources\\properties.properties");
		//step2-
		Properties prop = new Properties();
		
		prop.load(fis);
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("userName");
		String PASSWORD = prop.getProperty("Password");
		
		WebDriver driver;
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
		
		
		//automation script
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(URL);
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		
	}

}
