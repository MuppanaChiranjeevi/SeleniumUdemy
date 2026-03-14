package udemy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Program14 {

	public static void main(String[] args) throws InterruptedException {
		// use CTRL+shift+F for code formatting

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		WebElement returnDate = driver.findElement(By.id("ctl00_mainContent_view_date2"));

//		System.out.println(returnDate.isEnabled()); // isEnabled() not working properly
//		returnDate.click();
//		System.out.println(returnDate.isEnabled());

		String beforeVal = driver.findElement(By.id("Div1")).getDomAttribute("style");
		System.out.println(beforeVal);

		returnDate.click();

		String afterVal = driver.findElement(By.id("Div1")).getDomAttribute("style");
		System.out.println(afterVal);

		Assert.assertTrue(afterVal.contains("1"));
		System.out.println("Test Passed");

	}

}
