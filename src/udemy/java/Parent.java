package udemy.java;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Parent {
	
	public void parentMethod() {
		System.out.println("I am from parent");
	}
	
	@BeforeMethod
	public void beforeMethode() {
		System.out.println("I will run first");
	}
	@AfterMethod
	public void afterMethode() {
		System.out.println("I will run last");
	}

}
