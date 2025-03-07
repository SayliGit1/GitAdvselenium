package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class InsertAndreadDataFrom {

	public static void main(String[] args) throws Throwable {

Properties pro = new Properties();
pro.setProperty("browser", "chrome");
pro.setProperty("url", "https://flipkart.com");

FileOutputStream fos = new FileOutputStream("C:\\workspaces\\8 Aug 24\\AdvanceSeleniumFW\\src\\test\\resources\\InsertAndReadData.properties");
pro.store(fos, "InsertAndReadData");

FileInputStream fis =new FileInputStream("C:\\\\workspaces\\\\8 Aug 24\\\\AdvanceSeleniumFW\\\\src\\\\test\\\\resources\\\\InsertAndReadData.properties");
pro.load(fis);
String BROWSER = pro.getProperty("browser");
String URL = pro.getProperty("url");

System.out.println(BROWSER);
System.out.println(URL);
	}

}
