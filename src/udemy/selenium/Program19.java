package udemy.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Program19 {
	/*
	 * Here are the 5 main disadvantages of Implicit Wait in Selenium (Java):

		Global Scope – Applies to all findElement() calls, so you cannot control wait time for specific elements.
		
		Slows Down Execution – If an element is not present, Selenium waits the full timeout before throwing an exception.
		
		Not Condition-Based – Waits only for element presence in DOM, not for visibility, clickability, text, alerts, etc.
		
		Issues When Mixed with Explicit Wait – Can cause unpredictable and longer wait times.
		
		Limited Flexibility – No control over polling frequency or ignored exceptions (unlike Fluent/Explicit wait).
	 */




	public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.cssSelector("#start button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until "Hello World!" is visible
        WebElement helloText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("finish"))
        );

        System.out.println("Text displayed: " + helloText.getText());

        driver.quit();
    }
	

}
