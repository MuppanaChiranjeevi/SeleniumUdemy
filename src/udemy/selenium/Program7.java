package udemy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Program7 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement staticDropdown =  driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select select = new Select(staticDropdown);
		
		select.selectByIndex(2);
		System.out.println(select.getFirstSelectedOption().getText());
		
		select.selectByVisibleText("USD");
		System.out.println(select.getFirstSelectedOption().getText());
		
		select.selectByValue("INR");
		System.out.println(select.getFirstSelectedOption().getText());
	}
	

}
