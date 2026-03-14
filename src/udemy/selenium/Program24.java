package udemy.selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Program24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		Actions actions= new Actions(driver);
		actions.moveToElement(driver.findElement(By.className("blinkingText"))).click().build().perform();

		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> itr = windows.iterator();	
		String parent = itr.next();
		String child = itr.next();
		
		driver.switchTo().window(child);
		
		
		String para = driver.findElement(By.cssSelector(".im-para.red")).getText();
		String emailId = para.split(" ")[4];
		
		System.out.println(emailId);
		
		driver.switchTo().window(parent);

		driver.findElement(By.id("username")).sendKeys(emailId);
	}

}
