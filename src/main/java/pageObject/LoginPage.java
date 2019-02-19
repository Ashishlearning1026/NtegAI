package pageObject;

import org.openqa.selenium.By;

import core.TestBase;

public class LoginPage extends TestBase {

	public static void enterUsername(String UserName) {
	driver.findElement(By.xpath("//input[@name='userName']")).clear();
	driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(UserName);
}
	
	public static void enterPassword(String Password) {
		driver.findElement(By.xpath("//input[@name='password']")).clear();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
	}
	
	public static void clickSignIn() {
		driver.findElement(By.xpath("//input[@name='login']")).click();;
	}

	public static void findElement() {
		driver.findElement(By.xpath("//input[@name='loginfalse']")).click();;
		
	}
}
