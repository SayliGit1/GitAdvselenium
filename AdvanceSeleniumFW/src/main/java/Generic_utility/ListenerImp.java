package Generic_utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

//listener-listerner is a fature availabel in TestNG which is used to capture
//runtime events during the execution and perform appropriate action based on eventtype

public class ListenerImp implements ITestListener {
	
	public void onTestFailure(ITestResult result) {
		 TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		 File source = ts.getScreenshotAs(OutputType.FILE);
		 File destination = new File("./FailedScripts.png");
		 
		 try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
//impliments this VtigerApplicationUsingTestNG>CreateProductTest.java....check the result in test-output class