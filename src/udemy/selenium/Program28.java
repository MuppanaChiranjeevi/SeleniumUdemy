package udemy.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Program28 {
	/*
	 *  window → The browser window object.

		scrollBy(x, y) → Scrolls the document by a specified number of pixels.
		
		x = horizontal movement (left/right)
		
		y = vertical movement (up/down)
		
		window.scrollBy(0, 500); // 0 → No horizontal scrolling & 500 → Scroll down 500 pixels
		window.scrollBy(0, -500); // scroll up 500 pixels.
		
		scrollBy() → Moves relative to the current scroll position
		scrollTo() → Moves to an exact position
		
		In JavaScript (in a browser), document represents the entire web page loaded in the browser.
		document object gives JavaScript access to that page.
		
		window → Represents the browser window
		document → Represents the web page loaded inside that window
		
		document.querySelector('.tableFixHead').scrollTop = 200;
		.scrollTop -> A property that controls the vertical scroll position inside an element (Measured in pixels.)
		
		window.scrollBy() → Scrolls the entire webpage.

		element.scrollTop → scroll inside a specific scrollable container, not the whole page.
	 */
	/*
	 *  //td[4] (XPath) -> Every <td> element that is the 4th <td> among its <td> siblings. It counts only <td> elements.
	 *  td:nth-child(4) (CSS) -> Every <td> element that is the 4th child element of its parent, regardless of type. It counts all element types, not just <td>.
	 */

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,600)");
		
		Thread.sleep(2000);
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=200");

		List<WebElement> amounts = driver.findElements(By.cssSelector("#product td:nth-child(4)"));
		int sum =0;
		for(int i=0; i<amounts.size();i++) {
			sum = sum + Integer.parseInt(amounts.get(i).getText());
		}
		
		System.out.println(sum);
		
		String actaulStr = driver.findElement(By.cssSelector(".totalAmount")).getText();
		System.out.println(actaulStr);
		
		int expected = Integer.parseInt(actaulStr.split(":")[1].strip());
		System.out.println(expected);
		Assert.assertEquals(sum, expected);
		System.out.println("Test Passed");
	}

}
