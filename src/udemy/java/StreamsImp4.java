package udemy.java;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamsImp4 {
	
	@Test
	public void streamConcat() {
		List<String> names2 = Stream.of(
		        "Aryan", "Aishwarya", "Rahul", "Nisha", "Aditya",
		        "Amrita", "Sameer", "Isha", "Ankit", "Aman"
		).collect(Collectors.toList()); //Mutable (ArrayList) --> You can add, remove, or modify elements later:
		
		List<String> names4 = Stream.of(
		        "Anirudh", "Aarohi", "Pranav", "Aastha", "Tejas",
		        "Mira", "Dhruv", "Anvitha", "Kshitij", "Anvesh"
		).toList(); //Immutable / unmodifiable
		
		Stream<String>  newStream = Stream.concat(names2.stream(), names4.stream());
		
		//newStream.forEach(x -> System.out.println(x));
		
		newStream.sorted().forEach(System.out::println); // x -> System.out.println(x) equivalent to  System.out::println
		
//		boolean flag = newStream.anyMatch(x -> x.equalsIgnoreCase("Tejas"));
//		System.out.println(flag);
//		Assert.assertTrue(flag);
		
		/*
		 * A Stream can be consumed only once.
		 * Once you perform a terminal operation (like collect(), forEach(), count(), reduce(), etc.), the stream is consumed and closed.
		 * Trying to reuse the same stream again will throw: IllegalStateException
		 */
	}

}
