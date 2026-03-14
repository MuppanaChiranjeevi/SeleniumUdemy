package udemy.selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program41 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		// Get Parent Window ID
        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent ID: " + parentWindow);
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		//driver.switchTo().newWindow(WindowType.WINDOW);
		
		// Get all window handles
        Set<String> allWindows = driver.getWindowHandles();

        String childWindow = "";

        // Find Child Window ID
        for (String window : allWindows) {

            if (!window.equals(parentWindow)) {
                childWindow = window;
            }
        }

        System.out.println("Child ID: " + childWindow);
		
        // Switch to Child Window
        driver.switchTo().window(childWindow);	
		
		driver.get("https://courses.rahulshettyacademy.com/");
		
		String course = driver.findElement(By.xpath("(//h3[@class='featured-product-card__content__title'])[2]")).getText();
		
		driver.switchTo().window(parentWindow);
		
		driver.findElement(By.name("name")).sendKeys(course);
		
		driver.close();
		//driver.quit();
	}

}
