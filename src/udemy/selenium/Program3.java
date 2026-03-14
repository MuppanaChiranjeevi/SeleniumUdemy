package udemy.selenium;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Program3 {
	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        
	        // Open the specified URL in the browser
	        driver.get("https://rahulshettyacademy.com/locatorspractice/");
			
	        String name ="Chiranjeevi";
			driver.findElement(By.id("inputUsername")).sendKeys(name);
			
			//Stores that element in a WebElement variable called password	
			WebElement password = driver.findElement(By.name("inputPassword")); 
			password.sendKeys("rahulshettyacademy");
			
			driver.findElement(By.className("signInBtn")).click();
			Thread.sleep(1000);
			
			String msg = driver.findElement(By.tagName("p")).getText();
			System.out.println(msg);
			
			Assert.assertEquals(msg, "You are successfully logged in.");
			
			Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+name+",");
			
			driver.findElement(By.xpath("//*[text()='Log Out']")).click();
			
			driver.quit();
			System.out.println("Test Passed");
			
	}

}
