package Organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM_Repo.POMFlipkart;

public class Flipkart {

	public static void main(String[] args) {

   WebDriver driver = new ChromeDriver();
   driver.manage().window().maximize();
   driver.get("https://www.flipkart.com/");
   
  POMFlipkart search = new POMFlipkart(driver);
  search.entervalue("books");
   
   
   
   
   
	}

}
