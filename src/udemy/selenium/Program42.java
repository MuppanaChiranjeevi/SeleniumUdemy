package udemy.selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program42 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1️⃣ Open Parent Window (a simple form page)
        driver.get("https://www.w3schools.com/html/html_forms.asp");

        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent ID: " + parentWindow);

        // 2️⃣ Open Child Window (book store demo)
        driver.switchTo().newWindow(WindowType.WINDOW);
        Set<String> allWindows = driver.getWindowHandles();
        String childWindow = "";
        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                childWindow = window;
            }
        }

        System.out.println("Child ID: " + childWindow);
        
        driver.switchTo().window(childWindow);
        driver.get("https://books.toscrape.com/");

        // 3️⃣ Scrape the title and price of the first book
        String bookTitle = driver.findElement(By.cssSelector(".product_pod h3 a")).getAttribute("title");
        String bookPrice = driver.findElement(By.cssSelector(".product_pod .price_color")).getText();
        System.out.println("Book Title: " + bookTitle);
        System.out.println("Book Price: " + bookPrice);

        // 4️⃣ Switch back to Parent Window and fill the form
        driver.switchTo().window(parentWindow);

        driver.findElement(By.name("firstname")).sendKeys(bookTitle);
        driver.findElement(By.name("lastname")).sendKeys(bookPrice);

        // 5️⃣ Clean up
        driver.quit();        // Close parent window
    }
}