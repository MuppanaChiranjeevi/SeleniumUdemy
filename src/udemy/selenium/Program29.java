package udemy.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Program29 {
	/**
	 * ChromeOptions is a class in Selenium that lets you customize and configure
	 * the behavior of the Chrome browser when launching it.
	 *
	 * Using ChromeOptions, you can:
	 *   - Start Chrome in headless mode (no GUI)
	 *   - Disable pop-ups, notifications, or extensions
	 *   - Set the browser window size
	 *   - Add custom Chrome arguments (e.g., "--incognito", "--disable-gpu")
	 *   - Set the path to a specific Chrome binary
	 *
	 * After configuring ChromeOptions, pass it to ChromeDriver so the browser
	 * starts with those settings.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://expired.badssl.com/");
		
		System.out.println(driver.getTitle());

	}

}
