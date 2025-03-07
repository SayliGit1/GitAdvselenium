package practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToGetColorNameInAmazon {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.amazon.in");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone" , Keys.ENTER);
		
		List<WebElement> allColors = driver.findElements(By.xpath(
				"//span[text()='Apple iPhone 14 (128 GB) - Blue']/../../../..//div[@class='a-section a-spacing-none a-spacing-top-mini s-color-swatch-container-list-view']"));
		 
		 for (WebElement color : allColors)
		 {
			 System.out.println(color.getAttribute("arial-label"));
		 }
			
		}
	}


