package udemy.selenium;

import java.util.List;

import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Program36 {

	@Test
	public void greenKart() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.xpath("//table//th[1]")).click();

		List<WebElement> vegetableElements = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));

		List<String> price =  vegetableElements.stream().filter(f -> f.getText().equalsIgnoreCase("Beans"))
				.map(m -> m.findElement(By.xpath("following-sibling::td[1]")).getText()).collect(Collectors.toList());
		
		price.forEach(p->System.out.println(p));

	}
	
	
	/*
	 //tbody//td[1]/following-sibling::td[1]
	 
	 //tbody//td[1] → selects the first <td> of every <tbody> (any depth under tbody).
	 
	 /following-sibling::td[1] → selects the immediate next <td> sibling of that first <td>.
	 */
	

}
