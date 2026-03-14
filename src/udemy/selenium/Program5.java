package udemy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Program5 {

	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText()); 
		//button[text()='Practice']/following-sibling::button[1]
		//header/div/button[1]/following-sibling::button[1]
		driver.findElement(By.xpath("//button[text()='Practice']/parent::div/child::a/button")).click(); 

	}

}
