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
import org.testng.asserts.SoftAssert;

public class Program34 {
	/*
	 * HTTP status codes work like this:
			200–299 → Success
			300–399 → Redirection
			400–499 → Client error
			500–599 → Server error
			
	 * Connect timeout → time to establish connection
	 * Read timeout → time to wait for server response
	 *
	 */

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");

		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li']>a")); // > a (direct child <a> element)
																								

		System.out.println("Total Links: " + links.size());

		SoftAssert sa = new SoftAssert();

		for (WebElement link : links) { 

			String url = link.getAttribute("href");

			if (url == null || url.isEmpty()) {  // If any <a> tag does not have an href, may return null
				System.out.println("URL is empty for link: " + link.getText());
				continue;
			}

			HttpURLConnection connection = (HttpURLConnection) new URI(url).toURL().openConnection();

			connection.setRequestMethod("HEAD");
			
			connection.setConnectTimeout(5000); //time to establish connection
			
			connection.setReadTimeout(5000); // time to wait for server response

			connection.connect();

			int responseCode = connection.getResponseCode();

			System.out.println(link.getText() + " : " + responseCode);

			sa.assertFalse(responseCode >= 400,
					"The link with text \"" + link.getText() + "\" is broken with code " + responseCode);
			
			connection.disconnect();

		}

		System.out.println("Test Completed");

		sa.assertAll();

	}

}
