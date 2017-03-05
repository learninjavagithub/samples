package com.learninjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author learninjava.com
 * @see www.learninjava.com
 */
public class StreamExample1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		list.add("Red Bird");
		list.add("Yellow Bird");
		list.add("Blue Bird");
		
		list.stream()
			.map(String::toUpperCase)
			.sorted()
			.forEach(System.out::println);
		
		System.out.println("\n");
		
		Arrays.asList("Red Bird", "Yellow Bird", "Blue Bird")
			  .stream()
			  .forEach(System.out::println);
		
		System.out.println("\n");

		Arrays.stream(new String[]{"Red Bird", "Yellow Bird", "Blue Bird"})
			  .sorted()
			  .forEach(System.out::println);
		
		System.out.println("\n");

		Stream.of("Red Bird", "Yellow Bird", "Blue Bird")
			  .filter(s -> s.contains("l"))
			  .forEach(System.out::println);
			  
		System.out.println("\n");
		
		System.out.println( IntStream.of(3, 2, 1).count() );		
		
		System.out.println( LongStream.of(3000000, 2000000, 1000000).sum() );

		System.out.println( DoubleStream.of(3.2, 2.9, 1.7).average() );
		
	}
}
