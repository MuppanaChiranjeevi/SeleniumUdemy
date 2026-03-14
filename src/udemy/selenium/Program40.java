
package udemy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Program40 {

    /*
     * This example demonstrates Selenium 4 Relative Locators
     * using the SauceDemo login page.
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        // Locate the password field
        WebElement password = driver.findElement(By.id("password"));

        // Find the username field ABOVE the password field
        WebElement username = driver.findElement(with(By.tagName("input")).above(password));
        username.sendKeys("standard_user");

        // Find the login button BELOW the password field
        WebElement loginButton = driver.findElement( with(By.tagName("input")).below(password));
        
        password.sendKeys("secret_sauce");
        loginButton.click();

        // After login - find "Add to cart" button to the RIGHT of product name
        WebElement productName = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));

        WebElement addToCartButton = driver.findElement(with(By.tagName("button")).toRightOf(productName));
        addToCartButton.click();
        
        Thread.sleep(1000);

        //Find cart icon NEAR the shopping cart badge
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));

        WebElement cartIcon = driver.findElement(with(By.tagName("a")).near(cartBadge));
        cartIcon.click();
        
        System.out.println("Test Over");

        // driver.quit();
    }
}