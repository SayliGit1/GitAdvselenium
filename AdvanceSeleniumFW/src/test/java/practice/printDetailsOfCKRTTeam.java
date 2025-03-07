package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class printDetailsOfCKRTTeam {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.prokabaddi.com/standings");
		driver.findElement(By.xpath("//button[@aria-label='Close']")).click();  //close notification bar
		
		 String MatchesWon = driver.findElement(By.xpath("//p[text()='Haryana Steelers']/ancestor::div[@class='row-head']//div[@class='table-data matches-won']")).getText();
		System.out.println("matches won: "+ MatchesWon);
		
		 String MatchesLose = driver.findElement(By.xpath("//p[text()='Haryana Steelers']/ancestor::div[@class='row-head']//div[@class='table-data matches-lost']")).getText();
		System.out.println("matches loss: "+MatchesLose);
		
		String point = driver.findElement(By.xpath("//p[text()='Haryana Steelers']/ancestor::div[@class='row-head']//div[@class='table-data points']")).getText();
	    System.out.println("total points: "+ point);
	}

}
