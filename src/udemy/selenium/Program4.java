package udemy.selenium;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Program4 {

	public static void main(String[] args) throws InterruptedException {
		//WebDriver driver = new ChromeDriver();
		//WebDriver driver = new EdgeDriver();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // Open the specified URL in the browser
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        String passowrd = getPassword(driver);
        
        String name ="Chiranjeevi";
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		
		//Stores that element in a WebElement variable called password	
		driver.findElement(By.name("inputPassword")).sendKeys(passowrd);
		
		Thread.sleep(1000);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(1000);
		String msg = driver.findElement(By.tagName("p")).getText();
		System.out.println(msg);
		
		Assert.assertEquals(msg, "You are successfully logged in.");
		
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		
		driver.quit();
		System.out.println("Test Passed");
		

	}

	public static String  getPassword(WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String[] passowrdArray = driver.findElement(By.cssSelector("form p")).getText().split("'");
		
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		return passowrdArray[1];
		
	}

}
