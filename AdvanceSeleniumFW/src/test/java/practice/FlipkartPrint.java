package practice;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartPrint {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.flipkart.com/");
		WebElement search = driver.findElement(By.xpath("//input[@class='Pke_EE']"));
		search.click();
		search.sendKeys("iphone13");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		 List<WebElement> names = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
		 
		 
		 for(WebElement name : names)
		 {
			 System.out.println(name.getText());
		 }
	
		
		
	}

}
