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
import org.testng.annotations.Test;

public class Program37 {

	@Test
	public void greenKart() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table/tbody/tr")));

		driver.findElement(By.xpath("//table//th[1]")).click();

		List<WebElement> vegetableElements = null;
		
		List<String> price = null;
		
		do {
		vegetableElements = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));

		price =  vegetableElements.stream().filter(f -> f.getText().equalsIgnoreCase("Strawberry"))
				.map(m -> m.findElement(By.xpath("following-sibling::td[1]")).getText()).collect(Collectors.toList());
		
		if(price.size()>0) {
			price.forEach(p->System.out.println(p));
			break;
		}
		else {
		
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		}
		
		}while(true);

	}
	
	
	
	

}
