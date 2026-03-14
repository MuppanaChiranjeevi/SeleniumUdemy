package udemy.selenium;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Program38 {

	@Test
	public void greenKart() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table/tbody/tr")));

		driver.findElement(By.cssSelector("#search-field")).sendKeys("an");

		
		List<WebElement> vegetableElements = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));

		List<WebElement> filteredElements = vegetableElements.stream().filter(f->f.getText().contains("an")).collect(Collectors.toList());
		
		Assert.assertEquals(filteredElements.size(), vegetableElements.size());
		
		// simply in one line 
		Assert.assertTrue(vegetableElements.stream().allMatch(e -> e.getText().toLowerCase().contains("an")));
		
		filteredElements.forEach(e->System.out.println(e.getText()));
		

}
	/*
	 * It checks ALL elements in this stream satisfy a given condition
	 * It returns a boolean:
	 * true → if every element matches the condition
	 * false → if at least one element does NOT match
	 * 
	 * If any element returns false → it stops immediately (short-circuit)
	 * allMatch()	All elements must satisfy condition
	 * anyMatch()	At least one element must satisfy
	 */

}
