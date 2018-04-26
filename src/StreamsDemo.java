/**
*
*/

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.*;

/**
* @author perbraa
*
*/
public class StreamsDemo {

               /**
               * @param args
               */
               public static void main(String[] args) {

            	   // TODO Auto-generated method stub
                   System.out.println("Create array from an array");

                   partOfArray();
                   System.out.println("\nFor each: ");

                   foreach();
                   System.out.println("\nSorted numbers: ");
                              
                   sorted();
                   System.out.println("\nUsing Map: ");

                   map();
                   System.out.println("\nMaps continued: ");

                   mapEx();
                   System.out.println("\nUsing Filter: ");

                   filter();
                   
                   order();
                   System.out.println("Importance of Order: ");
                   
               }//end of main

               public static Stream<String> partOfArray() {
            	   
            	   String[] arr = new String[]{"Cat","Dog","Bird","Gorilla","Lion","Tiger","Cheetah","Gazel","Deer","Mouse","Squirrel","Rabbit"};
                   Stream<String> streamOfArrayPart = Arrays.stream(arr,5,9);//prints 8, stops at 9
                   streamOfArrayPart.forEach(x -> System.out.println(x));

                   return streamOfArrayPart;

               }//end

               public static void foreach() {

                   Random random = new Random();
                   int n = random.nextInt(50);
                   random.ints().limit(10).forEach(System.out::println);//example of foreach and .limit implementation

               }//end

               public static List<Integer> sorted() {

                   List<Integer> numbers = Arrays.asList(1,12,24,23,10,11,4,5,6);
                   numbers.stream().sorted().forEach(System.out::println);//example of foreach and .limit implementation
                              
                   return numbers;

               }//end
              
               public static List<Integer> map() {

                   List<Integer> numbers = Arrays.asList(2,4,4,6,7);//does not print duplicates
                   List<Integer> squareList = numbers.stream().map(i -> i*i).distinct().collect(Collectors.toList());
                   squareList.forEach(x -> System.out.println(x));

                   return squareList;

               }//end

               public static List<Integer> mapEx(){

            	   List<Integer> numbers = Arrays.asList(2,4,4,6,7);//does not print duplicates
                   List<Integer> timesTwelve= numbers.stream().map(i -> i*12/2).distinct().collect(Collectors.toList());//map hold the math functionality
                   timesTwelve.forEach(x -> System.out.println(x));

                   return timesTwelve;

               }//end

               public static int filter(){

                   List<String>strings = Arrays.asList("Cat","Dog","Bird","Gorilla","Lion","Tiger","Cheetah","Gazel","Deer","Mouse","Squirrel","Rabbit");
                   int count = (int) strings.stream().filter(String -> String.contains("C")).count();//case sensitve
                   System.out.print(count);

                   return count;
               }
               
               public static List<String> order(){
            	   
            	   List<String> myList = Arrays.asList("Hello", "world", "", "what a day", "to be", "", "alive.");
            	   
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
           		   
           		   return myList;

               }
               
}




