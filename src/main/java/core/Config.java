package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	
	public static String url; 
	public static String webdrivername;  
	public static String webdriverpath;
	public static String browser;
	public static void setpaths() throws IOException
	{
		//Setting up properties to read data from the config file
		Properties prop= new Properties();
		InputStream is= new FileInputStream(System.getProperty("user.dir")+"\\resources\\config\\config.properties");
		prop.load(is);
		
		//Initializaing values for all the variables to be used while testing
		url=prop.getProperty("URL");
		browser=prop.getProperty("Browser").toLowerCase();
		if(browser.equalsIgnoreCase("chrome"))
		{
			webdrivername="webdriver.chrome.driver";
			webdriverpath=System.getProperty("user.dir")+"\\resources\\driver\\chromedriver.exe";
		}
		
		else if(prop.getProperty("Browser").equalsIgnoreCase("firefox"))
		{
			webdrivername="webdriver.gecko.driver";
			webdriverpath=System.getProperty("user.dir")+"\\resources\\driver\\geckodriver.exe";
		}
		else if(prop.getProperty("Browser").equalsIgnoreCase("IE"))
		{
			webdrivername="webdriver.ie.driver";
			webdriverpath=System.getProperty("user.dir")+"\\resources\\driver\\IEDriverServer.exe";
		}
		else
		{
			webdrivername="webdriver.chrome.driver";
			webdriverpath=System.getProperty("user.dir")+"\\resources\\driver\\chromedriver.exe";
			browser="chrome";
		}
	}
}