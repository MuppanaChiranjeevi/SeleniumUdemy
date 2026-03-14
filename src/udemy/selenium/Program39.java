package udemy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;


public class Program39 {
	/*
	 * Relative Locators (introduced in Selenium 4) allow you to locate elements based on their position relative to another element
	 */

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement email = driver.findElement(By.name("email"));
		
		System.out.println(driver.findElement(with(By.tagName("label")).above(email)).getText()); //Find the label above the email input.

		WebElement DOB = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		
		driver.findElement(with(By.className("btn-success")).below(DOB)).click();
		
		WebElement IceCreamsLabel = driver.findElement(By.xpath("//*[@for='exampleCheck1']"));
		
		driver.findElement(with(By.cssSelector("[class='form-check-input']")).toLeftOf(IceCreamsLabel)).click();
		
		WebElement eStatusLabel = driver.findElement(By.xpath("//label[@for='exampleFormControlRadio1']"));
		
		driver.findElement(with(By.xpath("//input[@class='form-check-input']")).toRightOf(eStatusLabel)).click();
	}
	
}
