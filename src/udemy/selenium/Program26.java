package udemy.selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program26 {
	/*
	 * // → Selects nodes anywhere in the document (at any depth). 
	 * * → Matches any element
	 * StaleElementReferenceException -> Selenium found the element earlier, but the DOM changed and that element is no longer attached to the page.
	 * Order of windows in a Set is not guaranteed
	 * If you want to switch back to the parent window, you should store its handle first:
	 * String parent = driver.getWindowHandle();
	 */

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		System.out.println("Total links: " + driver.findElements(By.tagName("a")).size());

		WebElement footer = driver.findElement(By.id("gf-BIG"));

		System.out.println("Links in Footer: " + footer.findElements(By.tagName("a")).size());

		// Find all <a> elements that are descendants (at any depth) of the element with id="gf-BIG".
		System.out.println("Links in Footer: " + footer.findElements(By.xpath("//*[@id='gf-BIG']//a")).size());

		WebElement column1 = footer.findElement(By.xpath(".//table/tbody/tr/td[1]/ul")); //The dot . means: “Search inside this element only
		
		List<WebElement> colLinks = column1.findElements(By.tagName("a"));

		System.out.println("Links in column: " + colLinks.size());
		
		String clickOnLink = Keys.chord(Keys.CONTROL,Keys.ENTER);

		for(int i=1;i<colLinks.size();i++) {
			colLinks.get(i).sendKeys(clickOnLink);
			
		}	
		
		 Thread.sleep(2000); // wait for tabs to open
        
		String parent = driver.getWindowHandle();
		
		Set<String> windows = driver.getWindowHandles(); //returns all open browser window IDs
		
		System.out.println("--------------------------------------------");
		
		//Switching Windows Using Iterator
		Iterator<String> itr = windows.iterator();
		
		while(itr.hasNext()) { //while loop runs as long as there is another window handle available.
			
			driver.switchTo().window(itr.next()); //itr.next() gets the next window ID.
			System.out.println(driver.getTitle());
		}
		
		System.out.println("--------------------------------------------");

		driver.switchTo().window(parent);
		//Switching Windows Using Enhanced For Loop
		for(String window : windows) {
		    driver.switchTo().window(window);
		    System.out.println(driver.getTitle());
		}
	}

}
