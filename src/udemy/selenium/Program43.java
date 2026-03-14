package udemy.selenium;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program43 {
	
	public static void main(String[] args) throws IOException {
		
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
		
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys(course);
		
		//Taking WebElement Partial Screenshot with Selenium
		File source = name.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source, new File("element.png"));
		
		FileUtils.copyFile(source, new File("Screenshots\\element.png"));
		
		
		System.out.println(name.getRect().getDimension().getHeight());
		
		System.out.println(name.getRect().getDimension().getWidth());
		
		driver.quit();
		
	}

}
