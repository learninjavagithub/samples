package com;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MergeArrays {

	public static void main(String[] args) {
		
		String[] a = new String[] {"one", "two", "three"};
		String[] b = new String[] {"four", "five"};
		
		String[] c = mergeUsingStreams(a, b);
		//Stream.of(c).forEach(System.out::println);
		//	or
		Arrays.stream(c).forEach(System.out::println);
		
		Arrays.stream(c).reduce((x, y) -> x+ "-"+y).ifPresent(System.out::println);
		
		int[] numbers = {2, 4, 5, 7, 1, 8};
		
		int initialValue = 3;
		System.out.println(Arrays.stream(numbers).reduce(initialValue, Integer::sum));
		
		System.out.println(IntStream.range(1, 6).reduce(0, Integer::sum));
		
		System.out.println(Stream.of(c).collect(Collectors.joining(",")));
		
		System.out.println(Stream.of(c).collect(Collectors.joining("-", "[","]")));

	}
	public static String[] mergeUsingStreams(String[] a, String[] b) {
		
		return Stream.of(a, b)
			  .flatMap(Stream::of) // or Arrays::stream
			  .toArray(String[]::new);
	}
}
