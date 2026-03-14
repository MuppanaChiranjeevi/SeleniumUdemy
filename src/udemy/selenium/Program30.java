package udemy.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Program30 {
	/*
	 * WebDriver does NOT directly have getScreenshotAs().
	 * So we type cast the driver to TakesScreenshot.
	 */

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		// It captures the screenshot and stores it as a temporary file.
		File screenshotSource = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		// Copies the temporary screenshot file and Saves it to your Desktop folder
		FileUtils.copyFile(screenshotSource, new File("C:\\Users\\v-muppanac\\Desktop\\SleniumScreenshots\\screenshot.png"));
		
		//Copies the temporary screenshot inside your project directory and Inside a folder called Screenshots
		FileUtils.copyFile(screenshotSource, new File("Screenshots\\screenshot.png"));


	}

}
