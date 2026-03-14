package udemy.selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Program33 {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");

		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li']>a")); // > a (direct child <a>
																								// element)
		System.out.println("Total Links: "+links.size());
		for (WebElement link : links) {
			
			String url = link.getAttribute("href");

			HttpURLConnection connection = (HttpURLConnection) new URI(url).toURL().openConnection();

			connection.setRequestMethod("HEAD");

			connection.connect();

			int responseCode = connection.getResponseCode();
			
			System.out.println(link.getText()+ " : "+responseCode);
			
			// Hard assertion
		    Assert.assertFalse(responseCode>400, "The link with text \""+link.getText()+"\" is broken with code "+responseCode);
			

			
		}
		
		System.out.println("Test Completed");

	}

}
