package practice;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadingDataFromJsonFile {

	public static void main(String[] args) throws Throwable {

		File file = new File("C:\\workspaces\\8 Aug 24\\AdvanceSeleniumFW\\src\\test\\resources\\jsondata1.json"); //jsondata1 file from resource
		
		
		ObjectMapper obj = new ObjectMapper();
		  //JsonNode data = obj.readTree(file);
		JsonNode data = obj.readTree(file);  //check for file path
		 
		  String BROWSER = data.get("browser").asText();
		  String URL = data.get("url").asText();
		  String USERNAME = data.get("username").asText();
		  String PASSWORD = data.get("password").asText();
	
		 WebDriver driver;
			if( BROWSER.equalsIgnoreCase("chrome"))
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
			
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
			driver.findElement(By.id("user-name")).sendKeys(USERNAME);
			driver.findElement(By.id("password")).sendKeys(PASSWORD);
			driver.findElement(By.id("login-button")).click();
			
	}

}
