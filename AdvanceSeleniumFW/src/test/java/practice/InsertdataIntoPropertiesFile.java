package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class InsertdataIntoPropertiesFile {

	public static void main(String[] args) throws Throwable {
  //optional line
  FileInputStream fis = new FileInputStream("C:\\workspaces\\8 Aug 24\\AdvanceSeleniumFW\\src\\test\\resources\\insertdata.properties");  //to read data
  Properties pro = new Properties();
  pro.setProperty("browser", "edge");
  pro.setProperty("url", "https://www.amazon.com");
  pro.setProperty("username", "sayli");
  
  //to inserting data into properties file sore in test/resourse folder
  FileOutputStream fos= new FileOutputStream("C:\\workspaces\\8 Aug 24\\AdvanceSeleniumFW\\src\\test\\resources\\insertdata.properties");
  pro.store(fos, "insertData");
  
  //to read data from properties file.....................................................................
  //if given in first line no need to write again
  //FileInputStream fis = new FileInputStream("C:\\workspaces\\8 Aug 24\\AdvanceSeleniumFW\\src\\test\\resources\\insertdata.properties");
  pro.load(fis);
  String BROWSER = pro.getProperty("broser");
  String URL = pro.getProperty("url");
  String USERNAME = pro.getProperty("username");
  System.out.println(URL);
  
	}

}
