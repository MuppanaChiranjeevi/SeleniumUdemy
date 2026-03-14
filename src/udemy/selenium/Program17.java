package udemy.selenium;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program17 {
	/*
	 * int[] arr; arr = new int[5]; // size = 5
	 * 
	 * int[] arr = new int[5];
	 * 
	 * int[] arr = {10, 20, 30, 40};
	 * 
	 * int[] arr = new int[]{10, 20, 30, 40};
	 * 
	 * int[] arr; arr = new int[]{10, 20, 30};
	 */

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		List<WebElement> productNames = driver.findElements(By.cssSelector("h4.product-name"));
		List<WebElement> addToCartButtons = driver.findElements(By.xpath("//div[@class='product-action']/button"));

		String[] requiredItems = { "Brocolli", "Cucumber", "Carrot", "Mushroom" };
		List<String> requiredItemList = Arrays.asList(requiredItems);

		String currentProduct = null;
		int itemsAddedCount = 0;
		for (int i = 0; i < productNames.size(); i++) {
			currentProduct = productNames.get(i).getText().split("-")[0].trim();
			if (requiredItemList.contains(currentProduct)) {
				addToCartButtons.get(i).click();
				// productNames.get(i).findElement(By.xpath("following-sibling::div/button")).click();

				itemsAddedCount++;
				if (itemsAddedCount == requiredItems.length) {
					System.out.println("Test Passed - All required items added.");
					break;
				}
			}
		}
		driver.findElement(By.cssSelector(".cart-icon")).click();
		System.out.println("Number of items added to cart: " + itemsAddedCount);

		Thread.sleep(5000);
		driver.quit();

	}

}
