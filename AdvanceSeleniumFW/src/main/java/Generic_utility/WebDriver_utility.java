package Generic_utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WebDriver_utility {
	
	//this method is used to maximixe the window
	public void maximizeWIndow(WebDriver driver) 
	{
		driver.manage().window().maximize();
		
	}
//.......................................................................................................................................
	
	//this ethod is used to wait for all the elements to get loaded
	public void loadTheElements(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}
	
	
	
	public void windowSwitching(WebDriver driver,String partialTitle)
	{
		 Set<String> allWins = driver.getWindowHandles();  //get all windows i.e win1,win2
		   Iterator<String> it = allWins.iterator();   //store all windows in variable
		 
		   while(it.hasNext()) {
			String win = it.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
			if(title.contains(partialTitle))
			{
				break;
			}
		    }

	}
	
	public void alertAccept(WebDriver driver)
	{
	driver.switchTo().alert().accept();	
	}
}
