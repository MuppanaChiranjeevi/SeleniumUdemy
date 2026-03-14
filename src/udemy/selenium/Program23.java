package udemy.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Program23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.amazon.com/");
		Actions actions= new Actions(driver);
		WebElement searchBox =driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
		actions.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		//actions.moveToElement(searchBox).doubleClick().build().perform();
		actions.doubleClick(searchBox).perform();
		
		System.out.println("Test Passed");
		
		

	}

}
