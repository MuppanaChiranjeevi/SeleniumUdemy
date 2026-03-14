package udemy.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program2 {

	public static void main(String[] args) throws InterruptedException {
		
		 // Create a WebDriver object and launch the Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // Open the specified URL in the browser
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.id("inputUsername")).sendKeys("Chiru");
		
		//Stores that element in a WebElement variable called password	
		WebElement password = driver.findElement(By.name("inputPassword")); 
		password.sendKeys("hello123");
		
		driver.findElement(By.className("signInBtn")).click(); //You can only use one class (not multiple space-separated classes)
		
		String errorMsg = driver.findElement(By.cssSelector("p.error")).getText(); //console --> $('')
		System.out.println(errorMsg);
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Chiranjeevi"); // console --> $x('')
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("chiru@abc.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("chiru@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9123456780");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Chiranjeevi");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("#chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		driver.quit();
	}

}
