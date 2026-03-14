package udemy.selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program32 {
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
	 *
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

		String url = driver.findElement(By.cssSelector("a[href*='broken']")).getAttribute("href"); 
		
		System.out.println(url);

		HttpURLConnection connection = (HttpURLConnection) new URI(url).toURL().openConnection();

		connection.setRequestMethod("HEAD");

		connection.connect();

		System.out.println(connection.getResponseCode());

		System.out.println(connection.getResponseMessage());

	}

}
