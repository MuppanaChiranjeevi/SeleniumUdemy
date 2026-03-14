import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Program1 {

	public static void main(String[] args) {
		
		WebDriver driver;
		
		//Selenium Manager (Selenium 4+) automatically downloads and configures chromedriver for you
		
		//driver =new ChromeDriver(); //Launches a new Chrome browser window
		
		//driver =new FirefoxDriver(); //Launches a new Firefox browser window
		
		driver =new EdgeDriver(); //Launches a new edge browser window

		System.out.println("Chrome Browser Invoked");
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		
		// driver.quit();  // closes ALL windows and ends the WebDriver session
		
		driver.close(); // closes current window only, WebDriver session may still exist

		// Close the current window, quitting the browser if it's the last window currently open.
		//If that window is the only open window, the browser session ends and the browser quits.
		// Use driver.quit() instead of close() for automation best practice
		

	}

}
