package udemy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Program12 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement checkbox =  driver.findElement(By.xpath("//input[contains(@id,'IndArm')]")); //CSS -->   input[id*='IndArm']
		Assert.assertFalse(checkbox.isSelected());
		checkbox.click();
		Assert.assertTrue(checkbox.isSelected());
		
		Assert.assertEquals(driver.findElements(By.xpath("//input[@type='checkbox']")).size(),6);
		System.out.println("Test Passed");

		driver.quit();
	}

}
