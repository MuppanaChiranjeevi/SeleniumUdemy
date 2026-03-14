package udemy.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class StreamsImp5 {

	@Test
	public void streamCollect() {
		List<String> names = Stream.of(
		        "Aarini", "Anvay", "Snehal", "Vanya", "Priyank",
		        "Kavish", "Adhira", "Manav", "Ritika", "Aayush"
		).filter(f->f.contains("y")).collect(Collectors.toList());
		
		System.out.println(names.get(2));
		/*
		 * .collect() is a terminal operation that triggers the processing of the Stream and gathers its elements into a container
		 * Collectors.toList() is a collector that accumulates processed stream elements into a new List.
		 * The result is usually a mutable ArrayList.
		 */
	}
	
	@Test
	public void streamExercise() {
		List<Integer> nums = Arrays.asList(8,2,4,2,7,6,4,6,5,6,9,1,6,5,3); //fixed size
		List<Integer> results = nums.stream().distinct().filter(f->f>5).map(m->m*10).sorted().limit(3).collect(Collectors.toList());
		
		results.forEach(System.out::println);
	}
}
