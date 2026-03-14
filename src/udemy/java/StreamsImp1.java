package udemy.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class StreamsImp1 {

	/*
	 * Streams in Java are a feature introduced in Java 8 
	 * Streams allow you to process collections of data in a functional and declarative way.
	 * 
	 * A Stream is a sequence of elements that supports operations like:
			Filtering
			Mapping
			Sorting
			Reducing
			Collecting
		
	 * Stream does not store data.
	 * Stream processes data from a source (like a List, Set, or array).
	 * Stream does not modify the original collection.
	 * 
	 * Streams Work (3-Step Process)
	 * Source → Intermediate Operations → Terminal Operation
	 * 
	 * Intermediate Operations (Lazy)
	 * Always return a new Stream
	 * Intermediate operations take a Stream, transform it, and produce another Stream. 
	 * They do not execute immediately. 
			filter()
			map()
			sorted()
			distinct()
			limit()
			skip()
	 * Nothing actually happens when you call an intermediate operation and only executed when a terminal operation is called.
	 * 
	 * Terminal Operation triggers execution and produces a result.
			count()
			forEach()
			collect()
			reduce()
			anyMatch()
			allMatch()
	 * Without a terminal operation, nothing runs.
	 *
	 *
	 *
	 */
	@Test
	public void withoutStream() {
		
		String[] names = {"Anand","Bhargav","Aravind","Abhishek","Smriti","Virat","Arjun","Rohit","Aparna"};
		
		List<String> namesList = Arrays.asList(names);
		
		int count =0;
		for(String name:namesList) {
			
			if(name.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);
		

	}
	
	@Test
	public void withStream() {
		// Use ArrayList instead of array
	    List<String> namesList = new ArrayList<>(Arrays.asList("Anand","Bhargav","Aravind","Abhishek","Smriti","Virat","Arjun","Rohit","Aparna"));

	    // Use stream to filter names starting with "A" and count them
	    long count = namesList.stream().filter(name -> name.startsWith("A")).count();

	    System.out.println(count);
	}
	/*
	 * namesList.stream() creates a Stream from the list.
	 * .filter(name -> name.startsWith("A")) filters the names that start with "A".
	 * .count() is a terminal operation that counts the number of elements in the Stream.
	 * The result is a long representing how many names start with "A".
	 */

}
