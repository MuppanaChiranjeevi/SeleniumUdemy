package udemy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Program15 {

	public static void main(String[] args) throws InterruptedException {
		// use CTRL+shift+F for code formatting

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();

		String beforeVal = driver.findElement(By.id("Div1")).getDomAttribute("style");
		Assert.assertFalse(beforeVal.contains("1"));

		WebElement checkbox = driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")); // CSS -->
																											// input[id*='IndArm']
		checkbox.click();
		Assert.assertTrue(checkbox.isSelected());

		WebElement passengers = driver.findElement(By.id("divpaxinfo"));
		passengers.click();
		Thread.sleep(2000);
		for (int i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(passengers.getText());

		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select select = new Select(staticDropdown);
		select.selectByVisibleText("INR");

		driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
		System.out.println("Test Passed");
		driver.quit();

	}

}
