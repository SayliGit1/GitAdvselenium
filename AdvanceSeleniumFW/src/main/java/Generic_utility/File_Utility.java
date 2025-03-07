package Generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {
	
	//this method is used to read data from properties file
	
	public String getCommonData(String key) throws Throwable {
	
FileInputStream fis = new FileInputStream("C:\\workspaces\\8 Aug 24\\AdvanceSeleniumFW\\src\\test\\resources\\vtiger.properties");
		
		Properties pro = new Properties();
		pro.load(fis);
		
		String Value = pro.getProperty(key);
		return Value;
	}

}
