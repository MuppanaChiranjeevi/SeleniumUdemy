package udemy.selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Program20 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); // Global implicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		String[] requiredItems = { "Brocolli", "Cucumber", "Carrot", "Mushroom" };
		addItemsToCart(driver,requiredItems);
		
		driver.findElement(By.cssSelector(".cart-icon")).click();
		driver.findElement(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']")).click();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		System.out.println("Test Passed");


		//driver.quit();

	}

	private static void addItemsToCart(WebDriver driver, String[] requiredItems) {
		// TODO Auto-generated method stub
		List<WebElement> productNames = driver.findElements(By.cssSelector("h4.product-name"));
		List<WebElement> addToCartButtons = driver.findElements(By.xpath("//div[@class='product-action']/button"));


		List<String> requiredItemList = Arrays.asList(requiredItems);

		String currentProduct = null;
		int itemsAddedCount = 0;
		for (int i = 0; i < productNames.size(); i++) {
			currentProduct = productNames.get(i).getText().split("-")[0].trim();
			if (requiredItemList.contains(currentProduct)) {
				addToCartButtons.get(i).click();

				itemsAddedCount++;
				if (itemsAddedCount == requiredItems.length) {
					System.out.println("Test Passed - All required items added.");
					break;
				}
			}
		}
		System.out.println("Number of items added to cart: " + itemsAddedCount);
	}

}
