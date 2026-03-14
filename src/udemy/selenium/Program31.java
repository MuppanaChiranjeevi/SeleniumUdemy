package udemy.selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program31 {
	/*
	 * A broken link is a link (<a> tag) that does not work and returns an error HTTP status code instead of a successful response.
	 * In most automation testing, any response ≥ 400 is typically treated as a broken link.
	 * If a link does not return 200 OK, it is usually considered broken.
	 * Common broken link status codes:
			404 → Not Found
			500 → Internal Server Error
			403 → Forbidden
	 *
	 * HttpURLConnection connection1 = (HttpURLConnection) new URL(url).openConnection(); //URL deprecated since version 20
	 * 
	 * HttpURLConnection connection = (HttpURLConnection) new URI(url).toURL().openConnection();
	 * 
	 * Because HttpURLConnection provides:
			setRequestMethod()
			getResponseCode()
			getResponseMessage()
	 * HTTP status codes work like this:
			200–299 → Success
			300–399 → Redirection
			400–499 → Client error
			500–599 → Server error
	 */

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		
		 // Step 1: Provide the URL you want to test
		 String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href"); // *= → means "contains"
		 
		 System.out.println(url);
		 

         // 🔹 Step 2: Create URI object (validates the URL format)
         URI uri = new URI(url);

         // 🔹 Step 3: Convert URI to URL (required to open connection) -> because openConnection() exists in the URL class, Not in the URI class
         URL link = uri.toURL();

         // 🔹 Step 4: Open connection -> 
         //    Open connection returns URLConnection but we want HTTP-specific features -> (HttpURLConnection) This is type casting.
         HttpURLConnection connection = (HttpURLConnection) link.openConnection(); //URLConnection → HttpURLConnection

         // 🔹 Step 5: Set HTTP request method as HEAD
         // HEAD is faster because it only fetches headers, not full page content
         connection.setRequestMethod("HEAD");

         // 🔹 Step 6: Establish connection to server
         connection.connect();

         // 🔹 Step 7: Get HTTP response code
         int responseCode = connection.getResponseCode();
		
		System.out.println(responseCode);
		System.out.println(connection.getResponseMessage());
		/*
		 * String URL
			   ↓
			URI
			   ↓
			URL
			   ↓
			URLConnection
			   ↓ (casting)
			HttpURLConnection
			   ↓
			Set HEAD method
			   ↓
			Connect
			   ↓
			Get Response Code
		 */

	}

}
