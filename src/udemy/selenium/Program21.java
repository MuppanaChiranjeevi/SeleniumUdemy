package udemy.selenium;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Program21 {
	/*
	 * FluentWait is a type of Explicit Wait in Selenium that gives you more control over waiting behavior.

		It allows you to:
		✅ Set a maximum wait time		
		✅ Define the polling frequency (how often Selenium checks the condition)
		✅ Ignore specific exceptions while waiting
	
	 * WebDriverWait actually extends FluentWait, but FluentWait gives more customization.
	 * All Implemented Interfaces: Wait<T>
	 * Direct Known Subclasses: WebDriverWait
	 *
	 * Each FluentWait instance defines the maximum amount of time to wait for a condition, as well as the frequency with which to check the condition. 
	 * Furthermore, the user may configure the wait to ignore specific types of exceptions whilst waiting, such as NoSuchElementExceptions when searching for an element on the page.
	 * 
	 * // Waiting 30 seconds for an element to be present on the page, checking for its presence once every 5 seconds.
	   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        .withTimeout(Duration.ofSeconds(30))        // Maximum wait time
        .pollingEvery(Duration.ofSeconds(5))        // Polling interval
        .ignoring(NoSuchElementException.class);    // Exception to ignore

		WebElement element = wait.until(new Function<WebDriver, WebElement>() { //Represents a function that accepts one argument and produces a result.
														 						  This is a functional interface whose functional method is apply(Object).
		    public WebElement apply(WebDriver driver) { 
		        return driver.findElement(By.id("exampleId"));
		    }
		});
	 * What Happens Internally?
	 * Selenium checks for the element. 
	 * If NoSuchElementException occurs → it ignores it.
	 * Waits 5 seconds.
	 * Tries again.
	 * Repeats until: Element is found, or 30 seconds timeout is reached.
	 * 
	 * Note:- Both WebDriverWait and FluentWait classes implement same Wait interface
	 *
	 */

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("div[id='start'] button")).click();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class);
		
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				if(driver.findElement(By.cssSelector("div[id='finish'] h4")).isDisplayed()) {
					return driver.findElement(By.cssSelector("div[id='finish'] h4"));
				}
				else {
					return null;
				}
			}
		});
		
		System.out.println("Test Passed: "+foo.getText());
		
	}

}
