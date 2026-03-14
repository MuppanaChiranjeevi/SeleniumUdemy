package udemy.selenium;

import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Program44 {
	
	
	public static void main(String[] args) {
		
		String path = System.getProperty("user.dir")+"//reports//ExtentReport.html";
		// Create reporter object
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(path);
		sparkReporter.config().setDocumentTitle("Test Results");
		sparkReporter.config().setReportName("Web Automation Results");
		
		// Create ExtentReports object
        ExtentReports extent = new ExtentReports();
        extent.setSystemInfo("Tester", "Chiranjeevi");
        extent.setSystemInfo("Project", "Selenium Automation");
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.attachReporter(sparkReporter);
        
        
        // Create test
        ExtentTest test = extent.createTest("Google Test");     
        ChromeDriver driver = new ChromeDriver();
        test.info("Browser launched");
        driver.get("https://www.google.com");
        test.pass("Navigated to Google successfully");

        String title = driver.getTitle();

        if(title.contains("Google")) {
            test.pass("Title verified");
        	System.out.println("Test Passed");
        } else {
            test.fail("Title verification failed");
            System.out.println("Test failed");
        }
        driver.quit();

        // Write results to report
        extent.flush();
        
	}

}
