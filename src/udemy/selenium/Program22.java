package udemy.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Program22 {
	/*
	 * Actions class is used to perform advanced user interactions—especially complex mouse and keyboard actions
	 * Some web elements require:
			Mouse hover
			Drag and drop
			Right click
			Double click
			Keyboard combinations (Ctrl, Shift, etc.)
			Click and hold
	 *
	 * Actions actions = new Actions(driver);
	 * perform() executes the action.
	 * build() is used to combine multiple actions before performing.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.amazon.com/");
		Actions actions= new Actions(driver); //Create Actions object
		WebElement accountList =driver.findElement(By.cssSelector("div#nav-link-accountList"));
		actions.moveToElement(accountList).perform();
		System.out.println(driver.findElement(By.cssSelector("div#nav-al-container")).isDisplayed());
		
		//actions.moveToElement(accountList).contextClick().build().perform();  //contextClick() – Right Click
		actions.contextClick(accountList).perform();
		
		System.out.println("Test Passed");
		
	}

}
