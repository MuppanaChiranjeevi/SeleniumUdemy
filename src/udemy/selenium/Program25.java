package udemy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Program25 {

	/*
	 * A frame is an HTML document embedded inside another HTML document using the <frame> or <iframe> tag.
	 * When a webpage contains frames, Selenium cannot directly interact with elements inside a frame 
	 * unless you switch the WebDriver’s focus to that frame first.
	 * By default, Selenium interacts with elements in the main page
	 * You can switch in three ways:
	 * 		Switch by Index -> driver.switchTo().frame(0); //Not recommended if frame order changes
	 * 		Switch by Name or ID -> driver.switchTo().frame("loginFrame"); //Works if the frame has a name or id attribute
	 * 		Switch by WebElement (Most Reliable) -> WebElement frameElement = driver.findElement(By.id("loginFrame"));
				 									driver.switchTo().frame(frameElement);
	 * Switching Back from Frame to Parent Frame -> driver.switchTo().parentFrame();
	 * Switching Back to Main Page (Default Content) -> driver.switchTo().defaultContent();
	 *
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		//Switch by Index
		//driver.switchTo().frame(0);
		
		//Switch by WebElement (Most Reliable)
		WebElement frameElement = driver.findElement(By.cssSelector("iframe.demo-frame"));
		driver.switchTo().frame(frameElement);
		
		WebElement source = driver.findElement(By.id("draggable"));
		
		WebElement target = driver.findElement(By.id("droppable"));
		
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();
		
		driver.switchTo().defaultContent(); //Switching Back to Main Page
		
		driver.findElement(By.name("s")).click();
		
		
		;

	}

}
