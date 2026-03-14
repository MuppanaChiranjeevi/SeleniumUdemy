package udemy.selenium;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Program8 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement passengers = driver.findElement(By.id("divpaxinfo"));
		passengers.click();
		Thread.sleep(2000);
		System.out.println(passengers.getText());

	    for (int i = 1; i < 5; i++) {
			
		driver.findElement(By.id("hrefIncAdt")).click();
		
	    }
	    driver.findElement(By.id("btnclosepaxoption")).click();
	    System.out.println(passengers.getText());
		
	    driver.quit();

	}

}
