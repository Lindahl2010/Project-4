
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
/**
 * 
 */

/**
 * @author linelij
 *
 */
public class Streams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Using Java Streams API: ");
		
		//	String array to run stream operations on.
		List<String> myList = Arrays.asList("Hello", "world", "", "what a day", "to be", "", "alive.");
		
		//	Use of stream operations to take string starting with "w" and capitalizing them.
		myList
			.stream()
			.filter(s -> s.startsWith("w"))
			.map(String::toUpperCase)
			.sorted()
			.forEach(System.out::println);
		
		//	Stream operation that checks for first item in data source and if it exists, prints it to the console.
		myList
			.stream()
			.findFirst()
			.ifPresent(System.out::println);
		
		//	Prints each number from 1 up to, not including, 5.
		IntStream.range(1,5)
			.forEach(System.out::print);
		
		System.out.println("\n");
		
		myList
			.stream()
			.map(s -> {
				System.out.println("Map: " + s);;
				return s.toUpperCase();
			})
			.filter(s -> {
				System.out.println("Filter: " + s);;
				return s.startsWith("w");
			})
			.forEach(s -> System.out.println("forEach: " + s));
			
		System.out.println("\nSame functionality, different order: ");
		
		myList
			.stream()
			.filter(s -> {
				System.out.println("Filter: " + s);
				return s.startsWith("w");
			})
			.map(s -> {
				System.out.println("Map: " + s);
				return s.toUpperCase();
			})
			.forEach(s -> System.out.println("forEach: " + s));
		
	}

}
