package udemy.java;

import org.testng.annotations.Test;

public class Child extends Parent{
	
	@Test
	public void childMethod() {
		parentMethod();
		System.out.println("I am from child");
	}


}
