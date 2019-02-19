package tesCases;

import java.util.NoSuchElementException;

import org.testng.annotations.Test;

import core.TestBase;
import pageObject.LoginPage;

public class Login extends TestBase {
	
	@Test
	public static void TestLoginSuccess()
	{
		LoginPage.enterUsername("Ashish.Chander");
		LoginPage.enterPassword("Passw0rd");
		LoginPage.clickSignIn();
		
	}
	
	@Test
	public static void TestCaseFailForWithoutCatch(){
		LoginPage.findElement();
	}
	
	@Test
	public static void TestCaseFailWithTryCatch()
	{
		try {
		LoginPage.findElement();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	@Test
	public static void TestCaseFailWithThrow() throws NoSuchElementException
	{
		LoginPage.findElement();
	}
	
	@Test
	public static void TestCaseFailWithExtentReport()
	{
		
	}
}
