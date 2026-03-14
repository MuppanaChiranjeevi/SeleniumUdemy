package udemy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program11 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement checkbox =  driver.findElement(By.cssSelector("input[id*='IndArm']")); //Xpath -->  //input[contains(@id,'IndArm')]
		System.out.println(checkbox.isSelected());
		checkbox.click();
		System.out.println(checkbox.isSelected());
		
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

	}

}
