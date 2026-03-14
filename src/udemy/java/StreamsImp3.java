package udemy.java;

import java.util.stream.Stream;

import org.testng.annotations.Test;

public class StreamsImp3 {

	@Test
	public void streamFilter() {
		System.out.println("-------------streamFilter--------------");
		Stream.of("Aarav", "Ananya", "Sneha", "Vikram", "Priya", "Karan", "Aditi", "Meera", "Rohan", "Aarohi", "Aasish",
				"Avni").filter(name -> name.length() > 5).forEach(name -> System.out.println(name));
		System.out.println("---------------------------");
		Stream.of("Aarav", "Ananya", "Sneha", "Vikram", "Priya", "Karan", "Aditi", "Meera", "Rohan", "Aarohi", "Isha",
				"Avni").filter(name -> name.length() > 5).limit(2).forEach(name -> System.out.println(name));
	}

	@Test
	public void streamMap() {
		/*
		 * map() transforms each element in a stream into something else.
		 * map() method is an intermediate operation used to transform each element of a stream by applying a function to it, 
		 * resulting in a new stream of the transformed elements.
		 */

		System.out.println("--------------streamMap-------------");
		Stream.of("Aarush", "Anika", "Vivek", "Ayaan", "Ritika", "Akanksha", "Dev", "Avni", "Siddharth", "Isha")
				.filter(name -> name.endsWith("a")).map(name-> name.toUpperCase()).forEach(name -> System.out.println(name));
		System.out.println("---------------------------");
		Stream.of("Aarush", "Anika", "Vivek", "Ayaan", "Ritika", "Akanksha", "Dev", "Avni", "Siddharth", "Isha")
		.filter(name -> name.endsWith("a")).sorted().map(name-> name.toUpperCase()).forEach(name -> System.out.println(name));

	}

}
