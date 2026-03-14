package udemy.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program18 {
	/*
	 * WAITS IN SELENIUM (JAVA)
	 *
	 * In Selenium, waits are used to handle synchronization issues.
	 * They help the script wait for elements or specific conditions before performing actions.
	 *
	 * This is important because modern web applications load dynamically(AJAX calls, animations, delayed rendering, etc.).
	 *
	 * Without proper waits, you may encounter:
	 *  - NoSuchElementException
	 *  - ElementNotInteractableException
	 *  - TimeoutException
	 *
	 * ------------------------------------------------------------
	 * TYPES OF WAITS IN SELENIUM
	 * ------------------------------------------------------------
	 *
	 * 1) Implicit Wait
	 * -----------------
	 * - Implicit Wait tells Selenium WebDriver to wait a specified amount of time when trying to find an element if it is not immediately available in the DOM
	 * - Applied globally to all findElement() calls.
	 * - If the element is not found immediately, WebDriver polls the DOM until the timeout is reached.
	 * - Waits only for presence of the element in the DOM, not visibility or clickability.
	 *
	 * 2) Explicit Wait
	 * -----------------
	 * - Explicit Wait tells Selenium WebDriver to wait for a specific condition before performing an action, with a maximum timeout. 
	 * - It is element-specific, not global.
	 * - Implemented using WebDriverWait and ExpectedConditions.
	 * - More controlled and condition-based.
	 * - More reliable for dynamic web applications, e.g., AJAX loaders, spinners, or buttons appearing later.
	 *
	 *
	 * 3) Fluent Wait
	 * -----------------
	 * - Advanced form of Explicit Wait.
	 * - Allows:
	 *      * Custom timeout
	 *      * Custom polling frequency
	 *      * Ignoring specific exceptions
	 * - Useful for complex synchronization scenarios.
	 *
	 *
	 * NOTE:
	 * - Avoid mixing Implicit and Explicit waits.
	 * - Avoid using Thread.sleep() (not dynamic and slows execution).
	 */




	    public static void main(String[] args) {

	        WebDriver driver = new ChromeDriver();

	        // Global implicit wait
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        driver.get("https://the-internet.herokuapp.com/login");

	        // Locate elements
	        driver.findElement(By.id("username")).sendKeys("tomsmith");
	        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
	        driver.findElement(By.cssSelector("button[type='submit']")).click();

	        // Verify successful login
	        String message = driver.findElement(By.id("flash")).getText();
	        System.out.println(message);

	        //driver.quit();
	    }
	

}
