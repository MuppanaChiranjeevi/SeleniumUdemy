package udemy.java;

import java.util.ArrayList;

import java.util.List;

import org.testng.annotations.Test;

public class StreamsImp2 {

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
	 * Intermediate operations take a Stream, transform, and produce another Stream. 
	 * They do not execute immediately. 
			filter()
			map()
			sorted()
			distinct()
			limit()
			skip()
	 * Nothing actually happens when you call an intermediate operation and only executed when a terminal operation is called.
	 * Terminal Operation triggers execution and produces a result.
			forEach()
			collect()
			reduce()
			count()
			anyMatch()
			allMatch()
	 * Without a terminal operation, nothing runs.
	 *
	 *
	 *
	 */
	@Test
	public void withoutStream() {
		
		List<String> namesList = new ArrayList<String>();
		namesList.add("Anand");
		namesList.add("Bhargav");
		namesList.add("Aravind");
		namesList.add("Abhishek");
		namesList.add("Smriti");
		namesList.add("Virat");
		namesList.add("Arjun");
		namesList.add("Rohit");
		namesList.add("Aparna");
			
		List<String> results = new ArrayList<>();
		
		for(String name:namesList) {
			
			if (name.startsWith("A")) {
		        results.add(name);
		    }
		}
		
		for(String result:results) {
			
			System.out.println(result);
		}
		
		
	}
	
	@Test
	public void withStream() {
		// // Immutable list (Java 9+) --> Cannot add/remove elements
	    List<String> namesList = List.of( "Anand","Bhargav","Aravind","Abhishek","Smriti","Virat","Arjun","Rohit","Aparna");

	    // filter() processes each element in a stream and keeps only those that satisfy a specified condition (a predicate).
	    List<String> results = namesList.stream().filter(name -> name.startsWith("A")).toList();
	    results.forEach(result -> System.out.println(result));
	    
	    
//	    List<String> results1 = namesList.stream().filter(name -> 
//	    {
//	    	name.startsWith("A");
//	    	return false;
//	    }).toList();
//	    results1.forEach(System.out::println);
	    
	    System.out.println("------------------withStream-------------------");

	}
	/*
	 * .stream() creates a Stream from the list.
	 * .filter(name -> name.startsWith("A")) filters the names that start with "A".
	 * .map(String::toUpperCase) converts the filtered names to uppercase.
	 */

}



