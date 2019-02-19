package core;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import core.Config;

public class TestBase {
	public static WebDriver driver;
	
	@BeforeSuite
	public void BeforeSuite()
	{
		//initializing values from config
		try {
				Config.setpaths();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	
	@BeforeMethod
	public void BeforeMethod()
	{
		 System.setProperty(Config.webdrivername,Config.webdriverpath);
		  try {
		  if(Config.browser.equalsIgnoreCase("chrome"))
		  driver=new ChromeDriver();
		  else if(Config.browser.equalsIgnoreCase("firefox"))
			  driver=new FirefoxDriver();
		  else if(Config.browser.equalsIgnoreCase("ie"))
			  driver=new InternetExplorerDriver();
		  driver.manage().window().maximize();
		  driver.get(Config.url);
		  }
		  catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void AfterMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			System.out.println(result.getMethod());
			System.out.println(result.getThrowable());
			System.out.println(result.getStatus());
		}else if(result.getStatus()==ITestResult.FAILURE)
		{
			System.out.println(result.getMethod());
			System.out.println(result.getThrowable());
			System.out.println(result.getStatus());
		}
		if(result.getThrowable() !=null) {
			try {
				final Throwable testResultThrowable=result.getThrowable();
				System.out.println(testResultThrowable);
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
		
		driver.quit();
	}
}
